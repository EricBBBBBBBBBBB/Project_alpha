/********************************************
* Project Team:	
* Students: 
* Couse: OOP 2015 Sem 1, HDIT
*
* Users.java: 
********************************************/

class Users{
	
	//data members
	public int userID;
	public int userType;
	private String userName;
	private String password;
	protected String email;
	protected String phone;
	public static int totalNumOfUser = 0;
	public Courses courses;
	
	//constructors
	Users(){
		this.userName = "Unknown";
		this.password = "Unknown";
		this.userType = 99;
		this.userID = totalNumOfUser;
		this.totalNumOfUser++;
	}
	
	Users(String userName, String password, int userType) {
		this.userName = userName;
		//encrypt password
		//CryptWithMD5 CMD5 = new CryptWithMD5();
		this.password = CryptWithMD5.cryptWithMD5(password);
		this.userType = userType;
		this.userID = totalNumOfUser;
		this.totalNumOfUser++;
	}

	//methods
	public boolean validateUser(String inName, String inPassword) {
		return (userName.equals(inName) && password.equals(inPassword));
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public int getUserType() {
		return this.userType;
	}
	
	public int getUserID() {
		return this.userID;
	}

	public void getUserInfo() {	// for test ONLY
		System.out.println("*********** LOGIN INFORMATION (FOR TEST ONLY) ************");
		System.out.println("userID: " + this.userID);
		System.out.println("userName: " + this.userName);
		System.out.println("userType: " + this.userType);
		System.out.println("*********** LOGIN INFORMATION (FOR TEST ONLY) ************");
	}
	
}

class Trainees extends Users{
	
	//data members
	
	//constructors
	
	//methods
	public void joinCourse(String name){
		
	}
}
