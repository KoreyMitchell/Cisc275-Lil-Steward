package MVC;

public class Tool {

	private boolean isShovel;

	public Tool(boolean b) {
		// TODO Auto-generated constructor stub
		isShovel = b;
	}

	public boolean isShovel() {
		return isShovel;
	}

	public void setShovel(boolean isShovel) {
		this.isShovel = isShovel;
	}
	
	public void switchTool() {
		boolean temp = !isShovel;
		this.isShovel = temp;
	}
}
