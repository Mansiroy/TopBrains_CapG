package javaJdbcConnection;
importjava.sql.*;

public class JdbcExample {

public static void main(String[] args) {
try {            
// Step 1: Import java.sql package (done automatically in this code) 
// Step 2: Load and Register Driver
Class.forName("com.mysql.cj.jdbc.Driver");
// Step 3: Establish Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TEMP1", "root", "");
// Step 4: Create Statement and Execute Query
            Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM student");
// Step 5: Process Results and Close Connection
            System.out.println("Student Records:");
while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
", Name: " + rs.getString("name"));
            }
rs.close();
stmt.close();
con.close();
            System.out.println("Connection closed successfully.");
        } catch (Exception e) {
e.printStackTrace();
        }
    }
}
