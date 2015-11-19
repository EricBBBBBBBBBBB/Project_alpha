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
		System.out.println("-----------------------------------------------------");	
		System.out.println("-   \t\t" + getUserType() + " Information\t\t   -");
		System.out.println("-----------------------------------------------------");	
		System.out.println("User ID: \t  " + getUserID());
		System.out.println("User Name: \t  " + getUserName());
		System.out.println("User Email: \t  " + getUserEmail());
		System.out.println("User Phone: \t  " + getUserPhone());
		System.out.println("Date of register: " + dateOfRegister.getTime());
		System.out.println("-----------------------------------------------------");
		System.out.println("Owned Courses: \t  " + Curriculum.checkNoOfOwned(getUserID()));
		System.out.println("-----------------------------------------------------");	
		System.out.println("End of Personal Infomation.\n");
	}
	
}