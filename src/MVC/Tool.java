package MVC;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Tool.
 */
public class Tool implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The is shovel. */
	private boolean isShovel;

	/**
	 * Instantiates a new tool.
	 *
	 * @param b the b
	 */
	public Tool(boolean b) {
		// TODO Auto-generated constructor stub
		isShovel = b;
	}

	/**
	 * Checks if is shovel.
	 *
	 * @return true, if is shovel
	 */
	public boolean isShovel() {
		return isShovel;
	}

	/**
	 * Sets the shovel.
	 *
	 * @param isShovel the new shovel
	 */
	public void setShovel(boolean isShovel) {
		this.isShovel = isShovel;
	}
	
	/**
	 * Switch tool.
	 */
	public void switchTool() {
		boolean temp = !isShovel;
		this.isShovel = temp;
	}
}
