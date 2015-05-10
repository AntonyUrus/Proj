/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication1;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;

/**
 *
 * @author Nikita
 */

public class Catalog{
    private String ID, ID_PARENT, Description/*, cat_id*/;
    
    public Catalog(){}
    //public Catalog(String cat_id){ this.cat_id=cat_id;}
     
    public void setID(String ID) {this.ID = ID;} 
    public void setID_PARENT(String ID_PARENT) {this.ID_PARENT = ID_PARENT;}
    public void setDescription(String Description){ this.Description = Description;}
    //public void setCat_id(String cat_id){this.cat_id = cat_id;}

    public String getID() {return ID;}
    public String getID_PARENT(){return ID_PARENT;}
    public String getDescription(){return Description;}
    //public String getCat_id(){return cat_id;}
}