/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.adminAccRecovery;
import admin.adminUsers;
import config.Session;
import config.dbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import limsgui.loginForm;

/**
 *
 * @author Keycee Bolambot
 */
public class UserDashboard extends javax.swing.JFrame {

    /**
     * Creates new form UserDashboard
     */
    public UserDashboard() {
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

        Mainpanel1 = new javax.swing.JPanel();
        Header1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        acd = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        navi1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        firstn = new javax.swing.JLabel();
        lastn = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        passrecov = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Mainpanel1.setBackground(new java.awt.Color(204, 204, 204));
        Mainpanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Mainpanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header1.setBackground(new java.awt.Color(255, 204, 102));
        Header1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header1.setForeground(new java.awt.Color(255, 204, 102));
        Header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("USER DASHBOARD!");
        Header1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        Header1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 80, 60));

        Mainpanel1.add(Header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 80));

        acd.setBackground(new java.awt.Color(204, 204, 204));
        acd.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        acd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acdMouseClicked(evt);
            }
        });
        acd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DETAILS");
        acd.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 20));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accdt.png"))); // NOI18N
        acd.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setText("ACCOUNT");
        acd.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        Mainpanel1.add(acd, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 170, 180));

        navi1.setBackground(new java.awt.Color(102, 102, 102));
        navi1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sluser.png"))); // NOI18N
        jPanel3.add(jLabel3);

        navi1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 140, 140));

        firstn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        firstn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstn.setText("USER");
        navi1.add(firstn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 140, -1));

        lastn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lastn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastn.setText("USER");
        navi1.add(lastn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 140, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logosmallerver.png"))); // NOI18N
        navi1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 130, 110));

        Mainpanel1.add(navi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 280, 570));

        passrecov.setBackground(new java.awt.Color(204, 204, 204));
        passrecov.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        passrecov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passrecovMouseClicked(evt);
            }
        });
        passrecov.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RECOVERY");
        passrecov.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PASSWORD");
        passrecov.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accrec.png"))); // NOI18N
        passrecov.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 56, 130, 110));

        Mainpanel1.add(passrecov, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 170, 180));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BOOKS");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 30));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookss.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 100, 70));

        Mainpanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 170, 180));

        getContentPane().add(Mainpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session ses = Session.getInstance();
      

        if (ses.getUid() == 0) {
            JOptionPane.showMessageDialog(null, "No account, Login First!");
            loginForm lf = new loginForm();
            lf.setVisible(true);
            this.dispose();
        }else{
            
        firstn.setText(""+ses.getFname());
        lastn.setText(""+ses.getLname());
        }

    }//GEN-LAST:event_formWindowActivated

    private void acdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acdMouseClicked
        accDetails ad = new accDetails();
        ad.setVisible(true);
        this.dispose( );
    }//GEN-LAST:event_acdMouseClicked

    private void passrecovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passrecovMouseClicked
        adminAccRecovery aar = new adminAccRecovery();
        aar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_passrecovMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        loginForm lf = new loginForm();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header1;
    private javax.swing.JPanel Mainpanel1;
    private javax.swing.JPanel acd;
    private javax.swing.JLabel firstn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lastn;
    private javax.swing.JPanel navi1;
    private javax.swing.JPanel passrecov;
    // End of variables declaration//GEN-END:variables
}
