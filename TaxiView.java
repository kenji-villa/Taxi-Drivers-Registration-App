package Taxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import form.FormVeiwT;

public class TaxiView {
    // Method to get the row count of the Taxi table
	private static final String DB_URL = "jdbc:sqlserver://LENO\\SQLEXPRESS;databaseName=Adminstors;integratedSecurity=true;encrypt=false;portNumber=1433";

    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(DB_URL);
    }

    public DefaultTableModel getTaxiData() {
        String query = "SELECT TaxiID, CapacitY, Model, Year FROM Taxi";
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"TaxiID", "Capacity", "Model", "Year"}, 0);

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String taxiID = resultSet.getString("TaxiID");
                int capacity = resultSet.getInt("CapacitY");
                String model = resultSet.getString("Model");
                int year = resultSet.getInt("Year");

                tableModel.addRow(new Object[]{taxiID, String.valueOf(capacity), model, String.valueOf(year)});
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return tableModel;
    }


}