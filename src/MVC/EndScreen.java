package MVC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class EndScreen.
 */
public class EndScreen extends View{
	
//	Rectangle plantedRec = new Rectangle( screenWidth/2-410,250,685,60);
//	Rectangle PlayRec = new Rectangle(screenWidth/2-410,450,765,60);
	
	/** The Constant serialVersionUID. */
private static final long serialVersionUID = 1L;    
	
	/** The mixed. */
	Color mixed;	//(red,green,blue) saturation
	
	/**
	 * Render.
	 *
	 * @param g the g
	 */
	public void render(Graphics g) {
		//g.drawImage(scaled_bg_img, 0, 0, null);
		Graphics2D g2d= (Graphics2D) g;
		g2d.setFont(new Font("arial",Font.BOLD,50)); //font,bold,size		
		g2d.drawImage(greyBannerImg, screenWidth/2 -230,25,450,125, null);
		g.setColor(Color.BLACK);
		g.drawString("Congratulations!",screenWidth/2 -200,100 );

		
		//Number planted
		//g2d.drawImage(brownBannerImg, screenWidth/2-360,250,685,60, null);
		g2d.drawImage(brownBannerImg, screenWidth/2-430,565,799,-360, null);

		g.setColor(Color.BLACK);
		g2d.setFont(new Font("arial",Font.BOLD,50)); //font,bold,size		
		g.drawString("You planted " + plantedCount + " native plants!", screenWidth/2-350,300);

		//Number invaseive
		//g2d.drawImage(brownBannerImg, screenWidth/2-410,450,765,-300, null);
		g.setColor(Color.BLACK);
		g2d.setFont(new Font("arial",Font.BOLD,50)); //font,bold,size
		g.drawString("You removed " + plantsRemoved + " invasive plants!", screenWidth/2-400,500);

		
		//Take survey
		//g2d.setColor(mixed = new Color(30, 60, 25));
		//g2d.fillOval(screenWidth/2-400,723,740,125);
		g2d.drawImage(greyBannerImg, screenWidth/2-400,723,740,125, null);

		g.setColor(Color.BLACK);
		g.drawString("Click to test your knowledge!", screenWidth/2-380,800);



		



		
	}
	
}
