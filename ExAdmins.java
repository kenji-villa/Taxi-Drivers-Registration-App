package Cabb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExAdmins {
	

	public boolean validateLogin(String Name, String password) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	   //System.load("C:\\\\Program Files\\\\Java\\\\jdk-22\\\\bin/mssql-jdbc_auth-12.8.0.x64.dll");
	    //System.setProperty("java.library.path", "/path/to/dll/C:\\Program Files\\Java\\jdk-22\\bin");

	    try {
	        conn = DriverManager.getConnection("jdbc:sqlserver://LENO\\SQLEXPRESS;database=Adminstors;integratedSecurity=true; encrypt=false;portNumber=1433");
	        			
	        String query = "SELECT Name, Password FROM Admin WHERE Name = ?";
	        stmt = conn.prepareStatement(query);
	        stmt.setString(1, Name);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	        	String storedUsername = rs.getString("Name");
	            String storedPassword = rs.getString("Password");
	            
	            if (storedUsername.equals(Name) && storedPassword.equals(password)) {
	                return true;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return false;
	}
}
