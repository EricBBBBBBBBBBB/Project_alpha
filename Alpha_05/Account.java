/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Account > User > Trainer, Trainee, Admin
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Account implements Files{

// Declare data members 
	public static ArrayList<User> userlist = new ArrayList<User>();
	

// Methods 
	//Initialization User List
	public static void inituserlist() {
		userlist = UserIO.readUTxtFile(DEF_USER);
	}
	
	//Update User List
    public static boolean updateuserlist(User user) {
        if(userlist.add(user))
            return true;
        else
            return false;
    }
	
	//Get User List
    public static ArrayList<User> getuserlist() {
        return userlist;
    }
	
	//Remove User by Name
    public static void removeUser(String userName, int uid, User operateUser) {
        int lisuid;
        if(userName.isEmpty())
            lisuid = searchuserlisuid(userName);
        else
            lisuid = searchuserlisuid(uid);

        if(lisuid == -1) {
            System.out.println("user not found!");
        }else if((userlist.get(lisuid).getUserName()).equals(operateUser.getUserName())) {
                System.out.println("You cannot remove yourself!");
        }else if((userlist.get(lisuid).getUserType()).equals("Admin")) {
            System.out.println("You cannot remove an admin-type user!");
        }else{
            System.out.println("Are you sure to remove User [" + userlist.get(lisuid).getUserName() + "]? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            char inChar = scanner.next().charAt(0);
            
            if(inChar == 'Y' || inChar == 'y') {
                userlist.remove(lisuid);
                System.out.println("Removed!");
            } else{
                System.out.println("Unsuccessful, Unknown error!");
            }
        }
    }
	
	
    //Search User by ID (return ArrayList ID)
    public static int searchuserlisuid(int uid) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserID() == uid)
                return i;
        }
        return -1;
    }
	
    //Search User by name (return ArrayList ID) [Require exactly User name for searching]
    public static int searchuserlisuid(String userName) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserName().equals(userName)) 
                return i;
        }
        return -1;
    }

	//Search User 
	public static boolean searchUserReBo(String userName) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserName().equals(userName)) 
                return true;
        }
        return false;
    }
	
    //Search User by Name (return no value)
    public static void searchUser(String userName) {
        System.out.println("There is/are the result(s) of searching: ");
		System.out.println("- ID   User Name");
        System.out.println("===========================================");
        for (int i = 0; i < userlist.size(); i++) {
            if(userlist.get(i).getUserName().contains(userName)) {
                System.out.format( "- %-5d%-20s\n" , userlist.get(i).getUserID(), userlist.get(i).getUserName());
            }
        }
        System.out.println("===========================================");
        System.out.println("Please enter the user ID for detailed Information.");
        System.out.print("(-1) for quit. : ");

        Scanner scanner = new Scanner(System.in);
		String inStr;
        int inInt;
        if(scanner.hasNextInt())
            inInt = scanner.nextInt();
        else
            inInt = -1;

        if(inInt == -1){
            System.out.println(">> quit.");
            return;
        }
        printUserInfo(searchuserlisuid(inInt));
    }


    //Print User Information
    public static void printUserInfo(int lisuid) {
        if(lisuid != -1) {
            userlist.get(lisuid).printUserInfo();
        }else{
            System.out.println("User not found!");
        }
    }

    //Edit User Information
    public static void editUser(String userName) {
        int lisuid = searchuserlisuid(userName);
        if (lisuid != -1) {
            System.out.println("Found the record");
            //userlist.get(lisuid).printUserInfo();
        Scanner scanner = new Scanner(System.in);
            String inStr;
            char inChar;
			
            whileloop:
            while(true) {
                System.out.println("---------------Edit User Information-------------");
                System.out.println("Please select the part you want to edit: ");
                System.out.println("- 1: User Email");
                System.out.println("- 2: User Phone");
                System.out.println("- 3: Other");
                System.out.println("- 8: Show User information");
                System.out.println("- 9: Quit Editing");

                inStr = scanner.next();

                switch(inStr.charAt(0)) {
                    case '1':
                        System.out.println("Please enter the new Email Address (-q for quit without change");
						inStr = scanner.next();
                        if(inStr.equals("-q") || inStr.equals("-Q")) {
                            break;
                        } else {
                            if(IOValidation.emailValid(inStr)) {
                                System.out.println("The previous Email: " + userlist.get(lisuid).getUserEmail());
                                System.out.println("The new Email: " + inStr);
                                System.out.println(">> Are you sure to make change? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    userlist.get(lisuid).setUserEmail(inStr);
                                    System.out.println("The Email is updated!");
                                } else {
                                    System.out.println("Action was cancelled!");
                                }
                            }else{
                                System.out.println("Wrong format");
                            }
                        }
						break;
                    case '2':
						System.out.println("Please enter the new phone number (-q for quit without change");
                        inStr = scanner.next();
                        if(inStr.equals("-q") || inStr.equals("-Q")) {
                            break;
                        } else {
                            if(IOValidation.phoneValid(inStr)) {
                                System.out.println("The previous Phone: " + userlist.get(lisuid).   getUserPhone());
                                System.out.println("The new Phone: " + inStr);
                                System.out.println(">> Are you sure to make chnage? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    userlist.get(lisuid).setUserPhone(inStr);
                                    System.out.println("The Phone number is updated!");
                                } else {
                                    System.out.println("Action was cancelled!");
                                }
                            }else{
                                System.out.println("Wrong format");
                            }
                        }
                        break;
                    case '3':
                        break;
                    case '8':
						userlist.get(lisuid).printUserInfo();
                        break;
                    case '9':
                        break whileloop;
                    default:
                        System.out.println("Unknown command");
                        break whileloop;
                }

            }
        } else {
            System.out.println("No such user");
        }
	}
	
	//List all Users records
	public static void listAll(){
		
		System.out.println("-----------------------------------------------------");
		System.out.println("- ID   User Name           User Type");
		System.out.println("-----------------------------------------------------");
		
		for (int i = 0; i < userlist.size(); i++) {
			if(userlist.get(i) instanceof Trainee) {
				Trainee trainee = (Trainee)userlist.get(i);
				System.out.format( "- %-5d%-20s%s (%s)\n" , userlist.get(i).getUserID(), userlist.get(i).getUserName(), userlist.get(i).getUserType(), trainee.getTraineeType());
			}else  
				System.out.format( "- %-5d%-20s%s\n" , userlist.get(i).getUserID(), userlist.get(i).getUserName(), userlist.get(i).getUserType());
		}
		System.out.println("-----------------------------------------------------\n");

	}
	
}
