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

class CourseRecord{

// Declare data members
	public static int totalNoOfCourses = 0;
	
	protected int courseID;
	protected int courseTrainerID;
	protected boolean Completed;
	public int maxNumOfTrainee;
    protected ArrayList<Integer> traineelist = new ArrayList<Integer>();
		
// Constructors
	CourseRecord(int cid){
		courseID = cid;
		Completed = Curriculum.checkCompleted(courseID);
	}
	
// Methods
	public void setInfo(int tid, int max) {
		courseTrainerID = tid;
		maxNumOfTrainee = max;
	}
	
	public void setTrainee(ArrayList<Integer> list) {
		traineelist = list;
	}
	
	public int getTotalOfTrainee(){
		return traineelist.size();
	}

	public int getMaxOfTrainee(){
		return maxNumOfTrainee;
	}
	
	public void addTrainee(int uid) {
		traineelist.add(uid);
	}
	
	public void printRecoedInfo(){
		System.out.println("-----------------------------------------------------");	
		System.out.println("					XXX				");
		System.out.println("-----------------------------------------------------");	
		System.out.println("courseID: \t  " + courseID );
		System.out.println("courseTrainerID:  " + courseTrainerID);
		System.out.println("Completed: \t  " + Completed);
		System.out.println("Trainee: \t  " + traineelist.size()+ "/" + maxNumOfTrainee);
		System.out.println("-----------------------------------------------------");	
		for(int i = 0; i < traineelist.size() ; i++ ){
			System.out.println(traineelist.get(i));
		}
		System.out.println("-----------------------------------------------------");	
		System.out.println("End of XXX.\n");
		
	}
	
	public boolean checkid(int uid){
		for(int i = 0; i < traineelist.size() ; i++ ){
			if(traineelist.get(i) == uid) return true;
		}
		return false;
	}
	
	
}
