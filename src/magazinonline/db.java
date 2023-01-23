/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magazinonline;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author denis
 */
public class db {
    
    public static Connection mycon(){
        Connection con = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://mysql-105349-0.cloudclusters.net:17481/revitdb","admin", "Ea3b7ArW");
            return con;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println(e);
            return null;
            
        }
    }
    
}
