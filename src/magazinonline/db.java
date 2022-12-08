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
            con = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7579302","sql7579302", "fvz8qRCiyJ");
            return con;
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.println(e);
            return null;
            
        }
    }
    
}
