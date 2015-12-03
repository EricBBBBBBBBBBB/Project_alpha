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


class Register extends JFrame {
	
//////Data Members
    private static final int FRAME_WIDTH    = 360;
    private static final int FRAME_HEIGHT   = 640; 
	private static int listID;
	
	
	
	public Register(boolean self) {
		Container   contentPane;

        JButton 	signup;
        JButton     cancel;
		JTextArea 	textArea;
		JTextField 	username;
		JPasswordField 	password;
		JTextField 	email;
		JTextField 	phone;
		JTextField 	birth;

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("SSEM - User Register");

		//set center
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 360) / 2;
		final int y = (screenSize.height - 640) / 2;
		setLocation(x, y);

        contentPane = getContentPane();
        contentPane.setLayout(null);
		contentPane.setBackground( new Color(26, 188, 156) );
		

		//messae box
		textArea = new JTextArea();
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
			"      - letters and digit \n" +
			"   Day of Brith (YYYY-MM-DD)\n" +
			"      - e.g. 1997-01-24"
		);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
			
		//name
		JLabel userLabel = new JLabel("Name:");
		userLabel.setBounds(10, 270, 80, 25);
		username = new JTextField(20);
		username.setBounds(100, 270, 160, 25);

		//password
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 310, 80, 25);
		password = new JPasswordField(20);
		password.setBounds(100, 310, 160, 25);

		
		//re-password
		
		//email
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(10, 350, 80, 25);
		email = new JTextField(20);
		email.setBounds(100, 350, 160, 25);
		
		//phone
		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(10, 390, 80, 25);
		phone = new JTextField(20);
		phone.setBounds(100, 390, 160, 25);
			
		//Date of birth (YYYY/MM/DD)
		JLabel birthLabel = new JLabel("Date of birth:");
		birthLabel.setBounds(10, 430, 80, 25);
		birth = new JTextField(20);
		birth.setBounds(100, 430, 160, 25);
		
		//SignUp
		signup = new JButton("Signup");
		signup.setBounds(10, 470, 80, 25);

		//Cancel
		cancel = new JButton("Cancel");
		cancel.setBounds(100, 470, 80, 25);

		contentPane.add(textArea);	
		contentPane.add(userLabel);			
		contentPane.add(username);	
		contentPane.add(passwordLabel);		
		contentPane.add(password);		
		contentPane.add(emailLabel);		
		contentPane.add(email);
		contentPane.add(phoneLabel);
		contentPane.add(phone);
		contentPane.add(birthLabel);
		contentPane.add(birth);
        contentPane.add(signup);
        contentPane.add(cancel);
		
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		
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
				if(checkbirth(birth.getText())) signup.doClick();				
			}
		}); 		
		
		//signup
		signup.addActionListener(new ActionListener() {
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
						dispose();
						if(self)SSEM.main.setVisible(true);		
					} else {
						JOptionPane.showMessageDialog(null, "Action Cancelled & SYSTEM END."," ",JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});

		//cancel
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				dispose();
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
			JOptionPane.showMessageDialog(null, "Birthday wrong Format! Please enter again"," ",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			String[] dateSplit = birthString.split("-");
			int year = Integer.parseInt(dateSplit[0]);
			int month = Integer.parseInt(dateSplit[1]);
			int day = Integer.parseInt(dateSplit[2]);
			if(month < 0 || month > 12) {
				JOptionPane.showMessageDialog(null, "Birthday wrong Format! Month must between 1 and 12! "," ",JOptionPane.WARNING_MESSAGE);
				return false;
			} else if(day < 0 || day > 31) {
				JOptionPane.showMessageDialog(null, "Birthday wrong Format! Day not accept "," ",JOptionPane.WARNING_MESSAGE);
				return false;
			} else {
				
			}
		return true;
		}	
	}
}