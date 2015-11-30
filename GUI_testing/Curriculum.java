/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Curriculum > Course
********************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

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
		
		String output =  "> List all courses";
		test.write(output);
		
		String [] strHeader = {"Course ID", "Course Name", "Type", "Status"};
		String [][] strData = new String[courselist.size()][4]; 
		boolean not = true;
		int row = 0;
		for (int i = 0; i < courselist.size(); i++) {
			strData[row][0] = Integer.toString(courselist.get(i).getCourseID()); 
			strData[row][1] = courselist.get(i).getCourseName(); 
			strData[row][2] = courselist.get(i).getCourseType(); 
			strData[row++][3] = courselist.get(i).getStatus(); 
			not = false;
		}
		if(not) {
			JOptionPane.showMessageDialog(null, "Not for now.");
		}else {
			TableModel  model = new DefaultTableModel(strData,strHeader);
			TraineeMenu.table.setModel(model);
		}
	}
	
	

	

	//List Avaible Courses (Trainee Option 1)
	public static void listAvaibleCourse(int type,int uid){
		
		String output =  "> List Avaible courses";
		test.write(output);
		
		String [] strHeader = {"Course ID", "Course Name", "Course Type", "Price($)"};
		String [][] strData = new String[courselist.size()][4]; 
		int age = Account.userlist.get(Account.searchuserlistID(uid)).getAge();
		boolean not = true;
		int row = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(!(courselist.get(i).completed) && courselist.get(i).courseType <= type && !(courselist.get(i).checkid(uid))){
				int price = courselist.get(i).getPrice();
				if ( age <= 18 || age >= 60) price = (int)(price * 0.7);
				strData[row][0] = Integer.toString(courselist.get(i).getCourseID()); 
				strData[row][1] = courselist.get(i).getCourseName(); 
				strData[row][2] = courselist.get(i).getCourseType(); 
				strData[row++][3] = Integer.toString(price); 
				not = false;
			}
		}
		if(not) {
			JOptionPane.showMessageDialog(null, "Not for now.");
		}else {
			TableModel  model = new DefaultTableModel(strData,strHeader);
			TraineeMenu.table.setModel(model);
		}
	}

	//Join Courses (Trainee Option 2)
	public static void joinCourse(int type,int uid){
		
		String output =  "> Join courses";
		test.write(output);
		
		int i = Integer.parseInt(TraineeMenu.table.getValueAt(TraineeMenu.table.getSelectedRow(), 0).toString());
		
		if(JOptionPane.showConfirmDialog(null, "Are you sure to pay and join Course [" + i + "] ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			courselist.get(i-1).addTrainee(uid);
			JOptionPane.showMessageDialog(null, "Course joined");	
		}else{
			JOptionPane.showMessageDialog(null, "Action was cancelled");	
		}
		
	}
	
	//List CCCourses (Trainee Option 3)
	public static void listCCCourse(int uid){
		
		String output =  "> List Current/Completed courses";
		test.write(output);
		
		String [] strHeader = {"Course ID", "Course Name", "Status"};
		String [][] strData = new String[courselist.size()][3]; 
		boolean not = true;
		int row = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid)){
				strData[row][0] = Integer.toString(courselist.get(i).getCourseID()); 
				strData[row][1] = courselist.get(i).getCourseName(); 
				strData[row++][2] = courselist.get(i).getStatus();
				not = false;
			}
		}
		if(not) {
			JOptionPane.showMessageDialog(null, "Not for now.");
		}else {
			TableModel  model = new DefaultTableModel(strData,strHeader);
			TraineeMenu.table.setModel(model);
		}
	}	
	
	//List Courses Targets (Trainee Option 4)
	public static void listTarget(int uid){
		String [] strHeader = {"Course ID", "Course Name", "Targets"};
		String [][] strData = new String[courselist.size()][3]; 
		boolean not = true;
		int row = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid) && !(courselist.get(i).completed)){
				strData[row][0] = Integer.toString(courselist.get(i).getCourseID()); 
				strData[row][1] = courselist.get(i).getCourseName(); 
				strData[row++][2] = courselist.get(i).getTarget();
				not = false;
			}
		}
		if(not) {
			JOptionPane.showMessageDialog(null, "Not for now.");
		}else {
			TableModel  model = new DefaultTableModel(strData,strHeader);
			TraineeMenu.table.setModel(model);
		}
	}
	
	//Search Course by cid (return ArrayList ID)
    public static int searchcourselistID(int uid) {
        for (int i = 0; i < courselist.size(); i++) {
            if (courselist.get(i).getCourseID() == uid) 
                return i;
        }
        return -1;
    }

	//List Trainer Owned Courses (Trainer Option 1)
	public static void listOwnedCourse(int uid, boolean all){
		
		String output =  "> List Owned Courses ";
		test.write(output);
		
		String [] strHeader = {"Course ID", "Course Name", "Total", "Status"};
		String [][] strData = new String[courselist.size()][4]; 
		boolean not = true;
		int row = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).getTrainerID() == uid){
				if( all || !(courselist.get(i).completed ) ){
					strData[row][0] = Integer.toString(courselist.get(i).getCourseID()); 
					strData[row][1] = courselist.get(i).getCourseName(); 
					strData[row][2] = Integer.toString(courselist.get(i).getTotalOfTrainee()); 
					strData[row++][3] = courselist.get(i).getStatus(); 
					not = false;
				}
			}
		}
		if(not) {
			JOptionPane.showMessageDialog(null, "Not for now.");
		}else {
			TableModel  model = new DefaultTableModel(strData,strHeader);
			TrainerMenu.table.setModel(model);
		}
	}
		
	//Complete Courses (Trainer Option 3)
	public static void completeCourse(int uid){

		String output =  "> Complete courses";
		test.write(output);
		
		int i = Integer.parseInt(TrainerMenu.table.getValueAt(TrainerMenu.table.getSelectedRow(), 0).toString());
		
		if(JOptionPane.showConfirmDialog(null, "Are you sure to complete Course [" + i + "] ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			courselist.get(i-1).completed = true;
			JOptionPane.showMessageDialog(null, "Course Completed");	
		}else{
			JOptionPane.showMessageDialog(null, "Action was cancelled");	
		}
		
	}

			
//######################################################################################################################
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

//######################################################################################################################
//Edit Course Information
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
                System.out.println("- 2: Course Target");
                System.out.println("- 3: Course Description");
                System.out.println("- 8: Show Course information");
                System.out.println("- 9: Quit Editing");

                inStr = scanner.next();

                switch(inStr.charAt(0)) {
                    case '1':
                        System.out.println("Please enter the new Name (-q for quit without change");
						inStr = scanner.next();
                        if(inStr.equals("-q") || inStr.equals("-Q")) {
                            break;
                        } else {
                                System.out.println("The previous Name: " + courselist.get(listID).getCourseName());
                                System.out.println("The new Name: " + inStr);
                                System.out.println(">> Are you sure to make change? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    courselist.get(listID).setCourseName(inStr);
                                    System.out.println("The Name is updated!");
                                } else {
                                    System.out.println("Action was cancelled!");
                                }
                        }
						break;
                    case '2':
						System.out.println("Please enter the target (-q for quit without change");
						inStr = scanner.next();
                        if(inStr.equals("-q") || inStr.equals("-Q")) {
                            break;
                        } else {
                                System.out.println("The previous target: " + courselist.get(listID).getTarget());
                                System.out.println("The new target: " + inStr);
                                System.out.println(">> Are you sure to make change? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    courselist.get(listID).setTarget(inStr);
                                    System.out.println("The Target is updated!");
                                } else {
                                    System.out.println("Action was cancelled!");
                                }
                        }
						break;
                    case '3':
						System.out.println("Please enter the description (-q for quit without change");
						inStr = scanner.next();
                        if(inStr.equals("-q") || inStr.equals("-Q")) {
                            break;
                        } else {
                                System.out.println("The previous description: " + courselist.get(listID).getDescription().replaceAll("(.{1,50})\\s+", "$1\n\t   "));
                                System.out.println("The new description: " + inStr);
                                System.out.println(">> Are you sure to make change? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    courselist.get(listID).setDescription(inStr);
                                    System.out.println("The Description is updated!");
                                } else {
                                    System.out.println("Action was cancelled!");
                                }
                        }
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

//######################################################################################################################	
	//Delete Course
	 public static void	deleteCourse(int cid) {
		int listID = searchcourselistID(cid);
        if (listID != -1) {
            System.out.println("Found the record");
			System.out.format("Course Name: [%s]\n", courselist.get(listID).getCourseName() );
			System.out.println("Are you Confirm to delete this Course? (Y/N)");
			Scanner scanner = new Scanner(System.in);
			String inStr;
			inStr = scanner.next();
			if(inStr.equals("Y") || inStr.equals("y")) {
				removeCourse(cid);
                System.out.println("Course was deleted!");	
			} else{
                System.out.println("Action was cancelled!");
			}
        } else {
            System.out.println("No such course");
        }
	}
	
}
