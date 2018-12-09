package MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


// TODO: Auto-generated Javadoc
/**
 * The Class EndSurvey.
 */
public class EndSurvey extends View {

	/** The f. */
	JFrame f;
	
	/** The mixed. */
	Color mixed;	//(red,green,blue) saturation
	
	/** The q 1 correct. */
	boolean q1Correct = false;

	/** The q 2 correct. */
	boolean q2Correct = false;
	
	/** The q 3 correct. */
	boolean q3Correct = false;

	boolean q1Incorrect = false;
	boolean q2Incorrect = false;
	boolean q3Incorrect = false;

	
	/**
	 * Render.
	 *
	 * @param g the g
	 */
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
		g2d.drawString("Which one is the Invasive Specie? (Click One)",screenWidth/2-385,210);
		
		g2d.drawImage(groundimg, screenWidth/2-385,300, null);
		g2d.drawImage(rockimg, screenWidth/2-250, 300, null);
		g2d.drawImage(iplantimg, screenWidth/2-120, 235, null);
		g2d.drawImage(nplantimg, screenWidth/2-5, 300, null);

		//Question 2
		g2d.setFont(fnt1);		
		g2d.setColor(Color.BLACK);
		g2d.drawString("Which species was planted? (Click One)",screenWidth/2-385,430);
		g2d.drawImage(groundimg, screenWidth/2-385,500, null);
		g2d.drawImage(rockimg, screenWidth/2-250, 500, null);
		g2d.drawImage(iplantimg, screenWidth/2-120, 450, null);
		g2d.drawImage(nplantimg, screenWidth/2-5, 500, null);
		
		//Question 3
		g2d.setFont(fnt1);		
		g2d.setColor(Color.BLACK);
		g2d.drawString("What is the type of bush that birds love to feed on? (Click One)",screenWidth/2-385,630);
		
		Font fnt3 = new Font("arial",Font.BOLD,20); //font,bold,size	
		g2d.setColor(Color.GREEN);
		g2d.setFont(fnt3);		
		g2d.drawString("Blueberry",screenWidth/2-255,672);
		g2d.drawString("Inkberry",screenWidth/2-400,672);
		g2d.drawString("Bananaberry",screenWidth/2-75,672);
		g2d.drawString("Chocolateberry",screenWidth/2+135,672);

		//Q1 correct/incorrect draw
		if (q1Correct == true && q1Incorrect ==false) {
			g2d.setColor(Color.GREEN);
			g2d.drawString("Correct",screenWidth/2-600,300);
			
		}		
		if(q1Incorrect ==true && q1Correct ==false) {
			g2d.setColor(Color.RED);
			g2d.drawString("Incorrect", screenWidth/2-600,300);
		}
		
		//Q2 correct/incorrect draw
		if (q2Correct == true && q2Incorrect ==false) {
			g2d.setColor(Color.GREEN);
			g2d.drawString("Correct",screenWidth/2-600,530);
		}
		if(q2Incorrect ==true && q2Correct ==false) {
			g2d.setColor(Color.RED);
			g2d.drawString("Incorrect", screenWidth/2-600,530);
		}
		
		//	Q3 correct/incorrect draw
		if (q3Correct == true&& q3Incorrect ==false) {
			g2d.setColor(Color.GREEN);
			g2d.drawString("Correct",screenWidth/2-600,660);
		}
		
		if(q3Incorrect ==true && q3Correct ==false) {
			g2d.setColor(Color.RED);
			g2d.drawString("Incorrect", screenWidth/2-600,660);
		}
		
		//Draw if all q's are correct
		if(q1Correct && q2Correct && q3Correct) {
			Font fnt2 = new Font("arial",Font.BOLD,50); //font,bold,size	
			g2d.setFont(fnt2);		
			g2d.setColor(Color.YELLOW);
			g2d.drawString("Wow! You got all questions correct!",screenWidth/2-400,810);
			//Image newplayerimgRight = playerimgRight.getScaledInstance(500, 500, Image.SCALE_DEFAULT);
			g2d.drawImage(playerimgRight, screenWidth/2-700,710, 270, 300, null);

		}
		

	}
	

	
}
