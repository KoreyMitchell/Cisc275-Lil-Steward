package MVC;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class MyTests.
 */
public class MyTests {

    /**
     * Controller test.
     */
    @Test
    public void ControllerTest() {
        Controller tester = new Controller(); // MyClass is tested
        assertThat(tester.model, is(not(0)));
        
        tester.syncViewToModel(tester.model);
        assertThat(tester.model.player.getXloc(), is(tester.view.player.getXloc()));
        assertThat(tester.model.invasivePlants, is(tester.view.invasivePlants));
        assertThat(tester.model.nativePlants, is(tester.view.nativePlants));
        assertThat(tester.model.getGroundList(), is(tester.view.groundList));
        assertThat(tester.model.obstacleList, is(tester.view.obstacleList));
        assertThat(tester.model.tool, is(tester.view.tool));
        tester.click(0, 0);
    }
    
    /**
     * Game object test.
     */
    @Test
	public void GameObjectTest() {
    	GameObject tester = new GameObject(); // MyClass is tested
    	tester.setXloc(0);
    	tester.setYloc(0);

    	GameObject tester2 = new GameObject();
    	tester2.setXloc(0);
    	tester2.setYloc(0);
    	assertThat(tester.equals("horse"), is(false));
    	assertThat(tester.equals(tester2), is(false));//check after setting image icons
	    }
    
    /**
     * Ground patch test.
     */
    @Test
    public void GroundPatchTest() {
    	GroundPatch tester= new GroundPatch(0, 0);
    	assertEquals(0, tester.getXloc(), "this should fail");

	    }

    
    /**
     * Invasive plant test.
     */
    @Test
    public void InvasivePlantTest() {
    	InvasivePlant tester = new InvasivePlant(0, 0);
    	assertEquals(0, tester.getXloc(), "this should fail");

    	assertEquals(0, tester.hashCode(), "this should fail");
    	
	    }
    
    /**
     * Model test.
     */
    @Test
    public void ModelTest() {
    	Model tester = new Model();
    	tester.run();
    	assertThat(tester.checkMove("up"), is(not(0)));
    	assertThat(tester.checkMove("down"), is(not(0)));
    	assertThat(tester.checkMove("left"), is(not(0)));
    	assertThat(tester.checkMove("right"), is(not(0)));
    	tester.getObstacleList().add(new Obstacle(10,10));
    	tester.getPlayer().setXloc(9);
    	assertThat(tester.checkMove("up"), is(false));
    	assertThat(tester.getSeconds(), is(60));
    	tester.escapeReset();
    	assertThat(tester.nativePlants.size(), is(0));
    	tester.setLevel(1);
    	assertThat(tester.level, is(1));
    	tester.levelPreset(0);
    	assertThat(tester.nativePlants.size(), is(0));
    	assertThat(tester.getPlantsPlanted(), is(0));
    	assertThat(tester.getPlantsRemoved(), is(0));
    	assertThat(tester.getNativePlants().size(), is(0));
    	assertThat(tester.getObstacleList().size(), is(not (0)));
    	assertThat(tester.getPlayer().getXloc(), is(0));
    	assertThat(tester.getLevel(), is(tester.getLevel()));
    	assertThat(tester.getInvasivePlants().size(), is(not(0)));
    	KeyEvent e = null;
		tester.getGroundList().clear();
    	tester.getInvasivePlants().clear();
    	tester.setLevel(4);
    	tester.checkLvlUp();
    	assertThat(tester.win, is(true));
    	tester.setLevel(1);
    	tester.escapeReset();
    	tester.setPlantsRemoved(0);
    	tester.setInvasivePlants(new ArrayList<InvasivePlant>());
    	tester.setNativePlants(new ArrayList<NativePlant>());
    	tester.setObstacleList(new ArrayList<Obstacle>());
    	tester.setPlantsPlanted(0);
    	tester.setPlayer(new PlayerCharacter());
    	assertThat(tester.plantsRemoved, is(0));
	    }
    
    /**
     * Native plant test.
     */
    @Test
    public void NativePlantTest() {
    	NativePlant tester = new NativePlant(0, 0);
    	assertEquals(0, tester.getXloc(), "this should fail");

    	assertEquals(0, tester.hashCode(), "this should fail");
	    }
    
    /**
     * Obstacle test.
     */
    @Test
    public void ObstacleTest() {
    	Obstacle tester = new Obstacle(0, 0);
    	assertEquals(0, tester.getXloc(), "this should fail");

    	assertEquals(0, tester.hashCode(), "this should fail");
	    }
    
    /**
     * Player test.
     */
    @Test
    public void PlayerTest() {
    	PlayerCharacter tester = new PlayerCharacter();
    	assertEquals(10, tester.getXloc(), "this should fail");
    	assertThat(tester.getXloc(), is(not(0)));

    	
    	assertThat(tester.hashCode(), is(not(0)));
    	
    	//assertThat(tester.updatePlayerLocation(e);) TODO figure out how to make example keyevent for testing
    	@SuppressWarnings("unused")
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
    
    

    /**
     * Tool.
     */
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
    
    /**
     * View test.
     */
    @Test
    public void ViewTest() {
    	View tester = new View();
    	Controller c = new Controller();
    	//assertEquals(0, tester., "this should fail");
    	tester.setControl(c);
    	assertThat(tester.getControl(), is(c));
    	tester.printStuff();

    	tester.initialize();
	    }        
}
