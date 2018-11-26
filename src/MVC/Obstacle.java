package MVC;

public class Obstacle extends GameObject {

String name = "rock";
	
	public Obstacle(int x, int y) {
		setXloc(x);
		setYloc(y);
	}
	
	@Override 
	public int hashCode() {
		return (getXloc()+getYloc())*name.hashCode();
	}
	
}
