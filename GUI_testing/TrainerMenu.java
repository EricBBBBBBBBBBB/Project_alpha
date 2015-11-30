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
import javax.swing.table.*;

class TrainerMenu extends JPanel{

	public static JTable table;
	private JScrollPane scrollPane;
	private static final int BOTTON_WIDTH    = 300;
    private static final int BOTTON_HEIGHT   = 25;
	private static final int TABLE_WIDTH    = 300;
    private static final int TABLE_HEIGHT   = 360;
	
	private JLabel title;
	private JButton option1 = new JButton("1. Owned Courses List");
	private JButton option2 = new JButton("2. Courses Enrolled Trainees");
	private JButton option3 = new JButton("3. Courses Complete");
	private JButton option4 = new JButton("4. View Personal Infomation");
	private JButton option5 = new JButton("5. Change Password");
	private JButton complete = new JButton("Complete");

	public TrainerMenu(Trainer trainer){
		
		setBounds(0, 0, 1020, 660);
		setOpaque(false);
		setLayout(null);
		setVisible(true);
		
		//title
		title = new JLabel("Trainer Menu");
		title.setBounds(30, 5, 300, 25);
		add(title);
		
		//table
		table = new JTable();
		scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		//option1
		option1.setBounds(30, 430, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option1);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT);
				Curriculum.listOwnedCourse(trainer.getUserID(),true);	
			}
		});
		
		//option2
		option2.setBounds(30, 460, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option2);
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT);
				
			}
		});
		
		//option3
		option3.setBounds(30, 490, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option3);
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT-30);
				Curriculum.listOwnedCourse(trainer.getUserID(),false);	
				complete.setVisible(true);
			}
		});
		
		complete.setBounds(671, 363, 300, 30);
		add(complete);
		complete.setVisible(false);
		complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculum.completeCourse(trainer.getUserID());	
			}
		});
		
		//option4
		option4.setBounds(350, 430, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option4);
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainer.printUserInfo();
			}
		});		
		
		//option5
		option5.setBounds(350, 460, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option5);
		option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//changePassword();
			}
		});			
		
		//for clicking table
		table.addMouseListener(new Click());
		
    }
	
	class Click extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() <= 5){
				int i = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())-1;
				Curriculum.courselist.get(i).printCourseInfo();
			}
		}
	}
	
}