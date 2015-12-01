/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Account > User > Trainer, Trainee, Admin
********************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Account implements Files{

// Declare data members 
	public static ArrayList<User> userlist = new ArrayList<User>();
	

// Methods 
	//Initialization User List
	public static void inituserlist() {
		userlist = UserIO.readUTxtFile(DEF_USER);
	}
	
	//Update User List
    public static boolean updateuserlist(User user) {
        if(userlist.add(user))
            return true;
        else
            return false;
    }
	
	//Get User List
    public static ArrayList<User> getuserlist() {
        return userlist;
    }
	
	//Remove User (admin option4)
    public static void removeUser(int uid, User operateUser) {

		int listID = searchuserlistID(uid);

		if((userlist.get(listID).getUserName()).equals(operateUser.getUserName())) {
                JOptionPane.showMessageDialog(null, "You cannot remove yourself!"," ",JOptionPane.WARNING_MESSAGE);
        }else {
			if((userlist.get(listID).getUserType()).equals("Admin")) {
					JOptionPane.showMessageDialog(null, "You cannot remove an admin-type user!"," ",JOptionPane.WARNING_MESSAGE);
			}else{
				if(JOptionPane.showConfirmDialog(null, "Are you sure to remove User [" + userlist.get(listID).getUserName() + "] ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					userlist.remove(listID);
					JOptionPane.showMessageDialog(null, "User Removed");	
				}else{
					JOptionPane.showMessageDialog(null, "Action was cancelled");	
				}
			}
		}
		
		listAll();
    }
	
	
    //Search User by ID (return ArrayList ID)
    public static int searchuserlistID(int uid) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserID() == uid)
                return i;
        }
        return -1;
    }
	
    //Search User by name (return ArrayList ID) [Require exactly User name for searching]
    public static int searchuserlistID(String userName) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserName().equals(userName)) 
                return i;
        }
        return -1;
    }

	// Search User by Name (return boolean if yes)
	public static boolean searchUserReBo(String userName) {
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserName().equals(userName)) 
                return true;
        }
        return false;
    }
	
    //Search User by Name (Admin Option 2)
    public static void searchUser(int userType) {
		
        int totSearchNum = 0;
		int row = 0;
		String message, inStr;  
		boolean type;
		
        switch(userType) {
            case 0:
                message = "user name of trainee: ";
                break;
            case 1:
                message = "user name of trainer: ";
                break;
            default:
                message = "user name:";
        }
				
		inStr = JOptionPane.showInputDialog("Please enter the " + message);

		//listing
		String [] strHeader = {"User ID", "User Name", "User Type"};
		String [][] strData = new String[userlist.size()][3]; 
        for (int i = 0; i < userlist.size(); i++) {
			switch(userType) {
				case 0:
					type = userlist.get(i) instanceof Trainee ;
					break;
				case 1:
					type = userlist.get(i) instanceof Trainer ;
					break;
				default:
					type = true;
			}
            if(userlist.get(i).getUserName().contains(inStr) && type) {
				strData[row][0] = Integer.toString(userlist.get(i).getUserID()); 
				strData[row][1] = userlist.get(i).getUserName(); 
				strData[row++][2] = userlist.get(i).getUserType();
                totSearchNum++;
            }

        }
		if(totSearchNum <= 0) {
			JOptionPane.showMessageDialog(null, "User can't found.");
		}else {
			JOptionPane.showMessageDialog(null, "There are " + totSearchNum + " result(s)");
			TableModel  model = new DefaultTableModel(strData,strHeader);
			Menus.table.setModel(model);
		}
            
    }


    //Print User Information
    public static void printUserInfo(int listID) {
        if(listID != -1) {
            userlist.get(listID).printUserInfo();
        }else{
            System.out.println("User not found!");
        }
    }

    //Edit User Information
    public static void editUser(String userName) {
        int listID = searchuserlistID(userName);
        if (listID != -1) {
            System.out.println("Found the record");
            //userlist.get(listID).printUserInfo();
        Scanner scanner = new Scanner(System.in);
            String inStr;
            char inChar;
			
            whileloop:
            while(true) {
                System.out.println("---------------Edit User Information-------------");
                System.out.println("Please select the part you want to edit: ");
                System.out.println("- 1: User Email");
                System.out.println("- 2: User Phone");
                System.out.println("- 3: Other");
                System.out.println("- 8: Show User information");
                System.out.println("- 9: Quit Editing");

                inStr = scanner.next();

                switch(inStr.charAt(0)) {
                    case '1':
                        System.out.println("Please enter the new Email Address (-q for quit without change");
						inStr = scanner.next();
                        if(inStr.equals("-q") || inStr.equals("-Q")) {
                            break;
                        } else {
                            if(IOValidation.emailValid(inStr)) {
                                System.out.println("The previous Email: " + userlist.get(listID).getUserEmail());
                                System.out.println("The new Email: " + inStr);
                                System.out.println(">> Are you sure to make change? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    userlist.get(listID).setUserEmail(inStr);
                                    System.out.println("The Email is updated!");
                                } else {
                                    System.out.println("Action was cancelled!");
                                }
                            }else{
                                System.out.println("Wrong format");
                            }
                        }
						break;
                    case '2':
						System.out.println("Please enter the new phone number (-q for quit without change");
                        inStr = scanner.next();
                        if(inStr.equals("-q") || inStr.equals("-Q")) {
                            break;
                        } else {
                            if(IOValidation.phoneValid(inStr)) {
                                System.out.println("The previous Phone: " + userlist.get(listID).   getUserPhone());
                                System.out.println("The new Phone: " + inStr);
                                System.out.println(">> Are you sure to make chnage? (Y/N)");
                                inChar = scanner.next().charAt(0);
                                if(inChar == 'y' || inChar == 'Y'){
                                    userlist.get(listID).setUserPhone(inStr);
                                    System.out.println("The Phone number is updated!");
                                } else {
                                    System.out.println("Action was cancelled!");
                                }
                            }else{
                                System.out.println("Wrong format");
                            }
                        }
                        break;
                    case '3':
                        break;
                    case '8':
						userlist.get(listID).printUserInfo();
                        break;
                    case '9':
                        break whileloop;
                    default:
                        System.out.println("Unknown command");
                        break whileloop;
                }

            }
        } else {
            System.out.println("No such user");
        }
	}
	
	//List all Users records
	public static void listAll(){

		String output =  "> List all courses";
		test.write(output);
		
		String [] strHeader = {"User ID", "User Name", "User Type"};
		String [][] strData = new String[userlist.size()][3]; 
		boolean not = true;
		int row = 0;
		for (int i = 0; i < userlist.size(); i++) {
			strData[row][0] = Integer.toString(userlist.get(i).getUserID()); 
			strData[row][1] = userlist.get(i).getUserName(); 
			if(userlist.get(i) instanceof Trainee) {
				Trainee trainee = (Trainee)userlist.get(i);
				strData[row++][2] = userlist.get(i).getUserType() + " (" + trainee.getTraineeType() + ")";
			}else  
				strData[row++][2] = userlist.get(i).getUserType();
			not = false;
		}
		if(not) {
			JOptionPane.showMessageDialog(null, "Not for now.");
		}else {
			TableModel  model = new DefaultTableModel(strData,strHeader);
			Menus.table.setModel(model);
		}		
		
		
	}
	
}
