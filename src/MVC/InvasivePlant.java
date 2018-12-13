package MVC;

import java.io.Serializable;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class InvasivePlant.
 */
public class InvasivePlant extends GameObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The name. */
	String name = "invasive";
	
	/**
	 * Instantiates a new invasive plant.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public InvasivePlant(int x, int y) {
		setXloc(x);
		setYloc(y);
		setImic(new ImageIcon("images/phragmites.png"));
	}
	
	
	
	
}
