//package javaapplication1;


import java.util.Iterator;
import javax.xml.soap.*;
import org.w3c.dom.NodeList;

public class Items {

    private String cat_id, item_id, shipment_method, page, rows_on_page;

    private String No, Name, Brand, GroupItem, Vendor_part, Size, EOL, Warranty, Weight, Volume, Min_Packaged, GroupName1,GroupName2;

    public Items(){}

    //public Items(String cat_id){this.cat_id = cat_id;}

    public Items(String cat_id, String item_id, String shipment_method, String page, String rows_on_page){
        this.cat_id = cat_id;
        this.item_id = item_id;
        this.shipment_method = shipment_method;
        this.page = page;
        this.rows_on_page = rows_on_page;
    }

    public void setCat_id(String cat_id) {this.cat_id = cat_id;}
    public void setItem_id(String item_id) {this.item_id = item_id;}
    public void setShipment_method(String shipment_method) {this.shipment_method = shipment_method;}
    public void setPage(String page) {this.page = page;}
    public void setRows_on_page(String rows_on_page) {this.rows_on_page = rows_on_page;}

    public void setNo(String No){this.No = No;}
    public void setName(String Name){this.Name = Name;}
    public void setBrand(String Brand){this.Brand = Brand;}
    public void setGroupItem(String GroupItem){this.GroupItem = GroupItem;}
    public void setVendor_part(String Vendor_part){this.Vendor_part = Vendor_part;}
    public void setSize(String Size){this.Size = Size;}
    public void setEOL(String EOL){this.EOL = EOL;}
    public void setWarranty(String Warranty){this.Warranty = Warranty;}
    public void setWeight(String Weight){this.Weight = Weight;}
    public void setVolume(String Volume){this.Volume = Volume;}
    public void setMin_Packaged(String Min_Packaged){this.Min_Packaged = Min_Packaged;}
    public void setGroupName1(String GroupName1){this.GroupName1 = GroupName1;}
    public void setGroupName2(String GroupName2){this.GroupName2 = GroupName2;}


    public String getCat_id() {return cat_id;}
    public String getItem_id() {return item_id;}
    public String getShipment_method() {return shipment_method;}
    public String getPage() {return page;}
    public String getRows_on_page() {return rows_on_page;}

    public String getNo(){return No;}
    public String getName(){return Name;}
    public String getBrand(){return Brand;}
    public String getGroupItem(){return GroupItem;}
    public String getVendor_part(){return Vendor_part;}
    public String getSize(){return Size;}
    public String getEOL(){return EOL;}
    public String getWarranty(){return Warranty;}
    public String getWeight(){return Weight;}
    public String getVolume(){return Volume;}
    public String getMin_Packaged(){return Min_Packaged;}
    public String getGroupName1(){return GroupName1;}
    public String getGroupName2(){return GroupName2;}


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.No);
        builder.append(" ");
        builder.append(this.Name);
        builder.append(" ");
        builder.append(this.Brand);
        builder.append(" ");
        builder.append(this.GroupItem);
        builder.append(" ");
        builder.append(this.Vendor_part);
        builder.append(" ");
        builder.append(this.Size);
        builder.append(" ");
        builder.append(this.EOL);
        builder.append(" ");
        builder.append(this.Warranty);
        builder.append(" ");
        builder.append(this.Weight);
        builder.append(" ");
        builder.append(this.Volume);
        builder.append(" ");
        builder.append(this.Min_Packaged);
        builder.append(" ");
        builder.append(this.GroupName1);
        builder.append(" ");
        builder.append(this.GroupName2);
        builder.append("\n");
        return builder.toString();
    }
    
    public SOAPMessage createItemsSOAP() throws SOAPException {
        SOAPMessage ItemsSOAP = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();

        SOAPPart part = ItemsSOAP.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();
        envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
        envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema");
        envelope.addNamespaceDeclaration("mls", "https://api-iz.merlion.ru/re/mlservice2");
        envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");

        SOAPHeader header = ItemsSOAP.getSOAPHeader();

        Name getCatalog = envelope.createName("getItems", "mls", "https://api-iz.merlion.ru/re/mlservice2");
        SOAPBody soapBody = ItemsSOAP.getSOAPBody();

        SOAPBodyElement soapBodyElement = soapBody.addBodyElement(getCatalog);
        soapBodyElement.addNamespaceDeclaration("encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");

        SOAPElement Catalog = soapBodyElement.addChildElement("cat_id");
        Catalog.addTextNode(this.cat_id);
        Catalog.setAttribute("xsi:type", "xsd:string");
        Catalog.setAttribute("xs:type", "type:string");
        Catalog.addNamespaceDeclaration("xs", "http://www.w3.org/2000/XMLSchema-instance");

        SOAPElement Item = soapBodyElement.addChildElement("item_id");
        Item.addTextNode(this.item_id);
        Item.setAttribute("xsi:type", "xsd:string");
        Item.setAttribute("xs:type", "type:string");
        Item.addNamespaceDeclaration("xs", "http://www.w3.org/2000/XMLSchema-instance");

        SOAPElement ShipmentMethod = soapBodyElement.addChildElement("shipment_method");
        ShipmentMethod.addTextNode(this.shipment_method);
        ShipmentMethod.setAttribute("xsi:type","xsd:string");
        ShipmentMethod.setAttribute("xs:type", "type:string");
        ShipmentMethod.addNamespaceDeclaration("xs", "http://www.w3.org/2000/XMLSchema-instance");

        SOAPElement Page = soapBodyElement.addChildElement("page");
        Page.addTextNode(this.page);
        Page.setAttribute("xsi:type", "xsd:string");
        Page.setAttribute("xs:type", "type:string");
        Page.addNamespaceDeclaration("xs", "http://www.w3.org/2000/XMLSchema-instance");

        SOAPElement RowsOnPage = soapBodyElement.addChildElement("rows_on_page");
        RowsOnPage.addTextNode(this.rows_on_page);
        RowsOnPage.setAttribute("xsi:type", "xsd:string");
        RowsOnPage.setAttribute("xs:type", "type:string");
        RowsOnPage.addNamespaceDeclaration("xs", "http://www.w3.org/2000/XMLSchema-instance");

        return ItemsSOAP;
    }


    public void parseSOAPrequest(SOAPMessage request) throws SOAPException {

        SOAPBody soapBody = request.getSOAPBody();
        Iterator iterator = soapBody.getChildElements();
        NodeList nodeList = (NodeList) iterator.next();
        int nodeListLength = nodeList.getLength();

        for (int i = 0; i < nodeListLength; i++){
            Node node = (Node) nodeList.item(i);
            if (node.getLocalName().equals("cat_id")) {
                this.setCat_id(node.getValue());}
            else if (node.getLocalName().equals("item_id")) {
                this.setItem_id(node.getValue());}
            else if (node.getLocalName().equals("shipment_method")) {
                this.setShipment_method(node.getValue());}
            else if (node.getLocalName().equals("page")) {
                this.setPage(node.getValue());}
            else if (node.getLocalName().equals("rows_on_page")) {
                this.setRows_on_page(node.getValue());}
        }
    }
}
