import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel{
	int x;
	int y;
	int w = 500;
	int h = 300;
	int iw = 165;
	int ih = 165;
	int frameCount = 10;
	int picNum = 0;
	int arrayCounter = 0;
	
	BufferedImage[][] pica;
	JFrame frame;
	private JButton pauseButton = new JButton("pause");
	MouseListener mouseListener;
	
	private BufferedImage createImage(File filo) {
		return null;
		
	}
	
	// Override this JPanel's paint method to cycle through picture array and draw
	public void paint(Graphics g) {
		
	}

	public int getWidth() {
		return w;
	}
	public int getHeight() {
		return h;
	}

	public int getImageWidth() {
		return iw;
	}

	public int getImageHeight() {
		return ih;
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
}
