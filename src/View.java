import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class View extends JPanel implements ActionListener, Runnable{
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
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenHeight = screenSize.getSize().height;
	int screenWidth = screenSize.getSize().width;
	JButton button = new JButton("Close");

	
	Player p;
	Model m;
	public Image img;
	Timer time;
	int v = 172;
	Thread animator;

	boolean a = false;
	boolean done2 = false;
	
	public View() {
		p = new Player(75, 172, 0);
		m = new Model();
		//addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("res/Person-Images/Background.jpg");
		img = i.getImage();
		time = new Timer(5, this);
		time.start();
	}
	
	public void initialize(){
		JFrame frame = new JFrame();
		frame.add(new View());	
		frame.setTitle("2-D Test Game");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(screenSize);
		//frame.setUndecorated(true);  //uncomment this to run the game in fullscreen mode
		//frame.setSize(700,365);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		m.move();
		repaint();
	}
	

	public void paint(Graphics g) {
		if (p.dy == 1 && done2 == false) {
			done2 = true;
			animator = new Thread(this);
			animator.start();
			//System.out.print(p.nx);
		}

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		if ((p.getXloc() - 590) % 2400 == 0)// p.getX() == 590 || p.getX() == 2990)
			p.nx = 0;
		if ((p.getXloc() - 1790) % 2400 == 0)// p.getX() == 1790 || p.getX() == 4190)
			p.nx2 = 0;

		g2d.drawImage(img, 685 - p.getnX2(), 0, null);
		if (p.getXloc() > 590) {
			g2d.drawImage(img, 685 - p.getnX(), 0, null);
		}
		g2d.drawImage(p.getImage(), p.left, v, null);

		if (p.getdx() == -1) {
			g2d.drawImage(img, 685 - p.getnX2(), 0, null);
			g2d.drawImage(p.getImage(), p.left, v, null);
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


	boolean h = false;
	boolean done = false;

	public void cycle() {

		if (h == false)
			v--;
		if (v == 125)
			h = true;
		if (h == true && v <= 172) {
			v++;
			if (v == 172) {
				done = true;
			}
		}
	}

	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (done == false) {

			cycle();

			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = 10 - timeDiff;

			if (sleep < 0)
				sleep = 2;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}

			beforeTime = System.currentTimeMillis();
		}
		done = false;
		h = false;
		done2 = false;
	}
	

}