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


class Register extends SSEM {
	
	public void register() {
		
		JFrame registerframe = new JFrame();
		registerframe.setSize(360, 640);
		
		//set center
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 360) / 2;
		final int y = (screenSize.height - 640) / 2;
		registerframe.setLocation(x, y);
		
		registerframe.setUndecorated(true);
		registerframe.setVisible(true);
		
		//panel
		JPanel panel = new JPanel();
		registerframe.add(panel);
		panel.setLayout(null);		
		
		//title
		JLabel Title = new JLabel("User Register");
		Title.setBounds(10, 10, 1000, 25);
		panel.add(Title);
			
			
		//name
		JLabel userLabel = new JLabel("Name:");
		userLabel.setBounds(10, 40, 80, 25);
		panel.add(userLabel);

		JTextField username = new JTextField(20);
		username.setBounds(100, 40, 160, 25);
		panel.add(username);

		//password
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 80, 80, 25);
		panel.add(passwordLabel);

		JPasswordField password = new JPasswordField(20);
		password.setBounds(100, 80, 160, 25);
		panel.add(password);	
		
		//re-password
		
		//email
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(10, 120, 80, 25);
		panel.add(emailLabel);

		JTextField email = new JTextField(20);
		email.setBounds(100, 120, 160, 25);
		panel.add(email);	
		
		//phone
		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(10, 160, 80, 25);
		panel.add(phoneLabel);

		JTextField phone = new JTextField(20);
		phone.setBounds(100, 160, 160, 25);
		panel.add(phone);	
			
		//Date of birth (YYYY/MM/DD)
		JLabel birthLabel = new JLabel("Date of birth (YYYY/MM/DD):");
		birthLabel.setBounds(10, 200, 80, 25);
		panel.add(birthLabel);

		JTextField birth = new JTextField(20);
		birth.setBounds(100, 200, 160, 25);
		panel.add(birth);	
		
		//SignUp
		JButton signupButton = new JButton("Signup");
		signupButton.setBounds(10, 240, 80, 25);
		panel.add(signupButton);

		//Cancel
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(100, 240, 80, 25);
		panel.add(cancelButton);
		
		
		/*


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
		
        System.out.println("#####################################################");
        System.out.println("# Please check the information correctly");
        System.out.println("#   Your user name: \t" + inUserName);
        System.out.println("#   Your E-mail: \t" + inEmail);
        System.out.println("#   Your Phone: \t" + inPhone);
        System.out.println("#   Date of Birth: \t" + inDate);
        System.out.println("#####################################################");


		*/
		
/////////////////////////////////////////////////////////
		
		//on ENTER key switch to password from name
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkname(username.getText())) password.requestFocusInWindow();
			}
		}); 
		
		//on ENTER key switch to email from password
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] pass = password.getPassword();				
				String passString = new String(pass);	
				if(checkpassword(passString)) email.requestFocusInWindow();
			}
		}); 

		//on ENTER key switch to phone from email
		email.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkemail(email.getText()))	phone.requestFocusInWindow();
			}
		}); 
		
		//on ENTER key switch to birth from phone
		phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkphone(phone.getText())) birth.requestFocusInWindow();
			}
		}); 

		//brith
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

				if(checkname(userString) && checkpassword(passString) && checkemail(emailString) &&	checkphone(phoneString)){
					if(JOptionPane.showConfirmDialog(null, "Create account ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
						int uid = Account.userlist.get(Account.userlist.size() - 1).getUserID() + 1;
						passString = CryptWithMD5.cryptWithMD5(passString);
						Trainee newtrainee = new Trainee(uid, userString, passString);
						newtrainee.setTraineeInfo(emailString,phoneString,3);
						//newtrainee.setUserBirth();
						Account.updateuserlist(newtrainee);
						JOptionPane.showMessageDialog(null, "Account ["+userString+"] created! Please login.");
						registerframe.dispose();
						SSEM.main.setVisible(true);		
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
				SSEM.main.setVisible(true);						
			}
		});
		
		
	}
	
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
			String[] dateSplit = birthString.split("/");
			int year = Integer.parseInt(dateSplit[0]);
			int month = Integer.parseInt(dateSplit[1]);
			int day = Integer.parseInt(dateSplit[2]);
			if(month < 0 || month > 12)
				JOptionPane.showMessageDialog(null, "Wrong Format!"," ",JOptionPane.WARNING_MESSAGE);
			else if(day < 0 || day > 31)
				JOptionPane.showMessageDialog(null, "Wrong Format!"," ",JOptionPane.WARNING_MESSAGE);
			else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				try {  
					bDay = sdf.parse(birthString);  
				} catch (ParseException pe) {  
					JOptionPane.showMessageDialog(null, "Wrong Format!"," ",JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(null, pe.getMessage()," ",JOptionPane.WARNING_MESSAGE);
				} 
			}
		return true;
		}	
	}
	
}