/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import config.Session;
import config.dbConnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Keycee Bolambot
 */
public class dispInv extends javax.swing.JFrame {

    /**
     * Creates new form dispInv
     */
    public dispInv() {
        initComponents();
        displayData();
        
    }
    Color navcolor = new Color(102,102,102);
     Color hovercolor = new Color(204,204,204);

     public void displayData() {
    try {
        dbConnect dbc = new dbConnect();
        String query = "SELECT " +
                       "i.i_id AS 'Inventory ID', " +
                       "i.b_id AS 'Book ID', " +
                       "b.b_title AS 'Book Title', " +
                       "i.quantity AS 'Quantity', " +
                       "i.borrowed AS 'Borrowed', " +
                       "i.damaged AS 'Damaged', " +
                       "i.lost AS 'Lost', " +
                       "i.available AS 'Stock Left' " +
                       "FROM inventory i " +
                       "JOIN books b ON i.b_id = b.b_id";

        ResultSet rs = dbc.getData(query);
        inventory.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        print = new javax.swing.JLabel();
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
        iedit = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        p_delete = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventory = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logosmallerver.png"))); // NOI18N

        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printt.png"))); // NOI18N
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
        });

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INVENTORY");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        Header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 90, 60));

        navi.setBackground(new java.awt.Color(102, 102, 102));
        navi.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        navi.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, 12));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userb.png"))); // NOI18N
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
        p_add.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                p_addCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        p_add.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ADD");
        p_add.add(jLabel6);
        jLabel6.setBounds(50, 10, 130, 30);

        navi.add(p_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 230, 50));

        iedit.setBackground(new java.awt.Color(102, 102, 102));
        iedit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        iedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ieditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ieditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ieditMouseExited(evt);
            }
        });
        iedit.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("EDIT");
        iedit.add(jLabel9);
        jLabel9.setBounds(60, 10, 110, 30);

        navi.add(iedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 230, 50));

        fname.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        fname.setText("USERS");
        navi.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 90, 30));

        p_delete.setBackground(new java.awt.Color(102, 102, 102));
        p_delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_deleteMouseExited(evt);
            }
        });
        p_delete.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DELETE");
        p_delete.add(jLabel12);
        jLabel12.setBounds(60, 10, 110, 30);

        navi.add(p_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 230, 50));

        inventory.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        inventory.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(inventory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navi, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(513, 513, 513)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(navi, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
        MessageFormat header = new MessageFormat(
            "Matrix Library Inventory Reports     " + java.time.LocalDate.now());
        MessageFormat footer = new MessageFormat("Page {0, number, integer}");

        try {
            inventory.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_printMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        UserDashboard adb = new UserDashboard();
        adb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void p_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseClicked
        createInventory cbf = new createInventory();
        cbf.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_p_addMouseClicked

    private void p_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseEntered
        p_add.setBackground(hovercolor);
    }//GEN-LAST:event_p_addMouseEntered

    private void p_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseExited
        p_add.setBackground(navcolor);
    }//GEN-LAST:event_p_addMouseExited

    private void ieditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ieditMouseClicked
     int rowIndex = inventory.getSelectedRow();

    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select an item.");
        return;
    }

    try {
        dbConnect dbc = new dbConnect();
        TableModel tbl = inventory.getModel();
        Object invID = tbl.getValueAt(rowIndex, 0);

        ResultSet rs = dbc.getData("SELECT * FROM inventory WHERE i_id = '" + invID + "'");

        if (rs.next()) {
            createInventory bk = new createInventory();

            // Set data to form fields
            bk.i_id.setText(rs.getString("i_id"));
            bk.bookid.setText(rs.getString("b_id"));
            bk.qty.setText(rs.getString("quantity"));
            bk.bor.setText(rs.getString("borrowed"));
            bk.dam.setText(rs.getString("damaged"));
            bk.los.setText(rs.getString("lost"));
            bk.lef.setText(rs.getString("available"));

            bk.badd.setEnabled(false);
            bk.bedit.setEnabled(true);

            // Show the form
            bk.setVisible(true);
            this.dispose(); // Close current form
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving book data: " + ex.getMessage());
        ex.printStackTrace();
    }
    }//GEN-LAST:event_ieditMouseClicked

    private void ieditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ieditMouseEntered
        iedit.setBackground(hovercolor);
    }//GEN-LAST:event_ieditMouseEntered

    private void ieditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ieditMouseExited
        iedit.setBackground(navcolor);
    }//GEN-LAST:event_ieditMouseExited

    private void p_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseClicked
        dbConnect dbc = new dbConnect();
        Session ses = Session.getInstance();
        dbConnect connector = new dbConnect();
        String bookTitle = null;
        int selectedRow = inventory.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a book to delete.");
            return;
        }

        int bookId = Integer.parseInt(inventory.getValueAt(selectedRow, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this book?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String query = "SELECT * FROM books WHERE b_id = ?";
                PreparedStatement pstmt = connector.getConnection().prepareStatement(query);
                pstmt.setInt(1, bookId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    bookTitle = rs.getString("b_title");

                    String deleteQuery = "DELETE FROM books WHERE b_id = ?";
                    PreparedStatement deleteStmt = connector.getConnection().prepareStatement(deleteQuery);
                    deleteStmt.setInt(1, bookId);
                    int rowsAffected = deleteStmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Book \"" + bookTitle + "\" deleted successfully.");
//                        displayData(); // Refresh the table
                    } else {
                        JOptionPane.showMessageDialog(this, "Deletion failed. No rows affected.");
                    }

                    deleteStmt.close();
                }

                rs.close();
                pstmt.close();
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex);
                JOptionPane.showMessageDialog(this, "An error occurred while deleting the book.");
            }
        }
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
                System.out.println("Log recorded successfully.");
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
    }//GEN-LAST:event_p_deleteMouseClicked

    private void p_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseEntered
        p_delete.setBackground(hovercolor);
    }//GEN-LAST:event_p_deleteMouseEntered

    private void p_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseExited
        p_delete.setBackground(navcolor);
    }//GEN-LAST:event_p_deleteMouseExited

    private void p_addCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_p_addCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_p_addCaretPositionChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         Session ses = Session.getInstance();
        accid.setText(""+ses.getUid());
         fname.setText(""+ses.getFname());

        
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
            java.util.logging.Logger.getLogger(dispInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dispInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dispInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dispInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dispInv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JLabel accid;
    private javax.swing.JLabel fname;
    private javax.swing.JPanel iedit;
    public javax.swing.JTable inventory;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel p_delete;
    private javax.swing.JLabel print;
    // End of variables declaration//GEN-END:variables
}
