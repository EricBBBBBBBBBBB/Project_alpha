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

// Declare data members //////////////////////////
	public static int totalNoOfTrainee = 0;  // class data member
	
	public ArrayList<Course> CurrentCourseList = new ArrayList<Course>(); 
	public ArrayList<Course> CompletedCourseList = new ArrayList<Course>(); 
	
// Constructors //////////////////////////
	Trainee(String name) {
		super(name, 0);	//call superclass constructor
	}
	
	Trainee(String name, String pw) {
		super(name, pw, 0);	//call superclass constructor
	}

// Methods //////////////////////////
	//Diplay User Current Courses & Completed Courses
	public void displayCourse(){
		
	}
	
	// Print Trainee information
	public void printUserInfo() {
		System.out.println("---------------------------------------------------------");
		System.out.println("                   " + getUserType() + " Information ");
		System.out.println("----------------------------------------------------------");
		System.out.println("User ID: " + getUserID());
		System.out.println("User Name: " + getUserName());
		System.out.println("User Email: " + getUserEmail());
		System.out.println("User Phone: " + getUserPhone());
		System.out.println("Completed Courses: ");
		System.out.println("Current Courses: ");
		System.out.println("----------------------------------------------------------\n");
		System.out.println("End of Personal Infomation.\n");
	}
}
