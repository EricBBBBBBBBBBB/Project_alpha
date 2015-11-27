import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A sample frame to illustrate the use of JComboBox.
 */
class CommonJComboBoxSample extends JFrame
                           implements ActionListener,
                                      ItemListener   {

//----------------------------------
//    Data Members
//----------------------------------

    /**
     * Default frame width
     */
    private static final int FRAME_WIDTH    = 300;

    /**
     * Default frame height
     */
    private static final int FRAME_HEIGHT   = 200;

    /**
     * X coordinate of the frame default origin point
     */
    private static final int FRAME_X_ORIGIN = 150;

    /**
     * Y coordinate of the frame default origin point
     */
    private static final int FRAME_Y_ORIGIN = 250;

    /**
     * A combo box of programming languages
     */
    private JComboBox comboBox;

//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        CommonJComboBoxSample frame = new CommonJComboBoxSample();
        frame.setVisible(true);
    }


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public CommonJComboBoxSample() {
        Container   contentPane;
        JPanel      comboPanel, okPanel;

        JButton     okButton;
        String[]    comboBoxItem = {"Java", "C++", "Smalltalk", "Ada"};

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("Program CommonJComboBoxSample");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new BorderLayout());

        //create and place a combo box
        comboPanel = new JPanel(new FlowLayout());
        comboPanel.setBorder(
                    BorderFactory.createTitledBorder("Pick your favorite"));

        comboBox = new JComboBox(comboBoxItem);
        comboBox.addItemListener(this);
        comboPanel.add(comboBox);

        //create and place the OK button
        okPanel = new JPanel(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        okPanel.add(okButton);

        contentPane.add(comboPanel, BorderLayout.CENTER);
        contentPane.add(okPanel, BorderLayout.SOUTH);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    public void actionPerformed(ActionEvent event) {

        String favorite;
        int    loc;

        favorite = (String) comboBox.getSelectedItem();
        loc      = comboBox.getSelectedIndex();

        JOptionPane.showMessageDialog(this, "Currently selected item '" +
                           favorite + "' is at index position " + loc);
    }

    public void itemStateChanged(ItemEvent event) {

        String state;

        if (event.getStateChange() == ItemEvent.SELECTED) {
            state = "is selected";
        } else {
            state = "is deselected";
        }

        JOptionPane.showMessageDialog(this, "JComboBox Item '" +
                                            event.getItem() +
                                            "' " + state);
    }
}