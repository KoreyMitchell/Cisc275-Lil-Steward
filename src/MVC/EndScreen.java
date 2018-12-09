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
	
	Color mixed;	//(red,green,blue) saturation
	
	/**
	 * Render.
	 *
	 * @param g the g
	 */
	public void render(Graphics g) {
		//g.drawImage(scaled_bg_img, 0, 0, null);
		Graphics2D g2d= (Graphics2D) g;
		double scale =(double)screenHeight/(double)screenWidth;
		System.out.println("start");
		System.out.println(screenWidth);
		System.out.println(screenHeight);
		System.out.println(scale);
		System.out.println("end");
		g2d.scale(1,.75);
		//Congratulations
		g2d.drawOval(screenWidth/2 -230,25,450,125);	//congrats oval
		g2d.setColor(mixed = new Color(30, 60, 25));
		g2d.fillOval(screenWidth/2 -230,25,450,125);
		
		//Num planted
		g2d.setColor(Color.BLACK);
		g2d.fillRect(screenWidth/2-360,250,685,60);

		//Num invaseive
		g2d.setColor(Color.BLACK);
		g2d.fillRect(screenWidth/2-410,450,765,60);
		
		//Take survey
		g2d.setColor(mixed = new Color(30, 60, 25));
		g2d.fillOval(screenWidth/2-400,723,740,125);
		
		//Text colors
		Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size		
		g.setFont(fnt0);		
		g.setColor(Color.WHITE);
		g.drawString("Congratulations!",screenWidth/2 -200,100 );

		g.setColor(Color.RED);
		g.drawString("You planted " + plantedCount + " native plants!", screenWidth/2-350,300);

		g.drawString("You removed " + plantsRemoved + " invasive plants!", screenWidth/2-400,500);
		
		g.setColor(Color.WHITE);
		g.drawString("Click to test your knowledge!", screenWidth/2-380,800);


		
	}
	
}
