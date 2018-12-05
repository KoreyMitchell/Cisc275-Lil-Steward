package MVC;

import javax.swing.ImageIcon;

public class TutorialNote extends GameObject {

	public TutorialNote(int x, int y, String imgloc) {
		setImic(new ImageIcon(imgloc));
		setXloc(x);
		setYloc(y);
	}

}
