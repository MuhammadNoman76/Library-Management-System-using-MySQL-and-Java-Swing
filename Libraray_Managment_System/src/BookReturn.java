/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.*;


public class BookReturn extends javax.swing.JFrame {
        databaseConnection con = new databaseConnection();

  
    public BookReturn() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

       
    }
    

        
    
    public  void main() {
        con.connectionsql();
       
        int id = Integer.parseInt(jTextField2.getText());

                      int bid = 0;
                      String bname = "";
                      String bgenre = "";
         try {  
                    String query1 = "SELECT * FROM display_books WHERE ID = ?";
                    
                    PreparedStatement pstmt = con.conn.prepareStatement(query1);
                    pstmt.setInt(1, id);
                    ResultSet rs = pstmt.executeQuery();
                    
                if (rs.next()) {
                      
                      bid = rs.getInt("ID");
                      String ID = String.valueOf(bid);
                      bname = rs.getString("name");
                      bgenre = rs.getString("genre");
                    
              
                }
                
                } catch (SQLException ex) {
                    return;
         }
         String query = "INSERT INTO books (ID, name, genre) VALUES (?, ?, ?)";
         try{
                    PreparedStatement pstmt = con.conn.prepareStatement(query);
                    
                    pstmt.setInt(1, bid);
                    pstmt.setString(2, bname);
                    pstmt.setString(3, bgenre);
                    pstmt.executeUpdate();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Book Not returned Succesfully :(");
                    return;
          }
         
            String getIssuedBookQuery = "SELECT * FROM issued_books WHERE book_id = ?";
         try {
            PreparedStatement getIssuedBookStmt = con.conn.prepareStatement(getIssuedBookQuery);
            getIssuedBookStmt.setInt(1, id);
            ResultSet rs = getIssuedBookStmt.executeQuery();
            java.sql.Date returnDate = null;
             if (rs.next()) {
                       returnDate = rs.getDate("return_date");
             }

            LocalDate currentDate = LocalDate.now();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = dateFormatter.parse(currentDate.toString());
            String formattedDate = dateFormatter.format(date);

        boolean a = date.after(returnDate);
                    
             System.out.println(a);
        if (a) {
            JOptionPane.showMessageDialog(null, "You have been of RS : 2000  because you did not return book on time !!!!!!!!!!!");
        }
        else{
            JOptionPane.showMessageDialog(null, "Return on time");
        }
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Book Not returned Succesfully :(");
            return;
        }

            
           
      
        String query1 = "DELETE FROM issued_books WHERE book_id = ?";

        try {
            PreparedStatement pstmt = con.conn.prepareStatement(query1); 
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
            jTextField2.setText("");
        } 
        catch (Exception ex) {
            return;
        }

        JOptionPane.showMessageDialog(null,"Book returned Succesfully");

   
}
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 255, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sideLogin.png"))); // NOI18N
        jLabel6.setText("jLabel4");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 560, 560));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 590, 610));

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BOOK ID ");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, 30));

        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 230, 50));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RETURNN.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 100, 112));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 260, 590, 610));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 100)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("RETURN BOOK ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backicON.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 200, 200));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try {
             main();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Book_Area().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(BookReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookReturn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
