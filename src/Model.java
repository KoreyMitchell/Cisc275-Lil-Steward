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
		playerCharacter = new Player();
		playerCharacter.setXloc(0);
		playerCharacter.setYloc(0);
	}
	
	public void updateLocationAndDirection() {
		//TODO: using arrow keys: up down left right
	}
	
	//we also need update methods for all the other elements in the model

	public static void update() {
		
	}
	
}
