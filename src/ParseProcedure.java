import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/**
 * Created by Антон on 09.05.2015.
 */
public class ParseProcedure {

    private String procedure;

    public String getProcedure() {return procedure;}

    public void setProcedure(String procedure) {this.procedure = procedure;}

    public void parseSOAP(SOAPMessage response) throws SOAPException {
        SOAPBody soapBody = response.getSOAPBody();
        Node node = (javax.xml.soap.Node)soapBody.getFirstChild();

        if (node.getLocalName().equals("getCatalog")){this.setProcedure(node.getLocalName());}
        else if (node.getLocalName().equals("getCurrencyRate")){this.setProcedure(node.getLocalName());}
        else if (node.getLocalName().equals("getItems")){this.setProcedure(node.getLocalName());}
        else if (node.getLocalName().equals("getItemsAvail")){this.setProcedure(node.getLocalName());}
        else if (node.getLocalName().equals("getOrdersList")){this.setProcedure(node.getLocalName());}
    }
}
