/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package w;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class Frame3 extends javax.swing.JFrame { 

    private void initDefaultValues() {
    txtplyerx.setText("Player X");
    txtolyero.setText("Player O");
    txtplyerx.setText("0");
    txtolyero.setText("0");
}
    private String startGame = "X";
    private int xCount = 0;
    private int oCount = 0;
    boolean checker;

 
    public Frame3() {
        initComponents();
        initDefaultValues();
    }

private void resetFields() {
    txtplyerx.setText("0");
    txtolyero.setText("0");
}

private void gameScore()
    {
    txtplyerx.setText(String.valueOf(xCount));
    txtolyero.setText(String.valueOf(oCount));
    }
    
    private void choose_a_Player()
    {
        if(startGame.equalsIgnoreCase("X"))
        {
            startGame = "O";
        }
        else
        {
            startGame = "X";
        }
    }
    
    private void winningGame()
        {
            String b1 =jbtn1.getText();
            String b2 =jbtn2.getText();
            String b3 =jbtn3.getText();
            String b4 =jbtn4.getText();
            String b5 =jbtn5.getText();
            String b6 =jbtn6.getText();
            String b7 =jbtn7.getText();
            String b8 =jbtn8.getText();
            String b9 =jbtn9.getText();
            
            if (b1 == ("X") && b2 == ("X") && b3 == ("X") )
            {
                JOptionPane.showMessageDialog(this,"Player X Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn1.setBackground(Color.ORANGE);
                jbtn2.setBackground(Color.ORANGE);
                jbtn3.setBackground(Color.ORANGE);
                xCount++;
                gameScore();
            }
            
            if (b4 == ("X") && b5 == ("X") && b6 == ("X") )
            {
                JOptionPane.showMessageDialog(this,"Player X Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn4.setBackground(Color.CYAN);
                jbtn5.setBackground(Color.CYAN);
                jbtn6.setBackground(Color.CYAN);
                xCount++;
                gameScore();
            }
            
           if (b7 == ("X") && b8 == ("X") && b9 == ("X") )
            {
                JOptionPane.showMessageDialog(this,"Player X Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn7.setBackground(Color.GREEN);
                jbtn8.setBackground(Color.GREEN);
                jbtn9.setBackground(Color.GREEN);
                xCount++;
                gameScore();
            }
           //
            if (b3 == ("X") && b6 == ("X") && b9 == ("X") )
            {
                JOptionPane.showMessageDialog(this,"Player X Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn3.setBackground(Color.ORANGE);
                jbtn6.setBackground(Color.ORANGE);
                jbtn9.setBackground(Color.ORANGE);
                xCount++;
                gameScore();
            }
            
            if (b1 == ("X") && b5 == ("X") && b9 == ("X") )
            {
                JOptionPane.showMessageDialog(this,"Player X Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn1.setBackground(Color.CYAN);
                jbtn5.setBackground(Color.CYAN);
                jbtn9.setBackground(Color.CYAN);
                xCount++;
                gameScore();
            }
            
           if (b3 == ("X") && b5 == ("X") && b7 == ("X") )
            {
                JOptionPane.showMessageDialog(this,"Player X Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn3.setBackground(Color.GREEN);
                jbtn5.setBackground(Color.GREEN);
                jbtn7.setBackground(Color.GREEN);
                xCount++;
                gameScore();
            }
           //
           if (b1 == ("O") && b2 == ("O") && b3 == ("O") )
            {
                JOptionPane.showMessageDialog(this,"Player O Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn1.setBackground(Color.PINK);
                jbtn2.setBackground(Color.PINK);
                jbtn3.setBackground(Color.PINK);
                oCount++;
                gameScore();
            }
            
            if (b4 == ("O") && b5 == ("O") && b6 == ("O") )
            {
                JOptionPane.showMessageDialog(this,"Player O Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn4.setBackground(Color.YELLOW);
                jbtn5.setBackground(Color.YELLOW);
                jbtn6.setBackground(Color.YELLOW);
                oCount++;
                gameScore();
            }
            
           if (b7 == ("O") && b8 == ("O") && b9 == ("O") )
            {
                JOptionPane.showMessageDialog(this,"Player O Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn7.setBackground(Color.GREEN);
                jbtn8.setBackground(Color.GREEN);
                jbtn9.setBackground(Color.GREEN);
                oCount++;
                gameScore();
            }
           //
           if (b1 == ("O") && b4 == ("O") && b7 == ("O") )
            {
                JOptionPane.showMessageDialog(this,"Player O Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn1.setBackground(Color.MAGENTA);
                jbtn4.setBackground(Color.MAGENTA);
                jbtn7.setBackground(Color.MAGENTA);
                oCount++;
                gameScore();
            }
            
            if (b2 == ("O") && b5 == ("O") && b8 == ("O") )
            {
                JOptionPane.showMessageDialog(this,"Player O Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn2.setBackground(Color.MAGENTA);
                jbtn5.setBackground(Color.MAGENTA);
                jbtn8.setBackground(Color.MAGENTA);
                oCount++;
                gameScore();
            }
            
           if (b3 == ("X") && b6 == ("X") && b9 == ("X") )
            {
                JOptionPane.showMessageDialog(this,"Player O Won","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
                jbtn3.setBackground(Color.PINK);
                jbtn6.setBackground(Color.PINK);
                jbtn9.setBackground(Color.PINK);
                oCount++;
                gameScore();
            }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jbtn3 = new javax.swing.JButton();
        jbtn1 = new javax.swing.JButton();
        jbtn2 = new javax.swing.JButton();
        jbtn4 = new javax.swing.JButton();
        jbtn5 = new javax.swing.JButton();
        jbtn6 = new javax.swing.JButton();
        jbtn7 = new javax.swing.JButton();
        jbtn8 = new javax.swing.JButton();
        jbtn9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtolyero = new javax.swing.JTextField();
        txtplyerx = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblriwayat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 102));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jbtn3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn3ActionPerformed(evt);
            }
        });

        jbtn1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn1ActionPerformed(evt);
            }
        });

        jbtn2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn2ActionPerformed(evt);
            }
        });

        jbtn4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn4ActionPerformed(evt);
            }
        });

        jbtn5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn5ActionPerformed(evt);
            }
        });

        jbtn6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn6ActionPerformed(evt);
            }
        });

        jbtn7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn7ActionPerformed(evt);
            }
        });

        jbtn8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn8ActionPerformed(evt);
            }
        });

        jbtn9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 580, 590));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PLAYER O :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PLAYER X :");

        txtolyero.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtolyero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtolyero.setText("0");
        txtolyero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtolyeroActionPerformed(evt);
            }
        });

        txtplyerx.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtplyerx.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtplyerx.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtplyerx, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtolyero, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(txtplyerx, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(txtolyero, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 380, 220));

        jLabel1.setFont(new java.awt.Font("STHupo", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AMBAGAME");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("NEW GAME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, java.awt.BorderLayout.CENTER);

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("RESET");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, java.awt.BorderLayout.PAGE_START);

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Log Out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 380, 210));

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Simpan");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 330, -1, -1));

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, -1, -1));

        jTabbedPane1.addTab("AmbaGame", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel4.setFont(new java.awt.Font("STHupo", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("AMBASCORE");

        tblriwayat.setBackground(new java.awt.Color(0, 153, 153));
        tblriwayat.setFont(new java.awt.Font("STHupo", 1, 14)); // NOI18N
        tblriwayat.setForeground(new java.awt.Color(51, 51, 255));
        tblriwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Player X", "Player O"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblriwayat);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(307, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("AmbaScore", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private JFrame frame;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frame = new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"Apakah Anda Mau Keluar?","Tic Tac Toe",
                JOptionPane.YES_NO_OPTION )==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jbtn1.setEnabled(true);
        jbtn2.setEnabled(true);
        jbtn3.setEnabled(true);
        jbtn4.setEnabled(true);
        jbtn5.setEnabled(true);
        jbtn6.setEnabled(true);
        jbtn7.setEnabled(true);
        jbtn8.setEnabled(true);
        jbtn9.setEnabled(true);
        
        jbtn1.setText("");
        jbtn2.setText("");
        jbtn3.setText("");
        jbtn4.setText("");
        jbtn5.setText("");
        jbtn6.setText("");
        jbtn7.setText("");
        jbtn8.setText("");
        jbtn9.setText("");
        
        jbtn1.setBackground(Color.LIGHT_GRAY);
        jbtn2.setBackground(Color.LIGHT_GRAY);
        jbtn3.setBackground(Color.LIGHT_GRAY);
        jbtn4.setBackground(Color.LIGHT_GRAY);
        jbtn5.setBackground(Color.LIGHT_GRAY);
        jbtn6.setBackground(Color.LIGHT_GRAY);
        jbtn7.setBackground(Color.LIGHT_GRAY);
        jbtn8.setBackground(Color.LIGHT_GRAY);
        jbtn9.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jbtn1.setEnabled(true);
        jbtn2.setEnabled(true);
        jbtn3.setEnabled(true);
        jbtn4.setEnabled(true);
        jbtn5.setEnabled(true);
        jbtn6.setEnabled(true);
        jbtn7.setEnabled(true);
        jbtn8.setEnabled(true);
        jbtn9.setEnabled(true);
        
        txtplyerx.setText("0");
        txtolyero.setText("0");
        
        jbtn1.setText("");
        jbtn2.setText("");
        jbtn3.setText("");
        jbtn4.setText("");
        jbtn5.setText("");
        jbtn6.setText("");
        jbtn7.setText("");
        jbtn8.setText("");
        jbtn9.setText("");
        
        jbtn1.setBackground(Color.LIGHT_GRAY);
        jbtn2.setBackground(Color.LIGHT_GRAY);
        jbtn3.setBackground(Color.LIGHT_GRAY);
        jbtn4.setBackground(Color.LIGHT_GRAY);
        jbtn5.setBackground(Color.LIGHT_GRAY);
        jbtn6.setBackground(Color.LIGHT_GRAY);
        jbtn7.setBackground(Color.LIGHT_GRAY);
        jbtn8.setBackground(Color.LIGHT_GRAY);
        jbtn9.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn1ActionPerformed
        jbtn1.setText(startGame);
        
        if (startGame.equalsIgnoreCase("X"))
        {
            checker = false;
        }
        else
        {
            checker = true;
        }
        choose_a_Player();
        winningGame();
    }//GEN-LAST:event_jbtn1ActionPerformed

    private void jbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn2ActionPerformed
        jbtn2.setText(startGame);
        
        if (startGame.equalsIgnoreCase("X"))
        {
            checker = false ;
        }
        else
        {
            checker = true;
        }
        choose_a_Player();
        winningGame();
    }//GEN-LAST:event_jbtn2ActionPerformed

    private void jbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn3ActionPerformed
        jbtn3.setText(startGame);
        
        if (startGame.equalsIgnoreCase("X"))
        {
            checker = false ;
        }
        else
        {
            checker = true;
        }
        choose_a_Player();
        winningGame();
    }//GEN-LAST:event_jbtn3ActionPerformed

    private void jbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn4ActionPerformed
        jbtn4.setText(startGame);
        
        if (startGame.equalsIgnoreCase("X"))
        {
            checker = false ;
        }
        else
        {
            checker = true;
        }
        choose_a_Player();
        winningGame();
    }//GEN-LAST:event_jbtn4ActionPerformed

    private void jbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn5ActionPerformed
        jbtn5.setText(startGame);
        
        if (startGame.equalsIgnoreCase("X"))
        {
            checker = false ;
        }
        else
        {
            checker = true;
        }
        choose_a_Player();
        winningGame();
    }//GEN-LAST:event_jbtn5ActionPerformed

    private void jbtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn6ActionPerformed
        jbtn6.setText(startGame);
        
        if (startGame.equalsIgnoreCase("X"))
        {
            checker = false ;
        }
        else
        {
            checker = true;
        }
        choose_a_Player();
        winningGame();
    }//GEN-LAST:event_jbtn6ActionPerformed

    private void jbtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn7ActionPerformed
        jbtn7.setText(startGame);
        
        if (startGame.equalsIgnoreCase("X"))
        {
            checker = false ;
        }
        else
        {
            checker = true;
        }
        choose_a_Player();
        winningGame();
    }//GEN-LAST:event_jbtn7ActionPerformed

    private void jbtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn8ActionPerformed
        jbtn8.setText(startGame);
        
        if (startGame.equalsIgnoreCase("X"))
        {
            checker = false ;
        }
        else
        {
            checker = true;
        }
        choose_a_Player();
        winningGame();
    }//GEN-LAST:event_jbtn8ActionPerformed

    private void jbtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn9ActionPerformed
        jbtn9.setText(startGame);
        
        if (startGame.equalsIgnoreCase("X"))
        {
            checker = false ;
        }
        else
        {
            checker = true;
        }
        choose_a_Player();
        winningGame();
    }//GEN-LAST:event_jbtn9ActionPerformed

    private void txtolyeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtolyeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtolyeroActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        frame1 frame1 = new frame1();
        frame1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String playerX = txtplyerx.getText();
    String playerO = txtolyero.getText();
    String scoreXText = txtplyerx.getText();
    String scoreOText = txtolyero.getText();

    if (playerX.isEmpty() || playerO.isEmpty() || scoreXText.isEmpty() || scoreOText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        int scoreX = Integer.parseInt(scoreXText);
        int scoreO = Integer.parseInt(scoreOText);

        DefaultTableModel model = (DefaultTableModel) tblriwayat.getModel();
        model.addRow(new Object[]{playerX, playerO, scoreX, scoreO});

        resetFields();
        JOptionPane.showMessageDialog(null, "Skor berhasil disimpan ke tabel!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Skor harus berupa angka!", "Error", JOptionPane.WARNING_MESSAGE);
    } 
    }//GEN-LAST:event_jButton4ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtn1;
    private javax.swing.JButton jbtn2;
    private javax.swing.JButton jbtn3;
    private javax.swing.JButton jbtn4;
    private javax.swing.JButton jbtn5;
    private javax.swing.JButton jbtn6;
    private javax.swing.JButton jbtn7;
    private javax.swing.JButton jbtn8;
    private javax.swing.JButton jbtn9;
    private javax.swing.JTable tblriwayat;
    private javax.swing.JTextField txtolyero;
    private javax.swing.JTextField txtplyerx;
    // End of variables declaration//GEN-END:variables
}
