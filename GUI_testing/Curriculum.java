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

	
////Trainee Option
	//List Avaible Courses (Trainee Option 1)
	public static void listAvaibleCourse(int type,int uid){
		
		String output =  "> List Avaible courses";
		OutPutStream.write(output);
		
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
			TableModel  model = new DefaultTableModel(strData,strHeader) {
				public boolean isCellEditable(int row, int column)
				{
				  return false;
				}
			};
			Menus.table.setModel(model);
		}
	}

	//Join Courses (Trainee Option 2)
	public static void joinCourse(int i, int type,int uid){
		
		String output =  
			"> Join courses\n" +
			"> Select one course before click the join button"		
		;
		OutPutStream.write(output);
		int listID = searchcourselistID(i);		
		
		if(JOptionPane.showConfirmDialog(null, "Are you sure to pay and join Course [" + i + "] ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			if(!courselist.get(listID).checkid(uid)){
				courselist.get(listID).addTrainee(uid);
				JOptionPane.showMessageDialog(null, "Course joined");
			}else{
				JOptionPane.showMessageDialog(null, "You already joined the course");	
			}
		}else{
			JOptionPane.showMessageDialog(null, "Action was cancelled");	
		}
		
		listAvaibleCourse(type,uid);
	}
	
	//List CCCourses (Trainee Option 3)
	public static void listCCCourse(int uid){
		
		String output =  "> List Current/Completed courses";
		OutPutStream.write(output);
		
		String [] strHeader = {"Course ID", "Course Name", "Status", "Grade"};
		String [][] strData = new String[courselist.size()][4]; 
		boolean not = true;
		int row = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).checkid(uid)){
				strData[row][0] = Integer.toString(courselist.get(i).getCourseID()); 
				strData[row][1] = courselist.get(i).getCourseName(); 
				strData[row][2] = courselist.get(i).getStatus();
				if(courselist.get(i).searchtraineelistID(uid) != -1){
					strData[row++][3] = courselist.get(i).gettraineeGrade(courselist.get(i).searchtraineelistID(uid));
				}else{
					row++;
				}
				not = false;
			}
		}
		if(not) {
			JOptionPane.showMessageDialog(null, "Not for now.");
		}else {
			TableModel  model = new DefaultTableModel(strData,strHeader) {
				public boolean isCellEditable(int row, int column)
				{
				  return false;
				}
			};
			Menus.table.setModel(model);
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
			TableModel  model = new DefaultTableModel(strData,strHeader) {
				public boolean isCellEditable(int row, int column)
				{
				  return false;
				}
			};
			Menus.table.setModel(model);
		}
	}
	
	
////Trainer Option
	//List Trainer Owned Courses (Trainer Option 1)
	public static void listOwnedCourse(int uid, boolean all){
		
		String output =  "> List Owned Courses ";
		OutPutStream.write(output);
		
		String [] strHeader = {"Course ID", "Course Name", "Total", "Status"};
		String [][] strData = new String[courselist.size()][4]; 
		boolean not = true;
		int row = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).getTrainerID() == uid){
				if( all || !(courselist.get(i).completed ) ){
					strData[row][0] = Integer.toString(courselist.get(i).getCourseID()); 
					strData[row][1] = courselist.get(i).getCourseName(); 
					strData[row][2] = courselist.get(i).getTotalOfTrainee() + "/" +courselist.get(i).getMaxOfTrainee() ;
					strData[row++][3] = courselist.get(i).getStatus(); 
					not = false;
				}
			}
		}
		if(not) {
			JOptionPane.showMessageDialog(null, "Not for now.");
		}else {
			TableModel  model = new DefaultTableModel(strData,strHeader){
				public boolean isCellEditable(int row, int column)
				{
				  return false;
				}
			};
			Menus.table.setModel(model);
		}
	}
	
	//Trainer Search Course (Trainer Option 2)
	public static void trainersearchCourse(int courseType,int uid){

		int totSearchNum = 0;
		int row = 0;
		String message, inStr;  
		boolean type;
		
        switch(courseType) {
            case 0:
                message = "Beginner Course name: ";
                break;
            case 1:
                message = "Advanced Course name: ";
                break;
			case 2:
				message = "Intermediate Course name:";
				break;
            default:
                message = " Course name:";
        }
		inStr = JOptionPane.showInputDialog("Please enter the " + message);

		//listing
		String [] strHeader = {"Course ID", "Course Name", "Course Type"};
		String [][] strData = new String[courselist.size()][3]; 
        for (int i = 0; i < courselist.size(); i++) {
			switch(courseType) {
				case 0:
					type =  (courselist.get(i).getCourseType() == "Beginner");
					break;
				case 1:
					type =  (courselist.get(i).getCourseType() == "Intermediate");
					break;
				case 2:
					type =  (courselist.get(i).getCourseType() == "Advanced");
					break;
				default:
					type = true;
			}
            if(courselist.get(i).getCourseName().contains(inStr) && type && courselist.get(i).getTrainerID() == uid) {
				strData[row][0] = Integer.toString(courselist.get(i).getCourseID()); 
				strData[row][1] = courselist.get(i).getCourseName(); 
				strData[row++][2] = courselist.get(i).getCourseType();
                totSearchNum++;
            }
			
        }
		if(totSearchNum <= 0) {
			JOptionPane.showMessageDialog(null, "Course can't found.");
		}else {
			JOptionPane.showMessageDialog(null, "There are " + totSearchNum + " result(s)");
			TableModel  model = new DefaultTableModel(strData,strHeader){
				public boolean isCellEditable(int row, int column)
				{
				  return false;
				}
			};
			Menus.table.setModel(model);
		}
	
	}

	//List Trainer Owned Courses (Trainer Option 3)
	public static void enrolledTrainees(int uid){
		
		String output =  "> Courses Enrolled Trainees ";
		OutPutStream.write(output);
		
		String [] strHeader = {"Course ID", "Course Name", "Course Type", "Course Trainees"};
		String [][] strData = new String[courselist.size()][4]; 
		boolean not = true;
		int row = 0;
		for (int i = 0; i < courselist.size(); i++) {
			if(courselist.get(i).getTrainerID() == uid){
				if(!(courselist.get(i).completed ) ){
					strData[row][0] = Integer.toString(courselist.get(i).getCourseID()); 
					strData[row][1] = courselist.get(i).getCourseName(); 
					strData[row][2] =  courselist.get(i).getCourseType();
					strData[row++][3] = courselist.get(i).getTotalOfTrainee() + "/" +courselist.get(i).getMaxOfTrainee() ;
					not = false;
				}
			}
		}
		if(not) {
			JOptionPane.showMessageDialog(null, "Not for now.");
		}else {
			TableModel  model = new DefaultTableModel(strData,strHeader){
				public boolean isCellEditable(int row, int column)
				{
				  return false;
				}
			};
			Menus.table.setModel(model);
		}
	}
	
	public static boolean viewTrainees(int cid){
		
		ArrayList<Integer> traineelist = courselist.get(searchcourselistID(cid)).getTrainees();
		ArrayList<String> gradelist = courselist.get(searchcourselistID(cid)).getGrades();
		String [] strHeader = {"Trainee ID", "Trainee Name", "Trainee Type", "Grade"};
		String [][] strData = new String[traineelist.size()][4]; 
		boolean not = true;
		int row = 0;
		int tid = 0;
		
		for (int i = 0; i < traineelist.size(); i++) {
			tid = Account.searchuserlistID(traineelist.get(i));
			strData[row][0] =  Integer.toString(Account.userlist.get(tid).getUserID());
			strData[row][1] =  Account.userlist.get(tid).getUserName();
			strData[row][2] =  ((Trainee)Account.userlist.get(tid)).getTraineeType();
			strData[row++][3] =  gradelist.get(i);
			not = false;
			}
		if(not) {
			JOptionPane.showMessageDialog(null, "Not for now.");
			return false;
		}else {
			TableModel  model = new DefaultTableModel(strData,strHeader);
			Menus.table.setModel(model);
			return true;
		}
		
	}		
		
	//Complete Courses (Trainer Option 4)
	public static void completeCourse(int cid, int uid){

		String output =  "> Complete courses";
		OutPutStream.write(output);
		
		int listID = searchcourselistID(cid);	
		
		if(JOptionPane.showConfirmDialog(null, "Are you sure to complete Course [" + cid + "] ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			courselist.get(listID).completed = true;
			JOptionPane.showMessageDialog(null, "Course Completed");	
		}else{
			JOptionPane.showMessageDialog(null, "Action was cancelled");	
		}
		
	}
	

	
////Admin Option	

	//Search Course (Admin Option 7)
	public static void searchCourse(int courseType){

		int totSearchNum = 0;
		int row = 0;
		String message, inStr;  
		boolean type;
		
        switch(courseType) {
            case 0:
                message = "Beginner Course name: ";
                break;
            case 1:
                message = "Advanced Course name: ";
                break;
			case 2:
				message = "Intermediate Course name:";
				break;
            default:
                message = " Course name:";
        }
		inStr = JOptionPane.showInputDialog("Please enter the " + message);

		//listing
		String [] strHeader = {"Course ID", "Course Name", "Course Type"};
		String [][] strData = new String[courselist.size()][3]; 
        for (int i = 0; i < courselist.size(); i++) {
			switch(courseType) {
				case 0:
					type =  (courselist.get(i).getCourseType() == "Beginner");
					break;
				case 1:
					type =  (courselist.get(i).getCourseType() == "Intermediate");
					break;
				case 2:
					type =  (courselist.get(i).getCourseType() == "Advanced");
					break;
				default:
					type = true;
			}
            if(courselist.get(i).getCourseName().contains(inStr) && type) {
				strData[row][0] = Integer.toString(courselist.get(i).getCourseID()); 
				strData[row][1] = courselist.get(i).getCourseName(); 
				strData[row++][2] = courselist.get(i).getCourseType();
                totSearchNum++;
            }
			
        }
		if(totSearchNum <= 0) {
			JOptionPane.showMessageDialog(null, "Course can't found.");
		}else {
			JOptionPane.showMessageDialog(null, "There are " + totSearchNum + " result(s)");
			TableModel  model = new DefaultTableModel(strData,strHeader){
				public boolean isCellEditable(int row, int column)
				{
				  return false;
				}
			};
			Menus.table.setModel(model);
		}
	
	}
	
	//Remove Course (Admin Option 9)
	public static void	removeCourse(int cid) {
		int listID = searchcourselistID(cid);

		if(JOptionPane.showConfirmDialog(null, "Are you sure to remove Course [" + courselist.get(listID).getCourseName() + "] ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			courselist.remove(listID);
			JOptionPane.showMessageDialog(null, "Course Removed");	
			listAll();
		}else{
			JOptionPane.showMessageDialog(null, "Action was cancelled");	
		}	 
		
	}
//######################################################################################################################
	//Create Course (Admin Option 10)
	public static void createCourse(){
		
		//declare datas
		int courseID, courseType, courseTrainer, duration, price, max, total;
		String courseName, venue, target, description;
		boolean completed;
			
		//input information

		duration = 3;
		venue = "###";
		price = 0;
		target = "###";
		description = "###";
		max = 15 ;
		
		//create
		
	}

	
//Other Supporting method
	
	//List all Course records
	public static void listAll(){
		
		String output =  "> List all courses";
		OutPutStream.write(output);	
		
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
			TableModel  model = new DefaultTableModel(strData,strHeader) {
				public boolean isCellEditable(int row, int column)
				{
				  return false;
				}
			};
			Menus.table.setModel(model);
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
	
}
