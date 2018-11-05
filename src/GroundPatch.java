import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class GroundPatch extends GameObject {
	int xloc;
	int yloc;
	boolean isFilled;
	
	public GroundPatch(int xloc, int yloc, boolean isFilled) {
		super(xloc, yloc);
		this.isFilled = isFilled;
		
	}
	public GroundPatch() { // By default, Java calls parent constructor w/o super()
		this.isFilled = (Boolean) null;
	}
	
	public boolean isFilled() {
		return isFilled;
	}
	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}


}

