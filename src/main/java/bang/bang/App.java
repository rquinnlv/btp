package bang.bang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	boolean start = false;
    	
    	File file = new File("bang.txt");
    	   	
    	
    	BufferedReader reader = null;

    	 try {
    	  reader = new BufferedReader(new FileReader(file));
    	  String line;
    	  String[] action;

    	  //Read one line at a time, printing it.
    	  while ((line = reader.readLine()) != null) {
    		  if(line.contains("start"))
    		  {
    			  
    			  start = true;
    			  //initialize the game state
    			  
    			  //scan for my role  (sheriff, deputy, outlaw, renegate)
    			  
    			  //
    			  
    		  }
    		  else
    		  {
    			  
    			  start = false;
    		  }
    		  
    		  while(start){
    		
    			  
    			  
    			  //read file for command to play the game
    			  action = line.split(",");
    			  
    			  if(action.length < 1){
    				  // something is wrong
    				  
    			  }
    			  
    			  //
    		  }
    	   
    	  }
    	  
    	 
    	 } catch (IOException e) {
    	  e.printStackTrace();
    	 } 
    	
    }
}
