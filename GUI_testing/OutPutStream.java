
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class OutPutStream extends JPanel {
	
	private JScrollPane scrollPane;
	private static JTextArea textArea = new JTextArea(22, 54);
	private static User user;
    public OutPutStream(User u) { 

		
		user = u;
		setOpaque(false);
		setVisible(true);
		setBounds(34, 33, 600, 365);
		
			
		textArea.setText(
		"[SYSM] Hello!  " + user.getUserName() + " .\n" +
		"[SYSM] Welcome to Sum Sum Eye record system!!\n"	
		);
		user.printUserInfo();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		scrollPane = new JScrollPane(textArea);
		add(scrollPane);		
    }
		
	public static void write(String text){
		textArea.setText(" [" + user.getUserName() + "]\n" +
		"----------------------------------------------------------------------------------------------------------------------------------------------------\n");
		textArea.append(text);
	}

	
}