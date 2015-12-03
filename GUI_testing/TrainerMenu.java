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

class TrainerMenu extends JPanel{

	private JScrollPane scrollPane;
	private static final int BOTTON_WIDTH    = 300;
    private static final int BOTTON_HEIGHT   = 25;
	private static final int TABLE_WIDTH    = 300;
    private static final int TABLE_HEIGHT   = 360;
	
	private JButton option1 = new JButton("1. Owned Courses List");
	private JButton option2 = new JButton("2. Course Searching");
	private JButton option3 = new JButton("3. Courses Enrolled Trainees");
	private JButton option4 = new JButton("4. Courses Complete");	//not done
	
	private JButton complete = new JButton("Complete");
	private JButton view = new JButton("View Trainees");
	private JButton back = new JButton("Back");

	public TrainerMenu(Trainer trainer){
		
		setBounds(0, 0, 1020, 660);
		setOpaque(false);
		setLayout(null);
		setVisible(true);

		//table
		Menus.table = new JTable();
		scrollPane = new JScrollPane(Menus.table);
		add(scrollPane);
		
		//option1
		option1.setBounds(30, 430, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option1);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT);
				Menus.Detail = 2;
				Curriculum.listOwnedCourse(trainer.getUserID(),true);	
			}
		});
		
		//option2
		option2.setBounds(30, 460, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option2);
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT);
				CourseSearching frame = new CourseSearching(trainer);
				frame.setVisible(true);
			}
		});
		
		//option3
		option3.setBounds(30, 490, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option3);
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT-30);
				Menus.Detail = 3;
				Curriculum.enrolledTrainees(trainer.getUserID());
				view.setVisible(true);
			}
		});
		
		view.setBounds(671, 363, 300, 30);
		add(view);
		view.setVisible(false);
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(value() != -1){
					Menus.Detail = 1;
					Curriculum.viewTrainees(value());
					view.setVisible(false);
					back.setVisible(true);
				}
				
			}
		});			
		
		back.setBounds(671, 363, 300, 30);
		add(back);
		back.setVisible(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(value() != -1){
					Menus.Detail = 3;
					Curriculum.enrolledTrainees(trainer.getUserID());
					back.setVisible(false);
					view.setVisible(true);
				}
				
			}
		});	
		
		//option4
		option4.setBounds(30, 520, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option4);
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT-30);
				Curriculum.listOwnedCourse(trainer.getUserID(),false);	
				Menus.Detail = 2;
				complete.setVisible(true);
			}
		});
		
		complete.setBounds(671, 363, 300, 30);
		add(complete);
		complete.setVisible(false);
		complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(value() != -1)
				Curriculum.completeCourse(value(),trainer.getUserID());	
			}
		});		
		
    }
	
	public int value(){
		if(Menus.table.getValueAt(Menus.table.getSelectedRow(), 0) != null){
			String inStr = Menus.table.getValueAt(Menus.table.getSelectedRow(), 0).toString();
			if(IOValidation.numberValid(inStr)){
				return Integer.parseInt(inStr);
			}else 
				return -1;
		}else{
			JOptionPane.showMessageDialog(null, "Please Select the right records.");
			return -1;
		}
	}
		
}