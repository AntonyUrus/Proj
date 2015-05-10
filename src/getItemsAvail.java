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
public class getItemsAvail {
    public String cat_id, shipment_method, shipment_date, only_avail;
    public ItemsAvail[] getItemsAvail(String cat_id,String shipment_method, String shipment_date,String only_avail)throws SQLException, ClassNotFoundException, FileNotFoundException{
        ItemsAvail[] newItemsAvail = new ItemsAvail[1000000];
         for(int i=0;i < newItemsAvail.length;i++){
            newItemsAvail[i]=new ItemsAvail();
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
        
        
        rs = stmt.executeQuery("USE [Project] GO" +"DECLARE @return_value int\n" +
                    "EXEC @return_value = [dbo].[Merlion_api_getItemsAvail]\n" +
                    "@cat_id =" + cat_id + "\n" +
                    "@shipment_method =" + shipment_method+ "\n" +
                    "@shipment_date = " + shipment_date + "\n" +
                    "@only_avail = " + only_avail + "\n" +
                    "SELECT 'Return Value' = @return_value\n" +
                    "GO");
                
        while (rs.next()) {
            newItemsAvail[rs.getRow()].setitems_no(rs.getString("items_no"));
            newItemsAvail[rs.getRow()].setqty(rs.getString("qty"));
            newItemsAvail[rs.getRow()].setdesire_qty(rs.getString("desire_qty"));
            newItemsAvail[rs.getRow()].setprice(rs.getString("price"));
            newItemsAvail[rs.getRow()].setamount(rs.getString("amount"));
            newItemsAvail[rs.getRow()].setdesire_price(rs.getString("desire_price"));
            newItemsAvail[rs.getRow()].setweight(rs.getString("weight"));
            newItemsAvail[rs.getRow()].setvolume(rs.getString("volume"));
           
        }
 
         
         return newItemsAvail;
    }

  

}
