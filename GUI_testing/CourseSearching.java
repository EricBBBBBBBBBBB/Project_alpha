import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CourseSearching extends JFrame implements ActionListener {

//////Data Members
    private static final int FRAME_WIDTH    = 300;
    private static final int FRAME_HEIGHT   = 120; 
	private JComboBox comboBox;

//////Constructors

    public CourseSearching() {
        Container   contentPane;
        JPanel      comboPanel, okPanel;

        JButton     okButton;
        String[]    comboBoxItem = {"Beginner", "Advanced", "Intermediate","All Course"};

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("Course Searching");
		
		//set center
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 300) / 2;
		final int y = (screenSize.height - 120) / 2;
		setLocation(x, y);

        contentPane = getContentPane( );
        contentPane.setBackground(new Color(26, 188, 156));
        contentPane.setLayout(new BorderLayout());

        //create and place a combo box
        comboPanel = new JPanel(new FlowLayout());
        comboBox = new JComboBox(comboBoxItem);
        comboPanel.add(comboBox);

        //create and place the OK button
        okPanel = new JPanel(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        okPanel.add(okButton);

        contentPane.add(comboPanel, BorderLayout.CENTER);
        contentPane.add(okPanel, BorderLayout.SOUTH);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
    }

    public void actionPerformed(ActionEvent event) {
        int  loc = comboBox.getSelectedIndex();
		Curriculum.searchCourse(loc);
		this.dispose();
    }

}