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

	public void showUserInfo() {
		System.out.println("========== User Information [" + getUserName() + "] ==========");
		System.out.println("User name:\t\t" + getUserName());
		System.out.println("User type:\t\t" + getUserType());
		System.out.println("Phone:\t\t\t" + phone);
		System.out.println("Email:\t\t\t" + email);
		System.out.println("Date of register:\t" + dateOfRegister.getTime());
		System.out.println("===========================================");
	}
}