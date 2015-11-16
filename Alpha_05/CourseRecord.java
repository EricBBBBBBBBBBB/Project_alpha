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
	public int totalNumOfTrainee;
	public int maxNumOfTrainee;
    protected int[] traineelist = new int[maxNumOfTrainee];
		
// Constructors
	CourseRecord(){
		
	}
	
	CourseRecord(int cid){
		courseID = cid;
	}
	
// Methods
	public void setInfo(int tid, boolean com, int max) {
		courseTrainerID = tid;
		Completed = com;
		maxNumOfTrainee = max;
	}
	
	public void setTrainee(int[] list) {
		traineelist = list;
		totalNumOfTrainee = traineelist.length;
	}
	
	public void printRecoedInfo(){
		System.out.println("-----------------------------------------------------");	
		System.out.println("					XXX				");
		System.out.println("-----------------------------------------------------");	
		System.out.println("courseID: \t  " + courseID );
		System.out.println("courseTrainerID:  " + courseTrainerID);
		System.out.println("Completed: \t  " + Completed);
		System.out.println("Trainee: \t  " + totalNumOfTrainee + "/" + maxNumOfTrainee);
		System.out.println("-----------------------------------------------------");	
		for(int i = 0; i < traineelist.length ; i++ ){
			System.out.println(traineelist[i]);
		}
		System.out.println("-----------------------------------------------------");	
		System.out.println("End of XXX.\n");
		
	}
	
	public boolean checkid(int uid){
		for(int i = 0; i < traineelist.length ; i++ ){
			if(traineelist[i] == uid) return true;
		}
		return false;
	}
	
	
}
