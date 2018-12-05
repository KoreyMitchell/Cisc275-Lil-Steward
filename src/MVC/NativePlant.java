package MVC;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class NativePlant.
 */
public class NativePlant extends GameObject {

	/** The name. */
	String name = "native";
	
	/**
	 * Instantiates a new native plant.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public NativePlant(int x, int y) {
		setXloc(x);
		setYloc(y);
		setImic(new ImageIcon("images/nativeplant.png"));
	}
	
	/* (non-Javadoc)
	 * @see MVC.GameObject#hashCode()
	 */
	@Override 
	public int hashCode() {
		return (getXloc()+getYloc())*name.hashCode();
	}
	
}
