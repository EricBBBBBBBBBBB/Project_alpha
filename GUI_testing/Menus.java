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
import javax.swing.table.*;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Menus extends SSEM{

	public static JTable table;
	public static int Detail;
	
	Menus(User user) {
		add(new MenusPanel(user));
		setSize(1015, 645);
		
		//set center
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 1010) / 2;
		final int y = (screenSize.height - 650) / 2;	
		setLocation(x, y);
		setVisible(true);	
		
		//set title 
		switch(user.getUserType()) {
			case "Trainee":
				setTitle("Trainee Menu");
				break;
			case "Trainer":
				setTitle("Trainer Menu");
				break;
			case "Admin":
				setTitle("Admin Menu");
				break;
			default:
				setTitle("Menu");
		}	
	}
	
}

//panel
class MenusPanel extends JPanel implements Files {

	private User user;
	private JButton Infomation = new JButton("View Personal Infomation");
	private JButton ChangePW = new JButton("Change Password");	
	private JButton Logout = new JButton("Logout");

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
				Trainee trainee = (Trainee) user;		
				add(new TraineeMenu(trainee));
				break;
			case "Trainer":
				Trainer trainer = (Trainer) user;		
				add(new TrainerMenu(trainer));
				break;
			case "Admin":
				Admin admin = (Admin) user;	
				add(new AdminMenu(admin));
				break;
			default:
				JOptionPane.showMessageDialog(null, "Unknown Comment, Please Restart The System."," ",JOptionPane.WARNING_MESSAGE);
		}	
		
		//Infomation
		Infomation.setBounds(670, 430, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(Infomation);
		Infomation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.printUserInfo();
			}
		});		
		
		//ChangePW
		ChangePW.setBounds(670, 460, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(ChangePW);
		ChangePW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});	
		
		//logout
		Logout.setBounds(670, 490, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(Logout);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});		
		
		add(new test(u));
		
		//for clicking table
		Menus.table.addMouseListener(new Click());
	}	
	
	private void changePassword(){
		/*System.out.println("=================== Change Password =================");
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
		
		System.out.println("=====================================================");*/
	}
	
	private void logout(){
		//Prompt user for saving
		int confirm = JOptionPane.showOptionDialog(null, "Are you want to logout ?","Logout Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (confirm == 0) {
			int save = JOptionPane.showOptionDialog(null, "Are You Sure to Save All Updates?","Update Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if(save == 0){
				//Backup
				UserIO.writeUTxtFile(DEF_USER.substring(0,DEF_USER.length() - 4) + "_BackUp.csv", Account.userlist);	
				CourseIO.writeCTxtFile(DEF_COURSE.substring(0,DEF_COURSE.length() - 4) + "_BackUp.csv", Curriculum.courselist);	
				//Write
				UserIO.writeUTxtFile(DEF_USER, Account.userlist);
				CourseIO.writeCTxtFile(DEF_COURSE, Curriculum.courselist);
				JOptionPane.showMessageDialog(null, "Updates Saved.");
				SSEM.main.setVisible(true);
				SSEM.menus.dispose();
			}else{
				SSEM.main.setVisible(true);
				SSEM.menus.dispose();
			}
		} else {
			//do nothing
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int imwidth = bgimage.getWidth(null);
		int imheight = bgimage.getHeight(null);
		g.drawImage(bgimage, 0, 0, imwidth,imheight, this);
	}
	
	class Click extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() <= 10 && Menus.table.getValueAt(Menus.table.getSelectedRow(), 0) != null){
				int i = Integer.parseInt(Menus.table.getValueAt(Menus.table.getSelectedRow(), 0).toString());
				switch(Menus.Detail) {
					case 1:
						i = Account.searchuserlistID(i);
						Account.userlist.get(i).printUserInfo();
						break;
					case 2:
						i = Curriculum.searchcourselistID(i);
						Curriculum.courselist.get(i).printCourseInfo();
						break;
					case 3:
						i = Curriculum.searchcourselistID(i);
						Curriculum.courselist.get(i).printCourseTrainee();
						break;
					default:
						JOptionPane.showMessageDialog(null, "Unknown Comment."," ",JOptionPane.WARNING_MESSAGE);
				}	
				
				
					
				
			}
		}
	}
	
}
