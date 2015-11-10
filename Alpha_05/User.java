/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* 
********************************************/
import java.util.Calendar;
class User{
	
// Declare data members
	public static int totalNoOfUser = 0;

	public int userID;
	public int userType;
	private String userName;
	private String password;
	protected String email;
	protected int phone;
	protected Calendar dateOfRegister;

// Constructors
	User() {
		totalNoOfUser++;
		dateOfRegister = Calendar.getInstance();
	}
	
	public User(String name, int type) {	
		this();
		userID = totalNoOfUser;
		userName = name;
		userType = type;
	}
	
	public User(String name, String pw, int type) {
		this(name,type);
		password = CryptWithMD5.cryptWithMD5(pw);
	}

// Methods
	// Validate a User
	public boolean validateUser(String name, String pw) {
		return (userName.equals(name) && password.equals(pw));
	}
	
	//Get the User information
	public int getUserID() {
		return userID;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserType() {	
		if(userType == 0 ) return "Tarinee" ;
		if(userType == 1 ) return "Tariner" ;
		if(userType == 2 ) return "Admin" ;
		return "Unknown" ;
	}
	
	public String getUserEmail() {
		return email;
	}
			
	public int getUserPhone() {
		return phone;
	}	
	
	//Set the User information
	public void setUserName(String name) {
		userName = name;
	}
	
	public void setUserPassword(String pw) {
		password = pw;
	}
		
	public void setUserType(int type) {
		userType = type;
	}
			
	public void setUserEmail(String mail) {
		email = mail;
	}
			
	public void setUserPhone(int tel) {
		phone = tel;
	}
	
	public void setUserInfo(String name,String pw,int type,String mail,int tel) {
		userName = name;
		password = pw;
		userType = type;
		email = mail;
		phone = tel;
	}
	
	// Print User information
	public void printUserInfo() {
		System.out.println("-----------------------------------------------------");	
		System.out.println("-   \t\t" + getUserType() + " Information\t\t   -");
		System.out.println("-----------------------------------------------------");	
		System.out.println("User ID: \t  " + getUserID());
		System.out.println("User Name: \t  " + getUserName());
		System.out.println("User Email: \t  " + getUserEmail());
		System.out.println("User Phone: \t  " + getUserPhone());
		System.out.println("Date of register: " + dateOfRegister.getTime());
		System.out.println("-----------------------------------------------------");	
		System.out.println("End of Personal Infomation.\n");
	}
}