/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CASHIER_FRAME;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.sound.sampled.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author joeya
 */

public class POS extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(POS.class.getName());
    private javax.swing.JTextField activePaymentField;
    private boolean foundMatch = false;
    private String currentUsername;



    /**
     * Creates new form POS
     */
    public POS() {
        initComponents();
        startClock(lblDATE, lblTIME);
        btnREFUND.setEnabled(false);
        txtGCASH.setEnabled(false);
        txtCASH.setEnabled(false);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
        
        
    //========================================== SCROLL BAR=========================================
        jScrollPane2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            @Override
                public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                JScrollBar bar = jScrollPane2.getVerticalScrollBar();

                int scrollAmount = (int)(evt.getUnitsToScroll() * 0.5 * bar.getUnitIncrement());

                int newValue = bar.getValue() + scrollAmount;

                newValue = Math.max(bar.getMinimum(), Math.min(bar.getMaximum(), newValue));
                bar.setValue(newValue);
            }
        });
        
        

    //==============================================PAYMENT METHOD===============================
        txtCASH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                activePaymentField = txtCASH;
            }
            
        });

        txtGCASH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                activePaymentField = txtGCASH;
            }
            
        });
        
        btnSEARCH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                filterProducts();  // Call your existing search logic
            }
        });
        
        btnCLEARSEARCH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtSEARCH.setText("");        // Clear the text field
                filterProducts();             // Reset product visibility
            }
            
        
        });
 
        
        
    //========================================= Bar Code ===================================================
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/FREE3OF9.TTF");
            Font barcodeFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(140f);
            lblBARCODE.setFont(barcodeFont);
        }   
        
            catch (Exception e) {
            e.printStackTrace();
            }


    //=========================================  CLEAR FOR SEARCH BAR ==============================================   
    btnCLEARSEARCH.setVisible(false); // hide it initially

    txtSEARCH.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                toggleClearButton();
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                toggleClearButton();
            }

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                toggleClearButton();
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

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paymentMethod = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnDOT = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnCLEAR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        btnRESET = new javax.swing.JButton();
        btnPAY = new javax.swing.JButton();
        btnREMOVE = new javax.swing.JButton();
        btnPRINT = new javax.swing.JButton();
        btnREFUND = new javax.swing.JButton();
        btnCompleteSale = new javax.swing.JButton();
        btmEXIT = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCASH = new javax.swing.JTextField();
        txtCHANGE = new javax.swing.JTextField();
        txtGCASH = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rbCASH = new javax.swing.JRadioButton();
        rbGCASH = new javax.swing.JRadioButton();
        rbSPLIT = new javax.swing.JRadioButton();
        JTabbedPane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jButton77 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jButton79 = new javax.swing.JButton();
        jButton80 = new javax.swing.JButton();
        jButton81 = new javax.swing.JButton();
        jButton82 = new javax.swing.JButton();
        jButton83 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jButton85 = new javax.swing.JButton();
        jButton86 = new javax.swing.JButton();
        jButton87 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnCONSTRUCTIONPAPER1 = new javax.swing.JButton();
        btnYELLOWPAPER1 = new javax.swing.JButton();
        btnINDEXCARD13 = new javax.swing.JButton();
        btnINDEXCARD15 = new javax.swing.JButton();
        btnSPIRALNOTEBOOk1 = new javax.swing.JButton();
        btnLONGBOND1 = new javax.swing.JButton();
        btnSHORTBOND1 = new javax.swing.JButton();
        btnGRAPHINGPAD1 = new javax.swing.JButton();
        btnINTERMEDIATEPAD1 = new javax.swing.JButton();
        btnCOLOREDPAPER1 = new javax.swing.JButton();
        Papers = new javax.swing.JPanel();
        btnCONSTRUCTIONPAPER = new javax.swing.JButton();
        btnYELLOWPAPER = new javax.swing.JButton();
        btnINDEXCARD12 = new javax.swing.JButton();
        btnINDEXCARD14 = new javax.swing.JButton();
        btnSPIRALNOTEBOOk = new javax.swing.JButton();
        btnLONGBOND = new javax.swing.JButton();
        btnSHORTBOND = new javax.swing.JButton();
        btnGRAPHINGPAD = new javax.swing.JButton();
        btnINTERMEDIATEPAD = new javax.swing.JButton();
        btnCOLOREDPAPER = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnGELPEN = new javax.swing.JButton();
        btnMONGOLPENCIL = new javax.swing.JButton();
        btnBALLPENBLACK = new javax.swing.JButton();
        btnBALLPENBLUE = new javax.swing.JButton();
        btnBALLPENRED = new javax.swing.JButton();
        btnWHITEBOARDMARKER = new javax.swing.JButton();
        btnHIGHLIGHTER = new javax.swing.JButton();
        btnTECHNICALPEN = new javax.swing.JButton();
        btnMECHANICALPENCIL = new javax.swing.JButton();
        btnPERMANENTMARKER = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnRULER12 = new javax.swing.JButton();
        btnSETSQUARE45 = new javax.swing.JButton();
        btnRULER6 = new javax.swing.JButton();
        btnPROTRACTOR = new javax.swing.JButton();
        btnCOMPASS = new javax.swing.JButton();
        btnSETSQUARE30 = new javax.swing.JButton();
        btnMEASURINGTAPE = new javax.swing.JButton();
        btnGEOMETRYSET = new javax.swing.JButton();
        btnTSQUARE = new javax.swing.JButton();
        btnSCIENTIFICCALCULATOR = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        btnGLUESTICK = new javax.swing.JButton();
        btnLIQUIDGLUE = new javax.swing.JButton();
        btnPASTE = new javax.swing.JButton();
        btnDOUBLESIDEDTAPE = new javax.swing.JButton();
        btnSCOTCHTAPESMALL = new javax.swing.JButton();
        btnSCOTCHTAPELARGE = new javax.swing.JButton();
        btnMASKINGTAPE = new javax.swing.JButton();
        btnCORRECTIONTAPE = new javax.swing.JButton();
        btnGLUEGUN = new javax.swing.JButton();
        btnSTICKYNOTES = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnPENCILCASE = new javax.swing.JButton();
        btnERASER = new javax.swing.JButton();
        btnSHARPENER = new javax.swing.JButton();
        btnIDLACE = new javax.swing.JButton();
        btnPLASTICCOVER = new javax.swing.JButton();
        btnNAMETAGHOLDER = new javax.swing.JButton();
        btnBINDERCLIPSSMALL = new javax.swing.JButton();
        btnSTAPLERNO10 = new javax.swing.JButton();
        btnPAPERCLIPS50s = new javax.swing.JButton();
        btnPUNCHERSINGLEHOLE = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTOTAL = new javax.swing.JTextField();
        txtSUBTOTAL = new javax.swing.JTextField();
        txtTAX = new javax.swing.JTextField();
        lblBARCODE = new javax.swing.JLabel();
        lblBARCODETEXT = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnCLEARSEARCH = new javax.swing.JButton();
        txtSEARCH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSEARCH = new javax.swing.JButton();
        lblTIME = new javax.swing.JLabel();
        lblDATE = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1450, 820));
        setMinimumSize(new java.awt.Dimension(1450, 820));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1450, 820));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(158, 219, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn1.setBackground(new java.awt.Color(26, 94, 134));
        btn1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("1");
        btn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 120));

        btn2.setBackground(new java.awt.Color(26, 94, 134));
        btn2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("2");
        btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, 120));

        btn3.setBackground(new java.awt.Color(26, 94, 134));
        btn3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("3");
        btn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 100, 120));

        btn4.setBackground(new java.awt.Color(26, 94, 134));
        btn4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("4");
        btn4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 120));

        btn5.setBackground(new java.awt.Color(26, 94, 134));
        btn5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("5");
        btn5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 100, 120));

        btn6.setBackground(new java.awt.Color(26, 94, 134));
        btn6.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("6");
        btn6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 100, 120));

        btn7.setBackground(new java.awt.Color(26, 94, 134));
        btn7.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setText("7");
        btn7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel1.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 100, 120));

        btn8.setBackground(new java.awt.Color(26, 94, 134));
        btn8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setText("8");
        btn8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel1.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 100, 120));

        btn9.setBackground(new java.awt.Color(26, 94, 134));
        btn9.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setText("9");
        btn9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel1.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 100, 120));

        btnDOT.setBackground(new java.awt.Color(26, 94, 134));
        btnDOT.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btnDOT.setForeground(new java.awt.Color(255, 255, 255));
        btnDOT.setText(".");
        btnDOT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btnDOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDOTActionPerformed(evt);
            }
        });
        jPanel1.add(btnDOT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, 120));

        btn0.setBackground(new java.awt.Color(26, 94, 134));
        btn0.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btn0.setForeground(new java.awt.Color(255, 255, 255));
        btn0.setText("0");
        btn0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel1.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 100, 120));

        btnCLEAR.setBackground(new java.awt.Color(26, 94, 134));
        btnCLEAR.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btnCLEAR.setForeground(new java.awt.Color(255, 255, 255));
        btnCLEAR.setText("C");
        btnCLEAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btnCLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLEARActionPerformed(evt);
            }
        });
        jPanel1.add(btnCLEAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 100, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 320, 520));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "QUANTITY", "AMOUNT"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 390, 420));

        jPanel9.setBackground(new java.awt.Color(158, 219, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 5));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRESET.setBackground(new java.awt.Color(173, 181, 189));
        btnRESET.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRESET.setForeground(new java.awt.Color(255, 255, 255));
        btnRESET.setText("RESET");
        btnRESET.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRESETActionPerformed(evt);
            }
        });
        jPanel9.add(btnRESET, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 190, 90));

        btnPAY.setBackground(new java.awt.Color(40, 167, 69));
        btnPAY.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnPAY.setForeground(new java.awt.Color(255, 255, 255));
        btnPAY.setText("PAY");
        btnPAY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnPAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPAYActionPerformed(evt);
            }
        });
        jPanel9.add(btnPAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 90));

        btnREMOVE.setBackground(new java.awt.Color(220, 53, 69));
        btnREMOVE.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnREMOVE.setForeground(new java.awt.Color(255, 255, 255));
        btnREMOVE.setText("REMOVE");
        btnREMOVE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnREMOVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREMOVEActionPerformed(evt);
            }
        });
        jPanel9.add(btnREMOVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 190, 90));

        btnPRINT.setBackground(new java.awt.Color(108, 117, 125));
        btnPRINT.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnPRINT.setForeground(new java.awt.Color(255, 255, 255));
        btnPRINT.setText("PRINT");
        btnPRINT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnPRINT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRINTActionPerformed(evt);
            }
        });
        jPanel9.add(btnPRINT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 190, 90));

        btnREFUND.setBackground(new java.awt.Color(253, 126, 20));
        btnREFUND.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnREFUND.setForeground(new java.awt.Color(255, 255, 255));
        btnREFUND.setText("REFUND");
        btnREFUND.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnREFUND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREFUNDActionPerformed(evt);
            }
        });
        jPanel9.add(btnREFUND, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 190, 90));

        btnCompleteSale.setBackground(new java.awt.Color(0, 123, 255));
        btnCompleteSale.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCompleteSale.setForeground(new java.awt.Color(255, 255, 255));
        btnCompleteSale.setText("CHECKOUT");
        btnCompleteSale.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 4));
        btnCompleteSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteSaleActionPerformed(evt);
            }
        });
        jPanel9.add(btnCompleteSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 190, 90));

        btmEXIT.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        btmEXIT.setText("LOG OUT");
        btmEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmEXITActionPerformed(evt);
            }
        });
        jPanel9.add(btmEXIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 70, 30));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 580, 690, 230));

        jPanel8.setBackground(new java.awt.Color(158, 219, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 5));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(26, 94, 134));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("PAYMENT METHOD");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 140, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(26, 94, 134));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("CASH:");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(26, 94, 134));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("CHANGE");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 90, 40));

        txtCASH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCASH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCASHActionPerformed(evt);
            }
        });
        jPanel8.add(txtCASH, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 250, 40));

        txtCHANGE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel8.add(txtCHANGE, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 210, 40));

        txtGCASH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtGCASH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGCASHActionPerformed(evt);
            }
        });
        jPanel8.add(txtGCASH, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 250, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(26, 94, 134));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Gcash:");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 150, 40));

        paymentMethod.add(rbCASH);
        rbCASH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbCASH.setForeground(new java.awt.Color(26, 94, 134));
        rbCASH.setText("Cash");
        rbCASH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCASHActionPerformed(evt);
            }
        });
        jPanel8.add(rbCASH, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        paymentMethod.add(rbGCASH);
        rbGCASH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbGCASH.setForeground(new java.awt.Color(26, 94, 134));
        rbGCASH.setText("Gcash");
        rbGCASH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGCASHActionPerformed(evt);
            }
        });
        jPanel8.add(rbGCASH, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        paymentMethod.add(rbSPLIT);
        rbSPLIT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbSPLIT.setForeground(new java.awt.Color(26, 94, 134));
        rbSPLIT.setText("Split");
        rbSPLIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSPLITActionPerformed(evt);
            }
        });
        jPanel8.add(rbSPLIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 320, 260));

        JTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        JTabbedPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 5));
        JTabbedPane.setForeground(new java.awt.Color(59, 105, 133));
        JTabbedPane.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane2MouseWheelMoved(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMinimumSize(new java.awt.Dimension(560, 1700));
        jPanel6.setPreferredSize(new java.awt.Dimension(580, 1700));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setBackground(new java.awt.Color(59, 105, 133));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("<html>GEL PEN<br>15 Php</html>");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 140, 130));

        jButton50.setBackground(new java.awt.Color(59, 105, 133));
        jButton50.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton50.setForeground(new java.awt.Color(255, 255, 255));
        jButton50.setText("<html>BALLPEN (RED)<br>8 Php</html>");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 140, 130));

        jButton51.setBackground(new java.awt.Color(59, 105, 133));
        jButton51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton51.setForeground(new java.awt.Color(255, 255, 255));
        jButton51.setText("<html>BALLPEN (BLUE)<br>8 Php</html>");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 140, 130));

        jButton52.setBackground(new java.awt.Color(59, 105, 133));
        jButton52.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton52.setForeground(new java.awt.Color(255, 255, 255));
        jButton52.setText("<html>BALLPEN (BLACK)<br>8 Php</html>");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 140, 130));

        jButton53.setBackground(new java.awt.Color(59, 105, 133));
        jButton53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton53.setForeground(new java.awt.Color(255, 255, 255));
        jButton53.setText("<html>MONGOL PENCIL #2<br>10 Php</html>");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 140, 130));

        jButton54.setBackground(new java.awt.Color(59, 105, 133));
        jButton54.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton54.setForeground(new java.awt.Color(255, 255, 255));
        jButton54.setText("<html>WHITEBOARD MARKER<br>25 Php</html>");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 140, 130));

        jButton55.setBackground(new java.awt.Color(59, 105, 133));
        jButton55.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton55.setForeground(new java.awt.Color(255, 255, 255));
        jButton55.setText("<html>HIGHLIGHTER<br>20 Php</html>");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 140, 130));

        jButton56.setBackground(new java.awt.Color(59, 105, 133));
        jButton56.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton56.setForeground(new java.awt.Color(255, 255, 255));
        jButton56.setText("<html>MECHANICAL PENCIL<br>30 Php</html>");
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 140, 130));

        jButton7.setBackground(new java.awt.Color(59, 105, 133));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("<html>PENTEL PEN<br>30 Php</html>");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 140, 130));

        jButton57.setBackground(new java.awt.Color(59, 105, 133));
        jButton57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton57.setForeground(new java.awt.Color(255, 255, 255));
        jButton57.setText("<html>TECHNICAL PEN<br>60 Php</html>");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 140, 130));

        jButton58.setBackground(new java.awt.Color(59, 105, 133));
        jButton58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton58.setForeground(new java.awt.Color(255, 255, 255));
        jButton58.setText("<html>SET SQUARE 45°<br>20 Php</html>");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 790, 140, 130));

        jButton59.setBackground(new java.awt.Color(59, 105, 133));
        jButton59.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton59.setForeground(new java.awt.Color(255, 255, 255));
        jButton59.setText("<html>COMPASS<br>30 Php</html>");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton59, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 660, 140, 130));

        jButton60.setBackground(new java.awt.Color(59, 105, 133));
        jButton60.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton60.setForeground(new java.awt.Color(255, 255, 255));
        jButton60.setText("<html>PROTRACTOR<br>12 Php</html>");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton60, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 660, 140, 130));

        jButton61.setBackground(new java.awt.Color(59, 105, 133));
        jButton61.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton61.setForeground(new java.awt.Color(255, 255, 255));
        jButton61.setText("<html>RULER 12 INCH<br>15 Php</html>");
        jButton61.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 660, 140, 130));

        jButton62.setBackground(new java.awt.Color(59, 105, 133));
        jButton62.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton62.setForeground(new java.awt.Color(255, 255, 255));
        jButton62.setText("<html>RULER 6 INCH<br>10 Php</html>");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 140, 130));

        jButton63.setBackground(new java.awt.Color(59, 105, 133));
        jButton63.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton63.setForeground(new java.awt.Color(255, 255, 255));
        jButton63.setText("<html>SET SQUARE 30°/60°<br>20 Php</html>");
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 790, 140, 130));

        jButton64.setBackground(new java.awt.Color(59, 105, 133));
        jButton64.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton64.setForeground(new java.awt.Color(255, 255, 255));
        jButton64.setText("<html>MEASURING TAPE 1M<br>35 Php</html>");
        jButton64.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 790, 140, 130));

        jButton65.setBackground(new java.awt.Color(59, 105, 133));
        jButton65.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton65.setForeground(new java.awt.Color(255, 255, 255));
        jButton65.setText("<html>GEOMETRY SET<br>50 Php</html>");
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton65, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 790, 140, 130));

        jButton66.setBackground(new java.awt.Color(59, 105, 133));
        jButton66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton66.setForeground(new java.awt.Color(255, 255, 255));
        jButton66.setText("<html>T-SQUARE<br>120 Php</html>");
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 920, 140, 130));

        jButton67.setBackground(new java.awt.Color(59, 105, 133));
        jButton67.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton67.setForeground(new java.awt.Color(255, 255, 255));
        jButton67.setText("<html>SCIENTIFIC CALCULATOR<br>450 Php</html>");
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton67, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 920, 140, 130));

        jButton68.setBackground(new java.awt.Color(59, 105, 133));
        jButton68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton68.setForeground(new java.awt.Color(255, 255, 255));
        jButton68.setText("<html>GLUE STICK<br>20 Php</html>");
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton68, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 920, 140, 130));

        jButton69.setBackground(new java.awt.Color(59, 105, 133));
        jButton69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton69.setForeground(new java.awt.Color(255, 255, 255));
        jButton69.setText("<html>LIQUID GLUE<br>18 Php</html>");
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton69, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 920, 140, 130));

        jButton70.setBackground(new java.awt.Color(59, 105, 133));
        jButton70.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton70.setForeground(new java.awt.Color(255, 255, 255));
        jButton70.setText("<html>PASTE (TUB)<br>15 Php</html>");
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1050, 140, 130));

        jButton71.setBackground(new java.awt.Color(59, 105, 133));
        jButton71.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton71.setForeground(new java.awt.Color(255, 255, 255));
        jButton71.setText("<html>DOUBLE-SIDED TAPE<br>25 Php</html>");
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton71, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1050, 140, 130));

        jButton72.setBackground(new java.awt.Color(59, 105, 133));
        jButton72.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton72.setForeground(new java.awt.Color(255, 255, 255));
        jButton72.setText("<html>SCOTCH TAPE SMALL<br>10 Php</html>");
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton72, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1050, 140, 130));

        jButton73.setBackground(new java.awt.Color(59, 105, 133));
        jButton73.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton73.setForeground(new java.awt.Color(255, 255, 255));
        jButton73.setText("<html>STICKY NOTES 3x3<br>35 Php</html>");
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton73ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton73, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1180, 140, 130));

        jButton74.setBackground(new java.awt.Color(59, 105, 133));
        jButton74.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton74.setForeground(new java.awt.Color(255, 255, 255));
        jButton74.setText("<html>GLUE GUN STICK<br>5 Php</html>");
        jButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton74ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton74, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1180, 140, 130));

        jButton75.setBackground(new java.awt.Color(59, 105, 133));
        jButton75.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton75.setForeground(new java.awt.Color(255, 255, 255));
        jButton75.setText("<html>CORRECTION TAPE<br>25 Php</html>");
        jButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton75ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton75, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1180, 140, 130));

        jButton76.setBackground(new java.awt.Color(59, 105, 133));
        jButton76.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton76.setForeground(new java.awt.Color(255, 255, 255));
        jButton76.setText("<html>MASKING TAPE<br>20 Php</html>");
        jButton76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton76ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1180, 140, 130));

        jButton77.setBackground(new java.awt.Color(59, 105, 133));
        jButton77.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton77.setForeground(new java.awt.Color(255, 255, 255));
        jButton77.setText("<html>SCOTCH TAPE LARGE<br>18 Php</html>");
        jButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton77ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton77, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1050, 140, 130));

        jButton78.setBackground(new java.awt.Color(59, 105, 133));
        jButton78.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton78.setForeground(new java.awt.Color(255, 255, 255));
        jButton78.setText("<html>PENCIL CASE<br>40 Php</html>");
        jButton78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton78ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton78, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1310, 140, 130));

        jButton79.setBackground(new java.awt.Color(59, 105, 133));
        jButton79.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton79.setForeground(new java.awt.Color(255, 255, 255));
        jButton79.setText("<html>ERASER<br>8 Php</html>");
        jButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton79ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton79, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1310, 140, 130));

        jButton80.setBackground(new java.awt.Color(59, 105, 133));
        jButton80.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton80.setForeground(new java.awt.Color(255, 255, 255));
        jButton80.setText("<html>SHARPENER<br>12 Php</html>");
        jButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton80ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton80, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1310, 140, 130));

        jButton81.setBackground(new java.awt.Color(59, 105, 133));
        jButton81.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton81.setForeground(new java.awt.Color(255, 255, 255));
        jButton81.setText("<html>ID LACE<br>10 Php</html>");
        jButton81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton81ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton81, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1310, 140, 130));

        jButton82.setBackground(new java.awt.Color(59, 105, 133));
        jButton82.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton82.setForeground(new java.awt.Color(255, 255, 255));
        jButton82.setText("<html>PLASTIC COVER/METER<br>15 Php</html>");
        jButton82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton82ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1440, 140, 130));

        jButton83.setBackground(new java.awt.Color(59, 105, 133));
        jButton83.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton83.setForeground(new java.awt.Color(255, 255, 255));
        jButton83.setText("<html>PUNCHER (SINGLE HOLE)<br>50 Php</html>");
        jButton83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton83ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton83, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1570, 140, 130));

        jButton84.setBackground(new java.awt.Color(59, 105, 133));
        jButton84.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton84.setForeground(new java.awt.Color(255, 255, 255));
        jButton84.setText("<html>PAPER CLIPS (50s)<br>10 Php</html>");
        jButton84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton84ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton84, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1570, 140, 130));

        jButton85.setBackground(new java.awt.Color(59, 105, 133));
        jButton85.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton85.setForeground(new java.awt.Color(255, 255, 255));
        jButton85.setText("<html>STAPLER NO. 10<br>45 Php</html>");
        jButton85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton85ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton85, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 1440, 140, 130));

        jButton86.setBackground(new java.awt.Color(59, 105, 133));
        jButton86.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton86.setForeground(new java.awt.Color(255, 255, 255));
        jButton86.setText("<html>BINDER CLIPS SMALL<br>5 Php</html>");
        jButton86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton86ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton86, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1440, 140, 130));

        jButton87.setBackground(new java.awt.Color(59, 105, 133));
        jButton87.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton87.setForeground(new java.awt.Color(255, 255, 255));
        jButton87.setText("<html>NAME TAG HOLDER<br>10 Php</html>");
        jButton87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton87ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton87, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1440, 140, 130));

        jLabel14.setBackground(new java.awt.Color(59, 105, 133));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 1730, 30, 40));

        btnCONSTRUCTIONPAPER1.setBackground(new java.awt.Color(59, 105, 133));
        btnCONSTRUCTIONPAPER1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCONSTRUCTIONPAPER1.setForeground(new java.awt.Color(255, 255, 255));
        btnCONSTRUCTIONPAPER1.setText("<html>CONSTRUCTION PAPER<br>35 Php</html>\n");
        btnCONSTRUCTIONPAPER1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONSTRUCTIONPAPER1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnCONSTRUCTIONPAPER1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 130));

        btnYELLOWPAPER1.setBackground(new java.awt.Color(59, 105, 133));
        btnYELLOWPAPER1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnYELLOWPAPER1.setForeground(new java.awt.Color(255, 255, 255));
        btnYELLOWPAPER1.setText("<html>YELLOW PAD<br>50 Php</html>\n");
        btnYELLOWPAPER1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYELLOWPAPER1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnYELLOWPAPER1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 130));

        btnINDEXCARD13.setBackground(new java.awt.Color(59, 105, 133));
        btnINDEXCARD13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnINDEXCARD13.setForeground(new java.awt.Color(255, 255, 255));
        btnINDEXCARD13.setText("<html>INDEX CARD<br>(1/2) 10pcs<br> 25 Php</html>");
        btnINDEXCARD13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnINDEXCARD13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINDEXCARD13ActionPerformed(evt);
            }
        });
        jPanel6.add(btnINDEXCARD13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 130));

        btnINDEXCARD15.setBackground(new java.awt.Color(59, 105, 133));
        btnINDEXCARD15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnINDEXCARD15.setForeground(new java.awt.Color(255, 255, 255));
        btnINDEXCARD15.setText("<html>INDEX CARD<br>(1/4) 10pcs<br>20 Php</html>\n");
        btnINDEXCARD15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINDEXCARD15ActionPerformed(evt);
            }
        });
        jPanel6.add(btnINDEXCARD15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 130));

        btnSPIRALNOTEBOOk1.setBackground(new java.awt.Color(59, 105, 133));
        btnSPIRALNOTEBOOk1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSPIRALNOTEBOOk1.setForeground(new java.awt.Color(255, 255, 255));
        btnSPIRALNOTEBOOk1.setText("<html>SPIRAL NOTEBOOK<br>40 Php</html>\n\n");
        btnSPIRALNOTEBOOk1.setActionCommand("\n\n");
        btnSPIRALNOTEBOOk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPIRALNOTEBOOk1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnSPIRALNOTEBOOk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 140, 130));

        btnLONGBOND1.setBackground(new java.awt.Color(59, 105, 133));
        btnLONGBOND1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLONGBOND1.setForeground(new java.awt.Color(255, 255, 255));
        btnLONGBOND1.setText("<html>LONG BOND PAPER <br>(25 pcs.)<br>90 Php</html>");
        btnLONGBOND1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLONGBOND1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnLONGBOND1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 130));

        btnSHORTBOND1.setBackground(new java.awt.Color(59, 105, 133));
        btnSHORTBOND1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSHORTBOND1.setForeground(new java.awt.Color(255, 255, 255));
        btnSHORTBOND1.setText("<html>SHORT BOND PAPER<br>(25 pcs.)<br>80 Php</html>");
        btnSHORTBOND1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSHORTBOND1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSHORTBOND1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnSHORTBOND1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 140, 130));

        btnGRAPHINGPAD1.setBackground(new java.awt.Color(59, 105, 133));
        btnGRAPHINGPAD1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGRAPHINGPAD1.setForeground(new java.awt.Color(255, 255, 255));
        btnGRAPHINGPAD1.setText("<html>GRAPHING PAD<br>60 Php</html>");
        btnGRAPHINGPAD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGRAPHINGPAD1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnGRAPHINGPAD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 140, 130));

        btnINTERMEDIATEPAD1.setBackground(new java.awt.Color(59, 105, 133));
        btnINTERMEDIATEPAD1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnINTERMEDIATEPAD1.setForeground(new java.awt.Color(255, 255, 255));
        btnINTERMEDIATEPAD1.setText("<html>INTERMEDIATE PAD<br>25 Php</html>");
        btnINTERMEDIATEPAD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINTERMEDIATEPAD1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnINTERMEDIATEPAD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 140, 130));

        btnCOLOREDPAPER1.setBackground(new java.awt.Color(59, 105, 133));
        btnCOLOREDPAPER1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCOLOREDPAPER1.setForeground(new java.awt.Color(255, 255, 255));
        btnCOLOREDPAPER1.setText("<html>COLORED PAPER<br>(16 pcs.)<br>(RANDOMIZED)<br>50 Php</html>");
        btnCOLOREDPAPER1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOLOREDPAPER1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnCOLOREDPAPER1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 130));

        jScrollPane2.setViewportView(jPanel6);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 460));

        JTabbedPane.addTab("ALL PRODUCTS", jPanel3);

        Papers.setBackground(new java.awt.Color(255, 255, 255));
        Papers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCONSTRUCTIONPAPER.setBackground(new java.awt.Color(59, 105, 133));
        btnCONSTRUCTIONPAPER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCONSTRUCTIONPAPER.setForeground(new java.awt.Color(255, 255, 255));
        btnCONSTRUCTIONPAPER.setText("<html>CONSTRUCTION PAPER<br>35 Php</html>\n");
        btnCONSTRUCTIONPAPER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONSTRUCTIONPAPERActionPerformed(evt);
            }
        });
        Papers.add(btnCONSTRUCTIONPAPER, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 140, 130));

        btnYELLOWPAPER.setBackground(new java.awt.Color(59, 105, 133));
        btnYELLOWPAPER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnYELLOWPAPER.setForeground(new java.awt.Color(255, 255, 255));
        btnYELLOWPAPER.setText("<html>YELLOW PAD<br>50 Php</html>\n");
        btnYELLOWPAPER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYELLOWPAPERActionPerformed(evt);
            }
        });
        Papers.add(btnYELLOWPAPER, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 130));

        btnINDEXCARD12.setBackground(new java.awt.Color(59, 105, 133));
        btnINDEXCARD12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnINDEXCARD12.setForeground(new java.awt.Color(255, 255, 255));
        btnINDEXCARD12.setText("<html>INDEX CARD<br>(1/2) 10pcs<br> 25 Php</html>");
        btnINDEXCARD12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnINDEXCARD12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINDEXCARD12ActionPerformed(evt);
            }
        });
        Papers.add(btnINDEXCARD12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 130));

        btnINDEXCARD14.setBackground(new java.awt.Color(59, 105, 133));
        btnINDEXCARD14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnINDEXCARD14.setForeground(new java.awt.Color(255, 255, 255));
        btnINDEXCARD14.setText("<html>INDEX CARD<br>(1/4) 10pcs<br>20 Php</html>\n");
        btnINDEXCARD14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINDEXCARD14ActionPerformed(evt);
            }
        });
        Papers.add(btnINDEXCARD14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 130));

        btnSPIRALNOTEBOOk.setBackground(new java.awt.Color(59, 105, 133));
        btnSPIRALNOTEBOOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSPIRALNOTEBOOk.setForeground(new java.awt.Color(255, 255, 255));
        btnSPIRALNOTEBOOk.setText("<html>SPIRAL NOTEBOOK<br>40 Php</html>\n\n");
        btnSPIRALNOTEBOOk.setActionCommand("\n\n");
        btnSPIRALNOTEBOOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPIRALNOTEBOOkActionPerformed(evt);
            }
        });
        Papers.add(btnSPIRALNOTEBOOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 130));

        btnLONGBOND.setBackground(new java.awt.Color(59, 105, 133));
        btnLONGBOND.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLONGBOND.setForeground(new java.awt.Color(255, 255, 255));
        btnLONGBOND.setText("<html>LONG BOND PAPER <br>(25 pcs.)<br>90 Php</html>");
        btnLONGBOND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLONGBONDActionPerformed(evt);
            }
        });
        Papers.add(btnLONGBOND, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 130));

        btnSHORTBOND.setBackground(new java.awt.Color(59, 105, 133));
        btnSHORTBOND.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSHORTBOND.setForeground(new java.awt.Color(255, 255, 255));
        btnSHORTBOND.setText("<html>SHORT BOND PAPER<br>(25 pcs.)<br>80 Php</html>");
        btnSHORTBOND.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSHORTBOND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSHORTBONDActionPerformed(evt);
            }
        });
        Papers.add(btnSHORTBOND, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 140, 130));

        btnGRAPHINGPAD.setBackground(new java.awt.Color(59, 105, 133));
        btnGRAPHINGPAD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGRAPHINGPAD.setForeground(new java.awt.Color(255, 255, 255));
        btnGRAPHINGPAD.setText("<html>GRAPHING PAD<br>60 Php</html>");
        btnGRAPHINGPAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGRAPHINGPADActionPerformed(evt);
            }
        });
        Papers.add(btnGRAPHINGPAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 140, 130));

        btnINTERMEDIATEPAD.setBackground(new java.awt.Color(59, 105, 133));
        btnINTERMEDIATEPAD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnINTERMEDIATEPAD.setForeground(new java.awt.Color(255, 255, 255));
        btnINTERMEDIATEPAD.setText("<html>INTERMEDIATE PAD<br>25 Php</html>");
        btnINTERMEDIATEPAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINTERMEDIATEPADActionPerformed(evt);
            }
        });
        Papers.add(btnINTERMEDIATEPAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 140, 130));

        btnCOLOREDPAPER.setBackground(new java.awt.Color(59, 105, 133));
        btnCOLOREDPAPER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCOLOREDPAPER.setForeground(new java.awt.Color(255, 255, 255));
        btnCOLOREDPAPER.setText("<html>COLORED PAPER<br>(16 pcs.)<br>(RANDOMIZED)<br>50 Php</html>");
        btnCOLOREDPAPER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOLOREDPAPERActionPerformed(evt);
            }
        });
        Papers.add(btnCOLOREDPAPER, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 130));

        JTabbedPane.addTab("PAPER SUPPLIES", Papers);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGELPEN.setBackground(new java.awt.Color(59, 105, 133));
        btnGELPEN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGELPEN.setForeground(new java.awt.Color(255, 255, 255));
        btnGELPEN.setText("<html>GEL PEN<br>15 Php</html>");
        btnGELPEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGELPENActionPerformed(evt);
            }
        });
        jPanel4.add(btnGELPEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 130));

        btnMONGOLPENCIL.setBackground(new java.awt.Color(59, 105, 133));
        btnMONGOLPENCIL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMONGOLPENCIL.setForeground(new java.awt.Color(255, 255, 255));
        btnMONGOLPENCIL.setText("<html>MONGOL PENCIL #2<br>10 Php</html>");
        btnMONGOLPENCIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMONGOLPENCILActionPerformed(evt);
            }
        });
        jPanel4.add(btnMONGOLPENCIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 130));

        btnBALLPENBLACK.setBackground(new java.awt.Color(59, 105, 133));
        btnBALLPENBLACK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBALLPENBLACK.setForeground(new java.awt.Color(255, 255, 255));
        btnBALLPENBLACK.setText("<html>BALLPEN (BLACK)<br>8 Php</html>");
        btnBALLPENBLACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBALLPENBLACKActionPerformed(evt);
            }
        });
        jPanel4.add(btnBALLPENBLACK, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 130));

        btnBALLPENBLUE.setBackground(new java.awt.Color(59, 105, 133));
        btnBALLPENBLUE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBALLPENBLUE.setForeground(new java.awt.Color(255, 255, 255));
        btnBALLPENBLUE.setText("<html>BALLPEN (BLUE)<br>8 Php</html>");
        btnBALLPENBLUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBALLPENBLUEActionPerformed(evt);
            }
        });
        jPanel4.add(btnBALLPENBLUE, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 130));

        btnBALLPENRED.setBackground(new java.awt.Color(59, 105, 133));
        btnBALLPENRED.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBALLPENRED.setForeground(new java.awt.Color(255, 255, 255));
        btnBALLPENRED.setText("<html>BALLPEN (RED)<br>8 Php</html>");
        btnBALLPENRED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBALLPENREDActionPerformed(evt);
            }
        });
        jPanel4.add(btnBALLPENRED, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 140, 130));

        btnWHITEBOARDMARKER.setBackground(new java.awt.Color(59, 105, 133));
        btnWHITEBOARDMARKER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnWHITEBOARDMARKER.setForeground(new java.awt.Color(255, 255, 255));
        btnWHITEBOARDMARKER.setText("<html>WHITEBOARD MARKER<br>25 Php</html>");
        btnWHITEBOARDMARKER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWHITEBOARDMARKERActionPerformed(evt);
            }
        });
        jPanel4.add(btnWHITEBOARDMARKER, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 130));

        btnHIGHLIGHTER.setBackground(new java.awt.Color(59, 105, 133));
        btnHIGHLIGHTER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHIGHLIGHTER.setForeground(new java.awt.Color(255, 255, 255));
        btnHIGHLIGHTER.setText("<html>HIGHLIGHTER<br>20 Php</html>");
        btnHIGHLIGHTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHIGHLIGHTERActionPerformed(evt);
            }
        });
        jPanel4.add(btnHIGHLIGHTER, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 140, 130));

        btnTECHNICALPEN.setBackground(new java.awt.Color(59, 105, 133));
        btnTECHNICALPEN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTECHNICALPEN.setForeground(new java.awt.Color(255, 255, 255));
        btnTECHNICALPEN.setText("<html>TECHNICAL PEN<br>60 Php</html>");
        btnTECHNICALPEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTECHNICALPENActionPerformed(evt);
            }
        });
        jPanel4.add(btnTECHNICALPEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 140, 130));

        btnMECHANICALPENCIL.setBackground(new java.awt.Color(59, 105, 133));
        btnMECHANICALPENCIL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMECHANICALPENCIL.setForeground(new java.awt.Color(255, 255, 255));
        btnMECHANICALPENCIL.setText("<html>MECHANICAL PENCIL<br>30 Php</html>");
        btnMECHANICALPENCIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMECHANICALPENCILActionPerformed(evt);
            }
        });
        jPanel4.add(btnMECHANICALPENCIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 140, 130));

        btnPERMANENTMARKER.setBackground(new java.awt.Color(59, 105, 133));
        btnPERMANENTMARKER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPERMANENTMARKER.setForeground(new java.awt.Color(255, 255, 255));
        btnPERMANENTMARKER.setText("<html>PERMANENT MARKER<br>30 Php</html>");
        btnPERMANENTMARKER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPERMANENTMARKERActionPerformed(evt);
            }
        });
        jPanel4.add(btnPERMANENTMARKER, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 130));

        JTabbedPane.addTab("WRITING TOOLS", jPanel4);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRULER12.setBackground(new java.awt.Color(59, 105, 133));
        btnRULER12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRULER12.setForeground(new java.awt.Color(255, 255, 255));
        btnRULER12.setText("<html>RULER 12 INCH<br>15 Php</html>");
        btnRULER12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRULER12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRULER12ActionPerformed(evt);
            }
        });
        jPanel10.add(btnRULER12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 130));

        btnSETSQUARE45.setBackground(new java.awt.Color(59, 105, 133));
        btnSETSQUARE45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSETSQUARE45.setForeground(new java.awt.Color(255, 255, 255));
        btnSETSQUARE45.setText("<html>SET SQUARE 45°<br>20 Php</html>");
        btnSETSQUARE45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSETSQUARE45ActionPerformed(evt);
            }
        });
        jPanel10.add(btnSETSQUARE45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 130));

        btnRULER6.setBackground(new java.awt.Color(59, 105, 133));
        btnRULER6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRULER6.setForeground(new java.awt.Color(255, 255, 255));
        btnRULER6.setText("<html>RULER 6 INCH<br>10 Php</html>");
        btnRULER6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRULER6ActionPerformed(evt);
            }
        });
        jPanel10.add(btnRULER6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 130));

        btnPROTRACTOR.setBackground(new java.awt.Color(59, 105, 133));
        btnPROTRACTOR.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPROTRACTOR.setForeground(new java.awt.Color(255, 255, 255));
        btnPROTRACTOR.setText("<html>PROTRACTOR<br>12 Php</html>");
        btnPROTRACTOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPROTRACTORActionPerformed(evt);
            }
        });
        jPanel10.add(btnPROTRACTOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 130));

        btnCOMPASS.setBackground(new java.awt.Color(59, 105, 133));
        btnCOMPASS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCOMPASS.setForeground(new java.awt.Color(255, 255, 255));
        btnCOMPASS.setText("<html>COMPASS<br>30 Php</html>");
        btnCOMPASS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOMPASSActionPerformed(evt);
            }
        });
        jPanel10.add(btnCOMPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 140, 130));

        btnSETSQUARE30.setBackground(new java.awt.Color(59, 105, 133));
        btnSETSQUARE30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSETSQUARE30.setForeground(new java.awt.Color(255, 255, 255));
        btnSETSQUARE30.setText("<html>SET SQUARE 30°/60°<br>20 Php</html>");
        btnSETSQUARE30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSETSQUARE30ActionPerformed(evt);
            }
        });
        jPanel10.add(btnSETSQUARE30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 130));

        btnMEASURINGTAPE.setBackground(new java.awt.Color(59, 105, 133));
        btnMEASURINGTAPE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMEASURINGTAPE.setForeground(new java.awt.Color(255, 255, 255));
        btnMEASURINGTAPE.setText("<html>MEASURING TAPE 1M<br>35 Php</html>");
        btnMEASURINGTAPE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMEASURINGTAPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMEASURINGTAPEActionPerformed(evt);
            }
        });
        jPanel10.add(btnMEASURINGTAPE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 140, 130));

        btnGEOMETRYSET.setBackground(new java.awt.Color(59, 105, 133));
        btnGEOMETRYSET.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGEOMETRYSET.setForeground(new java.awt.Color(255, 255, 255));
        btnGEOMETRYSET.setText("<html>GEOMETRY SET<br>50 Php</html>");
        btnGEOMETRYSET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGEOMETRYSETActionPerformed(evt);
            }
        });
        jPanel10.add(btnGEOMETRYSET, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 140, 130));

        btnTSQUARE.setBackground(new java.awt.Color(59, 105, 133));
        btnTSQUARE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTSQUARE.setForeground(new java.awt.Color(255, 255, 255));
        btnTSQUARE.setText("<html>T-SQUARE<br>120 Php</html>");
        btnTSQUARE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTSQUAREActionPerformed(evt);
            }
        });
        jPanel10.add(btnTSQUARE, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 140, 130));

        btnSCIENTIFICCALCULATOR.setBackground(new java.awt.Color(59, 105, 133));
        btnSCIENTIFICCALCULATOR.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSCIENTIFICCALCULATOR.setForeground(new java.awt.Color(255, 255, 255));
        btnSCIENTIFICCALCULATOR.setText("<html>SCIENTIFIC CALCULATOR<br>450 Php</html>");
        btnSCIENTIFICCALCULATOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSCIENTIFICCALCULATORActionPerformed(evt);
            }
        });
        jPanel10.add(btnSCIENTIFICCALCULATOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 130));

        JTabbedPane.addTab("MEASURING TOOLS", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGLUESTICK.setBackground(new java.awt.Color(59, 105, 133));
        btnGLUESTICK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGLUESTICK.setForeground(new java.awt.Color(255, 255, 255));
        btnGLUESTICK.setText("<html>GLUE STICK<br>20 Php</html>");
        btnGLUESTICK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGLUESTICKActionPerformed(evt);
            }
        });
        jPanel11.add(btnGLUESTICK, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 130));

        btnLIQUIDGLUE.setBackground(new java.awt.Color(59, 105, 133));
        btnLIQUIDGLUE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLIQUIDGLUE.setForeground(new java.awt.Color(255, 255, 255));
        btnLIQUIDGLUE.setText("<html>LIQUID GLUE<br>18 Php</html>");
        btnLIQUIDGLUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIQUIDGLUEActionPerformed(evt);
            }
        });
        jPanel11.add(btnLIQUIDGLUE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 130));

        btnPASTE.setBackground(new java.awt.Color(59, 105, 133));
        btnPASTE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPASTE.setForeground(new java.awt.Color(255, 255, 255));
        btnPASTE.setText("<html>PASTE (TUB)<br>15 Php</html>");
        btnPASTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPASTEActionPerformed(evt);
            }
        });
        jPanel11.add(btnPASTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 130));

        btnDOUBLESIDEDTAPE.setBackground(new java.awt.Color(59, 105, 133));
        btnDOUBLESIDEDTAPE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDOUBLESIDEDTAPE.setForeground(new java.awt.Color(255, 255, 255));
        btnDOUBLESIDEDTAPE.setText("<html>DOUBLE-SIDED TAPE<br>25 Php</html>");
        btnDOUBLESIDEDTAPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDOUBLESIDEDTAPEActionPerformed(evt);
            }
        });
        jPanel11.add(btnDOUBLESIDEDTAPE, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 140, 130));

        btnSCOTCHTAPESMALL.setBackground(new java.awt.Color(59, 105, 133));
        btnSCOTCHTAPESMALL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSCOTCHTAPESMALL.setForeground(new java.awt.Color(255, 255, 255));
        btnSCOTCHTAPESMALL.setText("<html>SCOTCH TAPE SMALL<br>10 Php</html>");
        btnSCOTCHTAPESMALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSCOTCHTAPESMALLActionPerformed(evt);
            }
        });
        jPanel11.add(btnSCOTCHTAPESMALL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 130));

        btnSCOTCHTAPELARGE.setBackground(new java.awt.Color(59, 105, 133));
        btnSCOTCHTAPELARGE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSCOTCHTAPELARGE.setForeground(new java.awt.Color(255, 255, 255));
        btnSCOTCHTAPELARGE.setText("<html>SCOTCH TAPE LARGE<br>18 Php</html>");
        btnSCOTCHTAPELARGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSCOTCHTAPELARGEActionPerformed(evt);
            }
        });
        jPanel11.add(btnSCOTCHTAPELARGE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 130));

        btnMASKINGTAPE.setBackground(new java.awt.Color(59, 105, 133));
        btnMASKINGTAPE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMASKINGTAPE.setForeground(new java.awt.Color(255, 255, 255));
        btnMASKINGTAPE.setText("<html>MASKING TAPE<br>20 Php</html>");
        btnMASKINGTAPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMASKINGTAPEActionPerformed(evt);
            }
        });
        jPanel11.add(btnMASKINGTAPE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 140, 130));

        btnCORRECTIONTAPE.setBackground(new java.awt.Color(59, 105, 133));
        btnCORRECTIONTAPE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCORRECTIONTAPE.setForeground(new java.awt.Color(255, 255, 255));
        btnCORRECTIONTAPE.setText("<html>CORRECTION TAPE<br>25 Php</html>");
        btnCORRECTIONTAPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCORRECTIONTAPEActionPerformed(evt);
            }
        });
        jPanel11.add(btnCORRECTIONTAPE, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 140, 130));

        btnGLUEGUN.setBackground(new java.awt.Color(59, 105, 133));
        btnGLUEGUN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGLUEGUN.setForeground(new java.awt.Color(255, 255, 255));
        btnGLUEGUN.setText("<html>GLUE GUN STICK<br>5 Php</html>");
        btnGLUEGUN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGLUEGUNActionPerformed(evt);
            }
        });
        jPanel11.add(btnGLUEGUN, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 140, 130));

        btnSTICKYNOTES.setBackground(new java.awt.Color(59, 105, 133));
        btnSTICKYNOTES.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSTICKYNOTES.setForeground(new java.awt.Color(255, 255, 255));
        btnSTICKYNOTES.setText("<html>STICKY NOTES 3x3<br>35 Php</html>");
        btnSTICKYNOTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSTICKYNOTESActionPerformed(evt);
            }
        });
        jPanel11.add(btnSTICKYNOTES, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 130));

        JTabbedPane.addTab("ADHESIVES", jPanel11);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPENCILCASE.setBackground(new java.awt.Color(59, 105, 133));
        btnPENCILCASE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPENCILCASE.setForeground(new java.awt.Color(255, 255, 255));
        btnPENCILCASE.setText("<html>PENCIL CASE<br>40 Php</html>");
        btnPENCILCASE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPENCILCASEActionPerformed(evt);
            }
        });
        jPanel7.add(btnPENCILCASE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 130));

        btnERASER.setBackground(new java.awt.Color(59, 105, 133));
        btnERASER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnERASER.setForeground(new java.awt.Color(255, 255, 255));
        btnERASER.setText("<html>ERASER<br>8 Php</html>");
        btnERASER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnERASERActionPerformed(evt);
            }
        });
        jPanel7.add(btnERASER, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 130));

        btnSHARPENER.setBackground(new java.awt.Color(59, 105, 133));
        btnSHARPENER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSHARPENER.setForeground(new java.awt.Color(255, 255, 255));
        btnSHARPENER.setText("<html>SHARPENER<br>12 Php</html>");
        btnSHARPENER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSHARPENERActionPerformed(evt);
            }
        });
        jPanel7.add(btnSHARPENER, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 130));

        btnIDLACE.setBackground(new java.awt.Color(59, 105, 133));
        btnIDLACE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIDLACE.setForeground(new java.awt.Color(255, 255, 255));
        btnIDLACE.setText("<html>ID LACE<br>10 Php</html>");
        btnIDLACE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDLACEActionPerformed(evt);
            }
        });
        jPanel7.add(btnIDLACE, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 140, 130));

        btnPLASTICCOVER.setBackground(new java.awt.Color(59, 105, 133));
        btnPLASTICCOVER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPLASTICCOVER.setForeground(new java.awt.Color(255, 255, 255));
        btnPLASTICCOVER.setText("<html>PLASTIC COVER/METER<br>15 Php</html>");
        btnPLASTICCOVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPLASTICCOVERActionPerformed(evt);
            }
        });
        jPanel7.add(btnPLASTICCOVER, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 130));

        btnNAMETAGHOLDER.setBackground(new java.awt.Color(59, 105, 133));
        btnNAMETAGHOLDER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNAMETAGHOLDER.setForeground(new java.awt.Color(255, 255, 255));
        btnNAMETAGHOLDER.setText("<html>NAME TAG HOLDER<br>10 Php</html>");
        btnNAMETAGHOLDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNAMETAGHOLDERActionPerformed(evt);
            }
        });
        jPanel7.add(btnNAMETAGHOLDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 130));

        btnBINDERCLIPSSMALL.setBackground(new java.awt.Color(59, 105, 133));
        btnBINDERCLIPSSMALL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBINDERCLIPSSMALL.setForeground(new java.awt.Color(255, 255, 255));
        btnBINDERCLIPSSMALL.setText("<html>BINDER CLIPS SMALL<br>5 Php</html>");
        btnBINDERCLIPSSMALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBINDERCLIPSSMALLActionPerformed(evt);
            }
        });
        jPanel7.add(btnBINDERCLIPSSMALL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 140, 130));

        btnSTAPLERNO10.setBackground(new java.awt.Color(59, 105, 133));
        btnSTAPLERNO10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSTAPLERNO10.setForeground(new java.awt.Color(255, 255, 255));
        btnSTAPLERNO10.setText("<html>STAPLER NO. 10<br>45 Php</html>");
        btnSTAPLERNO10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSTAPLERNO10ActionPerformed(evt);
            }
        });
        jPanel7.add(btnSTAPLERNO10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 140, 130));

        btnPAPERCLIPS50s.setBackground(new java.awt.Color(59, 105, 133));
        btnPAPERCLIPS50s.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPAPERCLIPS50s.setForeground(new java.awt.Color(255, 255, 255));
        btnPAPERCLIPS50s.setText("<html>PAPER CLIPS (50s)<br>10 Php</html>");
        btnPAPERCLIPS50s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPAPERCLIPS50sActionPerformed(evt);
            }
        });
        jPanel7.add(btnPAPERCLIPS50s, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 140, 130));

        btnPUNCHERSINGLEHOLE.setBackground(new java.awt.Color(59, 105, 133));
        btnPUNCHERSINGLEHOLE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPUNCHERSINGLEHOLE.setForeground(new java.awt.Color(255, 255, 255));
        btnPUNCHERSINGLEHOLE.setText("<html>PUNCHER (SINGLE HOLE)<br>50 Php</html>");
        btnPUNCHERSINGLEHOLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPUNCHERSINGLEHOLEActionPerformed(evt);
            }
        });
        jPanel7.add(btnPUNCHERSINGLEHOLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 130));

        JTabbedPane.addTab("ACCESSORIES", jPanel7);

        getContentPane().add(JTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 690, 490));

        jPanel2.setBackground(new java.awt.Color(158, 219, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 5));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(26, 94, 134));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("TOTAL ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 130, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(26, 94, 134));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("SUB TOTAL:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(26, 94, 134));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TAX:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 40));

        txtTOTAL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel2.add(txtTOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 350, 60));

        txtSUBTOTAL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel2.add(txtSUBTOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 230, 40));

        txtTAX.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel2.add(txtTAX, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 230, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 390, 260));

        lblBARCODE.setBackground(new java.awt.Color(255, 255, 255));
        lblBARCODE.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblBARCODE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBARCODE.setPreferredSize(new java.awt.Dimension(390, 60));
        getContentPane().add(lblBARCODE, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 720, 390, 70));

        lblBARCODETEXT.setBackground(new java.awt.Color(255, 255, 255));
        lblBARCODETEXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblBARCODETEXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 790, 390, 20));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 105, 133), 5));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 720, 390, 90));

        jPanel12.setBackground(new java.awt.Color(153, 204, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCLEARSEARCH.setText("X");
        btnCLEARSEARCH.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCLEARSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLEARSEARCHActionPerformed(evt);
            }
        });
        jPanel12.add(btnCLEARSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 30, 40, 30));

        txtSEARCH.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSEARCHActionPerformed(evt);
            }
        });
        jPanel12.add(txtSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 250, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(26, 94, 134));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("SEARCH:");
        jPanel12.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 110, 50));

        btnSEARCH.setText("ENTER");
        btnSEARCH.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEARCHActionPerformed(evt);
            }
        });
        jPanel12.add(btnSEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 20, 60, 50));

        lblTIME.setBackground(new java.awt.Color(65, 120, 153));
        lblTIME.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTIME.setForeground(new java.awt.Color(26, 94, 134));
        lblTIME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel12.add(lblTIME, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, 170, 30));

        lblDATE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDATE.setForeground(new java.awt.Color(26, 94, 134));
        lblDATE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel12.add(lblDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 40, 250, 30));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 820));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //=================== SALES REPORT
    
    public void logSalesToDatabase() {
        String cashierUsername = currentUsername; // ensure currentUsername is set in POS frame

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123")) {

            String sql = "INSERT INTO sales (cashier_username, product_name, quantity, price, total) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {
                String productName = model.getValueAt(i, 0).toString();
                int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
                double totalPrice = Double.parseDouble(model.getValueAt(i, 2).toString());
                double unitPrice = totalPrice / quantity;

                pst.setString(1, cashierUsername);
                pst.setString(2, productName);
                pst.setInt(3, quantity);
                pst.setDouble(4, unitPrice);
                pst.setDouble(5, totalPrice);
                pst.executeUpdate();
            }

            pst.close();
            JOptionPane.showMessageDialog(this, "Sales logged successfully!");
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error logging sales: " + ex.getMessage());
        }
    }


    //==================== activity log ======================================
    public void setCurrentUsername(String username) {
        this.currentUsername = username;
    }

    private void logActivity(String username, String action) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudEssentials_POS", "root", "admin123")) {
            String sql = "INSERT INTO activity_logs (username, action) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, action);
            pst.executeUpdate();
            pst.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //=================================KEYPAD==================================================
    private void appendToActiveField(String digit) {
    playClickSound();
    
    if (activePaymentField != null && activePaymentField.isEnabled()) {
        String current = activePaymentField.getText().replace(",", "");
        current += digit;

        try {
            long number = Long.parseLong(current);
            activePaymentField.setText(formatWithCommas(String.valueOf(number)));
        } catch (NumberFormatException e) {
            activePaymentField.setText(current);
        }
    }
}
    //=================================QUANTITY DIALOG==============================================
    private void showQuantityDialog(String productName, double unitPrice, String code) {
    JDialog dialog = new JDialog(this, "Enter Quantity", false); // false = non-modal
    dialog.setSize(300, 150);
    dialog.setLayout(new BorderLayout());
    dialog.setLocationRelativeTo(this);

    JTextField quantityField = new JTextField();
    quantityField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    quantityField.setHorizontalAlignment(JTextField.CENTER);

    // Set this as the active field for your keypad
    activePaymentField = quantityField;

    JPanel inputPanel = new JPanel(new BorderLayout());
    inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    inputPanel.add(new JLabel("Enter quantity for " + productName + ":"), BorderLayout.NORTH);
    inputPanel.add(quantityField, BorderLayout.CENTER);

    JButton btnOK = new JButton("OK");
    btnOK.addActionListener(e -> {
        try {
            int quantity = Integer.parseInt(quantityField.getText().trim());
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be greater than 0.");
                return;
            }

            double totalPrice = unitPrice * quantity;
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            boolean itemFound = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).toString().equals(productName)) {
                    int existingQty = Integer.parseInt(model.getValueAt(i, 1).toString());
                    int newQty = existingQty + quantity;
                    model.setValueAt(String.valueOf(newQty), i, 1);
                    model.setValueAt(unitPrice * newQty, i, 2);
                    itemFound = true;
                    break;
                }
            }

            if (!itemFound) {
                model.addRow(new Object[]{productName, String.valueOf(quantity), totalPrice});
            }

            ItemCost();
            lblBARCODE.setText("*" + code + "*");
            lblBARCODETEXT.setText(code);

            dialog.dispose();
            activePaymentField = null;

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid quantity.");
        }
    });

        dialog.add(inputPanel, BorderLayout.CENTER);
        dialog.add(btnOK, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    //====================================================DECIMAL PAYMENT TEXTFIELD ===========================================
    private String formatWithCommas(String input) {
        input = input.replace(",", "");

    try {
        BigDecimal value = new BigDecimal(input);
        DecimalFormat formatter = new DecimalFormat("#,##0.##");
        return formatter.format(value);
    }       catch (NumberFormatException e) {
            return input;
        }
    }


    
    //========================================================= SEARCH BAR =====================================


    private void filterProducts() {
    String searchText = txtSEARCH.getText().toLowerCase();
    foundMatch = false; // Reset this before filtering

    Component selectedTab = JTabbedPane.getSelectedComponent();
    JPanel panel = null;

    // Handle nested structure: JScrollPane > JPanel
    if (selectedTab instanceof JScrollPane) {
        JScrollPane scrollPane = (JScrollPane) selectedTab;
        Component view = scrollPane.getViewport().getView();
        if (view instanceof JPanel) {
            panel = (JPanel) view;
        }
    } else if (selectedTab instanceof JPanel) {
        panel = (JPanel) selectedTab;
    }

    if (panel != null) {
        // Run filter on actual panel with buttons
        filterButtonsInPanel(panel, searchText, panel);

        panel.revalidate();
        panel.repaint();

        if (!foundMatch && !searchText.isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No products found for: " + searchText, "Not Found", JOptionPane.WARNING_MESSAGE);

            // Reset search
            txtSEARCH.setText("");

            // Reset all tabs
            for (int i = 0; i < JTabbedPane.getTabCount(); i++) {
                Component tabComp = JTabbedPane.getComponentAt(i);
                if (tabComp instanceof JScrollPane) {
                    Component inner = ((JScrollPane) tabComp).getViewport().getView();
                    if (inner instanceof JPanel) {
                        showAllButtons((JPanel) inner);
                    }
                }   else if (tabComp instanceof JPanel) {
                    showAllButtons((JPanel) tabComp);
                    }
                }

                JTabbedPane.revalidate();
                JTabbedPane.repaint();
            }
        }
    }

    private void filterButtonsInPanel(Container container, String searchText, JPanel panel) {
    boolean[] scrolled = { false }; // to scroll only once
    filterButtonsRecursive(container, searchText, panel, scrolled);

    // Reset scroll to top if search is empty or no match found
    if (searchText.isEmpty() || !foundMatch) {
        SwingUtilities.invokeLater(() -> {
            JScrollPane scrollPane = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, panel);
            if (scrollPane != null) {
                scrollPane.getVerticalScrollBar().setValue(0);
                }
            });
        }
    }

    private void filterButtonsRecursive(Container container, String searchText, JPanel panel, boolean[] scrolled) {
        for (Component comp : container.getComponents()) {
             if (comp instanceof JButton) {
                JButton btn = (JButton) comp;
                String productName = btn.getText().toLowerCase();
                boolean visible = productName.contains(searchText);
                btn.setVisible(visible);

            if (visible) {
                foundMatch = true;

                // Scroll to the first visible button once
                if (!scrolled[0]) {
                    btn.scrollRectToVisible(new Rectangle(btn.getSize()));
                    scrolled[0] = true;
                }
            }

            }   else if (comp instanceof Container) {
                filterButtonsRecursive((Container) comp, searchText, panel, scrolled);
            }
        }
    }


    
    
    private void showAllButtons(Component comp) {
    if (comp instanceof JButton) {
        comp.setVisible(true);
        
    } else if (comp instanceof JPanel) {
        for (Component child : ((JPanel) comp).getComponents()) {
            showAllButtons(child);
        }
    }   else if (comp instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) comp;
            JViewport viewport = scrollPane.getViewport();
            Component view = viewport.getView();
            showAllButtons(view); // recurse into the panel inside the scrollpane
        }
    }   


    
    
    

    // ==================================================SOUND===============================
    public void playClickSound() {
    try {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(
            getClass().getResource("/Resources/zapsplat_multimedia_alert_menu_select_item_beep_click_001_70847.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public void Sound2() {
    try {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(
            getClass().getResource("/Resources/sound2.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    
    
    
    
    
    
    
    
    
    // ================================================== FOR TOTAL SUBTOTAL AND TAX ===========================================
    public void ItemCost()
    {
        double sum = 0;
        
        for (int i = 0; i < jTable1.getRowCount(); i++)
        {
            sum = sum + Double.parseDouble(jTable1.getValueAt (i, 2).toString());
        }
        txtSUBTOTAL.setText(Double.toString(sum));
        
        double cTotal1 = Double.parseDouble(txtSUBTOTAL.getText());
        
        double cTax = (cTotal1 * 0.12) /100;
        String iTotalTax = String.format("₱ %.2f", cTax);
        txtTAX.setText(iTotalTax);
        
        String iSubTotal = String.format("₱ %.2f", cTotal1);
        txtSUBTOTAL.setText(iSubTotal);
        
        String iTotal = String.format("₱ %.2f", cTotal1 + cTax);
        txtTOTAL.setText(iTotal);
        
        String Barcode = String.format("Total is %.2f", cTotal1 + cTax);
        lblBARCODE.setText(Barcode);
    }
    
    //=================================================== CHANGE ==============================================================
    
    public void Change() {
        double total = Double.parseDouble(txtTOTAL.getText().replace(",", "").replace("₱", "").trim());

        double cash = 0;
        double gcash = 0;

        if (rbCASH.isSelected() || rbSPLIT.isSelected()) {
            try {
                cash = Double.parseDouble(txtCASH.getText().replace(",", "").replace("₱", "").trim());
            } catch (Exception e) { cash = 0; }
        }

        if (rbGCASH.isSelected() || rbSPLIT.isSelected()) {
            try {
                gcash = Double.parseDouble(txtGCASH.getText().replace(",", "").replace("₱", "").trim());
            } catch (Exception e) { gcash = 0; }
        }

        double totalPaid = cash + gcash;
        double change = totalPaid - total;

        if (change < 0) {
            txtCHANGE.setText("₱ 0.00");
            JOptionPane.showMessageDialog(this, "Insufficient payment.", "Payment Error", JOptionPane.WARNING_MESSAGE);
        }       else {
                txtCHANGE.setText(String.format("₱ %,.2f", change));
        }
    }

   
   //===================================== SEARCH BAR ===============================================
    private void toggleClearButton() {
        String text = txtSEARCH.getText();
        btnCLEARSEARCH.setVisible(!text.trim().isEmpty());
    }
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        appendToActiveField("1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
        appendToActiveField("7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
        appendToActiveField("8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btnDOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDOTActionPerformed
        playClickSound();

    if (activePaymentField != null && activePaymentField.isEnabled()) {
        String current = activePaymentField.getText();

        // Prevent multiple decimal points
        if (!current.contains(".")) {
            current += ".";
            activePaymentField.setText(current); // No formatting yet — format after more digits are added
            }
        }
    }//GEN-LAST:event_btnDOTActionPerformed

    private void btnCLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLEARActionPerformed
        playClickSound();

    if (activePaymentField != null && activePaymentField.isEnabled()) {
        activePaymentField.setText("");
        

    }
        
    }//GEN-LAST:event_btnCLEARActionPerformed

    private void btnSETSQUARE45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSETSQUARE45ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SET SQUARE 45*", 20.00, "MT30003320");
    }//GEN-LAST:event_btnSETSQUARE45ActionPerformed

    private void btnPROTRACTORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPROTRACTORActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PROTRACTOR", 12.00, "MT30003310");
    }//GEN-LAST:event_btnPROTRACTORActionPerformed

    private void btnCOMPASSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOMPASSActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("COMPASS", 30.00, "MT30003315");
    }//GEN-LAST:event_btnCOMPASSActionPerformed

    private void btnPASTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPASTEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PASTE (TUBE)", 15.00, "AD40004410");
    }//GEN-LAST:event_btnPASTEActionPerformed

    private void btnDOUBLESIDEDTAPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDOUBLESIDEDTAPEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("DOUBLE SIDED TAPE", 25.00, "AD40004415");
    }//GEN-LAST:event_btnDOUBLESIDEDTAPEActionPerformed

    private void btnSCOTCHTAPESMALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSCOTCHTAPESMALLActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SCOTCH TAPE SMALL", 10.00, "AD40004420");
    }//GEN-LAST:event_btnSCOTCHTAPESMALLActionPerformed

    private void btnSHARPENERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSHARPENERActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SHARPENER", 12.00, "AC50005510");
    }//GEN-LAST:event_btnSHARPENERActionPerformed

    private void btnIDLACEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDLACEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("ID LACE", 10.00, "AC50005515");
        
    }//GEN-LAST:event_btnIDLACEActionPerformed

    private void btnPLASTICCOVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPLASTICCOVERActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PLASTIC COVER/METER", 15.00, "AC50005520");
    }//GEN-LAST:event_btnPLASTICCOVERActionPerformed

    private void btnCONSTRUCTIONPAPERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONSTRUCTIONPAPERActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("CONSTRUCTION PAPER", 35.00, "PS10001120"); 
    }//GEN-LAST:event_btnCONSTRUCTIONPAPERActionPerformed

    private void btnINDEXCARD14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINDEXCARD14ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("INDEX CARRD '1/4' (10 PCS.)", 20.00, "PS10001110");
    }//GEN-LAST:event_btnINDEXCARD14ActionPerformed

    private void btnSPIRALNOTEBOOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPIRALNOTEBOOkActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SPIRAL NOTEBOOk", 40.00, "PS10001115"); 
        
    }//GEN-LAST:event_btnSPIRALNOTEBOOkActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        appendToActiveField("2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        appendToActiveField("3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        appendToActiveField("4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        appendToActiveField("5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        appendToActiveField("6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
       appendToActiveField("9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here:
        appendToActiveField("0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnYELLOWPAPERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYELLOWPAPERActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("YELLOW PAPER", 50.00, "PS10001100");

        
    }//GEN-LAST:event_btnYELLOWPAPERActionPerformed

    private void btnINDEXCARD12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINDEXCARD12ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("INDEX CARRD '1/2' (10 PCS.)", 25.00, "PS10001105");
    }//GEN-LAST:event_btnINDEXCARD12ActionPerformed

    private void btnPAYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPAYActionPerformed
        if (rbCASH.isSelected() || rbGCASH.isSelected() || rbSPLIT.isSelected()) {
        Change();
    } else {
        JOptionPane.showMessageDialog(this, "Please select a payment method first.", "Missing Selection", JOptionPane.WARNING_MESSAGE);
    }
    
    }//GEN-LAST:event_btnPAYActionPerformed

    private void btnRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRESETActionPerformed
       int response = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to reset this transaction?\nAll entered data will be cleared.",
        "Confirm Reset",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );

    if (response == JOptionPane.YES_OPTION) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clears all rows from the table

        // Clear all input and output fields
        txtGCASH.setText("");
        txtCASH.setText("");
        txtCHANGE.setText("");
        txtSUBTOTAL.setText("");
        txtTAX.setText("");
        txtTOTAL.setText("");
        lblBARCODE.setText("");
        lblBARCODETEXT.setText("");



        lblBARCODE.requestFocus(); // Set focus back to the barcode input

        JOptionPane.showMessageDialog(this, "Transaction has been reset.", "Reset Successful", JOptionPane.INFORMATION_MESSAGE);
        btnREMOVE.setEnabled(true);
        btnREFUND.setEnabled(false);

        }

    }//GEN-LAST:event_btnRESETActionPerformed

    private void btnPRINTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRINTActionPerformed
        // TODO add your handling code here:
        try {
        StringBuilder receipt = new StringBuilder();
        String date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());

        receipt.append("        StudEssentials RECEIPT\n");
        receipt.append("     Thank you for your purchase!\n\n");

        receipt.append("Date: ").append(date).append("\n\n");
        receipt.append("Item\t     Qty\t       Price\n");
        receipt.append("------------------------------------\n");

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String item = jTable1.getValueAt(i, 0).toString();
            String qty = jTable1.getValueAt(i, 1).toString();
            String price = jTable1.getValueAt(i, 2).toString();
            receipt.append(item).append("\t").append(qty).append("\t").append(price).append("\n");
        }

        receipt.append("------------------------------------\n");
        receipt.append("TOTAL: ₱ ").append(txtTOTAL.getText()).append("\n");

        // Use selected radio button for payment method
        if (rbCASH.isSelected()) {
            receipt.append("CASH: ").append(txtCASH.getText()).append("\n");
            receipt.append("CHANGE: ").append(txtCHANGE.getText()).append("\n");
            receipt.append("Payment Method: Cash\n");

        } else if (rbGCASH.isSelected()) {
            receipt.append("GCASH: ").append(txtGCASH.getText()).append("\n");
            receipt.append("CHANGE: Paid via GCash\n");
            receipt.append("Payment Method: GCash\n");

        } else if (rbSPLIT.isSelected()) {
            receipt.append("CASH: ").append(txtCASH.getText()).append("\n");
            receipt.append("GCASH: ").append(txtGCASH.getText()).append("\n");
            receipt.append("CHANGE: ").append(txtCHANGE.getText()).append("\n");
            receipt.append("Payment Method: Split (Cash + GCash)\n");

        } else {
            receipt.append("Payment Method: Unknown\n");
        }

        // Print
        JTextArea textArea = new JTextArea(receipt.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        boolean complete = textArea.print();

        if (complete) {
            btnREFUND.setEnabled(true);
            btnREMOVE.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Receipt printed successfully. You may now process a refund if needed.");
        }

    } catch (PrinterException e) {
        JOptionPane.showMessageDialog(null, "Failed to print receipt: " + e.getMessage(), "Print Error", JOptionPane.ERROR_MESSAGE);
        
    }
        
    }//GEN-LAST:event_btnPRINTActionPerformed

    private void btnREMOVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREMOVEActionPerformed
        // TODO add your handling code here:
     DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int selectedRow = jTable1.getSelectedRow();

    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select an item from the table to remove.", "No Item Selected", JOptionPane.WARNING_MESSAGE);
        return;
    }

    model.removeRow(selectedRow);
    ItemCost(); // Recalculate new total

    // Handle change recalculation based on selected payment method
    if (rbCASH.isSelected() || rbSPLIT.isSelected()) {
        String cashText = txtCASH.getText().replace(",", "").replace("₱", "").trim();
        if (!cashText.isEmpty()) {
            Change(); // Recalculate change after removing item
        } else {
            txtCHANGE.setText("");
        }
    } else if (rbGCASH.isSelected()) {
        txtCASH.setText(""); // Optional: clear cash input if mistakenly filled
        txtCHANGE.setText("Paid via GCash");
    } else {
        txtCASH.setText("");
        txtCHANGE.setText("");
        }
      if (model.getRowCount() == 0) {
        lblBARCODE.setText("");         // Clear barcode display
        lblBARCODETEXT.setText("");
      }
    }//GEN-LAST:event_btnREMOVEActionPerformed

    private void txtSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSEARCHActionPerformed
        // TODO add your handling code here:
        filterProducts();
        JButton btnSEARCH = new JButton("Enter");
        JButton btnCLEARSEARCH = new JButton("Clear");

    }//GEN-LAST:event_txtSEARCHActionPerformed

    private void txtCASHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCASHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCASHActionPerformed

    private void btnREFUNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREFUNDActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select an item from the table to refund.", "No Item Selected", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to refund the selected item?", "Confirm Refund", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(selectedRow);

        // Recalculate all costs
        ItemCost();

        // Recalculate change if payment method is cash or split
        if (rbCASH.isSelected() || rbSPLIT.isSelected()) {
            String cashText = txtCASH.getText().replace(",", "").replace("₱", "").trim();
            if (!cashText.isEmpty()) {
                Change(); // Recalculate with new totals
            }   else {
                txtCHANGE.setText("");
                }
            
        }   
            else if (rbGCASH.isSelected()) {
            txtCHANGE.setText("Paid via GCash"); // Or simply: txtCHANGE.setText("");
            }   
                else {
                    txtCHANGE.setText(""); // Fallback
                }

        JOptionPane.showMessageDialog(this, "Item refunded successfully.");

        // Disable refund button if cart is now empty
        if (jTable1.getRowCount() == 0) {
            btnREFUND.setEnabled(false);        
        }
        
            if (jTable1.getRowCount() == 0) {
                btnREFUND.setEnabled(false);
    
                lblBARCODE.setText("");
                lblBARCODETEXT.setText("");
            }

        }
    
    }//GEN-LAST:event_btnREFUNDActionPerformed

    private void txtGCASHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGCASHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGCASHActionPerformed

    private void rbCASHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCASHActionPerformed
        // TODO add your handling code here:
        txtCASH.setEnabled(true);
        txtGCASH.setEnabled(false);
        txtGCASH.setText("");
        activePaymentField = txtCASH;
        txtCASH.requestFocus();
    }//GEN-LAST:event_rbCASHActionPerformed

    private void rbGCASHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGCASHActionPerformed
        // TODO add your handling code here:
        txtGCASH.setEnabled(true);
        txtCASH.setEnabled(false);
        txtCASH.setText("");
        activePaymentField = txtGCASH;
        txtGCASH.requestFocus();
    }//GEN-LAST:event_rbGCASHActionPerformed

    private void rbSPLITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSPLITActionPerformed
        // TODO add your handling code here:
        txtCASH.setEnabled(true);
        txtGCASH.setEnabled(true);
        activePaymentField = txtCASH;
        txtCASH.requestFocus();
    }//GEN-LAST:event_rbSPLITActionPerformed

    private void jScrollPane2MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane2MouseWheelMoved
       
    }//GEN-LAST:event_jScrollPane2MouseWheelMoved

    private void btnLONGBONDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLONGBONDActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("LONG BOND (25 PCS.)", 90.00, "PS10001125");
    }//GEN-LAST:event_btnLONGBONDActionPerformed

    private void btnSHORTBONDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSHORTBONDActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SHORT BOND (25 PCS)", 85.00, "PS10001130");
    }//GEN-LAST:event_btnSHORTBONDActionPerformed

    private void btnGRAPHINGPADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAPHINGPADActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("GRAPHING PAD", 60.00, "PS10001135");
    }//GEN-LAST:event_btnGRAPHINGPADActionPerformed

    private void btnINTERMEDIATEPADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINTERMEDIATEPADActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("INTERMEDIATE PAD", 25.00, "PS10001140");
    }//GEN-LAST:event_btnINTERMEDIATEPADActionPerformed

    private void btnCOLOREDPAPERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOLOREDPAPERActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("COLORED PAPER (16 PCS.)", 50.00, "PS10001145");
    }//GEN-LAST:event_btnCOLOREDPAPERActionPerformed

    private void btnGEOMETRYSETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGEOMETRYSETActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("GEOMETRY SET", 50.00, "MT30003335");
    }//GEN-LAST:event_btnGEOMETRYSETActionPerformed

    private void btnTSQUAREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTSQUAREActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("T-SQUARE", 12.00, "MT30003340");
    }//GEN-LAST:event_btnTSQUAREActionPerformed

    private void btnSCIENTIFICCALCULATORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSCIENTIFICCALCULATORActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SCIENTIFIC CALCULATOR", 450.00, "MT30003345");
    }//GEN-LAST:event_btnSCIENTIFICCALCULATORActionPerformed

    private void btnCORRECTIONTAPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCORRECTIONTAPEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("CORRECTION TAPE", 25.00, "AD40004435");
    }//GEN-LAST:event_btnCORRECTIONTAPEActionPerformed

    private void btnGLUEGUNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGLUEGUNActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("GLUE GUN STICK", 5.00, "AD40004440");
    }//GEN-LAST:event_btnGLUEGUNActionPerformed

    private void btnSTICKYNOTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSTICKYNOTESActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("STICKY NOTE 3*3", 35.00, "AD40004445");
    }//GEN-LAST:event_btnSTICKYNOTESActionPerformed

    private void btnSTAPLERNO10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSTAPLERNO10ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("STAPLER NO. 10", 45.00, "AC50005535");
    }//GEN-LAST:event_btnSTAPLERNO10ActionPerformed

    private void btnPAPERCLIPS50sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPAPERCLIPS50sActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PAPER CLIPS (50S)", 10.00, "AC50005540");
    }//GEN-LAST:event_btnPAPERCLIPS50sActionPerformed

    private void btnPUNCHERSINGLEHOLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPUNCHERSINGLEHOLEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PUNCHER SINGLE HOLE", 50.00, "AC50005545");
    }//GEN-LAST:event_btnPUNCHERSINGLEHOLEActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SET SQUARE 45*", 20.00, "MT30003320");
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("COMPASS", 30.00, "MT30003315");
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PROTRACTOR", 12.00, "MT30003310");
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("GEOMETRY SET", 50.00, "MT30003335");
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("T-SQUARE", 12.00, "MT30003340");
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SCIENTIFIC CALCULATOR", 450.00, "MT30003345");
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PASTE (TUBE)", 15.00, "AD40004410");
    }//GEN-LAST:event_jButton70ActionPerformed

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("DOUBLE SIDED TAPE", 25.00, "AD40004415");
    }//GEN-LAST:event_jButton71ActionPerformed

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SCOTCH TAPE SMALL", 10.00, "AD40004420");
    }//GEN-LAST:event_jButton72ActionPerformed

    private void jButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("STICKY NOTE 3*3", 35.00, "AD40004445");
    }//GEN-LAST:event_jButton73ActionPerformed

    private void jButton74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton74ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("GLUE GUN STICK", 5.00, "AD40004440");
    }//GEN-LAST:event_jButton74ActionPerformed

    private void jButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("CORRECTION TAPE", 25.00, "AD40004435");
    }//GEN-LAST:event_jButton75ActionPerformed

    private void jButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton80ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SHARPENER", 12.00, "AC50005510");
    }//GEN-LAST:event_jButton80ActionPerformed

    private void jButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton81ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("ID LACE", 10.00, "AC50005515");
    }//GEN-LAST:event_jButton81ActionPerformed

    private void jButton82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton82ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PLASTIC COVER/METER", 15.00, "AC50005520");
    }//GEN-LAST:event_jButton82ActionPerformed

    private void jButton83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton83ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PUNCHER SINGLE HOLE", 50.00, "AC50005545");
    }//GEN-LAST:event_jButton83ActionPerformed

    private void jButton84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton84ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PAPER CLIPS (50S)", 10.00, "AC50005540");
    }//GEN-LAST:event_jButton84ActionPerformed

    private void jButton85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton85ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("STAPLER NO. 10", 45.00, "AC50005535");
    }//GEN-LAST:event_jButton85ActionPerformed

    private void btnSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEARCHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSEARCHActionPerformed

    private void btnCLEARSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLEARSEARCHActionPerformed
        // TODO add your handling code here:
        txtSEARCH.setText(""); // this also hides the clear button
        filterProducts();
    }//GEN-LAST:event_btnCLEARSEARCHActionPerformed

    private void btnMONGOLPENCILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMONGOLPENCILActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("MONGOL PENCIL #2", 10.00, "WT20002200");
    }//GEN-LAST:event_btnMONGOLPENCILActionPerformed

    private void btnBALLPENBLACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBALLPENBLACKActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("BALLPEN BLACK", 8.00, "WT20002205");
    }//GEN-LAST:event_btnBALLPENBLACKActionPerformed

    private void btnBALLPENBLUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBALLPENBLUEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("BALLPEN BLUE", 8.00, "WT20002210");
    }//GEN-LAST:event_btnBALLPENBLUEActionPerformed

    private void btnBALLPENREDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBALLPENREDActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("BALLPEN RED", 8.00, "WT20002215");
    }//GEN-LAST:event_btnBALLPENREDActionPerformed

    private void btnGELPENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGELPENActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("GEL PEN", 15.00, "WT20002220");
    }//GEN-LAST:event_btnGELPENActionPerformed

    private void btnWHITEBOARDMARKERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWHITEBOARDMARKERActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("WHITE BOARD MARKER", 25.00, "WT20002225");
    }//GEN-LAST:event_btnWHITEBOARDMARKERActionPerformed

    private void btnHIGHLIGHTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHIGHLIGHTERActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("HIGHLIGHTER", 20.00, "WT20002230");
    }//GEN-LAST:event_btnHIGHLIGHTERActionPerformed

    private void btnTECHNICALPENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTECHNICALPENActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("TECHNICAL PEN", 60.00, "WT20002235");
    }//GEN-LAST:event_btnTECHNICALPENActionPerformed

    private void btnMECHANICALPENCILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMECHANICALPENCILActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("MECHANICAL PENCIL", 30.00, "WT20002240");
    }//GEN-LAST:event_btnMECHANICALPENCILActionPerformed

    private void btnPERMANENTMARKERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPERMANENTMARKERActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PERMANENT MARKER", 30.00, "WT20002245");
    }//GEN-LAST:event_btnPERMANENTMARKERActionPerformed

    private void btnRULER6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRULER6ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("RULER 6-INCH", 10.00, "MT30003300");
    }//GEN-LAST:event_btnRULER6ActionPerformed

    private void btnRULER12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRULER12ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("RULER 12-INCH", 15.00, "MT30003305");
    }//GEN-LAST:event_btnRULER12ActionPerformed

    private void btnSETSQUARE30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSETSQUARE30ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SET SQAURE 30* / 60*", 20.00, "MT30003325");
    }//GEN-LAST:event_btnSETSQUARE30ActionPerformed

    private void btnMEASURINGTAPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMEASURINGTAPEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("MEASURING TAPE 1M", 35.00, "MT30003330");
    }//GEN-LAST:event_btnMEASURINGTAPEActionPerformed

    private void btnGLUESTICKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGLUESTICKActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("GLUE STICK", 10.00, "AD40004400");
    }//GEN-LAST:event_btnGLUESTICKActionPerformed

    private void btnLIQUIDGLUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIQUIDGLUEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("LIQUID GLUE", 18.00, "AD40004405");
    }//GEN-LAST:event_btnLIQUIDGLUEActionPerformed

    private void btnSCOTCHTAPELARGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSCOTCHTAPELARGEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SCOTCH TAPE LARGE", 20.00, "AD40004425");
    }//GEN-LAST:event_btnSCOTCHTAPELARGEActionPerformed

    private void btnMASKINGTAPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMASKINGTAPEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("MASKING TAPE", 20.00, "AD40004430");
    }//GEN-LAST:event_btnMASKINGTAPEActionPerformed

    private void btnPENCILCASEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPENCILCASEActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PENCIL CASE", 40.00, "AC50005500");
    }//GEN-LAST:event_btnPENCILCASEActionPerformed

    private void btnERASERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnERASERActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("ERASER", 8.00, "AC50005505");
    }//GEN-LAST:event_btnERASERActionPerformed

    private void btnNAMETAGHOLDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNAMETAGHOLDERActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("NAME TAG HOLDER", 10.00, "AC50005525");
    }//GEN-LAST:event_btnNAMETAGHOLDERActionPerformed

    private void btnBINDERCLIPSSMALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBINDERCLIPSSMALLActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("BINDER CLIPS SMALL", 5.00, "AC50005530");
    }//GEN-LAST:event_btnBINDERCLIPSSMALLActionPerformed

    private void btnCONSTRUCTIONPAPER1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONSTRUCTIONPAPER1ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("CONSTRUCTION PAPER", 35.00, "PS10001120"); 
    }//GEN-LAST:event_btnCONSTRUCTIONPAPER1ActionPerformed

    private void btnYELLOWPAPER1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYELLOWPAPER1ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("YELLOW PAPER", 50.00, "PS10001100");
    }//GEN-LAST:event_btnYELLOWPAPER1ActionPerformed

    private void btnINDEXCARD13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINDEXCARD13ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("INDEX CARRD '1/2' (10 PCS.)", 25.00, "PS10001105");
    }//GEN-LAST:event_btnINDEXCARD13ActionPerformed

    private void btnINDEXCARD15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINDEXCARD15ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("INDEX CARRD '1/4' (10 PCS.)", 20.00, "PS10001110");
    }//GEN-LAST:event_btnINDEXCARD15ActionPerformed

    private void btnSPIRALNOTEBOOk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPIRALNOTEBOOk1ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SPIRAL NOTEBOOk", 40.00, "PS10001115"); 
        
    }//GEN-LAST:event_btnSPIRALNOTEBOOk1ActionPerformed

    private void btnLONGBOND1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLONGBOND1ActionPerformed
        // TODO add your handling code here:
         Sound2();
        showQuantityDialog("LONG BOND (25 PCS.)", 90.00, "PS10001125");
    }//GEN-LAST:event_btnLONGBOND1ActionPerformed

    private void btnSHORTBOND1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSHORTBOND1ActionPerformed
        // TODO add your handling code here:
         Sound2();
        showQuantityDialog("SHORT BOND (25 PCS)", 85.00, "PS10001130");
    }//GEN-LAST:event_btnSHORTBOND1ActionPerformed

    private void btnGRAPHINGPAD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAPHINGPAD1ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("GRAPHING PAD", 60.00, "PS10001135");
    }//GEN-LAST:event_btnGRAPHINGPAD1ActionPerformed

    private void btnINTERMEDIATEPAD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINTERMEDIATEPAD1ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("INTERMEDIATE PAD", 25.00, "PS10001140");
    }//GEN-LAST:event_btnINTERMEDIATEPAD1ActionPerformed

    private void btnCOLOREDPAPER1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOLOREDPAPER1ActionPerformed
        // TODO add your handling code here:
         Sound2();
        showQuantityDialog("COLORED PAPER (16 PCS.)", 50.00, "PS10001145");
    }//GEN-LAST:event_btnCOLOREDPAPER1ActionPerformed

    private void jButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton77ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SCOTCH TAPE LARGE", 20.00, "AD40004425");
    }//GEN-LAST:event_jButton77ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        // TODO add your handling code here:
         Sound2();
        showQuantityDialog("MONGOL PENCIL #2", 10.00, "WT20002200");
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("BALLPEN BLACK", 8.00, "WT20002205");
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("BALLPEN BLUE", 8.00, "WT20002210");
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("BALLPEN RED", 8.00, "WT20002215");
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("GEL PEN", 15.00, "WT20002220");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("WHITE BOARD MARKER", 25.00, "WT20002225");
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("HIGHLIGHTER", 20.00, "WT20002230");
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("TECHNICAL PEN", 60.00, "WT20002235");
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("MECHANICAL PENCIL", 30.00, "WT20002240");
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("MECHANICAL PENCIL", 30.00, "WT20002240");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("RULER 6-INCH", 10.00, "MT30003300");
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("RULER 12-INCH", 15.00, "MT30003305");
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("SET SQAURE 30* / 60*", 20.00, "MT30003325");
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("MEASURING TAPE 1M", 35.00, "MT30003330");
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("GLUE STICK", 10.00, "AD40004400");
    }//GEN-LAST:event_jButton68ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("LIQUID GLUE", 18.00, "AD40004405");
    }//GEN-LAST:event_jButton69ActionPerformed

    private void jButton76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton76ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("MASKING TAPE", 20.00, "AD40004430");
    }//GEN-LAST:event_jButton76ActionPerformed

    private void jButton78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton78ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("PENCIL CASE", 40.00, "AC50005500");
    }//GEN-LAST:event_jButton78ActionPerformed

    private void jButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton79ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("ERASER", 8.00, "AC50005505");
    }//GEN-LAST:event_jButton79ActionPerformed

    private void jButton87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton87ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("NAME TAG HOLDER", 10.00, "AC50005525");
    }//GEN-LAST:event_jButton87ActionPerformed

    private void jButton86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton86ActionPerformed
        // TODO add your handling code here:
        Sound2();
        showQuantityDialog("BINDER CLIPS SMALL", 5.00, "AC50005530");
    }//GEN-LAST:event_jButton86ActionPerformed

    private void btmEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmEXITActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to logout?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            // Log the logout activity
            logActivity(currentUsername, "Logged out");
            this.dispose(); // Close the current window (e.g., admin dashboard)

            // Open the login form again
            Login_Frame login = new Login_Frame();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btmEXITActionPerformed

    private void btnCompleteSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteSaleActionPerformed
        // TODO add your handling code here:
         logSalesToDatabase();

    // Clear the cart and reset UI after sale
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    
    // Reset totals, change, etc.
        txtSUBTOTAL.setText("");
        txtTAX.setText("");
        txtTOTAL.setText("");
        txtCHANGE.setText("");
        lblBARCODE.setText("");
        lblBARCODETEXT.setText("");
        txtCASH.setText("");
        txtGCASH.setText("");
        
    }//GEN-LAST:event_btnCompleteSaleActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new POS().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPane;
    private javax.swing.JPanel Papers;
    private javax.swing.JButton btmEXIT;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnBALLPENBLACK;
    private javax.swing.JButton btnBALLPENBLUE;
    private javax.swing.JButton btnBALLPENRED;
    private javax.swing.JButton btnBINDERCLIPSSMALL;
    private javax.swing.JButton btnCLEAR;
    private javax.swing.JButton btnCLEARSEARCH;
    private javax.swing.JButton btnCOLOREDPAPER;
    private javax.swing.JButton btnCOLOREDPAPER1;
    private javax.swing.JButton btnCOMPASS;
    private javax.swing.JButton btnCONSTRUCTIONPAPER;
    private javax.swing.JButton btnCONSTRUCTIONPAPER1;
    private javax.swing.JButton btnCORRECTIONTAPE;
    private javax.swing.JButton btnCompleteSale;
    private javax.swing.JButton btnDOT;
    private javax.swing.JButton btnDOUBLESIDEDTAPE;
    private javax.swing.JButton btnERASER;
    private javax.swing.JButton btnGELPEN;
    private javax.swing.JButton btnGEOMETRYSET;
    private javax.swing.JButton btnGLUEGUN;
    private javax.swing.JButton btnGLUESTICK;
    private javax.swing.JButton btnGRAPHINGPAD;
    private javax.swing.JButton btnGRAPHINGPAD1;
    private javax.swing.JButton btnHIGHLIGHTER;
    private javax.swing.JButton btnIDLACE;
    private javax.swing.JButton btnINDEXCARD12;
    private javax.swing.JButton btnINDEXCARD13;
    private javax.swing.JButton btnINDEXCARD14;
    private javax.swing.JButton btnINDEXCARD15;
    private javax.swing.JButton btnINTERMEDIATEPAD;
    private javax.swing.JButton btnINTERMEDIATEPAD1;
    private javax.swing.JButton btnLIQUIDGLUE;
    private javax.swing.JButton btnLONGBOND;
    private javax.swing.JButton btnLONGBOND1;
    private javax.swing.JButton btnMASKINGTAPE;
    private javax.swing.JButton btnMEASURINGTAPE;
    private javax.swing.JButton btnMECHANICALPENCIL;
    private javax.swing.JButton btnMONGOLPENCIL;
    private javax.swing.JButton btnNAMETAGHOLDER;
    private javax.swing.JButton btnPAPERCLIPS50s;
    private javax.swing.JButton btnPASTE;
    private javax.swing.JButton btnPAY;
    private javax.swing.JButton btnPENCILCASE;
    private javax.swing.JButton btnPERMANENTMARKER;
    private javax.swing.JButton btnPLASTICCOVER;
    private javax.swing.JButton btnPRINT;
    private javax.swing.JButton btnPROTRACTOR;
    private javax.swing.JButton btnPUNCHERSINGLEHOLE;
    private javax.swing.JButton btnREFUND;
    private javax.swing.JButton btnREMOVE;
    private javax.swing.JButton btnRESET;
    private javax.swing.JButton btnRULER12;
    private javax.swing.JButton btnRULER6;
    private javax.swing.JButton btnSCIENTIFICCALCULATOR;
    private javax.swing.JButton btnSCOTCHTAPELARGE;
    private javax.swing.JButton btnSCOTCHTAPESMALL;
    private javax.swing.JButton btnSEARCH;
    private javax.swing.JButton btnSETSQUARE30;
    private javax.swing.JButton btnSETSQUARE45;
    private javax.swing.JButton btnSHARPENER;
    private javax.swing.JButton btnSHORTBOND;
    private javax.swing.JButton btnSHORTBOND1;
    private javax.swing.JButton btnSPIRALNOTEBOOk;
    private javax.swing.JButton btnSPIRALNOTEBOOk1;
    private javax.swing.JButton btnSTAPLERNO10;
    private javax.swing.JButton btnSTICKYNOTES;
    private javax.swing.JButton btnTECHNICALPEN;
    private javax.swing.JButton btnTSQUARE;
    private javax.swing.JButton btnWHITEBOARDMARKER;
    private javax.swing.JButton btnYELLOWPAPER;
    private javax.swing.JButton btnYELLOWPAPER1;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton83;
    private javax.swing.JButton jButton84;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBARCODE;
    private javax.swing.JLabel lblBARCODETEXT;
    private javax.swing.JLabel lblDATE;
    private javax.swing.JLabel lblTIME;
    private javax.swing.ButtonGroup paymentMethod;
    private javax.swing.JRadioButton rbCASH;
    private javax.swing.JRadioButton rbGCASH;
    private javax.swing.JRadioButton rbSPLIT;
    private javax.swing.JTextField txtCASH;
    private javax.swing.JTextField txtCHANGE;
    private javax.swing.JTextField txtGCASH;
    private javax.swing.JTextField txtSEARCH;
    private javax.swing.JTextField txtSUBTOTAL;
    private javax.swing.JTextField txtTAX;
    private javax.swing.JTextField txtTOTAL;
    // End of variables declaration//GEN-END:variables
}
