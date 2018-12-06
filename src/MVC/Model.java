package MVC;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

// TODO: Auto-generated Javadoc
/**
 * The Class Model.
 */
public class Model implements Runnable {
	Thread t;
	
	int soundCount;
	HashMap<String, MakeSong> sfx;
	
	/** The player. */
	PlayerCharacter player;
	
	/** The native plants. */
	ArrayList<NativePlant> nativePlants;
	
	/** The invasive plants. */
	ArrayList<InvasivePlant> invasivePlants;
	
	/** The ground list. */
	ArrayList<GroundPatch> groundList;
	
	/** The obstacle list. */
	ArrayList<Obstacle> obstacleList;
	ArrayList<GameObject> tutorialNotes;
	
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
	int level;
	
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
	
	int secondsPassed;

	/**
	 * Instantiates a new model.
	 */
	Model() {
		// initialize local variables
		player = new PlayerCharacter();
		nativePlants = new ArrayList<NativePlant>();
		invasivePlants = new ArrayList<InvasivePlant>();
		groundList = new ArrayList<GroundPatch>();
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
		if (groundList.contains(g)&&g.equals(player)) {
			System.out.println("You can plant here!");
			// add new plant to the list of native plants
			
			NativePlant n = new NativePlant(player.getXloc(), player.getYloc());
			nativePlants.add(n);
			// remove the plantable ground, since it is now planted
			groundList.remove(g);
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
		if (groundList.isEmpty() && invasivePlants.isEmpty()) {
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
		groundList.clear();
		obstacleList.clear();
		player.setXloc(10);
		player.setYloc(10);
	}

	/**
	 * Level preset.
	 *
	 * @param lvl the lvl
	 */
	public void levelPreset(int lvl) {
		switch (lvl) {
		case 0: {
			// TODO: tutorial mode
			nativePlants.clear();
			invasivePlants.clear();
			groundList.clear();
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
//			InvasivePlant inv1 = new InvasivePlant(600, 100);
			InvasivePlant inv2 = new InvasivePlant(700, 75);
//			invasivePlants.add(inv1);
			invasivePlants.add(inv2);
			GroundPatch grp1 = new GroundPatch(700, getScreenHeight()-150);
			groundList.add(grp1);
			break;
		}

		case 1: {
			nativePlants.clear();
			invasivePlants.clear();
			groundList.clear();
			obstacleList.clear();
			tutorialNotes.clear();
			player.setXloc(0);
			player.setYloc(0);
			// TODO: level one
			System.out.println("Level one selected");
			// board conditions at start
//			for(int i = 0; i<3;i++) {
//			GroundPatch grp1 = new GroundPatch(20, 120*i);
//			
//			groundList.add(grp1);
//			}
//
//			Obstacle ob1 = new Obstacle(90, 90);
//			obstacleList.add(ob1);
//
//			InvasivePlant inv1 = new InvasivePlant(10, 10);
//			InvasivePlant inv2 = new InvasivePlant(200, 200);
//			InvasivePlant inv3 = new InvasivePlant(300, 30);
//			InvasivePlant inv4 = new InvasivePlant(20, 100);
//			InvasivePlant inv5 = new InvasivePlant(300, 100);
//			invasivePlants.add(inv1);
//			invasivePlants.add(inv2);
//			invasivePlants.add(inv3);
//			invasivePlants.add(inv4);
//			invasivePlants.add(inv5);
//			break;
			for (int i = 0; i < 15; i++) {//set to 15
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
			}
			for (int i = 0; i < 5; i++) {//set to 7
				random1 = new Random();
				randomx = random1.nextInt(screenWidth-100);
				random2 = new Random();
				randomy = random2.nextInt(screenHeight-100);


				// Obstacle ob2 = new Obstacle (300, 20*i+300);
				// Obstacle ob4 = new Obstacle (1000, 30*i+600);

//				for (int j = 0; j < 10; j++) {
//					Obstacle ob = new Obstacle(250 + 500 * j, screenHeight - (20 * i) - 300);
//					Obstacle ob2 = new Obstacle(500 * j, 20 * i + 300);
//					obstacleList.add(ob);
//					obstacleList.add(ob2);
//				}

				// .add(ob4);
				
				GroundPatch grp1 = new GroundPatch(randomx, randomy);
				if(!obstacleList.contains(grp1)) {
					groundList.add(grp1);
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

				// Obstacle ob2 = new Obstacle (300, 20*i+300);
				// Obstacle ob4 = new Obstacle (1000, 30*i+600);

				for (int j = 0; j < 9; j++) {
					Obstacle ob = new Obstacle(250 + 500 * j, screenHeight - (20 * i) - 300);
					Obstacle ob2 = new Obstacle(500 * j, 20 * i + 300);
					obstacleList.add(ob);
					obstacleList.add(ob2);
				}

				// .add(ob4);
				
				GroundPatch grp1 = new GroundPatch(randomx, randomy);
				if(!obstacleList.contains(grp1)) {
					groundList.add(grp1);
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
			for (int i = 0; i < 11; i++) {//set to 25
				random1 = new Random();
				randomx = random1.nextInt(screenWidth-100);
				random2 = new Random();
				randomy = random2.nextInt(screenHeight-100);
				Obstacle ob = new Obstacle((randomx*2)%(screenWidth-300), (randomy*5)%(screenHeight-500));
				obstacleList.add(ob);
				GroundPatch grp1 = new GroundPatch(randomx, randomy);
				if(!obstacleList.contains(grp1)) {
					groundList.add(grp1);
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
//	public void setTutorialNotes(ArrayList<Object> n) {
//		tutorialNotes.clear();
//		tutorialNotes.addAll(n);
//	}
	
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
