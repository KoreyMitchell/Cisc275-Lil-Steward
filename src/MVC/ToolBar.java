package MVC;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ToolBar extends View{
	   public ToolBar() {
			//Toolbar
			JButton b=new JButton("Tool",new ImageIcon("images/rock.png"));    
			b.setBounds(100,screenHeight-300,150, 150);  
			frame.add(b); 
			b.setVisible(true);
	    }
}
