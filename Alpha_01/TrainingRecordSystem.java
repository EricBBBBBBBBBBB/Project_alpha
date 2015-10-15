
import java.util.Scanner;

public class TrainingRecordSystem {

	public static void main(String[] args) {

		String userName;
		String password;

		int loginID = -1;	// no login ID -> empty

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

		System.out.print("Please enter your user name: ");
		while ((userName = scanner.nextLine()).isEmpty()){
			System.out.print("User name cannot be empty, Please enter again: ");
		} 
		System.out.print("Please enter your password: ");
		while ((password = scanner.nextLine()).isEmpty()){
			System.out.print("Password cannot be empty, Please enter again: ");
		} 
		for (int i = 0; i < trainee.length; i++) {
			if(trainee[i].validateUser(userName, password)){
				System.out.println("\nLogin in successfully!");
				loginID = i;
				System.out.println("The ID is " + loginID);
				break;
			}
		}
		if(loginID == -1)
			System.out.println("\nLogin fail, please login again.");
		scanner.close();
	}
}
