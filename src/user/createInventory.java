
package user;

import config.Session;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class createInventory extends javax.swing.JFrame {

   
    public createInventory() {
        initComponents();
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lef = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        navi1 = new javax.swing.JPanel();
        bdel = new javax.swing.JButton();
        bref = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        bcan = new javax.swing.JButton();
        badd = new javax.swing.JButton();
        uid = new javax.swing.JLabel();
        bedit = new javax.swing.JButton();
        bookid = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        bor = new javax.swing.JTextField();
        dam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        los = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        i_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD INVENTORY");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 530, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        Header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 90, 70));

        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 720, 90));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Total Qty:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 90, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Total Lost:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 90, 40));

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
        jPanel1.add(lef, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 110, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Total Damage:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 150, 40));

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
        navi1.add(bdel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, 50));

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
        navi1.add(bref, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 170, 50));

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
        navi1.add(bclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, 50));

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
        navi1.add(bcan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 170, 50));

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
        navi1.add(badd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 50));

        uid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        uid.setText("USER ID:");
        navi1.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 90, 40));

        bedit.setBackground(new java.awt.Color(102, 102, 102));
        bedit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
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
        navi1.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 50));

        jPanel1.add(navi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 600));

        bookid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bookid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bookid.setEnabled(false);
        bookid.setRequestFocusEnabled(false);
        bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookidActionPerformed(evt);
            }
        });
        bookid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bookidKeyReleased(evt);
            }
        });
        jPanel1.add(bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 260, 40));

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
        jPanel1.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 260, 40));

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
        jPanel1.add(bor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 130, 40));

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
        jPanel1.add(dam, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 130, 40));

        jButton1.setText("Books Left:");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 100, 40));

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
        jPanel1.add(los, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 130, 40));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Total Borrowed:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 170, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Book ID:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 90, 40));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Inventory ID:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 90, 40));

        i_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        i_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        i_id.setEnabled(false);
        i_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_idActionPerformed(evt);
            }
        });
        i_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                i_idKeyReleased(evt);
            }
        });
        jPanel1.add(i_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 260, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        dispInv db = new dispInv();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
        dispInv adus = new dispInv();
        adus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bcanActionPerformed

    private void baddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baddMouseClicked
        bookInventory cbf = new bookInventory();
        cbf.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_baddMouseClicked

    private void baddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baddMouseEntered
        badd.setBackground(hovercolor);
    }//GEN-LAST:event_baddMouseEntered

    private void baddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baddMouseExited
        badd.setBackground(navcolor);
    }//GEN-LAST:event_baddMouseExited

    private void baddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baddActionPerformed
        bookInventory bi = new bookInventory();
        bi.setVisible(true);
        this.dispose();
 

if (qty.getText().isEmpty() || bor.getText().isEmpty() || dam.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "All fields are required");
    return;
} 
else if (!qty.getText().matches("\\d+") || !bor.getText().matches("\\d+") || !dam.getText().matches("\\d+")) {
    JOptionPane.showMessageDialog(null, "Must be positive whole numbers.");
    return;
} 
else {
    try {
        int quant = Integer.parseInt(qty.getText());
        int borrowed = Integer.parseInt(bor.getText());
        int damaged = Integer.parseInt(dam.getText());
        int lost = los.getText().isEmpty() ? 0 : Integer.parseInt(los.getText());

        if (borrowed + damaged > quant) {
            JOptionPane.showMessageDialog(null, "Cannot exceed Total Quantity.");
            return;
        }

        int left = quant - borrowed - damaged;
        lef.setText(String.valueOf(left));

        dbConnect dbc = new dbConnect();
        
       int bookidInt = Integer.parseInt(bookid.getText().trim());

        String query = "INSERT INTO inventory (b_id, quantity, borrowed, damaged, lost, available) " +
               "VALUES('" + bookidInt + "', " + quant + ", " + borrowed + 
               ", " + damaged + ", " + lost + ", " + left + ")";


        int rowsInserted = dbc.insertData(query);

        if (rowsInserted > 0) {
            try {
                if (selectedFile != null) {
                    Files.copy(selectedFile.toPath(), new File(destination).toPath(), 
                             StandardCopyOption.REPLACE_EXISTING);
                }
                JOptionPane.showMessageDialog(null, "Inventory added Successfully!");
                dispInv disp = new dispInv();
                disp.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                System.out.println("Insert Image Error: " + ex);
                JOptionPane.showMessageDialog(null, "Image saving failed: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Inventory insertion failed!");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid number format in fields");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        ex.printStackTrace();
    }
}
    }//GEN-LAST:event_baddActionPerformed

    private void bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookidActionPerformed

    private void bookidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookidKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_bookidKeyReleased

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

    private void losActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_losActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_losActionPerformed

    private void losKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_losKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_losKeyReleased

    private void i_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_i_idActionPerformed

    private void i_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_i_idKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_i_idKeyReleased

    private void beditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beditMouseClicked
       if (qty.getText().isEmpty() || bor.getText().isEmpty() || dam.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Quantity, Borrowed and Damaged fields are required");
    return;
} 
else if (!qty.getText().matches("\\d+") || !bor.getText().matches("\\d+") || !dam.getText().matches("\\d+")) {
    JOptionPane.showMessageDialog(null, "Quantity, Borrowed, and Damaged must be positive whole numbers.");
    return;
} 
else {
    try {
        // Parse and validate inventory numbers
        int quant = Integer.parseInt(qty.getText());
        int borrowed = Integer.parseInt(bor.getText());
        int damaged = Integer.parseInt(dam.getText());
        int lost = los.getText().isEmpty() ? 0 : Integer.parseInt(los.getText());

        if (borrowed + damaged + lost > quant) {
            JOptionPane.showMessageDialog(null, "Borrowed + Damaged + Lost cannot exceed Total Quantity.");
            return;
        }

        int available = quant - borrowed - damaged - lost;

        dbConnect dbc = new dbConnect();

        dbc.updateData("UPDATE inventory SET quantity = '" + quant + "', borrowed = '" + borrowed + "', "
                + "damaged = '" + damaged + "', lost = '" + lost + "', available = '" + available + "' WHERE i_id = '" + i_id.getText() + "'");

        dispInv db = new dispInv();
        db.setVisible(true);
        this.dispose();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter valid numeric values.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

    }//GEN-LAST:event_beditMouseClicked

    private void beditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beditMouseEntered
        bedit.setBackground(hovercolor);
    }//GEN-LAST:event_beditMouseEntered

    private void beditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beditMouseExited
        bedit.setBackground(navcolor);
    }//GEN-LAST:event_beditMouseExited

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed

    }//GEN-LAST:event_beditActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         Session ses = Session.getInstance();
        uid.setText(""+ses.getUid());
         
        
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
            java.util.logging.Logger.getLogger(createInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    public javax.swing.JButton badd;
    public javax.swing.JButton bcan;
    public javax.swing.JButton bclear;
    public javax.swing.JButton bdel;
    public javax.swing.JButton bedit;
    public javax.swing.JTextField bookid;
    public javax.swing.JTextField bor;
    public javax.swing.JButton bref;
    public javax.swing.JTextField dam;
    public javax.swing.JTextField i_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField lef;
    public javax.swing.JTextField los;
    private javax.swing.JPanel navi1;
    public javax.swing.JTextField qty;
    private javax.swing.JLabel uid;
    // End of variables declaration//GEN-END:variables
}
