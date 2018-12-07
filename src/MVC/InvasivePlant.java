package MVC;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class InvasivePlant.
 */
public class InvasivePlant extends GameObject {

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
