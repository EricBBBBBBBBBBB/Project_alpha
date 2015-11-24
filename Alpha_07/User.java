/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* User.java:
********************************************/
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
class User{
	
// Declare data members
	public static int totalNoOfUser = 0;

	public int userID;
	public int userType;
	protected String userName;
	protected String password;
	protected String email;
	protected String phone;
	protected Long dateOfRegister;
	protected LocalDate dateOfBirth;
	private Date getTime;

// Constructors
	User() {
		totalNoOfUser++;
		//dateOfRegister = Calendar.getInstance();
		getTime = new Date();
		dateOfRegister = getTime.getTime();	// Long type number must add "L" after the number
		dateOfBirth = LocalDate.now();
	}
	
	public User(String name, int type) {	
		this();
		userName = name;
		userType = type;
	}
	
	public User(int uid, String name, String pw, int type) {
		this(name,type);
		userID = uid;
		password = pw;
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

	public String getUserPassword() {
		return password;
	}
	
	public String getUserType() {	
		if(userType == 0 ) return "Trainee" ;
		if(userType == 1 ) return "Trainer" ;
		if(userType == 2 ) return "Admin" ;
		return "Unknown" ;
	}
	
	public String getUserEmail() {
		return email;
	}
			
	public String getUserPhone() {
		return phone;
	}	
	
	public Long getDate() {
		return dateOfRegister;
	}	

	public int getAge() {
		LocalDate today = LocalDate.now();
		Period period = Period.between(dateOfBirth, today);
		return period.getYears();
	}

	public LocalDate getBDay() {
		return dateOfBirth;
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
			
	public void setUserPhone(String tel) {
		phone = tel;
	}
	
	public void setUserInfo(String mail,String tel) {
		email = mail;
		phone = tel;
	}

	public void setUserRegTime(Long date) {
		dateOfRegister = date;
	}

	public void setUserBirth(LocalDate date) {
		dateOfBirth = date;
	}

	
	// Print User information
	public void printUserInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		System.out.println("-----------------------------------------------------");	
		System.out.println("-   \t\t" + getUserType() + " Information\t\t   -");
		System.out.println("-----------------------------------------------------");	
		System.out.println("User ID: \t  " + getUserID());
		System.out.println("User Name: \t  " + getUserName());
		System.out.println("User Email: \t  " + getUserEmail());
		System.out.println("User Phone: \t  " + getUserPhone());
		System.out.println("Date of register: " + sdf.format(dateOfRegister));
		System.out.println("Date of Birth: \t  " + sdf.format(dateOfBirth));
		System.out.println("-----------------------------------------------------");	
		System.out.println("End of Personal Infomation.\n");
	}


}