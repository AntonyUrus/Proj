/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication1;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nikita
 */
public class getOrdersList {
    private String document_no;
    public OrdersList[] getOrdersList(String document_no)throws SQLException, ClassNotFoundException, FileNotFoundException{
        OrdersList[] newOrdersList = new OrdersList[1000000];
        for(int i=0;i < newOrdersList.length;i++){
            newOrdersList[i]=new OrdersList();
        }

       String URL="jdbc:sqlserver://localhost:1433;databaseName=Project;user=PU1;password=PU1; Integrated Security = true ";
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       Connection conn = DriverManager.getConnection(URL);
 
        if (conn != null) {
            System.out.println("Соединение с БД установлено!");
        }
        if (conn == null) {
            System.out.println("Не удалось соединиться с БД!");
            System.exit(0);
        }
 
        Statement stmt = conn.createStatement();
        ResultSet rs;
        
        
        rs = stmt.executeQuery("DECLARE @return_value int\n" +
            "EXEC @return_value = [dbo].[Merlion_api_getOrdersList]\n" +
            "@document_no="+document_no+"\n" +
            "SELECT 'Return Value'=@return_value\n"
        );

        while (rs.next()) {
            newOrdersList[rs.getRow()].setdocument_no(rs.getString("document_no"));
            newOrdersList[rs.getRow()].setTNN(rs.getString("TNN"));
            newOrdersList[rs.getRow()].setOrderDate(rs.getString("OrderDate"));
            newOrdersList[rs.getRow()].setManager(rs.getString("Manager"));
            //newOrdersList[rs.getRow()].setContract(rs.getString("Contract"));
            newOrdersList[rs.getRow()].setShipmentMethod(rs.getString("ShipmentMethod"));
            newOrdersList[rs.getRow()].setShipmentMethodCode(rs.getString("ShipmentMethodCode"));
            newOrdersList[rs.getRow()].setShipmentDate(rs.getString("ShipmentDate"));
            newOrdersList[rs.getRow()].setCounterpartyClient(rs.getString("CounterpartyClient"));
            newOrdersList[rs.getRow()].setCounterpartyClientCode(rs.getString("CounterpartyClientCode"));
            newOrdersList[rs.getRow()].setShippingAgent(rs.getString("ShippingAgent"));
            newOrdersList[rs.getRow()].setShippingAgentCode(rs.getString("ShippingAgentCode"));
            newOrdersList[rs.getRow()].setEndCustomer(rs.getString("EndCustomer"));
            newOrdersList[rs.getRow()].setPostingDescription(rs.getString("PostingDescription"));
            newOrdersList[rs.getRow()].setWeight(rs.getString("Weight"));
            newOrdersList[rs.getRow()].setVolume(rs.getString("Volume"));
            newOrdersList[rs.getRow()].setAmount(rs.getString("Amount"));
            newOrdersList[rs.getRow()].setAmountRUR(rs.getString("AmountRUR"));
        }
        
         return newOrdersList;
    }

  

}
