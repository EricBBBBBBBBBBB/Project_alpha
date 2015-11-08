/********************************************
* Student: FUNG K.K. Eric (10614373), HDIT
* Couse: OOP 2015 Sem 1
*
* 
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Trainee extends User{

// Declare data members //////////////////////////
	public static int totalNoOfTrainee = 0;  // class data member

// Constructors //////////////////////////
	Trainee(String name) {
		super(name, 0);	//call superclass constructor
	}
	
	Trainee(String name, String pw) {
		super(name, pw, 0);	//call superclass constructor
	}

// Methods //////////////////////////
	// XXXXXXXX
	public void register(){
		System.out.println(" Self-Register\n");
	}
	
	public void browseCourse(){
		System.out.println(" Browse Course\n");
	}
	
	public void joinCourse(){
		System.out.println(" Join Course\n");
	}
	
	public void displayCourse(){
		
	}
	
	
}