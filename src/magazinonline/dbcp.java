/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magazinonline;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import static com.mchange.v2.c3p0.impl.C3P0Defaults.contextClassLoaderSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class dbcp {
    static Connection con = null;
    static ComboPooledDataSource comboPooledDataSource = null;

	static {
		comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setContextClassLoaderSource("library");
        } catch (PropertyVetoException ex) {
            Logger.getLogger(dbcp.class.getName()).log(Level.SEVERE, null, ex);
        }
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://mysql-105349-0.cloudclusters.net:17481/revitdb");
		comboPooledDataSource.setUser("admin");
		comboPooledDataSource.setPassword("Ea3b7ArW");

		comboPooledDataSource.setMinPoolSize(30);
		comboPooledDataSource.setAcquireIncrement(30);
		comboPooledDataSource.setMaxPoolSize(100);

	}
    
   public static Connection poolCon() throws SQLException{
                
                try {
                    con = comboPooledDataSource.getConnection();
                } catch (SQLException E){
                    
                    
	}
                return con;
}
}
