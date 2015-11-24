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
	
// Declare data members 
	public char inChar;
	public String inString;
	public int inInt;
	private User user;
	public boolean quit = false;
	
// Constructors 
	Menus(User user) {
		this.user = user;
	}
	

// Methods 
	//Main Menu
	public void mainMenu() {
		while(!quit){
			quit = false;
			switch(user.getUserType()) {
				case "Trainee":
					traineeMenu();
					break;
				case "Trainer":
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
		System.out.println("-----------------------------------------------------");
		System.out.println("------------------ Trainee Menu ---------------------");
		System.out.println("- 1. View the Current Available Courses\t\t    -");
		System.out.println("- 2. Join Training Courses\t\t\t    -");
		System.out.println("- 3. Display Current/completed Courses\t\t    -");
		System.out.println("- 4. Display Targets Set\t\t\t    -");
		System.out.println("- 5. View Personal Infomation\t\t\t    -");
		System.out.println("- 6. General Menu\t\t\t\t    -");
		System.out.println("- 9. Quit the system\t\t\t\t    -");
		System.out.println("-----------------------------------------------------");
		System.out.print(">> Please enter the number: ");
		
		Scanner scanner = new Scanner(System.in);
		inChar = scanner.next().charAt(0);
		
		switch(inChar) {
			case '1':
				System.out.println(">>View the Current Available Courses.");	
				Curriculum.listAvaibleCourse(trainee.upadteTraineeType(),trainee.getUserID());
				pkContinue();
				break;
			case '2':
				System.out.println(">>Join Training Courses.");	
				Curriculum.joinCourse(trainee.upadteTraineeType(),trainee.getUserID());
				pkContinue();
				break;
			case '3':
				System.out.println(">>Display Current/completed Courses.");	
				Curriculum.listCCCourse(trainee.getUserID());
				pkContinue();
				break;
			case '4':
				System.out.println(">>Display Targets Set.");	
				Curriculum.listTarget(trainee.getUserID());
				pkContinue();
				break;
			case '5':
				System.out.println(">>View Personal Infomation.");	
				trainee.printUserInfo();
				pkContinue();
				break;
			case '6':
				System.out.println(">>General Menu.");	
				break;
			case '9':
				System.out.println("You choosed to quit the system. Bye!! ");
				quit = true;
				break;
			default:
				System.out.println(">>Unknown Comment, Please Re-type Again.\n");	
		}
	}
	
	//Trainer Menu
	public void trainerMenu() {
		Trainer trainer = (Trainer) user;
		System.out.println("-----------------------------------------------------");
		System.out.println("------------------ Trainer Menu ---------------------");
		System.out.println("- 1. Owned Courses List\t\t\t\t    -");
		System.out.println("- 2. Courses Enrolled Trainees\t\t\t    -");
		System.out.println("- 3. Courses Complete\t\t\t\t    -");
		System.out.println("- 4. XXXXXXXXXXXXXX\t\t\t\t    -");
		System.out.println("- 5. View Personal Infomation\t\t\t    -");
		System.out.println("- 6. General Menu\t\t\t\t    -");
		System.out.println("- 9. Quit the system\t\t\t\t    -");
		System.out.println("-----------------------------------------------------");
		System.out.print(">> Please enter the number: ");
		
		Scanner scanner = new Scanner(System.in);
		inChar = scanner.next().charAt(0);

		switch(inChar) {
			case '1':
				System.out.println(">>Owned Courses List.");	
				Curriculum.listOwnedCourse(trainer.getUserID());
				pkContinue();
				break;
			case '2':
				System.out.println(">>Courses Enrolled Trainees");	
				//
				pkContinue();
				break;
			case '3':
				System.out.println(">>Courses Complete");
				Curriculum.completeCourse(trainer.getUserID());
				pkContinue();
				break;
			case '4':
				System.out.println(">>XXXXXXXXXXXXXXXX");
				pkContinue();
				break;
			case '5':
				trainer.printUserInfo();
				pkContinue();
				break;
			case '6':
				//General menu
				System.out.println("You choose number 6");
				break;
			case '9':
				System.out.println("You choosed to quit the system. Bye!! ");
				quit = true;
				break;
		}
	}
	
	//Admin Menu
	public void adminMenu() {
		Admin admin = (Admin) user;
		System.out.println("-----------------------------------------------------");
		System.out.println("-------------------- Admin Menu ---------------------");
		System.out.println("- 1. Users Management\t\t\t\t    -");
		System.out.println("- 2. Course Management\t\t\t\t    -");
		System.out.println("- 3. xxxxxxxxxxxxxxxxxxxxxxt\t\t\t    -");
		System.out.println("- 4. xxxxxxxxxxxxxxxxxxxxxx\t\t\t    -");
		System.out.println("- 5. View Personal Infomation\t\t\t    -");
		System.out.println("- 6. General Menu\t\t\t\t    -");
		System.out.println("- 9. Quit the system\t\t\t\t    -");
		System.out.println("-----------------------------------------------------");
		System.out.print(">> Please enter the number: ");

		Scanner scanner = new Scanner(System.in);
		inChar = scanner.next().charAt(0);

		switch(inChar) {
			case '1':
				outerloop:
				while(true){
					System.out.println("================ Users Management Menu ==============");
					System.out.println("= 1. Users Detailed Information\t\t\t    =");
					System.out.println("= 2. Users Searching\t\t\t\t    =");
					System.out.println("= 3. Users editing\t\t\t\t    =");
					System.out.println("= 4. Remove Users\t\t\t\t    =");
					System.out.println("= 5. Create Users\t\t\t\t    =");
					System.out.println("= 9. Return to main menu\t\t\t    =");
					System.out.println("= Enter '-l' for listing all user breif information =");
					System.out.println("=====================================================");
					System.out.print(">> Please enter the number: ");
					inString = scanner.next();
					if(inString.equals("-l"))
						Account.listAll();
					else{
						inChar = inString.charAt(0);
						switch(inChar){
							case '1':
								Account.listAll();
								break;
							case '2':	// Search User =======
								System.out.println("\n= = = = = = Users Searching = = = = = =");
								System.out.println(" Please enter the user type you want to search: ");
								System.out.println("  - 1. trainee");
								System.out.println("  - 2. trainer");
								System.out.println("  - 3. all types of users");
								System.out.println("  - 9. quit");
								System.out.print(" >>> ");
								Account.searchUser(scanner.next().charAt(0));
								break;
							case '3':	// Edit User =========
								System.out.println("\n= = = = = = User Information Editing = = = = = =");
								System.out.print(" Please enter the user name you want to edit: ");
								// temportary no ID 
								inString = scanner.next();
								Account.editUser(inString);
								break;
							case '4':	// Remove User =======
								System.out.println("\n= = = = = = = = = = Deregister = = = = = = = = = =");
								System.out.print(" Please enter the user name or ID you want to remove: ");
								if(scanner.hasNextInt()){	// if enter user ID
									inInt = scanner.nextInt();
									Account.removeUser("", inInt, user);
								} else {					// if enter user name
									inString = scanner.next();
									Account.removeUser(inString, 0, user);
								}
								break;
							case '5':	// Create User =======
								Register register = new Register();
								register.register();	
								break;
							case '9':
								break outerloop;	//break the outerloop -> return main menu
							default:
								System.out.println("Unknown Error.");
						}
						pkContinue();	// press enter key to continue
					}
				}
				break;
			case '2':
				outerloop:
				while(true){
					System.out.println("=============== Course Management Menu ==============");
					System.out.println("= 1. List all the Course\t\t\t    =");
					System.out.println("= 2. Create new course\t\t\t\t    =");
					System.out.println("= 3. Edit course\t\t\t\t    =");
					System.out.println("= 4. Delete course\t\t\t\t    =");
					System.out.println("= 9. Return to main menu\t\t\t    =");
					System.out.println("=====================================================");
					System.out.print(">> Please enter the number: ");
					inString = scanner.next();
					if(inString.equals("-l"))
						Curriculum.listAll();
					else{
						inChar = inString.charAt(0);
						switch(inChar){
							case '1':
								Curriculum.listAll();
								break;
							case '2': 	//Creat new course
								
								break;
							case '3':	//Edit Course
								System.out.println("\n= = = = = = Course Information Editing = = = = = =");
								System.out.print(" Please enter the course name you want to edit: "); 
								inInt = Integer.parseInt(scanner.next());
								Curriculum.editCourse(inInt);
								break;
							case '4':	//Deiete Course =========
								System.out.println("\n= = = = = = Course Deleting = = = = = =");
								System.out.print(" Please enter the course name/ID you want to delete: "); 
								if(scanner.hasNextInt()){	// if enter user ID
									inInt = Integer.parseInt(scanner.next());
									Curriculum.deleteCourse(inInt);
								} else {					// if enter user name
									inString = scanner.next();
									Curriculum.deleteCourse(inInt);
								}
								break;
							case '9':
								break outerloop;	//break the outerloop -> return main menu
							default:
								System.out.println("Unknown Error.");
						}
						pkContinue();	// press enter key to continue
					}
				}
				break;
			case '3':
				System.out.println("XXXXXXXXXXXXXXXXXXX");
				break;
			case '4':
				System.out.println("XXXXXXXXXXXXXXXXXXX");		
				break;
			case '5':
				admin.printUserInfo();
				break;
			case '6':
				//General menu
				System.out.println("You choose number 6");
				break;
			case '9':
				System.out.println("You choosed to quit the system. Bye!! ");
				quit = true;
				break;
		}
	}

	private void pkContinue(){
		System.out.print("Press Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {} 
	}
}
