/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnect;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import admin.createUserForm;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Keycee Bolambot
 */
public class adminUsers extends javax.swing.JFrame {

    /**
     * Creates new form adminUsers
     */
    public adminUsers() {
        initComponents();
        displayData();
    }
    Color navcolor = new Color(102,102,102);
     Color hovercolor = new Color(204,204,204);
    
    public void displayData(){
        try{
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT u_id AS 'ID', u_fname AS 'First Name', u_lname AS 'Last Name', " +
             "u_contact AS 'Contact', u_email AS 'Email', status AS 'Status' FROM users");
            users_tbl.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());

        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Mainpanel = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        navi = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        accid = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        p_add = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        p_edit = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        p_delete1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        users_tbl = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Mainpanel.setBackground(new java.awt.Color(204, 204, 204));
        Mainpanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Mainpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME TO ADMIN DASHBOARD!");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limsgui/images/back.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        Header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 90, 60));

        Mainpanel.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 80));

        navi.setBackground(new java.awt.Color(102, 102, 102));
        navi.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        navi.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, 12));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limsgui/images/userb.png"))); // NOI18N
        navi.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 110));

        accid.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        accid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accid.setText("ID");
        navi.add(accid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setText("CURRENT USER:");
        navi.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 210, 30));

        p_add.setBackground(new java.awt.Color(102, 102, 102));
        p_add.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ADD");
        p_add.add(jLabel6);
        jLabel6.setBounds(50, 10, 130, 30);

        navi.add(p_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 230, 50));

        p_edit.setBackground(new java.awt.Color(102, 102, 102));
        p_edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_editMouseExited(evt);
            }
        });
        p_edit.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("EDIT");
        p_edit.add(jLabel9);
        jLabel9.setBounds(50, 10, 110, 30);

        p_delete1.setBackground(new java.awt.Color(102, 102, 102));
        p_delete1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p_delete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_delete1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_delete1MouseExited(evt);
            }
        });
        p_delete1.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DELETE");
        p_delete1.add(jLabel12);
        jLabel12.setBounds(50, 10, 110, 30);

        p_edit.add(p_delete1);
        p_delete1.setBounds(-60, -50, 60, 50);

        navi.add(p_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 230, 50));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setText("USERS");
        navi.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 90, 30));

        Mainpanel.add(navi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 280, 570));

        users_tbl.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        users_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(users_tbl);

        Mainpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 202, 700, 430));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limsgui/images/logosmallerver.png"))); // NOI18N
        Mainpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, 120, 110));

        delete.setBackground(new java.awt.Color(102, 102, 102));
        delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        Mainpanel.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 100, 40));

        add.setBackground(new java.awt.Color(102, 102, 102));
        add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        Mainpanel.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 100, 40));

        update.setBackground(new java.awt.Color(102, 102, 102));
        update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        update.setText("EDIT");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        Mainpanel.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        

    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
    }//GEN-LAST:event_updateActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        accid.setText(""+ses.getUid());
        
        

    }//GEN-LAST:event_formWindowActivated

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       adminDashboard adb = new adminDashboard();
       adb.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void p_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseEntered
       p_add.setBackground(hovercolor);
        
    }//GEN-LAST:event_p_addMouseEntered

    private void p_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseExited
        p_add.setBackground(navcolor);
    }//GEN-LAST:event_p_addMouseExited

    private void p_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseEntered
        p_edit.setBackground(hovercolor);
    }//GEN-LAST:event_p_editMouseEntered

    private void p_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseExited
        p_edit.setBackground(navcolor);
    }//GEN-LAST:event_p_editMouseExited

    private void p_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseClicked
       createUserForm cuf = new createUserForm();
       cuf.setVisible(true);
       this.dispose();
       
    }//GEN-LAST:event_p_addMouseClicked

    private void p_delete1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_delete1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_p_delete1MouseEntered

    private void p_delete1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_delete1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_p_delete1MouseExited

    private void p_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseClicked
      int rowIndex = users_tbl.getSelectedRow();

    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please Select an Item");
    } else {
        try {
            dbConnect dbc = new dbConnect();
            TableModel tbl = users_tbl.getModel();
            ResultSet rs = dbc.getData("SELECT * FROM users WHERE u_id = '" + tbl.getValueAt(rowIndex, 0) + "'");
            if (rs.next()) {
                createUserForm au = new createUserForm();
                au.uid.setText(""+rs.getInt("u_id"));
                au.fname.setText("" + rs.getString("u_fname"));
                au.lname.setText("" + rs.getString("u_lname"));
                au.phone.setText("" + rs.getString("u_contact"));
                au.email.setText("" + rs.getString("u_email"));
                au.un.setText("" + rs.getString("u_un"));
                au.pass.setText("" + rs.getString("u_pass"));
                au.type.setSelectedItem(""+rs.getString("u_type")); 
                au.us.setSelectedItem(""+rs.getString("status")); 
                au.uadd.setEnabled(false);
                au.uupdate.setEnabled(true);
                au.setVisible(true);
                this.dispose();
            }
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }
       
    }//GEN-LAST:event_p_editMouseClicked

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
            java.util.logging.Logger.getLogger(adminUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Mainpanel;
    private javax.swing.JLabel accid;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel navi;
    private javax.swing.JPanel p_add;
    private javax.swing.JPanel p_delete1;
    private javax.swing.JPanel p_edit;
    private javax.swing.JButton update;
    private javax.swing.JTable users_tbl;
    // End of variables declaration//GEN-END:variables
}
