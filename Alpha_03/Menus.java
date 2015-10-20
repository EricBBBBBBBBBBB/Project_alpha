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
	//public char inChar;
	//data members
	
	
	//constructors
	Menus() {

	}
	
	
	
	//methods
	public static void mainMenu(Users user) {
		switch(user.getUserType()) {
			case 0:
				traineeMenu(user);
				break;
			case 1:
				System.out.println("trainer Menu");
				break;
			case 2:
				System.out.println("admin Menu");
				break;
			default:
				System.out.println("Unknown Comment");
		}
	}

	public static void traineeMenu(Users user) {
		char inChar;
		Scanner in = new Scanner(System.in);

		System.out.println("------- Trainee Menu -------");
		System.out.println("1. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("2. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("3. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("4. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("5. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("6. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("7. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("8. xxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("9. General Menu");
		System.out.println("Enter q for quit.");


		inChar = in.next().charAt(0);

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
			case '6':
				System.out.println("You choose number 6");
				break;
			case '7':
				System.out.println("You choose number 7");
				break;
			case '8':
				System.out.println("You choose number 8");
				break;
			case '9':
				System.out.println("You choose number 9");
				break;
			case 'Q':
			case 'q':
				System.out.println("You choose Q ");
				break;
		}

		in.close();
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
