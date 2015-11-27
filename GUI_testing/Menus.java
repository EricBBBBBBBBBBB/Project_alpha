/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Menus.java: 
********************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Menus extends SSEM{
	
	Menus(User user) {
		add(new MenusPanel(user));
		setSize(360, 640);
		
		//set center
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 360) / 2;
		final int y = (screenSize.height - 640) / 2;
		setLocation(x, y);
		
		setUndecorated(true);
		setVisible(true);
	}
	
}

//panel
class MenusPanel extends JPanel {
	
	private User user;
	private JLabel title;
	private JButton option1;
	private JButton option2;
	private JButton option3;
	private JButton option4;
	private JButton option5;
	private JButton option6;
	private JButton option7;
	private JButton Logout;
	private static final int BOTTON_WIDTH    = 300;
    private static final int BOTTON_HEIGHT   = 25;
	
	Image bgimage = null;

	MenusPanel(User u) {
		
		user = u;
		setLayout(null);	
		
		//background
		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage("img/menu.png");
		mt.addImage(bgimage, 0);
		try {
		  mt.waitForAll();
		} catch (InterruptedException e) {
		  e.printStackTrace();
		}
		
		
		//select the right menu
		switch(user.getUserType()) {
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
		
		//logout
		Logout = new JButton("Logout");
		Logout.setBounds(10, 220, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(Logout);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Prompt user for saving
				if (JOptionPane.showConfirmDialog(null, "Are you want to logout ?", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					SSEM.main.setVisible(true);
					SSEM.menus.dispose();
				} else {
					//do nothing
				}
			}
		});	
		SSEMPanel.quit(this);
		
	}	
	
	//Trainee Menu
	private void traineeMenu() {
		Trainee trainee = (Trainee) user;
	
		option1 = new JButton("1. View the Current Available Courses");
		option2 = new JButton("2. Join Training Courses");
		option3 = new JButton("3. Display Current/completed Courses");
		option4 = new JButton("4. Display Targets Set");
		option5 = new JButton("5. View Personal Infomation");
		option6 = new JButton("6. Change Password");
		
		//title
		title = new JLabel("Trainee Menu");
		title.setBounds(10, 10, 1000, 25);
		add(title);
		
		//option1
		option1.setBounds(10, 40, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option1);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.listAvaibleCourse(trainee.upadteTraineeType(),trainee.getUserID());				
			}
		});
		
		//option2
		option2.setBounds(10, 70, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option2);
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.joinCourse(trainee.upadteTraineeType(),trainee.getUserID());			
			}
		});
		
		//option3
		option3.setBounds(10, 100, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option3);
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.listCCCourse(trainee.getUserID());		
			}
		});
		
		//option4
		option4.setBounds(10, 130, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option4);
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.listTarget(trainee.getUserID());		
			}
		});		
		
		//option5
		option5.setBounds(10, 160, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option5);
		option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainee.printUserInfo();
			}
		});			
		
		//option6
		option6.setBounds(10, 190, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option6);
		option6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});		
				
	}

	//Trainer Menu
	private void trainerMenu() {
		Trainer trainer = (Trainer) user;
		
		option1 = new JButton("1. Owned Courses List");
		option2 = new JButton("2. Courses Enrolled Trainees");
		option3 = new JButton("3. Courses Complete");
		option4 = new JButton("4. View Personal Infomation");
		option5 = new JButton("5. Change Password");
		
		//title
		title = new JLabel("Trainer Menu");
		title.setBounds(10, 10, 1000, 25);
		add(title);

		
		//option1
		option1.setBounds(10, 40, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option1);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.listOwnedCourse(trainer.getUserID());			
			}
		});
		
		//option2
		option2.setBounds(10, 70, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option2);
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		
		//option3
		option3.setBounds(10, 100, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option3);
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.completeCourse(trainer.getUserID());
			}
		});
		
		//option4
		option4.setBounds(10, 130, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option4);
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainer.printUserInfo();
			}
		});			
		
		//option5
		option5.setBounds(10, 160, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option5);
		option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});		
		
	}
	
	//Admin Menu
	private void adminMenu() {
		Admin admin = (Admin) user;
		
		option1 = new JButton("1. Users Management");
		option2 = new JButton("2. Course Management");
		option3 = new JButton("3. View Personal Infomation");
		option4 = new JButton("4. Change Password");
		option6 = new JButton("Return to main menu");
		
		//title
		title = new JLabel("Administrator Menu");
		title.setBounds(10, 10, 1000, 25);
		add(title);

		//option1
		option1.setBounds(10, 40, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option1);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminMenuUM(admin);
			}
		});
		
		//option2
		option2.setBounds(10, 70, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option2);
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminMenuCM(admin);
			}
		});

		//option3
		option3.setBounds(10, 100, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option3);
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.printUserInfo();
			}
		});		
		
		//option4
		option4.setBounds(10, 100, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option4);
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});		

	}
	
	private void adminMenuUM(Admin admin) {
		
		
		option1 = new JButton("1. Users Detailed Information");
		option2 = new JButton("2. Users Searching");
		option3 = new JButton("3. Users editing");
		option4 = new JButton("4. Remove Users");
		option5 = new JButton("5. Create Users");
		
		//title
		title = new JLabel("Trainer Menu");
		title.setBounds(410, 10, 1000, 25);
		add(title);

		
		//option1
		option1.setBounds(310, 40, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option1);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account.listAll();
			}
		});
		
		//option2
		option2.setBounds(310, 70, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option2);
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*case '2':	// Search User =======
				System.out.println("\n= = = = = = Users Searching = = = = = =");
				System.out.println(" Please enter the user type you want to search: ");
				System.out.println("  - 1. trainee");
				System.out.println("  - 2. trainer");
				System.out.println("  - 3. all types of users");
				System.out.println("  - 9. quit");
				System.out.print(" >>> ");
				Account.searchUser(scanner.next().charAt(0));*/
			}
		});
		
		//option3
		option3.setBounds(310, 100, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option3);
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*case '3':	// Edit User =========
				System.out.println("\n= = = = = = User Information Editing = = = = = =");
				System.out.print(" Please enter the user name you want to edit: ");
				// temportary no ID 
				inString = scanner.next();
				Account.editUser(inString);*/
			}
		});
		
		//option4
		option4.setBounds(310, 130, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option4);
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*case '4':	// Remove User =======
					System.out.println("\n= = = = = = = = = = Deregister = = = = = = = = = =");
					System.out.print(" Please enter the user name or ID you want to remove: ");
					if(scanner.hasNextInt()){	// if enter user ID
						inInt = scanner.nextInt();
						Account.removeUser("", inInt, user);
					} else {					// if enter user name
						inString = scanner.next();
						Account.removeUser(inString, 0, user);
					}*/
			}
		});			
		
		//option5
		option5.setBounds(310, 160, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option5);
		option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.register();	
			}
		});		
		
		//option6
		option6.setBounds(310, 220, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option6);
		option6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});	
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
		/*Scanner scanner = new Scanner(System.in);
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
		*/
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int imwidth = bgimage.getWidth(null);
		int imheight = bgimage.getHeight(null);
		g.drawImage(bgimage, 1, 1, null);
	}
}
