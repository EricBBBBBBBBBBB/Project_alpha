/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* Login.java: 
********************************************/

import java.io.*;
import java.util.Scanner;


class Login{
	
	//data members
	private boolean loginSuccess = false;
	private int userID;
	private String userName;
	private String password;

	
	// Load user information - *For test only*
	Users[] users = {
		new Users("e1", "e", "trainee"),
		new Users("e2", "e", "trainee"),
		new Users("e3", "e", "trainee"),
		new Users("r1", "r", "trainer"),
		new Users("r2", "r", "trainer"),
		new Users("adm", "a", "admin")
	};
	
	
	//constuctor
	Login(){
		
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
			CryptWithMD5 CMD5 = new CryptWithMD5();
			password = CMD5.cryptWithMD5(password);

			//User validate
			for (int i = 0; i < users.length; i++){
				if(users[i].validateUser(userName, password)){
					this.loginSuccess = true;
					userID = users[i].userID;
					System.out.println("\nLogin in successfully!");
					System.out.println("The ID is " + userID);
					break;
				}
			}
			if(!this.loginSuccess) System.out.println("\nLogin fail, please login again.");
			
		}while(!this.loginSuccess);		//repeat when login fail
		
		scanner.close();
	}
	
	//methods
	public boolean LoginStatus(){
		System.out.println(userID + " " + userName);
		return this.loginSuccess;
	}
	
}
