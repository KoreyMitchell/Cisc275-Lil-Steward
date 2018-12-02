package MVC;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GameMenuv2 extends JFrame{
	   private JButton play;
	   private JButton exit;
	   private JPanel panel;

	GameMenuv2(){
		setLayout(null);
        setResizable(false);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(760, 700);
        panel.setBackground(Color.getHSBColor(1, 1, 1));
        add(panel);
        
        play = new JButton("PLAY");
        play.setSize(100, 50);
        play.setLocation(360, 400);
        panel.add(play);
        
        exit = new JButton("EXIT");
        exit.setSize(play.getSize());
        exit.setLocation(play.getX() + play.getWidth() + 50, play.getY());
        panel.add(exit);
        
        
	}
	
}
