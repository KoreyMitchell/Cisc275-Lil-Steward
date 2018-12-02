package MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EndScreen extends View{
	JFrame f;

	public void render(Graphics g) {
		
		//Title 
		Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size		
		g.setFont(fnt0);		
		g.setColor(Color.RED);
		g.drawString("Game Over Loser",screenWidth/2-150,100 );
		
	}
	
}
