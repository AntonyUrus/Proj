//package javaapplication1;
import java.io.FileNotFoundException;
import java.sql.*;
 
public class getCatalog {
    private String cat_id;
    private int count;
    Catalog[] newCatalog = new Catalog[1000000];
    
    public Catalog[] getCatalog(String cat_id)throws SQLException, ClassNotFoundException, FileNotFoundException{
        
        Catalog[] newCatalog = new Catalog[1000000];
        for(int i=0;i < newCatalog.length;i++){
            newCatalog[i]=new Catalog();
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
        
        
        rs = stmt.executeQuery("DECLARE	@return_value int\n" +
                    "EXEC @return_value = [dbo].[Merlion_api_getCatalog] @cat_id =" + cat_id + "\n"+
                    "SELECT 'Return Value' = @return_value");
                
        while (rs.next()) {
            count = rs.getRow();
            newCatalog[count].setID(rs.getString("ID"));
            newCatalog[count].setID_PARENT(rs.getString("ID_PARENT"));
            newCatalog[count].setDescription(rs.getString("Description"));
        }
       return newCatalog;
   } 
}
    
 