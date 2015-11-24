/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Register.java: 
********************************************/

import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


class Register {
	public void register() {
		
		String inUserName, inPassword, inEmail, inPhone, inDate, inStr;
        int year, month, day;

		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------------------------------------------------");
        System.out.println("-                  User Register                    -");
        System.out.println("-----------------------------------------------------");
        System.out.println("Please enter the information requested completely!");
		System.out.println(">>>Rules for a valid Login ID for a user account:");
		System.out.println("\tLogin ID must contain: ");
		System.out.println("\t\t- 8~12 characters");
		System.out.println("\t\t- Just LOWER-CASE letters");
		System.out.println("\t\t- no starting with digit");
        System.out.println("\tPassword must contain: ");
        System.out.println("\t\t- 8~12 characters");
        System.out.println("\t\t- letters and digit");
        
        System.out.print("Name: ");
        while(true){
            inUserName = scanner.nextLine();
            if(!IOValidation.usernameValid(inUserName))
                System.out.print("User name could not be empty! Please enter again: ");
            else {
                if(Account.searchUserReBo(inUserName))
                    System.out.println("The name has been used");
                else
                    break;
            }
        }
        System.out.print("Password: ");
        while((inPassword = scanner.nextLine()).isEmpty()){
        	System.out.print("Password could not be empty! Please enter again: ");
        }
        System.out.print("E-mail: ");
        //while((inEmail = scanner.nextLine()).isEmpty()){
        while(!IOValidation.emailValid(inEmail = scanner.nextLine())){
        	System.out.print("Email could not be empty! Please enter again: ");
        }
        System.out.print("Phone: ");
        //while((inPhone = scanner.nextLine()).isEmpty()){
        while(!IOValidation.phoneValid(inPhone = scanner.nextLine())){
        	System.out.print("Phone could not be empty! Please enter again: ");
        }
        System.out.print("Date of birth (YYYY/MM/DD) [Eg.: 2007/10/27]: ");
        Date bDay = new Date();
        while(true){
            inDate = scanner.nextLine();
            if(!IOValidation.dateValid(inDate))
                System.out.print("Wrong Format! Please enter again");
            else {
                String[] dateSplit = inDate.split("/");
                year = Integer.parseInt(dateSplit[0]);
                month = Integer.parseInt(dateSplit[1]);
                day = Integer.parseInt(dateSplit[2]);
                if(month < 0 || month > 12)
                    System.out.println("Wrong Format!");
                else if(day < 0 || day > 31)
                    System.out.println("Wrong Format!");
                else {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    try {  
                        bDay = sdf.parse(inDate);  
                    } catch (ParseException pe) {  
                        System.out.println("Wrong Format!");
                        System.out.println(pe.getMessage());
                        continue;
                    } 
                    break;
                }
            }
        }
        System.out.println("#####################################################");
        System.out.println("# Please check the information correctly");
        System.out.println("#   Your user name: \t" + inUserName);
        System.out.println("#   Your E-mail: \t" + inEmail);
        System.out.println("#   Your Phone: \t" + inPhone);
        System.out.println("#   Date of Birth: \t" + inDate);
        System.out.println("#####################################################");
        System.out.println(" **** Please Enter : 'Y' to create user ****");
        System.out.print("(Y / N): ");

        if((inStr = scanner.nextLine()).equals("Y") || inStr.equals("y")){
			int uid = Account.userlist.get(Account.userlist.size() - 1).getUserID() + 1;
			inPassword = CryptWithMD5.cryptWithMD5(inPassword);
			Trainee newtrainee = new Trainee(uid, inUserName, inPassword);
			newtrainee.setTraineeInfo(inEmail,inPhone,3);
            //newtrainee.setUserBirth(bDay.getTime());
            System.out.println(Account.updateuserlist(newtrainee));
			
			System.out.println("-----------------------------------------------------");
	        System.out.println("-                                                   -");
	        System.out.println("-      Your user is created! Please login..         -");
        	System.out.println("-                                                   -");
        	System.out.println("-----------------------------------------------------");
        } else {
			System.out.println("-----------------------------------------------------");
	        System.out.println("-                                                   -");
	        System.out.println("-             The action is Canceled!               -");
        	System.out.println("-                                                   -");
        	System.out.println("-----------------------------------------------------");
        }
	}
}