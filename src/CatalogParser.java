import org.w3c.dom.NodeList;

import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/**
 * Created by Антон on 02.05.2015.
 */
public class CatalogParser {

    public Catalog[] parseSOAP(SOAPMessage response) throws SOAPException {

        SOAPBody soapBody = response.getSOAPBody();
        java.util.Iterator iterator = soapBody.getChildElements();
        NodeList nodeList = (NodeList)iterator.next();
        NodeList nodeList1 = (NodeList)nodeList.item(1);
        int numberOfObjects = nodeList1.getLength();

        Catalog[] catalogs = new Catalog[numberOfObjects];
        for (int i = 0; i < numberOfObjects; i++) catalogs[i] = new Catalog();

        for (int i = 0; i < numberOfObjects; i++){
            NodeList nodeList2 = (NodeList)nodeList1.item(i);
            int nodeList2Length = nodeList2.getLength();
            for (int j = 0; j < nodeList2Length; j++){
                Node node = (javax.xml.soap.Node)nodeList2.item(j);
                String localName = node.getLocalName();

                if (localName.equals("ID")) {catalogs[i].setID(node.getValue());}
                else if (localName.equals("ID_PARENT")){catalogs[i].setID_PARENT(node.getValue());}
                else if (localName.equals("Description")){catalogs[i].setDescription(node.getValue());}
            }
        }
        return catalogs;
    }
}
