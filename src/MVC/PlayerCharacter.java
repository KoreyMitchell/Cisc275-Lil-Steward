package MVC;

import java.awt.event.KeyEvent;

public class PlayerCharacter extends GameObject{

	PlayerCharacter(){
		setXloc(10);
		setYloc(10);
	}
	
	public void updatePlayerLocation(KeyEvent e) {
		//TODO: use String version of this method but with KeyEvents
		System.out.println("Player moved");
		int id = e.getKeyCode();
		int temp;
		System.out.println("The id is " + id);
		
		switch( id ) { 
        case KeyEvent.VK_LEFT:
            // up 
        	System.out.println("Up pressed");
        	temp = getXloc()-5;
			setXloc(temp);
            break;
        case KeyEvent.VK_RIGHT:
            // down 
        	temp = getXloc()+5;
			setXloc(temp);
            break;
        case KeyEvent.VK_UP:
            // left
        	temp = getYloc()-5;
			setYloc(temp);
            break;
        case KeyEvent.VK_DOWN :
            // right
        	temp = getYloc()+5;
			setYloc(temp);
            break;
     }
	}
	
	
	
	 //Used for testing Model//
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
	
}
