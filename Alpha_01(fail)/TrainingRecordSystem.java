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

		System.out.println("***********************************");
		System.out.println(" Welcome to Training Record System");
		System.out.println("***********************************");
		
		Login login = new Login(); //login
		System.out.println(login.LoginStatus());
		
	}
}

