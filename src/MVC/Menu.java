package MVC;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu  extends View{
	//initialize buttons, (x,y,w,h)
	public Rectangle playButton = new Rectangle(screenWidth/2-35,150,100,50);
	public Rectangle quitButton = new Rectangle(screenWidth/2-35,250,100,50);
	public Rectangle anotherButton = new Rectangle(screenWidth/2-35,350,100,50);

	public void render(Graphics g) {
		//2d graphics for buttons
		Graphics2D g2d = (Graphics2D) g;
		
		//Title 
		Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size		
		g.setFont(fnt0);		
		g.setColor(Color.white);
		g.drawString("Estuary Game",screenWidth/2-150,100 );
		
		//Buttons
		Font fnt1 = new Font("arial",Font.BOLD,20); //font,bold,size		
		g.setFont(fnt1);
		g.drawString("Play",playButton.x+30,playButton.y+30);
		g.drawString("Quit",quitButton.x+30,quitButton.y+30);
		g.drawString("Help",anotherButton.x+30,anotherButton.y+30);

		g2d.draw(playButton);
		g2d.draw(quitButton);
		g2d.draw(anotherButton);
		
	}

	
}