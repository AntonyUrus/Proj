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
public class getCommandResult {
    private String operation_no;
    public CommandResult[] getCommandResult(String operation_no)throws SQLException, ClassNotFoundException, FileNotFoundException{
        
         CommandResult[] newCommandResult = new CommandResult[1000000];
         for(int i=0;i < newCommandResult.length;i++){
            newCommandResult[i]=new CommandResult();
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
                      "EXEC @return_value = [dbo].[Merlion_api_getCommandResult]\n" +
                       "@operation_no =" + operation_no + "\n"+
                       "SELECT 'Return Value' = @return_value");
                 
                while (rs.next()) {
                    newCommandResult[rs.getRow()].setCreateTime(rs.getString("Create Time"));
                    newCommandResult[rs.getRow()].setProcessingTime(rs.getString("Processing Time"));
                    newCommandResult[rs.getRow()].setEndingTime(rs.getString("Ending Time"));
                    newCommandResult[rs.getRow()].setProcessingResult(rs.getString("ProcessingResult"));
                    newCommandResult[rs.getRow()].setDocumentNo(rs.getString("DocumentNo"));
                    newCommandResult[rs.getRow()].setProcessingResultComment(rs.getString("ProcessingResultComment"));
                    newCommandResult[rs.getRow()].setErrorText(rs.getString("ErrorText"));
                    newCommandResult[rs.getRow()].setProcessingReserved(rs.getString("ProcessingReserved"));
                }
        return newCommandResult;
        
    }
}
