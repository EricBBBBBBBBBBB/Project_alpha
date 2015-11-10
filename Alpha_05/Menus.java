/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Menus.java: 
********************************************/
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

class Menus{
	
// Declare data members //////////////////////////
	public char inChar;
	public String inString;
	public User user;
	public boolean quit = false;
	
// Constructors //////////////////////////
	Menus(User user) {
		this.user = user;
	}
	

// Methods //////////////////////////
	//Main Menu
	public void mainMenu() {
		
		while(!quit){
			quit = false;
			switch(user.getUserType()) {
				case "Tarinee":
					traineeMenu();
					break;
				case "Tariner":
					trainerMenu();
					break;
				case "Admin":
					adminMenu();
					break;
				default:
					System.out.println("Unknown Comment, Please Restart The System.");
			}
		}
		
	}

	//Trainee Menu
	public void traineeMenu() {
		Trainee trainee = (Trainee) user;
		System.out.println("------------ Trainee Menu ---------------");
		System.out.println("- 1. View the Current Available Courses -");
		System.out.println("- 2. Join Training Courses");
		System.out.println("- 3. Display Current/Completed Courses  -");
		System.out.println("- 4. Display Targets Set             -");
		System.out.println("- 5. View Personal Infomation           -");
		System.out.println("- 6. General Menu						-");
		System.out.println("Enter q for quit.");
		
		Scanner scanner = new Scanner(System.in);
		inChar = scanner.next().charAt(0);
		
		switch(inChar) {
			case '1':
				Curriculum.listAvaibleCourse();
				break;
			case '2':
				Curriculum.JoinCourse(trainee);
				break;
			case '3':
				System.out.println("You choose number 3");
				break;
			case '4':
				System.out.println("You choose number 4");
				break;
			case '5':
				trainee.printUserInfo();
				break;
			case '6':
				System.out.println("You choose number 6");
				break;
			case 'Q':
			case 'q':
				System.out.println("You choosed to quit the system. Bye!! ");
				quit = true;
				scanner.close();
				break;
		}
	}
	
	//Trainer Menu
	public void trainerMenu() {
		Trainer trainer = (Trainer) user;
		System.out.println("------- Trainer Menu -------");
		System.out.println("1. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("2. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("3. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("4. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("5. View Personal Infomation");
		System.out.println("6. General Menu");
		System.out.println("Enter q for quit.");

		Scanner scanner = new Scanner(System.in);
		inChar = scanner.next().charAt(0);

		switch(inChar) {
			case '1':
				System.out.println("You choose number 1");
				break;
			case '2':
				System.out.println("You choose number 2");
				break;
			case '3':
				System.out.println("You choose number 3");
				break;
			case '4':
				System.out.println("You choose number 4");
				break;
			case '5':
				trainer.printUserInfo();
				break;
			case '6':
				System.out.println("You choose number 6");
				break;
			case 'Q':
			case 'q':
				System.out.println("You choosed to quit the system. Bye!! ");
				quit = true;
				scanner.close();
				break;
		}
	}
	
	//Admin Menu
	public void adminMenu() {
		Admin admin = (Admin) user;
		System.out.println("------- Admin Menu -------");
		System.out.println("1. Users setting");
		System.out.println("2. List All Courses");
		System.out.println("3. Remove Users");
		System.out.println("4. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("5. View Personal Infomation");
		System.out.println("6. General Menu");
		System.out.println("Enter q for quit.");

		Scanner scanner = new Scanner(System.in);
		inChar = scanner.next().charAt(0);

		switch(inChar) {
			case '1':
				while(true){
					System.out.print("\033[2J");
					System.out.println("===== Users setting Menu =====");
					System.out.println("enter -l for listing all user breif information");
					System.out.println("enter -q for quit");
					System.out.println("1. All Users Detailed Information");
					System.out.println("2. Users Searching");
					System.out.println("3. Users editing");



					inString = scanner.next();
					if(inString.equals("-l"))
						Account.listAll();
					else
						inChar = inString.charAt(0);
						switch(inChar){

						}
					break;
				}
				break;
			case '2':
				Curriculum.listAll();
				break;
			case '3':
				Account.deregister();
				break;
			case '4':
				Curriculum.DelCourse();
				break;
			case '5':
				admin.printUserInfo();
				break;
			case '6':
				System.out.println("You choose number 6");
				break;
			case 'Q':
			case 'q':
				System.out.println("You choosed to quit the system. Bye!! ");
				quit = true;
				scanner.close();
				break;
		}
	}
}
