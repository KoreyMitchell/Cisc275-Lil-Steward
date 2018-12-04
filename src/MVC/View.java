package MVC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JPanel implements MouseListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PlayerCharacter player;
	ArrayList<NativePlant> nativePlants;
	ArrayList<InvasivePlant> invasivePlants;
	ArrayList<GroundPatch> groundList;
	ArrayList<Obstacle> obstacleList;
	Tool tool;
	Controller control;
	
	JFrame frame;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenHeight = (int) screenSize.getHeight();
	int screenWidth = screenSize.getSize().width;
	
	static int plantedCount = 0;
	static int plantsRemoved = 0;
	int manFrameCountRight = 0;
	
	int level;

	Image playerimgFront;
	Image playerimgBack;
	Image playerimgRight;
	Image playerimgLeft;
	Image playerimg;
	Image groundimg;
	Image nplantimg;
	Image iplantimg;
	Image rockimg;
	Image backgroundimg;
	Image scaled_bg_img;
	Image menuimg;
	Image scaled_bg_img_menu;
	Image tutorialNote1;
	
	Graphics g;
	
	//Menu
	private Menu menu;
	
	//EndScreen
	private EndScreen endScreen;
	//TEST
	//private EndGameTest test;
	
	ToolBar toolbar;
    
	//TODO: Will use these to check for multiple key presses
	boolean isUpPressed, isDownPressed, isRightPressed,isLeftPressed;
	boolean[] keyArray = new boolean[4];
	
    
	public View() {
		player = new PlayerCharacter();
		nativePlants = new ArrayList<NativePlant>();
		invasivePlants = new ArrayList<InvasivePlant>();
		groundList = new ArrayList<GroundPatch>();
		obstacleList = new ArrayList<Obstacle>();
		tool = new Tool(true);
		
		setFocusable(true);
		
		requestFocusInWindow();
		
		//Images
	
		ImageIcon bgImage = new ImageIcon("images/grass_template2.jpg");
		ImageIcon bgMenuImage = new ImageIcon("images/background.png");
		ImageIcon tutNote1 = new ImageIcon("images/stickynote_phragmites.png");
		
		//Items
		ImageIcon groundicon = new ImageIcon("images/ground.png");
		ImageIcon nplanticon = new ImageIcon("images/nativeplant.png");
		ImageIcon iplanticon = new ImageIcon("images/phragmites.png");
		ImageIcon rockicon = new ImageIcon("images/rock.png");
		
		//Player 
		ImageIcon playerImageFront = new ImageIcon("images/Person_FRONT.png");
		ImageIcon playerImageBack = new ImageIcon("images/Person_BACK.png");
		ImageIcon playerImageRight = new ImageIcon("images/Person_RIGHT.png");
		ImageIcon playerImageLeft = new ImageIcon("images/Person_LEFT.png");
		playerimgFront = playerImageFront.getImage();
		playerimgBack = playerImageBack.getImage();
		playerimgRight = playerImageRight.getImage();
		playerimgLeft = playerImageLeft.getImage();
		playerimg = playerimgFront;
		
		//Get image from ImageIcon and store in Image variables
		groundimg = groundicon.getImage();
		nplantimg = nplanticon.getImage();
		iplantimg = iplanticon.getImage();
		rockimg = rockicon.getImage();
		backgroundimg = bgImage.getImage();
		menuimg = bgMenuImage.getImage();
		tutorialNote1 = tutNote1.getImage();
		
		
		//scale image to screen size
		scaled_bg_img = backgroundimg.getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT);   
		scaled_bg_img_menu = menuimg.getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT);   
	}
	
	public void paintPlantedInfo(int plantedCount,int x, int y) {
	    final JOptionPane pane = new JOptionPane("You've planted " + plantedCount + " native plants and removed " + plantsRemoved + " invasive Phragmites plants!");
	    final JDialog d = pane.createDialog((JFrame)null, "New Message!");
	    d.setLocation(x,y);
	    d.setVisible(true);
//		JOptionPane.showMessageDialog(null, 
//                "You've planted a new plant! #" + plantedCount, 
//                "New Message!", 
//                JOptionPane.PLAIN_MESSAGE);
		
	}
	//state of game
	public enum STATE{
		MENU,
		GAME,
		TEST,
		END
	};
	
	
	
	//Initialize state to Menu, to skip menu for testing change state to GAME
	public static STATE State = STATE.MENU;

	@SuppressWarnings("static-access")
	public void initialize() {
		// this method was meant to add the Controller listeners to View, but we're
		// changing it so that the Listeners are in the View instead
		
			frame = new JFrame();
			frame.add(this);
			frame.pack();
			frame.setResizable(false);     
			
			frame.setTitle("Wetlands Game");
			frame.setLayout(new GridLayout(1,1));
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setSize(screenSize);
			//frame.setSize(700, 365);
			//frame.pack();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.addMouseListener(this);
			frame.addKeyListener(this);
	        
			//Toolbar
			JButton b=new JButton("Tool",new ImageIcon("images/rock.png")); 
	        JPanel panel = new JPanel();
			b.setBounds(100,screenHeight-300,150, 150);  
			frame.add(b); 
			b.setVisible(true);
			
			panel.add(b);
	       // this.getRootPane().add(panel);
	        setVisible(true);
		
	        addKeyListener(this); 	//makes player move		

			//Create a new Menu
			menu= new Menu();
			
			//create a a new endgame test
			//test  = new  EndGameTest();
			
			//toolbar = new ToolBar();
			
			endScreen = new EndScreen();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(scaled_bg_img, 0, 0, null);

		//if in GAME state
		if(State == STATE.GAME) {
			level=0;
			if(level == 0) {
			
				g2d.drawImage(scaled_bg_img, 0, 0, null);
				g2d.drawImage(tutorialNote1, 50, 50, null);
				g2d.drawImage(playerimg, player.getXloc(), player.getYloc(), null);
				// need reset
				
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
				//draw the playerimage
				g2d.drawImage(playerimg, player.getXloc(), player.getYloc(), null);
				
			
				
			}
			else if(level <=3 && level !=0) {
		
			g2d.drawImage(scaled_bg_img, 0, 0, null);
			
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
			
			//draw the playerimage
			g2d.drawImage(playerimg, player.getXloc(), player.getYloc(), null);
			
			}
		
		}else if (State == STATE.TEST) {
			g2d.drawImage(scaled_bg_img_menu, 0, 0, null);
			//test.EndGameTest();
		}else if(State ==STATE.MENU) {//if game state is not in game,draw menu
			g2d.drawImage(scaled_bg_img_menu, 0, 0, null);
			menu.renderMenu(g);
		
		}else if(State == STATE.END) {
			endScreen.render(g);
		}
		
	}
	
	//set view's level to match model's
	public void setLevel(int lev) {
		level = lev;
	}
	
	//set view's controller to match input controller
	public void setControl(Controller c) {
		control = c;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Mouse clicked");
		System.out.println("Mouse clicked");
		System.out.println(e.getX() + " " + e.getY());
		control.click(e.getX(),e.getY());
		//plantedCount++;
		//paintPlantedInfo(plantedCount, e.getX(), e.getY());
		
		int mx = e.getX();	//x value of mouse
		int my = e.getY();	//y value of mouse
		
		if(State == STATE.GAME) 
		{
			control.click(mx,my);
		}	 
			//System.out.println("Mouse clicked");
	
	}

	public int getPlantedCount() {
		return plantedCount;
	}

	public void setPlantedCount(int plantedCount) {
		this.plantedCount = plantedCount;
	}

	public int getPlantsRemoved() {
		return plantsRemoved;
	}

	public void setPlantsRemoved(int plantsRemoved) {
		this.plantsRemoved = plantsRemoved;
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx = e.getX();	//x value of mouse
		int my = e.getY();	//y value of mouse

		/*
		 * 	public Rectangle playButton = new Rectangle(screenWidth/2-35,150,100,50);
			public Rectangle quitButton = new Rectangle(screenWidth/2-35,250,100,50);
			public Rectangle anotherButton = new Rectangle(screenWidth/2-35,350,100,50);
		 */

		
		if(State == STATE.MENU) {
		if(mx >= screenWidth/2-65 && mx <= screenWidth/2 + 35 )
		{	//first button
			if(my >= 230 && my <= 280)
			{
				System.out.print(mx + " " +  my);
				//Pressed play button
				level = 0;
				View.State = View.STATE.GAME;
			}
// 			//second button
// 			if(my >= 280 && my <= 330)
// 			{
// 				//Pressed tutorial button
// 				level = 0;
// 				View.State = View.STATE.GAME;
// 			}
			//third button
			if(my >= 330 && my <= 380)
			{
				//Pressed other button
				System.exit(1);
			}
		}

		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		control.key(e);
	 
		//System.out.println("Key pressed");
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Key pressed");
		control.key(e);
		
	//	int s = e.getKeyCode();
	
	}
	
	public void drawEndScreen() {
		
		super.paintComponent(g);
		Font fnt0 = new Font("arial",Font.BOLD,50); //font,bold,size		
		g.setFont(fnt0);		
		g.setColor(Color.ORANGE);
		g.drawString("Game Over",screenWidth/2-150,100 );
	}
	
//**-------------------------------Testing-----------------------------------------------**//
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

}
