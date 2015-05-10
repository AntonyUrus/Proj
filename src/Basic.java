import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Iterator;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;


/**
 * Created by Антон on 18.04.2015.
 */
public class Basic {
    public static void main(String[] args) throws SOAPException, IOException {

        //----------Create a connection to Merlion'ы server----------
        String login = new String("TCDN1284|DENIS");
        String password = new String("111222");
        String authorization = new sun.misc.BASE64Encoder().encode((login + ":" + password).getBytes());
        //MimeHeaders hd = msg.getMimeHeaders();
        //msg.getMimeHeaders().addHeader("Authorization", "Basic " + authorization);
        SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = soapConnFactory.createConnection();
        String destination = "https://api.merlion.ru/mlservice.php";
        //-----------------------------------------------------------

        //---------Create a connection with a server----------------
        int serverPort = 50000;
        String address = "192.168.43.19";

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("Connected");

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            SOAPMessage msg = new CurrencyRateRequest("08.05.2015").createCurrencyDateSOAP();   // added msg
            //SOAPMessage msg = new CatalogRequest("Order").createCatalogRequestSOAP();           //
            //SOAPMessage msg =  new Items("B1", "816273", "0", "1", "10").createItemsSOAP();     //

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();    //
            msg.writeTo(byteOut);                                           // записываем созданное сообщение в String
            String strMsg = new String(byteOut.toByteArray());              //

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // делаем отсылку сообщений контролируемой с клавиатуры

            InputStream Input;
            SOAPMessage message;

            String line;
        //------------------------------------------------------------
            while (true) {
                line = keyboard.readLine();                                 // ждем пока пользователь введет что-то и нажмет кнопку Enter.
                //out.writeUTF(strMsg);                                       // отсылаем введенную строку текста серверу.
                out.flush();                                                // заставляем поток закончить передачу данных.
                System.out.println("Sent:" + strMsg + "\n");
                line = in.readUTF();                                        // ждем пока сервер отошлет строку текста.
                Input = new ByteArrayInputStream(line.getBytes());                                                              // convert String to SOAPMessage
                message = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage(new MimeHeaders(), Input);  //
/*
                ParseProcedure procedure = new ParseProcedure();            // detecting type of procedure used by client
                procedure.parseSOAP(message);                               //

                message.getMimeHeaders().addHeader("Authorization", "Basic " + authorization);
                SOAPMessage response = connection.call(message, destination);

                if (procedure.getProcedure().equals("getCatalog")) {
                    CatalogRequest catalogRequest = new CatalogRequest();
                    catalogRequest.parseSOAP(message);
                    System.out.println(catalogRequest.getCat_id());
                }
                else if (procedure.getProcedure().equals("getCurrencyRate")){
                    CurrencyRateRequest currencyRateRequest = new CurrencyRateRequest();
                    currencyRateRequest.parseSOAP(message);
                    System.out.println(currencyRateRequest.getDate());
                }
                else if (procedure.getProcedure().equals("getItems")){
                    Items[] items = new ItemsParser().parseSOAPresponse(response);
                    Items sendItem = new ItemsParser().parseSOAPrequest(message);
                    //items.parseSOAPrequest(message);
                    //System.out.println(items.getCat_id() + items.getItem_id()+ items.getShipment_method()+ items.getPage() + items.getRows_on_page());
                    for (int i = 0; i < items.length; i++){System.out.println(items.toString());}
                    System.out.println(sendItem.getCat_id() + sendItem.getItem_id()+ sendItem.getShipment_method()+ sendItem.getPage() + sendItem.getRows_on_page());
                }
                //else if (procedure.getProcedure().equals("getItemsAvail")){this.setProcedure(node.getLocalName());}
                //else if (procedure.getProcedure().equals("getOrdersList")){this.setProcedure(node.getLocalName());}*/
            }
        } catch (Exception x) {
            x.printStackTrace();
        }


        //SOAPMessage msg = new CatalogRequest("Order").createCatalogRequestSOAP();

/*
        //----------Create a connection to Merlion'ы server----------
        String login = new String("TCDN1284|DENIS");
        String password = new String("111222");
        String authorization = new sun.misc.BASE64Encoder().encode((login + ":" + password).getBytes());
        //MimeHeaders hd = msg.getMimeHeaders();
        msg.getMimeHeaders().addHeader("Authorization", "Basic " + authorization);
        SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = soapConnFactory.createConnection();
        String destination = "https://api.merlion.ru/mlservice.php";
        //-----------------------------------------------------------
*/


        //SOAPMessage response = connection.call(msg, destination);

        //Catalog[] catalogs = new CatalogParser().parseSOAP(response);
        //for (int i = 0; i < catalogs.length; i++){System.out.println(catalogs[i].getID() + "\t" + catalogs[i].getID_PARENT() + "\t" + catalogs[i].getDescription());}



        //connection.close();//   the last string anyway
    }
}
