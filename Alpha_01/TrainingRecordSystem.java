
import java.util.Scanner;

public class TrainingRecordSystem {

	public static void main(String[] args) {

		String userName;
		String password;

		int loginID = -1;	// no login ID -> empty

		// Load user information - *For test only*
		Users[] users = {
			new Users("e1", "e", "trainee"),
			new Users("e2", "e", "trainee"),
			new Users("e3", "e", "trainee"),

			new Users("r1", "r", "trainer"),
			new Users("r2", "r", "trainer"),

			new Users("adm", "a", "admin")
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
		//CryptWithMD5 CMD5 = new CryptWithMD5();
		password = CryptWithMD5.cryptWithMD5(password);

		for (int i = 0; i < users.length; i++) {
			if(users[i].validateUser(userName, password)){
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
