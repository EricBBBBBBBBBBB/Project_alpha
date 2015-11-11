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

class Curriculum{

// Declare data members (To save the Course Infomation without FileIOSystem)
    public static ArrayList<Course> CourseList = new ArrayList<Course>(); 
	
	
// Methods
	//Initialization Course List
    public static void initCourseList() {       
        CourseList.add(new Course("Courses1"));
        CourseList.add(new Course("Courses2"));
        CourseList.add(new Course("Courses3"));
        CourseList.add(new Course("Courses4"));
    }
	
	//Update Course List
    public static boolean updateCourseList(Course course) {
        if(CourseList.add(course))
            return true;
        else
            return false;
    }
	
	//Get Course List
    public static ArrayList<Course> getCourseList() {
        return CourseList;
    }

	//Remove Course by ID
    public static boolean removeCourse(int cid) {
		for (int i = 0; i < CourseList.size(); i++) {
            if (CourseList.get(i).getCourseID() == cid) {
                CourseList.remove(i);
                return true;
            }
        }
        return false;
    }
	
	//Remove Course by Name
    public static boolean removeCourse(String cname) {
        for (int i = 0; i < CourseList.size(); i++) {
            if (CourseList.get(i).getCourseName().equals(cname)) {
                CourseList.remove(i);
                return true;
            }
        }
        return false;
    }
	
	//List all Course records
	public static void listAll(){
		
		System.out.println("-------------------------------------------");
		System.out.println("ID\tCourse Name\tStatus");
		System.out.println("-------------------------------------------");
		
		for (int i = 0; i < CourseList.size(); i++) {
			System.out.println(	CourseList.get(i).getCourseID() + "\t" + CourseList.get(i).getCourseName()+ "\t" + CourseList.get(i).getCourseStatus());
		}
		System.out.println("------------------------------------------\n");

	}
	
	//Diplay User Current Courses & Completed Courses
	public static void printCourse(int uid){
		Curriculum.printCurrentCourse(uid);
		Curriculum.printCompletedCourse(uid);
	}
				
	public static void printCurrentCourse(int uid){
		System.out.println("-----------------------------------------------------");
		System.out.println("---------------------- Courses ----------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("ID\tCourse Name\t\tStatus");
		System.out.println("-----------------------------------------------------");
		for (int i = 0; i < CourseList.size(); i++) {
			for (int j = 0; j < CourseList.get(i).TraineeList.size(); j++) {
				if(CourseList.get(i).TraineeList.get(j) == uid ) 
					System.out.println(CourseList.get(i).getCourseID() + "\t" + CourseList.get(i).getCourseName() + "\t\t(Current)");
			}
		}
	}
	
	public static void printCompletedCourse(int uid){
		for (int i = 0; i < CourseList.size(); i++) {
			for (int j = 0; j < CourseList.get(i).CompletedTraineeList.size(); j++) {
				if(CourseList.get(i).CompletedTraineeList.get(j) == uid) 
					System.out.println("- " + CourseList.get(i).getCourseID() + "\t\t" + CourseList.get(i).getCourseName() + "\t\t(Completed)");
			}
		}
		System.out.println("-----------------------------------------------------\n");
	}
	
	//Count Current Courses & Completed Courses	
	public static int totalOfCurrent(int uid){
		int total = 0;
		for (int i = 0; i < CourseList.size(); i++) {
			for (int j = 0; j < CourseList.get(i).TraineeList.size(); j++) {
				if(CourseList.get(i).TraineeList.get(j) == uid) total++;
			}
		}
		return total;
	}

	public static int totalOfCompleted(int uid){
		int total = 0;
		for (int i = 0; i < CourseList.size(); i++) {
			for (int j = 0; j < CourseList.get(i).CompletedTraineeList.size(); j++) {
				if(CourseList.get(i).CompletedTraineeList.get(j) == uid) total++;
			}
		}
		return total;
	}
	
	//Diplay User Owned Courses
	public static void printOwnedCourse(int uid){
		System.out.println("------------------- Owned Courses -------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("ID\tCourse Name");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < CourseList.size(); i++) {
				if(CourseList.get(i).getTrainerID() == uid ) 
					System.out.println("- " + CourseList.get(i).getCourseID() + "\t" + CourseList.get(i).getCourseName());
		}
		System.out.println("------------------------------------------\n");
	}
	
	//Courses Performance
	public static void Performance(){
		System.out.println(" Grade performance\n");
	}
	
	//Create Courses
	public static void AddCourse(){
			System.out.println(" Create Courses \n");
	}

	//Delete Courses
	public static void DelCourse(){
		System.out.println(" Delete Courses \n");
	}
	
	//Join Course
	public static boolean JoinCourse(int uid){
		
		listAvaibleCourse();
		System.out.print(">>Please enter the course name you want to join: ");
		Scanner scanner = new Scanner(System.in);
		int course = scanner.nextInt();
		
		for (int i = 0; i < CourseList.size(); i++) {
			if(CourseList.get(i).getCourseID() == course) {
				CourseList.get(i).joinCourse(uid);
				return true;
			}
		}
		return false;
	}

	//List Avaible Courses
	public static void listAvaibleCourse(){
		System.out.println("-----------------------------------------------------");
		System.out.println("- ID\tCourse Name");
		System.out.println("-----------------------------------------------------");	
		
		for (int i = 0; i < CourseList.size(); i++) {
			System.out.println("- " + CourseList.get(i).getCourseID() + "\t" + CourseList.get(i).getCourseName());
		}
		
		System.out.println("-----------------------------------------------------");
	}
	
	//List Courses Targets
	public static void listTarget(){
		System.out.println("-----------------------------------------------------");
		System.out.println("ID\tCourse Name\tTargets");
		System.out.println("-----------------------------------------------------");
		
		for (int i = 0; i < CourseList.size(); i++) {
			System.out.println("- " + CourseList.get(i).getCourseID() + "\t" + CourseList.get(i).getCourseName() + "\t" + CourseList.get(i).getTarget());
		}
		System.out.println("-----------------------------------------------------");
	}
}
