/********************************************
* Project Team:	
* Students: 
* Course: OOP 2015 Sem 1, HDIT
*
*  
********************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AdminMenu extends JPanel{

	private JScrollPane scrollPane;
	private static final int BOTTON_WIDTH    = 300;
    private static final int BOTTON_HEIGHT   = 25;
	private static final int TABLE_WIDTH    = 300;
    private static final int TABLE_HEIGHT   = 360;

	private JLabel title;
	//Users Detailed Information
	private JButton option1 = new JButton("1. List All Users ");
	private JButton option2 = new JButton("2. Users Searching");
	private JButton option3 = new JButton("3. Create Users");
	
	//Courses Detailed Information
	private JButton option4 = new JButton("4. List All Courses ");
	private JButton option5 = new JButton("5. Courses Searching");
	private JButton option6 = new JButton("6. Create Courses");	//not done
	
	private JButton edit 	= new JButton("Edit"); //edit course not done
	private JButton remove = new JButton("Remove");
	
	public AdminMenu(Admin admin){
		
		setBounds(0, 0, 1020, 660);
		setOpaque(false);
		setLayout(null);
		setVisible(true);
		
		//table
		Menus.table = new JTable();
		scrollPane = new JScrollPane(Menus.table);
		scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT);
		add(scrollPane);
		
/////Users Detailed Information		
		//option1
		option1.setBounds(30, 430, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option1);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT-30);
				setting(1);
				Account.listAll();
			}
		});
		
		//option2
		option2.setBounds(30, 460, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option2);
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(1);
				UserSearching frame = new UserSearching();
				frame.setVisible(true);
			}
		});
		
		//option3
		option3.setBounds(30, 490, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option3);
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(1);
				Register frame = new Register(false);
				frame.setVisible(true);
				Account.listAll();
			}
		});		
		
/////Courses Detailed Information
		//option4
		option4.setBounds(350, 430, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option4);
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT-30);
				setting(2);
				Curriculum.listAll();
			}
		});
	
		//option5
		option5.setBounds(350, 460, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option5);
		option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(2);
				CourseSearching frame = new CourseSearching(admin);
				frame.setVisible(true);
			}
		});		
	
		//option6
		option6.setBounds(350, 490, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option6);
		option6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(2);
				CourseCreating frame = new CourseCreating(admin);
				frame.setVisible(true);
			}
		});			
		
				edit.setBounds(671, 363, 150, 30);
		add(edit);
		edit.setVisible(true);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(Menus.Detail == 1){	
					if(value() != -1){
						UserEditing frame = new UserEditing(value());
						frame.setVisible(true);
					}
				}else{
					if(value() != -1){
						CourseEditing frame = new CourseEditing(value());
						frame.setVisible(true);
					}
				}	
			}
		});	
		
		remove.setBounds(821, 363, 150, 30);
		add(remove);
		remove.setVisible(true);
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Menus.Detail == 1){	
					if(value() != -1) Account.removeUser(value(),admin);
				}else{
					if(value() != -1) Curriculum.removeCourse(value());
				}
			}
		});	
	
    }
	
	private int value(){
		if(Menus.table.getValueAt(Menus.table.getSelectedRow(), 0) != null){
			String inStr = 	Menus.table.getValueAt(Menus.table.getSelectedRow(), 0).toString();
			if(IOValidation.numberValid(inStr)){
				return Integer.parseInt(inStr);
			}else 
				return -1;
		}else{
			JOptionPane.showMessageDialog(null, "Please Select the right records.");
			return -1;
		}
	}
	
	private	void setting(int i){
		Menus.Detail = i;
	}
	
}