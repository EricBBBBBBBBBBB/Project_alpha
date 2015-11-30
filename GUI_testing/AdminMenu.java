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

class AdminMenu extends JPanel{

	public static JTable table;
	private JScrollPane scrollPane;
	private static final int BOTTON_WIDTH    = 300;
    private static final int BOTTON_HEIGHT   = 25;
	private static final int TABLE_WIDTH    = 300;
    private static final int TABLE_HEIGHT   = 360;
	
	private JLabel title;
	private JButton option1 = new JButton("1. XXXXXXXXXXXXXX");
	private JButton option2 = new JButton("2. XXXXXXXXXXXXXX");
	private JButton option3 = new JButton("3. XXXXXXXXXXXXXX");
	private JButton option4 = new JButton("4. XXXXXXXXXXXXXX");
	private JButton option5 = new JButton("5. View Personal Infomation");
	private JButton option6 = new JButton("6. Change Password");

	public AdminMenu(Admin admin){
		
		setBounds(0, 0, 1020, 660);
		setOpaque(false);
		setLayout(null);
		setVisible(true);
		
		//title
		title = new JLabel("Admin Menu");
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
				
			}
		});
		
		//option2
		option2.setBounds(30, 460, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option2);
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT-30);
				
				
			}
		});

		
		//option3
		option3.setBounds(30, 490, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option3);
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT);
				
			}
		});
		
		//option4
		option4.setBounds(350, 430, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option4);
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setBounds(671, 33, TABLE_WIDTH, TABLE_HEIGHT);
				
			}
		});		
		
		//option5
		option5.setBounds(350, 460, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option5);
		option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.printUserInfo();
			}
		});			
		
		//option6
		option6.setBounds(350, 490, BOTTON_WIDTH, BOTTON_HEIGHT);
		add(option6);
		option6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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