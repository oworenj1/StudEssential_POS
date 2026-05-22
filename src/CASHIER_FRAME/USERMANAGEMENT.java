/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CASHIER_FRAME;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author joeya
 */
public class USERMANAGEMENT extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(USERMANAGEMENT.class.getName());
    private String currentUsername;
    /**
     * Creates new form USERMANAGEMENT
     */
    
 
    public USERMANAGEMENT() {
        initComponents();               
        txtID.setEnabled(false);

        //==================================================
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"ID", "Surname", "First Name", "Email", "Username", "Password", "Role"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5 || column == 6; // Only password and role can be edited
            }
        };

        jTable1.setModel(model);

        
        //=========================================================================================
        // Load data into table
        btnCLEARSEARCH.setVisible(false);
        btnSEARCH.setVisible(false);
        loadUsersIntoTable();       
        txtSEARCH.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                toggleSearchButtons();
            }

            public void removeUpdate(DocumentEvent e) {
                toggleSearchButtons();
            }

            public void changedUpdate(DocumentEvent e) {
                toggleSearchButtons();
            }

            private void toggleSearchButtons() {
                boolean hasText = !txtSEARCH.getText().trim().isEmpty();
                btnSEARCH.setVisible(hasText);
                btnCLEARSEARCH.setVisible(hasText);
            }
        });
   
    }
    
    private void startClock(JLabel lblDate, JLabel lblTime) {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
                lblTime.setText(timeFormat.format(now));
                lblDate.setText(dateFormat.format(now));
            }
        });
        timer.start();
    }

    
    public USERMANAGEMENT(String username) {
        initComponents();
        this.currentUsername = username;
        startClock(lblDATE, lblTIME);
        loadUsersIntoTable(); 
    }
    

    private void logActivity(String username, String action) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");
            String sql = "INSERT INTO activity_logs (username, action, timestamp) VALUES (?, ?, NOW())";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, action);
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to log activity: " + e.getMessage());
        }
    }

    private void loadUsersIntoTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");
            String sql = "SELECT * FROM users";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = new DefaultTableModel(
                    new String[]{"ID", "Surname", "First Name", "Email", "Username", "Password", "Role"}, 0
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 5 || column == 6;
                }
            };
            jTable1.setModel(model);
            model.setRowCount(0); // Clear table

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("surname"),
                    rs.getString("firstname"),
                    rs.getString("email"),
                    rs.getString("username"),
                    "********", 
                    rs.getString("role")
                });
            }

            rs.close();
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    private void saveChangesFromTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                int id = (int) jTable1.getValueAt(i, 0);
                String password = jTable1.getValueAt(i, 5).toString();
                String role = jTable1.getValueAt(i, 6).toString();

                String sql = "UPDATE users SET password = ?, role = ? WHERE id = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, password);
                pst.setString(2, role);
                pst.setInt(3, id);
                pst.executeUpdate();
                pst.close();
            }

            con.close();
            JOptionPane.showMessageDialog(null, "Changes saved successfully!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void filterTable(String query) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        if (query.trim().isEmpty()) {
            // Clear the filter (show all accounts)
            sorter.setRowFilter(null);
        } else {
            RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter("(?i)" + query);
            sorter.setRowFilter(rf);

            // Show alert only if no matching results
            if (sorter.getViewRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No user or account found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                txtSEARCH.setText("");
                sorter.setRowFilter(null); // Reset to show all again
            }
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

        aDMIN1 = new CASHIER_FRAME.ADMIN();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btnHOME = new javax.swing.JButton();
        btnUSERMANAGEMENT = new javax.swing.JButton();
        btnACTIVITYLOG = new javax.swing.JButton();
        btnSALESREPORT = new javax.swing.JButton();
        txtSURNAME = new javax.swing.JTextField();
        txtFIRSTNAME = new javax.swing.JTextField();
        txtEMAIL = new javax.swing.JTextField();
        txtUSERNAME = new javax.swing.JTextField();
        txtPASSWORD = new javax.swing.JPasswordField();
        txtCONFIRMPASS = new javax.swing.JPasswordField();
        rbADMIN = new javax.swing.JRadioButton();
        rbCASHIER = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnREMOVE = new javax.swing.JButton();
        btnADD = new javax.swing.JButton();
        btnEDIT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbSHOWPASS = new javax.swing.JCheckBox();
        btnCLEARSEARCH = new javax.swing.JButton();
        txtSEARCH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnSEARCH = new javax.swing.JButton();
        btnCLEAR = new javax.swing.JButton();
        btnLOGOUT = new javax.swing.JButton();
        lblDATE = new javax.swing.JLabel();
        lblTIME = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHOME.setBackground(new java.awt.Color(59, 105, 133));
        btnHOME.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHOME.setForeground(new java.awt.Color(255, 255, 255));
        btnHOME.setText("HOME");
        btnHOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHOMEActionPerformed(evt);
            }
        });
        getContentPane().add(btnHOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 230, 70));

        btnUSERMANAGEMENT.setBackground(new java.awt.Color(59, 105, 133));
        btnUSERMANAGEMENT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUSERMANAGEMENT.setForeground(new java.awt.Color(255, 255, 255));
        btnUSERMANAGEMENT.setText("USER MANAGEMENT");
        btnUSERMANAGEMENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUSERMANAGEMENTActionPerformed(evt);
            }
        });
        getContentPane().add(btnUSERMANAGEMENT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 230, 70));

        btnACTIVITYLOG.setBackground(new java.awt.Color(59, 105, 133));
        btnACTIVITYLOG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnACTIVITYLOG.setForeground(new java.awt.Color(255, 255, 255));
        btnACTIVITYLOG.setText("ACTIVITY LOG");
        btnACTIVITYLOG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnACTIVITYLOGActionPerformed(evt);
            }
        });
        getContentPane().add(btnACTIVITYLOG, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 230, 70));

        btnSALESREPORT.setBackground(new java.awt.Color(59, 105, 133));
        btnSALESREPORT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSALESREPORT.setForeground(new java.awt.Color(255, 255, 255));
        btnSALESREPORT.setText("SALES REPORT");
        btnSALESREPORT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSALESREPORTActionPerformed(evt);
            }
        });
        getContentPane().add(btnSALESREPORT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 230, 70));

        txtSURNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSURNAMEActionPerformed(evt);
            }
        });
        getContentPane().add(txtSURNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 190, 42));
        getContentPane().add(txtFIRSTNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 190, 42));
        getContentPane().add(txtEMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 190, 42));
        getContentPane().add(txtUSERNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 190, 42));
        getContentPane().add(txtPASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, 190, 42));
        getContentPane().add(txtCONFIRMPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 190, 42));

        buttonGroup1.add(rbADMIN);
        rbADMIN.setText("ADMIN");
        getContentPane().add(rbADMIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 190, 98, -1));

        buttonGroup1.add(rbCASHIER);
        rbCASHIER.setText("CASHIER");
        getContentPane().add(rbCASHIER, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 230, 98, -1));

        jTable1.setForeground(new java.awt.Color(59, 105, 133));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "SURNAME", "FIRST NAME", "EMAIL", "USERNAME", "PASSWORD", "ROLE"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 370, 850, 350));

        btnREMOVE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnREMOVE.setForeground(new java.awt.Color(59, 105, 133));
        btnREMOVE.setText("REMOVE");
        btnREMOVE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnREMOVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREMOVEActionPerformed(evt);
            }
        });
        getContentPane().add(btnREMOVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 730, 95, 60));

        btnADD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnADD.setForeground(new java.awt.Color(59, 105, 133));
        btnADD.setText("ADD");
        btnADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        getContentPane().add(btnADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 730, 95, 60));

        btnEDIT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEDIT.setForeground(new java.awt.Color(59, 105, 133));
        btnEDIT.setText("SAVE");
        btnEDIT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEDITActionPerformed(evt);
            }
        });
        getContentPane().add(btnEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 730, 95, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(59, 105, 133));
        jLabel1.setText("FIRST  NAME");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 82, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(59, 105, 133));
        jLabel2.setText("EMAIL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 82, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(59, 105, 133));
        jLabel3.setText("SURNAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 82, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(59, 105, 133));
        jLabel4.setText("PASSWORD");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 82, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(59, 105, 133));
        jLabel5.setText("CONFIRM PASS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 240, -1, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(59, 105, 133));
        jLabel6.setText("ROLE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 160, 80, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(59, 105, 133));
        jLabel7.setText("USERNAME");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 82, -1));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 155, 34));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(59, 105, 133));
        jLabel8.setText("ID:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 37, -1));

        cbSHOWPASS.setText("show password");
        cbSHOWPASS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSHOWPASSActionPerformed(evt);
            }
        });
        getContentPane().add(cbSHOWPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, -1, -1));

        btnCLEARSEARCH.setText("X");
        btnCLEARSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLEARSEARCHActionPerformed(evt);
            }
        });
        getContentPane().add(btnCLEARSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 330, 40, 30));
        getContentPane().add(txtSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 320, 30));

        jLabel9.setText("SEARCH");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 60, 30));

        btnSEARCH.setText("search");
        btnSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEARCHActionPerformed(evt);
            }
        });
        getContentPane().add(btnSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 330, -1, 30));

        btnCLEAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCLEAR.setForeground(new java.awt.Color(59, 105, 133));
        btnCLEAR.setText("CLEAR");
        btnCLEAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnCLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLEARActionPerformed(evt);
            }
        });
        getContentPane().add(btnCLEAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 730, 95, 60));

        btnLOGOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Z/LOGINPICTURES/1.png"))); // NOI18N
        btnLOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGOUTActionPerformed(evt);
            }
        });
        getContentPane().add(btnLOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 740, 50, 50));

        lblDATE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDATE.setForeground(new java.awt.Color(59, 105, 133));
        lblDATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 370, 30));

        lblTIME.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTIME.setForeground(new java.awt.Color(59, 105, 133));
        lblTIME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblTIME, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 170, 30));

        jLabel11.setText("Log out");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 760, 60, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Z/ADMIN/ADMINFRAME.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        // TODO add your handling code here:
        String surname = txtSURNAME.getText();
        String firstname = txtFIRSTNAME.getText();
        String email = txtEMAIL.getText();
        String username = txtUSERNAME.getText();
        String password = new String(txtPASSWORD.getPassword());
        String confirmPass = new String(txtCONFIRMPASS.getPassword());
        String role = rbADMIN.isSelected() ? "admin" : rbCASHIER.isSelected() ? "cashier" : "";

        if (surname.isEmpty() || firstname.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPass.isEmpty() || role.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields and select a role.");
            return;
        }

        if (!password.equals(confirmPass)) {
            JOptionPane.showMessageDialog(null, "Password and Confirm Password do not match.");
            return;
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");

            String checkUser = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstCheck = con.prepareStatement(checkUser);
            pstCheck.setString(1, username);
            ResultSet rsCheck = pstCheck.executeQuery();

            if (rsCheck.next()) {
                JOptionPane.showMessageDialog(null, "Username already exists. Please choose another.");
                rsCheck.close();
                pstCheck.close();
                con.close();
                return;
            }
            rsCheck.close();
            pstCheck.close();

            String sql = "INSERT INTO users (surname, firstname, email, username, password, role) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, surname);
            pst.setString(2, firstname);
            pst.setString(3, email);
            pst.setString(4, username);
            pst.setString(5, password);
            pst.setString(6, role);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Account created successfully!");
                loadUsersIntoTable(); // Make sure this method exists
                txtSURNAME.setText("");
                txtFIRSTNAME.setText("");
                txtEMAIL.setText("");
                txtUSERNAME.setText("");
                txtPASSWORD.setText("");
                txtCONFIRMPASS.setText("");
                rbADMIN.setSelected(false);
                rbCASHIER.setSelected(false);
            }

            pst.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnADDActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            txtID.setText(jTable1.getValueAt(selectedRow, 0).toString());
            txtSURNAME.setText(jTable1.getValueAt(selectedRow, 1).toString());
            txtFIRSTNAME.setText(jTable1.getValueAt(selectedRow, 2).toString());
            txtEMAIL.setText(jTable1.getValueAt(selectedRow, 3).toString());
            txtUSERNAME.setText(jTable1.getValueAt(selectedRow, 4).toString());

            // Load real password from database
            try {
                String id = jTable1.getValueAt(selectedRow, 0).toString();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");
                String sql = "SELECT password FROM users WHERE id = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String realPassword = rs.getString("password");
                    txtPASSWORD.setText(realPassword);
                    txtCONFIRMPASS.setText(realPassword);
                }

                rs.close();
                pst.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failed to load password: " + e.getMessage());
            }

            // Set the role radio buttons
            String role = jTable1.getValueAt(selectedRow, 6).toString();
            if (role.equalsIgnoreCase("admin")) {
                rbADMIN.setSelected(true);
            } else if (role.equalsIgnoreCase("cashier")) {
                rbCASHIER.setSelected(true);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDITActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to update.");
            return;
        }

        String id = jTable1.getValueAt(selectedRow, 0).toString();
        String surname = txtSURNAME.getText();
        String firstname = txtFIRSTNAME.getText();
        String email = txtEMAIL.getText();
        String username = txtUSERNAME.getText();
        String role = rbADMIN.isSelected() ? "admin" : rbCASHIER.isSelected() ? "cashier" : "";

        String password = txtPASSWORD.getText().trim();
        String confirmPassword = txtCONFIRMPASS.getText().trim();

        if (surname.isEmpty() || firstname.isEmpty() || email.isEmpty() || username.isEmpty() || role.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields and select a role.");
            return;
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");

            String sql;
            PreparedStatement pst;

            // 🔐 Handle password update only if new password is typed
            if (!password.isEmpty() || !confirmPassword.isEmpty()) {
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.");
                    return;
                }

                sql = "UPDATE users SET surname = ?, firstname = ?, email = ?, username = ?, password = ?, role = ? WHERE id = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, surname);
                pst.setString(2, firstname);
                pst.setString(3, email);
                pst.setString(4, username);
                pst.setString(5, password);
                pst.setString(6, role);
                pst.setString(7, id);
            } else {
                sql = "UPDATE users SET surname = ?, firstname = ?, email = ?, username = ?, role = ? WHERE id = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, surname);
                pst.setString(2, firstname);
                pst.setString(3, email);
                pst.setString(4, username);
                pst.setString(5, role);
                pst.setString(6, id);
            }

            int updated = pst.executeUpdate();

            if (updated > 0) {
                JOptionPane.showMessageDialog(null, "Account updated successfully!");
                loadUsersIntoTable();
            }

            pst.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnEDITActionPerformed

    private void btnREMOVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREMOVEActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            return;
        }

        String id = jTable1.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");

                String sql = "DELETE FROM users WHERE id = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, id);

                int deleted = pst.executeUpdate();

                if (deleted > 0) {
                    JOptionPane.showMessageDialog(null, "Account deleted successfully!");
                    loadUsersIntoTable();
                }

                pst.close();
                con.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnREMOVEActionPerformed

    private void cbSHOWPASSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSHOWPASSActionPerformed
        // TODO add your handling code here:
        if (cbSHOWPASS.isSelected()) {
            txtPASSWORD.setEchoChar((char) 0);
            txtCONFIRMPASS.setEchoChar((char) 0);
        } else {
            txtPASSWORD.setEchoChar('*');
            txtCONFIRMPASS.setEchoChar('*');
        }
    }//GEN-LAST:event_cbSHOWPASSActionPerformed

    private void btnSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEARCHActionPerformed
        // TODO add your handling code here:
        String query = txtSEARCH.getText().trim();
        if (!query.isEmpty()) {
            filterTable(query);
        }
    }//GEN-LAST:event_btnSEARCHActionPerformed

    private void btnCLEARSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLEARSEARCHActionPerformed
        // TODO add your handling code here:
        txtSEARCH.setText("");
        filterTable(""); // Reset to show all data
        
    }//GEN-LAST:event_btnCLEARSEARCHActionPerformed

    private void btnCLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLEARActionPerformed
        // TODO add your handling code here:
        txtID.setText("");
        txtSURNAME.setText("");
        txtFIRSTNAME.setText("");
        txtEMAIL.setText("");
        txtUSERNAME.setText("");
        txtPASSWORD.setText("");
        txtCONFIRMPASS.setText("");
        rbADMIN.setSelected(false);
        rbCASHIER.setSelected(false);
        jTable1.clearSelection();
    }//GEN-LAST:event_btnCLEARActionPerformed

    private void btnHOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHOMEActionPerformed
        // TODO add your handling code here:
        ADMIN admin = new ADMIN(currentUsername);
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHOMEActionPerformed

    private void btnUSERMANAGEMENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUSERMANAGEMENTActionPerformed
        // TODO add your handling code here:
        new USERMANAGEMENT(currentUsername).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUSERMANAGEMENTActionPerformed

    private void btnACTIVITYLOGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnACTIVITYLOGActionPerformed
        // TODO add your handling code here:
        Activity_Log logs = new Activity_Log(currentUsername);
        logs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnACTIVITYLOGActionPerformed

    private void btnSALESREPORTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSALESREPORTActionPerformed
        // TODO add your handling code here:
        SalesReport report = new SalesReport(currentUsername);
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSALESREPORTActionPerformed

    private void btnLOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOGOUTActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to logout?",
            "Logout Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {

            logActivity(currentUsername, "Logged out");
            Login_Frame login = new Login_Frame();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLOGOUTActionPerformed

    private void txtSURNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSURNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSURNAMEActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new USERMANAGEMENT().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CASHIER_FRAME.ADMIN aDMIN1;
    private javax.swing.JButton btnACTIVITYLOG;
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnCLEAR;
    private javax.swing.JButton btnCLEARSEARCH;
    private javax.swing.JButton btnEDIT;
    private javax.swing.JButton btnHOME;
    private javax.swing.JButton btnLOGOUT;
    private javax.swing.JButton btnREMOVE;
    private javax.swing.JButton btnSALESREPORT;
    private javax.swing.JButton btnSEARCH;
    private javax.swing.JButton btnUSERMANAGEMENT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbSHOWPASS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDATE;
    private javax.swing.JLabel lblTIME;
    private javax.swing.JRadioButton rbADMIN;
    private javax.swing.JRadioButton rbCASHIER;
    private javax.swing.JPasswordField txtCONFIRMPASS;
    private javax.swing.JTextField txtEMAIL;
    private javax.swing.JTextField txtFIRSTNAME;
    private javax.swing.JTextField txtID;
    private javax.swing.JPasswordField txtPASSWORD;
    private javax.swing.JTextField txtSEARCH;
    private javax.swing.JTextField txtSURNAME;
    private javax.swing.JTextField txtUSERNAME;
    // End of variables declaration//GEN-END:variables
}
