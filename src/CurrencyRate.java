/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication1;

import org.w3c.dom.NodeList;

import javax.xml.soap.*;

/**
 *
 * @author Nikita
 */
public class CurrencyRate {
    private String Code, ExchangeRate, date;
    
    public CurrencyRate(){}
    public CurrencyRate(String date){this.date = date;}
    
    public void setCode(String Code){this.Code = Code;}
    public void setExchangeRate(String ExchangeRate){this.ExchangeRate = ExchangeRate;}
    public void setDate(String date){this.date = date;}
    
    public String getCode(){return Code;}
    public String getExchangeRate(){return ExchangeRate;}
    public String getDate() {return date;}

    public void parseSOAP(SOAPMessage response) throws SOAPException {

        SOAPBody soapBody = response.getSOAPBody();
        java.util.Iterator iterator = soapBody.getChildElements();
        NodeList nodeList = (NodeList)iterator.next();
        NodeList nodeList1 = (NodeList)nodeList.item(1);
        NodeList nodeList2 = (NodeList)nodeList1.item(0);
        for (int i = 0; i < nodeList2.getLength(); i++){
            Node node = (javax.xml.soap.Node)nodeList2.item(i);
            if (node.getLocalName().equals("ExchangeRate")){this.setExchangeRate(node.getValue());}
            else if (node.getLocalName().equals("Code")){this.setCode(node.getValue());}
            else if (node.getLocalName().equals("date")){this.setDate(node.getValue());}
        }
    }
}
