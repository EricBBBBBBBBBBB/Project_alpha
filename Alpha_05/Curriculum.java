/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Curriculum > Course
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Curriculum implements Files{

// Declare data members

    public static ArrayList<Course> courselist = new ArrayList<Course>(); 

//Methods
	//Initialization Course List
    public static void initcourselist() {       
		courselist = CourseIO.readCTxtFile(DEF_COURSE);
    }
	
	
	
	//Update Course List
    public static boolean updatecourselist(Course course) {
        if(courselist.add(course))
            return true;
        else
            return false;
    }
	
	//Get Course List
    public static ArrayList<Course> getcourselist() {
        return courselist;
    }
	
	//Remove Course by ID
    public static boolean removeCourse(int cid) {
		for (int i = 0; i < courselist.size(); i++) {
            if (courselist.get(i).getCourseID() == cid) {
                courselist.remove(i);
                return true;
            }
        }
        return false;
    }
	
	//Remove Course by Name
    public static boolean removeCourse(String cname) {
        for (int i = 0; i < courselist.size(); i++) {
            if (courselist.get(i).getCourseName().equals(cname)) {
                courselist.remove(i);
                return true;
            }
        }
        return false;
    }

	//List all Course records
	public static void listAll(){
		
		System.out.println("-----------------------------------------------------");
		System.out.println("- ID   Course Name          Status         Price($)");
		System.out.println("-----------------------------------------------------");	
		boolean not = true;		
		for (int i = 0; i < courselist.size(); i++) {
			System.out.format( "- %-5d%-20s%-15s%d\n" , courselist.get(i).getCourseID(), courselist.get(i).getCourseName(), courselist.get(i).getCourseStatus(), courselist.get(i).getPrice() );
			not = false;
		}
		if(not)System.out.println("- Not for now.");		
		System.out.println("-----------------------------------------------------");

	}
	
	//List Trainer Owned Courses
	public static void listOwnedCourse(int uid){
		System.out.println("------------------- Owned Courses -------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(" ID   Course Name          Total Number of Trainee");
		System.out.println("-----------------------------------------------------");	
		boolean not = true;
		for (int i = 0; i < courselist.size(); i++) {
				if(courselist.get(i).getTrainerID() == uid){ 
					System.out.format( "- %-5d%-20s%-15d\n" , courselist.get(i).getCourseID(), courselist.get(i).getCourseName(), courselist.get(i).getTotalOfTrainee());
					not = false;
			}
		}
		if(not)System.out.println("- Not for now.");		
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Please enter the Course ID to show more details.");
        System.out.print("(-1) for quit. : ");

        Scanner scanner = new Scanner(System.in);
		int inInt;
        if(scanner.hasNextInt())
            inInt = scanner.nextInt();
        else
            inInt = -1;

        if(inInt == -1){
            System.out.println(">> quit.");
			return;
        }
		
		boolean found = false;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).courseID == inInt ){
				courselist.get(i).printCourseTrainee();
				found = true;
			} 
		}
		if(!found) System.out.println(">> Course not found!!\n");
	}

	//List Avaible Courses
	public static void listAvaible(int type,int uid){
		System.out.println("-----------------------------------------------------");
		System.out.println("- ID   Course Name         Course Type    Price($)");
		System.out.println("-----------------------------------------------------");	
		boolean not = true;
		for (int i = 0; i < courselist.size(); i++) {
			if(!(courselist.get(i).Completed) && courselist.get(i).courseType <= type && !(courselist.get(i).checkid(uid))){
				System.out.format( "- %-5d%-20s%-15s%d\n" , courselist.get(i).getCourseID(), courselist.get(i).getCourseName(), courselist.get(i).getCourseType(), courselist.get(i).getPrice() );
				not = false;
			}
		}
		if(not)System.out.println("- Not for now.");
		System.out.println("-----------------------------------------------------");
	}
	
	//List Avabile Courses Details
	public static void listAvaibleCourse(int type,int uid){
		
		listAvaible(type, uid);
		System.out.println("Please enter the Course ID to show more details.");
        System.out.print("(-1) for quit. : ");

        Scanner scanner = new Scanner(System.in);
		int inInt;
        if(scanner.hasNextInt())
            inInt = scanner.nextInt();
        else
            inInt = -1;

        if(inInt == -1){
            System.out.println(">> quit.");
			return;
        }
		
		boolean found = false;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).courseID == inInt && !(courselist.get(i).Completed) && courselist.get(i).courseType <= type ){
				courselist.get(i).printCourseInfo();
				found = true;
			} 
		}
		if(!found) System.out.println(">> Course not found!!\n");
	
	}
	
	//List Courses Targets
	public static void listTarget(int uid){
		System.out.println("-----------------------------------------------------");
		System.out.println(" ID   Course Name          Targets");
		System.out.println("-----------------------------------------------------");
		boolean not = true;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid) && !(courselist.get(i).Completed)){
				System.out.format( "- %-5d%-20s%-15s\n" , courselist.get(i).getCourseID(), courselist.get(i).getCourseName(), courselist.get(i).getTarget());
				not = false;		
			}
		}
		if(not)System.out.println("- Not for now.");		
		System.out.println("-----------------------------------------------------");
	}
	
	//List CCCourses
	public static void listCCCourse(int uid){
		System.out.println("-----------------------------------------------------");
		System.out.println(" ID   Course Name          Completed");
		System.out.println("-----------------------------------------------------");
		boolean not = true;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid)){
				System.out.format( "- %-5d%-20s%-15s\n" , courselist.get(i).getCourseID(), courselist.get(i).getCourseName(), courselist.get(i).Completed);
				not = false;		
			}
		}
		if(not)System.out.println("- Not for now.");		
		System.out.println("-----------------------------------------------------");	
	}	
	
	//Join Courses
	public static void joinCourse(int type,int uid){
		
		listAvaible(type, uid);
		System.out.println("Please enter the Course ID to join.");
        System.out.print("(-1) for quit. : ");

        Scanner scanner = new Scanner(System.in);
		int inInt;
        if(scanner.hasNextInt())
            inInt = scanner.nextInt();
        else
            inInt = -1;

        if(inInt == -1){
            System.out.println(">> quit.");
			return;
        }
		
		boolean found = false;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).courseID == inInt && !(courselist.get(i).Completed)) {
				courselist.get(i).addTrainee(uid) ;
				System.out.println(">> Course joined.\n");	
				found = true;
			}
		}
		if(!found) System.out.println(">> Course not found!!\n");		
	}
	
	
	//Check total of Completed Courses
	public static int checkNoOfCompleted(int uid){
		int total = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid) && courselist.get(i).Completed) total++;
		}
		return total;
	}
	
	//Check total of Current Courses
	public static int checkNoOfCurrent(int uid){
		int total = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid) && !(courselist.get(i).Completed)) total++;
		}
		return total;
	}
	
	//Check Completed or Not by CourseID 
    public static boolean checkCompleted(int uid) {
        for (int i = 0; i < courselist.size(); i++) {
            if (courselist.get(i).getCourseID() == uid)
                return courselist.get(i).Completed;
        }
        return false;
    }
	
	//Courses Performance
	public static void Performance(){
		System.out.println(" Grade performance\n");
		//Current trainee
		//Completed trainee
	}
	
	//Create Courses
	public static void AddCourse(){
			System.out.println(" Create Courses \n");
	}

	//Delete Courses
	public static void DelCourse(){
		System.out.println(" Delete Courses \n");
	}
}
