import org.w3c.dom.NodeList;

import javax.xml.soap.*;

/**
 * Created by Антон on 02.05.2015.
 */
public class CatalogRequest {
    private String cat_id;

    public CatalogRequest(){}

    public CatalogRequest(String cat_id){
        this.cat_id = cat_id;
    }

    public String getCat_id(){
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.cat_id);
        return builder.toString();
    }

    public SOAPMessage createCatalogRequestSOAP() throws SOAPException {
        SOAPMessage catalogRequestSOAP = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
        SOAPPart part = catalogRequestSOAP.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();

        envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
        envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        envelope.addNamespaceDeclaration("mls", "https://api-iz.merlion.ru/re/mlservice2");
        envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        SOAPHeader header = catalogRequestSOAP.getSOAPHeader();
        Name catalogRequestName = envelope.createName("getCatalog", "mls", "https://api-iz.merlion.ru/re/mlservice2");
        SOAPBody soapBody = catalogRequestSOAP.getSOAPBody();
        SOAPBodyElement soapBodyElement = soapBody.addBodyElement(catalogRequestName);

        soapBodyElement.addNamespaceDeclaration("encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");
        SOAPElement soapElement = soapBodyElement.addChildElement("cat_id");
        soapElement.addTextNode(this.cat_id);
        soapElement.setAttribute("xsi:type", "xsd:string");
        soapElement.setAttribute("xs:type", "type:string");
        soapElement.addNamespaceDeclaration("xs", "http://www.w3.org/2000/XMLSchema-instance");

        return catalogRequestSOAP;
    }

    public void parseSOAP(SOAPMessage response) throws SOAPException {
        SOAPBody soapBody = response.getSOAPBody();
        java.util.Iterator iterator = soapBody.getChildElements();
        NodeList nodeList = (NodeList)iterator.next();
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = (javax.xml.soap.Node)nodeList.item(i);
            System.out.println(node.getLocalName());
            if (node.getLocalName().equals("cat_id")){this.setCat_id(node.getValue());}
        }
    }
}
