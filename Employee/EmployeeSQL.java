package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeSQL {
    public void updateEmployeeInDatabase(Employee employee, String existingEmail) {
        // Database connection details
    	System.out.println("Deleting record for email2: " + existingEmail);
    String dbUrl = "jdbc:sqlserver://LENO\\SQLEXPRESS;databaseName=Adminstors;integratedSecurity=true;encrypt=false;portNumber=1433";

        // SQL UPDATE statement
        String sql = "UPDATE Employee SET Name = ?, PhoneNumber = ?, Address = ?, gender = ?, Dob = ?, Email = ? WHERE Email = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	 //System.out.println("Deleting record for email: " + email);
            // Set the values for the update
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPhone());
            pstmt.setString(3, employee.getAdress());
            pstmt.setString(4, employee.getGender());
            pstmt.setString(5, employee.getdob());            
            pstmt.setString(6, employee.getNEmail());
            pstmt.setString(7, existingEmail);
            // Execute the UPDATE statement
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("The row was updated successfully!");
            }
            else {
                System.out.println("Failed to insert the new record."); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
