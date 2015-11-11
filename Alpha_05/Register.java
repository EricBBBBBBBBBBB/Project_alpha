/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* Register.java: 
********************************************/

import java.util.Scanner;


class Register {
	public void register() {
		
		String inUserName, inPassword, inEmail, inPhone, inStr;

		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------------------------------------------------");
        System.out.println("-                  User Register                    -");
        System.out.println("-----------------------------------------------------");
        System.out.println("Please enter the information requested completely!");
		System.out.println(">>>Rules for a valid Login ID for a user account:");
		System.out.println("\tLogin ID must contain: ");
		System.out.println("\t\t- 8~12 characters");
		System.out.println("\t\t- Just LOWER-CASE letters");
		System.out.println("\t\t- no starting with digit");
        System.out.println("\tPassword must contain: ");
        System.out.println("\t\t- 8~12 characters");
        System.out.println("\t\t- letters and digit");
        System.out.print("Name: ");
        while(!IOValidation.usernameValid(inUserName = scanner.nextLine())){
        	System.out.print("User name could not be empty! Please enter again: ");
        }
        System.out.print("Password: ");
        while(!IOValidation.passwordValid(inPassword = scanner.nextLine())){
        	System.out.print("Password could not be empty! Please enter again: ");
        }
        System.out.print("E-mail: ");
        while(!IOValidation.emailValid(inEmail = scanner.nextLine())){
        	System.out.print("Email could not be empty! Please enter again: ");
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
        System.out.println(" **** Please Enter : 'Y' to create user ****");
        System.out.print("(Y / N): ");

        if((inStr = scanner.nextLine()).equals("Y") || inStr.equals("y")){
			Trainee trainee = new Trainee(inUserName, inPassword);
			trainee.setUserEmail(inEmail);
			trainee.setUserPhone( Integer.parseInt(inPhone));
     		System.out.println(Account.updateUserList(trainee));
			
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