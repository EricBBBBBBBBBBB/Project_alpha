/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Trainer.java:
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

class Trainer extends User{

// Declare data members 
	public static int totalNoOfTrainer = 0;  // class data member

// Constructors 
	Trainer(int uid, String name, String pw) {
		super(uid, name, pw, 1);	//call superclass constructor
	}

// Methods
	// Print Trainer information
	public void printUserInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		String output = 
			"---------------------------------------------------------------------------\n" +
			"-                               Trainer Information                               -\n" +
			"---------------------------------------------------------------------------\n" +
			"User ID: \t  " + getUserID() + "\n" +
			"User Name: \t  " + getUserName() + "\n" +
			"User Email: \t  " + getUserEmail() + "\n" +
			"User Phone: \t  " + getUserPhone() + "\n" +
			"Date of register:  " + sdf.format(dateOfRegister) + "\n" + 
			"Date of Birth: \t  " + dateOfBirth + "\n" + 
			"---------------------------------------------------------------------------\n" +
			"Owned Courses: \t  " + Curriculum.checkNoOfOwned(getUserID()) + "\n" + 
			"---------------------------------------------------------------------------\n" +
			"End of Personal Infomation.\n";
		OutPutStream.write(output);
	}
	
}