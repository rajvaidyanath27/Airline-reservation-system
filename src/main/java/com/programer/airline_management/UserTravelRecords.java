/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.programer.airline_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ROG
 */
public class UserTravelRecords extends javax.swing.JInternalFrame {

    /**
     * Creates new form UserTravelRecords
     */
    static String uId= "";
    public UserTravelRecords() {
        initComponents();
        autoShowUsers(uId);
    }
    public UserTravelRecords(String uId){
        this.uId = uId;
    }
    Connection con;
    PreparedStatement pre;
    public void autoShowUsers(String cId){
        try {
            int cc;
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbPath = "jdbc:mysql://localhost:3306/airlinedb?useSSL=false";
            String dbUser ="root";
            String dbPass = "sysadm!n123";
            con = (Connection)DriverManager.getConnection(dbPath,dbUser,dbPass);
            java.sql.Statement s = con.createStatement();
            String sql = "select flight.FlightName, ticket.Arrival, ticket.Departure,\n" +
            "ticket.DOB, ticket.Seats, ticket.Amount from flight \n" +
            "inner join ticket on ticket.FlightId = flight.FlightId where CustomerId=? Order by ticket.DOB";
            pre = con.prepareStatement(sql);           
            pre.setString(1,cId);
            ResultSet rs = pre.executeQuery();
            ResultSetMetaData RSMD = rs.getMetaData();
            cc = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel)jTable1.getModel();
            DFT.setRowCount(0);
            while(rs.next()){
                
                Vector v2 = new Vector();
                for(int i = 1; i <= cc; i++){
                    v2.add(rs.getString("FlightName"));
                    v2.add(rs.getString("Arrival"));
                    v2.add(rs.getString("Departure"));
                    v2.add(rs.getString("DOB"));
                    v2.add(rs.getString("Seats"));
                    v2.add(rs.getString("Amount"));
                }
                DFT.addRow(v2);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserTravelRecords.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserTravelRecords.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setName("History"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(153, 153, 255));
        jTable1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Flight Name", "Arrival", "Departure", "Date", "Seats", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Travel  History");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(6, 6, 6, 6, new java.awt.Color(204, 204, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(114, 114, 114))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
