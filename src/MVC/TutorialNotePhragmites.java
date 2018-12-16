package MVC;

import java.io.Serializable;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class TutorialNotePhragmites.
 */
public class TutorialNotePhragmites extends GameObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new tutorial note phragmites.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public TutorialNotePhragmites(int x, int y) {
		setImic(new ImageIcon("images/stickynote_phragmites.png"));
		setXloc(x);
		setYloc(y);
	}

}
