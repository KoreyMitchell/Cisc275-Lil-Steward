package MVC;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class TutorialNoteDirection.
 */
public class TutorialNoteDirection extends GameObject {

	/**
	 * Instantiates a new tutorial note direction.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public TutorialNoteDirection(int x, int y) {
		setImic(new ImageIcon("images/stickynote_directions.png"));
		setXloc(x);
		setYloc(y);
	}

}
