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

class Trainee extends User{

// Declare data members 
	public static int totalNoOfTrainee = 0;  // class data member
	
	private String traineeType = "beginner";
	
	
// Constructors 
	Trainee(String name) {
		super(name, 0);	//call superclass constructor
	}
	
	Trainee(String name, String pw) {
		super(name, pw, 0);	//call superclass constructor
	}

// Methods 
	//Trainee type updating
	public String getTraineeType() {	
		int total = Curriculum.totalOfCompleted(getUserID());
		if( total > 10 ) traineeType = "advanced";
			else if( total > 5 ) traineeType = "intermediate";
		return traineeType;
	}
	
	// Print Trainee information
	public void printUserInfo() {
		System.out.println("-----------------------------------------------------");	
		System.out.println("-   \t\t" + getUserType() + " Information\t\t   -");
		System.out.println("-----------------------------------------------------");	
		System.out.println("User ID: \t  " + getUserID());
		System.out.println("User Name: \t  " + getUserName());
		System.out.println("Trainee Type: \t  " + getTraineeType());
		System.out.println("User Email: \t  " + getUserEmail());
		System.out.println("User Phone: \t  " + getUserPhone());
		System.out.println("Date of register: " + dateOfRegister.getTime());
		System.out.println("-----------------------------------------------------");
		System.out.println("Completed Courses: ");
		System.out.println("Current Courses: ");
		System.out.println("-----------------------------------------------------");	
		System.out.println("End of Personal Infomation.\n");
	}
	
}
