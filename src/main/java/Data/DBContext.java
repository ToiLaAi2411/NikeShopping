/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author VINH HUNG
 */
public class DBContext {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
       Connection conn = null;
//       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//       String url = "jdbc:sqlserver://localhost:1433;databaseName=ASS";
//       String user ="sa";
//       String password = "12345";
//       conn = DriverManager.getConnection(url, user, password);
         String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=NikeWeb;"
                    + "user=sa;"
                    + "password=12345;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             conn = DriverManager.getConnection(url); 
        return conn;
    
}
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       Connection conn = DBContext.getConnection();
        System.out.println(conn);
    }
    
}
