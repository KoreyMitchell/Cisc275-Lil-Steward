package MVC;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.KeyEvent;

public class MyTests {

    @Test
    public void ControllerTest() {
        Controller tester = new Controller(); // MyClass is tested
        assertThat(tester.model, is(not(0)));
        
        tester.syncViewToModel(tester.model);
        assertThat(tester.model.player.getXloc(), is(tester.view.player.getXloc()));
        assertThat(tester.model.invasivePlants, is(tester.view.invasivePlants));
        assertThat(tester.model.nativePlants, is(tester.view.nativePlants));
        assertThat(tester.model.groundList, is(tester.view.groundList));
        assertThat(tester.model.obstacleList, is(tester.view.obstacleList));
        assertThat(tester.model.tool, is(tester.view.tool));
        tester.click(0, 0);
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
    	assertThat(tester.checkMove("down"), is(not(0)));
    	assertThat(tester.checkMove("left"), is(not(0)));
    	assertThat(tester.checkMove("right"), is(not(0)));
    	

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

    	
    	assertThat(tester.hashCode(), is(not(0)));
    	
    	//assertThat(tester.updatePlayerLocation(e);) TODO figure out how to make example keyevent for testing
    	KeyEvent key;
    	
    	//test movement method, both when it does and does not work
    	//Does work:
    	int temp = tester.getXloc()-1;
    	tester.updatePlayerLocation("up");
    	assertThat(tester.getXloc(), is(temp));
    	temp = tester.getXloc()+1;
    	tester.updatePlayerLocation("down");
    	assertThat(tester.getXloc(), is(temp));
    	temp = tester.getYloc()-1;
    	tester.updatePlayerLocation("left");
    	assertThat(tester.getYloc(), is(temp));
    	temp = tester.getYloc()+1;
    	tester.updatePlayerLocation("right");
    	assertThat(tester.getYloc(), is(temp));
    	
    	//Does not work:
    	tester.setXloc(0);
    	tester.setYloc(0);
    	temp = tester.getXloc()-1;
    	tester.updatePlayerLocation("up");
    	assertThat(tester.getXloc(), is(not(temp)));
    	temp = tester.getYloc()-1;
    	tester.updatePlayerLocation("left");
    	assertThat(tester.getYloc(), is(not(temp)));
    	tester.setXloc(200);
    	tester.setYloc(200);
    	temp = 201;
    	tester.updatePlayerLocation("down");
    	assertThat(tester.getXloc(), is(not(temp)));
    	tester.updatePlayerLocation("right");
    	assertThat(tester.getXloc(), is(not(temp)));
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
    	Controller c = new Controller();
    	//assertEquals(0, tester., "this should fail");
    	tester.setControl(c);
    	assertThat(tester.control, is(c));
    	tester.printStuff();

    	tester.initialize();
	    }
    
}
