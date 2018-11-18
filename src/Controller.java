import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

public class Controller implements KeyListener{
	
	private Model model;
	private View view;
	
	public Controller() {
		view = new View();
		
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
		//Initializes the controller's model and view
		
		view.initialize();
		view.addKeyListener(this);
		System.out.println("View started");
		
		
	}
	
	public void updateView() {
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			model.left();
			System.out.println("Left pressed");
		}

		if (key == KeyEvent.VK_RIGHT) {
			model.right();
			System.out.println("Right pressed");
		}

		if (key == KeyEvent.VK_UP) {
			model.up();
			System.out.println("Up pressed");
		}
		if (key == KeyEvent.VK_DOWN) {
			model.down();
			System.out.println("Down pressed");
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
	
	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			keyPressed(e);
		}
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			model.left();
			System.out.println("Left pressed");
		}

		if (key == KeyEvent.VK_RIGHT) {
			model.right();
			System.out.println("Right pressed");
		}

		if (key == KeyEvent.VK_UP) {
			model.up();
			System.out.println("Up pressed");
		}
		if (key == KeyEvent.VK_DOWN) {
			model.down();
			System.out.println("Down pressed");
		}
	}
	
}
