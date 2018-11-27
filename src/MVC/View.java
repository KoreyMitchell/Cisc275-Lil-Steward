package MVC;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class View extends JPanel implements MouseListener{

	PlayerCharacter player;
	ArrayList<NativePlant> nativePlants;
	ArrayList<InvasivePlant> invasivePlants;
	ArrayList<GroundPatch> groundList;
	ArrayList<Obstacle> obstacleList;
	Tool tool;

	Image playerimg;
	Image groundimg;
	Image nplantimg;
	Image iplantimg;
	Image rockimg;

	public View() {
		player = new PlayerCharacter();
		nativePlants = new ArrayList<NativePlant>();
		invasivePlants = new ArrayList<InvasivePlant>();
		groundList = new ArrayList<GroundPatch>();
		obstacleList = new ArrayList<Obstacle>();
		tool = new Tool(true);

		setFocusable(true);
		requestFocusInWindow();
		ImageIcon playericon = new ImageIcon("images/player.png");
		ImageIcon groundicon = new ImageIcon("images/ground.png");
		ImageIcon nplanticon = new ImageIcon("images/nativeplant.png");
		ImageIcon iplanticon = new ImageIcon("images/phragmites.png");
		ImageIcon rockicon = new ImageIcon("images/rock.png");
		playerimg = playericon.getImage();
		groundimg = groundicon.getImage();
		nplantimg = nplanticon.getImage();
		iplantimg = iplanticon.getImage();
		rockimg = rockicon.getImage();

	}

	public void initialize() {
		// this method was meant to add the Controller listeners to View, but we're
		// changing it so that the Listeners are in the View instead
		
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setTitle("Wetlands Game");
		frame.setLayout(new GridLayout(1,1));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(700, 365);
		//frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.addMouseListener(this);
		//frame.addKeyListener(k);
	}

	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		// draw each of the game objects
		for (GroundPatch gr : groundList) {
			g2d.drawImage(groundimg, gr.getXloc(), gr.getYloc(), null);
		}
		for (Obstacle o : obstacleList) {
			g2d.drawImage(rockimg, o.getXloc(), o.getYloc(), null);
		}
		for (InvasivePlant in : invasivePlants) {
			g2d.drawImage(iplantimg, in.getXloc(), in.getYloc(), null);
		}
		for (NativePlant n : nativePlants) {
			g2d.drawImage(nplantimg, n.getXloc(), n.getYloc(), null);
		}
		g2d.drawImage(playerimg, player.getXloc(), player.getYloc(), null);
	}

	// set player location to match input player
	public void setPlayer(PlayerCharacter p) {
		player.setXloc(p.getXloc());
		player.setYloc(p.getYloc());
	}

	// set list of native plants to input
	public void setNativePlants(ArrayList<NativePlant> n) {
		nativePlants.clear();
		nativePlants.addAll(n);
	}

	// set list of invasive plants to input
	public void setInvasivePlants(ArrayList<InvasivePlant> in) {
		invasivePlants.clear();
		invasivePlants.addAll(in);
	}

	// set list of plantable ground to input
	public void setPatches(ArrayList<GroundPatch> g) {
		groundList.clear();
		groundList.addAll(g);
	}

	// set obstacles to input
	public void setObstacles(ArrayList<Obstacle> o) {
		obstacleList.clear();
		obstacleList.addAll(o);
	}

	// set tool to input
	public void setTool(Tool t) {
		tool = t;
	}

	public void printStuff() {
		// For testing purposes: prints the location of all the objects to console
		System.out.println("Your location is: " + player.getXloc() + ", " + player.getYloc());
		for (GroundPatch gr : groundList) {
			System.out.println("Plantable ground at " + gr.getXloc() + " and " + gr.getYloc());

		}
		for (NativePlant nat : nativePlants) {
			System.out.println("Goldenrod" + " at " + nat.getXloc() + " and " + nat.getYloc());
		}
		for (InvasivePlant nat : invasivePlants) {
			System.out.println("Phragmites" + " at " + nat.getXloc() + " and " + nat.getYloc());
		}
		for (Obstacle ob : obstacleList) {
			System.out.println("Obstacle" + " at " + ob.getXloc() + " and " + ob.getYloc());
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Mouse clicked");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
