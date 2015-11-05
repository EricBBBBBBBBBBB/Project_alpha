/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* Users.java: 
********************************************/
import java.util.ArrayList;
import java.util.Scanner;

class ArrayListTest{
	public static void main(String[] args) {
		ArrayList<Users> myList = new ArrayList<Users>();

		myList.add(new Users("E111", "EEEE", 1));
		myList.add(new Users("E112", "EEEE", 1));
		myList.add(new Users("E113", "EEEE", 1));
		myList.add(new Users("E114", "EEEE", 1));
		myList.add(new Users("E115", "EEEE", 1));
		myList.add(new Users("E116", "EEEE", 1));

		System.out.println("Now The ArrayList has " + myList.size());

		myList.remove(1);

		//System.out.println(myList.contains(user1));
		System.out.println("Please enter your Username");
		Scanner scanner = new Scanner(System.in);
		String getString = scanner.nextLine();
		for (int i = 0; i < myList.size(); i++) {
			if((myList.get(i).getUserName()).equals(getString)) {
				System.out.println("The system has record. The index is " + i);
				break;
			}
		}

		System.out.println(myList.get(1).getUserName());

		System.out.println("Now The ArrayList has " + myList.size());

		System.out.println(Users.getTotNumOfUser());


	}
}