/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* CourseIO.java: 
********************************************/

import java.io.*;
import java.util.*;

class CourseIO{

// Declare data members //////////////////////////	
	public static final String DEF_COLDELIMITER = ",";
	public static final String DEF_TITLEHEADER ="Course ID,Course name,Course Type,Completed,Course Trainer,Duration (Weeks),Venue,Price ($),Course Target,Course Description,Total of Trainee,Max of Trainee";
	
// Methods //////////////////////////
	public static ArrayList<Course> readCTxtFile(String inFileStr){
		System.out.println("START of readLBTxtFile from file ["+inFileStr+"]");
			ArrayList<Course> list = new ArrayList<Course>();
			// Exception handling
			try {
				File inFile = new File(inFileStr);
				BufferedReader bufferReader = new BufferedReader(new FileReader(inFile));
				try {
					//1st row: title header (may be ignored)
					String [] header = bufferReader.readLine().split(DEF_COLDELIMITER);
					//other rows: content
					String row = null;
					String [] strSplitArr;
					int courseID, courseType, duration, price, total, max;
					String courseName, courseTrainer, venue, target, description;
					boolean Completed;
					Course newcourse;
					
					while ((row = bufferReader.readLine()) != null) {
						strSplitArr = row.split(DEF_COLDELIMITER);
						
						//create new course
						courseID = Integer.parseInt(strSplitArr[0]);
						courseName = strSplitArr[1];
						courseType = Integer.parseInt(strSplitArr[2]);
						newcourse = new Course(courseID, courseName, courseType);
						
						//input information
						Completed = Boolean.parseBoolean(strSplitArr[3]);
						courseTrainer = strSplitArr[4];
						duration = Integer.parseInt(strSplitArr[5]);
						venue = strSplitArr[6];
						price = Integer.parseInt(strSplitArr[7]);
						target = strSplitArr[8];
						description = strSplitArr[9];
						max = Integer.parseInt(strSplitArr[11]);
						newcourse.setCourseInfo(Completed, courseTrainer, duration, venue, price, target, description, max);
						
						//add to course list
						list.add(newcourse);
					}
				} finally {
					bufferReader.close(); //close the stream
				}
			} catch (IOException ex) {
				System.out.println("ERROR: File cannot be found");
			} catch (ArrayIndexOutOfBoundsException ex) {
				System.out.println("ERROR: Incorrect number of columns");
			} catch (NumberFormatException ex) {
				System.out.println("ERROR: Check colDelimiter/ data");
			}
		return list;
	}
	
	public static boolean writeCTxtFile(String outFileStr, ArrayList<Course> list ){
		System.out.println("START of writeLBTxtFile to file ["+outFileStr+"]");
		if (list==null) return false; // in case of null arraylist
		try{
			File outFile = new File(outFileStr);
			FileOutputStream outFileStream = new FileOutputStream(outFile);
			PrintWriter outStream = new PrintWriter(outFileStream);
			
			// writing Course objects to text file
			outStream.println(DEF_TITLEHEADER); // print/output title header
			for(int i = 0 ; i < list.size(); i++) { // print/output each Course
				outStream.print(list.get(i).courseID + DEF_COLDELIMITER);
				outStream.print(list.get(i).courseName + DEF_COLDELIMITER);
				outStream.print(list.get(i).courseType + DEF_COLDELIMITER);
				outStream.print(list.get(i).Completed + DEF_COLDELIMITER);
				outStream.print(list.get(i).courseTrainerName + DEF_COLDELIMITER);
				outStream.print(list.get(i).duration + DEF_COLDELIMITER);
				outStream.print(list.get(i).venue + DEF_COLDELIMITER);
				outStream.print(list.get(i).price + DEF_COLDELIMITER);
				outStream.print(list.get(i).target + DEF_COLDELIMITER);
				outStream.print(list.get(i).description + DEF_COLDELIMITER);
				outStream.print(list.get(i).totalNumOfTrainee + DEF_COLDELIMITER);
				outStream.print(list.get(i).maxNumOfTrainee + DEF_COLDELIMITER);		
				outStream.println("");
			}
			outStream.close();
			outFileStream.close();
		} catch (FileNotFoundException ex){
			System.out.println("ERROR - FileNotFoundException. Write Course Failure.");
			return false;
		} catch (IOException ex){
			System.out.println("ERROR - IOException. Write Course Failure.");
			return false;
		}
		System.out.println("END of writeLBTxtFile");
		return true;	
	}
	
}

