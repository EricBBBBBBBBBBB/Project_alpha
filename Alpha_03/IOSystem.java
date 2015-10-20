/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* IOSystem.java: 
********************************************/

import java.util.Scanner;
class IOSystem{
	
		Scanner scanner = new Scanner(System.in);
	//data members
	IOSystem() {
	}
	//constructors

	//methods
	public static String getString(){
		return scanner.nextLine();
	}
}
