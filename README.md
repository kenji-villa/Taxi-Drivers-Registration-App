The AddTaxii class serves as a data model for taxi information, encapsulating attributes such as taxiID, capacity, model, and year, along with corresponding getter and setter methods. The AddTaxi class handles database operations, specifically inserting taxi records into a SQL Server database. It uses JDBC to establish a connection and executes a prepared SQL INSERT statement to add taxi data stored in an AddTaxii object. 
RemoveTaxiSQ deletes taxi records by taxiID from the database.
TaxiService provides a utility method to create and configure AddTaxii objects.
TaxiView retrieves taxi data from the database and formats it into a DefaultTableModel for display in a GUI, such as a Swing table.
UpdateTaxi updates existing taxi records by first verifying the existence of the taxi via oldTaxiID and then applying new values from an AddTaxii object.
