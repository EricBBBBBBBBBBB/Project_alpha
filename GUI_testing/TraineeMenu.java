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

class TraineeMenu extends JPanel{


	private JScrollPane scrollPane;
	private static final int BOTTON_WIDTH    = 300;
    private static final int BOTTON_HEIGHT   = 25;
	private static final int TABLE_WIDTH    = 300;
    private static final int TABLE_HEIGHT   = 360;
	
	private JLabel title;
	private JButton option1 = new JButton("1. View the Current Available Courses");
	private JButton option2 = new JButton("2. Display Current/completed Courses");
	private JButton option3 = new JButton("3. Display Targets Set");
	
	private JButton join = new JButton("join");

	public TraineeMenu(Trainee trainee){
		
		setBounds(0, 0, 1020, 660);
		setOpaque(false);
		setLayout(null);
		setVisible(true);
		Menus.Detail = 2;

		//table
		Menus.table = new JTable();
		scrollPane = new JScrollPane(Menus.table);
		add(scrollPane);
		
		//option1
		option1.setBounds(30, 430, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option1);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				join.setVisible(true);
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT-30);
				Curriculum.listAvaibleCourse(trainee.upadteTraineeType(),trainee.getUserID());	
			}
		});
		option1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_F1) {
					  option1.doClick();
				 }
			} 
		});
		
		//option2
		option2.setBounds(30, 460, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option2);
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT);
				Curriculum.listCCCourse(trainee.getUserID());	
			}
		});
		
		//option3
		option3.setBounds(30, 490, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option3);
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT);
				Curriculum.listTarget(trainee.getUserID());	
			}
		});
		
		join.setBounds(671, 363, 300, 30);
		add(join);
		join.setVisible(false);
		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(value() != -1) Curriculum.joinCourse(value(), trainee.upadteTraineeType(),trainee.getUserID());		
			}
		});
		
    }
	
	private int value(){
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