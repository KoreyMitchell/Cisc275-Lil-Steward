package MVC;

import javax.swing.ImageIcon;

public class GroundPatch extends GameObject {

	public GroundPatch(int x, int y) {
		setImic(new ImageIcon("images/ground.png"));
		setXloc(x);
		setYloc(y);
	}
	
	@Override
    public boolean equals(Object o) {

	 //System.out.println("Equals called");
        if (o == this) return true;
        if (!(o instanceof GameObject)) {
            return false;
        }
        
        GameObject test = (GameObject) o;

       
        return (test.getXloc()<=getXloc()+imagewidth && test.getXloc()>getXloc()-imagewidth) &&
               (test.getYloc()<= getYloc()+imageheight+50 && test.getYloc()>getYloc()-imageheight);
 }

}
