package MVC;

import java.awt.event.KeyEvent;

public class PlayerCharacter extends GameObject{

	PlayerCharacter(){
		setXloc(10);
		setYloc(10);
	}
	
	public void updatePlayerLocation(String input) {
		// takes a string as input and updates location
		int temp;
		if(input.equals("up")&& getXloc()>0) {
			//move character up
			temp = getXloc()-1;
			setXloc(temp);
		}
		else if(input.equals("down")&&getXloc()<200) {
			//move character down
			temp = getXloc()+1;
			setXloc(temp);
		}
		else if(input.equals("left")&&getYloc()>0) {
			//move character left
			temp = getYloc()-1;
			setYloc(temp);
		}
		else if(input.equals("right")&&getYloc()<200) {
			//move character right
			temp = getYloc()+1;
			setYloc(temp);
		}
	}
	
	public void updatePlayerLocation(KeyEvent e) {
		//TODO: use String version of this method but with KeyEvents
		System.out.println("Player moved");
		int id = e.getID();
		int temp;
		System.out.println("The id is " + id);
		
		switch( id ) { 
        case KeyEvent.VK_UP:
            // up 
        	System.out.println("Up pressed");
        	temp = getXloc()-1;
			setXloc(temp);
            break;
        case KeyEvent.VK_DOWN:
            // down 
        	temp = getXloc()+1;
			setXloc(temp);
            break;
        case KeyEvent.VK_LEFT:
            // left
        	temp = getYloc()-1;
			setYloc(temp);
            break;
        case KeyEvent.VK_RIGHT :
            // right
        	temp = getYloc()+1;
			setYloc(temp);
            break;
     }
	}
	
}
