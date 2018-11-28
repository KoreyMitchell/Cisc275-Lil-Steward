package MVC;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    @Test
    public void ControllerTest() {
        Controller tester = new Controller(); // MyClass is tested
    	assertEquals(0, tester.model, "this should fail");
    }
    
    @Test
	public void GameObjectTest() {
    	GameObject tester = new GameObject(); // MyClass is tested

	    }
    @Test
    public void GroundPatchTest() {
    	GroundPatch tester= new GroundPatch(0, 0);
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }

    
    @Test
    public void InvasivePlantTest() {
    	InvasivePlant tester = new InvasivePlant(0, 0);
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }
    
    @Test
    public void ModelTest() {
    	Model tester = new Model();
    	assertEquals(0, tester.checkMove("up"), "this should fail");

	    }
    @Test
    public void NativePlantTest() {
    	NativePlant tester = new NativePlant(0, 0);
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }
    @Test
    public void ObstacleTest() {
    	Obstacle tester = new Obstacle(0, 0);
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }
    @Test
    public void PlayerTest() {
    	PlayerCharacter tester = new PlayerCharacter();
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }
 
    @Test
    public void Tool() {
    	Tool tester = new Tool(false);
    	assertEquals(0, tester.isShovel(), "this should fail");

	    }
    @Test
    public void ViewTest() {
    	View tester = new View();
    	//assertEquals(0, tester., "this should fail");

	    }
}
