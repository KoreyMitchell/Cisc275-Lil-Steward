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
	public Rectangle playButton = new Rectangle(screenWidth/2-475,400,100,50);
//	public Rectangle tutorialButton = new Rectangle(screenWidth/2-75,250,100,50);
	public Rectangle quitButton = new Rectangle(screenWidth/2-475,500,100,50);

	public void renderMenu(Graphics g) {
		for (int i =0; i<=3; i++) {
			switch (i){
			case 0: //sets color of play button
					g.setColor(Color.GREEN);
					g.fillRect(screenWidth/2-475,400,200,50);
					
			case 1: //sets color of quit button
					g.setColor(Color.red);
					g.fillRect(screenWidth/2-475,500,200,50);
					
			case 2: //2d graphics for buttons
					Graphics2D g2d = (Graphics2D) g;
					
					//Title 
					Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size		
					g.setFont(fnt0);		
					g.setColor(Color.black);
					g.drawString("",screenWidth/2-190,150 );
					
					//Buttons
					Font fnt1 = new Font("arial",Font.BOLD,20); //font,bold,size
					g.setFont(fnt1);
					g.drawString("Play",playButton.x+28,playButton.y+34);
					g.drawString("Quit",quitButton.x+28,quitButton.y+34);
	
					g2d.draw(playButton);
//					g2d.draw(tutorialButton);
					g2d.draw(quitButton);
			}
		}
	}
}
