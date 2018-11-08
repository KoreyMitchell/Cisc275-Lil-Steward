
public class Toolbar {
	
	boolean isShovel;
	int level;
	
	public void LevelUp() {
		level++;
	}
	
	public void toolSwitch() {
		isShovel = !isShovel;
	}
	
	public boolean isShovel() {
		return isShovel;
	}
	public void setShovel(boolean isShovel) {
		this.isShovel = isShovel;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
