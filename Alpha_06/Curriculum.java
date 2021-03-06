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
	public static void listOC(int tid, boolean all){
		System.out.println("------------------- Owned Courses -------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(" ID    Course Name         Total    Status");
		System.out.println("-----------------------------------------------------");	
		
		boolean not = true;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).getTrainerID() == tid){
				if( all || !(courselist.get(i).completed ) ){
					System.out.format( "- %-5d%-20s%d/%-7d%s\n" , courselist.get(i).getCourseID(), courselist.get(i).getCourseName(), courselist.get(i).getTotalOfTrainee(), courselist.get(i).getMaxOfTrainee(), courselist.get(i).getStatus());
					not = false;
				}
					
			}
		}
		
		if(not)System.out.println("- Not for now.");		
		System.out.println("-----------------------------------------------------");
	}
	
	public static void listOwnedCourse(int tid){
		
		listOC(tid,true);
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
			if(courselist.get(i).courseID == inInt && courselist.get(i).getTrainerID() == tid ){
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
			if(!(courselist.get(i).completed) && courselist.get(i).courseType <= type && !(courselist.get(i).checkid(uid))){
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
			if(courselist.get(i).courseID == inInt && !(courselist.get(i).completed) && courselist.get(i).courseType <= type ){
				courselist.get(i).printCourseInfo();
				found = true;
			} 
		}
		if(!found) System.out.println(">> Course not found!!\n");
	
	}
	
	//List Courses Targets
	public static void listTarget(int uid){
		System.out.println("-----------------------------------------------------");
		System.out.println(" ID    Course Name         Targets");
		System.out.println("-----------------------------------------------------");
		boolean not = true;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid) && !(courselist.get(i).completed)){
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
		System.out.println(" ID    Course Name         Status");
		System.out.println("-----------------------------------------------------");
		boolean not = true;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid)){
				System.out.format( "- %-5d%-20s%-20s\n" , courselist.get(i).getCourseID(), courselist.get(i).getCourseName(), courselist.get(i).getStatus());
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
			if(courselist.get(i).courseID == inInt && !courselist.get(i).completed && !courselist.get(i).checkid(i) ) {
				courselist.get(i).addTrainee(uid) ;
				System.out.println(">> Course joined.\n");	
				found = true;
			}
		}
		if(!found) System.out.println(">> Course not found!!\n");		
	}
	
	//Trainer complete Course
	public static void completeCourse(int tid){
		
		listOC(tid,false);
		System.out.println("Please enter the Course ID to complete it.");
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
			if(courselist.get(i).courseID == inInt && !(courselist.get(i).completed)) {
				courselist.get(i).completed = true;
				System.out.println(">> Course completed.\n");	
				found = true;
			}
		}
		if(!found) System.out.println(">> Course not found!!\n");		
	}
	
	
	
	//Check total of completed Courses
	public static int checkNoOfcompleted(int uid){
		int total = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid) && courselist.get(i).completed) total++;
		}
		return total;
	}
	
	//Check total of Current Courses
	public static int checkNoOfCurrent(int uid){
		int total = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid) && !(courselist.get(i).completed)) total++;
		}
		return total;
	}
	
	//Check completed or Not by CourseID 
    public static boolean checkcompleted(int uid) {
        for (int i = 0; i < courselist.size(); i++) {
            if (courselist.get(i).getCourseID() == uid)
                return courselist.get(i).completed;
        }
        return false;
    }
	
	//Courses Performance
	public static void Performance(){
		System.out.println(" Grade performance\n");
		//Current trainee
		//completed trainee
	}
	
}
