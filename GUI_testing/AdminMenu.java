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
	private JButton option3 = new JButton("3. Users Editing");
	private JButton editU 	= new JButton("Edit");
	private JButton option4 = new JButton("4. Remove Users");	
	private JButton removeU = new JButton("Remove");
	private JButton option5 = new JButton("5. Create Users");
	
	//Courses Detailed Information
	private JButton option6 = new JButton("6. List All Courses ");
	private JButton option7 = new JButton("7. Courses Searching");
	private JButton option8 = new JButton("8. Courses Editing");	//not done
	private JButton editC 	= new JButton("Edit");
	private JButton option9 = new JButton("9. Remove Courses");
	private JButton removeC = new JButton("Remove");
	private JButton option10 = new JButton("10. Create Courses");	//not done

	public AdminMenu(Admin admin){
		
		setBounds(0, 0, 1020, 660);
		setOpaque(false);
		setLayout(null);
		setVisible(true);
		
		//table
		Menus.table = new JTable();
		scrollPane = new JScrollPane(Menus.table);
		add(scrollPane);
		
		
/////Users Detailed Information		
		//option1
		option1.setBounds(30, 430, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option1);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				editU.setVisible(true);
			}
		});
		
		editU.setBounds(671, 363, 300, 30);
		add(editU);
		editU.setVisible(false);
		editU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(value() != -1){
					UserEditing frame = new UserEditing(value());
					frame.setVisible(true);
				}
			}
		});	
		
		//option4
		option4.setBounds(30, 520, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option4);
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(1);
				test.write("> User Deleting");
				removeU.setVisible(true);
			}
		});
		
		removeU.setBounds(671, 363, 300, 30);
		add(removeU);
		removeU.setVisible(false);
		removeU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(value() != -1) Account.removeUser(value(),admin);
			}
		});	
		
		//option5
		option5.setBounds(30, 550, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option5);
		option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(1);
				Register register = new Register();
				register.register(false);
				Account.listAll();
			}
		});		
		
/////Courses Detailed Information
		//option6
		option6.setBounds(350, 430, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option6);
		option6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(2);
				Curriculum.listAll();
			}
		});
	
		//option7
		option7.setBounds(350, 460, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option7);
		option7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(2);
				CourseSearching frame = new CourseSearching(admin);
				frame.setVisible(true);
			}
		});		
	
		//option8
		option8.setBounds(350, 490, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option8);
		option8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(2);
				test.write("> Course Information Editing");
				editC.setVisible(true);
			}
		});
	
		editC.setBounds(671, 363, 300, 30);
		add(editC);
		editC.setVisible(false);
		editC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(value() != -1){
					//CourseEditing frame = new CourseEditing(value());
					//frame.setVisible(true);
				}
			}
		});		
	
		//option9
		option9.setBounds(350, 520, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option9);
		option9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(2);
				test.write("> Course Deleting");
				removeC.setVisible(true);
			}
		});
	
		removeC.setBounds(671, 363, 300, 30);
		add(removeC);
		removeC.setVisible(false);
		removeC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(value() != -1) Curriculum.removeCourse(value());
			}
		});	
	
		//option10
		option10.setBounds(350, 550, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option10);
		option10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting(2);
				CourseCreate coursecreate = new CourseCreate();
				coursecreate.coursecreate();
				Curriculum.listAll();
			}
		});			
	
    }
	
	public int value(){
		if(Menus.table.getValueAt(Menus.table.getSelectedRow(), 0) != null){
			String inStr = 	Menus.table.getValueAt(Menus.table.getSelectedRow(), 0).toString();
			if(IOValidation.numberValid(inStr)){
				return Integer.parseInt(inStr);
			}else 
				return -1;
		}else{
			return -1;
		}
	}
	
	private	void setting(int i){
		scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT-30);
		buttonclear();
		Menus.Detail = i;
	}
	
	private	void buttonclear(){
		editU.setVisible(false);
		editC.setVisible(false);
		removeU.setVisible(false);
		removeC.setVisible(false);
	}
	
}