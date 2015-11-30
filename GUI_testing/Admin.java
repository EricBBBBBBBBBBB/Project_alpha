/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Admin.java:
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

class Admin extends User{

// Declare data members
	public static int totalNoOfAdmin = 0;  // class data member

// Constructors
	Admin(int uid, String name, String pw) {
		super(uid, name, pw, 2);	//call superclass constructor
	}

// Methods
	// Print Admin information
	public void printUserInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		String output = 
			"---------------------------------------------------------------------------\n" +
			"-                               Admin Information                               -\n" +
			"---------------------------------------------------------------------------\n" +
			"User ID: \t  " + getUserID() + "\n" +
			"User Name: \t  " + getUserName() + "\n" +
			"User Email: \t  " + getUserEmail() + "\n" +
			"User Phone: \t  " + getUserPhone() + "\n" +
			"Date of register:  " + sdf.format(dateOfRegister) + "\n" + 
			"Date of Birth: \t  " + dateOfBirth + "\n" + 
			"---------------------------------------------------------------------------\n" +
			"End of Personal Infomation.\n";
		test.write(output);
	}
}