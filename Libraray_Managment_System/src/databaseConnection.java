import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 class con{
     
        String url = "jdbc:mysql://127.0.0.1:3306/project";
//        jdbc:mysql://db4free.net:3306/noman123
//        jdbc:mysql://127.0.0.1:3306/
        String user = "root";
        String password = "root";
        
        void start(){
     
        }
 
 }
public class databaseConnection extends  con{
    Connection conn;
    Statement stmt;
    ResultSet rs; 
    public void connectionsql(){
           try {
            
            conn = DriverManager.getConnection(url, user, password);  
            stmt = conn.createStatement();
  
        } 
         catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
      
    }
}
