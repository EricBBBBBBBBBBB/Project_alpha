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
	protected boolean completed;

	protected int courseTrainerID;	
	protected int duration;	// add Date & Time later
	protected String venue;
	protected int price;	
	protected String target;
	protected String description;

    protected ArrayList<Integer> traineelist = new ArrayList<Integer>();
	public int totalNumOfTrainee;
	public int maxNumOfTrainee;
	protected boolean isAvailable = true;
		
// Constructors
	Course() {
		totalNoOfCourses++;
		getTotalOfTrainee();
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
	
	//trainee use
	public String getCourseStatus() {
		if(totalNumOfTrainee == maxNumOfTrainee || completed ) 
			isAvailable = false;
		
		String statusStr;
		if(!completed){
			if(isAvailable) statusStr = "Available";
				else statusStr = "NOT Available";
		}else{
			statusStr = "completed";
		}
		return statusStr;
	}
	
	//trainer use
	public String getStatus() {
		String statusStr;
		if(!completed) statusStr = "Current";
			else statusStr = "Completed";
				
		return statusStr;
	}
	
	
	public int getTrainerID() {
		return courseTrainerID;
	}
	
	public String getTarget() {
		return target;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getTotalOfTrainee(){
		totalNumOfTrainee = traineelist.size();	
		return totalNumOfTrainee;
	}
	
	public int getMaxOfTrainee(){
		return maxNumOfTrainee;
	}
	
	//set the Course information
	public void setCourseInfo(boolean status, int uid, int time, String place, int cost, String t , String d, int max ) {
		completed = status;
		courseTrainerID = uid;
		duration = time;
		venue = place;
		price = cost;
		target = t;
		description = d;
		maxNumOfTrainee = max;
		
	}
	
	public void setTrainee(ArrayList<Integer> list) {
		traineelist = list;
	}
	

	
	// Print the Course information
	public void printCourseInfo() {
		System.out.println("-----------------------------------------------------");
		System.out.println("          Course Information (" + getCourseStatus() + ")");    		 
		System.out.println("-----------------------------------------------------");
		System.out.format("- Course ID     :  %d\n", getCourseID());
		System.out.format("- Course Name   :  %s\n", getCourseName());
		System.out.format("- Course Trainer:  %d\n", courseTrainerID);
        System.out.format("- Requirements  :  %s\n", getCourseType());
		System.out.println("-----------------------------------------------------");
        System.out.format("- Price         :  $%d\n", getPrice());
        System.out.format("- Duration      :  %s weeks\n", duration);
        System.out.format("- Venue         :  %s\n", venue);
        System.out.format("- No. of Trainee:  %d/%d\n", totalNumOfTrainee, maxNumOfTrainee);
		System.out.format("- Description   :  %s\n", description.replaceAll("(.{1,35})\\s+", "$1\n\t\t   "));
		System.out.println("-----------------------------------------------------\n");	
	}
	
	public void printCourseTrainee(){
		System.out.println("-----------------------------------------------------");	
		System.out.println("          Course Information (" + getCourseStatus() + ")");    		 
		System.out.println("-----------------------------------------------------");
		System.out.format("- Course ID     :  %d\n", getCourseID());
		System.out.format("- Course Name   :  %s\n", getCourseName());
        System.out.format("- Requirements  :  %s\n", getCourseType());
		System.out.format("- No. of Trainee:  %d/%d\n", totalNumOfTrainee, maxNumOfTrainee);
		System.out.println("-----------------------------------------------------");
		System.out.println("- ID   User Name           User Type");
		System.out.println("-----------------------------------------------------");
		for(int i = 0; i < traineelist.size() ; i++ ){
			System.out.format( "- %-5d%-20s\n" , Account.userlist.get(traineelist.get(i)).getUserID(), Account.userlist.get(traineelist.get(i)).getUserName());
		}
		System.out.println("-----------------------------------------------------");	
		System.out.println("End of XXX.\n");
		
	}
	
	public void addTrainee(int uid) {
		traineelist.add(uid);
	}
	
	public boolean checkid(int uid){
		for(int i = 0; i < traineelist.size() ; i++ ){
			if(traineelist.get(i) == uid) return true;
		}
		return false;
	}
	
}
