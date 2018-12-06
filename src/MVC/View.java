package MVC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 */
public class View extends JPanel implements MouseListener, KeyListener{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The player. */
	PlayerCharacter player;
	
	/** The native plants. */
	ArrayList<NativePlant> nativePlants;
	
	/** The invasive plants. */
	ArrayList<InvasivePlant> invasivePlants;
	
	/** The ground list. */
	ArrayList<GroundPatch> groundList;
	
	/** The obstacle list. */
	ArrayList<Obstacle> obstacleList;
	ArrayList<GameObject> tutorialNotes;
	
	/** The tool. */
	Tool tool;
	
	/** The control. */
	Controller control;
	
	/** The frame. */
	JFrame frame;
	
	/** The screen size. */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/** The screen height. */
	int screenHeight = (int) screenSize.getHeight();
	
	/** The screen width. */
	int screenWidth = screenSize.getSize().width;
	
	/** The planted count. */
	static int plantedCount = 0;
	
	/** The plants removed. */
	static int plantsRemoved = 0;
	
	/** The man frame count right. */
	int manFrameCountRight = 0;
	
	/** The level. */
	int level = 0;

	/** The playerimg front. */
	Image playerimgFront;
	
	/** The playerimg back. */
	Image playerimgBack;
	
	/** The playerimg right. */
	Image playerimgRight;
	
	/** The playerimg left. */
	Image playerimgLeft;
	
	/** The playerimg. */
	Image playerimg;
	
	/** The groundimg. */
	Image groundimg;
	
	/** The nplantimg. */
	Image nplantimg;
	
	/** The iplantimg. */
	Image iplantimg;
	
	/** The rockimg. */
	Image rockimg;
	
	/** The backgroundimg. */
	Image backgroundimg;
	
	/** The scaled bg img. */
	Image scaled_bg_img;
	
	/** The menuimg. */
	Image menuimg;
	
	/** The scaled bg img menu. */
	Image scaled_bg_img_menu;

	Image tutorialNotePhragmites;
	Image tutorialNoteAster;
	Image tutorialNoteInkberry;
	Image tutorialNoteDirection;

	
	/** The g. */
	Graphics g;
	
	/** The menu. */
	//Menu
	private Menu menu;
	
	/** The end screen. */
	//EndScreen
	private EndScreen endScreen;
	//TEST
	EndGameTest endGameTest;
	
	/** The toolbar. */
	ToolBar toolbar;
    
	/** The is left pressed. */
	//TODO: Will use these to check for multiple key presses
	boolean isUpPressed, isDownPressed, isRightPressed,isLeftPressed;
	
	/** The key array. */
	boolean[] keyArray = new boolean[4];

	EndSurvey endSurvey;

	
    
	
	/**
	 * Instantiates a new view.
	 */
	public View() {
		player = new PlayerCharacter();
		nativePlants = new ArrayList<NativePlant>();
		invasivePlants = new ArrayList<InvasivePlant>();
		groundList = new ArrayList<GroundPatch>();
		obstacleList = new ArrayList<Obstacle>();
		tool = new Tool(true);
		tutorialNotes = new ArrayList<GameObject>();
		
		setFocusable(true);
		
		requestFocusInWindow();
		
		//Images
	
		ImageIcon bgImage = new ImageIcon("images/grass_template2.jpg");
		ImageIcon bgMenuImage = new ImageIcon("images/background.png");
		ImageIcon tutNote1 = new ImageIcon("images/stickynote_phragmites.png");
		ImageIcon tutNote2 = new ImageIcon("images/stickynote_aster.png");
		ImageIcon tutNote3 = new ImageIcon("images/stickynote_inkberry.png");
		ImageIcon tutNote4 = new ImageIcon("images/stickynote_directions.png");
		
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
		tutorialNotePhragmites = tutNote1.getImage();
		tutorialNoteAster = tutNote2.getImage();
		tutorialNoteInkberry = tutNote3.getImage();
		tutorialNoteDirection = tutNote4.getImage();
;//		tutorialNote1 = tutNote1.getImage();
//		tutorialNote2 = tutNote2.getImage();
		

		
		
		//scale image to screen size
		scaled_bg_img = backgroundimg.getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT);   
		scaled_bg_img_menu = menuimg.getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT);   
	}
	
	/**
	 * Paint planted info.
	 *
	 * @param plantedCount the planted count
	 * @param x the x
	 * @param y the y
	 */
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
	
	/**
	 * The Enum STATE.
	 */
	//state of game
	public enum STATE{
		
		/** The menu. */
		MENU,
		
		/** The game. */
		GAME,
		
		/** The test. */
		TEST,
		
		/** The end. */
		END
	};
	
	
	
	/** The State. */
	//Initialize state to Menu, to skip menu for testing change state to GAME
	public static STATE State = STATE.MENU;

	/**
	 * Initialize.
	 */
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
			
			GraphicsEnvironment env =
		            GraphicsEnvironment.getLocalGraphicsEnvironment();
		        GraphicsDevice device = env.getDefaultScreenDevice();
		        device.setFullScreenWindow(frame);
			//test
			
	        
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
			
			//create a a new endgame test
			//test  = new  EndGameTest();
			
	        //Menu stuff
	        menu= new Menu();
			//toolbar = new ToolBar();
			
			endScreen = new EndScreen();
			endSurvey = new EndSurvey();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(scaled_bg_img, 0, 0, null);

		//if in GAME state
		if(State == STATE.GAME) {
			if(level == 0) {
				g2d.drawImage(scaled_bg_img, 0, 0, null);
				
				
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
				for (GameObject n : tutorialNotes) {
					if(n instanceof TutorialNotePhragmites) {
						g2d.drawImage(tutorialNotePhragmites, n.getXloc(), n.getYloc(), null);
					}
					else if(n instanceof TutorialNoteAster) {
						g2d.drawImage(tutorialNoteAster, n.getXloc(), n.getYloc(), null);
					}
					else if(n instanceof TutorialNoteInkberry) {
						g2d.drawImage(tutorialNoteInkberry, n.getXloc(), n.getYloc(), null);
					}
					else if(n instanceof TutorialNoteDirection) {
						g2d.drawImage(tutorialNoteDirection, n.getXloc(), n.getYloc(), null);
					}
					
				}
				
			

			
				//draw the playerimage
				g2d.drawImage(playerimg, player.getXloc(), player.getYloc(), null);
				
				
			
				
			}
			else if(level == 1) {
				
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
		

		}else if(State ==STATE.MENU) {//if game state is not in game,draw menu
			g2d.drawImage(scaled_bg_img_menu, 0, 0, null);
			menu.renderMenu(g);
		}else if(State == STATE.END) {
			endScreen.render(g);
		}else if(State == STATE.TEST) {
			//endGameTest=new EndGameTest();
			endSurvey.render(g2d);
			
		}
		
	}
	
	/**
	 * Sets the level.
	 *
	 * @param lev the new level
	 */
	//set view's level to match model's
	public void setLevel(int lev) {
		level = lev;
	}
	
	/**
	 * Sets the control.
	 *
	 * @param c the new control
	 */
	//set view's controller to match input controller
	public void setControl(Controller c) {
		control = c;
	}

	/**
	 * Sets the player.
	 *
	 * @param p the new player
	 */
	// set player location to match input player
	public void setPlayer(PlayerCharacter p) {
		player.setXloc(p.getXloc());
		player.setYloc(p.getYloc());
	}

	/**
	 * Sets the native plants.
	 *
	 * @param n the new native plants
	 */
	// set list of native plants to input
	public void setNativePlants(ArrayList<NativePlant> n) {
		nativePlants.clear();
		nativePlants.addAll(n);
	}
	public void checkTut() {
		if(level > 1) {
			tutorialNotes.clear();
		}
	}
	
	public void setTutorialNotes(ArrayList<GameObject> n) {
		tutorialNotes.clear();
		tutorialNotes.addAll(n);
	}

	/**
	 * Sets the invasive plants.
	 *
	 * @param in the new invasive plants
	 */
	// set list of invasive plants to input
	public void setInvasivePlants(ArrayList<InvasivePlant> in) {
		invasivePlants.clear();
		invasivePlants.addAll(in);
	}

	/**
	 * Sets the patches.
	 *
	 * @param g the new patches
	 */
	// set list of plantable ground to input
	public void setPatches(ArrayList<GroundPatch> g) {
		groundList.clear();
		groundList.addAll(g);
	}

	/**
	 * Sets the obstacles.
	 *
	 * @param o the new obstacles
	 */
	// set obstacles to input
	public void setObstacles(ArrayList<Obstacle> o) {
		obstacleList.clear();
		obstacleList.addAll(o);
	}

	/**
	 * Sets the tool.
	 *
	 * @param t the new tool
	 */
	// set tool to input
	public void setTool(Tool t) {
		tool = t;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */


	/**
	 * Gets the planted count.
	 *
	 * @return the planted count
	 */
	public int getPlantedCount() {
		return plantedCount;
	}

	/**
	 * Sets the planted count.
	 *
	 * @param plantedCount the new planted count
	 */
	public void setPlantedCount(int plantedCount) {
		this.plantedCount = plantedCount;
	}

	/**
	 * Gets the plants removed.
	 *
	 * @return the plants removed
	 */
	public int getPlantsRemoved() {
		return plantsRemoved;
	}

	/**
	 * Sets the plants removed.
	 *
	 * @param plantsRemoved the new plants removed
	 */
	public void setPlantsRemoved(int plantsRemoved) {
		this.plantsRemoved = plantsRemoved;
}
		
	

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	
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
		//	System.out.println("Game: "+mx+" , "+my);
			control.click(mx,my);
		}
		else if(State == STATE.END)
		{
			if(mx>screenWidth/2-175 && mx<screenWidth/2+170 && my>772 && my<865) {
			//	System.out.println(screenWidth/2);
			//	System.out.println("End: "+mx+","+my);
				View.State=STATE.TEST;	
			}
		}
		else if(State == STATE.TEST) {
			System.out.println("test: "+mx+" , "+my);
			System.out.println(screenWidth/2);
			//Question 1
			if(mx>screenWidth/2-136 && mx<screenWidth/2-50 && my>262 && my<407) {
				endSurvey.q1Correct= true;
				//System.out.println("works");
			}
			//Question 2
			if(mx>screenWidth/2+22 && mx<screenWidth/2+89 && my>504 && my<626) {
				endSurvey.q2Correct= true;
			}
			//Question 3
			if(mx>screenWidth/2-273 && mx<screenWidth/2-193 && my>667 && my<723) {
				endSurvey.q3Correct= true;
			}
			
		}
			System.out.println("Mouse clicked");
	
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx = e.getX();	//x value of mouse
		int my = e.getY();	//y value of mouse

		
		if(State == STATE.MENU) {
			if(mx >= screenWidth/5+10 && mx <= screenWidth/5+200 )
	
			{	//Play button
				if(my >= screenHeight/3+28 && my <= screenHeight/3+103)
				{
					System.out.print(mx + " " +  my);
					//Pressed play button
					level = 0;
					View.State = View.STATE.GAME;
				}
	
				if(my >= (screenHeight/4*2)+28 && my <= ((screenHeight/4*2)+103))
				{
					//Pressed other button
					System.exit(1);
				}
			}

		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		control.key(e);
	 
		System.out.println("Key pressed");
	
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key pressed");
		control.key(e);
	}

	
/**
 * Prints the stuff.
 */
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
