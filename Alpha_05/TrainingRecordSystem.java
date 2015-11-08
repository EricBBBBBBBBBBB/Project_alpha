/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* TrainingRecordSystem.java: 
********************************************/

import java.util.Scanner;
import java.util.ArrayList;

public class TrainingRecordSystem {

	public static void main(String[] args) {
        // Load Users Information
        Account.initUserList();
        // Load Courses information 

		System.out.println("*****************************************************");
		System.out.println("* - - - - Welcome to Training Record System - - - - *");
		System.out.println("*****************************************************");
        System.out.println("");

        System.out.println("");

		Login login = new Login(); //login
        User loginUser = login.login();


        if (!login.LoginStatus() || (loginUser.getUserName().equals("Unknown"))) {
            System.out.println("Login unsuccessful! Unknown Error....");
            return; //close the application
        }

		Menus menus = new Menus(loginUser);
        menus.mainMenu();

        System.out.println("");
		System.out.println("SYSTEM END.");
		System.out.println("End of program.");

	}
}
