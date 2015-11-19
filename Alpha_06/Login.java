/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Login.java: 
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


class Login{
	
// Declare data members 
	private boolean loginSuccess = false;
	private String userName;
	private String password;
    private ArrayList<User> userlist;
	
// Constructors 
	public User login(){
		Scanner scanner = new Scanner(System.in);

		do{
			System.out.println("-----------------------------------------------------");
			System.out.println("-                   Login System                    -");
			System.out.println("-----------------------------------------------------");
			
			//Input User name
			System.out.println("(if you haven't got a user, please type '-r')");
			
			System.out.print("> Please enter your user name: ");
			while ((userName = scanner.nextLine()).isEmpty()){
				System.out.print(">>User name cannot be empty, Please enter again: ");
			} 
			if (userName.equals("-r") || userName.equals("-R")) {
				Register register = new Register();
				register.register();	
				continue;
			}

			if(userName.equals("q"))		// emergency quit for testing only
				return null;
			
			//Input User password
			System.out.print("> Please enter your password: ");
			while ((password = scanner.nextLine()).isEmpty()){
				System.out.print(">> Password cannot be empty, Please enter again: ");
			} 
			CryptWithMD5 CMD5 = new CryptWithMD5();
			password = CMD5.cryptWithMD5(password);	//Encrypt Password
			
			//Get User list
			userlist = Account.getuserlist();
			
			//loading 
			try {
				System.out.println(">> Loading...");
				Thread.sleep(500);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			
			//User validate
			for (int i = 0; i < userlist.size(); i++) {
				if(userlist.get(i).validateUser(userName, password)){
					this.loginSuccess = true;
					return userlist.get(i);
				}
			}
			if(!this.loginSuccess) System.out.println("\n>>> Login fail, please login again.");
			
		}while(!this.loginSuccess);		//repeat if login fail

		return null;
	}
	
// Methods 
	//Get login status
	public boolean LoginStatus(){
		return loginSuccess;
	}
	
}
