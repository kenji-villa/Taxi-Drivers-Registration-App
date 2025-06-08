package Cabb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewAdmins {
       public void Addmin(NewUser add) {
    	   
    	   String DbUrl = "jdbc:sqlserver://LENO\\SQLEXPRESS;databaseName=Adminstors;integratedSecurity=true;encrypt=false;portNumber=1433";
    	    String selectQuery = "SELECT Name, Password, Email, Gender, PhoneNumber FROM Admin";
    	    String insertQuery = "INSERT INTO Admin (Name, Password, Email, Gender, PhoneNumber) VALUES ('" + add.Name + "', '" + add.Password + "', '" + add.Email + "', '" + add.Gender + "', " + add.PhoneNumber + ")";

    	    System.out.println("Insert Query: " + insertQuery);

    	    try {
    	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	        try (Connection connection = DriverManager.getConnection(DbUrl);
    	             Statement statement = connection.createStatement()) {

    	            // Execute the INSERT query
    	            int rowsAffected = statement.executeUpdate(insertQuery);
    	            System.out.println("Rows affected: " + rowsAffected);

    	            // Retrieve and display admin records
    	            try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
    	                while (resultSet.next()) {
    	                    System.out.println("Admin Name: " + resultSet.getString("Name") + 
    	                                       " Admin Password: " + resultSet.getString("Password") + 
    	                                       " Admin Email: " + resultSet.getString("Email") + 
    	                                       " Admin Gender: " + resultSet.getString("Gender") + 
    	                                       " Admin PhoneNumber: " + resultSet.getLong("PhoneNumber"));
    	                }
    	            }

    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    } catch (ClassNotFoundException e) {
    	        e.printStackTrace();
    	    }
    	}
  }
