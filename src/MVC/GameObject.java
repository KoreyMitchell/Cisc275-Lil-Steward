package MVC;

import java.awt.Image;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class GameObject.
 */
public class GameObject {
	//image file
	
	//aaaaaaaaa
	
	/** The imic. */
	ImageIcon imic;
	
	/** The img. */
	Image img;
	
	/** The imagewidth. */
	int imagewidth;
	
	/** The imageheight. */
	int imageheight;

	
	/**
	 * Gets the imic.
	 *
	 * @return the imic
	 */
	public ImageIcon getImic() {
		return imic;
	}

	/**
	 * Sets the imic.
	 *
	 * @param imic the new imic
	 */
	public void setImic(ImageIcon imic) {
		this.imic = imic;
		img = imic.getImage();
		imagewidth = imic.getIconWidth();
		imageheight = imic.getIconHeight();
	}

	/** The xloc. */
	//X and Y locations
	private int xloc;
	
	/** The yloc. */
	private int yloc;

	/**
	 * Gets the xloc.
	 *
	 * @return the xloc
	 */
	public int getXloc() {
		return xloc;
	}

	/**
	 * Sets the xloc.
	 *
	 * @param xloc the new xloc
	 */
	public void setXloc(int xloc) {
		this.xloc = xloc;
	}

	/**
	 * Gets the yloc.
	 *
	 * @return the yloc
	 */
	public int getYloc() {
		return yloc;
	}

	/**
	 * Sets the yloc.
	 *
	 * @param yloc the new yloc
	 */
	public void setYloc(int yloc) {
		this.yloc = yloc;
	}
	
	 /* (non-Javadoc)
 	 * @see java.lang.Object#equals(java.lang.Object)
 	 */
 	@Override
	    public boolean equals(Object o) {

		 //System.out.println("Equals called");
	        if (o == this) return true;
	        if (!(o instanceof GameObject)) {
	            return false;
	        }
	        
	        GameObject test = (GameObject) o;

	       
	       
	        return (test.getXloc()<=xloc+imagewidth && test.getXloc()>xloc-imagewidth) &&
	               (test.getYloc()<= yloc+imageheight && test.getYloc()>yloc-imageheight);
	 }
	 
	 /* (non-Javadoc)
 	 * @see java.lang.Object#hashCode()
 	 */
 	@Override
	 public int hashCode() {
		 return xloc+yloc;
	 }

}
