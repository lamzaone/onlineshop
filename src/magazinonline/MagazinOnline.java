/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package magazinonline;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class MagazinOnline {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Connection con = dbcp.poolCon();
                } catch (SQLException ex) {
                    Logger.getLogger(MagazinOnline.class.getName()).log(Level.SEVERE, null, ex);
                }
                new LoadingScr().setVisible(true);
                
            }
        });
    }
    
}
