package MVC;

import java.io.Serializable;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class TutorialNoteAster.
 */
public class TutorialNoteAster extends GameObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new tutorial note aster.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public TutorialNoteAster(int x, int y) {
		setImic(new ImageIcon("images/stickynote_aster.png"));
		setXloc(x);
		setYloc(y);
	}

}
