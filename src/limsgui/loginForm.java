/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limsgui;

import admin.adminDashboard;
import config.Session;
import config.dbConnect;
import config.passwordHasher;
import static config.passwordHasher.hashPassword;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import user.UserDashboard;

/**
 *
 * @author Keycee Bolambot
 */
public class loginForm extends javax.swing.JFrame {

    
    public loginForm() {
        initComponents();
    }
    
    
    Color hover = new Color(0, 51, 255);
    static String status;
    static String type;
   public static boolean loginAcc(String username, String passs ){
       dbConnect dbc = new dbConnect();
       try{
        String query = "SELECT * FROM users  WHERE u_un = '" + username + "'";
        ResultSet resultSet = dbc.getData(query);
        if(resultSet.next()){
            
        String hashedPass = (resultSet.getString("u_pass"));
        String rehashedPass = passwordHasher.hashPassword(passs);
        if(hashedPass.equals(rehashedPass)){
            status = resultSet.getString("status");
            type = resultSet.getString("u_type");
            Session ses = Session.getInstance();
            ses.setUid(resultSet.getInt("u_id"));
            ses.setFname(resultSet.getString("u_fname"));
            ses.setLname(resultSet.getString("u_lname"));
            ses.setContact(resultSet.getString("u_contact"));
            ses.setEmail(resultSet.getString("u_email"));
            ses.setUsername(resultSet.getString("u_un"));
            ses.setType(resultSet.getString("u_type"));
            ses.setStatus(resultSet.getString("status"));
            System.out.println(""+ses.getUid());
            return true;
             }else{
            System.out.println("Password Don't Match");
            return false;
           }
       }else{
           return false;
       }
       }catch (SQLException | NoSuchAlgorithmException ex){
           return false;
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Mainpanel = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        navi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        passs = new javax.swing.JPasswordField();
        regs = new javax.swing.JLabel();
        login = new javax.swing.JPanel();
        blexit = new javax.swing.JButton();
        blogin = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Mainpanel.setBackground(new java.awt.Color(204, 204, 204));
        Mainpanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Mainpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME TO MY SYSTEM!");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        Mainpanel.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1013, 80));

        navi.setBackground(new java.awt.Color(102, 102, 102));
        navi.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limsgui/images/logo.png"))); // NOI18N
        navi.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 570));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limsgui/images/books.png"))); // NOI18N
        navi.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 570));

        Mainpanel.add(navi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 510, 570));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setText("Login Form");
        Mainpanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 210, 50));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Username:");
        Mainpanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 90, 50));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Password:");
        Mainpanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 90, 50));

        username.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        Mainpanel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 260, 50));

        passs.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        passs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mainpanel.add(passs, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 260, 50));

        regs.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        regs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        regs.setText("New User? Click Here to Register!");
        regs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regsMouseClicked(evt);
            }
        });
        Mainpanel.add(regs, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 260, -1));

        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Mainpanel.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 430, -1, 40));

        blexit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        blexit.setText("Exit");
        blexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blexitActionPerformed(evt);
            }
        });
        Mainpanel.add(blexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 100, 40));

        blogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        blogin.setText("Login");
        blogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloginMouseClicked(evt);
            }
        });
        blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloginActionPerformed(evt);
            }
        });
        Mainpanel.add(blogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 100, 40));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        Mainpanel.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 360, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void regsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regsMouseClicked
       
        registrationForm rfm = new registrationForm();
        rfm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regsMouseClicked

    private void blexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blexitActionPerformed
        System.exit(0);

        
    }//GEN-LAST:event_blexitActionPerformed

    private void bloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloginActionPerformed
        if (username.getText().isEmpty() || passs.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required");
            return;
        }
        if(loginAcc(username.getText(),passs.getText())){
              if(!status.equals("Active")){
           JOptionPane.showMessageDialog(null,"In-Active Account, Contact the Admin!");
              }else{
           JOptionPane.showMessageDialog(null,"Login Success!");
            if(type.equals("Librarian")){
           adminDashboard ads = new adminDashboard();
           ads.setVisible(true);
           this.dispose();
              }else if(type.equals("Staff")){
               UserDashboard ud = new UserDashboard();
               ud.setVisible(true);
               this.dispose();
              }else{
                JOptionPane.showMessageDialog(null,"No Account type found, Contact the Admin");
              }
              }
       }else{
            JOptionPane.showMessageDialog(null,"Login Failed!");
               
        }
    }//GEN-LAST:event_bloginActionPerformed

    private void bloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bloginMouseClicked
        adminDashboard adm = new adminDashboard();
        adm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bloginMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (passs.getEchoChar() == '*') {
                passs.setEchoChar((char) 0); // Show password
            } else {
                passs.setEchoChar('*'); // Hide password
    }    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Mainpanel;
    private javax.swing.JButton blexit;
    private javax.swing.JButton blogin;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel login;
    private javax.swing.JPanel navi;
    private javax.swing.JPasswordField passs;
    private javax.swing.JLabel regs;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
