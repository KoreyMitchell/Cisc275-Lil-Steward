package MVC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EndSurvey extends View {

	JFrame f;
	Color mixed;	//(red,green,blue) saturation

	public void render(Graphics g) {
		//f = new JFrame();
		Graphics2D g2d= (Graphics2D) g;

		//Survey Oval Graphic
		g2d.drawOval(screenWidth/2 -230,25,350,125);	//congrats oval
		g2d.setColor(mixed = new Color(30, 60, 25));
		g2d.fillOval(screenWidth/2 -230,25,350,125);
		
		//Survey Text
		Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size		
		g2d.setFont(fnt0);		
		g2d.setColor(Color.WHITE);
		g2d.drawString("Survey",screenWidth/2 -140,100 );
		
		//Question 1
		Font fnt1 = new Font("arial",Font.BOLD,30); //font,bold,size		
		g2d.setFont(fnt1);		
		g2d.setColor(Color.BLACK);
		g2d.drawString("Which one is the Invasive Specie?",screenWidth/2-385,210);
		
		g2d.drawImage(groundimg, screenWidth/2-385,300, null);
		g2d.drawImage(rockimg, screenWidth/2-250, 300, null);
		g2d.drawImage(iplantimg, screenWidth/2-120, 235, null);
		g2d.drawImage(nplantimg, screenWidth/2-5, 300, null);

		//Question 2
		g2d.setFont(fnt1);		
		g2d.setColor(Color.BLACK);
		g2d.drawString("What type of bushes were the obstacles?",screenWidth/2-385,430);
		g2d.drawString("65", screenWidth/2-385,480);
		g2d.drawString("73", screenWidth/2-320,480);
		g2d.drawString("85", screenWidth/2-260,480);
		g2d.drawString("23", screenWidth/2-200,480);


	}

}
