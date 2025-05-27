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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Keycee Bolambot
 */
public class bookInventory extends javax.swing.JFrame {

    /**
     * Creates new form bookInventory
     */
    public bookInventory() {
        initComponents();
           displayData();
      
    }
    
    
 
    Color navcolor = new Color(102,102,102);
     Color hovercolor = new Color(204,204,204);
     
        public void displayData() {
            try {
                dbConnect dbc = new dbConnect();
                ResultSet rs = dbc.getData("SELECT b_id AS 'ID', b_title AS 'Book Title', b_category AS 'Category', " +
                        "b_author AS 'Author', publisher AS 'Publisher' FROM books WHERE b_status = 'APPROVED'");

                tblInventory.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
            } catch(SQLException ex) {
                System.out.println("Error displaying approved books: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error loading approved books: " + ex.getMessage());
            }
        }
        
    
     
//  private void loadApprovedBooks() {
//    DefaultTableModel model = new DefaultTableModel();
//    model.setColumnIdentifiers(new String[]{"ID", "Title", "Category", "Author", "Publisher"});
//    
//    dbConnect dbc = new dbConnect();
//    Connection conn = null;
//    PreparedStatement pstmt = null;
//    ResultSet rs = null;
//
//    try {
//        conn = dbc.getConnection();
//        String query = "SELECT b_id, b_title, b_category, b_author, b_publisher FROM books WHERE b_status = 'APPROVED'";
//        pstmt = conn.prepareStatement(query);
//        rs = pstmt.executeQuery();
//        
//        while (rs.next()) {
//            model.addRow(new Object[]{
//                rs.getString("b_id"),
//                rs.getString("b_title"),
//                rs.getString("b_category"),
//                rs.getString("b_author"),
//                rs.getString("b_publisher")
//            });
//        }
//        
//        tblInventory.setModel(model);
//        
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error loading approved books: " + ex.getMessage());
//        ex.printStackTrace();
//    } finally {
//        try {
//            if (rs != null) rs.close();
//            if (pstmt != null) pstmt.close();
//            if (conn != null) conn.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();
        navi = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        accid = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        p_add = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        f_name = new javax.swing.JLabel();
        p_delete = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInventory.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblInventory.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblInventory);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 670, 480));

        navi.setBackground(new java.awt.Color(102, 102, 102));
        navi.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        navi.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 250, 12));

        accid.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        accid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accid.setText("ID");
        navi.add(accid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setText("CURRENT USER:");
        navi.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 210, 30));

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
        jLabel6.setBounds(30, 0, 130, 50);

        navi.add(p_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 190, 50));

        f_name.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        f_name.setText("USERS");
        navi.add(f_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 90, 30));

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
        jLabel12.setBounds(20, 0, 150, 50);

        navi.add(p_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 190, 50));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        navi.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 250, 12));

        jPanel1.add(navi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 500));

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INVENTORY");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 630, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        Header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 90, 70));

        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 90));

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

    private void p_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseClicked
        
        int rowIndex = tblInventory.getSelectedRow();

    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a Book.");
        return;
    }

    try {
        dbConnect dbc = new dbConnect();
        TableModel tbl = tblInventory.getModel();
        Object bookId = tbl.getValueAt(rowIndex, 0);

        ResultSet rs = dbc.getData("SELECT * FROM books WHERE b_id = '" + bookId + "'");

        if (rs.next()) {
            createInventory bk = new createInventory();
            this.dispose(); 
            

            // Set data to form fields
            bk.bookid.setText(rs.getString("b_id"));
            bk.setVisible(true);
            this.dispose(); 
 
    }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving book data: " + ex.getMessage());
        ex.printStackTrace();
    }

    }//GEN-LAST:event_p_addMouseClicked

    private void p_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseEntered
        p_add.setBackground(hovercolor);
    }//GEN-LAST:event_p_addMouseEntered

    private void p_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseExited
        p_add.setBackground(navcolor);
    }//GEN-LAST:event_p_addMouseExited

    private void p_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseClicked
        dbConnect dbc = new dbConnect();
        Session ses = Session.getInstance();
        dbConnect connector = new dbConnect();
        String bookTitle = null;
        int selectedRow = tblInventory.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a book to delete.");
            return;
        }

        int bookId = Integer.parseInt(tblInventory.getValueAt(selectedRow, 0).toString());
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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        UserDashboard db = new UserDashboard();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        accid.setText(""+ses.getUid());
         f_name.setText(""+ses.getFname());
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
            java.util.logging.Logger.getLogger(bookInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JLabel accid;
    private javax.swing.JLabel f_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel navi;
    private javax.swing.JPanel p_add;
    private javax.swing.JPanel p_delete;
    public javax.swing.JTable tblInventory;
    // End of variables declaration//GEN-END:variables
}
