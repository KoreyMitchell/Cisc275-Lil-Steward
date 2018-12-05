package MVC;

import javax.swing.ImageIcon;
import javax.swing.JButton;


// TODO: Auto-generated Javadoc
/**
 * The Class ToolBar.
 */
public class ToolBar extends View{
	   
   	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new tool bar.
	 */
	public ToolBar() {
			//Toolbar
			JButton b=new JButton("Tool",new ImageIcon("images/rock.png"));    
			b.setBounds(100,screenHeight-300,150, 150);  
			frame.add(b); 
			b.setVisible(true);
	    }
}
