/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
* SSEM.java: 
********************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SSEM extends JFrame implements Files {
	
	public static SSEM main;
	public static Menus menus;
	
	SSEM() {
		add(new SSEMPanel());
		setSize(376, 640);
		
		//set center
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 376) / 2;
		final int y = (screenSize.height - 640) / 2;
		setLocation	 (x, y);
        setTitle     ("SSEM");
		
		quit(this);	
	}
	

	public static void main(String[] args) {
		
		//loading data
		Account.inituserlist();
		Curriculum.initcourselist();
		
		main = new SSEM();
		main.setVisible(true);

	}
	
	public static void quit(JFrame f){
		f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		WindowListener exitListener = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Close Application?","Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
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
						System.exit(0);
					}else{
						System.exit(0);	
					}
				}else{
					//do nothing
				}
			}
		};
		f.addWindowListener(exitListener);
	}

}

//panel
class SSEMPanel extends JPanel {
	Image bgimage = null;
	SSEMPanel() {
		
		setLayout(null);	
		Font font = new Font("Airal", Font.PLAIN, 20);
		Color fontcolor = new Color(52,73,94);
		
		//background
		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage("img/background.png");
		mt.addImage(bgimage, 0);
		try {
		  mt.waitForAll();
		} catch (InterruptedException e) {
		  e.printStackTrace();
		}
		
		//init item
		JTextField username = new JTextField(20);
		JPasswordField password = new JPasswordField(20);
		JButton loginButton = new JButton(new ImageIcon("img/login.png"));
		JButton signupButton = new JButton(new ImageIcon("img/signup.png"));

		//user name
		username.setBounds(62, 369, 210, 25);
		username.setBorder(null);
		username.setFont(font);
		username.setForeground(fontcolor);
		add(username);
		//on ENTER key switch to password
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  password.requestFocusInWindow();    
			}
		}); 
		
		//password
		password.setBounds(62, 421, 210, 25);
		password.setBorder(null);
		password.setFont(font);
		password.setForeground(fontcolor);
		add(password);		
		//on ENTER key login
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButton.doClick();
			}
		}); 	
		
		//login
		loginButton.setBounds(58, 468, 245, 37);
		loginButton.setBorder(null);
		add(loginButton);
		//login function 
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButton.setVisible(false);			
			
				//get User name
				String userString = username.getText();
				
				//get password
				char[] pass = password.getPassword();
				String passString = new String(pass);
				passString = CryptWithMD5.cryptWithMD5(passString);

				//User validate
				boolean loginSuccess = false;
				int loginID = 0;
				for (int i = 0; i < Account.userlist.size(); i++) {
					if(Account.userlist.get(i).validateUser(userString, passString)){
						loginSuccess = true;
						loginID = i;
						break;
					}
				}
				if(!loginSuccess){
					JOptionPane.showMessageDialog(null, "Login fail, please login again."," ",JOptionPane.WARNING_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Login in successfully!");
					User loginUser = Account.userlist.get(loginID);
					
					//logining
					SSEM.main.setVisible(false);
					username.setText("");
					password.setText("");
					SSEM.menus = new Menus(loginUser);	
				
				}
			loginButton.setVisible(true);				
			}
		});

		
		//SignUp
		signupButton.setBounds(140, 513, 80, 25);
		signupButton.setBorder(null);
		add(signupButton);
		//signup function
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				SSEM.main.setVisible(false);
				Register frame = new Register(true);
				frame.setVisible(true);
			}
		});
		
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int imwidth = bgimage.getWidth(null);
		int imheight = bgimage.getHeight(null);
		g.drawImage(bgimage, 0, 0, imwidth,imheight, this);
	}

}

