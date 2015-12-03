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
    protected ArrayList<String> gradelist = new ArrayList<String>();
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
		setCourseName(cname);
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
		if(courseType == 4 ) return "Intermediate" ;
		if(courseType == 5 ) return "Advanced" ;
		return "Unknown" ;
	}
	
	//trainee use
	public String getCourseStatus() {
		if(totalNumOfTrainee == maxNumOfTrainee || completed ) 
			isAvailable = false;
		
		String statusStr;
		if(!completed){
			if(isAvailable) statusStr = "Available";
				else statusStr = "FULL";
		}else{
			statusStr = "Completed";
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
	
	public String getVenue() {
		return venue;
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
	
	public ArrayList<Integer> getTrainees(){
		return traineelist;
	}
		
	public ArrayList<String> getGrades(){
		return gradelist;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	//set the Course information
	public void setCourseInfo(boolean status, int uid, int time, String place, int cost, String tar , String des, int max ) {
		completed = status;
		setCourseTrainerID(uid);
		duration = time;
		venue = place;
		price = cost;
		setTarget(tar);
		setDescription(des);
		maxNumOfTrainee = max;
		
	}
	
	public void setCourseName(String cname) {
		courseName = cname;	
	}	
	
	public void setCourseTrainerID(int uid) {
		courseTrainerID = uid;	
	}	
	
	public void setTrainee(ArrayList<Integer> tlist, ArrayList<String> glist) {
		traineelist = tlist;
		gradelist = glist;
	}
	
	public void setDescription(String des) {
		description = des;
	}

	public void setTarget(String tar) {
		target =  tar;
	}
	
	// Print the Course information
	public void printCourseInfo() {

		String output = 
			"---------------------------------------------------------------------------\n" +
			"-                                Course Information (" + getCourseStatus() + ")                               -\n" +
			"---------------------------------------------------------------------------\n" +
			"Course ID     :  " + getCourseID() + "\n" +
			"Course Name   :  " + getCourseName() + "\n" +
			"Course Trainer:   " + Account.userlist.get(Account.searchuserlistID(courseTrainerID)).getUserName() + "\n" +
			"Requirements  :  " + getCourseType() + "\n" +
			"---------------------------------------------------------------------------\n" +
			"Price         :  " + getPrice() + "\n" +
		    "Duration      :  " + duration + " weeks\n" +
			"Venue         :  " + venue + "\n" +
			"No. of Trainee:  " + totalNumOfTrainee + "/" + maxNumOfTrainee + "\n" +
			"Description   :  " + description + "\n" +
			"---------------------------------------------------------------------------\n" +
			"End of Personal Infomation.\n";
		OutPutStream.write(output);
	}
	
	public void printCourseTrainee(){
		 
		String tlist = "";
		int tid;
		for(int i = 0; i < traineelist.size() ; i++ ){
			tid = Account.searchuserlistID(traineelist.get(i));
			tlist = tlist + String.format("- %-20d%-30s%-30s\n", Account.userlist.get(tid).getUserID(), Account.userlist.get(tid).getUserName(),((Trainee)Account.userlist.get(tid)).getTraineeType());
		}

		String output = 
			"---------------------------------------------------------------------------\n" +
			"-                                Course Information (" + getCourseStatus() + ")                               -\n" +
			"---------------------------------------------------------------------------\n" +
			"Course ID     :  " + getCourseID() + "\n" +
			"Course Name   :  " + getCourseName() + "\n" +
			"Requirements  :  " + getCourseType() + "\n" +
			"No. of Trainee:  " + totalNumOfTrainee + "/" + maxNumOfTrainee + "\n" +
			"---------------------------------------------------------------------------\n" +
			"- ID                  User Name           User Type\n" +
			"---------------------------------------------------------------------------\n" +
			tlist +
			"---------------------------------------------------------------------------\n" +
			"End of Personal Infomation.\n";
		OutPutStream.write(output);		
	}
	
	public void addTrainee(int uid) {
		traineelist.add(uid);
		gradelist.add(" ");
	}
	
	public boolean checkid(int uid){
		for(int i = 0; i < traineelist.size() ; i++ ){
			if(traineelist.get(i) == uid) return true;
		}
		return false;
	}
	
}
