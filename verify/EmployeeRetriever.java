package verify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

public class EmployeeRetriever {

    private static final String DB_URL = "jdbc:sqlserver://LENO\\SQLEXPRESS;databaseName=Adminstors;integratedSecurity=true;encrypt=false;portNumber=1433";

    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(DB_URL);
    }

    public DefaultTableModel getEmployeeData() {
        String query = "SELECT Name, Email, Address, PhoneNumber, Dob, gender, DateOfJoin, Rating, Status, TaxiID FROM Employee";
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Name", "Email", "Address", "PhoneNumber", "Age", "gender", "DateOfJoin", "Rating", "Status", "TaxiID"}, 0);

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                String address = resultSet.getString("Address");
                long phoneNumber = resultSet.getLong("PhoneNumber");
                String dob = resultSet.getString("Dob");
                String gender = resultSet.getString("gender");
                String dateOfJoin = resultSet.getString("DateOfJoin");
                String rating = resultSet.getString("Rating");
                String status = resultSet.getString("Status");
                String taxiID = resultSet.getString("TaxiID");

                int age = calculateAge(dob);

                tableModel.addRow(new Object[]{name, email, address, phoneNumber, age, gender, dateOfJoin, rating, status, taxiID});
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return tableModel;
    }

    private int calculateAge(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}
