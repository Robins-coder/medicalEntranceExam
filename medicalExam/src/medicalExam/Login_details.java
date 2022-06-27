package medicalExam;

import java.util.LinkedHashMap;

public class Login_details {
    
    String name;//key
    String pass;
    String typeOfUser;
    LinkedHashMap questions;
	public Login_details(String name, String pass,String typeOfUser,LinkedHashMap questions) {
		 
		 this.name=name;
		 this.pass=pass;
	     this.typeOfUser=typeOfUser;
	     this.questions=questions;
	}

}
