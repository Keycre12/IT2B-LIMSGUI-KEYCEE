
package admin;

import config.Session;
import config.dbConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class adminLogs extends javax.swing.JFrame {

    
    public adminLogs() {
        initComponents();
        displayData();
    }
    
   public void displayData() {
    try {
        dbConnect dbc = new dbConnect(); // Your database connection handler

        // SQL query to join logs with users to get additional user info including user type
        String query = "SELECT " +
                       "    l.log_id AS 'ID', " +
                       "    u.u_id AS 'User ID', " +
                       "    u.u_un AS 'Username', " +
                       "    u.u_type AS 'User Type', " +
                       "    l.log_action AS 'Log Action', " +
                       "    l.log_time AS 'Log Time' " +
                       "FROM logs l " +
                       "JOIN users u ON l.u_id = u.u_id";

        ResultSet rs = dbc.getData(query);

        // Assuming 'actions' is your JTable for displaying logs
        actions.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}

    public void NotShowDeletedUsers() {
        // Create a list to store filtered row data
        List<Object[]> rowData = new ArrayList<>();

        try {
            dbConnect dbc = new dbConnect();
            
            ResultSet rs = dbc.getData("SELECT u_id AS 'ID', u_fname AS 'First Name', u_lname AS 'Last Name', " +
             "u_contact AS 'Contact', u_email AS 'Email', status AS 'Status' FROM users");

            while (rs.next()) {
                // Store each column value in a separate variable
                String uid = rs.getString("u_id");
                String fname = rs.getString("u_fname");
                String lname = rs.getString("u_lname");
                String un = rs.getString("u_username");
                String contact = rs.getString("u_phone");
                String type = rs.getString("u_type");
                String status = rs.getString("u_status");

                // Check if the user status is not "Deleted"
                if (!status.equals("Deleted")) {
                    
                    // Add the row to the list
                    rowData.add(new Object[]{
                        uid,
                        fname,
                        lname, 
                        un,
//                        npass,
                        contact, 
                        type,
                        status 
                    });
                    /*System.out.println("\n==========");
                    System.out.println(""+u);
                    System.out.println(""+fn);
                    System.out.println(""+ln);
                    System.out.println(""+uname);
                    System.out.println(""+at);
                    System.out.println(""+p);
                    System.out.println(""+status);*/
                }
            }

            // After processing all rows, update the table on the Swing event dispatch thread
                SwingUtilities.invokeLater(() -> {
                DefaultTableModel model = new DefaultTableModel(
                        new String[]{"ID", "First Name", "Last Name", "Username", "Account Type", "Phone", "Status"}, 0
                );
                for (Object[] row : rowData) {
                    model.addRow(row);
                }
                actions.setModel(model);
                actions.repaint(); // Force visual refresh
            });


            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

//    public void displayData()
//    {
//        try
//        {
//            dbConnect dbc = new dbConnect();
//            ResultSet rs = dbc.getData("SELECT * FROM logs");
//            logacts.setModel(DbUtils.resultSetToTableModel(rs));
//            rs.close();
//        }catch(SQLException ex)
//        {
//            System.out.println("Errors: "+ex.getMessage());
//        }
//    }
//    

    
    private void loadUsersData() 
{
    DefaultTableModel model = (DefaultTableModel) actions.getModel();
    model.setRowCount(0); // Clear the table before reloading

    String sql = "SELECT * FROM users";

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lims_db", "root", "");
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) 
    {

        while (rs.next()) 
        {
            // Check if the user's status is not "Deleted"
            String userStatus = rs.getString("u_status");
            if (!"Deleted".equals(userStatus)) 
            {
                model.addRow(new Object[]
                {
                    rs.getInt("u_id"),
                    rs.getString("u_fname"),
                    rs.getString("u_lname"),
                    rs.getString("u_un"),
                    rs.getString("u_type"),
                    rs.getString("u_phone"),
                    rs.getString("u_status")
                });
            }
        }
    } catch (SQLException ex) 
    {
        JOptionPane.showMessageDialog(this, "Error loading user data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
        
    
    
     public void logEvent(int userId, String username, String action) 
    {
        dbConnect dbc = new dbConnect();
        Connection con = dbc.getConnection();
        PreparedStatement pstmt = null;
        Timestamp time = new Timestamp(new Date().getTime());

        try {
            String sql = "INSERT INTO logs (u_id, u_un, log_action, log_time) "
                    + "VALUES ('" + userId + "', '" + username + "', '" + action  + "', '" + time + "')";
            pstmt = con.prepareStatement(sql);

            /*            pstmt.setInt(1, userId);
            pstmt.setString(2, username);
            pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            pstmt.setString(4, userType);*/
            pstmt.executeUpdate();
            System.out.println("Log in log recorded successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error recording log: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }
     
    

     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        actions = new javax.swing.JTable();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        navi1 = new javax.swing.JPanel();
        accid = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        f_name = new javax.swing.JLabel();
        l_name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        actions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(actions);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 810, 530));

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGS");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        Header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 90, 60));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

        navi1.setBackground(new java.awt.Color(102, 102, 102));
        navi1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        accid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accid.setText("ID");
        navi1.add(accid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("CURRENT USER:");
        navi1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 120, 30));

        f_name.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        f_name.setText("USERS");
        navi1.add(f_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 90, 30));

        l_name.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        l_name.setText("USERS");
        navi1.add(l_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 90, 30));

        getContentPane().add(navi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 200, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        adminDashboard adb = new adminDashboard();
        adb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session ses = Session.getInstance();
      accid.setText(""+ses.getUid());
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
            java.util.logging.Logger.getLogger(adminLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminLogs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JLabel accid;
    private javax.swing.JTable actions;
    private javax.swing.JLabel f_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_name;
    private javax.swing.JPanel navi1;
    // End of variables declaration//GEN-END:variables
}
