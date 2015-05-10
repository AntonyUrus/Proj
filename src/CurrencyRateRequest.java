import org.w3c.dom.NodeList;

import javax.xml.soap.*;

/**
 * Created by Антон on 18.04.2015.
 */
public class CurrencyRateRequest {
    private String date;

    public CurrencyRateRequest(){}

    public CurrencyRateRequest(String date) { this.date = date; }

    public String getDate(){
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.date);
        return builder.toString();
    }

    public SOAPMessage createCurrencyDateSOAP() throws SOAPException {
        SOAPMessage currencyDateSOAP = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
        SOAPPart part = currencyDateSOAP.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();

        envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
        envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema");
        envelope.addNamespaceDeclaration("mls", "https://api-iz.merlion.ru/re/mlservice2");
        envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        SOAPHeader header = currencyDateSOAP.getSOAPHeader();
        Name currencyDateName = envelope.createName("getCurrencyRate", "mls", "https://api-iz.merlion.ru/re/mlservice2");
        SOAPBody soapBody = currencyDateSOAP.getSOAPBody();
        SOAPBodyElement soapBodyElement = soapBody.addBodyElement(currencyDateName);

        soapBodyElement.addNamespaceDeclaration("encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");
        SOAPElement soapElement = soapBodyElement.addChildElement("date");
        soapElement.addTextNode(this.date);
        soapElement.setAttribute("xsi:type", "xsd:string");
        soapElement.setAttribute("xs:type", "type:string");
        soapElement.addNamespaceDeclaration("xs", "http://www.w3.org/2000/XMLSchema-instance");

        return currencyDateSOAP;
    }

    public void parseSOAP(SOAPMessage response) throws SOAPException {
        SOAPBody soapBody = response.getSOAPBody();
        java.util.Iterator iterator = soapBody.getChildElements();
        NodeList nodeList = (NodeList)iterator.next();
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = (javax.xml.soap.Node)nodeList.item(i);
            if (node.getLocalName().equals("date")){this.setDate(node.getValue());}
        }
    }
}
