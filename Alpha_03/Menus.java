/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Menus.java: 
********************************************/
import java.io.*;
import java.util.*;

class Menus{
	
	//data members
	public char inChar;
	public Users user;
	
	//constructors
	Menus(Users user) {
		this.user = user;
	}
	
	//methods
	public void mainMenu() {
		switch(user.getUserType()) {
			case "Tarinee":
				traineeMenu();
				break;
			case "Tariner":
				traineeMenu();
				break;
			case "Admin":
				traineeMenu();
				break;
			default:
				System.out.println("Unknown Comment");
		}
	}

	public void traineeMenu() {
		
		Scanner in = new Scanner(System.in);

		System.out.println("------- " + user.getUserType() + " Menu -------");
		System.out.println("1. Self-Register");
		System.out.println("2. Browse current training courses");
		System.out.println("3. Join training courses");
		System.out.println("4. Display training courses");
		System.out.println("5. General Menu");
		System.out.println("Enter q for quit.");
	
		
		inChar = in.next().charAt(0);

		switch(inChar) {
			case '1':
				user.register();
				break;
			case '2':
				user.browseCourse();
				break;
			case '3':
				user.joinCourse();
				break;
			case '4':
				user.displayCourse();
				break;
			case '5':
				System.out.println("You choose number 5");
				break;
			case 'Q':
			case 'q':
				System.out.println("You choose Q ");
				break;
		}

		in.close();
	}
	
}
