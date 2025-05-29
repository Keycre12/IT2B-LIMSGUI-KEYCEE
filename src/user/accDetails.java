/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.createUserForm;
import config.Session;
import config.dbConnect;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import limsgui.loginForm;

/**
 *
 * @author Keycee Bolambot
 */
public class accDetails extends javax.swing.JFrame {

    /**
     * Creates new form accDetails
     */
    public accDetails() {
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
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        navi = new javax.swing.JPanel();
        f_name = new javax.swing.JLabel();
        p_add1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        p_add = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        l_name = new javax.swing.JLabel();
        phonelab = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lnlab = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        userlab = new javax.swing.JLabel();
        emlab = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        uns = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        fnlab = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        iddisp = new javax.swing.JLabel();

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

        jLabel4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ACCOUNT INFORMATION");
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 80, 60));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 80));

        navi.setBackground(new java.awt.Color(102, 102, 102));
        navi.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        f_name.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        f_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f_name.setText("USER");
        navi.add(f_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 260, 40));

        p_add1.setBackground(new java.awt.Color(102, 102, 102));
        p_add1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        p_add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_add1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_add1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_add1MouseExited(evt);
            }
        });
        p_add1.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel14.setText("PASS RECOVERY");
        p_add1.add(jLabel14);
        jLabel14.setBounds(10, 0, 160, 30);

        navi.add(p_add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 180, 30));

        p_add.setBackground(new java.awt.Color(102, 102, 102));
        p_add.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        p_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_addMouseExited(evt);
            }
        });
        p_add.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel11.setText("CHANGE PASS");
        p_add.add(jLabel11);
        jLabel11.setBounds(20, 0, 140, 30);

        navi.add(p_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 180, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sluser.png"))); // NOI18N
        jPanel1.add(image);
        image.setBounds(10, 10, 120, 130);

        navi.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 140, 150));

        l_name.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        l_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_name.setText("USER");
        navi.add(l_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 250, -1));

        getContentPane().add(navi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 280, 570));

        phonelab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        phonelab.setForeground(new java.awt.Color(204, 0, 0));
        phonelab.setText(" ");
        getContentPane().add(phonelab, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 260, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Username:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 90, 40));

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Librarian", "Staff" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        getContentPane().add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 260, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Last Name:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 90, 50));

        lnlab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lnlab.setForeground(new java.awt.Color(204, 0, 0));
        lnlab.setText(" ");
        getContentPane().add(lnlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 260, -1));

        phone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        phone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneKeyReleased(evt);
            }
        });
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 260, 40));

        userlab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        userlab.setForeground(new java.awt.Color(204, 0, 0));
        userlab.setText(" ");
        getContentPane().add(userlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, 260, -1));

        emlab.setForeground(new java.awt.Color(204, 0, 0));
        emlab.setText(" ");
        getContentPane().add(emlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 260, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Type:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 90, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("First Name:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 90, 50));

        uns.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        uns.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unsActionPerformed(evt);
            }
        });
        uns.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unsKeyReleased(evt);
            }
        });
        getContentPane().add(uns, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 260, 40));

        lname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lnameKeyReleased(evt);
            }
        });
        getContentPane().add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 260, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Contact:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 110, 40));

        fname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fnameKeyReleased(evt);
            }
        });
        getContentPane().add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 260, 40));

        fnlab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        fnlab.setForeground(new java.awt.Color(204, 0, 0));
        fnlab.setText(" ");
        getContentPane().add(fnlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 260, -1));

        email.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailKeyReleased(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 260, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Email:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 90, 40));

        iddisp.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        iddisp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iddisp.setText("UID:");
        getContentPane().add(iddisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 330, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void p_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseClicked
        changePass cp = new changePass();
        cp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_p_addMouseClicked

    private void p_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseEntered
//        p_add.setBackground(hovercolor);
    }//GEN-LAST:event_p_addMouseEntered

    private void p_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseExited
//        p_add.setBackground(navcolor);
    }//GEN-LAST:event_p_addMouseExited

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void phoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneKeyReleased
        String PATTERN = "^09\\d{9}$";
        Pattern pt = Pattern.compile(PATTERN);
        Matcher match = pt.matcher(phone.getText());

        if (!match.matches()) {
            phonelab.setText("Phone number must be 11 digits.");
        } else {
            phonelab.setText(null);
        }
    }//GEN-LAST:event_phoneKeyReleased

    private void unsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unsActionPerformed

    private void unsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unsKeyReleased
        String USERNAME_PATTERN = "^[a-zA-Z0-9._]{5,20}$";
        Pattern pt = Pattern.compile(USERNAME_PATTERN);
        Matcher match = pt.matcher(uns.getText());

        if (!match.matches()) {
            userlab.setText("Invalid username, try again...");
        } else {
            userlab.setText(null);
        }
    }//GEN-LAST:event_unsKeyReleased

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void lnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyReleased
        String PATTERN = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
        Pattern pt = Pattern.compile(PATTERN);
        Matcher match = pt.matcher(lname.getText());
        if (!match.matches()){
            lnlab.setText("Last Name is incorrect");
        }
        else{
            lnlab.setText(null);
        }
    }//GEN-LAST:event_lnameKeyReleased

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void fnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyReleased
        // TODO add your handling code here:
        String PATTERN = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
        Pattern pt = Pattern.compile(PATTERN);
        Matcher match = pt.matcher(fname.getText());

        if (!match.matches()) {
            fnlab.setText("First Name is incorrect..");
        } else {
            fnlab.setText(null);
        }
    }//GEN-LAST:event_fnameKeyReleased

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pt = Pattern.compile(EMAIL_PATTERN);
        Matcher match = pt.matcher(email.getText());

        if (!match.matches()) {
            emlab.setText("Invalid email format.");
        } else {
            emlab.setText(null);
        }
    }//GEN-LAST:event_emailKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session ses = Session.getInstance();
        if (ses.getUid() == 0) {
            JOptionPane.showMessageDialog(null, "No account, Login First!");
            loginForm lf = new loginForm();
            lf.setVisible(true);
            this.dispose();
        }else{
        iddisp.setText("USER ID:"+ses.getUid());
        l_name.setText(""+ses.getFname());
        f_name.setText(""+ses.getLname());
        fname.setText(""+ses.getFname());
        lname.setText(""+ses.getLname());
        phone.setText(""+ses.getLname());
        email.setText(""+ses.getEmail());
        uns.setText(""+ses.getUsername());
        
        }
    }//GEN-LAST:event_formWindowActivated

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        UserDashboard adb = new UserDashboard();
        adb.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void p_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_add1MouseClicked
        userAccRec aar = new userAccRec();
        aar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_p_add1MouseClicked

    private void p_add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_add1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_p_add1MouseEntered

    private void p_add1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_add1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_p_add1MouseExited

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
            java.util.logging.Logger.getLogger(accDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emlab;
    private javax.swing.JLabel f_name;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel fnlab;
    private javax.swing.JLabel iddisp;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_name;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel lnlab;
    private javax.swing.JPanel navi;
    private javax.swing.JPanel p_add;
    private javax.swing.JPanel p_add1;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel phonelab;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JTextField uns;
    private javax.swing.JLabel userlab;
    // End of variables declaration//GEN-END:variables
}
