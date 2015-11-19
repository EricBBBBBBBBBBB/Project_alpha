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
        int listID;
        if(userName.isEmpty())
            listID = searchuserlistID(userName);
        else
            listID = searchuserlistID(uid);

        if(listID == -1) {
            System.out.println("user not found!");
        }else if((userlist.get(listID).getUserName()).equals(operateUser.getUserName())) {
                System.out.println("You cannot remove yourself!");
        }else if((userlist.get(listID).getUserType()).equals("Admin")) {
            System.out.println("You cannot remove an admin-type user!");
        }else{
            System.out.println("Are you sure to remove User [" + userlist.get(listID).getUserName() + "]? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            char inChar = scanner.next().charAt(0);
            
            if(inChar == 'Y' || inChar == 'y') {
                userlist.remove(listID);
                System.out.println("Removed!");
            } else{
                System.out.println("Unsuccessful, Unknown error!");
            }
        }
    }
	
	
    //Search User by ID (return ArrayList ID)
    public static int searchuserlistID(int uid) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserID() == uid)
                return i;
        }
        return -1;
    }
	
    //Search User by name (return ArrayList ID) [Require exactly User name for searching]
    public static int searchuserlistID(String userName) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserName().equals(userName)) 
                return i;
        }
        return -1;
    }

	// Search User by Name (return boolean if yes)
	public static boolean searchUserReBo(String userName) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserName().equals(userName)) 
                return true;
        }
        return false;
    }
	
    //Search User by Name (return no value)
    public static void searchUser(char userTypeC) {
        int userType = 0;
        int totSearchNum = 0;
        int inInt;
        String inStr;
        switch(userTypeC) {
            case '1':
                System.out.print("Please enter the user name of trainee: ");
                userType = 1;
                break;
            case '2':
                System.out.print("Please enter the user name of trainer: ");
                userType = 2;
                break;
            case '3':
                System.out.print("Please enter the user name: ");
                userType = 3;
                break;
            case '9':
                return;
            default:
                System.out.println("Unknown error");
                return;
        }
        Scanner scanner = new Scanner(System.in);
        inStr = scanner.next();
        System.out.println("= = = = = = Searching Result(s) = = = = = =");
        System.out.println("- ID   User Name");
        System.out.println("===========================================");
        totSearchNum = searching(inStr, userType);
        System.out.println("There are " + totSearchNum + " result(s)");
        System.out.println("===========================================");

        if(totSearchNum > 0) {
            while(true) {
                System.out.println("Please enter the user ID for detailed Information.");
                System.out.print("(-1) for quit. : ");
                if(scanner.hasNextInt())
                    inInt = scanner.nextInt();
                else
                    inInt = -1;

                if(inInt == -1){
                    System.out.println(">> quit.");
                    break;
                }
                printUserInfo(searchuserlistID(inInt));
            }
        }
    }

    //SearchList
    public static int searching(String userName, int userType) {
        int total = 0;
        for (int i = 0; i < userlist.size(); i++) {
            if(userlist.get(i).getUserName().contains(userName)) {
                System.out.format( "- %-5d%-20s\n" , userlist.get(i).getUserID(), userlist.get(i).getUserName());
                total++;
            }
        }
        return total;
    }


    //Print User Information
    public static void printUserInfo(int listID) {
        if(listID != -1) {
            userlist.get(listID).printUserInfo();
        }else{
            System.out.println("User not found!");
        }
    }

    //Edit User Information
    public static void editUser(String userName) {
        int listID = searchuserlistID(userName);
        if (listID != -1) {
            System.out.println("Found the record");
            //userlist.get(listID).printUserInfo();
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
                                System.out.println("The previous Email: " + userlist.get(listID).getUserEmail());
                                System.out.println("The new Email: " + inStr);
                                System.out.println(">> Are you sure to make change? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    userlist.get(listID).setUserEmail(inStr);
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
                                System.out.println("The previous Phone: " + userlist.get(listID).   getUserPhone());
                                System.out.println("The new Phone: " + inStr);
                                System.out.println(">> Are you sure to make chnage? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    userlist.get(listID).setUserPhone(inStr);
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
						userlist.get(listID).printUserInfo();
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
