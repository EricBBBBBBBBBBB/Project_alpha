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
		protected String userName;
		private String password;
		protected String email;
		protected int phone;
		public static int totalNumOfUser = 0;
	
	
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

	
	//General methods
		public boolean validateUser(String inName, String inPassword) {
			return (userName.equals(inName) && password.equals(inPassword));
		}
		
	
	/*GetUserInfo*/
		public String getUserName() {
			return this.userName;
		}
		
		public String getUserType() {	
			if(this.userType == 0 ) return "Tarinee" ;
			if(this.userType == 1 ) return "Tariner" ;
			if(this.userType == 2 ) return "Admin" ;
			return "Unknown" ;
			
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
	
	
	/*SetUserInfo*/
		public void setUserName(String name) {
			this.userName = name;
		}
		
		public void setUserPassword(String pw) {
			this.password = pw;
		}
			
		public void setUserType(int type) {
			this.userType = type;
		}
			
		public void setUserEmail(String mail) {
			this.email = mail;
		}
			
		public void setUserPhone(int tel) {
			this.phone = tel;
		}
}
