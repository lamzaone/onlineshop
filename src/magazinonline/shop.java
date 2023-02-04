/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package magazinonline;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author denis
 */
public final class shop extends  javax.swing.JPanel implements Runnable    {
//    static ComboPooledDataSource comboPooledDataSource = null;
//
//	static {
//		comboPooledDataSource = new ComboPooledDataSource();
//
//		comboPooledDataSource.setJdbcUrl("jdbc:mysql://mysql-105349-0.cloudclusters.net:17481/revitdb");
//		comboPooledDataSource.setUser("admin");
//		comboPooledDataSource.setPassword("Ea3b7ArW");
//
//		comboPooledDataSource.setMinPoolSize(3);
//		comboPooledDataSource.setAcquireIncrement(3);
//		comboPooledDataSource.setMaxPoolSize(30);
//
//	}
    String pathe = System.getProperty("user.dir")+File.separator+"temp"+File.separator;
    int userid;
    double pret;
    int loginstate = 0;
    Connection conn = null;
    ImageIcon format;
    InputStream input;
    
    FileOutputStream output;
    
    private static final DecimalFormat df = new DecimalFormat("0.00");
    /**
     * Creates new form shop
     */
    
//    static ComboPooledDataSource comboPooledDataSource = null;
//    Connection con;
//	static {
//		comboPooledDataSource = new ComboPooledDataSource();
////        try {
////            comboPooledDataSource.setContextClassLoaderSource("library");
////        } catch (PropertyVetoException ex) {
////            Logger.getLogger(dbcp.class.getName()).log(Level.SEVERE, null, ex);
////        }
//		comboPooledDataSource.setJdbcUrl("jdbc:mysql://mysql-105349-0.cloudclusters.net:17481/revitdb");
//		comboPooledDataSource.setUser("admin");
//		comboPooledDataSource.setPassword("Ea3b7ArW");
//		comboPooledDataSource.setMinPoolSize(100);
//		comboPooledDataSource.setAcquireIncrement(5);
//		comboPooledDataSource.setMaxPoolSize(3000);
//                
//                
//
//	}
        
    public shop() {
        
//        try {
//                    con = comboPooledDataSource.getConnection();
//                } catch (SQLException E){
//                    
//                    
//	}
        initComponents();
        jSpinner1.setVisible(false);
        jButton1.setVisible(false);
        jLabel6.setVisible(false);
        jLabel8.setVisible(false);
        //jTable1.setVisible(false);
        
        //table_load();
        category_load();
        newprodload();
        
//        jScrollPane3.setSize(new Dimension (553,463));
        //jPanel4.setVisible(false);
        String pathe = System.getProperty("user.dir");

    }
    

    shop(int acclv, int userID, int login_state) {
        this();
        userid = userID;
        loginstate = login_state;
        if (login_state > 0){
            jSpinner1.setVisible(true);
            jButton1.setVisible(true);
            jLabel6.setVisible(true);
            jLabel8.setVisible(true);
        }
        
    }

    public void newprodload (){
            Thread th = new Thread() {

            @Override
            public void run() { 
                JPanel qq = new JPanel();
                JPanel eq = new JPanel();
                FlowLayout fl = new FlowLayout();
                eq.setLayout(fl);
                qq = new JPanel();
                qq.validate();
                GridLayout grid = new GridLayout(0,3);
                grid.setVgap(20);
                grid.setHgap(20);
                qq.setLayout(grid);
                qq.validate();


                    try { 

                        Statement s = dbcp.con.createStatement();

                        ResultSet rs = s.executeQuery("SELECT `product_id`, `product_name`, `product_price`, `product_picture` FROM Products");
            //            }else {
            //                rs = s.executeQuery("SELECT * FROM Products WHERE product_category ='"+category+"'");
            //            }



            //            File theFile = new File(pathe+"temp3.png");
            //            output = new FileOutputStream(theFile);


                        while (rs.next()){
                            String IDpr = rs.getString("product_id");
                            String NumePr = rs.getString("product_name");
                            String PretPR = rs.getString("product_price");
                            String UrlPR = rs.getString("product_picture");


                            produs_test1 prt = new produs_test1(IDpr,NumePr,PretPR, UrlPR);
                            prt.start();
                            

//                            Thread t1 = new Thread(prt);
//                            t1.start();
                            

                           
                            
                            prt.setPreferredSize(new Dimension(148, 208));
                            prt.validate();
                            prt.addMouseListener(new MouseAdapter() {
                                public void mouseClicked(MouseEvent e) {
                                   try {
                                    Statement s = dbcp.con.createStatement();
                                    ResultSet rs = s.executeQuery("SELECT `product_name`, `product_description`, `product_price`, `product_picture` FROM `Products` WHERE product_id='"+prt.IDprod+"'");
                                    File theFile = new File(pathe+prt.IDprod+".png");
                                    


                                    if(rs.next()){

                                        jLabel2.setText(rs.getString("product_name"));   
                                        jTextArea1.setText(rs.getString("product_description"));
                                        jTextArea1.setLineWrap(true);
                                        jTextArea1.setWrapStyleWord(true);

            //                             try{
            //                                URL url = new URL(rs.getString("product_picture"));
            //                                Image image = ImageIO.read(url);
            //                                Image imej2 = image.getScaledInstance(328, 165, SCALE_SMOOTH);
            //                                jLabel5.setIcon(new ImageIcon(imej2));
            //                            }catch (IOException ee){
            //            
            //                            }
                                        if(!theFile.exists()){
                                            output = new FileOutputStream(theFile);
                                            input = rs.getBinaryStream("product_picture");
                                            byte buffer[] = new byte[1024];
                                            while (input.read(buffer)>0){
                                                output.write(buffer);
                                            }
                                            String path = theFile.getAbsolutePath();
                                            ImageIcon myImage = new ImageIcon(path);
                                            Image img = myImage.getImage();
                                            Image newImg = img.getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), SCALE_SMOOTH);
                                            ImageIcon image = new ImageIcon(newImg);
                                            jLabel5.setIcon(image);
                                        }else {
                                            String path = theFile.getAbsolutePath();
                                            ImageIcon myImage = new ImageIcon(path);
                                            Image img = myImage.getImage();
                                            Image newImg = img.getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), SCALE_SMOOTH);
                                            ImageIcon image = new ImageIcon(newImg);
                                            jLabel5.setIcon(image);
                                        }
                                        String q;
                                        pret = rs.getDouble("product_price");
                                        q = String.valueOf(pret);
                                        jLabel8.setText(df.format(pret)+" RON");             
                                        jLabel7.setText(df.format(pret)+" RON");
                                    }

                                    rs.close();


                                }
                                catch(Exception ef){

                                }
                                }
                            });

                            qq.add(prt);
                        }
                    eq.add(qq);
                    s.close();
                    rs.close();
                    
                    
                    jScrollPane3.getViewport().add(eq);
            //        jScrollPane3.setSize(new Dimension (553,463));
                    }catch (Exception e){

                }
            }
            };
            
            th.start();
//        try {
//            th.join();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(shop.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
}
    
    public void category_load(){

        try {
            

//            conn = DriverManager.getConnection("jdbc:mysql://mysql-105349-0.cloudclusters.net:17481/revitdb","admin", "Ea3b7ArW");
//            Statement s = conn.createStatement();

//            conn = comboPooledDataSource.getConnection();
//            Statement s  = conn.createStatement();
            
            Statement s  = dbcp.con.createStatement();

            ResultSet rs = s.executeQuery("SELECT DISTINCT product_category FROM Products");
            

            while(rs.next()){
                jComboBox2.addItem(rs.getString("product_category"));
            }
            
            rs.close();
            s.close();
        }
        catch (SQLException e){
            
        }
    }

//    public void table_load(){
//        try {
//            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
//            dt.setRowCount(0);
////            conn = comboPooledDataSource.getConnection();
////            Statement s  = conn.createStatement();
//            
//            Statement s  = dbcp.poolCon().createStatement();
//            ResultSet rs = s.executeQuery("SELECT product_id,product_category,product_name,product_price,product_description FROM Products");
//
//            
//            while(rs.next()){
//                Vector v = new Vector();
//                v.add(rs.getInt(1));
//                v.add(rs.getString(2));
//                v.add(rs.getString(3));
//                v.add(df.format(rs.getDouble(4))+" RON");
//                
//                dt.addRow(v);
//            }
//            
//
//            
//            rs.close();
//            s.close();
//            
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlavbel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("CATEGORY:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton2.setText("SEARCH");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jlavbel.setText("Nume produs:");

        jLabel3.setText("PRET:");

        jLabel4.setText("Descriere:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Adauga in cos");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        jSpinner1.setToolTipText("");
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jSpinner1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jSpinner1FocusLost(evt);
            }
        });
        jSpinner1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSpinner1MouseClicked(evt);
            }
        });
        jSpinner1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSpinner1PropertyChange(evt);
            }
        });
        jSpinner1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jSpinner1VetoableChange(evt);
            }
        });

        jLabel6.setText("TOTAL:");

        jLabel8.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlavbel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlavbel)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(89, 89, 89))
        );

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String category = String.valueOf(jComboBox2.getSelectedItem());
        if (category.equals("ALL"))newprodload();
        else {
            Thread th = new Thread() {

            @Override
            public void run() { 
            JPanel qq = new JPanel();
            JPanel eq = new JPanel();
            FlowLayout fl = new FlowLayout();
            eq.setLayout(fl);
            qq = new JPanel();
            qq.validate();
            GridLayout grid = new GridLayout(0,3);
            grid.setVgap(20);
            grid.setHgap(20);
            qq.setLayout(grid);
            qq.validate();
            
            try {
                Statement s = dbcp.con.createStatement();
                
                System.out.println("qqeee");
                ResultSet rs = s.executeQuery("SELECT * FROM Products WHERE product_category ='"+category+"'");
                
                System.out.println("zzz");
                
//            File theFile = new File(pathe+"temp3.png");
//            output = new FileOutputStream(theFile);

                System.out.println("eeee");

                while (rs.next()){
                    String IDpr = rs.getString(1);
                    String NumePr = rs.getString(3);
                    String PretPR = rs.getString(4);
                    String UrlPR = rs.getString("product_picture");

                    System.out.println("qqqeeerer");

                    produs_test1 prt = new produs_test1(IDpr,NumePr,PretPR, UrlPR);
                    prt.start();
                    
                    prt.setPreferredSize(new Dimension(148, 208));
                    prt.validate();
                    prt.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            try {
                                Statement s = dbcp.con.createStatement();
                                ResultSet rs = s.executeQuery("SELECT * FROM `Products` WHERE product_id='"+prt.IDprod+"'");
                                File theFile = new File(pathe+prt.IDprod+".png");
                                


                                if(rs.next()){

                                    jLabel2.setText(rs.getString("product_name"));
                                    jTextArea1.setText(rs.getString("product_description"));
                                    jTextArea1.setLineWrap(true);
                                    jTextArea1.setWrapStyleWord(true);


//                                    try{
//                                        URL url = new URL(UrlPR);
//                                        Image imej2 = ImageIO.read(url).getScaledInstance(148, 94, SCALE_SMOOTH);
//                                        jLabel5.setIcon(new ImageIcon(imej2));
//                                    }catch (IOException ez){
//
//                                    }
                                    if(!theFile.exists()){
                                            output = new FileOutputStream(theFile);
                                            input = rs.getBinaryStream("product_picture");
                                            byte buffer[] = new byte[1024];
                                            while (input.read(buffer)>0){
                                                output.write(buffer);
                                            }
                                            String path = theFile.getAbsolutePath();
                                            ImageIcon myImage = new ImageIcon(path);
                                            Image img = myImage.getImage();
                                            Image newImg = img.getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), SCALE_SMOOTH);
                                            ImageIcon image = new ImageIcon(newImg);
                                            jLabel5.setIcon(image);
                                        }else {
                                            String path = theFile.getAbsolutePath();
                                            ImageIcon myImage = new ImageIcon(path);
                                            Image img = myImage.getImage();
                                            Image newImg = img.getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), SCALE_SMOOTH);
                                            ImageIcon image = new ImageIcon(newImg);
                                            jLabel5.setIcon(image);
                                        }
                                    pret = rs.getDouble("product_price");
                                    String q = String.valueOf(pret);
                                    jLabel8.setText(df.format(pret)+" RON");
                                    jLabel7.setText(df.format(pret)+" RON");
                                }

                                rs.close();


                            }
                            catch(Exception ef){

                            }
                        }
                    });

                    qq.add(prt);
                }
                eq.add(qq);
                s.close();
                rs.close();
                jScrollPane3.getViewport().add(eq);
            }catch (Exception e){
                
            }
            }
            };
            th.start();
            try {
                th.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(shop.class.getName()).log(Level.SEVERE, null, ex);
            }
                               
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        
        
        
//        if(category.equals("ALL") == false){
//            try {
//                DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
//                dt.setRowCount(0);
////              conn = comboPooledDataSource.getConnection();
////              Statement s  = conn.createStatement();
//            
//                Statement s  = dbcp.poolCon().createStatement();
//                ResultSet rs = s.executeQuery("SELECT product_id,product_category,product_name,product_price,product_description FROM `Products` WHERE product_category ='"+category+"'");
//
//                while(rs.next()){
//                    Vector v = new Vector();
//                    v.add(rs.getInt(1));
//                    v.add(rs.getString(2));
//                    v.add(rs.getString(3));
//                    v.add(rs.getDouble(4));
//
//                    dt.addRow(v);
//
//            }
//                
//            rs.close();
//            s.close();
//            }
//            
//
//            catch (Exception e){
//
//            }
//        }else {
//            try {
//                DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
//                dt.setRowCount(0);
////              conn = comboPooledDataSource.getConnection();
////              Statement s  = conn.createStatement();
//            
//                Statement s  = dbcp.poolCon().createStatement();
//                ResultSet rs = s.executeQuery("SELECT product_id,product_category,product_name,product_price,product_description FROM `Products`");
//
//                while(rs.next()){
//                    Vector v = new Vector();
//                    v.add(rs.getInt(1));
//                    v.add(rs.getString(2));
//                    v.add(rs.getString(3));
//                    v.add(rs.getDouble(4));
//
//                    dt.addRow(v);
//
//            }
//
//            rs.close();
//            s.close();
//            }
//
//            catch (Exception e){
//
//            }
//            
//            newprodload();
//        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //int r = jTable1.getSelectedRow();
        
        int pid=0;
        
        try {
            Statement s = dbcp.con.createStatement();
            ResultSet rs = s.executeQuery("SELECT `product_id` FROM Products WHERE product_name='"+jLabel2.getText()+"'");
            
            if(rs.next()){
                pid = rs.getInt("product_id");
            }
            s.close();
            rs.close();
        } catch  (Exception e){
            
        }
        
        int qty = Integer.parseInt(jSpinner1.getValue().toString());
//        double double2 = double1* Double.parseDouble(String.valueOf(cechet));
//        cos.add(new CosDeCumparaturi(cacat, double1, cechet, double2));
        
        try {
//            conn = comboPooledDataSource.getConnection();
//            Statement s  = conn.createStatement();
            
            Statement s  = dbcp.con.createStatement();
            s.executeUpdate(" INSERT INTO cos_cumparaturi (id, id_user, id_produs, cantitate) VALUES (DEFAULT,'"+userid+"', '"+pid+"', '"+qty+"')");
            s.close();
        }
        catch (Exception e) {
            
        }
    
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSpinner1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jSpinner1VetoableChange

    }//GEN-LAST:event_jSpinner1VetoableChange

    private void jSpinner1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSpinner1PropertyChange

    }//GEN-LAST:event_jSpinner1PropertyChange

    private void jSpinner1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner1MouseClicked


    }//GEN-LAST:event_jSpinner1MouseClicked

    private void jSpinner1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSpinner1FocusLost

    }//GEN-LAST:event_jSpinner1FocusLost

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged

        String q = jSpinner1.getValue().toString();
        String w = String.valueOf(pret);
        double e = Double.parseDouble(q) * Double.parseDouble(w);
        jLabel8.setText(df.format(e)+" RON");
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JPanel qq = new JPanel();
        JPanel eq = new JPanel();
        FlowLayout fl = new FlowLayout();
        eq.setLayout(fl);
        qq = new JPanel();
        qq.validate();
        GridLayout grid = new GridLayout(0,3);
        grid.setVgap(20);
        grid.setHgap(20);
        qq.setLayout(grid);
        qq.validate();
        try {
                String category = String.valueOf(jComboBox2.getSelectedItem());
               
                
            
                Statement s  = dbcp.con.createStatement();
                ResultSet rs;
                if (category != "ALL"){
                    rs = s.executeQuery("SELECT product_id,product_category,product_name,product_price,product_description,product_picture FROM `Products` WHERE product_name LIKE '%"+jTextField1.getText()+"%' and product_category = '"+category+"'");
                }
                else {
                    rs = s.executeQuery("SELECT product_id,product_category,product_name,product_price,product_description,product_picture FROM `Products` WHERE product_name LIKE '%"+jTextField1.getText()+"%'");

                }

                while(rs.next()){
                String IDpr = rs.getString("product_id");
                String NumePr = rs.getString("product_name");
                String PretPR = rs.getString("product_price");
                String UrlPR = rs.getString("product_picture");
                
                
                produs_test1 prt = new produs_test1(IDpr,NumePr,PretPR, UrlPR);
                prt.start();
                prt.setPreferredSize(new Dimension(148, 208));
                prt.validate();
                prt.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                       try {
                        Statement s = dbcp.con.createStatement();
                        ResultSet rs = s.executeQuery("SELECT `product_name`, `product_description`, `product_price`, `product_picture` FROM `Products` WHERE product_id='"+prt.IDprod+"'");
                                                                                File theFile = new File(pathe+prt.IDprod+".png");
                                output = new FileOutputStream(theFile);


                                if(rs.next()){

                                    jLabel2.setText(rs.getString("product_name"));
                                    jTextArea1.setText(rs.getString("product_description"));
                                    jTextArea1.setLineWrap(true);
                                    jTextArea1.setWrapStyleWord(true);


//                                    try{
//                                        URL url = new URL(UrlPR);
//                                        Image imej2 = ImageIO.read(url).getScaledInstance(148, 94, SCALE_SMOOTH);
//                                        jLabel5.setIcon(new ImageIcon(imej2));
//                                    }catch (IOException ez){
//
//                                    }
                                    input = rs.getBinaryStream("product_picture");
                                    byte buffer[] = new byte[1024];
                                    while (input.read(buffer)>0){
                                    output.write(buffer);
                                    }
                                    String path = theFile.getAbsolutePath();
                                    ImageIcon myImage = new ImageIcon(path);
                                    Image img = myImage.getImage();
                                    Image newImg = img.getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), SCALE_SMOOTH);
                                    ImageIcon image = new ImageIcon(newImg);
                                    jLabel5.setIcon(image);
                
//                            input = rs.getBinaryStream("product_picture");
//                            byte buffer[] = new byte[1024];
//                            while (input.read(buffer)>0){
//                                output.write(buffer);
//                            }
//                            String path = theFile.getAbsolutePath();
//                            ImageIcon myImage = new ImageIcon(path);
//                            Image img = myImage.getImage();
//                            Image newImg = img.getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), SCALE_SMOOTH);
//                            ImageIcon image = new ImageIcon(newImg);
                            //jLabel5.setIcon(image);
                            String q;
                            pret = rs.getDouble("product_price");
                            q = String.valueOf(pret);
                            jLabel8.setText(df.format(pret)+" RON");             
                            jLabel7.setText(df.format(pret)+" RON");
                        }

                        rs.close();


                    }
                    catch(Exception ef){

                    }
                    }
                });
                
                qq.add(prt);
            }
        eq.add(qq);
        s.close();
        rs.close();
        jScrollPane3.getViewport().add(eq);
//        jScrollPane3.setSize(new Dimension (553,463));
        }catch (Exception e){
        
    }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlavbel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
