package MVC;

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
		
        
       
          
        // Serialization  
        try
        {    
        	//Creating Native Plants
            NativePlant nativeP = new NativePlant(3, 3);
            nativeP.setXloc(0);
            nativeP.setYloc(0);
            //creating invasive plant
            InvasivePlant invasiveP = new InvasivePlant(3,3);
            nativeP.setXloc(2);
            nativeP.setYloc(2);
            //
            
        	//Saving object to file 
            FileOutputStream fos = new FileOutputStream("tempdata.ser"); 
            ObjectOutputStream oos = new ObjectOutputStream(fos); 
              
            //serialize 
            oos.writeObject(nativeP); 
              
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
              
            ois.close(); 
            //assertEquals()
            
            new File("tempdata.ser").delete();  
            System.out.println("read object successful"); 
            
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
        
  
    } 
} 


