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
public class CounterAgent {
    private String Code, Description, code;
    
    public CounterAgent(){}
    public CounterAgent(String code){this.code=code;}
    
    public void setCode(String Code){this.Code=Code;}
    public void setDescription(String Description){this.Description=Description;}
    
    public String getCode(){return Code;}
    public String getDescription(){return Description;}
    
}
