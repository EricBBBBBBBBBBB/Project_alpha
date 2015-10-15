
import java.util.Scanner;

public class TrainingRecordSystem {

	public static void main(String[] args) {

		String userName;
		String password;

		// Load user information - *For test only*
		Trainee[] trainee = {
			new Trainee("e1", "e"),
			new Trainee("e2", "e"), 
			new Trainee("e3", "e")
		};
		Trainer[] trainer = {
			new Trainer("r1", "r"), 
			new Trainer("r2", "r")
		};
		Admin[] admin = {
			new Admin("adm", "a")
		};

		
		System.out.println("**********************************");
		System.out.println(" Welcome to Training Record System");
		System.out.println("**********************************");
		
		Scanner scanner = new Scanner(System.in);
	
		do{
			// enter user name
			System.out.print("Please enter your user name: ");
			while ((userName = scanner.nextLine()).isEmpty()){
				System.out.print("User name cannot be empty, Please enter again: ");
			} 
			
			//enter password
			System.out.print("Please enter your password: ");
			while ((password = scanner.nextLine()).isEmpty()){
				System.out.print("Password cannot be empty, Please enter again: ");
			} 
			
			//validate
			if(trainee.validateUser(userName, password)) System.out.println("\nLogin in successfully!");
				else System.out.println("\nLogin fail, please login again.");
				
		}while(!trainee.validateUser(userName, password));		//repeat if login fail

		scanner.close();
	}
}
