/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Course.java: 
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Course{

// Declare data members
	protected int courseID;
	protected String courseName;
	protected boolean isAvailable = true;
	
	private int duration;
	private String place;
	private int price;	
	// add Date & Time later
	private String description;
	private String target;
	
	private int courseTrainerID;
	
	public int totalNumOfTrainee = 0;
	public int maxNumOfTrainee;
	
	public ArrayList<Trainee> TraineeList = new ArrayList<Trainee>(); 
	public ArrayList<Trainee> CompletedTraineeList = new ArrayList<Trainee>();
	
	public static int totalNoOfCourses = 0;
	
// Constructors
	Course() {
		totalNoOfCourses++;
	}

	Course(String cname) {
		this();
		courseID = totalNoOfCourses;
		courseName = cname;
	}
	
// Methods
	//Get the Course information
	public int getCourseID() {
		return courseID;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public String getCourseStatus() {
		String statusStr;
		if(isAvailable) statusStr = "Available";
		else statusStr = "NOT Available";
		return statusStr;
	}
	
	public int getTrainerID() {
		return courseTrainerID;
	}
	public String getTarget() {
		return target;
	}
	
	// Print the Course information
	public void printCourseInfo() {
		System.out.println("-----------------------------------------------------");
		System.out.println("           Information (" + getCourseStatus() + "\t)");    		 
		System.out.println("-----------------------------------------------------");
		System.out.println("Course ID: \t\t\t" + courseID);
		System.out.println("Course Name: \t\t" + courseName);
		System.out.println("Course Trainer ID: \t" + courseTrainerID);
        System.out.println("Price: \t\t\t" + price);
        System.out.println("Duration: \t" + "months");
        System.out.println("Description: \t\t" + description);
		System.out.println("Number of Trainee: \t" + totalNumOfTrainee + "/" + maxNumOfTrainee);
		System.out.println("-----------------------------------------------------");	
	}
	
	// Print the Course Trainee List
	public void printTraineeList() {    		 
		System.out.println("-----------------------------------------------------");
		System.out.println("- Trainee List\t\t\t    -");
		System.out.println("-----------------------------------------------------");
		System.out.println("UserID\tUserName");
		System.out.println("-----------------------------------------------------");		
		for (int i = 0; i < TraineeList.size(); i++) {
			System.out.println(	TraineeList.get(i).getUserID() + "\t" + TraineeList.get(i).getUserName());
		}
		System.out.println("-----------------------------------------------------");	
	}
	
	//Join Course
	public void joinCourse(Trainee user){
		totalNumOfTrainee++;
		TraineeList.add(user);
	}
	
}
