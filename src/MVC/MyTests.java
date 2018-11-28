package MVC;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    @Test
    public void ControllerTest() {
        Controller tester = new Controller(); // MyClass is tested
        assertThat(tester.model, is(not(0)));
    }
    
    @Test
	public void GameObjectTest() {
    	GameObject tester = new GameObject(); // MyClass is tested

    	GameObject tester2 = new GameObject();
    	assertThat(tester.equals("horse"), is(false));
    	assertThat(tester.equals(tester2), is(true));
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

    	assertEquals(0, tester.hashCode(), "this should fail");
	    }
    
    @Test
    public void ModelTest() {
    	Model tester = new Model();
    	assertThat(tester.checkMove("up"), is(not(0)));

	    }
    @Test
    public void NativePlantTest() {
    	NativePlant tester = new NativePlant(0, 0);
    	assertEquals(0, tester.getXloc(), "this should fail");

    	assertEquals(0, tester.hashCode(), "this should fail");
	    }
    @Test
    public void ObstacleTest() {
    	Obstacle tester = new Obstacle(0, 0);
    	assertEquals(0, tester.getXloc(), "this should fail");

    	assertEquals(0, tester.hashCode(), "this should fail");
	    }
    @Test
    public void PlayerTest() {
    	PlayerCharacter tester = new PlayerCharacter();
    	assertEquals(10, tester.getXloc(), "this should fail");
    	assertThat(tester.getXloc(), is(not(0)));

    	int temp = tester.getXloc()-1;
    	assertThat(tester.hashCode(), is(not(0)));
    	tester.updatePlayerLocation("up");
    	//assertThat(tester.updatePlayerLocation(e);) TODO figure out how to make example keyevent for testing
    	assertThat(tester.getXloc(), is(temp));
	    }
 
    @Test
    public void Tool() {
    	Tool tester = new Tool(false);
    	assertThat(tester.isShovel(),is(not(0)));
    	assertThat(tester.isShovel(),is(not(true)));
    	assertThat(tester.isShovel(),is(false));
    	
    	tester.switchTool();
    	
    	assertThat(tester.isShovel(),is(true));
    	assertThat(tester.isShovel(),is(not(false)));
    	tester.setShovel(false);
    	assertThat(tester.isShovel(),is(false));
	    }
    @Test
    public void ViewTest() {
    	View tester = new View();
    	//assertEquals(0, tester., "this should fail");

	    }
}
