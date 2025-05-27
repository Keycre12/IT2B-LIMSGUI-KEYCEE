/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limsgui;

import admin.adminDashboard;
import config.dbConnect;
import config.passwordHasher;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import static limsgui.loginForm.loginAcc;
import static limsgui.loginForm.status;

/**
 *
 * @author Keycee Bolambot
 */
public class forgotpass extends javax.swing.JFrame {

    private String correctAnswer;
    public forgotpass() {
        initComponents();
    }
    
    Color navcolor = new Color(102,102,102);
     Color hovercolor = new Color(204,204,204);
     
     
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
    
      private void fetchSecurityQuestion() {
        String username = usern.getText();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your username.");
            return;
        }

        // Create a database connection
        dbConnect db = new dbConnect();  // Instantiate dbConnector
        Connection con = db.getConnection(); // Get connection

        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed. Please try again later.");
            return;
        }

        try {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT security_question, security_answer FROM tbl_accounts WHERE u_username = ?"
            );
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                secq.removeAllItems();
                secq.addItem(rs.getString("sec_ques"));
                secq.setEnabled(true);
                correctAnswer = rs.getString("sec_ans");
                confirm.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Username not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while fetching the security question.");
        } finally {
            try {
                if (con != null) {
                    con.close(); // Close the connection after use
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void resetPassword() {
    String enteredAnswer = ans.getText().trim();
    String newPassword = new String(newpass.getPassword()).trim();
    String username = usern.getText().trim();

    if (correctAnswer == null) {
        JOptionPane.showMessageDialog(this, "Please search for your username first.");
        return;
    }

    if (!enteredAnswer.equalsIgnoreCase(correctAnswer)) {
        JOptionPane.showMessageDialog(this, "Incorrect security answer.");
        return;
    }

    if (newPassword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Password cannot be empty.");
        return;
    }

    try {
        String hashedPassword = passwordHasher.hashPassword(newPassword);
        dbConnect db = new dbConnect();
        Connection con = db.getConnection();

        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed. Please try again later.");
            return;
        }

        try {
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE users SET u_pass = ? WHERE u_un = ?"
            );
            stmt.setString(1, hashedPassword);
            stmt.setString(2, username);

            int rowsUpdated = stmt.executeUpdate();
            stmt.close();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Password successfully reset!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error: Username not found or password update failed.");
            }
        } finally {
            con.close();
        }
    } catch (NoSuchAlgorithmException ex) {
        JOptionPane.showMessageDialog(this, "Error hashing password: " + ex.getMessage());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "An error occurred while updating the password.");
    }
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        navi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ans = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        usern = new javax.swing.JTextField();
        newpass = new javax.swing.JPasswordField();
        blexit = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        secq = new javax.swing.JComboBox<>();

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setText("Answer:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("   FORGOT PASSWORD");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1013, -1));

        navi.setBackground(new java.awt.Color(102, 102, 102));
        navi.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        navi.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 570));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/books.png"))); // NOI18N
        navi.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 570));

        getContentPane().add(navi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Username:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 90, 50));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setText("Answer:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, -1, -1));

        ans.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });
        getContentPane().add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 260, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("New Password:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 120, 50));

        usern.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usern.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernActionPerformed(evt);
            }
        });
        getContentPane().add(usern, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 265, 40));

        newpass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        newpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 260, 40));

        blexit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        blexit.setText("Exit");
        blexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blexitMouseClicked(evt);
            }
        });
        blexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blexitActionPerformed(evt);
            }
        });
        getContentPane().add(blexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 100, 40));

        confirm.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        confirm.setText("Confirm");
        confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmMouseClicked(evt);
            }
        });
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 370, 100, 40));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 290, -1, 50));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel14.setText("Security Question:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        search.setBackground(new java.awt.Color(204, 204, 204));
        search.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMouseExited(evt);
            }
        });
        search.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searchs.png"))); // NOI18N
        jLabel3.setText("Search");
        search.add(jLabel3);
        jLabel3.setBounds(0, 0, 80, 30);

        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 80, 40));

        secq.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        secq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your nickname?", "What is your first pet name?", "What is your middle initial?" }));
        getContentPane().add(secq, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 260, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernActionPerformed

    private void blexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blexitActionPerformed
        loginForm lfm = new loginForm();
        lfm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_blexitActionPerformed

    private void confirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmMouseClicked
         String uns = usern.getText().trim();
         String an = ans.getText().trim();
         String np = new String(newpass.getPassword()).trim();
         dbConnect connector = new dbConnect();
         int userId = 0;

         if (uns.isEmpty() || an.isEmpty() || np.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Please fill in all fields before submitting.");
      
             return;
         }
            resetPassword();
         try {
             String query = "SELECT u_id FROM users WHERE u_un = ?";
             PreparedStatement pstmt = connector.getConnection().prepareStatement(query);
             pstmt.setString(1, uns);

             ResultSet resultSet = pstmt.executeQuery();

             if (resultSet.next()) {
                 System.out.println("User was received");
                 userId = resultSet.getInt("u_id");
             } else {
                 JOptionPane.showMessageDialog(this, "Username not found.");
                 return;
             }
         } catch (SQLException ex) {
             System.out.println("SQL Exception: " + ex);
             return;
         }

         System.out.println("Username: " + uns);
         System.out.println("User ID: " + userId);

         logEvent(userId, uns, "Forgot, and changed their password");

         loginForm l = new loginForm();
         l.setVisible(true);
         this.dispose();

    }//GEN-LAST:event_confirmMouseClicked

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
       
    }//GEN-LAST:event_confirmActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (newpass.getEchoChar() == '*') {
            newpass.setEchoChar((char) 0); // Show password
        } else {
            newpass.setEchoChar('*'); // Hide password
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansActionPerformed

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
        search.setBackground(navcolor);
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
        search.setBackground(hovercolor);
    }//GEN-LAST:event_searchMouseExited

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
//      dbConnect connector = new dbConnect();
//        String username = usern.getText();  
//        String answer = null;
//        
//    if (username.isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Please enter your username.");
//        return;
//    }
//
//    // Create a database connection
//    dbConnect db = new dbConnect();  // Instantiate dbConnector
//    Connection con = db.getConnection(); // Get connection
//        try {
//            String query = "SELECT * FROM users WHERE u_un = '" + username + "'";
//            PreparedStatement pstmt = connector.getConnection().prepareStatement(query);
//
//            ResultSet resultSet = pstmt.executeQuery();
//
//            if (resultSet.next()) {
//                answer = resultSet.getString("sec_ans");
//            }
//        } catch (SQLException ex) {
//            System.out.println("SQL Exception: " + ex);
//        }
//
//    if (con == null) {
//        JOptionPane.showMessageDialog(this, "Database connection failed. Please try again later.");
//        return;
//    }else if(answer.equals(""))
//    {
//        JOptionPane.showMessageDialog(this, "You did not set a password recovery for your account.");
//        loginForm l = new loginForm();
//        l.setVisible(true);
//        this.dispose();
//    }else
//    {
//
//        try {
//            PreparedStatement stmt = con.prepareStatement(
//                "SELECT sec_ques, sec_ans FROM users WHERE u_un = ?"
//            );
//            stmt.setString(1, username);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                secq.removeAllItems();
//                secq.addItem(rs.getString("sec_ques"));
//                secq.setEnabled(true);
//                correctAnswer = rs.getString("sec_ans");
//                confirm.setEnabled(true);
//            } else {
//                JOptionPane.showMessageDialog(this, "Username not found.");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "An error occurred while fetching the security question.");
//        } finally {
//            try {
//                if (con != null) {
//                    con.close(); // Close the connection after use
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }       

dbConnect connector = new dbConnect();
String username = usern.getText();  
String answer = null;

if (username.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please enter your username.");
    return;
}

// Create a database connection
dbConnect db = new dbConnect();  // Instantiate dbConnector
Connection con = db.getConnection(); // Get connection

if (con == null) {
    JOptionPane.showMessageDialog(this, "Database connection failed. Please try again later.");
    return;
}

try {
    // Check if the account exists
    String query = "SELECT * FROM users WHERE u_un = ?";
    PreparedStatement pstmt = connector.getConnection().prepareStatement(query);
    pstmt.setString(1, username);
    ResultSet resultSet = pstmt.executeQuery();

    if (!resultSet.next()) {
        JOptionPane.showMessageDialog(this, "Account doesn't exist.");
        return;
    }

    answer = resultSet.getString("sec_ans");

} catch (SQLException ex) {
    System.out.println("SQL Exception: " + ex);
    return;
}

if (answer == null || answer.isEmpty()) {
    JOptionPane.showMessageDialog(this, "You did not set a password recovery for your account.");
    loginForm l = new loginForm();
    l.setVisible(true);
    this.dispose();
} else {
    try {
        PreparedStatement stmt = con.prepareStatement(
            "SELECT sec_ques, sec_ans FROM users WHERE u_un = ?"
        );
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            secq.removeAllItems();
            secq.addItem(rs.getString("sec_ques"));
            secq.setEnabled(true);
            correctAnswer = rs.getString("sec_ans");
            confirm.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Username not found.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while fetching the security question.");
    } finally {
        try {
            if (con != null) {
                con.close(); // Close the connection after use
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    }//GEN-LAST:event_searchMouseClicked

    private void blexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blexitMouseClicked

    }//GEN-LAST:event_blexitMouseClicked

  
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
            java.util.logging.Logger.getLogger(forgotpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgotpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgotpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgotpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgotpass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JTextField ans;
    private javax.swing.JButton blexit;
    private javax.swing.JButton confirm;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel navi;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JPanel search;
    private javax.swing.JComboBox<String> secq;
    private javax.swing.JTextField usern;
    // End of variables declaration//GEN-END:variables
}
