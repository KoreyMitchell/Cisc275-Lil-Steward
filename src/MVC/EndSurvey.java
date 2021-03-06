package MVC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;



// TODO: Auto-generated Javadoc
/**
 * The Class EndSurvey.
 */
public class EndSurvey extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
//		g2d.drawOval(screenWidth/2 -230,25,350,125);	//congrats oval
//		g2d.setColor(mixed = new Color(30, 60, 25));
//		g2d.fillOval(screenWidth/2 -230,25,350,125);
		
		//draw banner for questions
		g2d.drawImage(blueBannerImg, screenWidth/2-480,110,1010,670, null);

		//Survey Text
		Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size
		g2d.drawImage(greyBannerImg, screenWidth/2 -170,30,350,100, null);
		g2d.setFont(fnt0);		
		g2d.setColor(Color.BLACK);
		g2d.drawString("Survey",screenWidth/2 -79,100 );

		

		//Question 1
		Font fnt1 = new Font("arial",Font.BOLD,30); //font,bold,size		
		g2d.setFont(fnt1);		
		g2d.setColor(Color.BLACK);
		g2d.drawString("Which one is the Invasive Specie? (Click One)",screenWidth/2-385,210);
			
			g2d.setFont(new Font("Dialog", Font.ITALIC,18));
			g2d.setColor(new Color(20,20,100));
			
			//First Choice
			g2d.drawString("Dirt", screenWidth/2-373,380);
			g2d.drawImage(groundimg, screenWidth/2-385,300, null);
			
			
			//Second Choice
			g2d.drawString("Inkberry Bush", screenWidth/2-280,380);
			g2d.drawImage(rockimg, screenWidth/2-250, 300, null);
			
			//Third Choice
			g2d.drawString("Phragmite", screenWidth/2-130,380);
			g2d.drawImage(iplantimg, screenWidth/2-120, 235, null);
			
			//Fourth Choice
			g2d.drawString("Aster", screenWidth/2,380);
			g2d.drawImage(nplantimg, screenWidth/2-5, 300, null);

		//Question 2
		g2d.setFont(fnt1);		
		g2d.setColor(Color.BLACK);
		g2d.drawString("Which species was planted? (Click One)",screenWidth/2-385,415);
			
			g2d.setFont(new Font("Dialog", Font.ITALIC,18));
			g2d.setColor(new Color(20,20,100));
			
			//First Choice
			g2d.drawString("Dirt", screenWidth/2-373,580);
			g2d.drawImage(groundimg, screenWidth/2-385,500, null);
			
			//Second Choice
			g2d.drawString("Inkberry Bush", screenWidth/2-280,580);
			g2d.drawImage(rockimg, screenWidth/2-250, 500, null);
			
			//Third Choice
			g2d.drawString("Phragmite", screenWidth/2-130,580);
			g2d.drawImage(iplantimg, screenWidth/2-120, 430, null);
			
			//Fourth Choice
			g2d.drawString("Aster", screenWidth/2,580);
			g2d.drawImage(nplantimg, screenWidth/2-5, 500, null);
		
		//Question 3
		g2d.setFont(fnt1);		
		g2d.setColor(Color.BLACK);
		g2d.drawString("What is the type of bush that birds love to feed on? (Click One)",screenWidth/2-385,630);
		
		Font fnt3 = new Font("arial",Font.BOLD,20); //font,bold,size	
		g2d.setFont(fnt3);		
		g2d.setColor(new Color(100,20,60));
		g2d.drawRect(screenWidth/2-255,672, 100, -50);
		g2d.drawString("Blueberry",screenWidth/2-255,672);
		g2d.drawString("Inkberry",screenWidth/2-400,672);
		g2d.drawString("Bananaberry",screenWidth/2-75,672);
		g2d.drawString("Chocolateberry",screenWidth/2+135,672);

		int numIncorrect=0;
		//Q1 correct/incorrect draw
		if (q1Correct == true && q1Incorrect ==false) {
			g2d.setColor(Color.GREEN);
			g2d.drawString("Correct!",screenWidth/2-600,300);
			
		}		
		if(q1Incorrect ==true && q1Correct ==false) {
			g2d.setColor(Color.RED);
			if(numIncorrect==0)
				g2d.drawString("Sorry, Try Again", screenWidth/2-600,300);

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
			g2d.drawString("Wow! You got all questions correct!",screenWidth/2-400,840);
			//Image newplayerimgRight = playerimgRight.getScaledInstance(500, 500, Image.SCALE_DEFAULT);
			g2d.drawImage(playerimgRight, screenWidth/2-700,710, 270, 300, null);

		}
		

	}
	
	
	public boolean isQ1Correct() {
		return q1Correct;
	}


	public void setQ1Correct(boolean q1Correct) {
		this.q1Correct = q1Correct;
	}


	public boolean isQ2Correct() {
		return q2Correct;
	}


	public void setQ2Correct(boolean q2Correct) {
		this.q2Correct = q2Correct;
	}


	public boolean isQ3Correct() {
		return q3Correct;
	}


	public void setQ3Correct(boolean q3Correct) {
		this.q3Correct = q3Correct;
	}


	public boolean isQ1Incorrect() {
		return q1Incorrect;
	}


	public void setQ1Incorrect(boolean q1Incorrect) {
		this.q1Incorrect = q1Incorrect;
	}


	public boolean isQ2Incorrect() {
		return q2Incorrect;
	}


	public void setQ2Incorrect(boolean q2Incorrect) {
		this.q2Incorrect = q2Incorrect;
	}


	public boolean isQ3Incorrect() {
		return q3Incorrect;
	}


	public void setQ3Incorrect(boolean q3Incorrect) {
		this.q3Incorrect = q3Incorrect;
	}

	
}
