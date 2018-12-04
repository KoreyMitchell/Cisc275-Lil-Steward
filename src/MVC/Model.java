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
	int plantsPlanted;
	int plantsRemoved;
	boolean win = false;
	int level;
	int screenHeight;
	int screenWidth;
	//Random random = new Random();

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
		level = 0;

		// levelPreset(level);
	}
	
	public void setLevel(int lev) {
		level = lev;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public void addNativePlant(int x, int y) {
		// only plant if there is an unplanted patch of ground at this x and y

		GroundPatch g = new GroundPatch(player.getXloc(), player.getYloc());
		if (groundList.contains(g)&&g.equals(player)) {
			System.out.println("You can plant here!");
			// add new plant to the list of native plants
			
			NativePlant n = new NativePlant(player.getXloc(), player.getYloc());
			nativePlants.add(n);
			// remove the plantable ground, since it is now planted
			groundList.remove(g);
			plantsPlanted++;
		}
	}

	public void removeInvasivePlant(int x, int y) {
		// removes an InvasivePlant with the x and y specified from the list of
		// invasive plants
		InvasivePlant inv = new InvasivePlant(player.getXloc(), player.getYloc());
		if (invasivePlants.contains(inv)&&inv.equals(player)) {
			plantsRemoved++;
			invasivePlants.remove(inv);
		}

	}

	public void checkLvlUp() {
		System.out.println("Levelup checked: Level is: "+level);
		if (groundList.isEmpty() && invasivePlants.isEmpty()) {
			if (level < 3) {
				System.out.println(invasivePlants.isEmpty());
				levelPreset(level);
				System.out.println(invasivePlants.isEmpty());
				level++;
				//break;
			} else {
				win = true;
			}
		}
	}
	public void escapeReset() {
		nativePlants.clear();
		invasivePlants.clear();
		groundList.clear();
		obstacleList.clear();
		player.setXloc(10);
		player.setYloc(10);
	}

	public void levelPreset(int lvl) {
		switch (lvl) {
		case 0: {
			// TODO: tutorial mode
			nativePlants.clear();
			invasivePlants.clear();
			groundList.clear();
			obstacleList.clear();
			System.out.println("Tutorial mode selected");
			Obstacle ob1 = new Obstacle(90, 90);
			obstacleList.add(ob1);
			InvasivePlant inv1 = new InvasivePlant(300, 100);
			InvasivePlant inv2 = new InvasivePlant(400, 100);
			invasivePlants.add(inv1);
			invasivePlants.add(inv2);
			break;
		}

		case 1: {
			nativePlants.clear();
			invasivePlants.clear();
			groundList.clear();
			obstacleList.clear();
			// TODO: level one
			System.out.println("Level one selected");
			// board conditions at start
			for(int i = 0; i<3;i++) {
			GroundPatch grp1 = new GroundPatch(20, 120*i);
			
			groundList.add(grp1);
			}

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
			break;
		}
		case 2: {
			// TODO: level two
			System.out.println("Level two selected" + screenHeight);

			for (int i = 0; i < 15; i++) {
				GroundPatch grp1 = new GroundPatch(20 * i, 30 * i);
				groundList.add(grp1);
				if (90 * i < screenWidth - 300) {
					Obstacle ob1 = new Obstacle(90 * i, 90);
					obstacleList.add(ob1);
					Obstacle ob3 = new Obstacle(90 * i + 300, 300);
					obstacleList.add(ob3);
					Obstacle ob5 = new Obstacle(90 * i, screenHeight - 300);

					obstacleList.add(ob5);
				}

				// Obstacle ob2 = new Obstacle (300, 20*i+300);
				// Obstacle ob4 = new Obstacle (1000, 30*i+600);

				for (int j = 0; j < 10; j++) {
					Obstacle ob = new Obstacle(250 + 500 * j, screenHeight - (20 * i) - 300);
					Obstacle ob2 = new Obstacle(500 * j, 20 * i + 300);
					obstacleList.add(ob);
					obstacleList.add(ob2);
				}

				// .add(ob4);
				
				
				InvasivePlant inv1 = new InvasivePlant(25 * i, 13 * i);
				invasivePlants.add(inv1);
			}
			break;
		}
		case 3: {
			// TODO: level three
			System.out.println("Level three selected");
			levelPreset(2);
			
			break;
		}

		}
	}
	
	//Checks for obstacles 
	public void checkAndMove(KeyEvent e) {
		// TODO Make character move diagonally
		Obstacle o;
		boolean outBound=false;

		int s = e.getKeyCode();
		if (s == KeyEvent.VK_LEFT) {
			o = new Obstacle((player.getXloc() - 10), player.getYloc());
			if(player.getXloc()-10<0) {
				outBound=true;
			}
//			if (s == KeyEvent.VK_LEFT && s == KeyEvent.VK_UP) {
//			
//
//			}
//			if (s == KeyEvent.VK_LEFT && s == KeyEvent.VK_DOWN) {
//
//			}
		} else if (s == KeyEvent.VK_RIGHT) {
			o = new Obstacle((player.getXloc() + 10), player.getYloc());
			if(player.getXloc()+10 > screenWidth-70) {
				outBound=true;
			}
//			if (s == KeyEvent.VK_RIGHT && s == KeyEvent.VK_UP) {
//
//			}
//			if (s == KeyEvent.VK_LEFT && s == KeyEvent.VK_DOWN) {
//
//			}
		} else if (s == KeyEvent.VK_UP) {
			o = new Obstacle(player.getXloc(), player.getYloc() - 10);
			if(player.getYloc()-10<0) {
				outBound=true;
			}
//			if (s == KeyEvent.VK_UP && s == KeyEvent.VK_LEFT) {
//
//			}
//			if (s == KeyEvent.VK_UP && s == KeyEvent.VK_RIGHT) {
//
//			}
		} else {
			o = new Obstacle(player.getXloc(), player.getYloc() + 10);
			if(player.getYloc()+10>screenHeight-115) {
				outBound=true;
			}
//			if (s == KeyEvent.VK_DOWN && s == KeyEvent.VK_LEFT) {
//
//			}
//			if (s == KeyEvent.VK_DOWN && s == KeyEvent.VK_RIGHT) {
//
//			}
		}

		if (obstacleList.contains(o)||outBound) {
			System.out.println("You can't move there");

		} 
		
		
		else {
			player.updatePlayerLocation(e);
		}

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

			// Print plants planted and removed
			System.out.println(
					"Planted " + m.plantsPlanted + " goldenrod plants and removed " + m.plantsRemoved + " phragmites");

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

		sc.close();
	}

}
