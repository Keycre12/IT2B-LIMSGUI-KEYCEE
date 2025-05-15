/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.individualPrinting;
import config.Session;
import config.dbConnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Keycee Bolambot
 */
public class dispBooks extends javax.swing.JFrame {

    /**
     * Creates new form dispBooks
     */
    public dispBooks() {
        initComponents();
        displayData();
    }
    Color navcolor = new Color(102,102,102);
     Color hovercolor = new Color(204,204,204);
     
      public void displayData(){
        try{
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT b_id AS 'ID', b_title AS 'Book Title', b_category AS 'Category', " +
             "b_author AS 'Author', publisher AS 'Publisher', quantity AS 'Quantity', borrowed AS 'Borrowed', damaged AS 'Damaged', available AS 'Available' FROM books");
            books_tbl.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());

        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel10 = new javax.swing.JLabel();
        p_delete = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        books_tbl = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        print = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BOOKS DISPLAY!");
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
        jLabel9.setBounds(60, 10, 110, 30);

        navi.add(p_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 230, 50));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setText("USERS");
        navi.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 90, 30));

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

        navi.add(p_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 230, 50));

        books_tbl.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        books_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(books_tbl);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logosmallerver.png"))); // NOI18N

        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printt.png"))); // NOI18N
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navi, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(500, 500, 500)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(navi, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
//        adminDashboard adb = new adminDashboard();
//        adb.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void p_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseClicked
        createBookForm cbf = new createBookForm();
        cbf.setVisible(true);
        cbf.remove.setEnabled(false);
        cbf.select.setEnabled(true);
        this.dispose();

    }//GEN-LAST:event_p_addMouseClicked

    private void p_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseEntered
        p_add.setBackground(hovercolor);

    }//GEN-LAST:event_p_addMouseEntered

    private void p_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseExited
        p_add.setBackground(navcolor);
    }//GEN-LAST:event_p_addMouseExited

    private void p_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseClicked
                                    
    int rowIndex = books_tbl.getSelectedRow();

    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select an item.");
        return;
    }

    try {
        dbConnect dbc = new dbConnect();
        TableModel tbl = books_tbl.getModel();
        Object bookId = tbl.getValueAt(rowIndex, 0);

        ResultSet rs = dbc.getData("SELECT * FROM books WHERE b_id = '" + bookId + "'");

        if (rs.next()) {
            createBookForm bk = new createBookForm();

            // Set data to form fields
            bk.uid.setText(rs.getString("b_id")); // IMPORTANT for update
            bk.isbn.setText(rs.getString("b_isbn"));
            bk.title.setText(rs.getString("b_title"));
            bk.cat.setText(rs.getString("b_category"));
            bk.author.setText(rs.getString("b_author"));
            bk.pub.setText(rs.getString("publisher"));
            bk.qty.setText(rs.getString("quantity"));
            bk.bor.setText(rs.getString("borrowed"));
            bk.dam.setText(rs.getString("damaged"));
            bk.lef.setText(rs.getString("available"));

            String imagePath = rs.getString("b_image");
            bk.image.setIcon(bk.ResizeImage(imagePath, null, bk.image));
            bk.oldpath = imagePath;
            bk.path = imagePath;
            bk.destination = imagePath;

            if (imagePath == null || imagePath.isEmpty()) {
                bk.select.setEnabled(true);
                bk.remove.setEnabled(false);
            } else {
                bk.select.setEnabled(false);
                bk.remove.setEnabled(true);
            }

            // Set form button states
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

    }//GEN-LAST:event_p_editMouseClicked

    private void p_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseEntered
        p_edit.setBackground(hovercolor);
    }//GEN-LAST:event_p_editMouseEntered

    private void p_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseExited
        p_edit.setBackground(navcolor);
    }//GEN-LAST:event_p_editMouseExited

    private void p_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseClicked
    dbConnect dbc = new dbConnect();
    Session ses = Session.getInstance();
    dbConnect connector = new dbConnect();
    String bookTitle = null;
    int selectedRow = books_tbl.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book to delete.");
        return;
    }

    int bookId = Integer.parseInt(books_tbl.getValueAt(selectedRow, 0).toString());
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
                    displayData(); // Refresh the table
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
    }//GEN-LAST:event_p_deleteMouseClicked

    private void p_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseEntered
        p_delete.setBackground(hovercolor);
    }//GEN-LAST:event_p_deleteMouseEntered

    private void p_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseExited
        p_delete.setBackground(navcolor);
    }//GEN-LAST:event_p_deleteMouseExited

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
//        int rowIndex = books_tbl.getSelectedRow();
//
//        if (rowIndex < 0) {
//            JOptionPane.showMessageDialog(null, "Please Select an Item");
//        } else {
//            try {
//                dbConnect dbc = new dbConnect();
//                TableModel tbl = books_tbl.getModel();
//                ResultSet rs = dbc.getData("SELECT * FROM users WHERE u_id = '" + tbl.getValueAt(rowIndex, 0) + "'");
//                if (rs.next()) {
//                    individualPrinting ipt = new individualPrinting();
//                    ipt.uid.setText(""+rs.getInt("u_id"));
//                    ipt.fn.setText("" + rs.getString("u_fname"));
//                    ipt.ln.setText("" + rs.getString("u_lname"));
//                    ipt.phone.setText("" + rs.getString("u_contact"));
//                    ipt.email.setText("" + rs.getString("u_email"));
//                    ipt.un.setText("" + rs.getString("u_un"));
//                    ipt.at.setText(""+rs.getString("u_type"));
//                    ipt.st.setText(""+rs.getString("status"));
//                    ipt.image.setIcon(ipt.ResizeImage(rs.getString("u_image"), null, ipt.image));
//                    ipt.setVisible(true);
//                    this.dispose();
//                }
//            } catch (SQLException ex) {
//                System.out.println("" + ex);
//            }
//        }

    }//GEN-LAST:event_printMouseClicked

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
            java.util.logging.Logger.getLogger(dispBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dispBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dispBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dispBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dispBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JLabel accid;
    public javax.swing.JTable books_tbl;
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
    private javax.swing.JPanel p_delete;
    private javax.swing.JPanel p_edit;
    private javax.swing.JLabel print;
    // End of variables declaration//GEN-END:variables
}
