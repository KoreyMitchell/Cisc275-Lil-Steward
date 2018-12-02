package MVC;

import javax.swing.ImageIcon;

public class Obstacle extends GameObject {

String name = "rock";
	
	public Obstacle(int x, int y) {
		setXloc(x);
		setYloc(y);
		setImic(new ImageIcon("images/rock.png"));
	}
	
	@Override
    public boolean equals(Object o) {

	 //System.out.println("Equals called");
        if (o == this) return true;
        if (!(o instanceof GameObject)) {
            return false;
        }
        
        GameObject test = (GameObject) o;

       
        return (test.getXloc()<=getXloc()+imagewidth-20 && test.getXloc()>getXloc()-imagewidth+10) &&
               (test.getYloc()<= getYloc()+imageheight+15 && test.getYloc()>getYloc()-imageheight+50);
 }
	
}
