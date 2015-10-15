
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
			new Trainer{("r2", "r")
		};
		Admin[] admin = {
			new Admin("adm", "a")
		};

		
		System.out.println("**********************************");
		System.out.println(" Welcome to Training Record System");
		System.out.println("**********************************");
		
		Scanner scanner = new Scanner(System.in);

		System.out.pirnt("Please enter your user name: ");

		scanner.close();
	}
}
