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
    public static void removeUser(int uid) {
        int listID = searchUser(uid);
        if(listID != -1) {
            removeUserConfirm(listID);
        }else{
            System.out.println("user not found!");
        }
    }
	
	//Remove User by Name
    public static void removeUser(String userName) {
        int listID = searchUser(userName);
        if(listID != -1) {
            removeUserConfirm(listID);
        }else{
            System.out.println("user not found!");
        }
    }

    public static void removeUserConfirm(int listID) {
        System.out.println("Are you sure to remove User [" + UserList.get(listID).getUserName() + "]? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        char inChar = scanner.next().charAt(0);
            if(inChar == 'Y' || inChar == 'y') {
                UserList.remove(listID);
                System.out.println("Remove凸!");
            } else{
                System.out.println("Unsuccessful, Unknown error!");
            }
        }

    //Search User by ID (return ArrayList ID)
    public static int searchUser(int uid) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getUserID() == uid) {
                return i;
            }
        }
        return -1;
    }

    //Search User by Name (return ArrayList ID)
    public static int searchUser(String userName) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
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
