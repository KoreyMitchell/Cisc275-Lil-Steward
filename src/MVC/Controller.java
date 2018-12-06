package MVC;

import java.awt.event.KeyEvent;

import MVC.View.STATE;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 * Connects the Model and View
 */
public class Controller {

	/** The model. 
	 * The functionality of the program
	 * */
	Model model;
	
	/** The view. 
	 * 	The visuals of the program
	 * */
	View view;

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
		MakeSong m = new MakeSong();
		m.playSound("images/BackGroundMusic.wav");
		
		
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
	 * @param x the x
	 * @param y the y
	 */
	public void click(int x, int y) {
		//System.out.println("Controller read click from view");
		//TODO: call click methods from model 
		
		if(model.win == true) {
			View.State = STATE.END;
			
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



		if(s==KeyEvent.VK_ESCAPE) {
			view.State = STATE.MENU;
			model.escapeReset();
			model.level = model.level-1;
			view.level = view.level-1;
		}
		

		model.checkAndMove(e);
		//System.out.println(model.player.getXloc());
		syncViewToModel(model);
		view.repaint();
		//
	}


}
