import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Model {
	// Attributes of Model

	Player playerCharacter;
	ArrayList<NativePlant> listOfNativePlants;
	ArrayList<InvasivePlant> listOfInvasivePlants;
	Toolbar toolbar;
	ToDoList todolist;
	ArrayList<Obstacle> obstacleList;
	ArrayList<GroundPatch> groundList;
	double velx = 0, vely = 0;
	int x = 0;

	// Methods
	public static void main(String[] args) {
		// Text-only version of gameplay for demonstration purposes

		Model m = new Model();

		System.out.println("Your location is: " + m.playerCharacter.getXloc() + ", " + m.playerCharacter.getYloc());

	}

	public Model() {
		playerCharacter = new Player(0, 0, 0);
		playerCharacter.setXloc(0);
		playerCharacter.setYloc(0);
	}
	public void move() {
		if (playerCharacter.getXloc()== 1) {
			if (x + playerCharacter.getXloc() <= 1366-50) {
				x += playerCharacter.getXloc();
			}
		}
		else if (x == -1) {
			if (x + playerCharacter.getXloc()>= 0) {
				x = x + playerCharacter.getXloc();
			}
		}
	}

	public void up() {
		vely = -1.5;
		velx = 0;
		updatePlayerLocation("up");
		System.out.print(playerCharacter.getXloc());
		System.out.print(playerCharacter.getYloc());
	}

	public void down() {
		vely = 1.5;
		velx = 0;
		updatePlayerLocation("down");
		System.out.print(playerCharacter.getXloc());
		System.out.print(playerCharacter.getYloc());
	}

	public void left() {
		vely = 0;
		velx = -1.5;
		updatePlayerLocation("left");
		System.out.print(playerCharacter.getXloc());
		System.out.print(playerCharacter.getYloc());
	}

	public void right() {
		vely = 0;
		velx = 1.5;
		updatePlayerLocation("right");
		System.out.print(playerCharacter.getXloc());
		System.out.print(playerCharacter.getYloc());
	}

//	public void keyPressed(KeyEvent e) {
//		int key = e.getKeyCode();
//		if (key == KeyEvent.VK_LEFT) {
//			left();
//		}
//
//		if (key == KeyEvent.VK_RIGHT) {
//			right();
//		}
//
//		if (key == KeyEvent.VK_UP) {
//			up();
//		}
//		if (key == KeyEvent.VK_DOWN) {
//			down();
//		}
//	}
//
//	public void keyReleased(KeyEvent e) {
//		int key = e.getKeyCode();
//
//		if (key == KeyEvent.VK_LEFT)
//			velx = 0;
//
//		if (key == KeyEvent.VK_RIGHT)
//			velx = 0;
//
//		if (key == KeyEvent.VK_UP) {
//			vely = 0;
//		}
//		if (key == KeyEvent.VK_DOWN) {
//			vely = 0;
//		}
//		
//		if (key == KeyEvent.VK_Q) {
//			System.exit(0);
//		}
//	}

	public void updatePlayerLocation(String input) {
		
		int currx = playerCharacter.getXloc();
		int curry = playerCharacter.getYloc();
		if(input.equals("up")&&currx>0) {
			//move character up
			
			playerCharacter.setXloc(currx-10);
			System.out.println("Player moved up");
		}
		else if(input.equals("down")&&currx<200) {
			//move character down
			playerCharacter.setXloc(currx+10);
			System.out.println("Player moved down");
		}
		else if(input.equals("left")&&curry>0) {
			//move character left
			playerCharacter.setYloc(curry-10);
			System.out.println("Player moved left");
		}
		else if(input.equals("right")&&curry<200) {
			//move character right
			playerCharacter.setYloc(curry+10);
			System.out.println("Player moved right");
		}
	}
	public void updatePlayerLocation() {
		// TODO: using arrow keys: up down left right
	}

	public void updatePlayerDirection() {
		// TODO: using arrow keys: up down left right
	}

	public void updatePlayer() {
		// TODO: uses both updatePlayerDirection and Location
	}

	public void addNativePlant(int x, int y) {
		// TODO: only plant if there is an unplanted patch of ground at this x and y
		listOfNativePlants.add(new NativePlant(x, y, "goldenrod"));
	}

	public void removeInvasivePlant(int x, int y) {
		// TODO: removes an InvasivePlant with the x and y specified from the list of
		// invasive plants
	}

	public void switchTool() {
		// switches the Toolbar between modes
		toolbar.toolSwitch();
	}

	public void addTask(String s) {
		// adds an item to the ToDoList
		todolist.taskAdd(s);
	}

	public void removeTask(String s) {
		// TODO: removes an item from the ToDoList
	}

	// we also need update methods for all the other elements in the model

	public static void update() {

	}

}
