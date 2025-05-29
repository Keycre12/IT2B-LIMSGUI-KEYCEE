
package user;

import config.Session;
import config.dbConnect;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import limsgui.loginForm;

/**
 *
 * @author Keycee Bolambot
 */
public class changePass extends javax.swing.JFrame {

    /**
     * Creates new form changePass
     */
    public changePass() {
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
        jLabel7 = new javax.swing.JLabel();
        navi = new javax.swing.JPanel();
        f_name = new javax.swing.JLabel();
        uid = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        l_name = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        npslab = new javax.swing.JLabel();
        oldpas = new javax.swing.JTextField();
        oldlab = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        back = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        saved = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cpslab = new javax.swing.JLabel();
        cpas = new javax.swing.JCheckBox();
        conpas = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        newpas = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
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
        jLabel4.setText("CHANGE PASSWORD");
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 80));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 80));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logosmallerver.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 120, 110));

        navi.setBackground(new java.awt.Color(102, 102, 102));
        navi.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        f_name.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        f_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f_name.setText("USER");
        navi.add(f_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 290, 40));

        uid.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        uid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uid.setText("UID:");
        navi.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 90, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("USERS ID:");
        navi.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 120, 40));

        l_name.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        l_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_name.setText("USER");
        navi.add(l_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 290, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sluser.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        navi.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 140, 140));

        getContentPane().add(navi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 530));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Confirm Pass:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 260, 30));

        npslab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        npslab.setForeground(new java.awt.Color(204, 0, 0));
        npslab.setText(" ");
        getContentPane().add(npslab, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 260, -1));

        oldpas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        oldpas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        oldpas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldpasActionPerformed(evt);
            }
        });
        oldpas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                oldpasKeyReleased(evt);
            }
        });
        getContentPane().add(oldpas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 260, 40));

        oldlab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        oldlab.setForeground(new java.awt.Color(204, 0, 0));
        oldlab.setText(" ");
        getContentPane().add(oldlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 260, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Type Old Pass:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 260, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Enter New Pass:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 260, 30));

        back.setBackground(new java.awt.Color(102, 102, 102));
        back.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        back.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("BACK");
        back.add(jLabel12);
        jLabel12.setBounds(10, 0, 90, 40);

        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 100, 40));

        saved.setBackground(new java.awt.Color(102, 102, 102));
        saved.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        saved.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                savedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                savedMouseExited(evt);
            }
        });
        saved.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SAVED");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        saved.add(jLabel11);
        jLabel11.setBounds(0, 0, 100, 40);

        getContentPane().add(saved, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 100, 40));

        cpslab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cpslab.setForeground(new java.awt.Color(204, 0, 0));
        cpslab.setText(" ");
        getContentPane().add(cpslab, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 260, -1));

        cpas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpasActionPerformed(evt);
            }
        });
        getContentPane().add(cpas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, 40));

        conpas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        conpas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                conpasKeyReleased(evt);
            }
        });
        getContentPane().add(conpas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 260, 40));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, -1, 40));

        newpas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newpas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpasActionPerformed(evt);
            }
        });
        newpas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newpasKeyReleased(evt);
            }
        });
        getContentPane().add(newpas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 260, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void oldpasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldpasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldpasActionPerformed

    private void oldpasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldpasKeyReleased
        String PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d!@#$%^&*()_+\\-=]{8,30}$";
        Pattern pt = Pattern.compile(PATTERN);
        String password = oldpas.getText().trim(); // Trim to remove spaces
        Matcher match = pt.matcher(password);
        if (!match.matches()){
            oldlab.setText("Password too short, at least be 8 characters long");
        }
        else{
            oldlab.setText(null);
        }
    }//GEN-LAST:event_oldpasKeyReleased

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
//        back.setBackground(hovercolor);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
//        back.setBackground(navcolor);
    }//GEN-LAST:event_backMouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
      try {
            dbConnect dbc = new dbConnect();
            Session ses = Session.getInstance();

            String query = "SELECT * FROM users WHERE u_id = ?";
            PreparedStatement pst = dbc.getConnection().prepareStatement(query);
            pst.setInt(1, ses.getUid());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String oldps = rs.getString("u_pass");  // Stored hashed password
                String oldhash = passwordHasher.hashPassword(oldpas.getText().trim());

                if (oldps.equals(oldhash)) {
                    String npass = newpas.getText().trim();
                    String cpass = conpas.getText().trim();

                    // Prevent reusing the old password
                    String hashedNPass = passwordHasher.hashPassword(npass);
                    if (oldps.equals(hashedNPass)) {
                        JOptionPane.showMessageDialog(null, "New password cannot be the same as the old password!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!npass.equals(cpass)) {
                        JOptionPane.showMessageDialog(null, "New password and Confirm password do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String updateQuery = "UPDATE users SET u_pass = ? WHERE u_id = ?";
                    PreparedStatement updateData = dbc.getConnection().prepareStatement(updateQuery);
                    updateData.setString(1, hashedNPass);
                    updateData.setInt(2, ses.getUid());

                    int rowsUpdated = updateData.executeUpdate();
                    if (rowsUpdated > 0) {
//                        loginForm lg = new loginForm();
//                        lg.setVisible(true);
//                        this.dispose();
                            accDetails adb = new accDetails();
                            adb.setVisible(true);
                            this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error updating password!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Old Password is Incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NoSuchAlgorithmException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "An error occurred while updating password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void savedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savedMouseEntered
//        saved.setBackground(hovercolor);
    }//GEN-LAST:event_savedMouseEntered

    private void savedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savedMouseExited
//        saved.setBackground(navcolor);
    }//GEN-LAST:event_savedMouseExited

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
            accDetails acds = new accDetails();
            acds.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void cpasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpasActionPerformed
            if (conpas.getEchoChar() == '*') {
                conpas.setEchoChar((char) 0); // Show password
            } else {
                conpas.setEchoChar('*'); // Hide password
            }
    }//GEN-LAST:event_cpasActionPerformed

    private void conpasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_conpasKeyReleased
        String PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d!@#$%^&*()_+\\-=]{8,30}$";
        Pattern pt = Pattern.compile(PATTERN);
        String password = conpas.getText().trim(); // Trim to remove spaces
        Matcher match = pt.matcher(password);
        if (!match.matches()) {
                    cpslab.setText("Password too short, at least be 8 characters long");
                }
                else{
                    cpslab.setText(null);
                }
    }//GEN-LAST:event_conpasKeyReleased

    private void newpasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpasKeyReleased
        String PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d!@#$%^&*()_+\\-=]{8,30}$";
        Pattern pt = Pattern.compile(PATTERN);
        String password = newpas.getText().trim(); // Trim to remove spaces
        Matcher match = pt.matcher(password);

        if (!match.matches()) {
            npslab.setText("Password must be 8-30 characters long");
        } else {
            npslab.setText(null);
        }

    }//GEN-LAST:event_newpasKeyReleased

    private void newpasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpasActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (newpas.getEchoChar() == '*') {
                newpas.setEchoChar((char) 0); // Show password
            } else {
                newpas.setEchoChar('*'); // Hide password
            }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        uid.setText(""+ses.getUid());
        f_name.setText(""+ses.getFname());
        l_name.setText(""+ses.getLname());
        
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
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel back;
    private javax.swing.JPasswordField conpas;
    private javax.swing.JCheckBox cpas;
    private javax.swing.JLabel cpslab;
    private javax.swing.JLabel f_name;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_name;
    private javax.swing.JPanel navi;
    private javax.swing.JPasswordField newpas;
    private javax.swing.JLabel npslab;
    private javax.swing.JLabel oldlab;
    private javax.swing.JTextField oldpas;
    private javax.swing.JPanel saved;
    private javax.swing.JLabel uid;
    // End of variables declaration//GEN-END:variables
}
