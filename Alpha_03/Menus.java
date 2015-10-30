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
				trainerMenu();
				break;
			case "Admin":
				adminMenu();
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
				register();
				break;
			case '2':
				browseCourse();
				break;
			case '3':
				joinCourse();
				break;
			case '4':
				displayCourse();
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
	
	public void trainerMenu() {
		Scanner in = new Scanner(System.in);

		System.out.println("------- " + user.getUserType() + " Menu -------");
		System.out.println("1. List");
		System.out.println("2. Display records");
		System.out.println("3. Grade performance");
		System.out.println("Enter q for quit.");
	
		inChar = in.next().charAt(0);
		switch(inChar) {
			case '1':
				listCourse();
				break;
			case '2':
				displayRecords();
				break;
			case '3':
				gradePerformance();
				break;
			case 'Q':
			case 'q':
				System.out.println("You choose Q ");
				break;
		}
		in.close();
	}
	
	public void adminMenu() {
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
				register();
				break;
			case '2':
				browseCourse();
				break;
			case '3':
				joinCourse();
				break;
			case '4':
				displayCourse();
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
	
	
	//Trainee methods
		public void register(){
			System.out.println(user.userID + " Self-Register");
		}
		
		public void browseCourse(){
			System.out.println(user.userName + " Browse Course");
		}
		
		public void joinCourse(){
			System.out.println(user.email + " Join Course");
		}
		
		public void displayCourse(){
			
		}
	
	
	//Trainer methods
		public void listCourse(){
			System.out.println(user.userID + " List");
		}
		
		public void displayRecords(){
			System.out.println(user.userName + " Display records");
		}
		
		public void gradePerformance(){
			System.out.println(user.email + " Grade performance");
		}
	
	
	//Admin methods
		public void deregister(){
			System.out.println(user.userID + " Deregister");
		}
		
		public void listallRecords(){
			System.out.println(user.userID + " List all records ");
		}
		
		public void AddCourses(){
			System.out.println(user.userID + " Create Courses ");
		}
		
		public void DelCourses(){
			System.out.println(user.userID + " Delete Courses ");
		}
}
