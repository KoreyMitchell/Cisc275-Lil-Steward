
public class Player extends GameObject {

	int xloc;
	int yloc;
	int level;
	
	public Player(int xloc, int yloc, int level) {
		super(xloc, yloc);
		this.level = level;
	}
	public Player() { // By default, Java calls parent constructor w/o super()
		this.level = (Integer) null;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
