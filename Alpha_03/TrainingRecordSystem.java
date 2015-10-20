/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* TrainingRecordSystem.java: 
********************************************/

import java.util.Scanner;

public class TrainingRecordSystem {

    //public Users loginUser = new Users();

	public static void main(String[] args) {
		System.out.println("***********************************");
		System.out.println(" Welcome to Training Record System ");
		System.out.println("***********************************");
		
		Login login = new Login(); //login
        Users loginUser = login.login();

        loginUser.getUserInf();  // for test only

        if (!login.LoginStatus() || (loginUser.getUserName().equals("Unknown"))) {
            System.out.println("Login unsuccessful! Unknown Error....");
            return; //close the application
        }

		
        // Menu
        //Menus.mainMenu(loginUser);
        //Menus menu = new Menus(loginUser);
		
	}
}
