package MVC;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ToolBar extends View{
	   public ToolBar(JFrame frame) {
	        JPanel panel = new JPanel();
	        JButton shovel = new JButton("Shovel");
	        JButton planter = new JButton("Planter");
	        	       
	        //add buttons to jpanel
	        panel.add(shovel);
	        panel.add(planter);
	        
	        //add panel to the bottom
	        add(panel, BorderLayout.SOUTH);
	        frame.add(panel);
	    }
}
