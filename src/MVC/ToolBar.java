package MVC;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class ToolBar extends View{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBar() {
			//Toolbar
			JButton b=new JButton("Tool",new ImageIcon("images/rock.png"));    
			b.setBounds(100,screenHeight-300,150, 150);  
			frame.add(b); 
			b.setVisible(true);
	    }
}
