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
	
	
	//Trainee methods
		public void register(){
			System.out.println(userID + " Self-Register");
		}
		
		public void browseCourse(){
			System.out.println(userName + " Browse Course");
		}
		
		public void joinCourse(){
			System.out.println(email + " Join Course");
		}
		
		public void displayCourse(){
			
		}
	
	
	//Trainer methods
		public void listCourse(){
			System.out.println(userID + " List");
		}
		
		public void displayRecords(){
			System.out.println(userName + " Display records");
		}
		
		public void gradePerformance(){
			System.out.println(email + " Grade performance");
		}
	
	
	//Admin methods
		public void deregister(){
			System.out.println(userID + " Deregister");
		}
		
		public void listallRecords(){
			System.out.println(userID + " List all records ");
		}
		
		public void AddCourses(){
			System.out.println(userID + " Create Courses ");
		}
		
		public void DelCourses(){
			System.out.println(userID + " Delete Courses ");
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
