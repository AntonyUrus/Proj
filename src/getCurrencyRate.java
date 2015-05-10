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
public class getCurrencyRate {
     private String date;
   public CurrencyRate[] getCurrencyRate(String date)throws SQLException, ClassNotFoundException, FileNotFoundException{
        CurrencyRate[] newCurrencyRate = new CurrencyRate[1000000];
         for(int i=0;i < newCurrencyRate.length;i++){
            newCurrencyRate[i]=new CurrencyRate();
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
                       "EXEC @return_value = [dbo].[Merlion_api_getCurrencyRate] @date =" + date +"\n" +
                       "SELECT 'Return Value' = @return_value");
                
         while (rs.next()) {
            newCurrencyRate[rs.getRow()].setCode(rs.getString("Code"));
            newCurrencyRate[rs.getRow()].setExchangeRate(rs.getString("ExchangeRate"));
         }
         return newCurrencyRate;
         
    }
}
