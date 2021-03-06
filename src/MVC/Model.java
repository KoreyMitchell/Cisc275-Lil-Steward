package MVC;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;



// TODO: Auto-generated Javadoc
/**
 * The Class Model.
 */
public class Model implements Runnable {
	
	/** The t. */
	Thread t;
	
	/** The sound count. */
	int soundCount;
	
	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	/** The sfx. */
	HashMap<String, MakeSong> sfx;
	
	/** The player. */
	PlayerCharacter player;
	
	public int getPlantsPlanted() {
		return plantsPlanted;
	}

	public void setPlantsPlanted(int plantsPlanted) {
		this.plantsPlanted = plantsPlanted;
	}

	public int getPlantsRemoved() {
		return plantsRemoved;
	}

	public void setPlantsRemoved(int plantsRemoved) {
		this.plantsRemoved = plantsRemoved;
	}

	/** The native plants. */
	ArrayList<NativePlant> nativePlants;
	
	/** The invasive plants. */
	ArrayList<InvasivePlant> invasivePlants;
	
	/** The ground list. */
	private ArrayList<GroundPatch> groundList;
	
	/** The obstacle list. */
	ArrayList<Obstacle> obstacleList;
	
	/** The tutorial notes. */
	ArrayList<GameObject> tutorialNotes;
	
	/** The t 1. */
	Thread t1;
	/** The tool. */
	Tool tool;
	
	/** The plants planted. */
	int plantsPlanted;
	
	/** The plants removed. */
	int plantsRemoved;
	
	/** The win. */
	boolean win = false;
	
	/** The level. */
	public int level;
	
	/** The screen height. */
	int screenHeight;
	
	/** The screen width. */
	int screenWidth;
	
	/** The random 1. */
	Random random1;
	
	/** The random 2. */
	Random random2;
	
	/** The randomx. */
	int randomx;
	
	/** The randomy. */
	int randomy;
	
	/** The seconds passed. */
	int secondsPassed;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		// initialize local variables
		player = new PlayerCharacter();
		nativePlants = new ArrayList<NativePlant>();
		invasivePlants = new ArrayList<InvasivePlant>();
		setGroundList(new ArrayList<GroundPatch>());
		obstacleList = new ArrayList<Obstacle>();
		tutorialNotes = new ArrayList<GameObject>();
		tool = new Tool(false);
		plantsPlanted = 0;
		plantsRemoved = 0;
		
		level = 0;
		sfx = new HashMap<String, MakeSong>();
		sfx.put("levelUp", new MakeSong("images/levelUp.wav"));
		sfx.put("rewardSound", new MakeSong("images/rewardSound.wav"));
		soundCount = 0;
		secondsPassed = 60;
		

		
		// levelPreset(level);
	}
	
	/**
	 * Gets the seconds.
	 *
	 * @return the seconds
	 */
	public int getSeconds() {
		return secondsPassed;
	}
	
	/**
	 * Sets the level.
	 *
	 * @param lev the new level
	 */
	public void setLevel(int lev) {
		level = lev;
	}

	/**
	 * Gets the screen height.
	 *
	 * @return the screen height
	 */
	public int getScreenHeight() {
		return screenHeight;
	}

	/**
	 * Sets the screen height.
	 *
	 * @param screenHeight the new screen height
	 */
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	/**
	 * Gets the screen width.
	 *
	 * @return the screen width
	 */
	public int getScreenWidth() {
		return screenWidth;
	}

	/**
	 * Sets the screen width.
	 *
	 * @param screenWidth the new screen width
	 */
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}


	/**
	 * Adds the native plant.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void addNativePlant(int x, int y) {
		// only plant if there is an unplanted patch of ground at this x and y

		GroundPatch g = new GroundPatch(player.getXloc(), player.getYloc());
		if (getGroundList().contains(g)&&g.equals(player)) {
			System.out.println("You can plant here!");
			// add new plant to the list of native plants
			
			NativePlant n = new NativePlant(player.getXloc(), player.getYloc());
			nativePlants.add(n);
			// remove the plantable ground, since it is now planted
			getGroundList().remove(g);
			plantsPlanted++;
			t1 = new Thread(new Model());
			t1.start();
		}
	}

	/**
	 * Removes the invasive plant.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void removeInvasivePlant(int x, int y) {
		// removes an InvasivePlant with the x and y specified from the list of
		// invasive plants
		InvasivePlant inv = new InvasivePlant(player.getXloc(), player.getYloc());
		if (invasivePlants.contains(inv)&&inv.equals(player)) {
			plantsRemoved++;
			invasivePlants.remove(inv);
			t1 = new Thread(new Model());
			t1.start();
		}

	}

	

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if(soundCount == 0) {
		sfx.get("rewardSound").playSound();
		}
		else if(soundCount == 1) {
			sfx.get("levelUp").playSound();
		}
	}
	




	/**
	 * Check lvl up.
	 */
	public void checkLvlUp() {
		System.out.println("Levelup checked: Level is: "+level);
		if (getGroundList().isEmpty() && invasivePlants.isEmpty()) {
			if (level < 4) {
				System.out.println(invasivePlants.isEmpty());
				levelPreset(level);
				System.out.println(invasivePlants.isEmpty());
				level++;
				t1 = new Thread(new LevelUpSound(sfx,level));
				t1.start();
				//break;
			} else {
				win = true;
			}
		}
	}
	
	/**
	 * Escape reset.
	 */
	public void escapeReset() {
		nativePlants.clear();
		invasivePlants.clear();
		getGroundList().clear();
		obstacleList.clear();
		player.setXloc(10);
		player.setYloc(10);
	}

	/**
	 * Level preset.
	 *
	 * @param lvl the lvl
	 */
	@SuppressWarnings("unlikely-arg-type")
	public void levelPreset(int lvl) {
		switch (lvl) {
		case 0: {
			// TODO: tutorial mode
			nativePlants.clear();
			invasivePlants.clear();
			getGroundList().clear();
			obstacleList.clear();
			player.setXloc(0);
			player.setYloc(0);
			System.out.println("Tutorial mode selected");
			for(int i = 0; i < 40; i++) {
				if(i != 18 && i != 19 && i != 20 && i != 21) {
				Obstacle i1 = new Obstacle(getScreenWidth() - (i*50), getScreenHeight()/2);
				obstacleList.add(i1);
				}
			}
			
			TutorialNotePhragmites tut1 = new TutorialNotePhragmites(screenWidth-500, 10);
			tutorialNotes.add(tut1);
			TutorialNoteAster tut2 = new TutorialNoteAster(screenWidth-500, screenHeight-310);
			tutorialNotes.add(tut2);
			TutorialNoteInkberry tut3 = new TutorialNoteInkberry(10, (screenHeight/2)-200);
			tutorialNotes.add(tut3);
			TutorialNoteDirection tut4 = new TutorialNoteDirection(10, screenHeight-210);
			tutorialNotes.add(tut4);
			InvasivePlant inv2 = new InvasivePlant(700, 75);
			invasivePlants.add(inv2);
			GroundPatch grp1 = new GroundPatch(700, getScreenHeight()-150);
			getGroundList().add(grp1);
			break;
		}

		case 1: {
			nativePlants.clear();
			invasivePlants.clear();
			getGroundList().clear();
			obstacleList.clear();
			tutorialNotes.clear();
			player.setXloc(0);
			player.setYloc(0);
			// TODO: level one
			System.out.println("Level one selected");
			// board conditions at start

			for (int i = 0; i < 15; i++) {//set to 15
				random1 = new Random();
				randomx = random1.nextInt(screenWidth-100);
				random2 = new Random();
				randomy = random2.nextInt(screenHeight-100);
				
				if (90 * i < screenWidth - 300) {
					Obstacle ob1 = new Obstacle(90 * i, 90);
					obstacleList.add(ob1);
					Obstacle ob3 = new Obstacle(90 * i + 550, 480);
					obstacleList.add(ob3);
					Obstacle ob5 = new Obstacle(90 * i, screenHeight - 300);

					obstacleList.add(ob5);
				}
			}
			for (int i = 0; i < 5; i++) {//set to 7
				random1 = new Random();
				randomx = random1.nextInt(screenWidth-100);
				random2 = new Random();
				randomy = random2.nextInt(screenHeight-100);
				
				GroundPatch grp1 = new GroundPatch(randomx, randomy);
				if(!obstacleList.contains(grp1)) {
					getGroundList().add(grp1);
				}
				
				InvasivePlant inv1 = new InvasivePlant((randomx*3)%(screenWidth-100), (randomy*4)%(screenHeight-100));
				invasivePlants.add(inv1);
				if(!obstacleList.contains(inv1)) {
					invasivePlants.add(inv1);
				}
			}
			break;
		}
		case 2: {
			// TODO: level two
			System.out.println("Level two selected" + screenHeight);
			player.setXloc(0);
			player.setYloc(0);
			
			for (int i = 0; i < 7; i++) {//set to 15
				random1 = new Random();
				randomx = random1.nextInt(screenWidth-100);
				random2 = new Random();
				randomy = random2.nextInt(screenHeight-100);
				
				if (90 * i < screenWidth - 300) {
					Obstacle ob1 = new Obstacle(90 * i, 90);
					obstacleList.add(ob1);
					Obstacle ob3 = new Obstacle(90 * i + 300, 300);
					obstacleList.add(ob3);
					Obstacle ob5 = new Obstacle(90 * i, screenHeight - 300);

					obstacleList.add(ob5);
				}


				for (int j = 0; j < 9; j++) {
					Obstacle ob = new Obstacle(250 + 500 * j, screenHeight - (20 * i) - 300);
					Obstacle ob2 = new Obstacle(500 * j, 20 * i + 300);
					obstacleList.add(ob);
					obstacleList.add(ob2);
				}

				
				GroundPatch grp1 = new GroundPatch(randomx, randomy);
				if(!obstacleList.contains(grp1)) {
					getGroundList().add(grp1);
				}
				
				InvasivePlant inv1 = new InvasivePlant((randomx*3)%(screenWidth-100), (randomy*4)%(screenHeight-100));
				invasivePlants.add(inv1);
				if(!obstacleList.contains(inv1)) {
					invasivePlants.add(inv1);
				}
			}
			break;
		}
		case 3: {
			// TODO: level three
			System.out.println("Level three selected");
			player.setXloc(0);
			player.setYloc(0);
			
			levelPreset(2);
			for (int i = 0; i < 10; i++) {//set to 25
				random1 = new Random();
				randomx = random1.nextInt(screenWidth-100);
				random2 = new Random();
				randomy = random2.nextInt(screenHeight-100);
				Obstacle ob = new Obstacle((randomx*2)%(screenWidth-300), (randomy*5)%(screenHeight-500));
				obstacleList.add(ob);
				GroundPatch grp1 = new GroundPatch(randomx, randomy);
				if(!obstacleList.contains(grp1)) {
					getGroundList().add(grp1);
				}
				InvasivePlant inv2 = new InvasivePlant((randomx*3)%(screenWidth-100), (randomy*4)%(screenHeight-100));
				
				if(!obstacleList.contains(inv2)) {
					invasivePlants.add(inv2);
				}
			}
			
			break;
		}

		}
	}

	
	/**
	 * Check and move.
	 *
	 * @param e the e
	 */
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

		} else if (s == KeyEvent.VK_RIGHT) {
			o = new Obstacle((player.getXloc() + 10), player.getYloc());
			if(player.getXloc()+10 > screenWidth-70) {
				outBound=true;
			}

		} else if (s == KeyEvent.VK_UP) {
			o = new Obstacle(player.getXloc(), player.getYloc() - 10);
			if(player.getYloc()-10<0) {
				outBound=true;
			}

		} else {
			o = new Obstacle(player.getXloc(), player.getYloc() + 10);
			if(player.getYloc()+10>screenHeight-115) {
				outBound=true;
			}

		}

		if (obstacleList.contains(o)||outBound) {
			System.out.println("You can't move there");

		} 
		
		
		else {
			player.updatePlayerLocation(e);
		}

	}


//**----------------------------For testing-----------------------------------**//
/**
 * Check move.
 *
 * @param s the s
 * @return true, if successful
 */
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

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
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
			for (GroundPatch gr : m.getGroundList()) {
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

	public ArrayList<GroundPatch> getGroundList() {
		return groundList;
	}

	public void setGroundList(ArrayList<GroundPatch> groundList) {
		this.groundList = groundList;
	}

	public PlayerCharacter getPlayer() {
		return player;
	}

	public void setPlayer(PlayerCharacter player) {
		this.player = player;
	}

	public ArrayList<NativePlant> getNativePlants() {
		return nativePlants;
	}

	public void setNativePlants(ArrayList<NativePlant> nativePlants) {
		this.nativePlants = nativePlants;
	}

	public ArrayList<InvasivePlant> getInvasivePlants() {
		return invasivePlants;
	}

	public void setInvasivePlants(ArrayList<InvasivePlant> invasivePlants) {
		this.invasivePlants = invasivePlants;
	}

	public ArrayList<Obstacle> getObstacleList() {
		return obstacleList;
	}

	public void setObstacleList(ArrayList<Obstacle> obstacleList) {
		this.obstacleList = obstacleList;
	}

	public int getLevel() {
		return level;
	}

	



}
