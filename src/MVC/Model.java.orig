package MVC;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {
	PlayerCharacter player;
	ArrayList<NativePlant> nativePlants;
	ArrayList<InvasivePlant> invasivePlants;
	ArrayList<GroundPatch> groundList;
	ArrayList<Obstacle> obstacleList;
	Tool tool;
<<<<<<< HEAD
	
	int plantsPlanted;
	int plantsRemoved;
=======
	int plantsPlanted;
	int plantsRemoved;
	int level;
>>>>>>> levelup

	

	Model() {
		// initialize local variables
		player = new PlayerCharacter();
		nativePlants = new ArrayList<NativePlant>();
		invasivePlants = new ArrayList<InvasivePlant>();
		groundList = new ArrayList<GroundPatch>();
		obstacleList = new ArrayList<Obstacle>();
		tool = new Tool(false);
		plantsPlanted = 0;
		plantsRemoved = 0;
<<<<<<< HEAD
=======
		level = 1;
>>>>>>> levelup

		// board conditions at start
		GroundPatch grp1 = new GroundPatch(10, 12);
		GroundPatch grp2 = new GroundPatch(2000, 520);
		groundList.add(grp1);
		groundList.add(grp2);

		Obstacle ob1 = new Obstacle(90, 90);
		obstacleList.add(ob1);

		InvasivePlant inv1 = new InvasivePlant(10, 10);
		InvasivePlant inv2 = new InvasivePlant(200, 200);
		InvasivePlant inv3 = new InvasivePlant(300, 30);
		InvasivePlant inv4 = new InvasivePlant(20, 100);
		InvasivePlant inv5 = new InvasivePlant(300, 100);
		invasivePlants.add(inv1);
		invasivePlants.add(inv2);
		invasivePlants.add(inv3);
		invasivePlants.add(inv4);
		invasivePlants.add(inv5);
	}

	public void addNativePlant(int x, int y) {
		// only plant if there is an unplanted patch of ground at this x and y
	
		GroundPatch g = new GroundPatch(x, y);
		if (groundList.contains(g)) {
			System.out.println("You can plant here!");
			// add new plant to the list of native plants
			NativePlant n = new NativePlant(x, y);
			nativePlants.add(n);
			// remove the plantable ground, since it is now planted
			groundList.remove(g);
			plantsPlanted++;
		}

	}

	public void removeInvasivePlant(int x, int y) {
		// removes an InvasivePlant with the x and y specified from the list of
		// invasive plants
		InvasivePlant inv = new InvasivePlant(x, y);
		if (invasivePlants.contains(inv)) {
			plantsRemoved++;
<<<<<<< HEAD
		}
=======
		};
>>>>>>> levelup
		invasivePlants.remove(inv);
		
	}

	public void checkLvlUp() {
		System.out.println("Levelup checked");
		if(groundList.isEmpty()&&invasivePlants.isEmpty()) {
			if(level<3) {
				level++;
				System.out.println(level);
			}
			else {
				//game is over
			}
		}
	}


	public void checkAndMove(KeyEvent e) {
		// TODO Make character move diagonally 
		Obstacle o;
		
		int s = e.getKeyCode();
		if(s==KeyEvent.VK_LEFT) {
		o = new Obstacle((player.getXloc()-1),player.getYloc());	
			if(s==KeyEvent.VK_LEFT&&s==KeyEvent.VK_UP) {
				
			}
			if(s==KeyEvent.VK_LEFT&&s==KeyEvent.VK_DOWN) {
				
			}
		}
		else if(s==KeyEvent.VK_RIGHT) {
			o = new Obstacle((player.getXloc()+1),player.getYloc());
			if(s==KeyEvent.VK_RIGHT&&s==KeyEvent.VK_UP) {
				
				}
			if(s==KeyEvent.VK_LEFT&&s==KeyEvent.VK_DOWN) {
			
			}
		}
		else if(s==KeyEvent.VK_UP) {
			o = new Obstacle(player.getXloc(),player.getYloc()-1);
			if(s==KeyEvent.VK_UP&&s==KeyEvent.VK_LEFT) {
				
			}
			if(s==KeyEvent.VK_UP&&s==KeyEvent.VK_RIGHT) {
		
			}
		}
		else {
			o = new Obstacle((player.getXloc()-1),player.getYloc()+1);
			if(s==KeyEvent.VK_DOWN&&s==KeyEvent.VK_LEFT) {
				
			}
			if(s==KeyEvent.VK_DOWN&&s==KeyEvent.VK_RIGHT) {
		
			}
		}
	
		
		if(obstacleList.contains(o)) {
			System.out.println("You hit an obstacle");
			
		}
		else {player.updatePlayerLocation(e);}
		
	}
	
	
//**----------------------------For testing-----------------------------------**//
//**--------------------------------------------------------------------------**//
	public boolean checkMove(String s) {
		// checks to see if player's move is valid
		Obstacle o;
		if (s.equals("up")) {
			o = new Obstacle((player.getXloc() - 1), player.getYloc());
		} else if (s.equals("down")) {
			o = new Obstacle((player.getXloc() + 1), player.getYloc());
		} else if (s.equals("left")) {
			o = new Obstacle(player.getXloc(), player.getYloc() - 1);
		} else {
			o = new Obstacle((player.getXloc() - 1), player.getYloc() + 1);
		}

		// if the list of obstacles contains an obstacle with the x and y given, the
		// player cannot move there
		if (obstacleList.contains(o)) {
			System.out.println("You hit an obstacle");
			return false;
		}
		// if not, the player can move
		return true;

	}
	

	public static void main(String[] args) {
		Model m = new Model();
		// Use a loop and a scanner class that takes input of arrow keys to make test
		// game
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 1000; i++) {
			// Print player location
			System.out.println("Your location is: " + m.player.getXloc() + ", " + m.player.getYloc());

			// Print plantable ground
			System.out.println("Plantable ground:");
			for (GroundPatch gr : m.groundList) {
				System.out.println("Plantable ground at " + gr.getXloc() + " and " + gr.getYloc());

			}

			// Print native plants
			System.out.println("Native plants:");
			for (NativePlant nat : m.nativePlants) {
				System.out.println("Goldenrod" + " at " + nat.getXloc() + " and " + nat.getYloc());
			}

			// Print invasive plants
			System.out.println("Invasive plants:");
			for (InvasivePlant nat : m.invasivePlants) {
				System.out.println("Phragmites" + " at " + nat.getXloc() + " and " + nat.getYloc());
			}

			// Print obstacles
			System.out.println("Obstacles:");
			for (Obstacle ob : m.obstacleList) {
				System.out.println("Obstacle" + " at " + ob.getXloc() + " and " + ob.getYloc());
			}
			
			//Print plants planted and removed
			System.out.println("Planted " + m.plantsPlanted + " goldenrod plants and removed " + m.plantsRemoved +" phragmites");

			// Choose an action to take
			System.out.println("Choose: up, down, left, right, plant, remove");

			String input = sc.nextLine();
			if (input.equals("up") || input.equals("down") || input.equals("left") || input.equals("right")) {
				// move character
				if (m.checkMove(input)) {
					m.player.updatePlayerLocation(input);
				}

			} else if (input.equals("plant")) {

				m.addNativePlant(m.player.getXloc(), m.player.getYloc());

			} else if (input.equals("remove")) {
				m.removeInvasivePlant(m.player.getXloc(), m.player.getYloc());
			}
		}
		

	}

}
