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

public class Account{

// Declare data members (To save the User Infomation without FileIOSystem)
    public static ArrayList<User> UserList = new ArrayList<User>();

// Methods 


//Initialization User List
    public static void initUserList() {       
        UserList.add(new Trainee("e1", "e"));
        UserList.add(new Trainee("e2", "e"));
        UserList.add(new Trainee("e3", "e"));
        UserList.add(new Trainee("Donny", "don"));
        UserList.add(new Trainer("r1", "r"));
        UserList.add(new Trainer("r2", "r"));
        UserList.add(new Trainer("Fred", "red"));
        UserList.add(new Trainer("Eric", "ric"));
        UserList.add(new Admin("adm", "a"));
        UserList.add(new Admin("Peter", "pe"));
    }
	
	//Update User List
    public static boolean updateUserList(User user) {
        if(UserList.add(user))
            return true;
        else
            return false;
    }
	
	//Get User List
    public static ArrayList<User> getUserList() {
        return UserList;
    }
	
	//Remove User by Name
    public static void removeUser(String userName, int uid, User operateUser) {
        int listID;
        if(userName.isEmpty())
            listID = searchUserListID(userName);
        else
            listID = searchUserListID(uid);

        if(listID == -1) {
            System.out.println("user not found!");
        }else if((UserList.get(listID).getUserName()).equals(operateUser.getUserName())) {
                System.out.println("You cannot remove yourself!");
        }else if((UserList.get(listID).getUserType()).equals("Admin")) {
            System.out.println("You cannot remove an admin-type user!");
        }else{
            System.out.println("Are you sure to remove User [" + UserList.get(listID).getUserName() + "]? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            char inChar = scanner.next().charAt(0);
            
            if(inChar == 'Y' || inChar == 'y') {
                UserList.remove(listID);
                System.out.println("Removed!");
            } else{
                System.out.println("Unsuccessful, Unknown error!");
            }
        }
    }
	
	
    //Search User by ID (return ArrayList ID)
    public static int searchUserListID(int uid) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getUserID() == uid)
                return i;
        }
        return -1;
    }
	
    //Search User by name (return ArrayList ID) [Require exactly User name for searching]
    public static int searchUserListID(String userName) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getUserName().equals(userName)) 
                return i;
        }
        return -1;
    }

    //Search User by Name (return no value)
    public static void searchUser(String userName) {
        System.out.println("There is/are the result(s) of searching: ");
        System.out.println("ID\tUsername");
        System.out.println("===========================================");
        for (int i = 0; i < UserList.size(); i++) {
            if(UserList.get(i).getUserName().contains(userName)) {
                System.out.println(UserList.get(i).getUserID() +"\t"+UserList.get(i).getUserName());
            }
        }
        System.out.println("===========================================");
        System.out.println("Please enter the user ID for detailed Information.");
        System.out.print("(-1) for quit. : ");

        Scanner scanner = new Scanner(System.in);
        String inStr;
        //String inString = scanner.next();
        int inInt;
        if(scanner.hasNextInt())
            inInt = scanner.nextInt();
        else
            inInt = -1;

        if(inInt == -1){
            System.out.println(">> quit.");
            return;
        }
        printUserInfo(searchUserListID(inInt));
    }

    //SearchList
    public static void searching() {
       
    }


    //Print User Information
    public static void printUserInfo(int listID) {
        if(listID != -1) {
            UserList.get(listID).printUserInfo();
        }else{
            System.out.println("user not found!");
        }
    }

    //Edit User Information
    public static void editUser(String userName) {
        int listID = searchUserListID(userName);
        if (listID != -1) {
            System.out.println("Found the record");
            //UserList.get(listID).printUserInfo();

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
                System.out.println("- 8: Show the information");
                System.out.println("- 9: Quit Editing");

                inStr = scanner.next();

                switch(inStr.charAt(0)) {
                    case '1':
                        System.out.println("Please enter the new Email Address (-q for quit without save");
                        inStr = scanner.next();
                        if(inStr.equals("-q") || inStr.equals("-Q")) {
                            break;
                        } else {
                            if(IOValidation.emailValid(inStr)) {
                                System.out.println("The previous Email: " + UserList.get(listID).getUserEmail());
                                System.out.println("The new Email: " + inStr);
                                System.out.println(">> Are you sure to make change? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    UserList.get(listID).setUserEmail(inStr);
                                    System.out.println("The Email is updated!");
                                } else {
                                    System.out.println("Action was cancelled!");
                                }
                            }else{
                                System.out.println("格式不乎");
                            }
                        }
                        break;
                    case '2':
                        break;
                    case '3':
                        break;
                    case '8':
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
		
		System.out.println("--------------------------------");
		System.out.println("UserID\tUserName\tUserType");
		System.out.println("--------------------------------");
		
		for (int i = 0; i < UserList.size(); i++) {
			System.out.println(	UserList.get(i).getUserID() + "\t" + UserList.get(i).getUserName() + "\t\t" + UserList.get(i).getUserType());
		}
		System.out.println("--------------------------------\n");

	}
	
}
