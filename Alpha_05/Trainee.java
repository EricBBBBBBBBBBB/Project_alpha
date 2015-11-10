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
	
	public ArrayList<Course> CurrentCourseList = new ArrayList<Course>(); 
	public ArrayList<Course> CompletedCourseList = new ArrayList<Course>(); 
	
// Constructors 
	Trainee(String name) {
		super(name, 0);	//call superclass constructor
	}
	
	Trainee(String name, String pw) {
		super(name, pw, 0);	//call superclass constructor
	}

// Methods 
	
}
