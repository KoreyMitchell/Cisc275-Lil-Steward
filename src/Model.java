import java.util.ArrayList;

public class Model {
	 //Attributes of Model
	
	Player playerCharacter;
	ArrayList<NativePlant> listOfNativePlants;
	ArrayList<InvasivePlant> listOfInvasivePlants;
	Toolbar toolbar;
	ToDoList todolist;
	ArrayList<Obstacle> obstacleList;
	ArrayList<GroundPatch> groundList;
	
	
	//Methods
	public static void main(String[] args) {
		// Text-only version of gameplay for demonstration purposes

		Model m = new Model();
		
		System.out.println("Your location is: "+ m.playerCharacter.getXloc() + ", "+ m.playerCharacter.getYloc());
		
	}
	
	public Model() {
		playerCharacter = new Player(0,0,0);
		playerCharacter.setXloc(0);
		playerCharacter.setYloc(0);
	}
	
	public void updatePlayerLocation() {
		//TODO: using arrow keys: up down left right
	}
	
	public void updatePlayerDirection() {
		//TODO: using arrow keys: up down left right
	}
	
	public void updatePlayer() {
		//TODO: uses both updatePlayerDirection and Location
	}
	
	public void addNativePlant(int x, int y) {
		//TODO: only plant if there is an unplanted patch of ground at this x and y
		listOfNativePlants.add(new NativePlant(x,y,"goldenrod"));
	}
	
	public void removeInvasivePlant(int x, int y) {
		//TODO: removes an InvasivePlant with the x and y specified from the list of invasive plants
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
		//TODO: removes an item from the ToDoList
	}
	
	//we also need update methods for all the other elements in the model

	public static void update() {
		
	}
	
}
