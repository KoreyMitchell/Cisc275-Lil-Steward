import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class Controller {
	
	private Model model;
	private View view;
	
	public Controller() {
		view = new View();
		view.initialize();
		model = new Model();
	}
	public void setGame() {
		
	}
	
	public String getGame() {
		return null;
		
	}
	
	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
		

	}
	
	public void start() {
		
	}
	
	public void updateView() {
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			model.left();
		}

		if (key == KeyEvent.VK_RIGHT) {
			model.right();
		}

		if (key == KeyEvent.VK_UP) {
			model.up();
		}
		if (key == KeyEvent.VK_DOWN) {
			model.down();
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT)
			model.velx = 0;

		if (key == KeyEvent.VK_RIGHT)
			model.velx = 0;

		if (key == KeyEvent.VK_UP) {
			model.vely = 0;
		}
		if (key == KeyEvent.VK_DOWN) {
			model.vely = 0;
		}
		
		if (key == KeyEvent.VK_Q) {
			System.exit(0);
		}
	}
	
}
