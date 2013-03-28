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
		int rangeGun = 1;
		int rangeOther = 0;
		List <String>	roles =  new ArrayList();
		List <String>	hand =  new ArrayList();
		List <String>	gHand =  new ArrayList();
		List <Boolean>	gHandActive =  new ArrayList();
		String myRole = "";
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

					//Initilaize Myself;
					health = 4;
					

				}
				else if(line.equals("end"))
				{	  /*
				 *  To do
				 *  Cleanup
				 */

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

				} else if (action[0].equals("b3")) {
					/*
					 * to do
					 * add cards to correct hand
					 */
					b3Button(action[2]);
					
				} else if (action[0].equals("b1")){

					/*
					 * to do
					 * Add 2 cards to hand and play my turn
					 * If role card
					 * scan for roles (sheriff, deputy, outlaw, renegate)
					 */
					if (action[1].equals("role")) {						
						roles.add(action[2]);
						if(myRole.equals("")) {
							myRole = roles.get(0);
							if (myRole.equals("s"))
								printSomething(1); // announce myself if sheriff
						}
					}
					else { // Add to hand
						if (action[1].equals("green"))
							addToHand(2, action[2]);
						else
							addToHand(1, action[2]);
					}
					

				} else if (action[0].equals("b2"));

				/*
				 * to do 
				 * respond to card b2
				 * if role
				 * Update player death
				 */
				if (action[1].equals("role")) {						
					//roles.remove(action[2]);
					
					printSomething(1); // Smack Talk dead person
					
				}
				else { // Respond!
					b2Button(action[2]);
				}

			}    		    		  


		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

	public static void addToHand(int hand, String card) {
		// resulted from b3 - used to add initial hand and general store cards
	}
	
	public static void b3Button(String Card) {
		// see excel sheet B3 table
	}
	
	public static void b2Button(String Card) {
		// see excel sheet B2 table
	}
	
	public static void printSomething(int index) {
		/*
		 * This function has all the LED prints
		 * in a nice switch statement
		 */
		switch (index) {
		case 1:  // print
		case 2:  
		case 3:  
		case 4:  
		case 5:  
		case 6:  
		case 7:  
		case 8:  
		case 9:  
		case 10: 
		case 11: 
		case 12: 
			break;
		default: break;
		}
	}
}
