package MVC;

import java.awt.event.KeyEvent;

import MVC.View.STATE;

public class Controller {

	Model model;
	View view;

	public static void main(String[] args) {
		// makes an instance of Controller
		Controller c = new Controller();
		
		c.view.initialize();
		c.view.setControl(c);
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				c.syncViewToModel(c.model);
				c.view.repaint();
				c.view.printStuff();
				//c.model.checkLvlUp();
			}
		});

	}

	Controller() {
		model = new Model();
		view = new View();
		model.setScreenWidth(view.screenWidth);
		model.setScreenHeight(view.screenHeight);

		// model.levelPreset(model.level);
	}

	public void syncViewToModel(Model m) {
		// sets all variables in view to match their equivalents in the model
		view.setPlayer(m.player);
		view.setInvasivePlants(m.invasivePlants);
		view.setNativePlants(m.nativePlants);
		view.setPatches(m.groundList);
		view.setObstacles(m.obstacleList);
		view.setTool(m.tool);

		view.setPlantedCount(m.plantsPlanted);
		view.setPlantsRemoved(m.plantsRemoved);
		
		
	}
	public void syncModelToView(View v) {
		model.setLevel(v.level);
	}
	

	
	public void click(int x, int y) {
		//System.out.println("Controller read click from view");
		//TODO: call click methods from model 
		

		model.addNativePlant(x, y);
		model.removeInvasivePlant(x, y);
		//model.player.setXloc(x);
		//model.player.setYloc(y);
		//System.out.println(model.player.getXloc());
		syncViewToModel(model);
		view.repaint();
		model.checkLvlUp();
		if(model.win == true) {
			View.State = STATE.END;
		}
	
	}
	
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
	}
	


}
