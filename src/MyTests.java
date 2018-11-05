import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    @Test
    public void ControllerTest() {
        Controller tester = new Controller(); // MyClass is tested
        assertEquals(0, tester.getGame(), "10 x 0 must be 0");

    }
    
    @Test
	public void GameObjectTest() {
    	GameObject tester = new GameObject(); // MyClass is tested
	   // assertEquals(0, Controllertester.getGame(), "10 x 0 must be 0");

	    }
    
    @Test
    public void GroundPatchTest() {
    	GroundPatch tester = new GroundPatch();
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }
    
    @Test
    public void InvasivePlantTest() {
    	InvasivePlant tester = new InvasivePlant();
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }
    
    @Test
    public void ModelTest() {
    	Model tester = new Model();
    	//assertEquals(0, tester.getXloc(), "this should fail");

	    }
    @Test
    public void NativePlantTest() {
    	NativePlant tester = new NativePlant();
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }
    @Test
    public void ObstacleTest() {
    	Obstacle tester = new Obstacle();
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }
    @Test
    public void PlayerTest() {
    	Player tester = new Player();
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }
    @Test
    public void ToDoListTest() {
    	ToDoList tester = new ToDoList();
    	//assertEquals(0, tester.getXloc(), "this should fail");

	    }
    @Test
    public void ToolbarTest() {
    	Toolbar tester = new Toolbar();
    	//assertEquals(0, tester.getXloc(), "this should fail");

	    }
    @Test
    public void ViewTest() {
    	View tester = new View();
    	//assertEquals(0, tester.getXloc(), "this should fail");

	    }
}