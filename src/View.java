import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel{
	Player playerCharacter;
	BufferedImage  playerImage;
	ArrayList<NativePlant> listOfNativePlants;
	BufferedImage nPlantImage;
	Toolbar toolbar;
	BufferedImage toolbarImage;
	ToDoList todolist;
	BufferedImage listBackground;
	ArrayList<Obstacle> obstacleList;
	BufferedImage obstacleImage;
	ArrayList<GroundPatch> groundList;
	BufferedImage groundImage;
	BufferedImage bglImage;
	
	
	//BufferedImage[][] pica;
	JFrame frame;
	private JButton pauseButton = new JButton("pause");
	MouseListener mouseListener;

	private BufferedImage createImage(File filo) {
		return null;
		
	}
	
	// Override this JPanel's paint method to cycle through picture array and draw
	public void paint(Graphics g) {
		
	}

	//would add Direct z if using direction
	public void update(int x, int y) {
		
	}
	
	void addPauseListener(ActionListener listenForPauseButton) {
		pauseButton.addActionListener(listenForPauseButton);
	}
	
	   void addMouseListener(MouseAdapter listenForClick) {
		frame.addMouseListener(listenForClick);
	}
	   
	   public void keyPressed(KeyEvent e) {
//
//		    int key = e.getKeyCode();
//
//		    if (key == KeyEvent.VK_LEFT) {
//		        dx = -1;
//		    }
//
//		    if (key == KeyEvent.VK_RIGHT) {
//		        dx = 1;
//		    }
//
//		    if (key == KeyEvent.VK_UP) {
//		        dy = -1;
//		    }
//
//		    if (key == KeyEvent.VK_DOWN) {
//		        dy = 1;
//		    }
		}
}
