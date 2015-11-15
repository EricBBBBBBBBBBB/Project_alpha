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

// Declare data members
    public static final String DEF_COURSE = "Courses.csv";
    public static final String DEF_CURCOURSE = "Current.csv";
    public static ArrayList<Course> courselist = new ArrayList<Course>(); 
	
	
// Methods
	//Initialization Course List
    public static void initcourselist() {       
		courselist = CourseIO.readCTxtFile(DEF_COURSE);
		System.out.println("Read OK: " + DEF_COURSE);
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
		
		System.out.println("-------------------------------------------");
		System.out.println("ID\tCourse Name\tStatus");
		System.out.println("-------------------------------------------");
		
		for (int i = 0; i < courselist.size(); i++) {
			System.out.println(	courselist.get(i).getCourseID() + "\t" + courselist.get(i).getCourseName()+ "\t" + courselist.get(i).getCourseStatus());
		}
		System.out.println("------------------------------------------\n");

	}
	
	//Diplay User Owned Courses
	public static void printOwnedCourse(String uname){
		System.out.println("------------------- Owned Courses -------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("ID\tCourse Name");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < courselist.size(); i++) {
				if(courselist.get(i).getTrainerName().equals(uname)) 
					System.out.println("- " + courselist.get(i).getCourseID() + "\t" + courselist.get(i).getCourseName());
		}
		System.out.println("------------------------------------------\n");
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

	//List Avaible Courses
	public static void listAvaibleCourse(){
		System.out.println("-----------------------------------------------------");
		System.out.println("- ID\tCourse Name");
		System.out.println("-----------------------------------------------------");	
		
		for (int i = 0; i < courselist.size(); i++) {
			if(!(courselist.get(i).Completed) && courselist.get(i).isAvailable) System.out.println("- " + courselist.get(i).getCourseID() + "\t" + courselist.get(i).getCourseName());
		}
		
		System.out.println("-----------------------------------------------------");
	}
	
	//List Courses Targets
	public static void listTarget(){
		System.out.println("-----------------------------------------------------");
		System.out.println("ID\tCourse Name\tTargets");
		System.out.println("-----------------------------------------------------");
		
		for (int i = 0; i < courselist.size(); i++) {
			System.out.println("- " + courselist.get(i).getCourseID() + "\t" + courselist.get(i).getCourseName() + "\t" + courselist.get(i).getTarget());
		}
		System.out.println("-----------------------------------------------------");
	}
}
