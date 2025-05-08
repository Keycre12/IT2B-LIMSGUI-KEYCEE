/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import config.dbConnect;
import java.awt.Color;
import limsgui.loginForm;

/**
 *
 * @author Keycee Bolambot
 */
public class userGuest extends javax.swing.JFrame {

    /**
     * Creates new form userGuest
     */
    public userGuest() {
        initComponents();
    }

    Color navcolor = new Color(102,102,102);
    Color hovercolor = new Color(204,204,204);
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        navi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        usern = new javax.swing.JTextField();
        search = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOOKING FOR A BOOK? SEARCH HERE");
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

        usern.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usern.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernActionPerformed(evt);
            }
        });
        getContentPane().add(usern, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 265, 40));

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

        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 80, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel7.setText("Search Book Title......");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 166, 265, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel4.setText("COMING SOON..");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(569, 366, -1, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("LOGOUT");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel3.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 560, 70, 80));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernActionPerformed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
//        dbConnect connector = new dbConnect();
//        String username = usern.getText();
//        String answer = null;
//
//        if (username.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please enter your username.");
//            return;
//        }
//
//        // Create a database connection
//        dbConnect db = new dbConnect();  // Instantiate dbConnector
//        Connection con = db.getConnection(); // Get connection
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
//        if (con == null) {
//            JOptionPane.showMessageDialog(this, "Database connection failed. Please try again later.");
//            return;
//        }else if(answer.equals(""))
//        {
//            JOptionPane.showMessageDialog(this, "You did not set a password recovery for your account.");
//            loginForm l = new loginForm();
//            l.setVisible(true);
//            this.dispose();
//        }else
//        {
//
//            try {
//                PreparedStatement stmt = con.prepareStatement(
//                    "SELECT sec_ques, sec_ans FROM users WHERE u_un = ?"
//                );
//                stmt.setString(1, username);
//                ResultSet rs = stmt.executeQuery();
//
//                if (rs.next()) {
//                    secq.removeAllItems();
//                    secq.addItem(rs.getString("sec_ques"));
//                    secq.setEnabled(true);
//                    correctAnswer = rs.getString("sec_ans");
//                    confirm.setEnabled(true);
//                } else {
//                    JOptionPane.showMessageDialog(this, "Username not found.");
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(this, "An error occurred while fetching the security question.");
//            } finally {
//                try {
//                    if (con != null) {
//                        con.close(); // Close the connection after use
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }//GEN-LAST:event_searchMouseClicked

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
        search.setBackground(navcolor);
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
        search.setBackground(hovercolor);
    }//GEN-LAST:event_searchMouseExited

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        loginForm lf = new loginForm();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

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
            java.util.logging.Logger.getLogger(userGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userGuest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel navi;
    private javax.swing.JPanel search;
    private javax.swing.JTextField usern;
    // End of variables declaration//GEN-END:variables
}
