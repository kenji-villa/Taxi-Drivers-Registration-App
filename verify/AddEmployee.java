package verify;

import Mainwindow.MainWindow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddEmployee {
    public void AddEmps(UserAdd add) {
        String DbUrl = "jdbc:sqlserver://LENO\\SQLEXPRESS;databaseName=Adminstors;integratedSecurity=true;encrypt=false;portNumber=1433";
        String selectQuery = "SELECT Name, Email, Address, PhoneNumber, Dob, gender, DateOfJoin, Rating, Status FROM Employee";
        String insertQuery = "INSERT INTO Employee (Name, Email, Address, PhoneNumber, Dob, gender, DateOfJoin, Rating, Status, TaxiID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        System.out.println("Insert Query: " + insertQuery);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection connection = DriverManager.getConnection(DbUrl);
                 Statement statement = connection.createStatement()) {

                // Get available TaxiIDs
                List<String> availableTaxiIDs = getAvailableTaxiIDs(connection);
                if (availableTaxiIDs.isEmpty()) {
                    System.out.println("No available TaxiIDs.");
                    return;
                }

                // Select a random TaxiID
                Random random = new Random();
                int randomIndex = random.nextInt(availableTaxiIDs.size());
                String selectedTaxiID = availableTaxiIDs.get(randomIndex);

                // Prepare the insert query with the selected TaxiID
                try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
                    pstmt.setString(1, add.Name);
                    pstmt.setString(2, add.Email);
                    pstmt.setString(3, add.Adress);
                    pstmt.setLong(4, add.PhoneNumber);
                    pstmt.setString(5, add.Dob);
                    pstmt.setString(6, add.gender);
                    pstmt.setString(7, add.DateOfJoin);
                    pstmt.setString(8, add.Rating);
                    pstmt.setString(9, add.Status);
                    pstmt.setString(10, selectedTaxiID);

                    // Execute the INSERT query
                    int rowsAffected = pstmt.executeUpdate();
                    System.out.println("Rows affected: " + rowsAffected);
                }

                // Retrieve and display Employee records
                try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
                    while (resultSet.next()) {
                        System.out.println("Employee Name: " + resultSet.getString("Name") +
                                           " Employee Email: " + resultSet.getString("Email") +
                                           " Employee Address: " + resultSet.getString("Address") +
                                           " Employee PhoneNumber: " + resultSet.getLong("PhoneNumber") +
                                           " Employee Dob: " + resultSet.getString("Dob") +
                                           " Employee gender: " + resultSet.getString("gender") +
                                           " Employee DateofJoin: " + resultSet.getString("DateOfJoin") +
                                           " Employee Rating: " + resultSet.getString("Rating") +
                                           " Employee status: " + resultSet.getString("Status") +
                                           " Employee TaxiID: " + resultSet.getString("TaxiID")
                        );
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<String> getAvailableTaxiIDs(Connection connection) {
        List<String> availableTaxiIDs = new ArrayList<>();
        String sql = "SELECT TaxiID FROM Taxi WHERE TaxiID NOT IN (SELECT TaxiID FROM Employee)";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                availableTaxiIDs.add(rs.getString("TaxiID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableTaxiIDs;
    }
}
