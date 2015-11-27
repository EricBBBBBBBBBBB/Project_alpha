/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Menus.java: 
********************************************/

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

class Menus implements Files {
	
// Declare data members 
	public char inChar;
	public String inString;
	public int inInt;
	private User user;
	public boolean quit = false;
	
	private JFrame menuframe;
	private JPanel panel;
    private JTextArea textArea;
	private JLabel title;
	private JButton Button1;
	private JButton Button2;
	private JButton Button3;
	private JButton Button4;
	private JButton Button5;
	private JButton Button6;
	private JButton Button7;
	private JButton Logout;
	private static final int BOTTON_WIDTH    = 300;
    private static final int BOTTON_HEIGHT   = 25;

// Constructors 
	Menus(User user) {
		this.user = user;
		mainMenu(user.getUserType());
	}

// Methods 
	//Main Menu
	private void mainMenu(String type) {
		
	
		panel = new JPanel();
		panel.setLayout(null);
		menuframe = new JFrame();
		menuframe.setSize(640, 360);
		menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuframe.add(panel);
		
		
		switch(type) {
			case "Trainee":
				traineeMenu();
				break;
			case "Trainer":
				trainerMenu();
				break;
			case "Admin":
				adminMenu();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Unknown Comment, Please Restart The System."," ",JOptionPane.WARNING_MESSAGE);
		}
		
		//option9
		Logout = new JButton("Logout");
		Logout.setBounds(10, 220, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Logout);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Prompt user for saving
				if (JOptionPane.showConfirmDialog(null, "Are you want to logout ?", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (JOptionPane.showConfirmDialog(null, "Are you want to saving all updates?", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						//Backup
						UserIO.writeUTxtFile(DEF_USER.substring(0,DEF_USER.length() - 4) + "_BackUp.csv", Account.userlist);	
						CourseIO.writeCTxtFile(DEF_COURSE.substring(0,DEF_COURSE.length() - 4) + "_BackUp.csv", Curriculum.courselist);	
						//Write
						UserIO.writeUTxtFile(DEF_USER, Account.userlist);
						CourseIO.writeCTxtFile(DEF_COURSE, Curriculum.courselist);
						JOptionPane.showMessageDialog(null, "Updates Saved.");
						SSEM.main.setVisible(true);					
					} else{
						JOptionPane.showMessageDialog(null, "Upate Cancelled & Logout."," ",JOptionPane.WARNING_MESSAGE);
						SSEM.main.setVisible(true);
						menuframe.dispose();
					}
				} else {
					//do nothing
				}
			}
		});
		menuframe.setVisible(true);			
	}

	//Trainee Menu
	private void traineeMenu() {
		Trainee trainee = (Trainee) user;
		
		//title
		title = new JLabel("Trainee Menu");
		title.setBounds(10, 10, 1000, 25);
		panel.add(title);
		
		//option1
		Button1 = new JButton("1. View the Current Available Courses");
		Button1.setBounds(10, 40, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button1);
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.listAvaibleCourse(trainee.upadteTraineeType(),trainee.getUserID());				
			}
		});
		
		//option2
		Button2 = new JButton("2. Join Training Courses");
		Button2.setBounds(10, 70, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button2);
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.joinCourse(trainee.upadteTraineeType(),trainee.getUserID());			
			}
		});
		
		//option3
		Button3 = new JButton("3. Display Current/completed Courses");
		Button3.setBounds(10, 100, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button3);
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.listCCCourse(trainee.getUserID());		
			}
		});
		
		//option4
		Button4 = new JButton("4. Display Targets Set");
		Button4.setBounds(10, 130, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button4);
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.listTarget(trainee.getUserID());		
			}
		});		
		
		//option5
		Button5 = new JButton("5. View Personal Infomation");
		Button5.setBounds(10, 160, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button5);
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainee.printUserInfo();
			}
		});			
		
		//option6
		Button6 = new JButton("6. Change Password");
		Button6.setBounds(10, 190, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button6);
		Button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});		
					
	}
	
	//Trainer Menu
	private void trainerMenu() {
		Trainer trainer = (Trainer) user;
		
		//title
		title = new JLabel("Trainer Menu");
		title.setBounds(10, 10, 1000, 25);
		panel.add(title);

		
		//option1
		Button1 = new JButton("1. Owned Courses List");
		Button1.setBounds(10, 40, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button1);
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.listOwnedCourse(trainer.getUserID());			
			}
		});
		
		//option2
		Button2 = new JButton("2. Courses Enrolled Trainees");
		Button2.setBounds(10, 70, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button2);
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		
		//option3
		Button3 = new JButton("3. Courses Complete");
		Button3.setBounds(10, 100, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button3);
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.completeCourse(trainer.getUserID());
			}
		});
		
		//option4
		Button4 = new JButton("4. View Personal Infomation");
		Button4.setBounds(10, 130, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button4);
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainer.printUserInfo();
			}
		});			
		
		//option5
		Button5 = new JButton("5. Change Password");
		Button5.setBounds(10, 160, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button5);
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});		
		
	}
	
	//Admin Menu
	private void adminMenu() {
		Admin admin = (Admin) user;
		
		//title
		title = new JLabel("Administrator Menu");
		title.setBounds(10, 10, 1000, 25);
		panel.add(title);

		//option1
		Button1 = new JButton("1. Users Management");
		Button1.setBounds(10, 40, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button1);
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminMenuUM(admin);
			}
		});
		
		//option2
		Button2 = new JButton("2. Course Management");
		Button2.setBounds(10, 70, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button2);
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminMenuCM(admin);
			}
		});

		//option3
		Button3 = new JButton("3. View Personal Infomation");
		Button3.setBounds(10, 100, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button3);
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.printUserInfo();
			}
		});		
		
		//option4
		Button4 = new JButton("4. Change Password");
		Button4.setBounds(10, 100, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button4);
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});		

	}
	
	private void adminMenuUM(Admin admin) {
		//title
		title = new JLabel("Trainer Menu");
		title.setBounds(410, 10, 1000, 25);
		panel.add(title);

		
		//option1
		Button1 = new JButton("1. Users Detailed Information");
		Button1.setBounds(310, 40, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button1);
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account.listAll();
			}
		});
		
		//option2
		Button2 = new JButton("2. Users Searching");
		Button2.setBounds(310, 70, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button2);
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		
		//option3
		Button3 = new JButton("3. Users editing");
		Button3.setBounds(310, 100, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button3);
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//option4
		Button4 = new JButton("4. Remove Users");
		Button4.setBounds(310, 130, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button4);
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});			
		
		//option5
		Button5 = new JButton("5. Create Users");
		Button5.setBounds(310, 160, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button5);
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.register();	
			}
		});		
		
		//option9
		Button6 = new JButton("Return to main menu");
		Button6.setBounds(310, 220, BOTTON_WIDTH, BOTTON_HEIGHT);
		panel.add(Button6);
		Button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});	



						

					/*case '2':	// Search User =======
						System.out.println("\n= = = = = = Users Searching = = = = = =");
						System.out.println(" Please enter the user type you want to search: ");
						System.out.println("  - 1. trainee");
						System.out.println("  - 2. trainer");
						System.out.println("  - 3. all types of users");
						System.out.println("  - 9. quit");
						System.out.print(" >>> ");
						Account.searchUser(scanner.next().charAt(0));

						
						
					case '3':	// Edit User =========
						System.out.println("\n= = = = = = User Information Editing = = = = = =");
						System.out.print(" Please enter the user name you want to edit: ");
						// temportary no ID 
						inString = scanner.next();
						Account.editUser(inString);

						
					case '4':	// Remove User =======
						System.out.println("\n= = = = = = = = = = Deregister = = = = = = = = = =");
						System.out.print(" Please enter the user name or ID you want to remove: ");
						if(scanner.hasNextInt()){	// if enter user ID
							inInt = scanner.nextInt();
							Account.removeUser("", inInt, user);
						} else {					// if enter user name
							inString = scanner.next();
							Account.removeUser(inString, 0, user);
						}	
					*/
	}
	
	private void adminMenuCM(Admin admin) {
		/*while(true){
			System.out.println("=============== Course Management Menu ==============");
			System.out.println("= 1. List all the Course\t\t\t    =");
			System.out.println("= 2. Create new course\t\t\t\t    =");
			System.out.println("= 3. Edit course\t\t\t\t    =");
			System.out.println("= 4. Delete course\t\t\t\t    =");
			System.out.println("= 9. Return to main menu\t\t\t    =");
			System.out.println("=====================================================");
			System.out.print(">> Please enter the number: ");
			inString = scanner.next();
			if(inString.equals("-l"))
				Curriculum.listAll();
			else{
				inChar = inString.charAt(0);
				switch(inChar){
					case '1':
						Curriculum.listAll();
						break;
					case '2': 	//Creat new course
						
						break;
					case '3':	//Edit Course
						System.out.println("\n= = = = = = Course Information Editing = = = = = =");
						System.out.print(" Please enter the course ID you want to edit: "); 
						inInt = Integer.parseInt(scanner.next());
						Curriculum.editCourse(inInt);
						break;
					case '4':	//Deiete Course =========
						System.out.println("\n= = = = = = Course Deleting = = = = = =");
						System.out.print(" Please enter the course name/ID you want to delete: "); 
						if(scanner.hasNextInt()){	// if enter user ID
							inInt = Integer.parseInt(scanner.next());
							Curriculum.deleteCourse(inInt);
						} else {					// if enter user name
							inString = scanner.next();
							Curriculum.deleteCourse(inInt);
						}
						break;
					case '9':
						break outerloop;	//break the outerloop -> return main menu
					default:
						System.out.println("Unknown Error.");
				}
				pkContinue();	// press enter key to continue
			}
		}*/
	}
	
	private void changePassword(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("=================== Change Password =================");
				System.out.println(" - Enter [-q] to exit;");
				System.out.println(" Please Enter your old password");
				System.out.print(" >>> ");
				String inPassword;
				while(true) {
					inString = scanner.next();
					inPassword = CryptWithMD5.cryptWithMD5(inString);
					if (inString.equals("-q") || inString.equals("-Q")) {
						break;
					} else if (inPassword.equals(user.getUserPassword())) {
						System.out.println("Please Enter the password you want to change");
						System.out.print(" >>> ");
					} else {
						System.out.println("The old password is not correct. Please enter again: ");
					}
				}
		System.out.println("=====================================================");
		
	}
	
	
}
