import org.junit.Test;

public class GameObject {
	int xloc;
	int yloc;
	
	public GameObject(int xloc, int yloc) {
		this.xloc = xloc;
		this.yloc = yloc;
	}
	public GameObject() { 
		this.xloc = (Integer)null;
		this.yloc = (Integer)null;
	}
	
	public int getXloc() {
		return xloc;
	}
	public void setXloc(int xloc) {
		this.xloc = xloc;
	}
	public int getYloc() {
		return yloc;
	}
	public void setYloc(int yloc) {
		this.yloc = yloc;
	}

	  @Test
	    public void testMultiplyException() {
		  //GameObject tester = new GameObject();
	        //assertEquals("Result", result, tester.multiply(m1, m2));
	    }
}
