
package admin;

import config.dbConnect;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import limsgui.loginForm;


public class createUserForm extends javax.swing.JFrame {

  
    public createUserForm() {
        initComponents();

    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }

    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    
    
    
     Color navcolor = new Color(102,102,102);
     Color hovercolor = new Color(204,204,204);
     
     public static String u_email,u_un;
     public boolean duplicateCheck() {
    dbConnect dbc = new dbConnect();
    try {
        String query = "SELECT * FROM users WHERE u_un = '" + un.getText() + "' OR u_email = '" + email.getText() + "'";
        ResultSet resultSet = dbc.getData(query);
        
        if (resultSet.next()) {
            if (resultSet.getString("u_email").equals(email.getText())) {
                JOptionPane.showMessageDialog(null, "Email is already used!");
                email.setText(""); 
                return true;  
            }

            if (resultSet.getString("u_un").equals(un.getText())) {
                JOptionPane.showMessageDialog(null, "Username is already used!!");
                un.setText("");  
                return true;  
            }
        }
    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex);
    }
    return false; 
    }
    
    public boolean updateCheck() {
    dbConnect dbc = new dbConnect();
    try {
        String query = "SELECT * FROM users WHERE (u_un = '" + un.getText() + "' OR u_email = '" + email.getText() + "') AND u_id !='"+uid.getText()+"'";
        ResultSet resultSet = dbc.getData(query);
        
        if (resultSet.next()) {
            if (resultSet.getString("u_email").equals(email.getText())) {
                JOptionPane.showMessageDialog(null, "Email is already used!");
                email.setText(""); 
                return true;  
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
    return false;  
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

        Mainpanel = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        pass = new javax.swing.JPasswordField();
        pslab = new javax.swing.JLabel();
        userlab = new javax.swing.JLabel();
        emlab = new javax.swing.JLabel();
        phonelab = new javax.swing.JLabel();
        lnlab = new javax.swing.JLabel();
        fnlab = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        us = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        navi1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        udel = new javax.swing.JButton();
        uref = new javax.swing.JButton();
        uupdate = new javax.swing.JButton();
        uclear = new javax.swing.JButton();
        ucan = new javax.swing.JButton();
        uadd = new javax.swing.JButton();
        uid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        image = new javax.swing.JPanel();
        remove = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        select = new javax.swing.JButton();

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
        jLabel1.setText("CREATE USER");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        Mainpanel.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 1010, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("User ID:");
        Mainpanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 90, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Last Name:");
        Mainpanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Contact:");
        Mainpanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 75, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Email:");
        Mainpanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 83, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Username:");
        Mainpanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 90, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Password:");
        Mainpanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 83, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Acc Status:");
        Mainpanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 580, 83, 40));

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Librarian", "Staff" }));
        Mainpanel.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, 260, 40));

        pass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passKeyReleased(evt);
            }
        });
        Mainpanel.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 260, 40));

        pslab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        pslab.setForeground(new java.awt.Color(204, 0, 0));
        pslab.setText(" ");
        Mainpanel.add(pslab, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 260, -1));

        userlab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        userlab.setForeground(new java.awt.Color(204, 0, 0));
        userlab.setText(" ");
        Mainpanel.add(userlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 250, -1));

        emlab.setForeground(new java.awt.Color(204, 0, 0));
        emlab.setText(" ");
        Mainpanel.add(emlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 260, -1));

        phonelab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        phonelab.setForeground(new java.awt.Color(204, 0, 0));
        phonelab.setText(" ");
        Mainpanel.add(phonelab, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 260, -1));

        lnlab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lnlab.setForeground(new java.awt.Color(204, 0, 0));
        lnlab.setText(" ");
        Mainpanel.add(lnlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 260, -1));

        fnlab.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        fnlab.setForeground(new java.awt.Color(204, 0, 0));
        fnlab.setText(" ");
        Mainpanel.add(fnlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 260, -1));

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
        Mainpanel.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 260, 40));

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
        Mainpanel.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 260, 40));

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
        Mainpanel.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 260, 40));

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
        Mainpanel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 260, 40));

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
        Mainpanel.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 260, 40));

        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        Mainpanel.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 580, 260, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Type:");
        Mainpanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 83, 40));

        navi1.setBackground(new java.awt.Color(102, 102, 102));
        navi1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        navi1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, 12));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sluser.png"))); // NOI18N
        navi1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 120, 110));

        udel.setBackground(new java.awt.Color(102, 102, 102));
        udel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        udel.setText("DELETE");
        udel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                udelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                udelMouseExited(evt);
            }
        });
        udel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                udelActionPerformed(evt);
            }
        });
        navi1.add(udel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 230, 50));

        uref.setBackground(new java.awt.Color(102, 102, 102));
        uref.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        uref.setText("REFRESH");
        uref.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                urefMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                urefMouseExited(evt);
            }
        });
        uref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urefActionPerformed(evt);
            }
        });
        navi1.add(uref, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 230, 50));

        uupdate.setBackground(new java.awt.Color(102, 102, 102));
        uupdate.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        uupdate.setText("UPDATE");
        uupdate.setEnabled(false);
        uupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uupdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                uupdateMouseExited(evt);
            }
        });
        uupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uupdateActionPerformed(evt);
            }
        });
        navi1.add(uupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 230, 50));

        uclear.setBackground(new java.awt.Color(102, 102, 102));
        uclear.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        uclear.setText("CLEAR");
        uclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uclearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                uclearMouseExited(evt);
            }
        });
        uclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uclearActionPerformed(evt);
            }
        });
        navi1.add(uclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 230, 50));

        ucan.setBackground(new java.awt.Color(102, 102, 102));
        ucan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ucan.setText("CANCEL");
        ucan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ucanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ucanMouseExited(evt);
            }
        });
        ucan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucanActionPerformed(evt);
            }
        });
        navi1.add(ucan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 230, 50));

        uadd.setBackground(new java.awt.Color(102, 102, 102));
        uadd.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        uadd.setText("ADD");
        uadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uaddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uaddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                uaddMouseExited(evt);
            }
        });
        uadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uaddActionPerformed(evt);
            }
        });
        navi1.add(uadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 230, 50));

        Mainpanel.add(navi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 280, 570));

        uid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        uid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uidKeyReleased(evt);
            }
        });
        Mainpanel.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 260, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("First Name:");
        Mainpanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 90, 50));

        javax.swing.GroupLayout imageLayout = new javax.swing.GroupLayout(image);
        image.setLayout(imageLayout);
        imageLayout.setHorizontalGroup(
            imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        imageLayout.setVerticalGroup(
            imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        Mainpanel.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 240, 320));

        remove.setBackground(new java.awt.Color(102, 102, 102));
        remove.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        remove.setText("REMOVE");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeMouseExited(evt);
            }
        });
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        Mainpanel.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 440, 90, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logosmallerver.png"))); // NOI18N
        Mainpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, 120, 110));

        select.setBackground(new java.awt.Color(102, 102, 102));
        select.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        select.setText("SELECT");
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectMouseExited(evt);
            }
        });
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        Mainpanel.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 90, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unActionPerformed
    private static HashSet<String> existingEmails = new HashSet<>();
    private static HashSet<String> existingUsernames = new HashSet<>();
    private void unKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unKeyReleased
          String USERNAME_PATTERN = "^[a-zA-Z0-9]{5,20}$"; // Allows only letters and numbers, 5-20 characters
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

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed

    }//GEN-LAST:event_passActionPerformed

    private void passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyReleased
        String PATTERN = "^[a-zA-Z0-9]{8,30}$";
        Pattern pt = Pattern.compile(PATTERN);
        Matcher match = pt.matcher(pass.getText());
        if (!match.matches()){
            pslab.setText("Password too short...");
        }
        else{
            pslab.setText(null);
        }
    }//GEN-LAST:event_passKeyReleased

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        String EMAIL_PATTERN = "^[a-zA-Z]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
        Pattern pt = Pattern.compile(EMAIL_PATTERN);
        Matcher match = pt.matcher(email.getText());

        if (!match.matches()) {
            emlab.setText("Invalid email format.");
        } else if (existingEmails.contains(email.getText())) {
            emlab.setText("Email already exists.");
        } else {
            emlab.setText(null);
        }
    }//GEN-LAST:event_emailKeyReleased

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void lnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyReleased
        String PATTERN = "^[a-zA-Z0-9]{2,30}$";
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
        String PATTERN = "^[a-zA-Z0-9]{2,30}$";
        Pattern pt = Pattern.compile(PATTERN);
        Matcher match = pt.matcher(fname.getText());

        if (!match.matches()){
            fnlab.setText("First Name is incorrect..");
        }
        else{
            fnlab.setText(null);
        }

    }//GEN-LAST:event_fnameKeyReleased

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

    private void udelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_udelMouseEntered
        udel.setBackground(hovercolor);
    }//GEN-LAST:event_udelMouseEntered

    private void udelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_udelMouseExited
        udel.setBackground(navcolor);
    }//GEN-LAST:event_udelMouseExited

    private void udelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_udelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_udelActionPerformed

    private void urefMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urefMouseEntered
         uref.setBackground(hovercolor);
    }//GEN-LAST:event_urefMouseEntered

    private void urefMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urefMouseExited
        uref.setBackground(navcolor);
    }//GEN-LAST:event_urefMouseExited

    private void urefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urefActionPerformed

    private void uupdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uupdateMouseEntered
         uupdate.setBackground(hovercolor);
    }//GEN-LAST:event_uupdateMouseEntered

    private void uupdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uupdateMouseExited
        uupdate.setBackground(navcolor);
    }//GEN-LAST:event_uupdateMouseExited

    private void uupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uupdateActionPerformed
          if (fname.getText().isEmpty()
            || lname.getText().isEmpty()
            || email.getText().isEmpty()
            || phone.getText().isEmpty()
            || un.getText().isEmpty()
            || pass.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required");
        return;
    } else if (updateCheck()) {
        System.out.println("Duplicate Exist");
        return;
    } else {
        dbConnect dbc = new dbConnect();
        dbc.updateData("UPDATE users SET u_fname = '" + fname.getText() + "', u_lname = '" + lname.getText() + "', "
                + "u_contact = '" + phone.getText() + "', u_email = '" + email.getText() + "', u_un = '" + un.getText() + "', "
                + "u_pass = '" + pass.getText() + "', u_type = '" + type.getSelectedItem() + "', "
                + "status = '" + us.getSelectedItem() + "' WHERE u_id = '" + uid.getText() + "'");
       
        adminUsers adu = new adminUsers();
        adu.setVisible(true);
        this.dispose();
    }


    }//GEN-LAST:event_uupdateActionPerformed

    private void uclearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uclearMouseEntered
        uclear.setBackground(hovercolor);
    }//GEN-LAST:event_uclearMouseEntered

    private void uclearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uclearMouseExited
       uclear.setBackground(navcolor);
    }//GEN-LAST:event_uclearMouseExited

    private void uclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uclearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uclearActionPerformed

    private void ucanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucanMouseEntered
        ucan.setBackground(hovercolor);
    }//GEN-LAST:event_ucanMouseEntered

    private void ucanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ucanMouseExited
        ucan.setBackground(navcolor);
    }//GEN-LAST:event_ucanMouseExited

    private void ucanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ucanActionPerformed
        adminUsers adus = new adminUsers();
        adus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ucanActionPerformed

    private void uaddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uaddMouseEntered
         uadd.setBackground(hovercolor);
    }//GEN-LAST:event_uaddMouseEntered

    private void uaddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uaddMouseExited
        uadd.setBackground(navcolor);
    }//GEN-LAST:event_uaddMouseExited

    private void uaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uaddActionPerformed
    if (fname.getText().isEmpty() 
        || lname.getText().isEmpty() 
        || email.getText().isEmpty() 
        || phone.getText().isEmpty()
        || un.getText().isEmpty() 
        || pass.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "All fields are required");
        return;
    } 
    
    if (duplicateCheck()) {
        System.out.println("Duplicate Exist");
        return;
    } 

    dbConnect dbc = new dbConnect();
    int rowsInserted = dbc.insertData("INSERT INTO users (u_fname, u_lname, u_contact, u_email, u_un, u_pass, u_type, status)"
            + "VALUES('" + fname.getText() + "','" + lname.getText() + "', '" + phone.getText() + "',"
            + " '" + email.getText() + "', '" + un.getText() + "', '" + pass.getText() + "',"
            + " '" + type.getSelectedItem() + "', '"+us.getSelectedItem()+"')");

    if (rowsInserted > 0) {  // Check if at least one row was inserted
        JOptionPane.showMessageDialog(null, "Registered Successfully!");
        adminUsers adus = new adminUsers();
        adus.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Registration Failed!");
    }


    }//GEN-LAST:event_uaddActionPerformed

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void uidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uidKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_uidKeyReleased

    private void removeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_removeMouseEntered

    private void removeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_removeMouseExited

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeActionPerformed

    private void selectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_selectMouseEntered

    private void selectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_selectMouseExited

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectActionPerformed

    private void uaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uaddMouseClicked
         createUserForm crf = new createUserForm();
         crf.setVisible(true);
         crf.remove.setEnabled(false);
         crf.select.setEnabled(true);
         this.dispose();
         
    }//GEN-LAST:event_uaddMouseClicked

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
         //         imageuploadjava.txt
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userimages/" + selectedFile.getName();
                path = selectedFile.getAbsolutePath();

                if (FileExistenceChecker(path) == 1) {
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path = "";
                } else {
//                    image.setIcon(ResizeImage(path, null, image));
                    select.setEnabled(false);
                    remove.setEnabled(true);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_selectMouseClicked

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
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Mainpanel;
    public javax.swing.JTextField email;
    private javax.swing.JLabel emlab;
    public javax.swing.JTextField fname;
    private javax.swing.JLabel fnlab;
    private javax.swing.JPanel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JTextField lname;
    private javax.swing.JLabel lnlab;
    private javax.swing.JPanel navi1;
    public javax.swing.JPasswordField pass;
    public javax.swing.JTextField phone;
    private javax.swing.JLabel phonelab;
    private javax.swing.JLabel pslab;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JComboBox<String> type;
    public javax.swing.JButton uadd;
    public javax.swing.JButton ucan;
    public javax.swing.JButton uclear;
    public javax.swing.JButton udel;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField un;
    public javax.swing.JButton uref;
    public javax.swing.JComboBox<String> us;
    private javax.swing.JLabel userlab;
    public javax.swing.JButton uupdate;
    // End of variables declaration//GEN-END:variables
}
