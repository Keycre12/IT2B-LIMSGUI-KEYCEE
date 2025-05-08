/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.adminDashboard;
import config.Session;
import config.dbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Keycee Bolambot
 */
public class userAccRec extends javax.swing.JFrame {

    /**
     * Creates new form userAccRec
     */
    public userAccRec() {
        initComponents();
    }

     public void logEvent(int userId, String username, String action) 
    {
        dbConnect dbc = new dbConnect();
        Connection con = dbc.getConnection();
        PreparedStatement pstmt = null;
        Timestamp time = new Timestamp(new Date().getTime());

        try 
        {
            String sql = "INSERT INTO logs (u_id, u_un, log_action, log_time) "
                    + "VALUES ('" + userId + "', '" + username + "', '" + action + "', '" + time + "')";
            pstmt = con.prepareStatement(sql);

            pstmt.executeUpdate();
            System.out.println("Login Log recorded successfully.");
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Error recording log: " + e.getMessage());
        } finally //This is a database closer
        {
            try 
            {
                if (pstmt != null) 
                {
                    pstmt.close();
                }
                if (con != null) 
                {
                    con.close();
                }
            } catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        navi1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        accid = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Header1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        navi2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        accid1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        acctype = new javax.swing.JLabel();
        accfname = new javax.swing.JLabel();
        acclname = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        anss = new javax.swing.JTextField();
        confirm1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        sec = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("    PASSWORD RECOVERY");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        Header.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 80, 60));

        navi1.setBackground(new java.awt.Color(102, 102, 102));
        navi1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        navi1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, 12));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limsgui/images/userb.png"))); // NOI18N
        navi1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 110));

        accid.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        accid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accid.setText("ID");
        navi1.add(accid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setText("CURRENT USER:");
        navi1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 210, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setText("USERS");
        navi1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 90, 30));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header1.setBackground(new java.awt.Color(255, 204, 102));
        Header1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header1.setForeground(new java.awt.Color(255, 204, 102));
        Header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("   FORGOT PASSWORD");
        Header1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        Header1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 90, 60));

        jPanel1.add(Header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1013, -1));

        navi2.setBackground(new java.awt.Color(102, 102, 102));
        navi2.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        navi2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, 12));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limsgui/images/userb.png"))); // NOI18N
        navi2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 110, 110));

        accid1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        accid1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accid1.setText("ID");
        navi2.add(accid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 90, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("CURRENT USER:");
        navi2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 210, 30));

        acctype.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        acctype.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acctype.setText("USERS");
        navi2.add(acctype, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 30));

        accfname.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        accfname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accfname.setText("USERS");
        navi2.add(accfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 210, 30));

        acclname.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        acclname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acclname.setText("USERS");
        navi2.add(acclname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 210, 30));

        jPanel1.add(navi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 280, 570));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(anss, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 350, 30));

        confirm1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirm1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirm1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirm1MouseExited(evt);
            }
        });
        confirm1.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Confirm");
        confirm1.add(jLabel12);
        jLabel12.setBounds(0, 10, 90, 10);

        jPanel2.add(confirm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, 90, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel14.setText("Security Question:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, -1, 30));

        sec.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        sec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your nickname?", "What is your first pet name?", "What is your middle initial?" }));
        jPanel2.add(sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 350, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lockk.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 390, 350));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1013, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(navi1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(navi1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        adminDashboard adb = new adminDashboard();
        adb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void confirm1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirm1MouseClicked
        //        dbConnect dbc = new dbConnect();
        //        Session ses = Session.getInstance();
        //        String secQuestion = secq.getSelectedItem().toString();
        //        String secAnswer = ans.getText();
        //        dbConnect connector = new dbConnect();
        //        int userId = 0;
        //        String uname2 = null;
        //
        //        if(secAnswer.isEmpty())
        //        {
            //            JOptionPane.showMessageDialog(null, "Please Fill All Boxes");
            //        }else
        //        {
            //            System.out.println("1");
            //
            //            //            dbc.updateData("UPDATE tbl_accounts SET security_question = '" + secQuestion + "', security_answer='" + secAnswer + "' WHERE u_id = '" + sess.getUid() + "'");
            //
            //            System.out.println("2");
            //            System.out.println(""+ses.getUid());
            //            System.out.println(""+secQuestion);
            //            System.out.println(""+secAnswer);
            //
            //try {
                //    String query = "UPDATE users SET sec_ques = ?, sec_ans = ? WHERE u_id = ?";
                //    PreparedStatement pstmt2 = connector.getConnection().prepareStatement(query);
                //    pstmt2.setString(1, secQuestion);
                //    pstmt2.setString(2, secAnswer);
                //    pstmt2.setInt(3, ses.getUid());
                //    int rowsAffected = pstmt2.executeUpdate();
                //    pstmt2.close();
                //
                //    if (rowsAffected > 0) {
                    //        System.out.println("Update successful.");
                    //    } else {
                    //        System.out.println("No rows updated.");
                    //    }
                //
                //    // Insert into forgotpass table
                //    String insertQuery = "INSERT INTO forgotpass (u_id, fps_ques, fps_ans) VALUES (?, ?, ?)";
                //    PreparedStatement insertStmt = connector.getConnection().prepareStatement(insertQuery);
                //    insertStmt.setInt(1, ses.getUid());
                //    insertStmt.setString(2, secQuestion);
                //    insertStmt.setString(3, secAnswer);
                //    insertStmt.executeUpdate();
                //    insertStmt.close();
                //
                //    String query2 = "SELECT * FROM users WHERE u_id = ?";
                //    PreparedStatement pstmt = connector.getConnection().prepareStatement(query2);
                //    pstmt.setInt(1, ses.getUid());
                //    ResultSet resultSet = pstmt.executeQuery();
                //
                //    if (resultSet.next()) {
                    //        userId = resultSet.getInt("u_id");
                    //        uname2 = resultSet.getString("u_un");
                    //    }
                //
                //    pstmt.close();
                //    resultSet.close();
                //} catch (SQLException ex) {
                //    System.out.println("SQL Exception: " + ex);
                //}
            //
            //
            //            logEvent(userId, uname2, "User Changed Their Details");
            //
            //            adminDashboard ed = new adminDashboard();
            //            ed.setVisible(true);
            //            this.dispose();
            //        }

        dbConnect dbc = new dbConnect();
        Session ses = Session.getInstance();
        String secQues = sec.getSelectedItem().toString();
        String secAns = anss.getText();
        dbConnect connector = new dbConnect();
        int userId = 0;
        String uname2 = null;

        if(secAns.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Fill All Boxes");
        }else
        {
            System.out.println("1");
            System.out.println("2");
            System.out.println(""+ses.getUid());
            System.out.println(""+secQues);
            System.out.println(""+secAns);

            try
            {
                String query = "UPDATE users SET sec_ques = ?, sec_ans = ? WHERE u_id = ?";
                PreparedStatement pstmt2 = connector.getConnection().prepareStatement(query);
                pstmt2.setString(1, secQues);
                pstmt2.setString(2, secAns);
                pstmt2.setInt(3, ses.getUid());

                int rowsAffected = pstmt2.executeUpdate(); 
                if (rowsAffected > 0) {
                    System.out.println("Update successful.");
                } else {
                    System.out.println("No rows updated.");
                }

                String query2 = "SELECT * FROM users WHERE u_id = '" + ses.getUid() + "'";
                PreparedStatement pstmt = connector.getConnection().prepareStatement(query2);

                ResultSet resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    userId = resultSet.getInt("u_id");  
                    uname2 = resultSet.getString("u_un");
                }
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex);
            }

            logEvent(userId, uname2, "User Changed Their Details");

            adminDashboard ed = new adminDashboard();
            ed.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_confirm1MouseClicked

    private void confirm1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirm1MouseEntered
        //        confirm.setBackground(h);
    }//GEN-LAST:event_confirm1MouseEntered

    private void confirm1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirm1MouseExited
        //        confirm.setBackground(d);
    }//GEN-LAST:event_confirm1MouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        UserDashboard adb = new UserDashboard();
        adb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(userAccRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userAccRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userAccRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userAccRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userAccRec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Header1;
    private javax.swing.JLabel accfname;
    private javax.swing.JLabel accid;
    private javax.swing.JLabel accid1;
    private javax.swing.JLabel acclname;
    private javax.swing.JLabel acctype;
    private javax.swing.JTextField anss;
    private javax.swing.JPanel confirm1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel navi1;
    private javax.swing.JPanel navi2;
    private javax.swing.JComboBox<String> sec;
    // End of variables declaration//GEN-END:variables
}
