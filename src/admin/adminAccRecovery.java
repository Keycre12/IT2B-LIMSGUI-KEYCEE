/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import limsgui.loginForm;

/**
 *
 * @author Keycee Bolambot
 */
public class adminAccRecovery extends javax.swing.JFrame {

    /**
     * Creates new form adminAccRecovery
     */
    public adminAccRecovery() {
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
        jLabel3 = new javax.swing.JLabel();
        navi = new javax.swing.JPanel();
        navi1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        accid = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        acctype = new javax.swing.JLabel();
        accfname = new javax.swing.JLabel();
        acclname = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ans = new javax.swing.JTextField();
        confirm = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        secq = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("   FORGOT PASSWORD");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        Header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 90, 60));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1013, -1));

        navi.setBackground(new java.awt.Color(102, 102, 102));
        navi.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(navi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, -1, -1));

        navi1.setBackground(new java.awt.Color(102, 102, 102));
        navi1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        navi1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, 12));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userb.png"))); // NOI18N
        navi1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 110, 110));

        accid.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        accid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accid.setText("ID");
        navi1.add(accid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setText("CURRENT USER:");
        navi1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 210, 30));

        acctype.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        acctype.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acctype.setText("USERS");
        navi1.add(acctype, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 30));

        accfname.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        accfname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accfname.setText("USERS");
        navi1.add(accfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 210, 30));

        acclname.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        acclname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acclname.setText("USERS");
        navi1.add(acclname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 210, 30));

        getContentPane().add(navi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 280, 570));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 350, 30));

        confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmMouseExited(evt);
            }
        });
        confirm.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Confirm");
        confirm.add(jLabel11);
        jLabel11.setBounds(0, 10, 90, 10);

        jPanel1.add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, 90, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setText("Security Question:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, -1, 30));

        secq.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        secq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your nickname?", "What is your first pet name?", "What is your middle initial?", "What is the name of your mother?", "What city you were born?" }));
        jPanel1.add(secq, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 350, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lockk.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 390, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmMouseClicked
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
        String secQues = secq.getSelectedItem().toString();
        String secAns = ans.getText();
        dbConnect connector = new dbConnect();
        int userId = 0;
        String uname2 = null;

        if(secAns.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Fill All Boxes");
        }else
        {
            System.out.println("1");
            
//            dbc.updateData("UPDATE tbl_accounts SET security_question = '" + secQuestion + "', security_answer='" + secAnswer + "' WHERE u_id = '" + sess.getUid() + "'");
            
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

                int rowsAffected = pstmt2.executeUpdate(); // Executes the update query
                if (rowsAffected > 0) {
                    System.out.println("Update successful.");
                } else {
                    System.out.println("No rows updated.");
                }
                

                String query2 = "SELECT * FROM users WHERE u_id = '" + ses.getUid() + "'";
                PreparedStatement pstmt = connector.getConnection().prepareStatement(query2);

                ResultSet resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    userId = resultSet.getInt("u_id");   // Update the outer `userId` correctly
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
                                        

    }//GEN-LAST:event_confirmMouseClicked

    private void confirmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmMouseEntered
//        confirm.setBackground(h);
    }//GEN-LAST:event_confirmMouseEntered

    private void confirmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmMouseExited
//        confirm.setBackground(d);
    }//GEN-LAST:event_confirmMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        adminDashboard adb = new adminDashboard();
        adb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
       if(ses.getUid() == 0)
       {
           JOptionPane.showMessageDialog(null,"No Account, Login FIrst");
           loginForm l = new loginForm();
           l.setVisible(true);
           this.dispose();
       }else
       {
           accfname.setText("" + ses.getFname());
           acclname.setText("" + ses.getLname());
           
           acctype.setText("" + ses.getType());
           accid.setText("" + ses.getUid());
       }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(adminAccRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminAccRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminAccRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminAccRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminAccRecovery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JLabel accfname;
    private javax.swing.JLabel accid;
    private javax.swing.JLabel acclname;
    private javax.swing.JLabel acctype;
    private javax.swing.JTextField ans;
    private javax.swing.JPanel confirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel navi;
    private javax.swing.JPanel navi1;
    private javax.swing.JComboBox<String> secq;
    // End of variables declaration//GEN-END:variables
}
