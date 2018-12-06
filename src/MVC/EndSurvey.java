package MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class EndSurvey extends View {

	JFrame f;
	Color mixed;	//(red,green,blue) saturation
	boolean q1Correct = false;
	boolean q2Correct = false;
	boolean q3Correct = false;

	
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
		g2d.drawString("Which species was planted?",screenWidth/2-385,430);
		g2d.drawImage(groundimg, screenWidth/2-385,500, null);
		g2d.drawImage(rockimg, screenWidth/2-250, 500, null);
		g2d.drawImage(iplantimg, screenWidth/2-120, 450, null);
		g2d.drawImage(nplantimg, screenWidth/2-5, 500, null);
		
		//Question 3
		g2d.setFont(fnt1);		
		g2d.setColor(Color.BLACK);
		g2d.drawString("How tall are Phragmites?",screenWidth/2-385,630);
		
		g2d.drawString("6 ft",screenWidth/2-255,672);
		g2d.drawString("1 in",screenWidth/2-385,672);
		g2d.drawString("1 ft",screenWidth/2-145,672);
		g2d.drawString("100 ft",screenWidth/2-2,672);


		
		if (q1Correct == true) {
			g2d.setColor(Color.GREEN);
			g2d.drawString("Correct",screenWidth/2-600,300);
		}
		
		if (q2Correct == true) {
			g2d.setColor(Color.GREEN);
			g2d.drawString("Correct",screenWidth/2-600,530);
		}
		
		if (q3Correct == true) {
			g2d.setColor(Color.GREEN);
			g2d.drawString("Correct",screenWidth/2-600,660);
		}
	}
	

	
}
