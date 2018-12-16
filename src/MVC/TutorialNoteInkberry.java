package MVC;

import java.io.Serializable;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class TutorialNoteInkberry.
 */
public class TutorialNoteInkberry extends GameObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new tutorial note inkberry.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public TutorialNoteInkberry(int x, int y) {
		setImic(new ImageIcon("images/stickynote_inkberry.png"));
		setXloc(x);
		setYloc(y);
	}

}
