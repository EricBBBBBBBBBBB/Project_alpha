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
		System.out.println("- ID   Course Name         Type           Status");
		System.out.println("-----------------------------------------------------");	
		boolean not = true;		
		for (int i = 0; i < courselist.size(); i++) {
			System.out.format( "- %-5d%-20s%-15s%s\n" , courselist.get(i).getCourseID(), courselist.get(i).getCourseName(), courselist.get(i).getCourseType(), courselist.get(i).getCourseStatus() );
			not = false;
		}
		if(not)System.out.println("- Not for now.");		
		System.out.println("-----------------------------------------------------");

	}
	
	
	//List Trainer Owned Courses
	public static void listOC(int uid, boolean all){
		System.out.println("------------------- Owned Courses -------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println(" ID    Course Name         Total    Status");
		System.out.println("-----------------------------------------------------");	
		
		boolean not = true;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).getTrainerID() == uid){
				if( all || !(courselist.get(i).completed ) ){
					System.out.format( "- %-5d%-20s%d/%-7d%s\n" , courselist.get(i).getCourseID(), courselist.get(i).getCourseName(), courselist.get(i).getTotalOfTrainee(), courselist.get(i).getMaxOfTrainee(), courselist.get(i).getStatus());
					not = false;
				}
					
			}
		}
		
		if(not)System.out.println("- Not for now.");		
		System.out.println("-----------------------------------------------------");
	}
	
	public static void listOwnedCourse(int uid){
		
		listOC(uid,true);
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
			if(courselist.get(i).courseID == inInt && courselist.get(i).getTrainerID() == uid ){
				courselist.get(i).printCourseInfo();
				found = true;
			} 
		}
		if(!found) System.out.println(">> Course not found!!\n");

	}	
	
	public static void completeCourse(int uid){
		
		listOC(uid,false);
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
        char inChar;
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
				found = true;
				courselist.get(i).printCourseInfo();
				System.out.println(">> Are you sure to pay and join this course? (Y/N)");
				inChar = scanner.next().charAt(0);
				if(inChar == 'y' || inChar == 'Y'){
					courselist.get(i).addTrainee(uid);
					System.out.println(">> Course joined. \n");
				} else {
					System.out.println(">> Action was cancelled!");
				}
			}
		}
		if(!found) System.out.println(">> Course not found!!\n");		
	}
	
	//Search Course by cid (return ArrayList ID)
    public static int searchcourselistID(int uid) {
        for (int i = 0; i < courselist.size(); i++) {
            if (courselist.get(i).getCourseID() == uid) 
                return i;
        }
        return -1;
    }
	
	
	//Create Course
	public static void createCourse(){
		
		//declare datas
		int courseID, courseType, courseTrainer, duration, price, max, total;
		String courseName, venue, target, description;
		boolean completed;
		Course newcourse;

		//create new course
		courseID = 0;
		courseName = "###";
		courseType = 3;
		newcourse = new Course(courseID, courseName, courseType);
		
		//input information
		completed = false;
		courseTrainer = 8;
		duration = 3;
		venue = "###";
		price = 0;
		target = "###";
		description = "###";
		//total = ;
		max = 15 ;
		

		newcourse.setCourseInfo(completed, courseTrainer, duration, venue, price, target, description, max);
		courselist.add(newcourse);
	}
		
		
	
	//Check total of completed Course
	public static int checkNoOfcompleted(int uid){
		int total = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid) && courselist.get(i).completed) total++;
		}
		return total;
	}
	
	//Check total of Current Course
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
	
	//Check total of owned by CourseID 
    public static int checkNoOfOwned(int uid) {
		int total = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).courseTrainerID == uid) total++;
		}
		return total;
    }
	
	//Edit User Information
    public static void editCourse(int cid) {
		int listID = searchcourselistID(cid);
        if (listID != -1) {
            System.out.println("Found the record");
			
        Scanner scanner = new Scanner(System.in);
            String inStr;
            char inChar;
			
            whileloop:
            while(true) {
                System.out.println("---------------Edit Course Information-------------");
                System.out.println("Please select the part you want to edit: ");
                System.out.println("- 1: Course Name");
                System.out.println("- 2: XX");
                System.out.println("- 3: XX");
                System.out.println("- 8: Show Course information");
                System.out.println("- 9: Quit Editing");

                inStr = scanner.next();

                switch(inStr.charAt(0)) {
                    case '1':
						System.out.format("Current Course Name: [%s]\n", courselist.get(listID).getCourseName() );
                        System.out.println("Please enter the new XX (-q for quit without change");
						inStr = scanner.next();
                        if(inStr.equals("-q") || inStr.equals("-Q")) {
                            break;
                        } /*else {
                            if(IOValidation.emailValid(inStr)) {
                                System.out.println("The previous Email: " + userlist.get(listID).getUserEmail());
                                System.out.println("The new Email: " + inStr);
                                System.out.println(">> Are you sure to make change? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    userlist.get(listID).setUserEmail(inStr);
                                    System.out.println("The Email is updated!");
                                } else {
                                    System.out.println("Action was cancelled!");
                                }
                            }else{
                                System.out.println("Wrong format");
                            }
                        }*/
						break;
                    case '2':
						/*System.out.println("Please enter the new phone number (-q for quit without change");
                        inStr = scanner.next();
                        if(inStr.equals("-q") || inStr.equals("-Q")) {
                            break;
                        } else {
                            if(IOValidation.phoneValid(inStr)) {
                                System.out.println("The previous Phone: " + userlist.get(listID).   getUserPhone());
                                System.out.println("The new Phone: " + inStr);
                                System.out.println(">> Are you sure to make chnage? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    userlist.get(listID).setUserPhone(inStr);
                                    System.out.println("The Phone number is updated!");
                                } else {
                                    System.out.println("Action was cancelled!");
                                }
                            }else{
                                System.out.println("Wrong format");
                            }
                        }*/
                        break;
                    case '3':
                        break;
                    case '8':
						courselist.get(listID).printCourseInfo();
                        break;
                    case '9':
                        break whileloop;
                    default:
                        System.out.println("Unknown command");
                        break whileloop;
                }

            }
        } else {
            System.out.println("No such course");
        }
	}
	
	
	//Courses Performance
	public static void Performance(){
		System.out.println(" Grade performance\n");
		//Current trainee
		//completed trainee
	}
	
}
