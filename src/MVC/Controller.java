package MVC;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
			}
		});

	}

	Controller() {
		model = new Model();
		view = new View();

	}

	public void syncViewToModel(Model m) {
		// sets all variables in view to match their equivalents in the model
		view.setPlayer(m.player);
		view.setInvasivePlants(m.invasivePlants);
		view.setNativePlants(m.nativePlants);
		view.setPatches(m.groundList);
		view.setObstacles(m.obstacleList);
		view.setTool(m.tool);

	}
	
	public void click(int x, int y) {
		System.out.println("Controller read click from view");
		//TODO: call click methods from model 
		model.addNativePlant(x, y);
		model.removeInvasivePlant(x, y);
		//model.player.setXloc(x);
		//model.player.setYloc(y);
		//System.out.println(model.player.getXloc());
		syncViewToModel(model);
		view.repaint();
	}
	
	public void key(KeyEvent e) {
		System.out.println("Controller read key from view");
	
		model.checkAndMove(e);
		System.out.println(model.player.getXloc());
		syncViewToModel(model);
		view.repaint();
	}

	// this stuff can go in View
	
	public void mouseClicked(MouseEvent arg0) {
		// Call method in model
		int clickx = arg0.getX();
		int clicky = arg0.getY();
		if (model.tool.isShovel()) {
			model.addNativePlant(clickx, clicky);
		} else {
			model.removeInvasivePlant(clickx, clicky);
		}
		System.out.println(model.tool.isShovel());
		syncViewToModel(model);
		view.repaint();

	}

}
