/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* 
********************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Admin extends User{

// Declare data members
	public static int totalNoOfAdmin = 0;  // class data member

// Constructors
	Admin(String name) {
		super(name, 2);	//call superclass constructor
	}
	
	Admin(String name, String pw) {
		super(name, pw, 2);	//call superclass constructor
	}

// Methods

}