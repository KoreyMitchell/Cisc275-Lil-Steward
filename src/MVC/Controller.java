package MVC;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener, KeyListener {

	Model model;
	View view;

	public static void main(String[] args) {
		// makes an instance of Controller
		Controller c = new Controller();

		c.view.initialize();

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

	// this stuff can go in View
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Call method in model
		int clickx = arg0.getX();
		int clicky = arg0.getY();
		if (model.tool.isShovel()) {
			model.addNativePlant(clickx, clicky);
		} else
			model.removeInvasivePlant(clickx, clicky);
		syncViewToModel(model);
		view.repaint();

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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		model.player.updatePlayerLocation(e);
	}

}
