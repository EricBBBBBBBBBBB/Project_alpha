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
    private ArrayList<User> UserList = new ArrayList<User>();
	
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
					System.out.println("Unknown Comment");
			}
		}
		
	}

	//Trainee Menu
	public void traineeMenu() {
		Trainee trainee = (Trainee) user;
		System.out.println("------- Trainee Menu -------");
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
		System.out.println("1. List All Users");
		System.out.println("2. Remove Users");
		System.out.println("3. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("4. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("5. View Personal Infomation");
		System.out.println("6. General Menu");
		System.out.println("Enter q for quit.");

		Scanner scanner = new Scanner(System.in);
		inChar = scanner.next().charAt(0);

		switch(inChar) {
			case '1':
				admin.listallRecords();
				break;
			case '2':
				admin.deregister();
				break;
			case '3':
				admin.AddCourses();
				break;
			case '4':
				admin.DelCourses();
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
