package MVC;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Menu  extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//initialize buttons, (x,y,w,h)
	public Rectangle playButton = new Rectangle(screenWidth/5,screenHeight/3,200,75);
	//public Rectangle tutorialButton = new Rectangle(screenWidth/2-75,250,100,50);
	public Rectangle quitButton = new Rectangle(screenWidth/5,screenHeight/4*2,200,75);

	public void renderMenu(Graphics g) {
		for (int i =0; i<=2; i++) {
			switch (i){
			case 0: //sets color of play button
					g.setColor(Color.green);
					g.fillRect(screenWidth/5,screenHeight/3,200,75);
					
//			case 1: //sets color of tutorial button
//					g.setColor(Color.yellow);
//					g.fillRect(screenWidth/2-75,250,100,50);
					
			case 2: //sets color of quit button
					g.setColor(Color.red);
					g.fillRect(screenWidth/5,screenHeight/4*2,200,75);
					
			default: //2d graphics for buttons
					Graphics2D g2d = (Graphics2D) g;
					
					//Title 
//					Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size		
//					g.setFont(fnt0);		
//					g.setColor(Color.black);
//					g.drawString("Estuary Game",screenWidth/2-190,100 );
					
					//Buttons
					g.setColor(Color.black);
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