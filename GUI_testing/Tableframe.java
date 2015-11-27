
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.List;

import javax.swing.*;

public class Tableframe extends JFrame {

	private JTable table;
	
	public Tableframe(String title, String[] header, String[][] data) {

		setTitle(title);
		setSize(800, 300);
		setLocation(50, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		table = new JTable(data, header);
		
		// listener for selecting table row, with anonymous class
		table.getSelectionModel().addListSelectionListener(
			new javax.swing.event.ListSelectionListener(){
				public void valueChanged(javax.swing.event.ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()){ // avoid multiple events for the same selection
						String mesgStr = (String) table.getValueAt(table.getSelectedRow(), 0);
						int i = Integer.parseInt(mesgStr);
						Curriculum.courselist.get(i-1).printCourseInfo();
					}
				}
			}
		);	
		
		table.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}
}
