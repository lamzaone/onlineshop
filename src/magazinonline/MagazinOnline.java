/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package magazinonline;

// UPDATE_URL = "https://dl.dropboxusercontent.com/s/27wxnj7l6twdvb2/latestversion.txt";
// JAR_URL = "https://dl.dropboxusercontent.com/s/v23spqoej7qpahe/MagazinOnline.jar";

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.tools.javac.Main;
import java.io.File;
import java.util.Set;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author denis
 */
public class MagazinOnline {
    private static final String VER_URL = "https://dl.dropboxusercontent.com/s/27wxnj7l6twdvb2/latestversion.txt";
    private static final String UPDATER_URL = "https://dl.dropboxusercontent.com/s/4b44qpwvjems5yf/Updater.jar";
    private static final String lib1_URL = "https://dl.dropboxusercontent.com/s/5buxzbrvb6l8h7u/c3p0-0.9.5.5.jar";
    private static final String lib2_URL = "https://dl.dropboxusercontent.com/s/r53zmda4n4x0wtm/mchange-commons-java-0.2.19.jar";
    private static final String lib3_URL = "https://dl.dropboxusercontent.com/s/bjqaq2ksp2r3gjj/mysql-connector-j-8.0.32.jar";
    static final String CURRENT_VERSION = "0.9.5.7";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException {
//    checkLib();
    checkForUpdates();
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
    
//    private static void checkLib(){
//       try{
//           Path target = Paths.get("lib\\c3p0-0.9.5.5.jar");
//            if (!Files.exists(target)){
//                InputStream in = new URL(lib1_URL).openStream();
//                Files.copy(in, target);
//            }
//            target = Paths.get("lib\\mchange-commons-java-0.2.19.jar");
//            if (!Files.exists(target)){
//                InputStream in = new URL(lib2_URL).openStream();
//                Files.copy(in, target);
//            }
//            target = Paths.get("lib\\mysql-connector-j-8.0.32.jar");
//            if (!Files.exists(target)){
//                InputStream in = new URL(lib3_URL).openStream();
//                Files.copy(in, target);
//            }
//            
//       } catch (Exception e){
//           
//       }
//    }
//    
    private static void checkForUpdates() throws URISyntaxException {
        try {
            String newVersion = checkVersion();
            if (newVersion != null && !newVersion.equals(CURRENT_VERSION)) {
                
                    Path target = Paths.get("Updater.jar");
                    if (!Files.exists(target)){
                        InputStream in = new URL(UPDATER_URL).openStream();
                        Files.copy(in, target);
                    }
                                     
                    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "Updater.jar");
                    Process p = pb.start();
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String checkVersion() throws IOException {
        String latestVersion = "0";
          try {
            // verifica daca exista o versiune mai noua
            URL updateURL = new URL(VER_URL);
            HttpURLConnection connection = (HttpURLConnection) updateURL.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            latestVersion = new String(inputStream.readAllBytes());
            System.out.println(latestVersion);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
         return latestVersion;
    }



    
    }
    
