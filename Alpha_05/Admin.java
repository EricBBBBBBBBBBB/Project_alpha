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

class Admin extends User{

// Declare data members //////////////////////////
	public static int totalNoOfAdmin = 0;  // class data member

// Constructors //////////////////////////
	Admin(String name) {
		super(name, 2);	//call superclass constructor
	}
	
	Admin(String name, String pw) {
		super(name, pw, 2);	//call superclass constructor
	}

// Methods //////////////////////////
	// Print Admin information
	public void printUserInfo() {
		System.out.println("---------------------------------------------------------");
		System.out.println("                   " + getUserType() + " Information ");
		System.out.println("----------------------------------------------------------");
		System.out.println("User ID: " + getUserID());
		System.out.println("User Name: " + getUserName());
		System.out.println("User Email: " + getUserEmail());
		System.out.println("User Phone: " + getUserPhone());
		System.out.println("----------------------------------------------------------\n");
		System.out.println("End of Personal Infomation.\n");
	}

	
}