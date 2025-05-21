/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.adminUsers;
import config.dbConnect;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Keycee Bolambot
 */
public class createBookForm extends javax.swing.JFrame {

    /**
     * Creates new form createBookForm
     */
    public createBookForm() {
        initComponents();
    }
    public boolean updateCheck() {
    dbConnect dbc = new dbConnect();
    try {
        String query = "SELECT * FROM books WHERE (b_isbn = '" + isbn.getText() + "' OR b_title = '" + title.getText() + "') AND b_id !='"+uid.getText()+"'";
        ResultSet resultSet = dbc.getData(query);
        
        if (resultSet.next()) {
            if (resultSet.getString("b_title").equals(title.getText())) {
                JOptionPane.showMessageDialog(null, "Email is already used!");
                title.setText(""); 
                return true;  
            }

            if (resultSet.getString("b_isbn").equals(isbn.getText())) {
                JOptionPane.showMessageDialog(null, "Username is already used!!");
                isbn.setText("");  // Clear username field
                return true;  // Stop further checks
            }
        }
    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex);
    }
    return false;  
    }
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    public String pic;
    
    public int FileExistenceChecker(String path) {
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
    
    
    
    public ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage = null;
        if (ImagePath != null) {
            MyImage = new ImageIcon(ImagePath);
        } else {
            MyImage = new ImageIcon(pic);
        }

        int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public void imageUpdater(String existingFilePath, String newFilePath) {
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: " + e);
            }
        } else {
            try {
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Error on update!");
            }
        }
    }

     Color navcolor = new Color(102,102,102);
     Color hovercolor = new Color(204,204,204);
     
    public boolean updateBookCheck() {
    dbConnect dbc = new dbConnect();
    try {
        String query = "SELECT * FROM books WHERE b_isbn = '" + isbn.getText() + "' OR b_title = '" + title.getText() + "'";
        ResultSet resultSet = dbc.getData(query);

        if (resultSet.next()) {
            if (resultSet.getString("b_isbn").equals(isbn.getText())) {
                JOptionPane.showMessageDialog(null, "ISBN is already used!");
                isbn.setText("");
                return true;
            }

            if (resultSet.getString("b_title").equalsIgnoreCase(title.getText())) {
                JOptionPane.showMessageDialog(null, "Title is already used!");
                title.setText("");
                return true;
            }
        }
    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex);
    }
    return false;
}



   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        author = new javax.swing.JTextField();
        cat = new javax.swing.JTextField();
        pub = new javax.swing.JTextField();
        lef = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        navi1 = new javax.swing.JPanel();
        bdel = new javax.swing.JButton();
        bref = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        bcan = new javax.swing.JButton();
        badd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        JPanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        select = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        isbn = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        bor = new javax.swing.JTextField();
        dam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        los = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        isbnlab = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD BOOK");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 840, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        Header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 90, 70));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 1010, 90));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Author:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Category:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 75, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Publisher:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 83, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Total Qty:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 90, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Total Lost:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 90, 40));

        title.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        title.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });
        title.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                titleKeyReleased(evt);
            }
        });
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 260, 40));

        author.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        author.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorActionPerformed(evt);
            }
        });
        author.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                authorKeyReleased(evt);
            }
        });
        getContentPane().add(author, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 260, 40));

        cat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catActionPerformed(evt);
            }
        });
        cat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                catKeyReleased(evt);
            }
        });
        getContentPane().add(cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 260, 40));

        pub.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pub.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubActionPerformed(evt);
            }
        });
        pub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pubKeyReleased(evt);
            }
        });
        getContentPane().add(pub, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 260, 40));

        lef.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lef.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lefActionPerformed(evt);
            }
        });
        lef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lefKeyReleased(evt);
            }
        });
        getContentPane().add(lef, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 640, 110, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Total Damage:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 150, 40));

        navi1.setBackground(new java.awt.Color(102, 102, 102));
        navi1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        navi1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bdel.setBackground(new java.awt.Color(102, 102, 102));
        bdel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bdel.setText("DELETE");
        bdel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bdelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bdelMouseExited(evt);
            }
        });
        bdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdelActionPerformed(evt);
            }
        });
        navi1.add(bdel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 170, 50));

        bref.setBackground(new java.awt.Color(102, 102, 102));
        bref.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bref.setText("REFRESH");
        bref.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                brefMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                brefMouseExited(evt);
            }
        });
        bref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brefActionPerformed(evt);
            }
        });
        navi1.add(bref, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 170, 50));

        bedit.setBackground(new java.awt.Color(102, 102, 102));
        bedit.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bedit.setText("UPDATE");
        bedit.setEnabled(false);
        bedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                beditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                beditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                beditMouseExited(evt);
            }
        });
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        navi1.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 170, 50));

        bclear.setBackground(new java.awt.Color(102, 102, 102));
        bclear.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bclear.setText("CLEAR");
        bclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bclearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bclearMouseExited(evt);
            }
        });
        bclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclearActionPerformed(evt);
            }
        });
        navi1.add(bclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 170, 50));

        bcan.setBackground(new java.awt.Color(102, 102, 102));
        bcan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bcan.setText("CANCEL");
        bcan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcanMouseExited(evt);
            }
        });
        bcan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcanActionPerformed(evt);
            }
        });
        navi1.add(bcan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 170, 50));

        badd.setBackground(new java.awt.Color(102, 102, 102));
        badd.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        badd.setText("ADD");
        badd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                baddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                baddMouseExited(evt);
            }
        });
        badd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baddActionPerformed(evt);
            }
        });
        navi1.add(badd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 170, 50));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("USER ID:");
        navi1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 90, 40));

        getContentPane().add(navi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 600));

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
        getContentPane().add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 260, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Book Title:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 90, 50));

        JPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(8, 8, 8, 8, new java.awt.Color(0, 0, 0)));
        JPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JPanel.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 300));

        getContentPane().add(JPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 240, 320));

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
        getContentPane().add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 440, 90, 50));

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
        getContentPane().add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 90, 50));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Book ISBN:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 90, 50));

        isbn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        isbn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        isbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbnActionPerformed(evt);
            }
        });
        isbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                isbnKeyReleased(evt);
            }
        });
        getContentPane().add(isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 260, 40));

        qty.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
        });
        getContentPane().add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 260, 40));

        bor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borActionPerformed(evt);
            }
        });
        bor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                borKeyReleased(evt);
            }
        });
        getContentPane().add(bor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 130, 40));

        dam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                damActionPerformed(evt);
            }
        });
        dam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                damKeyReleased(evt);
            }
        });
        getContentPane().add(dam, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 580, 130, 40));

        jButton1.setText("Books Left:");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, 100, 40));

        los.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        los.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        los.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                losActionPerformed(evt);
            }
        });
        los.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                losKeyReleased(evt);
            }
        });
        getContentPane().add(los, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 520, 130, 40));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Total Borrowed:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 520, 170, 40));

        isbnlab.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(isbnlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 260, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Book ID:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 90, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleActionPerformed

    private void titleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleKeyReleased
       
    }//GEN-LAST:event_titleKeyReleased

    private void authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorActionPerformed

    private void authorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_authorKeyReleased
      
    }//GEN-LAST:event_authorKeyReleased

    private void catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catActionPerformed

    private void catKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_catKeyReleased

    }//GEN-LAST:event_catKeyReleased

    private void pubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pubActionPerformed

    private void pubKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pubKeyReleased
 
    }//GEN-LAST:event_pubKeyReleased

    private void lefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lefActionPerformed

    private void lefKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lefKeyReleased
     
    }//GEN-LAST:event_lefKeyReleased

    private void bdelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdelMouseEntered
        bdel.setBackground(hovercolor);
    }//GEN-LAST:event_bdelMouseEntered

    private void bdelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdelMouseExited
        bdel.setBackground(navcolor);
    }//GEN-LAST:event_bdelMouseExited

    private void bdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdelActionPerformed

    private void brefMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brefMouseEntered
        bref.setBackground(hovercolor);
    }//GEN-LAST:event_brefMouseEntered

    private void brefMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brefMouseExited
        bref.setBackground(navcolor);
    }//GEN-LAST:event_brefMouseExited

    private void brefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brefActionPerformed

    private void beditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beditMouseEntered
        bedit.setBackground(hovercolor);
    }//GEN-LAST:event_beditMouseEntered

    private void beditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beditMouseExited
        bedit.setBackground(navcolor);
    }//GEN-LAST:event_beditMouseExited

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed

//   

    }//GEN-LAST:event_beditActionPerformed

    private void bclearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bclearMouseEntered
        bclear.setBackground(hovercolor);
    }//GEN-LAST:event_bclearMouseEntered

    private void bclearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bclearMouseExited
        bclear.setBackground(navcolor);
    }//GEN-LAST:event_bclearMouseExited

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bclearActionPerformed

    private void bcanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcanMouseEntered
        bcan.setBackground(hovercolor);
    }//GEN-LAST:event_bcanMouseEntered

    private void bcanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcanMouseExited
        bcan.setBackground(navcolor);
    }//GEN-LAST:event_bcanMouseExited

    private void bcanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcanActionPerformed
        dispBooks adus = new dispBooks();
        adus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bcanActionPerformed

    private void baddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baddMouseClicked
        createBookForm cbf = new createBookForm();
        cbf.setVisible(true);
        cbf.remove.setEnabled(false);
        cbf.select.setEnabled(true);
        this.dispose();

    }//GEN-LAST:event_baddMouseClicked

    private void baddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baddMouseEntered
        badd.setBackground(hovercolor);
    }//GEN-LAST:event_baddMouseEntered

    private void baddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baddMouseExited
        badd.setBackground(navcolor);
    }//GEN-LAST:event_baddMouseExited

    private void baddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baddActionPerformed
        if (title.getText().isEmpty()
                || isbn.getText().isEmpty()
                || author.getText().isEmpty()
                || pub.getText().isEmpty()
                || qty.getText().isEmpty()
                || bor.getText().isEmpty()
                || dam.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "All fields are required");
            return;

        } else if (updateBookCheck()) {  // Only called during add
            System.out.println("Duplicate Exist");
            return;

        } else if (!isbn.getText().matches("[0-9Xx]{10}")) {
            JOptionPane.showMessageDialog(null, "Invalid ISBN. It must be exactly 10 characters");
            return;

        } else if (!qty.getText().matches("\\d+")
                || !bor.getText().matches("\\d+")
                || !dam.getText().matches("\\d+")) {

            JOptionPane.showMessageDialog(null, "Quantity, Borrowed, and Damaged must be positive whole numbers.");
            return;

        } else {
            int quant = Integer.parseInt(qty.getText());
            int borrowed = Integer.parseInt(bor.getText());
            int damaged = Integer.parseInt(dam.getText());
            int lost = Integer.parseInt(los.getText());

            if (borrowed + damaged > quant) {
                JOptionPane.showMessageDialog(null, "Borrowed and Damaged books cannot exceed Total Quantity.");
                return;
            }

            int left = quant - borrowed - damaged;
            lef.setText(String.valueOf(left)); // Auto-set available

            dbConnect dbc = new dbConnect();

            int rowsInserted = dbc.insertData("INSERT INTO books (b_isbn, b_title, b_category, b_author, publisher, quantity, borrowed, damaged, lost, available, b_image) "
                    + "VALUES('" + isbn.getText() + "', '" + title.getText() + "', '" + cat.getText() + "', "
                    + "'" + author.getText() + "', '" + pub.getText() + "', " + quant + ", "
                    + borrowed + ", " + damaged + ", " + lost + ",  " + left + ", '" + destination + "')");

            if (rowsInserted > 0) {
                try {
                    if (selectedFile != null) {
                        Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                    JOptionPane.showMessageDialog(null, "Book Registered Successfully!");
                    dispBooks disp = new dispBooks();
                    disp.setVisible(true);
                    this.dispose();
                } catch (IOException ex) {
                    System.out.println("Insert Image Error: " + ex);
                    JOptionPane.showMessageDialog(null, "Image saving failed: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Book Registration Failed!");
            }
        }



    }//GEN-LAST:event_baddActionPerformed

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
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked

    }//GEN-LAST:event_selectMouseClicked

    private void selectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_selectMouseEntered

    private void selectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_selectMouseExited

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed

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
                    image.setIcon(ResizeImage(path, null, image));
                    select.setEnabled(false);
                    remove.setEnabled(true);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_selectActionPerformed

    private void isbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isbnActionPerformed

    private void isbnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnKeyReleased
        String PATTERN = "[0-9Xx]{10}$";
        Pattern pt = Pattern.compile(PATTERN);
        Matcher match = pt.matcher(isbn.getText());

        if (!match.matches()) {
            isbnlab.setText("Invalid ISBN. It must be exactly 10 characters");
        } else {
            isbnlab.setText(null);
        }
    }//GEN-LAST:event_isbnKeyReleased

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyActionPerformed

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyKeyReleased

    private void borActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_borActionPerformed

    private void borKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_borKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_borKeyReleased

    private void damActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_damActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_damActionPerformed

    private void damKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_damKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_damKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String qtyText = qty.getText();
        String borText = bor.getText();
        String damagedText = dam.getText();
        String lostText = los.getText();

        if (!qtyText.matches("\\d+") || !borText.matches("\\d+") || !damagedText.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Please enter valid positive whole numbers for Quantity, Borrowed, and Damaged.");
            return;
        }

        int qtyVal = Integer.parseInt(qtyText);
        int borrowed = Integer.parseInt(borText);
        int damaged = Integer.parseInt(damagedText);
        int lost = Integer.parseInt(lostText);

        if (borrowed + damaged > qtyVal) {
            JOptionPane.showMessageDialog(null, "Borrowed + Damaged cannot exceed Total Quantity.");
            return;
        }

        int left = qtyVal - borrowed - damaged - lost;
        lef.setText(String.valueOf(left));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void beditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beditMouseClicked
//        if (qty.getText().isEmpty()
//    || bor.getText().isEmpty()
//    || dam.getText().isEmpty()) {
//
//    JOptionPane.showMessageDialog(null, "All numeric fields are required");
//    return;
//
//} else if (!qty.getText().matches("\\d+")
//        || !bor.getText().matches("\\d+")
//        || !dam.getText().matches("\\d+")) {
//
//    JOptionPane.showMessageDialog(null, "Quantity, Borrowed, and Damaged must be positive whole numbers.");
//    return;
//
//} else {
//    int quant = Integer.parseInt(qty.getText());
//    int borrowed = Integer.parseInt(bor.getText());
//    int damaged = Integer.parseInt(dam.getText());
//
//    if (borrowed + damaged > quant) {
//        JOptionPane.showMessageDialog(null, "Borrowed and Damaged books cannot exceed Total Quantity.");
//        return;
//    }
//
//    int available = quant - borrowed - damaged;
//    lef.setText(String.valueOf(available));
//
//    try {
//        dbConnect dbc = new dbConnect();
//        dbc.updateData("UPDATE books SET quantity = '" + qty.getText() + "', borrowed = '" + bor.getText() + "', "
//                + "damaged = '" + dam.getText() + "', available = '" + lef.getText() + "', b_image = '" + destination + "' WHERE b_id = '" + uid.getText() + "'");
//            
//        if(destination.isEmpty()){
//            File existingFile = new File(oldpath);
//            if(existingFile.exists())
//            {
//                existingFile.delete();
//            }
//        }else{
//            if(!(oldpath.equals(destination)))
//            {
//                imageUpdater(oldpath,destination);
//            }
//        }
//
//        JOptionPane.showMessageDialog(null, "Book Updated Successfully!");
//        dispBooks disp = new dispBooks();
//        disp.setVisible(true);
//        this.dispose();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Error updating data: " + e.getMessage());
//    }
//}

 if (isbn.getText().isEmpty()
        || title.getText().isEmpty()
        || cat.getText().isEmpty()
        || author.getText().isEmpty()
        || pub.getText().isEmpty()
        || qty.getText().isEmpty()
        || bor.getText().isEmpty()
        || dam.getText().isEmpty()
        || lef.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "All fields are required");
    return;
} else {
    dbConnect dbc = new dbConnect();

    dbc.updateData("UPDATE books SET b_isbn = '" + isbn.getText() + "', b_title = '" + title.getText() + "', "
            + "b_category = '" + cat.getText() + "', b_author = '" + author.getText() + "', publisher = '" + pub.getText() + "', "
            + "quantity = '" + qty.getText() + "', borrowed = '" + bor.getText() + "', damaged = '" + dam.getText() + "', lost = '" + los.getText() + "', "
            + "available = '" + lef.getText() + "', b_image = '" + destination + "' WHERE b_id = '" + uid.getText() + "'");

    if (destination == null || destination.isEmpty()) {
        File existingFile = new File(oldpath);
        if (existingFile.exists()) {
            existingFile.delete();
        }
    } else {
        if (!oldpath.equals(destination)) {
            imageUpdater(oldpath, destination);
        }
    }

    dispBooks db = new dispBooks();
    db.setVisible(true);
    this.dispose();
}

    
    }//GEN-LAST:event_beditMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        dispBooks db = new dispBooks();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void losActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_losActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_losActionPerformed

    private void losKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_losKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_losKeyReleased

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
            java.util.logging.Logger.getLogger(createBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createBookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createBookForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel JPanel;
    public javax.swing.JTextField author;
    public javax.swing.JButton badd;
    public javax.swing.JButton bcan;
    public javax.swing.JButton bclear;
    public javax.swing.JButton bdel;
    public javax.swing.JButton bedit;
    public javax.swing.JTextField bor;
    public javax.swing.JButton bref;
    public javax.swing.JTextField cat;
    public javax.swing.JTextField dam;
    public javax.swing.JLabel image;
    public javax.swing.JTextField isbn;
    private javax.swing.JLabel isbnlab;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField lef;
    public javax.swing.JTextField los;
    private javax.swing.JPanel navi1;
    public javax.swing.JTextField pub;
    public javax.swing.JTextField qty;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField title;
    public javax.swing.JTextField uid;
    // End of variables declaration//GEN-END:variables
}
