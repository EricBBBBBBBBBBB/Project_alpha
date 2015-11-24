import java.awt.*;
import javax.swing.*;
 
public class GUI { 
    public static void main(String[] args) { 
       //Frame Setting
		JFrame demo = new JFrame();
        demo.setSize(400, 300);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Content
		JLabel Title = new JLabel("- - - - Welcome to Training Record System - - - -");
		demo.getContentPane().add(BorderLayout.NORTH , Title);
            
        demo.setVisible(true);
    }
}