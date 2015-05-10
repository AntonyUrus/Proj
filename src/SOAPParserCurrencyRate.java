import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.IOException;

/**
 * Created by Антон on 01.05.2015.
 */
public class SOAPParserCurrencyRate {
    public void parseSOAP(CurrencyRate currency, SOAPMessage response) throws SOAPException{

        SOAPBody soapBody = response.getSOAPBody();
        java.util.Iterator iterator = soapBody.getChildElements();
        SOAPBodyElement bodyElement = (SOAPBodyElement)iterator.next();
        SOAPBodyElement elem1 = (SOAPBodyElement) bodyElement.getChildElements().next();
        SOAPBodyElement elem2 = (SOAPBodyElement) elem1.getChildElements().next();
        NodeList list2 = elem2.getChildNodes();
        for (int i = 0; i < list2.getLength(); i++){
            Node node = (javax.xml.soap.Node)list2.item(i);
            if (node.getLocalName().equals("ExchangeRate")){currency.setExchangeRate(node.getValue());}
            if (node.getLocalName().equals("Code")){currency.setCode(node.getValue());}
        }
    }
}
