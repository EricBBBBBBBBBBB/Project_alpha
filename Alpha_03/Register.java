/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* Register.java: 
********************************************/

import java.util.Scanner;


class Register {
	Register() {

	}

	public void register() {
		String inUserName, inPassword, inEmail, inPhone, inStr;

		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------------------------------------------------");
        System.out.println("-                  User Register                    -");
        System.out.println("-----------------------------------------------------");
        System.out.println("Please enter the information requested completely!");
        System.out.print("Name: ");
        while((inUserName = scanner.nextLine()).isEmpty()){
        	System.out.print("User name could not be empty! Please enter again: ");
        }
        System.out.print("Password: ");
        while((inPassword = scanner.nextLine()).isEmpty()){
        	System.out.print("Password could not be empty! Please enter again: ");
        }
        System.out.print("E-mail: ");
        while((inEmail = scanner.nextLine()).isEmpty()){
        	System.out.print("User name could not be empty! Please enter again: ");
        }
        System.out.print("Phone: ");
        while((inPhone = scanner.nextLine()).isEmpty()){
        	System.out.print("User name could not be empty! Please enter again: ");
        }

        System.out.println("#####################################################");
        System.out.println("# Please check the information correctly");
        System.out.println("#   Your user name: " + inUserName);
        System.out.println("#   Your E-mail: " + inEmail);
        System.out.println("#   Your Phone: " + inPhone);
        System.out.println("#####################################################");
        System.out.println(" **** Please Enter : register to create user ****");
        System.out.print("(register): ");

        if((inStr = scanner.nextLine()).equals("register")){
			System.out.println("-----------------------------------------------------");
	        System.out.println("-                                                   -");
	        System.out.println("-      Your user is created! Please login..         -");
        	System.out.println("-                                                   -");
        	System.out.println("-----------------------------------------------------");
        } else {
			System.out.println("-----------------------------------------------------");
	        System.out.println("-                                                   -");
	        System.out.println("-             The action is Canceled!               -");
        	System.out.println("-                                                   -");
        	System.out.println("-----------------------------------------------------");
        }
	}
}