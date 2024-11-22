/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package w;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
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

public class Frame4 extends javax.swing.JFrame {
    
    private void initDefaultValues() {
    txtplayer.setText("Player X");
    txtcomputer.setText("Player O");
    txtplayer.setText("0");
    txtcomputer.setText("0");
}
 
    private void resetFields() {
    txtplayer.setText("0");
    txtcomputer.setText("0");
}
    
    private String startGame = "X";
    private int xCount = 0;
    private int oCount = 0;
    boolean checker;
    private boolean isComputerMode = true;
    private boolean gameOver = false;

 
    public Frame4() {
        initComponents();
        initDefaultValues();
    }
    
    private void gameScore()
    {
    txtplayer.setText(String.valueOf(xCount));
    txtcomputer.setText(String.valueOf(oCount));
    }
    
        private void computerMove() {
        // Strategi komputer dengan prioritas:
        // 1. Menang jika memungkinkan
        // 2. Blokir pemain jika akan menang
        // 3. Pilih kotak strategis
        // 4. Pilih kotak acak

        JButton[] buttons = {jbtn1, jbtn2, jbtn3, jbtn4, jbtn5, jbtn6, jbtn7, jbtn8, jbtn9};
        
        // Cek apakah komputer bisa menang
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().isEmpty()) {
                buttons[i].setText("O");
                if (checkWinningCondition("O")) {
                    winningGame();
                    return;
                }
                buttons[i].setText("");
            }
        }
        
        // Blokir pemain
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().isEmpty()) {
                buttons[i].setText("X");
                if (checkWinningCondition("X")) {
                    buttons[i].setText("O");
                    winningGame();
                    return;
                }
                buttons[i].setText("");
            }
        }
        
        // Pilih kotak tengah jika kosong
        if (jbtn5.getText().isEmpty()) {
            jbtn5.setText("O");
            winningGame();
            return;
        }
        
        // Pilih sudut jika memungkinkan
        JButton[] corners = {jbtn1, jbtn3, jbtn7, jbtn9};
        java.util.List<JButton> emptyCorners = new java.util.ArrayList<>();
        for (JButton corner : corners) {
            if (corner.getText().isEmpty()) {
                emptyCorners.add(corner);
            }
        }
        
        if (!emptyCorners.isEmpty()) {
            Random random = new Random();
            JButton selectedCorner = emptyCorners.get(random.nextInt(emptyCorners.size()));
            selectedCorner.setText("O");
            winningGame();
            return;
        }
        
        // Pilih kotak kosong secara acak
        java.util.List<JButton> emptyButtons = new java.util.ArrayList<>();
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                emptyButtons.add(button);
            }
        }
        
        if (!emptyButtons.isEmpty()) {
            Random random = new Random();
            JButton selectedButton = emptyButtons.get(random.nextInt(emptyButtons.size()));
            selectedButton.setText("O");
            winningGame();
        }
    }
        
        private boolean checkWinningCondition(String player) {
        String b1 = jbtn1.getText();
        String b2 = jbtn2.getText();
        String b3 = jbtn3.getText();
        String b4 = jbtn4.getText();
        String b5 = jbtn5.getText();
        String b6 = jbtn6.getText();
        String b7 = jbtn7.getText();
        String b8 = jbtn8.getText();
        String b9 = jbtn9.getText();
        
        // Kondisi menang horizontal
        if (b1.equals(player) && b2.equals(player) && b3.equals(player)) return true;
        if (b4.equals(player) && b5.equals(player) && b6.equals(player)) return true;
        if (b7.equals(player) && b8.equals(player) && b9.equals(player)) return true;
        
        // Kondisi menang vertikal
        if (b1.equals(player) && b4.equals(player) && b7.equals(player)) return true;
        if (b2.equals(player) && b5.equals(player) && b8.equals(player)) return true;
        if (b3.equals(player) && b6.equals(player) && b9.equals(player)) return true;
        
        // Kondisi menang diagonal
        if (b1.equals(player) && b5.equals(player) && b9.equals(player)) return true;
        if (b3.equals(player) && b5.equals(player) && b7.equals(player)) return true;
        
        return false;
    }
    
    private void winningGame() {
        String b1 = jbtn1.getText();
        String b2 = jbtn2.getText();
        String b3 = jbtn3.getText();
        String b4 = jbtn4.getText();
        String b5 = jbtn5.getText();
        String b6 = jbtn6.getText();
        String b7 = jbtn7.getText();
        String b8 = jbtn8.getText();
        String b9 = jbtn9.getText();
        
        // Cek kemenangan X
        if (checkWinningCondition("X")) {
            JOptionPane.showMessageDialog(this, "Player X Won", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            xCount++;
            gameScore();
            gameOver = true;
            disableButtons();
        }
        
        // Cek kemenangan O
        if (checkWinningCondition("O")) {
            JOptionPane.showMessageDialog(this, "Computer Won", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            oCount++;
            gameScore();
            gameOver = true;
            disableButtons();
        }
        
        // Cek seri
        if (!gameOver && isAllButtonsFilled()) {
            JOptionPane.showMessageDialog(this, "Draw!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            gameOver = true;
        }
    }
    
    private boolean isAllButtonsFilled() {
        JButton[] buttons = {jbtn1, jbtn2, jbtn3, jbtn4, jbtn5, jbtn6, jbtn7, jbtn8, jbtn9};
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    private void disableButtons() {
        JButton[] buttons = {jbtn1, jbtn2, jbtn3, jbtn4, jbtn5, jbtn6, jbtn7, jbtn8, jbtn9};
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }
    
    // Metode untuk button click dengan tambahan logika komputer
    private void playerMove(JButton button) {
        if (!gameOver && button.getText().isEmpty()) {
            button.setText("X");
            winningGame();
            
            if (!gameOver) {
                computerMove();
            }
        }
    }
    
    // Metode untuk reset game
    private void resetGame() {
        JButton[] buttons = {jbtn1, jbtn2, jbtn3, jbtn4, jbtn5, jbtn6, jbtn7, jbtn8, jbtn9};
        
        for (JButton button : buttons) {
            button.setText("");
            button.setEnabled(true);
            button.setBackground(Color.LIGHT_GRAY);
        }
        
        gameOver = false;
        startGame = "X";
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
        txtplayer = new javax.swing.JTextField();
        txtcomputer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jblriwayat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 102));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

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

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COMPUTER :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PLAYER :");

        txtplayer.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtplayer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtplayer.setText("0");

        txtcomputer.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtcomputer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcomputer.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtplayer, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtcomputer))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtplayer)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcomputer))
                .addGap(38, 38, 38))
        );

        jLabel1.setFont(new java.awt.Font("STHupo", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AMBAGAME");

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

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Simpan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("AmbaGame", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel4.setFont(new java.awt.Font("STHupo", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Amba Score");

        jblriwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Player", "Computer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jblriwayat);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("AmbaScore", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           resetGame();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           resetGame();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn1ActionPerformed
        playerMove(jbtn1);
    }//GEN-LAST:event_jbtn1ActionPerformed

    private void jbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn2ActionPerformed
        playerMove(jbtn2);
    }//GEN-LAST:event_jbtn2ActionPerformed

    private void jbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn3ActionPerformed
        playerMove(jbtn3);
    }//GEN-LAST:event_jbtn3ActionPerformed

    private void jbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn4ActionPerformed
        playerMove(jbtn4);
    }//GEN-LAST:event_jbtn4ActionPerformed

    private void jbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn5ActionPerformed
        playerMove(jbtn5);
    }//GEN-LAST:event_jbtn5ActionPerformed

    private void jbtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn6ActionPerformed
        playerMove(jbtn6);

    }//GEN-LAST:event_jbtn6ActionPerformed

    private void jbtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn7ActionPerformed
        playerMove(jbtn7);
     
    }//GEN-LAST:event_jbtn7ActionPerformed

    private void jbtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn8ActionPerformed
        playerMove(jbtn8);      
    }//GEN-LAST:event_jbtn8ActionPerformed

    private void jbtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn9ActionPerformed
        playerMove(jbtn9);   
    }//GEN-LAST:event_jbtn9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        frame1 frame1 = new frame1();
        frame1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    String playerX = txtplayer.getText();
    String playerO = txtcomputer.getText();
    String scoreXText = txtplayer.getText();
    String scoreOText = txtcomputer.getText();

    if (playerX.isEmpty() || playerO.isEmpty() || scoreXText.isEmpty() || scoreOText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        int scoreX = Integer.parseInt(scoreXText);
        int scoreO = Integer.parseInt(scoreOText);

        DefaultTableModel model = (DefaultTableModel) jblriwayat.getModel();
        model.addRow(new Object[]{playerX, playerO, scoreX, scoreO});

        resetFields();
        JOptionPane.showMessageDialog(null, "Skor berhasil disimpan ke tabel!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Skor harus berupa angka!", "Error", JOptionPane.WARNING_MESSAGE);
    } 
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Frame4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame4().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jblriwayat;
    private javax.swing.JButton jbtn1;
    private javax.swing.JButton jbtn2;
    private javax.swing.JButton jbtn3;
    private javax.swing.JButton jbtn4;
    private javax.swing.JButton jbtn5;
    private javax.swing.JButton jbtn6;
    private javax.swing.JButton jbtn7;
    private javax.swing.JButton jbtn8;
    private javax.swing.JButton jbtn9;
    private javax.swing.JTextField txtcomputer;
    private javax.swing.JTextField txtplayer;
    // End of variables declaration//GEN-END:variables
}
