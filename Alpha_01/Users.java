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
	public String userType;
	private String userName;
	private String password;
	protected String email;
	protected String phone;
	public static int totalNumOfUser = 0;
	
	//constructors
	Users(){

	}
	
	Users(String userName, String password, String userType){
		this.userName = userName;
		//encrypt password
		//CryptWithMD5 CMD5 = new CryptWithMD5();
		this.password = CryptWithMD5.cryptWithMD5(password);
		this.userType = userType;
		
		this.userID = totalNumOfUser;
		this.totalNumOfUser++;
	}

	//methods
	public boolean validateUser(String inName, String inPassword){
		return (userName.equals(inName) && password.equals(inPassword));
	}

	public String getUserName() {
		return this.userName;
	}

	public String getUserType() {
		return this.userType;
	}

	public int getUserID(){
		return this.userID;
	}
	
}

/*public static void main(String[] args) {
	Array userTypeName[] = {"trainee", "trainer", "admin"};
	userTypeName[userID];
}*/
