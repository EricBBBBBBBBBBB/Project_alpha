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

// Declare data members //////////////////////////
	protected int courseID;
	protected String courseName;
	protected boolean isAvailable = true;
	
	private int duration;
	private String place;
	private int courseTrainerID;
	private int price;	
	// add Date & Time later
	private String description;
	private String target;
	
	public static int totalNoOfCourses = 0;
	public int totalNumOfTrainee = 0;
	public int maxNumOfTrainee;
	
	public static ArrayList<Trainee> TraineeList = new ArrayList<Trainee>(); 
	
// Constructors //////////////////////////
	Course() {
		totalNoOfCourses++;
	}

	Course(String cname) {
		this();
		courseID = totalNoOfCourses;
		courseName = cname;
	}
	
// Methods //////////////////////////
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
	
	public String getTarget() {
		return target;
	}
	
	// Print the Course information
	public void printCourseInfo() {
		
		System.out.println("----------------------------------------------------------");
		System.out.println("                   		 Information (" + getCourseStatus() + ")");
		System.out.println("----------------------------------------------------------");
		System.out.println("Course ID: \t\t\t" + courseID);
		System.out.println("Course Name: \t\t" + courseName);
		System.out.println("Course Trainer ID: \t" + courseTrainerID);
        System.out.println("Price: \t\t\t" + price);
        System.out.println("Duration: \t" + "months");
        System.out.println("Description: \t\t" + description);
		System.out.println("Number of Trainee: \t" + totalNumOfTrainee + "/" + maxNumOfTrainee);
		System.out.println("----------------------------------------------------------");
	}
	
	//Join Course
	public void joinCourse(Trainee user){
		totalNumOfTrainee++;
		TraineeList.add(user);
	}
	
}
