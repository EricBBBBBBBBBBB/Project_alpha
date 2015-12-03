/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* Register.java: 
********************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

class UserEditing extends JFrame {

//////Data Members
    private static final int FRAME_WIDTH    = 300;
    private static final int FRAME_HEIGHT   = 600; 
	private static int listID;



//////Constructors

    public UserEditing(int uid) {
        Container   contentPane;
        JPanel      comboPanel, okPanel;

        JButton     okButton;
        JButton     cancel;
		JTextField 	username;
		JTextField 	email;
		JTextField 	phone;
        String[]    comboBoxItem = {"Trainees", "Trainers", "All Users"};


        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("SSEM - User Editing");
		
		//set center
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 300) / 2;
		final int y = (screenSize.height - 600) / 2;
		setLocation(x, y);

        contentPane = getContentPane();
        contentPane.setLayout(null);

		listID = Account.searchuserlistID(uid);
		
		//name
		JLabel userLabel = new JLabel("Name:");
		userLabel.setBounds(10, 10, 80, 25);
		username = new JTextField(20);
		username.setBounds(100, 10, 160, 25);
		username.setText(Account.userlist.get(listID).getUserName());
		
		//email
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(10, 50, 80, 25);
		email = new JTextField(20);
		email.setBounds(100, 50, 160, 25);
		email.setText(Account.userlist.get(listID).getUserEmail());

		//phone
		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(10, 90, 80, 25);
		phone = new JTextField(20);
		phone.setBounds(100, 90, 160, 25);
		phone.setText(Account.userlist.get(listID).getUserPhone());
		
        //create and place the OK button
        okButton = new JButton("OK");
		okButton.setBounds(10, 170, 80, 25);
      
	    //create and place the Cancel button
        cancel = new JButton("Cancel");
		cancel.setBounds(100, 170, 80, 25);
	

		contentPane.add(userLabel);		
		contentPane.add(username);		
		contentPane.add(emailLabel);		
		contentPane.add(email);
		contentPane.add(phoneLabel);
		contentPane.add(phone);
        contentPane.add(okButton);
        contentPane.add(cancel);
		
/////listener/////////////////////////////////////////////////
		//name////on ENTER key switch to password 
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkname(username.getText())) email.requestFocusInWindow();
			}
		}); 
		
		//email////on ENTER key switch to phone  
		email.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkemail(email.getText()))	phone.requestFocusInWindow();
			}
		}); 
		
		//phone////on ENTER key switch to  birth
		phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkphone(phone.getText())) okButton.doClick();
			}
		}); 

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		}); 
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( checkname(username.getText()) && checkphone(phone.getText()) && checkphone(phone.getText())){
					if(JOptionPane.showConfirmDialog(null, "Edit information ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					Account.userlist.get(listID).setUserName(username.getText());		
					Account.userlist.get(listID).setUserEmail(email.getText());		
					Account.userlist.get(UserEditing.listID).setUserPhone(phone.getText());
					Account.listAll();
					dispose();		
					} else {
						JOptionPane.showMessageDialog(null, "Action Cancelled & SYSTEM END."," ",JOptionPane.WARNING_MESSAGE);
					}
				}	
			}
		}); 		
    }

	//checking function/////////////////////////////////////////////	
	private boolean checkname(String userString){
		if(!IOValidation.usernameValid(userString)){
			JOptionPane.showMessageDialog(null, "User name not accept! Please enter again."," ",JOptionPane.WARNING_MESSAGE);
			return false;
		}else {
			return true;
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