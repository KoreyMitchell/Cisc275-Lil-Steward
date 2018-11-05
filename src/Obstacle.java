
public class Obstacle extends GameObject {

	int xloc;
	int yloc;
	String name;
	
	public Obstacle(int xloc, int yloc, String name) {
		super(xloc, yloc);
		this.name = name;
	}
	
	public Obstacle() { // By default, Java calls parent constructor w/o super()
		this.name = (String) null;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
