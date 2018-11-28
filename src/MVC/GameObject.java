package MVC;

public class GameObject {

	//X and Y locations
	private int xloc;
	private int yloc;

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
	
	 @Override
	    public boolean equals(Object o) {

		 //System.out.println("Equals called");
	        if (o == this) return true;
	        if (!(o instanceof GameObject)) {
	            return false;
	        }
	        
	        GameObject test = (GameObject) o;

	       
	        return (test.getXloc()<=xloc && test.getXloc()>xloc-100) &&
	               (test.getYloc()<= yloc && test.getYloc()>yloc-100);
	 }
	 
	 @Override
	 public int hashCode() {
		 return xloc+yloc;
	 }

}
