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
public class getItems {
    private String cat_id;
   public Items[] getItems(String cat_id)throws SQLException, ClassNotFoundException, FileNotFoundException{
        Items[] newItems = new Items[1000000];
         for(int i=0;i < newItems.length;i++){
            newItems[i]=new Items();
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
                        "EXEC @return_value = [dbo].[Merlion_api_getItems] @cat_id =" + cat_id + "\n" +
                        "SELECT 'Return Value' = @return_value");
                
         while (rs.next()) {
            newItems[rs.getRow()].setNo(rs.getString("No"));
            newItems[rs.getRow()].setName(rs.getString("Name"));
            newItems[rs.getRow()].setBrand(rs.getString("Brand"));
            newItems[rs.getRow()].setGroupItem(rs.getString("GroupItem"));
            newItems[rs.getRow()].setVendor_part(rs.getString("Vendor_part"));
            newItems[rs.getRow()].setSize(rs.getString("Size"));
            newItems[rs.getRow()].setEOL(rs.getString("EOL"));
            newItems[rs.getRow()].setWarranty(rs.getString("Warranty"));
            newItems[rs.getRow()].setWeight(rs.getString("Weight"));
            newItems[rs.getRow()].setVolume(rs.getString("Volume"));
            newItems[rs.getRow()].setMin_Packaged(rs.getString("Min_Packaged"));
            newItems[rs.getRow()].setGroupName1(rs.getString("GroupName1"));
            newItems[rs.getRow()].setGroupName2(rs.getString("GroupName2"));
        }
         
         return newItems;
    }

  

}
