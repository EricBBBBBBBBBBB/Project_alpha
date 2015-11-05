/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Menus.java: 
********************************************/
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;	// import statement here

class Menus{
	public char inChar;
	public Users user;
    private ArrayList<Users> myList = new ArrayList<Users>();
	//data members
	
	
	//constructors
	Menus(Users user) {
		this.user = user;
	}
	
	
	
	//methods
	public void mainMenu() {
		switch(user.getUserType()) {
			case 0:
				traineeMenu();
				break;
			case 1:
				trainerMenu();
				break;
			case 2:
				adminMenu();
				break;
			default:
				System.out.println("Unknown Comment");
		}
	}

	public void traineeMenu() {

		System.out.println("------- Trainee Menu -------");
		System.out.println("1. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("2. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("3. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("4. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("5. General Menu");
		System.out.println("Enter q for quit.");
		Scanner scanner = new Scanner(System.in);

        //if (scanner.hasNext())
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
				System.out.println("You choose number 5");
				break;
			case 'Q':
			case 'q':
				System.out.println("You choose Q ");
				break;
		}

		scanner.close();
	}

		public void trainerMenu() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("------- Trainer Menu -------");
		System.out.println("1. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("2. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("3. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("4. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("5. General Menu");
		System.out.println("Enter q for quit.");


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
				System.out.println("You choose number 5");
				break;
			case 'Q':
			case 'q':
				System.out.println("You choose Q ");
				break;
		}

		//scanner.close();
	}

	public void adminMenu() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("------- Admin Menu -------");
		System.out.println("1. List All Users");
		System.out.println("2. Remove Users");
		System.out.println("3. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("4. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("5. General Menu");
		System.out.println("Enter q for quit.");


		inChar = scanner.next().charAt(0);

		switch(inChar) {
			case '1':
				myList = Account.getMyList();		//update My List
				System.out.println("UserID\tUserName\tUserType");
				for (int i = 0; i < myList.size(); i++) {
					System.out.println(	myList.get(i).getUserID() + "\t" +
										myList.get(i).getUserName() + "\t" +
										myList.get(i).getUserType());
				}
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
				System.out.println("You choose number 5");
				break;
			case 'Q':
			case 'q':
				System.out.println("You choose Q ");
				break;
		}

		scanner.close();
	}
}

/*General
	-Change Personal Information
	-
*/

/*Trainee
	-Browse crrent available courses (from Courses.java)
	-
*/

/*Trainer
	-
	-
*/

/*Admin
	-
	-
*/
