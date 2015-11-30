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
import java.text.SimpleDateFormat;

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
		//if( totalcompletedCourse > 10 ) traineeType = 4;
		//	else if( totalcompletedCourse > 5 ) traineeType = 5;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		String output = 
			"---------------------------------------------------------------------------\n" +
			"-                               Trainee Information                               -\n" +
			"---------------------------------------------------------------------------\n" +
			"User ID: \t  " + getUserID() + "\n" +
			"User Name: \t  " + getUserName() + "\n" +
			"Trainee Type: \t  " + getTraineeType() + "\n" +
			"User Email: \t  " + getUserEmail() + "\n" +
			"User Phone: \t  " + getUserPhone() + "\n" +
			"Date of register:  " + sdf.format(dateOfRegister) + "\n" + 
			"Date of Birth: \t  " + dateOfBirth + "\n" + 
			"---------------------------------------------------------------------------\n" +
			"Completed Courses:" + Curriculum.checkNoOfcompleted(getUserID()) + "\n" + 
			"Current Courses:  " + Curriculum.checkNoOfCurrent(getUserID()) + "\n" + 
			"---------------------------------------------------------------------------\n" +
			"End of Personal Infomation.\n";
		test.write(output);
	}
	
}
