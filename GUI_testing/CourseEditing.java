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


class CourseEditing extends JFrame {
	
//////Data Members
    private static final int FRAME_WIDTH    = 360;
    private static final int FRAME_HEIGHT   = 640; 
	private static int listID;
	
	
	
	public CourseEditing(int cid) {
		Container   contentPane;

        JButton 	create;
        JButton     cancel;
		JComboBox 	type;
		JComboBox 	duration;
		JComboBox 	price;
		JComboBox 	trainer;
		JTextArea 	textArea;
		JTextField 	coursename;
		JTextField 	descriotion;
		JTextField 	venue;
		JTextField 	target;

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("SSEM - Course Editing");

		//set center
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 360) / 2;
		final int y = (screenSize.height - 640) / 2;
		setLocation(x, y);

        contentPane = getContentPane();
        contentPane.setLayout(null);

		listID = Curriculum.searchcourselistID(cid);
		

		//messae box
		textArea = new JTextArea();
		textArea.setBounds(10, 10, 324, 200);
		textArea.setText(
			"--------------------------------------------------------------------------------\n" +
			"-                                     Course Register                                     -\n" +
			"--------------------------------------------------------------------------------\n" +
			"Please enter the information requested completely!\n\n" +
			"Rules for a valid name for a Course:\n" +
			"   Course must contain: \n" +
			"      - 8~50 characters \n" 
		);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		//course name
		JLabel courseLabel = new JLabel("Course Name:");
		courseLabel.setBounds(10, 220, 80, 25);
		coursename = new JTextField(20);
		coursename.setBounds(100, 220, 160, 25);
		coursename.setText(Curriculum.courselist.get(listID).getCourseName());

		//trainer id
		JLabel trainerLabel = new JLabel("Trainer ID:");
		trainerLabel.setBounds(10, 260, 80, 25);
        ArrayList<String> trainerarray = new ArrayList<String>();
		int tid = 0;
		for(int i = 0; i < Account.userlist.size() ; i++ ){
			if(Account.userlist.get(i) instanceof Trainer ){
				tid = Account.userlist.get(i).getUserID();
				trainerarray.add(Integer.toString(tid));
			}
		}
		String[] trainerItem = trainerarray.toArray(new String[trainerarray.size()]);
        trainer = new JComboBox(trainerItem);
		trainer.setBounds(100, 260, 160, 25);
		
		
		//type
		JLabel typeLabel = new JLabel("Course Type:");
		typeLabel.setBounds(10, 300, 80, 25);
        String[] typeItem = {"Beginner", "Intermediate", "Advanced"};
        type = new JComboBox(typeItem);
		type.setBounds(100, 300, 160, 25);
		
		//price
		JLabel priceLabel = new JLabel("Price:");
		priceLabel.setBounds(10, 340, 80, 25);
        String[] priceItem = {"100", "150", "200"};
        price = new JComboBox(priceItem);
		price.setBounds(100, 340, 160, 25);
			
		//Duration 
		JLabel durationLabel = new JLabel("Duration:");
		durationLabel.setBounds(10, 380, 80, 25);
		String[] durationItem = {"1 weeks", "2 weeks", "3 weeks"};
        duration = new JComboBox(durationItem);
		duration.setBounds(100, 380, 160, 25);
		
		//Venue 
		JLabel venueLabel = new JLabel("Venue :");
		venueLabel.setBounds(10, 420, 80, 25);
		venue = new JTextField(20);
		venue.setBounds(100, 420, 160, 25);
		venue.setText(Curriculum.courselist.get(listID).getVenue());
		
		//Target
		JLabel targetLabel = new JLabel("Target:");
		targetLabel.setBounds(10, 460, 80, 25);
		target = new JTextField(20);
		target.setBounds(100, 460, 160, 25);
		target.setText(Curriculum.courselist.get(listID).getTarget());
		
		//Description
		JLabel descriotionLabel = new JLabel("Description:");
		descriotionLabel.setBounds(10, 500, 80, 25);
		descriotion = new JTextField(20);
		descriotion.setBounds(100, 500, 160, 25);
		descriotion.setText(Curriculum.courselist.get(listID).getDescription());
		
		//Create
		create = new JButton("Create");
		create.setBounds(10, 540, 80, 25);

		//Cancel
		cancel = new JButton("Cancel");
		cancel.setBounds(100, 540, 80, 25);

		contentPane.add(textArea);	
		contentPane.add(courseLabel);			
		contentPane.add(coursename);	
		contentPane.add(trainerLabel);		
		contentPane.add(trainer);		
		contentPane.add(typeLabel);		
        contentPane.add(type);
		contentPane.add(priceLabel);
		contentPane.add(price);
		contentPane.add(durationLabel);
		contentPane.add(duration);
		contentPane.add(venueLabel);
		contentPane.add(venue);
		contentPane.add(targetLabel);
		contentPane.add(target);
		contentPane.add(descriotionLabel);
		contentPane.add(descriotion);
        contentPane.add(create);
        contentPane.add(cancel);
		
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		
/////listener/////////////////////////////////////////////////
		//name////on ENTER key switch to trainer 
		coursename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainer.requestFocusInWindow();
			}
		}); 
		
		//trainer////on ENTER key switch to type 
		trainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type.requestFocusInWindow();
			}
		}); 

		//type////on ENTER key switch to price  
		type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price.requestFocusInWindow();
			}
		}); 
		
		//price////on ENTER key switch to duration  
		price.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duration.requestFocusInWindow();
			}
		}); 

		//duration////on ENTER key click the venue
		duration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venue.requestFocusInWindow();			
			}
		}); 		

		//venue////on ENTER key click the target
		venue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				target.requestFocusInWindow();			
			}
		}); 	
		
		//target////on ENTER key click the descriotion
		target.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descriotion.requestFocusInWindow();			
			}
		}); 	
		
		//descriotion////on ENTER key click the sign up
		descriotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create.doClick();		
			}
		});


		//create
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
			
				String courseString = coursename.getText();
				int tid = (int) trainer.getSelectedItem();
				int typeInt = type.getSelectedIndex()+3;
				int priceInt = (price.getSelectedIndex()+2)*50;
				int durationInt = duration.getSelectedIndex()+1;
				String venueString = venue.getText();
				String targetString = target.getText();
				String descriotionString = descriotion.getText();

				if(checkname(courseString) && checknull(venueString,targetString,descriotionString)){
					if(JOptionPane.showConfirmDialog(null, "Create course ??", " ",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
						int cid = Curriculum.courselist.get(Curriculum.courselist.size() - 1).getCourseID() + 1;
						Course newcourse = new Course(cid, courseString, typeInt);
						newcourse.setCourseInfo(false, tid, durationInt, venueString, priceInt, targetString, descriotionString, 15 );
						Curriculum.updatecourselist(newcourse);
						JOptionPane.showMessageDialog(null, "Course ["+courseString+"] created!");
						Curriculum.listAll();
						dispose();
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
			}
		});
		
	}

//checking function/////////////////////////////////////////////	
	private boolean checkname(String courseString){
		if(!IOValidation.coursenameValid(courseString)){
			JOptionPane.showMessageDialog(null, "Course name not accept! Please enter again."," ",JOptionPane.WARNING_MESSAGE);
			return false;
		}else  
			return true;
	}
	
	private boolean checknull(String venueString, String targetString, String descriotionString){
		if(venueString.isEmpty()|| targetString.isEmpty()|| descriotionString.isEmpty()){
			JOptionPane.showMessageDialog(null, "Data cant be NULL! Please enter again."," ",JOptionPane.WARNING_MESSAGE);
			return false;
		}else  
			return true;
	}	
	
}