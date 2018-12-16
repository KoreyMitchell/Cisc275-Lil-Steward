package MVC;

import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.ImageIcon;


// TODO: Auto-generated Javadoc
/**
 * The Class PlayerCharacter.
 */
public class PlayerCharacter extends GameObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new player character.
	 */
	PlayerCharacter(){
		setXloc(10);
		setYloc(10);
		//Direction d = Direction.SOUTH;
		setImic(new ImageIcon("images/Person_FRONT.png"));
	}
	
	
	/**
	 * Update player location.
	 *
	 * @param e the e
	 */
	public void updatePlayerLocation(KeyEvent e) {
		//TODO: use String version of this method but with KeyEvents
	//	System.out.println("Player moved");
		int id = e.getKeyCode();
		int temp;
	//	System.out.println("The id is " + id);
		
		
		switch( id ) { 
        case KeyEvent.VK_LEFT:
            // up 
        	//System.out.println("Up pressed");
        	temp = getXloc()-10;
			setXloc(temp);
            break;
        case KeyEvent.VK_RIGHT:
            // down 
        	temp = getXloc()+10;
			setXloc(temp);
            break;
        case KeyEvent.VK_UP:
            // left
        	temp = getYloc()-10;
			setYloc(temp);
            break;
        case KeyEvent.VK_DOWN :
            // right
        	temp = getYloc()+10;
			setYloc(temp);
            break;
	

		}
			


	}
	
	

	
	
	
	 /**
 	 * Update player location.
 	 *
 	 * @param input the input
 	 */
 	//----------------------Used for testing Model-------------------------//
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
	
	/**
	 * The Enum Direction.
	 * This code is not being used
	 */
	public enum Direction {

		/** The north. */
		NORTH("north"),
		
		/** The northeast. */
		NORTHEAST("northeast"),
		
		/** The east. */
		EAST("east"),
		
		/** The southeast. */
		SOUTHEAST("southeast"),
		
		/** The south. */
		SOUTH("south"),
		
		/** The southwest. */
		SOUTHWEST("southwest"),
		
		/** The west. */
		WEST("west"),
		
		/** The northwest. */
		NORTHWEST("northwest");
		
		/** The name. */
		private String name = null;
		
		
		/**
		 * Instantiates a new direction.
		 *
		 * @param s the s
		 */
		private Direction(String s){
			name = s;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Gets the name.
		 *
		 * @return the name
		 */
		public String getName() {
			return name;
		}


	}
	
	
	
}
