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
	public static int totalNoOfCourses = 0;
	
	protected int courseID;
	protected String courseName;
	protected int courseType;
	protected boolean Completed;

	protected String courseTrainerName;	
	protected int duration;	// add Date & Time later
	protected String venue;
	protected int price;	
	protected String target;
	protected String description;

	public int totalNumOfTrainee;
	public int maxNumOfTrainee;
	protected boolean isAvailable = true;
		
// Constructors
	Course() {
		totalNoOfCourses++;
	}

	Course(int cid, String cname, int type) {
		this();
		courseID = cid;
		courseName = cname;
		courseType = type;
	}
	
// Methods
	//Get the Course information
	public int getCourseID() {
		return courseID;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public String getCourseType() {	
		if(courseType == 3 ) return "Beginner" ;
		if(courseType == 4 ) return "Advanced" ;
		if(courseType == 5 ) return "Intermediate" ;
		return "Unknown" ;
	}
	
	public String getCourseStatus() {
		if(totalNumOfTrainee == maxNumOfTrainee || Completed ) 
			isAvailable = false;
		
		String statusStr;
		if(!Completed){
			if(isAvailable) statusStr = "Available";
				else statusStr = "NOT Available";
		}else{
			statusStr = "Completed";
		}
		return statusStr;
	}
	
	public String getTrainerName() {
		return courseTrainerName;
	}
	
	public String getTarget() {
		return target;
	}
	
	//set the Course information
	public void setCourseInfo(boolean status, String tname, int time, String place, int cost, String t , String d, int max ) {
		Completed = status;
		courseTrainerName = tname;
		duration = time;
		venue = place;
		price = cost;
		target = t;
		description = d;
		maxNumOfTrainee = max;
		
	}
	
	// Print the Course information
	public void printCourseInfo() {
		System.out.println("-----------------------------------------------------");
		System.out.println("           Information (" + getCourseStatus() + "\t)");    		 
		System.out.println("-----------------------------------------------------");
		System.out.println("Course ID: \t\t\t" + courseID);
		System.out.println("Course Name: \t\t" + courseName);
		System.out.println("Course Trainer: \t" + courseTrainerName);
        System.out.println("Price: \t\t\t" + price);
        System.out.println("Duration: \t" + "months");
        System.out.println("Venue: \t" + venue);
		
        System.out.println("Trainee Requirements: \t" + courseType);
        System.out.println("Number of Trainee: \t" + totalNumOfTrainee + "/" + maxNumOfTrainee);
		System.out.println("Description: \t\t" + description);
		System.out.println("-----------------------------------------------------");	
	}
	
	
}
