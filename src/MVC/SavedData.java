package MVC;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class SavedData.
 */
public class SavedData{
	
	/** The Constant serialVersionUID. */
	//private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) 
    {    
		
		//Creating Native Plants
        NativePlant nativeP = new NativePlant(3, 3);
        nativeP.setXloc(0);
        nativeP.setYloc(0);
        //creating invasive plant
        InvasivePlant invasiveP = new InvasivePlant(3,3);
        invasiveP.setXloc(2);
        invasiveP.setYloc(2);
        //creating obstacle
        Obstacle obstacle = new Obstacle(3, 3);
        obstacle.setXloc(4);
        obstacle.setYloc(4);
        //create player
        PlayerCharacter player = new PlayerCharacter();
        player.setXloc(3);
        player.setYloc(5);
        //create ground Patch
        GroundPatch patch = new GroundPatch(10, 10);
        patch.setXloc(30);
        patch.setYloc(7);
        
        //create tutorial note
        //TutorialNote tNote = new TutorialNote(7,7,"test");
        //tNote.setXloc(7);
        //tNote.setYloc(7);
        //create tutorial note aster
        //TutorialNoteAster noteA = new TutorialNoteAster(8,11);
        //noteA.setXloc(11);
        //noteA.setYloc(8);
        //create tutorial note direction
        //TutorialNoteDirection noteD = new TutorialNoteDirection(15,50);
        //noteD.setXloc(50);
        //noteD.setYloc(15);
        //create tutorial note inkberry
        //TutorialNoteInkberry noteI = new TutorialNoteInkberry(14,4);
        //noteI.setXloc(4);
        //noteI.setYloc(14);
        //create tutorial note phragmitesPlayerCharacter player = new PlayerCharacter();
        //TutorialNotePhragmites noteP= new TutorialNotePhragmites(4,73);
        //noteP.setXloc(73);
        //noteP.setYloc(4);
        
        // Serialization  
        try
        {    
        	
        	//Saving object to file 
            FileOutputStream fos = new FileOutputStream("tempdata.ser"); 
            ObjectOutputStream oos = new ObjectOutputStream(fos); 
              
            //serialize 
            oos.writeObject(nativeP); 
            oos.writeObject(invasiveP);  
            oos.writeObject(obstacle); 
            oos.writeObject(player);
            oos.writeObject(patch); 
            //oos.writeObject(tNote);  
            //oos.writeObject(noteA); 
            //oos.writeObject(noteD); 
            //oos.writeObject(noteI);  
            //oos.writeObject(noteP); 
            
            oos.close(); 
            
            System.out.println("write object successful"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("it failed"); 
        } 
  
       
        // Deserialization 
        try
        {    
        	
            // Reading the object from a file 
            FileInputStream fis = new FileInputStream("tempdata.ser"); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
              
            // Method for deserialization of object 
            NativePlant object1 = (NativePlant)ois.readObject(); 
            InvasivePlant object2 = (InvasivePlant)ois.readObject();  
            Obstacle object3 = (Obstacle)ois.readObject();
            PlayerCharacter object4 = (PlayerCharacter)ois.readObject();
            GroundPatch object5 = (GroundPatch)ois.readObject(); 
            //TutorialNote object6 = (TutorialNote)ois.readObject();  
            //TutorialNoteAster object7 = (TutorialNoteAster)ois.readObject();
            //TutorialNoteDirection object8 = (TutorialNoteDirection)ois.readObject();
            //TutorialNoteInkberry object9 = (TutorialNoteInkberry)ois.readObject();
            //TutorialNotePhragmites object10 = (TutorialNotePhragmites)ois.readObject();
            
            ois.close(); 
            
            //test if the objects are the same value
            assertEquals(nativeP,object1);
            assertEquals(invasiveP,object2);
            assertEquals(obstacle,object3);
            assertEquals(player,object4);
            assertEquals(patch,object5);
            //assertEquals(tNote,object6);
            //assertEquals(noteA,object7);
            //assertEquals(noteD,object8);
            //assertEquals(noteI,object9);
            //assertEquals(noteP,object10);
            
            new File("tempdata.ser").delete();  
            System.out.println("read object successful"); 
            
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("failed test"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
        
  
    } 
} 
