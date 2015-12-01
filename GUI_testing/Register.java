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
import java.time.LocalDate;
import java.text.ParseException;


class Register extends SSEM {
	
	public void register(boolean self) {
		
		JFrame registerframe = new JFrame();
		registerframe.setSize(360, 640);
		
		//set center
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 360) / 2;
		final int y = (screenSize.height - 640) / 2;
		registerframe.setLocation(x, y);
		registerframe.setVisible(true);
		SSEM.quit(this);	
		
		//panel
		JPanel panel = new JPanel();
		registerframe.add(panel);
		panel.setLayout(null);		
		panel.setBackground( new Color(26, 188, 156) );


		//messae box
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 324, 250);
		textArea.setText(
			"--------------------------------------------------------------------------------\n" +
			"-                                       User Register                                       -\n" +
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
			
			
		//name
		JLabel userLabel = new JLabel("Name:");
		userLabel.setBounds(10, 270, 80, 25);
		panel.add(userLabel);

		JTextField username = new JTextField(20);
		username.setBounds(100, 270, 160, 25);
		panel.add(username);

		//password
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 310, 80, 25);
		panel.add(passwordLabel);

		JPasswordField password = new JPasswordField(20);
		password.setBounds(100, 310, 160, 25);
		panel.add(password);	
		
		//re-password
		
		//email
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(10, 350, 80, 25);
		panel.add(emailLabel);

		JTextField email = new JTextField(20);
		email.setBounds(100, 350, 160, 25);
		panel.add(email);	
		
		//phone
		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(10, 390, 80, 25);
		panel.add(phoneLabel);

		JTextField phone = new JTextField(20);
		phone.setBounds(100, 390, 160, 25);
		panel.add(phone);	
			
		//Date of birth (YYYY/MM/DD)
		JLabel birthLabel = new JLabel("Date of birth:");
		birthLabel.setBounds(10, 430, 80, 25);
		panel.add(birthLabel);

		JTextField birth = new JTextField(20);
		birth.setBounds(100, 430, 160, 25);
		panel.add(birth);	
		
		//SignUp
		JButton signupButton = new JButton("Signup");
		signupButton.setBounds(10, 470, 80, 25);
		panel.add(signupButton);

		//Cancel
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(100, 470, 80, 25);
		panel.add(cancelButton);

		/*	
        System.out.println("#####################################################");
        System.out.println("# Please check the information correctly");
        System.out.println("#   Your user name: \t" + inUserName);
        System.out.println("#   Your E-mail: \t" + inEmail);
        System.out.println("#   Your Phone: \t" + inPhone);
        System.out.println("#   Date of Birth: \t" + inDate);
        System.out.println("#####################################################");
		*/
		
/////listener/////////////////////////////////////////////////
		
		//name////on ENTER key switch to password 
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkname(username.getText())) password.requestFocusInWindow();
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
				
				String userString = username.getText();
				char[] pass = password.getPassword();
				String passString = new String(pass);
				String emailString = email.getText();
				String phoneString = phone.getText();
				String birthString = birth.getText();

				if(checkname(userString) && checkpassword(passString) && checkemail(emailString) &&	checkphone(phoneString) && checkbirth(birthString)){
					if(JOptionPane.showConfirmDialog(null, "Create account ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
						int uid = Account.userlist.get(Account.userlist.size() - 1).getUserID() + 1;
						passString = CryptWithMD5.cryptWithMD5(passString);
						Trainee newtrainee = new Trainee(uid, userString, passString);
						newtrainee.setTraineeInfo(emailString,phoneString,3);
			            LocalDate dateOfbDay = LocalDate.parse(birthString);
			            // Problem to fix ---------
			            // 2015-8-9 -> ERROR
			            // 2015-08-09 -> Successful
			            // consider to change option panel?
			            newtrainee.setUserBirth(dateOfbDay);
						Account.updateuserlist(newtrainee);
						JOptionPane.showMessageDialog(null, "Account ["+userString+"] created! Please login.");
						registerframe.dispose();
						if(self)SSEM.main.setVisible(true);		
					} else {
						JOptionPane.showMessageDialog(null, "Action Cancelled & SYSTEM END."," ",JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		
		
		//cancel
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				registerframe.dispose();
				if(self)SSEM.main.setVisible(true);						
			}
		});
		
		
	}

//checking function/////////////////////////////////////////////	
	private boolean checkname(String userString){
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
	
	private boolean checkbirth(String birthString){
		Date bDay = new Date();
		if(!IOValidation.dateValid(birthString)){
			JOptionPane.showMessageDialog(null, "Wrong Format! Please enter again"," ",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			String[] dateSplit = birthString.split("-");
			int year = Integer.parseInt(dateSplit[0]);
			int month = Integer.parseInt(dateSplit[1]);
			int day = Integer.parseInt(dateSplit[2]);
			if(month < 0 || month > 12) {
				JOptionPane.showMessageDialog(null, "Wrong Format! Month cannot be less than 1 or more than 12! "," ",JOptionPane.WARNING_MESSAGE);
				return false;
			} else if(day < 0 || day > 31) {
				JOptionPane.showMessageDialog(null, "Wrong Format! "," ",JOptionPane.WARNING_MESSAGE);
				return false;
			} else {
				
			}
		return true;
		}	
	}
}