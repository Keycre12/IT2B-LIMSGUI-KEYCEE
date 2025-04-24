/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limsgui;

import config.dbConnect;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;


/**
 *
 * @author Keycee Bolambot
 */
import java.util.regex.Pattern;
public class registrationForm extends javax.swing.JFrame {

    /**
     * Creates new form registrationForm
     */
    public registrationForm() {
        initComponents();
    }
    public static String u_email,u_un;
   public boolean duplicateCheck() {
    dbConnect dbc = new dbConnect();
    try {
        String query = "SELECT * FROM users WHERE u_un = '" + un.getText() + "' OR u_email = '" + email.getText() + "'";
        ResultSet resultSet = dbc.getData(query);
        
        if (resultSet.next()) {
            if (resultSet.getString("u_email").equals(email.getText())) {
                JOptionPane.showMessageDialog(null, "Email is already used!");
                email.setText("");  // Clear email field
                return true;  // Stop further checks
            }

            if (resultSet.getString("u_un").equals(un.getText())) {
                JOptionPane.showMessageDialog(null, "Username is already used!!");
                un.setText("");  // Clear username field
                return true;  // Stop further checks
            }
        }
    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex);
    }
    return false;  // No duplicate found
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Mainpanel = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        navi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        lnlab = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        pslab = new javax.swing.JLabel();
        fnlab = new javax.swing.JLabel();
        emlab = new javax.swing.JLabel();
        phonelab = new javax.swing.JLabel();
        userlab = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        passs = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        secq = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        ans = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Mainpanel.setBackground(new java.awt.Color(204, 204, 204));
        Mainpanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(51, 51, 0)));
        Mainpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRATION FORM");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        Mainpanel.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        navi.setBackground(new java.awt.Color(102, 102, 102));
        navi.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limsgui/images/logo.png"))); // NOI18N
        navi.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 570));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limsgui/images/books.png"))); // NOI18N
        navi.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 570));

        Mainpanel.add(navi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 510, 570));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Username:");
        Mainpanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 90, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Type:");
        Mainpanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, 90, 40));

        un.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        un.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        un.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unKeyReleased(evt);
            }
        });
        Mainpanel.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 260, 40));

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Mainpanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, 110, 40));

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Mainpanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 590, 110, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Last Name:");
        Mainpanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 90, 50));

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
        Mainpanel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 260, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Email:");
        Mainpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 90, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("First Name:");
        Mainpanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 90, 50));

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
        Mainpanel.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 260, 40));

        lnlab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lnlab.setForeground(new java.awt.Color(204, 0, 0));
        lnlab.setText(" ");
        Mainpanel.add(lnlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 260, -1));

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
        Mainpanel.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 260, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Contact:");
        Mainpanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 110, 40));

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
        Mainpanel.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 260, 40));

        pslab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        pslab.setForeground(new java.awt.Color(204, 0, 0));
        pslab.setText(" ");
        Mainpanel.add(pslab, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 250, -1));

        fnlab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        fnlab.setForeground(new java.awt.Color(204, 0, 0));
        fnlab.setText(" ");
        Mainpanel.add(fnlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 260, -1));

        emlab.setForeground(new java.awt.Color(204, 0, 0));
        emlab.setText(" ");
        Mainpanel.add(emlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 260, 10));

        phonelab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        phonelab.setForeground(new java.awt.Color(204, 0, 0));
        phonelab.setText(" ");
        Mainpanel.add(phonelab, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 260, -1));

        userlab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        userlab.setForeground(new java.awt.Color(204, 0, 0));
        userlab.setText(" ");
        Mainpanel.add(userlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 260, -1));

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Librarian", "Staff" }));
        Mainpanel.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 260, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Password:");
        Mainpanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 80, 40));

        passs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passsKeyReleased(evt);
            }
        });
        Mainpanel.add(passs, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 260, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setText("Answer:");
        Mainpanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, -1, 20));

        secq.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        secq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your nickname?", "What is your first pet name?", "What is your middle initial?" }));
        Mainpanel.add(secq, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 260, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setText("Security Question:");
        Mainpanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, -1, -1));

        ans.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });
        Mainpanel.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 492, 260, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Mainpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      loginForm lfm = new loginForm();
      lfm.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  
        if (fname.getText().isEmpty() 
        || lname.getText().isEmpty() 
        || email.getText().isEmpty() 
        || phone.getText().isEmpty()
        || un.getText().isEmpty() 
        || passs.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required");
        return;
    } else if (duplicateCheck()) {
        System.out.println("Duplicate Exist");
         return;
    } else {
        dbConnect dbc = new dbConnect();
        try{
            String pass = passwordHasher.hashPassword(passs.getText());
      
//        if (dbc.insertData("INSERT INTO users (u_fname, u_lname, u_contact, u_email, u_un, u_pass, u_type, status)"
//                + "VALUES('" + fname.getText() + "','" + lname.getText() + "', '" + phone.getText() + "',"
//                + " '" + email.getText() + "', '" + un.getText() + "', '" + pass + "',"
//                + " '" + type.getSelectedItem() + "', 'Pending')") == 0) {
        if (dbc.insertData("INSERT INTO users (u_fname, u_lname, u_contact, u_email, u_un, u_pass, u_type, status, securityq, answer) "
        + "VALUES('" + fname.getText() + "', '" + lname.getText() + "', '" + phone.getText() + "',"
        + " '" + email.getText() + "', '" + un.getText() + "', '" + pass + "',"
        + " '" + type.getSelectedItem() + "', 'Pending', '" + secq.getSelectedItem() + "', '" + ans.getText() + "')") == 0) {


        } else {
            JOptionPane.showMessageDialog(null, "Registered Successfully!");
            loginForm lfr = new loginForm();
            lfr.setVisible(true);
            this.dispose();
        } 
        }catch(NoSuchAlgorithmException ex){
            System.out.println(""+ex);
        }
            
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyReleased
        String PATTERN = "^[A-Z][a-zA-Z ]{2,30}$";
        Pattern pt = Pattern.compile(PATTERN);
        Matcher match = pt.matcher(lname.getText());

        if (!match.matches()) {
            lnlab.setText("First Name is incorrect.");
        } else {
            lnlab.setText(null);
        }           
        
    }//GEN-LAST:event_lnameKeyReleased
    private static HashSet<String> existingEmails = new HashSet<>();
    private static HashSet<String> existingUsernames = new HashSet<>();
    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        String EMAIL_PATTERN = "^[a-zA-Z]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
        Pattern pt = Pattern.compile(EMAIL_PATTERN);
        Matcher match = pt.matcher(email.getText());

    if (!match.matches()) {
        emlab.setText("Invalid email format.");
    } else {
        emlab.setText(null);
    }

    }//GEN-LAST:event_emailKeyReleased

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

    private void fnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyReleased
        String PATTERN = "^[A-Z][a-zA-Z ]{2,30}$";
        Pattern pt = Pattern.compile(PATTERN);
        Matcher match = pt.matcher(fname.getText());

        if (!match.matches()) {
            fnlab.setText("First Name is incorrect.");
        } else {
            fnlab.setText(null);
        }
    }//GEN-LAST:event_fnameKeyReleased

    private void unKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unKeyReleased
        String USERNAME_PATTERN = "^[a-zA-Z0-9._]{5,20}$"; 
        Pattern pt = Pattern.compile(USERNAME_PATTERN);
        Matcher match = pt.matcher(un.getText());

        if (!match.matches()) {
            userlab.setText("Invalid username, try again...");
        } else if (existingUsernames.contains(un.getText())) {
            userlab.setText("Username already exists...");
        } else {
            userlab.setText(null);
        }
    }//GEN-LAST:event_unKeyReleased

    private void passsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passsKeyReleased
         String PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d!@#$%^&*()_+\\-=]{8,30}$";
        Pattern pt = Pattern.compile(PATTERN);
        Matcher match = pt.matcher(passs.getText());
        if (!match.matches()){
            pslab.setText("Password too short, at least be 8 characters long");
        }
        else{
            pslab.setText(null);
        }
    }//GEN-LAST:event_passsKeyReleased

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansActionPerformed

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
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Mainpanel;
    private javax.swing.JTextField ans;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emlab;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel fnlab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel lnlab;
    private javax.swing.JPanel navi;
    private javax.swing.JPasswordField passs;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel phonelab;
    private javax.swing.JLabel pslab;
    private javax.swing.JComboBox<String> secq;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JTextField un;
    private javax.swing.JLabel userlab;
    // End of variables declaration//GEN-END:variables
}
