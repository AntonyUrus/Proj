import org.w3c.dom.NodeList;

import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.util.Iterator;

/**
 * Created by Антон on 09.05.2015.
 */
public class ItemsParser {

    public Items[] parseSOAPresponse(SOAPMessage response) throws SOAPException {

        SOAPBody soapBody = response.getSOAPBody();
        Iterator iterator = soapBody.getChildElements();
        NodeList nodeList = (NodeList) iterator.next();
        NodeList nodeList1 = (NodeList) nodeList.item(1);
        int numberOfObjects = nodeList1.getLength();
        
        Items[] items = new Items[numberOfObjects];
        for (int i = 0; i < numberOfObjects; i++) items[i] = new Items();
        
        for (int i = 0; i < numberOfObjects; i++){
            NodeList nodeList2 = (NodeList)nodeList1.item(i);
            int nodeList2Length = nodeList2.getLength();
            for (int j = 0; j < nodeList2Length; j++){
                Node node = (javax.xml.soap.Node) nodeList2.item(j);
                String localName = node.getLocalName();
                
                if (localName.equals("No")) {items[i].setNo(node.getValue());}
                else if (localName.equals("Name")){items[i].setName(node.getValue());}
                else if (localName.equals("Brand")){items[i].setBrand(node.getValue());}
                else if (localName.equals("GroupItem")){items[i].setGroupItem(node.getValue());}
                else if (localName.equals("Vendor_part")){items[i].setVendor_part(node.getValue());}
                else if (localName.equals("Size")){items[i].setSize(node.getValue());}
                else if (localName.equals("EOL")){items[i].setEOL(node.getValue());}
                else if (localName.equals("Warranty")){items[i].setWarranty(node.getValue());}
                else if (localName.equals("Weight")){items[i].setWeight(node.getValue());}
                else if (localName.equals("Volume")){items[i].setVolume(node.getValue());}
                else if (localName.equals("Min_Packaged")){items[i].setMin_Packaged(node.getValue());}
                else if (localName.equals("GroupName1")){items[i].setGroupName1(node.getValue());}
                else if (localName.equals("GroupName2")){items[i].setGroupName2(node.getValue());}
            }
        }
        return items;
    }

    public Items parseSOAPrequest(SOAPMessage message) throws SOAPException {

        Items items = new Items();
        SOAPBody soapBody = message.getSOAPBody();
        Iterator iterator = soapBody.getChildElements();
        NodeList nodeList = (NodeList) iterator.next();
        int nodeListLength = nodeList.getLength();

        for (int i = 0; i < nodeListLength; i++){
            Node node = (Node) nodeList.item(i);
            if (node.getLocalName().equals("cat_id")) {items.setCat_id(node.getValue());}
            else if (node.getLocalName().equals("item_id")) {items.setItem_id(node.getValue());}
            else if (node.getLocalName().equals("shipment_method")) {items.setShipment_method(node.getValue());}
            else if (node.getLocalName().equals("page")) {items.setPage(node.getValue());}
            else if (node.getLocalName().equals("rows_on_page")) {items.setRows_on_page(node.getValue());}
        }
        return items;
    }
}
