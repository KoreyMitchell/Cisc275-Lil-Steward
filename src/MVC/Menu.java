package MVC;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


// TODO: Auto-generated Javadoc
/**
 * The Class Menu.
 */
public class Menu  extends View{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The play button. */
	//initialize buttons, (x,y,w,h)
	public Rectangle playButton = new Rectangle(screenWidth/5,screenHeight/3,200,75);
	
	/** The quit button. */
	//public Rectangle tutorialButton = new Rectangle(screenWidth/2-75,250,100,50);
	public Rectangle quitButton = new Rectangle(screenWidth/5,screenHeight/4*2,200,75);
	
	Color mixed;	//(red,green,blue) saturation


	/**
	 * Render menu.
	 *
	 * @param g the g
	 */
	public void renderMenu(Graphics g) {
		for (int i =0; i<=2; i++) {
			switch (i){
			case 0: //sets color of play button
					g.setColor(mixed = new Color(30, 100, 15));
					g.fillRect(screenWidth/5,screenHeight/3,200,75);
					
//			case 1: //sets color of tutorial button
//					g.setColor(Color.yellow);
//					g.fillRect(screenWidth/2-75,250,100,50);
					
			case 2: //sets color of quit button
					g.setColor(mixed = new Color(100, 30, 15));
					g.fillRect(screenWidth/5,screenHeight/4*2,200,75);
					
			default: //2d graphics for buttons
					Graphics2D g2d = (Graphics2D) g;
					
					//Buttons
					g.setColor(Color.WHITE);
					Font fnt1 = new Font("arial",Font.BOLD,50); //font,bold,size
					g.setFont(fnt1);
					g.drawString("Play",playButton.x+45,playButton.y+55);
					//g.drawString("Tutorial",tutorialButton.x+15,tutorialButton.y+32);
					g.drawString("Quit",quitButton.x+45,quitButton.y+55);
	
					g2d.draw(playButton);
					//g2d.draw(tutorialButton);
					g2d.draw(quitButton);
			}
		}
	}
}