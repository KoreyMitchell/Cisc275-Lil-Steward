package MVC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class EndScreen extends View{
	
//	Rectangle plantedRec = new Rectangle( screenWidth/2-410,250,685,60);
//	Rectangle PlayRec = new Rectangle(screenWidth/2-410,450,765,60);
	
	private static final long serialVersionUID = 1L;
	JFrame f;

	public void render(Graphics g) {
		//g.drawImage(scaled_bg_img, 0, 0, null);
		Graphics2D g2d= (Graphics2D) g;
		
		g2d.drawOval(screenWidth/2 -230,25,450,125);	//congrats oval
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillOval(screenWidth/2 -230,25,450,125);
		
		//g2d.draw(plantedRec);
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(screenWidth/2-360,250,685,60);

		//g2d.draw(PlayRec);
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(screenWidth/2-410,450,765,60);
		
		
		g2d.drawOval(screenWidth/2 -230,25,450,125);	//congrats oval
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillOval(screenWidth/2-200,745,313,80);
		
		//Title 
		Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size		
		g.setFont(fnt0);		
		g.setColor(Color.WHITE);
		g.drawString("Congratulations!",screenWidth/2 -200,100 );

		g.drawString("You planted " + plantedCount + " native plants!", screenWidth/2-350,300);

		g.drawString("You removed " + plantsRemoved + " invasive plants!", screenWidth/2-400,500);

		g.drawString("Play again", screenWidth/2-170,800);


		
	}
	
}
