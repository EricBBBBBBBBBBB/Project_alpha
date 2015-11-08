/********************************************
* Student: FUNG K.K. Eric (10614373), HDIT
* Couse: OOP 2015 Sem 1
*
* 
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Admin extends User{

// Declare data members //////////////////////////
	public static int totalNoOfAdmin = 0;  // class data member

// Constructors //////////////////////////
	Admin(String name) {
		super(name, 2);	//call superclass constructor
	}
	
	Admin(String name, String pw) {
		super(name, pw, 2);	//call superclass constructor
	}

// Methods //////////////////////////
	// Remove register
	public void deregister(){
		
		String inString;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(" Deregister\n");
		System.out.print(" Please enter the user name you want to remove: ");
		inString = scanner.next();

		if(Account.removeUser(inString))
			System.out.println("The user " + inString + "is removed");
		else
			System.out.println("Error");
	}
	
	public void listallRecords(){
		
		ArrayList<User> UserList = new ArrayList<User>();
		UserList = Account.getUserList();		
		
		System.out.println("--------------------------------");
		System.out.println("UserID\tUserName\tUserType");
		System.out.println("--------------------------------");
		
		for (int i = 0; i < UserList.size(); i++) {
			System.out.println(	UserList.get(i).getUserID() + "\t" + UserList.get(i).getUserName() + "\t\t" + UserList.get(i).getUserType());
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