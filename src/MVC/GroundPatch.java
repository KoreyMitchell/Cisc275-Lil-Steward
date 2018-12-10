package MVC;

import java.io.Serializable;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class GroundPatch.
 */
public class GroundPatch extends GameObject implements Serializable{

	/**
	 * Instantiates a new ground patch.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public GroundPatch(int x, int y) {
		setImic(new ImageIcon("images/ground.png"));
		setXloc(x);
		setYloc(y);
	}
	
	/* (non-Javadoc)
	 * @see MVC.GameObject#equals(java.lang.Object)
	 */
	@Override
    public boolean equals(Object o) {

	 //System.out.println("Equals called");
        if (o == this) return true;
        if (!(o instanceof GameObject)) {
            return false;
        }
        
        GameObject test = (GameObject) o;

       
        return (test.getXloc()<=getXloc()+imagewidth && test.getXloc()>getXloc()-imagewidth) &&
               (test.getYloc()<= getYloc()+imageheight+50 && test.getYloc()>getYloc()-imageheight);
 }

}
