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
	
	//data members
	public char inChar;
	public Users user;
	public boolean quit = false;
    private ArrayList<Users> myList = new ArrayList<Users>();
	
	//constructors
	Menus(Users user) {
		this.user = user;
	}
	
	//methods
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

			System.out.println("------- Trainee Menu -------");
			System.out.println("1. xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("2. xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("3. xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("4. xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("5. General Menu");
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
					System.out.println("You choose number 5");
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
			

			System.out.println("------- Trainer Menu -------");
			System.out.println("1. xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("2. xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("3. xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("4. xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("5. General Menu");
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
					System.out.println("You choose number 5");
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
			

			System.out.println("------- Admin Menu -------");
			System.out.println("1. List All Users");
			System.out.println("2. Remove Users");
			System.out.println("3. xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("4. xxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("5. General Menu");
			System.out.println("Enter q for quit.");

			Scanner scanner = new Scanner(System.in);
			inChar = scanner.next().charAt(0);

			switch(inChar) {
				case '1':
					listallRecords();
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
					System.out.println("You choosed to quit the system. Bye!! ");
					quit = true;
					scanner.close();
					break;
			}
		}
	
	//Trainee methods
		public void register(){
			System.out.println(" Self-Register\n");
		}
		
		public void browseCourse(){
			System.out.println(" Browse Course\n");
		}
		
		public void joinCourse(){
			System.out.println(" Join Course\n");
		}
		
		public void displayCourse(){
			
		}
	
	
	//Trainer methods
		public void listCourse(){
			System.out.println(" List\n");
		}
		
		public void displayRecords(){
			System.out.println(" Display records\n");
		}
		
		public void gradePerformance(){
			System.out.println(" Grade performance\n");
		}
	
	
	//Admin methods
		public void deregister(){
			System.out.println(" Deregister\n");
		}
		
		public void listallRecords(){
			myList = Account.getMyList();		//update My List
			System.out.println("--------------------------------");
			System.out.println("UserID\tUserName\tUserType");
			System.out.println("--------------------------------");
			for (int i = 0; i < myList.size(); i++) {
				System.out.println(	myList.get(i).getUserID() + "\t" + myList.get(i).getUserName() + "\t\t" + myList.get(i).getUserType());
			}
			System.out.println("--------------------------------\n");
		}
		
		public void AddCourses(){
			System.out.println(" Create Courses \n");
		}
		
		public void DelCourses(){
			System.out.println(" Delete Courses \n");
		}
}
