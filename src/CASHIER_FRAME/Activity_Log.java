/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CASHIER_FRAME;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author joeya
 */
public class Activity_Log extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Activity_Log.class.getName());
    private String currentUsername;
    /**
     * Creates new form Activity_Log
     */
    
    public Activity_Log() {
        initComponents();
        
        btnSEARCH.setVisible(false);
        btnCLEAR.setVisible(false);
        

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Username", "Action", "Timestamp"}, 0);
        jTable1.setModel(model);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");
            String sql = "SELECT * FROM activity_logs ORDER BY timestamp DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("action"),
                    rs.getTimestamp("timestamp")
                });
            }
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        btnCLEAR.setVisible(false);
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
                String text = txtSEARCH.getText().trim();
                boolean hasText = !text.isEmpty();

                btnSEARCH.setVisible(hasText);
                btnCLEAR.setVisible(hasText);
            }
        });

    }
    
    
    
    
    public Activity_Log(String username) {
        initComponents();
        this.currentUsername = username;
        startClock(lblDATE, lblTIME);
        loadActivityLogs();
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
    
    public void logActivity(String username, String action) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");
            String sql = "INSERT INTO activity_logs (username, action) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, action);
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadActivityLogs() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");
            String sql = "SELECT * FROM activity_logs ORDER BY timestamp DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                String action = rs.getString("action");
                String time = rs.getString("timestamp");
                model.addRow(new Object[]{id, username, action, time});
            }

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnHOME = new javax.swing.JButton();
        btnUSERMANAGEMENT = new javax.swing.JButton();
        btnACTIVITYLOG = new javax.swing.JButton();
        btnSALESREPORT = new javax.swing.JButton();
        btnCLEAR = new javax.swing.JButton();
        txtSEARCH = new javax.swing.JTextField();
        btnSEARCH = new javax.swing.JButton();
        btnPRINT = new javax.swing.JButton();
        btnCLEARACTIVITY = new javax.swing.JButton();
        btnLOGOUT = new javax.swing.JButton();
        lblTIME = new javax.swing.JLabel();
        lblDATE = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setForeground(new java.awt.Color(59, 105, 133));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NO.", "USER", "ACTION", "TIMESTAMP"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 840, 550));

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

        btnCLEAR.setText("X");
        btnCLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLEARActionPerformed(evt);
            }
        });
        getContentPane().add(btnCLEAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 40, 40));

        txtSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSEARCHActionPerformed(evt);
            }
        });
        getContentPane().add(txtSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 340, 40));

        btnSEARCH.setText("SEARCH");
        btnSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEARCHActionPerformed(evt);
            }
        });
        getContentPane().add(btnSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 110, 90, 40));

        btnPRINT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPRINT.setForeground(new java.awt.Color(59, 105, 133));
        btnPRINT.setText("PRINT");
        btnPRINT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnPRINT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRINTActionPerformed(evt);
            }
        });
        getContentPane().add(btnPRINT, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 720, 90, 60));

        btnCLEARACTIVITY.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCLEARACTIVITY.setForeground(new java.awt.Color(59, 105, 133));
        btnCLEARACTIVITY.setText("CLEAR");
        btnCLEARACTIVITY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnCLEARACTIVITY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLEARACTIVITYActionPerformed(evt);
            }
        });
        getContentPane().add(btnCLEARACTIVITY, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 720, 90, 60));

        btnLOGOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Z/LOGINPICTURES/1.png"))); // NOI18N
        btnLOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGOUTActionPerformed(evt);
            }
        });
        getContentPane().add(btnLOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 740, 50, 50));

        lblTIME.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTIME.setForeground(new java.awt.Color(59, 105, 133));
        lblTIME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblTIME, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 170, 30));

        lblDATE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDATE.setForeground(new java.awt.Color(59, 105, 133));
        lblDATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, 300, 30));

        jLabel5.setText("Log out");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 760, 60, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Z/ADMIN/ADMINFRAME.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEARCHActionPerformed
        // TODO add your handling code here:
        String query = txtSEARCH.getText().trim().toLowerCase();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        if (!query.isEmpty()) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));

            if (sorter.getViewRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No logs found.", "Search", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSEARCHActionPerformed

    private void btnCLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLEARActionPerformed
        // TODO add your handling code here:
        txtSEARCH.setText("");        

        // Reset table filter
        TableRowSorter<?> sorter = (TableRowSorter<?>) jTable1.getRowSorter();
        if (sorter != null) {
            sorter.setRowFilter(null);
        }
    }//GEN-LAST:event_btnCLEARActionPerformed

    private void btnPRINTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRINTActionPerformed
        // TODO add your handling code here:
        try {
            // Format the current date and time
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy - hh:mm a");

            // Create header and footer
            MessageFormat header = new MessageFormat("Activity Logs - Printed on " + sdf.format(now));
            MessageFormat footer = new MessageFormat("Page {0}");

            // Print with header and footer
            boolean complete = jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);

            if (complete) {
                JOptionPane.showMessageDialog(null, "Print successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Printing canceled.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error printing: " + e.getMessage());
        }
    }//GEN-LAST:event_btnPRINTActionPerformed

    private void btnCLEARACTIVITYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLEARACTIVITYActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear all activity logs?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123");
                String sql = "DELETE FROM activity_logs";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.executeUpdate();
                pst.close();
                con.close();

                // Refresh the table
                loadActivityLogs();
                JOptionPane.showMessageDialog(null, "All activity logs have been cleared.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnCLEARACTIVITYActionPerformed

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

    private void txtSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSEARCHActionPerformed
        // TODO add your handling code here:
        JButton btnSEARCH = new JButton("Enter");
        JButton btnCLEAR = new JButton("Clear");
    }//GEN-LAST:event_txtSEARCHActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Activity_Log().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnACTIVITYLOG;
    private javax.swing.JButton btnCLEAR;
    private javax.swing.JButton btnCLEARACTIVITY;
    private javax.swing.JButton btnHOME;
    private javax.swing.JButton btnLOGOUT;
    private javax.swing.JButton btnPRINT;
    private javax.swing.JButton btnSALESREPORT;
    private javax.swing.JButton btnSEARCH;
    private javax.swing.JButton btnUSERMANAGEMENT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDATE;
    private javax.swing.JLabel lblTIME;
    private javax.swing.JTextField txtSEARCH;
    // End of variables declaration//GEN-END:variables
}
