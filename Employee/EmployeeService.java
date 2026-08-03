package Employee;

public class EmployeeService {
    public Employee createEmployee(String name, String Email, String PhoneNumber, String gender, String dob, String dateJoined, String rating, String status) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(Email);
        employee.setPhone(PhoneNumber);
        employee.setGender(gender);
        employee.setDob(dob);
        employee.setDateJoined(dateJoined);
        employee.setRating(rating);
        employee.setStatus(status);
        return employee;
    }
   
}
