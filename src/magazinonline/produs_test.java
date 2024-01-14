/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package magazinonline;

import com.sun.tools.javac.Main;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.text.html.ImageView;

/**
 *
 * @author denis
 */
public class produs_test extends javax.swing.JPanel implements Runnable {
    
    String IDprod;
    ImageIcon Icon;
    InputStream input;
    FileOutputStream output;
    private static final DecimalFormat df = new DecimalFormat("0.00");
            
        /**
     * Creates new form produs_test
     */
    public produs_test() {
        initComponents();
        
    }
    
    public produs_test(String IDprodus, String NumeProd, String pretprod, String UrlPR){
        this();
        this.IDprod = IDprodus;
        Thread t = new Thread() {

            @Override
            public void run() {
                        //this.IDprod = IDprodus;
                        jLabel3.setText("#"+IDprodus);
                        jLabel2.setText (NumeProd);
                        Double pret = Double.valueOf(pretprod);
                        jLabel4.setText(df.format(pret)+" RON");
//                        try{
//                             URL url = new URL(UrlPR);
//                             Image imej2 = ImageIO.read(url).getScaledInstance(148, 94, SCALE_SMOOTH);
//                            jLabel1.setIcon(new ImageIcon(imej2));
//                    }catch (IOException e){
//            
//                    }
                    try {
                        Statement s = dbcp.poolCon().createStatement();
                        ResultSet rs = s.executeQuery("SELECT product_picture FROM Products WHERE product_id="+IDprod);
                        File theFile = new File("temp4.png");
                        output = new FileOutputStream(theFile);


                         while (rs.next()){
                            input = rs.getBinaryStream("product_picture");
                            byte buffer[] = new byte[10240];
                            while (input.read(buffer)>0){
                            output.write(buffer);
                            }
                            String path = theFile.getAbsolutePath(); 
                            ImageIcon myImage = new ImageIcon(path);
                            Image img = myImage.getImage();
                            Image newImg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), SCALE_SMOOTH);
                            ImageIcon image = new ImageIcon(newImg);
                            jLabel1.setIcon(image);
                         }
                         rs.close();
                         s.close();


                    }
                    catch (Exception e){

                    }
                }
            };
        
        t.start();
        

        
        
        
        

        
        
//        this.IDprod = IDprodus;
//        jLabel3.setText("#"+IDprodus);
//        jLabel2.setText (NumeProd);
//        Double pret = Double.valueOf(pretprod);
//        jLabel4.setText(df.format(pret)+" RON");
//        try{
//            URL url = new URL(UrlPR);
//            Image imej2 = ImageIO.read(url).getScaledInstance(148, 94, SCALE_SMOOTH);
//            jLabel1.setIcon(new ImageIcon(imej2));
//        }catch (IOException e){
//            
//        }
        
        
        


//************************ Resource eating junk        
//        try {
//            Statement sss = dbcp.poolCon().createStatement();
//            ResultSet rsss = sss.executeQuery("SELECT product_picture FROM Products WHERE product_id="+IDprod);
//            File theFile = new File("temp4.png");
//            output = new FileOutputStream(theFile);
//            
//            
//             while (rsss.next()){
//                input = rsss.getBinaryStream("product_picture");
//                byte buffer[] = new byte[10240];
//                while (input.read(buffer)>0){
//                output.write(buffer);
//                }
//                String path = theFile.getAbsolutePath(); 
//                ImageIcon myImage = new ImageIcon(path);
//                Image img = myImage.getImage();
//                Image newImg = img.getScaledInstance(121, 82, SCALE_SMOOTH);
//                ImageIcon image = new ImageIcon(newImg);
//                jLabel1.setIcon(image);
//             }
//             rsss.close();
//             sss.close();
//                    
//                    
//        }
//        catch (Exception e){
//            
//        }
        
        

    }
    


  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("Denumire");

        jLabel4.setText("Pret:");

        jLabel3.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 84, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
