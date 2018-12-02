package MVC;

import javax.swing.ImageIcon;

public class NativePlant extends GameObject {

	String name = "native";
	
	public NativePlant(int x, int y) {
		setXloc(x);
		setYloc(y);
		setImic(new ImageIcon("images/nativeplant.png"));
	}
	
	@Override 
	public int hashCode() {
		return (getXloc()+getYloc())*name.hashCode();
	}
	
}
