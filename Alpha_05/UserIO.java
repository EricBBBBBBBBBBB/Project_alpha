/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* UserIO.java:
********************************************/

import java.io.*;
import java.util.*;

class UserIO{

// Declare data members //////////////////////////	
	public static final String DEF_COLDELIMITER = ",";
	public static final String DEF_TITLEHEADER ="User ID, User Type, User name, Password, Email, Phone, Date of Register, Trainee Type (for Trainee Only)";
	
// Methods //////////////////////////
	public static ArrayList<User> readUTxtFile(String inFileStr){
		System.out.println("START of readLBTxtFile from file ["+inFileStr+"]");
			ArrayList<User> list = new ArrayList<User>();
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
					int userID, userType, traineeType;
					String uName, password, email, phone, dateOfReg;
					Calendar date;
					User newuser;
					
					while ((row = bufferReader.readLine()) != null) {
						strSplitArr = row.split(DEF_COLDELIMITER);
						userID = Integer.parseInt(strSplitArr[0]);
						uName = strSplitArr[2];
						password = strSplitArr[3];
						email = strSplitArr[4];
						phone = strSplitArr[5];
						//date = strSplitArr[6];
						//traineeType = Integer.parseInt(strSplitArr[7]);
						switch(Integer.parseInt(strSplitArr[1])) {
							case 1:
								newuser = new Trainer(userID, uName, password);
								newuser.setUserInfo(email,phone);
								break;
							case 2:
								newuser = new Admin(userID, uName, password);
								newuser.setUserInfo(email,phone);
								break;
							case 0:
							default:
								newuser = new Trainee(userID, uName, password);
								newuser.setUserInfo(email,phone);
						}
						list.add(newuser);
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
	
	public static boolean writeUTxtFile(String outFileStr, ArrayList<User> list ){
		System.out.println("START of writeLBTxtFile to file ["+outFileStr+"]");
		if (list==null) return false; // in case of null arraylist
		try{
			File outFile = new File(outFileStr);
			FileOutputStream outFileStream = new FileOutputStream(outFile);
			PrintWriter outStream = new PrintWriter(outFileStream);
			
			// writing Book objects to text file
			outStream.println(DEF_TITLEHEADER); // print/output title header
			for(int i = 0 ; i < list.size(); i++) { // print/output each book
				outStream.print(list.get(i).getUserID()  + DEF_COLDELIMITER);
				outStream.print(list.get(i).userType + DEF_COLDELIMITER);
				outStream.print(list.get(i).getUserName() + DEF_COLDELIMITER);
				outStream.print(list.get(i).password + DEF_COLDELIMITER);
				outStream.print(list.get(i).getUserEmail() + DEF_COLDELIMITER);
				outStream.print(list.get(i).getUserPhone() + DEF_COLDELIMITER);
				outStream.print(list.get(i).dateOfRegister.getTime() + DEF_COLDELIMITER);
				if (list.get(i) instanceof Trainee){
					outStream.print(((Trainee)list.get(i)).traineeType + DEF_COLDELIMITER);
				}
				if (list.get(i) instanceof Trainer){

				}
				if (list.get(i) instanceof Admin){

				}
				outStream.println("");
			}
			outStream.close();
			outFileStream.close();
		} catch (FileNotFoundException ex){
			System.out.println("ERROR - FileNotFoundException. Write Book Failure.");
			return false;
		} catch (IOException ex){
			System.out.println("ERROR - IOException. Write Book Failure.");
			return false;
		}
		System.out.println("END of writeLBTxtFile");
		return true;	
	}
	
}


