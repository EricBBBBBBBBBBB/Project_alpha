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
		new Users("e1", "e", 0),
		new Users("e2", "e", 0),
		new Users("e3", "e", 0),
		new Users("r1", "r", 1),
		new Users("r2", "r", 1),
		new Users("adm", "a", 2)
	};
	
	//constuctor
	public Login() {
	}
	//methods
	public Users login() {
		
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

					break;
				}
			}
			if(!this.loginSuccess) System.out.println("\nLogin fail, please login again.");
			
		}while(!this.loginSuccess);		//repeat when login fail
		
		//scanner.close();

		return users[userID];
	}
	
	
	public boolean LoginStatus(){
		return this.loginSuccess;
	}
	
}
