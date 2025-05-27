/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import user.bookInventory;

/**
 *
 * @author Keycee Bolambot
 */
public class bookapproval extends javax.swing.JFrame {


    public bookapproval() {
        initComponents();
        displayData();
    }

    public void displayData() {
        try {
            dbConnect dbc = new dbConnect();
            // ✅ Only select books that are NOT approved
            ResultSet rs = dbc.getData("SELECT b_id AS 'ID', b_isbn AS 'ISBN', b_title AS 'Book Title', " +
                    "b_category AS 'Category', b_author AS 'Author', publisher AS 'Publisher' " +
                    "FROM books WHERE b_status != 'APPROVED' OR b_status IS NULL"); // Include NULL if needed

            approvebook.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch(SQLException ex) {
            System.out.println("Error loading pending books: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error loading books for approval: " + ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        approvebook = new javax.swing.JTable();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        navi1 = new javax.swing.JPanel();
        accid = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        f_name = new javax.swing.JLabel();
        approve = new javax.swing.JButton();
        decline = new javax.swing.JButton();
        l_name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        approvebook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(approvebook);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 810, 510));

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BOOK APPROVAL");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        Header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 90, 60));

        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

        navi1.setBackground(new java.awt.Color(102, 102, 102));
        navi1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        accid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accid.setText("ID");
        navi1.add(accid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("CURRENT USER:");
        navi1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 120, 30));

        f_name.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        f_name.setText("USERS");
        navi1.add(f_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, 30));

        approve.setBackground(new java.awt.Color(51, 153, 0));
        approve.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        approve.setText("ACCEPT");
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });
        navi1.add(approve, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 120, 40));

        decline.setBackground(new java.awt.Color(204, 0, 0));
        decline.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        decline.setText("DECLINE\n");
        decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineActionPerformed(evt);
            }
        });
        navi1.add(decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, 40));

        l_name.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        l_name.setText("USERS");
        navi1.add(l_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 90, 30));

        jPanel1.add(navi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 180, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        adminDashboard adb = new adminDashboard();
        adb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveActionPerformed
        if (approvebook.getSelectedRow() == -1) {
    JOptionPane.showMessageDialog(null, "Please select a book to approve.");
    return;

} else {
    int selectedRow = approvebook.getSelectedRow();

    // Use b_id (assume it's in column 0)
    String idValue = approvebook.getValueAt(selectedRow, 0).toString(); 
    String titleValue = approvebook.getValueAt(selectedRow, 1).toString();
    String catValue = approvebook.getValueAt(selectedRow, 2).toString();
    String authorValue = approvebook.getValueAt(selectedRow, 3).toString();
    String pubValue = approvebook.getValueAt(selectedRow, 4).toString();

    // Validation
    if (idValue.isEmpty()
            || titleValue.isEmpty()
            || authorValue.isEmpty()
            || catValue.isEmpty()
            || pubValue.isEmpty()) {

        JOptionPane.showMessageDialog(null, "All fields are required.");
        return;

    } else {
        dbConnect dbc = new dbConnect();

        try {
            // ✅ Use b_id instead of b_isbn
            String query = "UPDATE books SET b_status = 'APPROVED' WHERE b_id = '" + idValue + "'";

            if (dbc.insertData(query) == 1) {
                JOptionPane.showMessageDialog(null, "Book approved and moved to inventory.");

                DefaultTableModel model = (DefaultTableModel) approvebook.getModel();
                model.removeRow(selectedRow);
                displayData(); 
//                bookInventory bi = new bookInventory();
//                bi.setVisible(true);
//                this.dispose(); // Close approval window
            } else {
                JOptionPane.showMessageDialog(null, "Error while approving the book.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}



    }//GEN-LAST:event_approveActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
          Session ses = Session.getInstance();
        accid.setText(""+ses.getUid());
         f_name.setText(""+ses.getFname());
        l_name.setText(""+ses.getLname());
    }//GEN-LAST:event_formWindowActivated

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
        if (approvebook.getSelectedRow() == -1) {
    JOptionPane.showMessageDialog(null, "Please select a book to decline.");
    return;
} else {
    int selectedRow = approvebook.getSelectedRow();

    // Use b_id (assume it's in column 0)
    String idValue = approvebook.getValueAt(selectedRow, 0).toString(); 
    String titleValue = approvebook.getValueAt(selectedRow, 1).toString();
    String catValue = approvebook.getValueAt(selectedRow, 2).toString();
    String authorValue = approvebook.getValueAt(selectedRow, 3).toString();
    String pubValue = approvebook.getValueAt(selectedRow, 4).toString();

    // Validation
    if (idValue.isEmpty()
            || titleValue.isEmpty()
            || authorValue.isEmpty()
            || catValue.isEmpty()
            || pubValue.isEmpty()) {

        JOptionPane.showMessageDialog(null, "All fields are required.");
        return;

    } else {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to decline and delete this book?", "Confirm Decline", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            dbConnect dbc = new dbConnect();

            try {
                // ❌ Delete the book from the database
                String query = "DELETE FROM books WHERE b_id = '" + idValue + "'";

                if (dbc.insertData(query) == 1) {
                    JOptionPane.showMessageDialog(null, "Book declined and removed from pending list.");

                    DefaultTableModel model = (DefaultTableModel) approvebook.getModel();
                    model.removeRow(selectedRow);
                    displayData();
                } else {
                    JOptionPane.showMessageDialog(null, "Error while declining the book.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}

    }//GEN-LAST:event_declineActionPerformed

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
            java.util.logging.Logger.getLogger(bookapproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookapproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookapproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookapproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookapproval().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JLabel accid;
    private javax.swing.JButton approve;
    private javax.swing.JTable approvebook;
    private javax.swing.JButton decline;
    private javax.swing.JLabel f_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_name;
    private javax.swing.JPanel navi1;
    // End of variables declaration//GEN-END:variables
}
