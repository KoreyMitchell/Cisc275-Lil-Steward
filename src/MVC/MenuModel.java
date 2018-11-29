package MVC;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuModel extends MenuView implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();	//x value of mouse
		int my = e.getY();	//y value of mouse
		System.out.println(mx);
		System.out.println(my);
		if(mx >= screenWidth/2-35 && mx <= screenWidth/2 +65 )
		{	//first button
			if(my >= 150 && my <= 200)
			{
				//Pressed play button
				View.State = View.STATE.GAME;
			}
			//second button
			if(my >= 250 && my <= 300)
			{
				//Pressed quit button
				System.exit(1);
			}
			//third button
			if(my >= 350 && my <= 400)
			{
				//Pressed other button
				System.exit(1);
			}
		}

	}
	/**
	 * 	public Rectangle playButton = new Rectangle(screenWidth/2-35,150,100,50);
	public Rectangle quitButton = new Rectangle(screenWidth/2-35,250,100,50);
	public Rectangle anotherButton = new Rectangle(screenWidth/2-35,350,100,50);
	 */

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
