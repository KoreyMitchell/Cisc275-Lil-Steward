package MVC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class EndScreen extends View{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f;

	public void render(Graphics g) {
		
		//Title 
		Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size		
		g.setFont(fnt0);		
		g.setColor(Color.WHITE);
		g.drawString("Congratulations!",screenWidth/2,100 );
		g.drawString("You planted " + plantedCount + " native plants!", screenWidth/2,300);
		g.drawString("You removed " + plantsRemoved + " invasive plants!", screenWidth/2,500);
		g.drawString("Play again", screenWidth/2,800);
		
	}
	
}
