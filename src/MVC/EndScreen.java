package MVC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class EndScreen extends View{
	public void render(Graphics g) {
		
		//Title 
		Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size		
		g.setFont(fnt0);		
		g.setColor(Color.ORANGE);
		g.drawString("Game Over Loser",screenWidth/2-150,100 );
		
	}
}
