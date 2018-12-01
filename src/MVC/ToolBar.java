package MVC;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends View{
	   public ToolBar() {
	        JPanel panel = new JPanel();
	        JButton go = new JButton("Shovel");
	        JButton stop = new JButton("Planter");
	        
	        GridBagConstraints c = new GridBagConstraints();
	       
	        panel.add(go);
	        panel.add(stop);

	        add(panel, BorderLayout.SOUTH);

	    }
}
