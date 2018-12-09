package MVC;

import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.TimerTask;

import MVC.View.STATE;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 * Connects the Model and View
 */
public class Controller {

	/** The model. 
	 * The logic  of the program
	 * */
	Model model;
	  
  	/** The i. */
  	private int i = 60;
	/** The view. 
	 * 	The visuals of the program
	 * */
	View view;
	
	/** The lus. */
	LevelUpSound lus;
	
	/** The lvl 1 count. */
	int lvl1count = 2;

	/** The count. */
	private int count;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// makes an instance of Controller
		Controller c = new Controller();
		
		
		c.view.initialize();
		c.view.setControl(c);
		MakeSong m = new MakeSong("images/BackGroundMusic.wav");
		m.playSound();
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				c.syncViewToModel(c.model);
				c.view.repaint();
				c.view.printStuff();
				//c.model.checkLvlUp();
			}
		});

	}

	/**
	 * Instantiates a new controller.
	 */
	Controller() {
		model = new Model();
		view = new View();
		model.setScreenWidth(view.screenWidth);
		model.setScreenHeight(view.screenHeight);

		// model.levelPreset(model.level);
	}

	/**
	 * Sync view to model.
	 *
	 * @param m the m
	 */
	public void syncViewToModel(Model m) {
		// sets all variables in view to match their equivalents in the model
		view.setPlayer(m.player);
		view.setInvasivePlants(m.invasivePlants);
		view.setNativePlants(m.nativePlants);
		view.setPatches(m.groundList);
		view.setObstacles(m.obstacleList);
		view.setTool(m.tool);
		view.setTutorialNotes(m.tutorialNotes);
		view.setPlantedCount(m.plantsPlanted);
		view.setPlantsRemoved(m.plantsRemoved);
		
	}
	
	/**
	 * Sync model to view.
	 *
	 * @param v the v
	 */
	public void syncModelToView(View v) {
		model.setLevel(v.level);
	}
	
 
	
	/**
	 * Click.
	 *
	 */
	
	boolean t1 = true;
	
	/**
	 * Click.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void click(int x, int y) {
		//System.out.println("Controller read click from view");
		//TODO: call click methods from model fs

		if(model.level >= 2 && t1) {
			setTimer(model.level);
			t1 = false;
		}
		
		if(model.win == true && count == 0) {
			View.State = STATE.END;
			count = 1;
			
		}else if(model.win == true && count ==1) {
			View.State = STATE.TEST;
		}
		model.addNativePlant(x, y);
		model.removeInvasivePlant(x, y);
		//model.player.setXloc(x);
		//model.player.setYloc(y);
		//System.out.println(model.player.getXloc());
		syncViewToModel(model);
		view.repaint();
		model.checkLvlUp();
	

	
	}
	
	/** The finalstage. */
	boolean finalstage = true;
	
	/** The lvl 2. */
	boolean lvl2 = true;
	
	/**
	 * Sets the timer.
	 *
	 * @param levels the new timer
	 */
	public void setTimer(int levels) {
		int lev = levels;
	
	final Timer timer = new Timer();
	// Note that timer has been declared final, to allow use in anon. class below
	timer.schedule( new TimerTask()
	{
	  
	    int levelcount = 1;

	    public void run()
	    { 
	        System.out.println(i);
	        model.secondsPassed--;
	    
	        view.setSeconds(model.secondsPassed);
	        view.repaint();
	        
	   
	        if (--i < 1 ) {
	        	model.groundList.clear();
	        	model.invasivePlants.clear();
	        	model.checkLvlUp();
	        	syncViewToModel(model);
	        	model.secondsPassed = 60;
	        	i = 60;
	        	view.repaint();
	        }
	        if(model.level==3 && lvl2) {
	        	lvl2 = false;
	        	i=60;
	        	model.secondsPassed = 60;
	        	model.checkLvlUp();
	        	syncViewToModel(model);
	        	view.repaint();
	        }
	        if(model.level > 4 && finalstage) {
	        	finalstage = false;
	        	view.State = STATE.END;
	        	view.repaint();
	        }
	        
	    }
	}, 1000, 1000 //Note the second argument for repetition
	);}

	
	
	
//	
//	Runnable runnable = new Runnable() {
//		  @Override public void run() {
//		    model.secondsPassed++;
//		    view.setSeconds(model.secondsPassed);
//		    view.repaint();
//		    
//		    
//		  }
//		 
//		};
//	
//	void startTimer(int delaySeconds) {
//		  Executors.newSingleThreadScheduledExecutor().schedule(
//		    runnable,
//		    delaySeconds,
//		    TimeUnit.SECONDS);
//		
//
//	
//	
//
//	}
//	
	/**
	 * Key.
	 *
	 * @param e the e
	 */
	public void key(KeyEvent e) {
		//System.out.println("Controller read key from view");
		int s = e.getKeyCode();
		if(s==KeyEvent.VK_UP) {
			view.playerimg = view.playerimgBack; 
		}
		if(s==KeyEvent.VK_DOWN) {
			view.playerimg = view.playerimgFront; 
		}
		if(s==KeyEvent.VK_RIGHT) {
			view.playerimg = view.playerimgRight; 
		}
		if(s==KeyEvent.VK_LEFT) {
			view.playerimg = view.playerimgLeft; 
		}

		int startlevel =0;
		

		if(s==KeyEvent.VK_ESCAPE) {
			view.State = STATE.MENU;
			model.escapeReset();
			model.level = model.level-1;
			view.level = view.level-1;
		}
		if(s==KeyEvent.VK_Q) {
			view.State = STATE.MENU;
		
		}
		

		model.checkAndMove(e);
		//System.out.println(model.player.getXloc());
		syncViewToModel(model);
		view.repaint();
		//
	}


}
