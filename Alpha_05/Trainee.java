/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Trainee.java: 
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Trainee extends User{

// Declare data members 
	public static int totalNoOfTrainee = 0;  // class data member
	protected int traineeType;
	
	
// Constructors 
	Trainee(int uid, String name, String pw) {
		super(uid, name, pw, 0);	//call superclass constructor
	}

// Methods 
	//Trainee type updating
	public int upadteTraineeType() {	
		//int total = 0;
		//if( total > 10 ) traineeType = 4;
		//	else if( total > 5 ) traineeType = 5;
		return traineeType;
	}
	
	//Set the User information
	public void setTraineeInfo(String mail,String tel, int type) {
		super.setUserInfo(mail,tel);
		traineeType = type;
	}
	
	//Get the User information
	public String getTraineeType() {	
		upadteTraineeType();
		if(traineeType == 3 ) return "Beginner" ;
		if(traineeType == 4 ) return "Advanced" ;
		if(traineeType == 5 ) return "Intermediate" ;
		return "Unknown" ;
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
