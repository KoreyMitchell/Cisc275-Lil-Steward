import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player extends GameObject {

	int xloc, yloc, level;
	int dx, dy, nx, nx2, left;
	Image still, jump, reverse, holder;

	ImageIcon s = new ImageIcon("res/Person-Images/Person-Right.png");
	ImageIcon j = new ImageIcon("res/Person-Images/Person-Front.png");
	ImageIcon l = new ImageIcon("res/Person-Images/Person-Left.png");

	public Player(int xloc, int yloc, int level) { // call with 75
		super(xloc, yloc);
		this.level = level;
		left = 0;
		nx = 0;
		nx2 = 685;
		still = s.getImage();
		holder = still;
		jump = j.getImage();
	}

	public Player() { // By default, Java calls parent constructor w/o super()
		this.level = 0;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getnX() {
		return nx;
	}
	
	public int getnX2() {
		return nx2;
	}

	public int getdx() {
		return dx;
	}
	
	public Image getImage() {
		return still;
	}

	public void move() {
		if (dx == 1) {
			if (left + dx <= 1366-50) {
				left += dx;
			}
		}
		else if (dx == -1) {
			if (left + dx >= 0) {
				left = left + dx;
			}
		}
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT)
		{		dx = -1;
		still = l.getImage();
		holder = still;}
		
		if (key == KeyEvent.VK_RIGHT)
			{dx = 1;
		still = s.getImage();
		holder = still;
			}
		
		if (key == KeyEvent.VK_UP)
			{dy = 1;
			still = j.getImage();
			}			}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT)
			dx = 0;

		if (key == KeyEvent.VK_RIGHT)
			dx = 0;
		
		if (key == KeyEvent.VK_UP)
			{dy = 0;
			still = holder;}
		if (key == KeyEvent.VK_Q) {
			System.exit(0);
		}
			}

}
