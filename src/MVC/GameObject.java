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

	        if (o == this) return true;
	        if (!(o instanceof GameObject)) {
	            return false;
	        }
	        
	        GameObject test = (GameObject) o;

	       
	        return (test.getXloc()<=xloc+50 && test.getXloc()>xloc-50) &&
	               (test.getYloc()<= yloc+50 && test.getYloc()>yloc-50);
	 }
	 
	 @Override
	 public int hashCode() {
		 return xloc+yloc;
	 }

}
