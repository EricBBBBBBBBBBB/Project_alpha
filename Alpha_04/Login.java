/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* Login.java: 
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


class Login{
	//data members
	private boolean loginSuccess = false;
	private int userID;
	private String userName;
	private String password;
    private ArrayList<Users> myList = new ArrayList<Users>();
	
	//constuctor
	public Login() {
	}
	//methods
	public Users login() {
		Scanner scanner = new Scanner(System.in);


		do{
        System.out.println("-----------------------------------------------------");
        System.out.println("-                   Login System                    -");
        System.out.println("-----------------------------------------------------");
        System.out.println("");
        	System.out.println("");
			//input username & password
			System.out.println("(if you haven't got a user, please type signup)");
			System.out.print("Please enter your user name: ");
			while ((userName = scanner.nextLine()).isEmpty()){
				System.out.print("User name cannot be empty, Please enter again: ");
			} 
			if (userName.equals("signup")) {
				Register register = new Register();
				register.register();	
				continue;
			}
			System.out.print("Please enter your password: ");
			while ((password = scanner.nextLine()).isEmpty()){
				System.out.print("Password cannot be empty, Please enter again: ");
			} 
			CryptWithMD5 CMD5 = new CryptWithMD5();
			password = CMD5.cryptWithMD5(password);

			myList = Account.getMyList();
			//User validate
			//for (int i = 0; i < users.length; i++){
			for (int i = 0; i < myList.size(); i++) {
				//if(users[i].validateUser(userName, password)){
				if(myList.get(i).validateUser(userName, password)){
					this.loginSuccess = true;
					userID = myList.get(i).userID;
					System.out.println("\nLogin in successfully!");

					return myList.get(i);
				}
			}
			if(!this.loginSuccess) System.out.println("\nLogin fail, please login again.");
			
		}while(!this.loginSuccess);		//repeat when login fail
		
		// scanner.close();

		return null;
	}
	
	
	public boolean LoginStatus(){
		return this.loginSuccess;
	}

	//public Users[] getUserInfo() {
	//	return users;
	//}
	
}
