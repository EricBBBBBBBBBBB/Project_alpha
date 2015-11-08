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
        System.out.println("\n");

		Login login = new Login(); //login class
        User loginUser = login.login();
        if (!login.LoginStatus()) {
            System.out.println("Login unsuccessful! Unknown Error....");
            return; //program end if login fail
        }

		Menus menus = new Menus(loginUser);	//menus class
        menus.mainMenu();

		System.out.println("SYSTEM END.");
		System.out.println("End of program.");

	}
}
