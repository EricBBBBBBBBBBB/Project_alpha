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

// Declare data members //////////////////////////(To save the Course Infomation without FileIOSystem)
    public static ArrayList<Course> CourseList = new ArrayList<Course>(); 
	
	
// Methods //////////////////////////
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
	public static void displayCourse(String uname){
		
		//Current Courses
		System.out.println("-------------------------------------------");
		System.out.println("Current Courses ");
		System.out.println("-------------------------------------------");
		System.out.println("ID\tCourse Name");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < CourseList.size(); i++) {
			for (int j = 0; j < CourseList.get(i).TraineeList.size(); j++) {
				if(CourseList.get(i).TraineeList.get(j).getUserName().equals(uname)) System.out.println(CourseList.get(i).getCourseID() + "\t" + CourseList.get(i).getCourseName());
			}
		}
		System.out.println("------------------------------------------\n");
		
		//Completed Courses
		System.out.println("-------------------------------------------");
		System.out.println("Completed Courses");
		System.out.println("------------------------------------------\n");
		System.out.println("ID\tCourse Name");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < CourseList.size(); i++) {
			for (int j = 0; j < CourseList.get(i).CompletedTraineeList.size(); j++) {
				if(CourseList.get(i).CompletedTraineeList.get(j).getUserName().equals(uname)) System.out.println(CourseList.get(i).getCourseID() + "t\t" + CourseList.get(i).getCourseName());
			}
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
	public static void JoinCourse(Trainee user){
		
		listAvaibleCourse();
		System.out.println(" Join");
		System.out.print(" Please enter the course name you want to join: ");
		Scanner scanner = new Scanner(System.in);
		String course = scanner.next();
		
		for (int i = 0; i < CourseList.size(); i++) {
			if(CourseList.get(i).getCourseName().equals(course)) {
				CourseList.get(i).joinCourse(user);
				System.out.println(" Joined. \n");
				break;
			}else{
				System.out.println(" Unknown Courses. \n");
			}
		}	
	}

	//List Avaible Courses
	public static void listAvaibleCourse(){
		System.out.println("--------------------------------");
		System.out.println("ID\tCourse Name");
		System.out.println("--------------------------------");
		
		for (int i = 0; i < CourseList.size(); i++) {
			System.out.println(	CourseList.get(i).getCourseID() + "\t\t" + CourseList.get(i).getCourseName());
		}
		System.out.println("--------------------------------");
	}
	
	//List Courses Targets
	public static void listTarget(){
		System.out.println("--------------------------------");
		System.out.println("ID\tCourse Name\tTargets");
		System.out.println("--------------------------------");
		
		for (int i = 0; i < CourseList.size(); i++) {
			System.out.println(	CourseList.get(i).getCourseID() + "\t\t" + CourseList.get(i).getCourseName() + "\t" + CourseList.get(i).getTarget());
		}
		System.out.println("--------------------------------\n");
	}
}
