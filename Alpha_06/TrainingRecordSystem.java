/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* TrainingRecordSystem.java: 
********************************************/

import java.util.Scanner;
import java.util.ArrayList;

interface Files {
	public static final String DEF_COURSE = "Courses.csv";
	public static final String DEF_USER = "Users.csv";
}

public class TrainingRecordSystem implements Files{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        while(true) {
            
			Account.inituserlist();
            Curriculum.initcourselist();

    		System.out.println("*****************************************************");
    		System.out.println("* - - - - Welcome to Training Record System - - - - *");
    		System.out.println("*****************************************************");
            System.out.println("");
    		
    		Login login = new Login(); //login class
            User loginUser = login.login();
            if (login.LoginStatus()) {
                System.out.println(">>> Login in successfully!\n");
            }else{
    			System.out.println(">>> Login unsuccessful! Unknown Error....");
                return; //program end if login fail
    		}
    		
    		Menus menus = new Menus(loginUser);	//menus class
            menus.mainMenu();
    		
    		//Backup
			UserIO.writeUTxtFile(DEF_USER.substring(0,DEF_USER.length() - 4) + "_BackUp.csv", Account.userlist);	
			CourseIO.writeCTxtFile(DEF_COURSE.substring(0,DEF_COURSE.length() - 4) + "_BackUp.csv", Curriculum.courselist);	
			//Write
			UserIO.writeUTxtFile(DEF_USER, Account.userlist);
    		CourseIO.writeCTxtFile(DEF_COURSE, Curriculum.courselist);

            System.out.println(">>> Enter \"-q\" for quit the system; nothing for login other user");
            String inStr;
            inStr = scanner.nextLine();
			
            if(inStr.equals("-q") || inStr.equals("-Q")) {
                System.out.println("\nSYSTEM END.");
                System.out.println("End of program.");
                break;
            }
        }	
	}
}
