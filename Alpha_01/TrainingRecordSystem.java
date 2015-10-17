/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* TrainingRecordSystem.java: 
********************************************/

import java.io.*;
import java.util.Scanner;

public class TrainingRecordSystem {

	public static void main(String[] args) {

		String userName;
		String password;
		int userID;

		boolean success = false;

		// Load user information - *For test only*
		Users[] users = {
			new Users("e1", "e", "trainee"),
			new Users("e2", "e", "trainee"),
			new Users("e3", "e", "trainee"),

			new Users("r1", "r", "trainer"),
			new Users("r2", "r", "trainer"),

			new Users("adm", "a", "admin")
		};

		System.out.println("***********************************");
		System.out.println(" Welcome to Training Record System");
		System.out.println("***********************************");
		
		Scanner scanner = new Scanner(System.in);
		
		do{
			//input username & password
			System.out.print("Please enter your user name: ");
			while ((userName = scanner.nextLine()).isEmpty()){
				System.out.print("User name cannot be empty, Please enter again: ");
			} 
			System.out.print("Please enter your password: ");
			while ((password = scanner.nextLine()).isEmpty()){
				System.out.print("Password cannot be empty, Please enter again: ");
			} 
			//CryptWithMD5 CMD5 = new CryptWithMD5();
			password = CryptWithMD5.cryptWithMD5(password);

			//User validate
			for (int i = 0; i < users.length; i++) {
				if(users[i].validateUser(userName, password)){
					success = true;
					userID = users[i].getUserID();
					userName = users[i].getUserName();
					System.out.println("\nLogin in successfully!");
					System.out.println("The ID is " + userID);
					break;
				}
			}
			if(!success)
				System.out.println("\nLogin fail, please login again.");
			
		}while(!success);		//repeat when login fail
		
		// menu for users
		

		scanner.close();

	}
}
