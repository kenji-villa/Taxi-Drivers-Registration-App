package Taxi;

public class TaxiService {
	public AddTaxii createTaxi(String taxiID, int capacity, String model, int year) {
        AddTaxii taxi = new AddTaxii();
        taxi.setTaxiID(taxiID); 
        taxi.setCapacity(capacity);
        taxi.setModel(model);
        taxi.setYear(year);
        return taxi;
    }

}
