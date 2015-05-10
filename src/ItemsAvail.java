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
public class ItemsAvail {
    private String items_no, qty, desire_qty, price, amount, desire_price, weight, volume, cat_id, shipment_method, shipment_date, only_avail;
    
    public ItemsAvail(){}
    public ItemsAvail(String cat_id,String shipment_method,String shipment_date,String only_avail){ 
        this.cat_id=cat_id;
        this.shipment_method=shipment_method;
        this.shipment_date=shipment_date;
        this.only_avail=only_avail;
    }
     
    public void setitems_no(String items_no) {this.items_no = items_no;} 
    public void setqty(String qty) {this.qty = qty;} 
    public void setdesire_qty(String desire_qty) {this.desire_qty = desire_qty;} 
    public void setprice(String price) {this.price = price;} 
    public void setamount(String amount) {this.amount = amount;} 
    public void setdesire_price(String desire_price) {this.desire_price = desire_price;} 
    public void setweight(String weight) {this.weight = weight;} 
    public void setvolume(String volume) {this.volume = volume;} 
    
    public String getitems_no() {return items_no;} 
    public String getqty() {return qty;} 
    public String getdesire_qty() {return desire_qty;} 
    public String getprice() {return price;} 
    public String getamount() {return amount;} 
    public String getdesire_price() {return desire_price;} 
    public String getweight() {return weight;} 
    public String getvolume() {return volume;} 
 
}
