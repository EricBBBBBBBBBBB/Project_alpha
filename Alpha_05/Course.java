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

	private String courseTrainerName;	
	private int duration;	// add Date & Time later
	private String venue;
	private int price;	
	private String target;
	private String description;

	public int totalNumOfTrainee = 0;
	public int maxNumOfTrainee = 15;
	protected boolean isAvailable = true;
	
	
	public ArrayList<Integer> TraineeList = new ArrayList<Integer>(); 
	public ArrayList<Integer> CompletedTraineeList = new ArrayList<Integer>();
	
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
		String statusStr;
		if(isAvailable) statusStr = "Available";
		else statusStr = "NOT Available";
		return statusStr;
	}
	
	public String getTrainerName() {
		return courseTrainerName;
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
		System.out.println("Course Trainer: \t" + courseTrainerName);
        System.out.println("Price: \t\t\t" + price);
        System.out.println("Duration: \t" + "months");
        System.out.println("Venue: \t" + venue);
		
        System.out.println("Trainee Requirements: \t" + courseType);
        System.out.println("Number of Trainee: \t" + totalNumOfTrainee + "/" + maxNumOfTrainee);
		System.out.println("Description: \t\t" + description);
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
			
		}
		System.out.println("-----------------------------------------------------");	
	}
	
	//Join Course
	public void joinCourse(int uid){
		if(maxNumOfTrainee == totalNumOfTrainee){
			System.out.println(">>>This Course was full. \n");
		}else{
			totalNumOfTrainee++;
			TraineeList.add(uid);
			System.out.println(">>>Joined. \n");
		}
	}
	
}
