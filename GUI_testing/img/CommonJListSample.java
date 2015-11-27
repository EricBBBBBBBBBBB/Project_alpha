import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A sample frame to illustrate the use of JList.
 */
class CommonJListSample extends JFrame
                           implements ActionListener {

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
    private static final int FRAME_HEIGHT   = 250;

    /**
     * X coordinate of the frame default origin point
     */
    private static final int FRAME_X_ORIGIN = 150;

    /**
     * Y coordinate of the frame default origin point
     */
    private static final int FRAME_Y_ORIGIN = 250;

    /**
     * A JList of three-letter animal names
     */
    private JList list;

//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        CommonJListSample frame = new CommonJListSample();
        frame.setVisible(true);
    }


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public CommonJListSample() {
        Container   contentPane;
        JPanel      listPanel, okPanel;

        JButton     okButton;
        String[]    names = {"Ape", "Bat", "Bee", "Cat",
                            "Dog", "Eel", "Fox", "Gnu",
                            "Hen", "Man", "Sow", "Yak"};

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("Program CommonJListSample2");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new BorderLayout());

        //create and place a JList
        listPanel = new JPanel(new GridLayout(0,1));
        listPanel.setBorder(BorderFactory.createTitledBorder("Three-letter Animal Names"));

        list = new JList(names);
        listPanel.add(new JScrollPane(list));
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            //this is default, so the explicit call is not necessary

        //---------------------------------------
        //Other selection modes
        //
        //list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //---------------------------------------

        //create and place the OK button
        okPanel = new JPanel(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        okPanel.add(okButton);

        contentPane.add(listPanel, BorderLayout.CENTER);
        contentPane.add(okPanel, BorderLayout.SOUTH);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    public void actionPerformed(ActionEvent event) {

        Object[] name;
        int[]    loc;

        name = list.getSelectedValues();
        loc  = list.getSelectedIndices();

        System.out.println("Currently selected animal names are ");
        for (int i = 0; i < name.length; i++) {
            System.out.println((String)name[i] + " at position " + loc[i]);
        }
    }
}