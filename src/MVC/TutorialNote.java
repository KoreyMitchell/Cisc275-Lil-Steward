package MVC;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class TutorialNote.
 */
public class TutorialNote extends GameObject {

	/**
	 * Instantiates a new tutorial note.
	 *
	 * @param x the x
	 * @param y the y
	 * @param imgloc the imgloc
	 */
	public TutorialNote(int x, int y, String imgloc) {
		setImic(new ImageIcon(imgloc));
		setXloc(x);
		setYloc(y);
	}

}
