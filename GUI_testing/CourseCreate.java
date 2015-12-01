/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Register.java: 
********************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


class CourseCreate extends SSEM {
	
	public void coursecreate() {
		
		JFrame coursecreateframe = new JFrame();
		coursecreateframe.setSize(360, 640);
		
		//set center
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 360) / 2;
		final int y = (screenSize.height - 640) / 2;
		coursecreateframe.setLocation(x, y);
		coursecreateframe.setVisible(true);
		SSEM.quit(this);	
		
		//panel
		JPanel panel = new JPanel();
		coursecreateframe.add(panel);
		panel.setLayout(null);		
		panel.setBackground( new Color(26, 188, 156) );


		//messae box
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 324, 250);
		textArea.setText(
			"--------------------------------------------------------------------------------\n" +
			"-                                       Course Create                                      -\n" +
			"--------------------------------------------------------------------------------\n" +
			"Please enter the information requested completely!\n\n" +
			"Rules for a valid Login ID for a user account:\n" +
			"   Login ID must contain: \n" +
			"      - 8~12 characters \n" +
			"      - Just LOWER-CASE letters \n" +
			"      - no starting with digit \n" +
			"   Password must contain: \n" +
			"      - 8~12 characters \n" +
			"      - letters and digit \n\n" +
			"   Day of Brith (YYYY/MM/DD)"
		);
		textArea.setLineWrap(true);
		panel.add(textArea);
			
			
		//course name
		JLabel courseLabel = new JLabel("Course Name:");
		courseLabel.setBounds(10, 270, 80, 25);
		panel.add(courseLabel);

		JTextField coursename = new JTextField(20);
		coursename.setBounds(100, 270, 160, 25);
		panel.add(coursename);

		//course type//// need valid 1,2,3
		JLabel typeLabel = new JLabel("Course Type:");
		typeLabel.setBounds(10, 310, 80, 25);
		panel.add(typeLabel);
		
       // JComboBox typeList = new JComboBox();

		
		
		
		//course trainer//// need id
		JLabel trainerLabel = new JLabel("Course Trainer:");
		trainerLabel.setBounds(10, 350, 80, 25);
		panel.add(trainerLabel);

		JTextField trainer = new JTextField(20);
		trainer.setBounds(100, 350, 160, 25);
		panel.add(trainer);
		
		
		
		//SignUp
		JButton signupButton = new JButton("Signup");
		signupButton.setBounds(10, 470, 80, 25);
		panel.add(signupButton);

		//Cancel
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(100, 470, 80, 25);
		panel.add(cancelButton);

		
/////listener/////////////////////////////////////////////////
		
		/**		
		//course name////on ENTER key switch to password 
		coursename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		}); 
	
		//password////on ENTER key switch to email 
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] pass = password.getPassword();				
				String passString = new String(pass);	
				if(checkpassword(passString)) email.requestFocusInWindow();
			}
		}); 

		//email////on ENTER key switch to phone  
		email.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkemail(email.getText()))	phone.requestFocusInWindow();
			}
		}); 
		
		//phone////on ENTER key switch to birth  
		phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkphone(phone.getText())) birth.requestFocusInWindow();
			}
		}); 

		//brith////on ENTER key click the sign up
		birth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkbirth(birth.getText())) signupButton.doClick();				
			}
		}); 		

		//signup
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				int courseID = Currculum.courselist.get(Currculum.courselist.size() - 1).getCourseID() + 1;
				String courseName = coursename.getText();
				int courseType = ;
		        boolean completed = false;
				int courseTrainer = ;
				int duration = ;
				
				if(JOptionPane.showConfirmDialog(null, "Create course ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					Course newcourse = new Course(courseID, courseName, courseType);
					newcourse.setCourseInfo(completed, courseTrainer, duration, venue, price, target, description, max);
					courselist.add(newcourse);
					JOptionPane.showMessageDialog(null, "Account ["+userString+"] created! Please login.");
					createcourseframe.dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "Action Cancelled."," ",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		*/		
		//cancel
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				coursecreateframe.dispose();			
			}
		});
		
		
	}


//checking function/////////////////////////////////////////////	
	/**private boolean checkname(String userString){
		if(!IOValidation.usernameValid(userString)){
			JOptionPane.showMessageDialog(null, "User name not accept! Please enter again."," ",JOptionPane.WARNING_MESSAGE);
			return false;
		}else {
			if(Account.searchUserReBo(userString)) {
				JOptionPane.showMessageDialog(null, "The name has been used."," ",JOptionPane.WARNING_MESSAGE);
				return false;
			}else return true;
		}
	}
	
	private boolean checkpassword(String passwordString){
		if(passwordString.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Password could not be empty! Please enter again."," ",JOptionPane.WARNING_MESSAGE);
			return false;
		}else return true;
	}
	
	private boolean checkemail(String emailString){
		if(!IOValidation.emailValid(emailString)) {
			JOptionPane.showMessageDialog(null, "Email not accept! Please enter again."," ",JOptionPane.WARNING_MESSAGE);
			return false;
		}else{
			return true;
		}
	}

	private boolean checkphone(String phoneString){
		if(!IOValidation.phoneValid(phoneString)) {
			JOptionPane.showMessageDialog(null, "Phone not accept! Please enter again."," ",JOptionPane.WARNING_MESSAGE);
			return false;
		}else return true;
	}
	
	*/
}