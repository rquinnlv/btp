package bang.bang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	boolean start = true;
    	
    	File file = new File("bang.txt");
    	int health = 0;
    	List    roles =  new ArrayList();
    	//card holders
//    	String colorOfCard = "";
//    	String B1 = "";
//    	String B2 = "";
    	   	   	
    	
    	BufferedReader reader = null;

    	 try {
    	  reader = new BufferedReader(new FileReader(file));
    	  String line;
    	  String[] action;

    	  
    	  line = reader.readLine();
    	  //Read one line at a time, printing it.
    	  while (start) {
    		  
    		
    		  if(line.equals("start"))
    		  {  			  
    			  start = true;
    			  /*
    			   *  To do
    			   *  initialize the game state
    			   */
    			  
    			   //initilaiz health;
    			   health = 3;
    			     
    			  
    			
    		  }
    		  else if(line.equals("end"))
    		  {
    			  
    			  start = false;
    		  }
    		  
    		  
    		  // close file and wait for new input
    		  try {
  				    reader.close();
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		
    			  reader = new BufferedReader(new FileReader(file));  	
    			  
    			  line = reader.readLine();
    			
    			  //read file for command to play the game
    			  action = line.split(",");
    			  
    			  if(action.length < 1){
    				  // something is wrong
    				  
    				  // set roles
    			  }else if(action[0].equals("role")){
    				  /*
        			   * to do
        			   * scan for my role  (sheriff, deputy, outlaw, renegate)
        			   */
        			 
    				  roles.add(action[1]);
    				  
        			  /*
        			   *  to do
        			   *  call py to announce my role
        			   */
    				  
    				  
    			  }else if(action[0].equals("b1")){
    				  
    				  /*
    				   * to do
    				   * play b1 stuff
    				   */
    				  
    			  }
    			  else if(action[0].equals("b2"));
    			  
    			    /*
    			     * to do 
    			     * play b2 stuff
    			     */
    			     			     			      			  
    		  }    		    		  
    	  
    	 
    	 } catch (IOException e) {
    	  e.printStackTrace();
    	 } 
    	
    }
}
