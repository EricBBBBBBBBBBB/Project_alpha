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

public class Account {

// Declare data members //////////////////////////(To save the User Infomation without FileIOSystem)
    public static ArrayList<User> UserList = new ArrayList<User>(); 


// Methods //////////////////////////
	//Initialization User List
    public static void initUserList() {       
        UserList.add(new Trainee("e1", "e"));
        UserList.add(new Trainee("e2", "e"));
        UserList.add(new Trainee("e3", "e"));
        UserList.add(new Trainer("r1", "r"));
        UserList.add(new Trainer("r2", "r"));
        UserList.add(new Admin("adm", "a"));
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

	//Remove User by ID
    public static boolean removeUser(int listID) {
        return true;
    }
	
	//Remove User by Name
    public static boolean removeUser(String userName) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getUserName().equals(userName)) {
                UserList.remove(i);
                return true;
            }
        }
        return false;
    }
	
	// Remove register
	public static void deregister(){
		
		String inString;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(" Deregister\n");
		System.out.print(" Please enter the user name you want to remove: ");
		inString = scanner.next();

		if(removeUser(inString))
			System.out.println("The user " + inString + " is removed");
		else
			System.out.println("Error");
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
