package Cabb;

public class NewUser {
	
	       String Name;
	       String Password;
		   String Email;
		   String Gender;
		   Long PhoneNumber;
		  
		   
	       public NewUser(String Name, String Password, String Email,String Gender, Long PhoneNumber) {
	    	    this.Name = Name;
	    	    this.Password = Password;
	    	    this.Email = Email;
	    	    this.PhoneNumber = PhoneNumber;
	    	    this.Gender = Gender;
	       }

		public String getGender() {
			return Gender;
		}

		public void setGender(String gender) {
			Gender = gender;
		}
	   
}
