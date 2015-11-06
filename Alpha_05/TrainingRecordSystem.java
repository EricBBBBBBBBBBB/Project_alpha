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
        Account.initMyList();
        // Load Courses information - *For test only*
        Courses[] courses = {
            new Courses("Learn How to Fuck Eric Fung"),
            new Courses("Eric BB")
        };

		System.out.println("*****************************************************");
		System.out.println("* - - - - Welcome to Training Record System - - - - *");
		System.out.println("*****************************************************");
        System.out.println("");

        System.out.println("");

		Login login = new Login(); //login
        Users loginUser = login.login();

        //loginUser.getUserInfo();  // for test only

        if (!login.LoginStatus() || (loginUser.getUserName().equals("Unknown"))) {
            System.out.println("Login unsuccessful! Unknown Error....");
            return; //close the application
        }

		Menus menus = new Menus(loginUser);
        menus.mainMenu();

        System.out.println("");
        System.out.println("");
        System.out.println("");

        //courses[0].getCourseInfo();
        //System.out.println("");
        //courses[1].getCourseInfo();
	}
}
