package Taxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTaxi {


	    public void insertTaxiIntoDatabase(AddTaxii taxi) {
	        // Database connection details
	       String DbUrl = "jdbc:sqlserver://user\\SQLEXPRESS;databaseName=db_name;integratedSecurity=true;encrypt=false;portNumber=1433";

	        // SQL INSERT statement
	        String sql = "INSERT INTO Taxi (TaxiID, Capacity, Model, Year) VALUES (?, ?, ?, ?)";

	        try (Connection conn = DriverManager.getConnection(DbUrl);
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            // Set the values for the new row from the Taxi object
	            pstmt.setString(1, taxi.getTaxiID());
	            pstmt.setInt(2, taxi.getCapacity());
	            pstmt.setString(3, taxi.getModel());
	            pstmt.setInt(4, taxi.getYear());

	            // Execute the INSERT statement
	            int rowsInserted = pstmt.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("A new row was inserted successfully!");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	


