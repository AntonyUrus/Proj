/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication1;

/**
 *
 * @author Nikita
 */
public class OrdersList {
    private String document_no, TNN , OrderDate , Manager , Contract , ShipmentMethod , ShipmentMethodCode , ShipmentDate , CounterpartyClient , CounterpartyClientCode , ShippingAgent , ShippingAgentCode , EndCustomer , PostingDescription , Weight , Volume , Amount , AmountRUR ;
    
    public OrdersList(){}
    public OrdersList(String document_no){ this.document_no=document_no;}
    public void setdocument_no(String document_no) {this.document_no = document_no;}
    public void setTNN(String TNN) {this.TNN = TNN;}
    public void setOrderDate(String OrderDate) {this.OrderDate = OrderDate;}
    public void setManager(String Manager) {this.Manager = Manager;}
    public void setContract(String Contract) {this.Contract = Contract;}
    public void setShipmentMethod(String ShipmentMethod) {this.ShipmentMethod = ShipmentMethod;}
    public void setShipmentMethodCode(String ShipmentMethodCode) {this.ShipmentMethodCode = ShipmentMethodCode;}
    public void setShipmentDate(String ShipmentDate) {this.ShipmentDate = ShipmentDate;}
    public void setCounterpartyClient(String CounterpartyClient) {this.TNN = CounterpartyClient;}
    public void setCounterpartyClientCode(String CounterpartyClientCode) {this.CounterpartyClientCode = CounterpartyClientCode;}
    public void setShippingAgent(String ShippingAgent) {this.ShippingAgent = ShippingAgent;}
    public void setShippingAgentCode(String ShippingAgentCode) {this.ShippingAgentCode = ShippingAgentCode;}
    public void setEndCustomer(String EndCustomer) {this.EndCustomer = EndCustomer;}
    public void setPostingDescription(String PostingDescription) {this.PostingDescription = PostingDescription;}
    public void setWeight(String Weight) {this.Weight = Weight;}
    public void setVolume(String Volume) {this.Volume = Volume;}
    public void setAmount(String Amount) {this.Amount = Amount;}
    public void setAmountRUR(String AmountRUR) {this.AmountRUR = AmountRUR;}
    
    
    public String getdocument_no() {return document_no;}
    public String getTNN() {return TNN;}
    public String getOrderDate() {return OrderDate;}
    public String getManager() {return Manager;}
    public String getContract() {return Contract;}
    public String getShipmentMethod() {return ShipmentMethod;}
    public String getShipmentMethodCode() {return ShipmentMethodCode;}
    public String getShipmentDate() {return ShipmentDate;}
    public String getCounterpartyClient() {return CounterpartyClient;}
    public String getCounterpartyClientCode() {return CounterpartyClientCode;}
    public String getShippingAgent() {return ShippingAgent;}
    public String getShippingAgentCode() {return ShippingAgentCode;}
    public String getEndCustomer() {return EndCustomer;}
    public String getPostingDescription() {return PostingDescription;}
    public String getWeight() {return Weight;}
    public String getVolume() {return Volume;}
    public String getAmount() {return Amount;}
    public String getAmountRUR() {return AmountRUR;}
    
}
