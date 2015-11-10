/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* 
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Trainer extends User{

// Declare data members //////////////////////////
	public static int totalNoOfTrainer = 0;  // class data member

// Constructors //////////////////////////
	Trainer(String name) {
		super(name, 1);	//call superclass constructor
	}
	
	Trainer(String name, String pw) {
		super(name, pw, 1);	//call superclass constructor
	}

// Methods //////////////////////////
	// Print Trainer information
	public void printUserInfo() {
		System.out.println("---------------------------------------------------------");
		System.out.println("                   " + getUserType() + " Information ");
		System.out.println("----------------------------------------------------------");
		System.out.println("User ID: " + getUserID());
		System.out.println("User Name: " + getUserName());
		System.out.println("User Email: " + getUserEmail());
		System.out.println("User Phone: " + getUserPhone());
		System.out.println("Owned Courses: ");
		System.out.println("----------------------------------------------------------\n");
		System.out.println("End of Personal Infomation.\n");
	}
	
	
}