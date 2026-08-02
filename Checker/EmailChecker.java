package Checker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailChecker {
	 public static boolean isEmailTaken(String email) {
	        String query = "SELECT COUNT(*) FROM Employee WHERE Email = ?";
	        String 	DbUrl = "jdbc:sqlserver://LENO\\SQLEXPRESS;databaseName=Adminstors;integratedSecurity=true;encrypt=false;portNumber=1433";
	        try (Connection conn = DriverManager.getConnection(DbUrl);
	             PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setString(1, email);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    return rs.getInt(1) > 0;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

}
