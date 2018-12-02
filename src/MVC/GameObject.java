package MVC;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GameObject {
	//image file
	
	//aaaaaaaaa
	ImageIcon imic;
	Image img;
	int imagewidth;
	int imageheight;

	
	public ImageIcon getImic() {
		return imic;
	}

	public void setImic(ImageIcon imic) {
		this.imic = imic;
		img = imic.getImage();
		imagewidth = imic.getIconWidth();
		imageheight = imic.getIconHeight();
	}

	//X and Y locations
	private int xloc;
	private int yloc;

	public int getXloc() {
		return xloc;
	}

	public void setXloc(int xloc) {
		this.xloc = xloc;
	}

	public int getYloc() {
		return yloc;
	}

	public void setYloc(int yloc) {
		this.yloc = yloc;
	}
	
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
	 
	 @Override
	 public int hashCode() {
		 return xloc+yloc;
	 }

}
