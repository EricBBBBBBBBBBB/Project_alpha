
class Users{
	
	public static void main(String[] args) {
	
	
	}

}
	
class Trainee{
	
	//data member
	public static int TraineeID ;
	private String displayName;
	private int phone;
	private String email;
	
	private String userName;
	private String cryptPassword;
	
	//constructor
	Trainee(){
		
	}
	
	Trainee(String name){
		
	}
	
	Trainee(String name, String password){
		
		//username
		userName = name;
		
		//encrypt password
		CryptWithMD5 CMD5 = new CryptWithMD5();
		cryptPassword = CryptWithMD5.cryptWithMD5(password);
		
	}
	
	//method
	public void browse(){
		
	}
	
	public void join(int cid){
		
	}
	
	public void display(){
		
	}
	
}

class Trainer{
	
	//data member
	public static int TrainerID ;
	private String displayName;
	private int phone;
	private String email;
		
	private String userName;
	private String cryptPassword;
	
	//constructor
	Trainer(){
		
	}
	
	Trainer(String name){
		
	}
	
	Trainer(String name, String password){
		
		//username
		userName = name;
		
		//encrypt password
		CryptWithMD5 CMD5 = new CryptWithMD5();
		cryptPassword = CryptWithMD5.cryptWithMD5(password);
		
	}
	
	//method
	public void list(){
		
		
	}
	
	public void track(String name){
		
		
	}
	
	
}

class Admin{

	//data member
	public static int AdminID ;
	private String displayName;
	private int phone;
	private String email;
		
	private String userName;
	private String cryptPassword;
	
	//constructor
	Admin(){
		
	}
	
	Admin(String name){
		
	}
	
	Admin(String name, String password){
		
		//username
		userName = name;
		
		//encrypt password
		CryptWithMD5 CMD5 = new CryptWithMD5();
		cryptPassword = CryptWithMD5.cryptWithMD5(password);
		
	}
	
	//method
	
	
	

}
