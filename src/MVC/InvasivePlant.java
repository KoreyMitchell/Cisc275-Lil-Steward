package MVC;

import javax.swing.ImageIcon;

public class InvasivePlant extends GameObject {

	String name = "invasive";
	
	public InvasivePlant(int x, int y) {
		setXloc(x);
		setYloc(y);
		setImic(new ImageIcon("images/phragmites.png"));
	}
	
	
	
	
}
