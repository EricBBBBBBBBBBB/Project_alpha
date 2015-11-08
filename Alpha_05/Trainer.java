/********************************************
* Student: FUNG K.K. Eric (10614373), HDIT
* Couse: OOP 2015 Sem 1
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
	// XXXXXXXX
	public void listCourse(){
		System.out.println(" List\n");
	}
	
	public void displayRecords(){
		System.out.println(" Display records\n");
	}
	
	public void gradePerformance(){
		System.out.println(" Grade performance\n");
	}

	
	
}