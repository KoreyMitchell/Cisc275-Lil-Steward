package MVC;

public class InvasivePlant extends GameObject {

	String name = "invasive";
	
	public InvasivePlant(int x, int y) {
		setXloc(x);
		setYloc(y);
	}
	
	@Override 
	public int hashCode() {
		return (getXloc()+getYloc())*name.hashCode();
	}
	
	
}
