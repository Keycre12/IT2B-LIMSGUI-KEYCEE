/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.adminUsers;
import static admin.createUserForm.getHeightFromWidth;
import config.PanelPrinter;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Keycee Bolambot
 */
public class soloprintbooks extends javax.swing.JFrame {


    public soloprintbooks() {
        initComponents();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        print = new javax.swing.JButton();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        page = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        uid = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bisbn = new javax.swing.JLabel();
        isbn = new javax.swing.JLabel();
        Lname = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        Cnum = new javax.swing.JLabel();
        em = new javax.swing.JLabel();
        cat = new javax.swing.JLabel();
        Uname = new javax.swing.JLabel();
        pub = new javax.swing.JLabel();
        JPanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        print.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        print.setText("PRINT");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        Header.setBackground(new java.awt.Color(255, 204, 102));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        Header.setForeground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRINTING FORM");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        page.setBackground(new java.awt.Color(255, 255, 255));
        page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MATRIX INTERNATIONAL LIBRARY-CEBU.INC");
        page.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 17, 324, 21));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Poblacion AB, Minglanilla Cebu");
        page.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 45, 263, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sb.png"))); // NOI18N
        page.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 17, -1, 57));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        page.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 84, 680, 10));

        uid.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        page.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 114, 199, 39));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jLabel7.setText("Book ID:");
        page.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 114, 79, 39));

        bisbn.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        bisbn.setText("Book ISBN:");
        page.add(bisbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 160, 79, 39));

        isbn.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        page.add(isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 199, 39));

        Lname.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        Lname.setText("Book Title");
        page.add(Lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 206, 79, 39));

        title.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        page.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 206, 199, 39));

        author.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        page.add(author, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 252, 199, 39));

        Cnum.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        Cnum.setText("Author:");
        page.add(Cnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 252, 79, 39));

        em.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        em.setText("Category:");
        page.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 298, 79, 39));

        cat.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        page.add(cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 298, 199, 39));

        Uname.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        Uname.setText("Publisher:");
        page.add(Uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 344, 79, 39));

        pub.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        page.add(pub, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 344, 199, 39));

        JPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        JPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setBackground(new java.awt.Color(255, 255, 255));
        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setText("No Image Found");
        JPanel.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 300));

        page.add(JPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 114, 240, 320));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/oksnato.png"))); // NOI18N
        page.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 90, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(print)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(page, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(page, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        JPanel myPanel = new JPanel();
        PanelPrinter pp = new PanelPrinter(page);
        pp.printPanel();

    }//GEN-LAST:event_printActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        dispBooks adus = new dispBooks();
        adus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(soloprintbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(soloprintbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(soloprintbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(soloprintbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new soloprintbooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cnum;
    private javax.swing.JPanel Header;
    public javax.swing.JPanel JPanel;
    private javax.swing.JLabel Lname;
    private javax.swing.JLabel Uname;
    public javax.swing.JLabel author;
    private javax.swing.JLabel bisbn;
    public javax.swing.JLabel cat;
    private javax.swing.JLabel em;
    public javax.swing.JLabel image;
    public javax.swing.JLabel isbn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel page;
    private javax.swing.JButton print;
    public javax.swing.JLabel pub;
    public javax.swing.JLabel title;
    public javax.swing.JLabel uid;
    // End of variables declaration//GEN-END:variables
}
