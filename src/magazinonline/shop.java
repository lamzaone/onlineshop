/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package magazinonline;


import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author denis
 */
public class shop extends javax.swing.JPanel {
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
    
    int userid;
    double pret;
    int loginstate = 0;
    Connection conn = null;
    ImageIcon format;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    /**
     * Creates new form shop
     */
    public shop() {
        
        
        initComponents();
        jSpinner1.setVisible(false);
        jButton1.setVisible(false);
        jLabel6.setVisible(false);
        jLabel8.setVisible(false);
        
        table_load();
        category_load();
        //newprodload();
        jPanel4.setVisible(false);

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
    public void setDen(String nume){
        String Nume = nume;
        jLabel2.setText(Nume);
    }
    
    public void newprodload(){
        
            List<produs_test> prods = new ArrayList<>();
            jPanel4.setLayout(new GridLayout(0,3));
            prods = new ArrayList<>();
        try { 
            Statement s = dbcp.poolCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Products");
            
            
            while (rs.next()){
                produs_test prt = new produs_test(rs.getString(3),rs.getString(4));
                jPanel4.add(prt);
                prods.add(prt);
//                System.out.print("a");
//                jprload.jProductLoader(jPanel4, prt);
//                prt.setVisible(true);
//                jPanel4.add(prt);
                //jPanel4.add(prt);
            }
            
//            for (produs_test panelprod: prods){;
////                jprload.jProductLoader(jPanel4, panelprod);
////                panelprod.setVisible(true);
////                jPanel4.add(panelprod);
//                //panelprod.setLayout(new FlowLayout());
//                jPanel4.add(panelprod);
//                
//                System.out.println("a");
//            }
                
        }catch (Exception e){
        
    }
}
    
    public void category_load(){

        try {
            

//            conn = DriverManager.getConnection("jdbc:mysql://mysql-105349-0.cloudclusters.net:17481/revitdb","admin", "Ea3b7ArW");
//            Statement s = conn.createStatement();

//            conn = comboPooledDataSource.getConnection();
//            Statement s  = conn.createStatement();
            
            Statement s  = dbcp.poolCon().createStatement();

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

    public void table_load(){
        try {
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
//            conn = comboPooledDataSource.getConnection();
//            Statement s  = conn.createStatement();
            
            Statement s  = dbcp.poolCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT product_id,product_category,product_name,product_price,product_description FROM Products");

            
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(df.format(rs.getDouble(4))+" RON");
                
                dt.addRow(v);
            }
            

            
            rs.close();
            s.close();
            
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        jPanel4 = new javax.swing.JPanel();

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
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Category", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setFocusable(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(30);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(5);
        }

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        jPanel4.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int r = jTable1.getSelectedRow();
        jSpinner1.setValue(1);
        InputStream input;
        FileOutputStream output;
        
        jLabel2.setText(jTable1.getValueAt(r, 2).toString());
        try {
//            conn = comboPooledDataSource.getConnection();
//            Statement s  = conn.createStatement();
            
            Statement s  = dbcp.poolCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM `Products` WHERE product_id="+jTable1.getValueAt(r, 0));
            File theFile = new File("temp.png");
            output = new FileOutputStream(theFile);
            
            
            if(rs.next()){
                
                jLabel2.setText(rs.getString("product_name"));   
                jTextArea1.setText(rs.getString("product_description"));
                jTextArea1.setLineWrap(true);
                jTextArea1.setWrapStyleWord(true);
                
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
                String q;
                pret = rs.getDouble("product_price");
                q = String.valueOf(pret);
                jLabel8.setText(df.format(pret)+" RON");             
                jLabel7.setText(df.format(pret)+" RON");
            }
            
            rs.close();
            s.close();
            
            
        }
        catch(Exception e){
            
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        String category = String.valueOf(jComboBox2.getSelectedItem());
        if(category.equals("ALL") == false){
            try {
                DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
                dt.setRowCount(0);
//              conn = comboPooledDataSource.getConnection();
//              Statement s  = conn.createStatement();
            
                Statement s  = dbcp.poolCon().createStatement();
                ResultSet rs = s.executeQuery("SELECT product_id,product_category,product_name,product_price,product_description FROM `Products` WHERE product_category ='"+category+"'");

                while(rs.next()){
                    Vector v = new Vector();
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));
                    v.add(rs.getDouble(4));

                    dt.addRow(v);

            }
                
            rs.close();
            s.close();
            }
            

            catch (Exception e){

            }
        }else {
            try {
                DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
                dt.setRowCount(0);
//              conn = comboPooledDataSource.getConnection();
//              Statement s  = conn.createStatement();
            
                Statement s  = dbcp.poolCon().createStatement();
                ResultSet rs = s.executeQuery("SELECT product_id,product_category,product_name,product_price,product_description FROM `Products`");

                while(rs.next()){
                    Vector v = new Vector();
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));
                    v.add(rs.getDouble(4));

                    dt.addRow(v);

            }

            rs.close();
            s.close();
            }

            catch (Exception e){

            }
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int r = jTable1.getSelectedRow();
        
        int pid = Integer.parseInt(jTable1.getValueAt(r, 0).toString());
        
        int qty = Integer.parseInt(jSpinner1.getValue().toString());
//        double double2 = double1* Double.parseDouble(String.valueOf(cechet));
//        cos.add(new CosDeCumparaturi(cacat, double1, cechet, double2));
        
        try {
//            conn = comboPooledDataSource.getConnection();
//            Statement s  = conn.createStatement();
            
            Statement s  = dbcp.poolCon().createStatement();
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
        try {
                String category = String.valueOf(jComboBox2.getSelectedItem());
                DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
                dt.setRowCount(0);
//              conn = comboPooledDataSource.getConnection();
//              Statement s  = conn.createStatement();
            
                Statement s  = dbcp.poolCon().createStatement();
                ResultSet rs;
                if (category != "ALL"){
                    rs = s.executeQuery("SELECT product_id,product_category,product_name,product_price,product_description FROM `Products` WHERE product_name LIKE '%"+jTextField1.getText()+"%' and product_category = '"+category+"'");
                }
                else {
                    rs = s.executeQuery("SELECT product_id,product_category,product_name,product_price,product_description FROM `Products` WHERE product_name LIKE '%"+jTextField1.getText()+"%'");

                }

                while(rs.next()){
                    Vector v = new Vector();
                    v.add(rs.getInt(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));
                    v.add(rs.getDouble(4));

                    dt.addRow(v);

            }
                
            rs.close();
            s.close();
            }
            

            catch (Exception e){

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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlavbel;
    // End of variables declaration//GEN-END:variables
}
