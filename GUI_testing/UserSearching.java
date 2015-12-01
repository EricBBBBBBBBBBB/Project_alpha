import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UserSearching extends JFrame implements ActionListener {

//////Data Members
    private static final int FRAME_WIDTH    = 300;
    private static final int FRAME_HEIGHT   = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private JComboBox comboBox;

//////Main method
    public static void main(String[] args) {
        UserSearching frame = new UserSearching();
        frame.setVisible(true);
    }

//////Constructors

    public UserSearching() {
        Container   contentPane;
        JPanel      comboPanel, okPanel;

        JButton     okButton;
        String[]    comboBoxItem = {"Trainees", "Trainers", "All Users"};

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("User Searching");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

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
        setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE  );
    }

    public void actionPerformed(ActionEvent event) {
        int  loc = comboBox.getSelectedIndex();
		Account.searchUser(loc);
    }

}