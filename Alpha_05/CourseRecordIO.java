/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* CourseIO.java: 
********************************************/

import java.io.*;
import java.util.*;

class CourseRecordIO{

// Declare data members //////////////////////////	
	public static final String DEF_COLDELIMITER = ",";
	public static final String DEF_TITLEHEADER ="Course ID,Trainer ID,Max of Trainee,Trainee ID";
	
// Methods //////////////////////////
	public static ArrayList<CourseRecord> readRTxtFile(String inFileStr){
		System.out.println("START of readLBTxtFile from file ["+inFileStr+"]");
			ArrayList<CourseRecord> list = new ArrayList<CourseRecord>();
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
					
					int courseID, trainerID, max;
					CourseRecord newrecord;
					
					while ((row = bufferReader.readLine()) != null) {
						strSplitArr = row.split(DEF_COLDELIMITER);
						
						//set info.
						courseID = Integer.parseInt(strSplitArr[0]);
						trainerID = Integer.parseInt(strSplitArr[1]);
						max = Integer.parseInt(strSplitArr[2]);
						
						ArrayList<Integer> tlist = new ArrayList<Integer>();
						for(int i = 3; i < strSplitArr.length ; i++ ){
							tlist.add(Integer.parseInt(strSplitArr[i]));
						}
						
						//create new course
						newrecord = new CourseRecord(courseID);
						newrecord.setInfo(trainerID, max);
						newrecord.setTrainee(tlist);
						
						
						//add to course list
						list.add(newrecord);
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
			
		//Backup
		writeRTxtFile(inFileStr.substring(0,inFileStr.length() - 4) + "_BackUp.csv", list );	
		
		return list;
	}
	
	public static boolean writeRTxtFile(String outFileStr, ArrayList<CourseRecord> list ){
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
				outStream.print(list.get(i).courseTrainerID + DEF_COLDELIMITER);
				outStream.print(list.get(i).maxNumOfTrainee + DEF_COLDELIMITER);
				ArrayList<Integer> tlist = list.get(i).traineelist;
				for(int j = 0; j < tlist.size(); j++ ){
					outStream.print(tlist.get(j)+ DEF_COLDELIMITER);
				}
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

