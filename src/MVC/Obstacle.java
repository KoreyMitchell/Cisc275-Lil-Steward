package MVC;

import java.io.Serializable;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class Obstacle.
 */
public class Obstacle extends GameObject implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/** The name. */
String name = "rock";
	
	/**
	 * Instantiates a new obstacle.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Obstacle(int x, int y) {
		setXloc(x);
		setYloc(y);
		setImic(new ImageIcon("images/rock.png"));
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

       
        return (test.getXloc()<=getXloc()+imagewidth-20 && test.getXloc()>getXloc()-imagewidth+10) &&
               (test.getYloc()<= getYloc()+imageheight+15 && test.getYloc()>getYloc()-imageheight+50);
 }
	
}
