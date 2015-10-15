class Users{
	public int userID;
	public String userName;
	public String userType;
	private String password;
	protected String email;
	protected String phone;
	public static int totalNumOfUser = 0;

	Users(){

	}

	Users(String userName, String password, String userType){
		this.userName = userName;
		//encrypt password
		//CryptWithMD5 CMD5 = new CryptWithMD5();
		this.password = CryptWithMD5.cryptWithMD5(password);
		this.userType = userType;
	}

	public boolean validateUser(String inName, String inPassword){
		return (userName.equals(inName) && password.equals(inPassword));
	}
}

/*public static void main(String[] args) {
	Array userTypeName[] = {"trainee", "trainer", "admin"};
	userTypeName[userID];
}*/