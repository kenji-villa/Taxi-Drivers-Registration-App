package verify;
import form.FormEditE;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EditEmpp {
    public void editor(String oldEmail, String newEmail, String Name, String Address, String Dob, Long Phone, String gender) {
        String dbUrl = "jdbc:sqlserver://user\\SQLEXPRESS;databaseName=db_name;integratedSecurity=true;encrypt=false;portNumber=1433";

        try (Connection connection = DriverManager.getConnection(dbUrl);
             PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM Employee WHERE Email = ?");
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Employee (Email, Name, Address, PhoneNumber, Dob, gender) VALUES (?, ?, ?, ?, ?, ?)")) {

            deleteStatement.setString(1, oldEmail);
            int rowsDeleted = deleteStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Existing record deleted successfully!");

                statement.setString(1, newEmail);
                statement.setString(2, Name);
                statement.setString(3, Address);
                statement.setLong(4, Phone);
                statement.setString(5, Dob);
                statement.setString(6, gender);

                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("New record inserted successfully!");
                } else {
                    System.out.println("Failed to insert new record.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
