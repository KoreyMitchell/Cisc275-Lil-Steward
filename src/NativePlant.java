
public class NativePlant extends GameObject {

	int xloc;
	int yloc;
	String name;
	
	public NativePlant(int xloc, int yloc, String name) {
		super(xloc, yloc);
		this.name = name;
	}
	
	public NativePlant() { // By default, Java calls parent constructor w/o super()
		this.name = (String) null;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}		
}
