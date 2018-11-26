package MVC;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class View extends JPanel{

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
	
	public void initialize(MouseListener m, KeyListener k) {
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setTitle("Wetlands Game");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(700,365);
		//frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.addMouseListener(m);
		frame.addKeyListener(k);
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		
		for(GroundPatch gr : groundList) {
			g2d.drawImage(groundimg,gr.getXloc(),gr.getYloc(), null);
		}
		for(Obstacle o : obstacleList) {
			g2d.drawImage(rockimg,o.getXloc(),o.getYloc(), null);
		}
		for(InvasivePlant in : invasivePlants) {
			g2d.drawImage(iplantimg,in.getXloc(),in.getYloc(), null);
		}
		for(NativePlant n : nativePlants) {
			g2d.drawImage(nplantimg,n.getXloc(),n.getYloc(), null);
		}
		g2d.drawImage(playerimg,player.getXloc(),player.getYloc(), null);
	}
	
	public void setPlayer(PlayerCharacter p) {
		player.setXloc(p.getXloc());
		player.setYloc(p.getYloc());
	}
	
	public void setNativePlants(ArrayList<NativePlant> n) {
		nativePlants.clear();
		nativePlants.addAll(n);
	}
	
	public void setInvasivePlants(ArrayList<InvasivePlant> in) {
		invasivePlants.clear();
		invasivePlants.addAll(in);
	}
	
	public void setPatches(ArrayList<GroundPatch> g) {
		groundList.clear();
		groundList.addAll(g);
	}
	
	public void setObstacles(ArrayList<Obstacle> o ) {
		obstacleList.clear();
		obstacleList.addAll(o);
	}
	
	public void setTool(Tool t) {
		tool = t;
	}
	
	public void printStuff() {
		//For testing purposes: prints the location of all the objects
		System.out.println("Your location is: " + player.getXloc() + ", " + player.getYloc());
		for(GroundPatch gr : groundList) {
			System.out.println("Plantable ground at " + gr.getXloc() + " and " + gr.getYloc());
			
		}
		for(NativePlant nat : nativePlants) {
			System.out.println("Goldenrod" + " at " + nat.getXloc() + " and " + nat.getYloc());
		}
		for(InvasivePlant nat : invasivePlants) {
			System.out.println("Phragmites" + " at " + nat.getXloc() + " and " + nat.getYloc());
		}
		for(Obstacle ob : obstacleList) {
			System.out.println("Obstacle" + " at " + ob.getXloc() + " and " + ob.getYloc());
		}
	}
	
	
	
}
