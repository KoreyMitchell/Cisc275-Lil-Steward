package MVC;

import javax.swing.ImageIcon;

public class GroundPatch extends GameObject {

	public GroundPatch(int x, int y) {
		setImic(new ImageIcon("images/ground.png"));
		setXloc(x);
		setYloc(y);
	}

}
