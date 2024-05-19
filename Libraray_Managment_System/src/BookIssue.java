
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest-a
 */
public class BookIssue extends javax.swing.JFrame {
 
    /**
     * Creates new form IssueBooks
     */
    databaseConnection con = new databaseConnection();
    public BookIssue() {
        
           initComponents();
          Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
          this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
          setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
    public boolean CheckOldIDinMembers(){
         con.connectionsql();
           boolean found = false;
                   
                int id = Integer.parseInt(jTextField1.getText());
                String query1 = "SELECT * FROM members WHERE ID = ?";
                
                try {
                    
                    PreparedStatement pstmt = con.conn.prepareStatement(query1);
                    pstmt.setInt(1, id);
                    ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                      found = true;    
                } 
                else {
                     found = false;     
                }
                } catch (SQLException ex) {
                    
                }
                return found;
       
    }
    
        public boolean CheckOldIDinBooks(){
           con.connectionsql();
           boolean found = false;
           int id = Integer.parseInt(jTextField2.getText());
                String query1 = "SELECT * FROM books WHERE ID = ?";
                
                try {
                    PreparedStatement pstmt = con.conn.prepareStatement(query1);
                    pstmt.setInt(1, id);
                    ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                      found = true;    
                } 
                else {
                     found = false;     
                }
                } catch (SQLException ex) {
                    
                }
                return found;
    }
        
  
        
    public void issuedBok(){
         con.connectionsql();
            
            int bookid = 0;
            int memberid = 0;
            String BookID = "";
            String MemberID = "";

            int issuedmemberid = Integer.parseInt(jTextField1.getText());
            int issuedbookidid = Integer.parseInt(jTextField2.getText());
                boolean found = false;
                String query1 = "SELECT * FROM books WHERE ID = ?";
                String query3 = "SELECT * FROM members WHERE ID = ?";
                try {
                    PreparedStatement pstmt = con.conn.prepareStatement(query1);
                    pstmt.setInt(1, issuedbookidid);
                    ResultSet rs = pstmt.executeQuery();

                    

                     if (rs.next()) {
                       bookid = rs.getInt("ID");
                       BookID = String.valueOf(bookid);
                       MemberID = String.valueOf(memberid);
                       try {
                        String query2 = "DELETE FROM books WHERE ID = ?";
                        PreparedStatement pstmt2 = con.conn.prepareStatement(query2); 
                        pstmt2.setInt(1, issuedbookidid);
                        pstmt2.executeUpdate();
                        
                        } 
                        catch (Exception ex) 
                    {       JOptionPane.showMessageDialog(null, ex);
                        }
                    PreparedStatement pstmt3 = con.conn.prepareStatement(query1);
                    pstmt3.setInt(1, issuedbookidid);
                    ResultSet rs1 = pstmt3.executeQuery();
                    if (rs1.next()) {
    
                       memberid = rs1.getInt("ID");
                       MemberID = String.valueOf(memberid);
                      
                    } 
                } 

                } catch (SQLException ex) {
                        System.out.println(ex + "142");
                        return;
                }

        int memberID = Integer.parseInt(MemberID);
        int bookID = Integer.parseInt(BookID);

  
        try {

                LocalDate currentdate = LocalDate.now();
                LocalDate returnDate = currentdate.plusWeeks(1);
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date ;
                Date date2 ;
                String formattedDate = "";
                String formattedDate2 = "";
             try {
                 date = dateFormatter.parse(currentdate.toString());
                 date2 = dateFormatter.parse(returnDate.toString());
                 formattedDate = dateFormatter.format(date);
                 formattedDate2 = dateFormatter.format(date2);
             } catch (ParseException ex) {
                             System.out.println(ex + "166");
                             return;
             }
                
               

                

                

             PreparedStatement statement = con.conn.prepareStatement(
                     "INSERT INTO issued_books (member_id, book_id, issued_date, return_date) VALUES (?, ?, ?, ?)") ;
            statement.setInt(1, issuedmemberid);
            statement.setInt(2, issuedbookidid);
            statement.setString(3, formattedDate);
            statement.setString(4, formattedDate2);
            JOptionPane.showMessageDialog(null, "Book Issued successfully");
            statement.executeUpdate();
   
        } catch (SQLException ex) {
            
            System.out.println(ex+ "186");
            return;
        }

        // Clear the text fields
        jTextField1.setText("");
        jTextField2.setText("");
             
             
                

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
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sideLogin.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 560, 560));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 590, 610));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MEMBER ID TO ISSUE");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 190, 40));

        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 190, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BOOK ID TO ISSUE");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 170, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled-3KK.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 100, 112));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 580, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 470, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 230, 590, 610));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 100)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("BOOK ISSUE ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 760, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backicON.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 200, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            boolean found1 = CheckOldIDinMembers();
            boolean found2 = CheckOldIDinBooks(); 
            try {
       
            if (!found1) {
                JOptionPane.showMessageDialog(null, "There is no member of this ID");
                return;
            }
            if (!found2) {
                JOptionPane.showMessageDialog(null, "There is no book of this ID");
                return;
            }
            issuedBok();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
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
            java.util.logging.Logger.getLogger(BookIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookIssue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
