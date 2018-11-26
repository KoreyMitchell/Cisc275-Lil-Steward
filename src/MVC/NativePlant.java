package MVC;

public class NativePlant extends GameObject {

	String name = "native";
	
	public NativePlant(int x, int y) {
		setXloc(x);
		setYloc(y);
	}
	
	@Override 
	public int hashCode() {
		return (getXloc()+getYloc())*name.hashCode();
	}
	
}
