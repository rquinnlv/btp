package bang.bang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


/**
 * Hello world!
 *
 */
public class App
{
	
	String[] print;
	static Random rnd = new Random();
	static int health = 0;
	static int rangeGun = 1;
	static int rangeOther = 0;
	static int myRange = rangeGun + rangeOther;
	static List <String>	roles =  new ArrayList<String>();
	static List <String>	hand =  new ArrayList<String>();
	static List <String> 	bHand = new ArrayList<String>();
	static List <GreenHand>	gHand =  new ArrayList<GreenHand>();
	static String myRole = "";
	static int inHand = 0;
	static String lastCardPlayed = "";
	
	public static void main( String[] args )
	{
		boolean start = true;
		File file = new File("bang.txt");
		
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
					System.out.print("start command: ");

				}
				else if(line.equals("end"))
				{	  /*
				 *  To do
				 *  Cleanup
				 */

					start = false;
					System.out.print("end command");
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
					b3Button();
					
					System.out.print("b3 command");
					
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
							if (myRole.equals("sheriff"))
								printSomething(1); // announce myself if sheriff
						}
						
						System.out.print("starting a new game...  role has been set");
					}
					else { // Add to hand
						if (action[1].equals("green"))
							addToHand(3, action[2]);
						else if (action[1].equals("blue"))
							addToHand(2, action[2]);
						else 
							addToHand(1, action[2]);
					}
					

				} else if (action[0].equals("b2")){
					String card = action[2];
					String cardType = action[1];
					if(card.equals("panic") || card.equals("contestoga") || card.equals("ragtime") 
							  || card.equals("cancan") || card.equals("cat") || card.equals("brawl")){
						lastCardPlayed = card;
					}
					else if(card.equals("bang") || card.equals("pepperbox") || card.equals("howitzer") || card.equals("Buffalorifle")
							 || card.equals("punch") || card.equals("knife") || card.equals("derringer") 
							     || card.equals("springfield") || card.equals("indian") || card.equals("duel")){
						
						// do action for to check for miss, no miss check for health, last health check for beer. if last health play beer
						someoneShotMe(card);
					}
//					else if(card.equals("indian") || card.equals("duel")){
//						// play bang , if no bang in hand, minus health, if last bullet, 
//						someoneShootMe(card);
//						//print something and announce finished from the game						
//					}
					else if(card.equals("saloon") || card.equals("tequila")){
					   // heal me, check for health if full health skip	
						healMe();
					}
					
					
					if(lastCardPlayed.equals("panic") || lastCardPlayed.equals("contestoga") || lastCardPlayed.equals("ragtime") 
							  || lastCardPlayed.equals("cancan") || lastCardPlayed.equals("catbalou") 
							     || lastCardPlayed.equals("brawl")) {
						//do action for taking a card away from my hand
						takeCardFromHand(cardType, card);
					}
				//	playMyHand(lastCardPlayed, action[1]);
					lastCardPlayed = card;
				}
				
				
				

				/*
				 * to do 
				 * respond to card b2
				 * if role
				 * Update player death
				 */
				if (action[1].equals("role")) {						
					for (int i = 0; i < roles.size(); i++) {
						if (roles.get(i).equals(action[2]))
							roles.remove(i);
					}
					
					printSomething(1); // Smack Talk dead person
					
					System.out.print("someone is finished");
				}
				else { // Respond!
					b2Button(action[2]);
				}

			}    		    		  


		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

	private static void healMe() {
		// TODO Auto-generated method stub
		if(health > 5){
			
			//Print i have full health don't need to heal me
		}
		else
		{
			health = health + 1;
		}
		
	}

	private static void someoneShotMe(String card) {
		int idxOfHand = 0;
		if(card.equals("indian") || card.equals("duel")){
			//do i have a miss
			if(hand.contains("bang")){
				
				idxOfHand = hand.indexOf("bang");
				hand.remove(idxOfHand);
				
				//print something to pi hand + bang, index
			}
			else{
				//print something is wrong
				//lost one health, if health is <= 0 print out die message
			}
		}
		else 
		{
			if(gHand.contains("sombrero") || gHand.contains("tengallonhat") || gHand.contains("ironplate") 
					 || gHand.contains("bible")){

				 Iterator<GreenHand> iter = gHand.iterator();
				 while (iter.hasNext()) {      // any more element
			         // Retrieve the next element, explicitly downcast from Object back to String
			         GreenHand gh = iter.next();
			         if(gh.Card.equals("sombrero") && gh.active > 0){
			        	idxOfHand = gHand.indexOf(gh.Card);
			        	gHand.remove(idxOfHand);
			        	//print something
			        	break;
			         }
			         else if(gh.Card.equals("tengallonhat") && gh.active > 0){
			        	idxOfHand = gHand.indexOf(gh.Card);
				        gHand.remove(idxOfHand);
				        //print something
				        break;
			         }
			         else if(gh.Card.equals("ironplate") && gh.active > 0){
			        	idxOfHand = gHand.indexOf(gh.Card);
				        gHand.remove(idxOfHand);
				        //print something
				        break;
			         }
			         else if(gh.Card.equals("bible") && gh.active > 0){
				        idxOfHand = gHand.indexOf(gh.Card);
					    gHand.remove(idxOfHand);
					        //print something
					    break;
				     }
			        
			      }				
			}
			else if(hand.contains("miss") ){
				idxOfHand = hand.indexOf("miss");
				hand.remove(idxOfHand);
				//print something
			}
			else if(hand.contains("dodge")){
				idxOfHand = hand.indexOf("miss");
				hand.remove(idxOfHand);
				//print something
			}
			else{
				//
				if (health >= 2){
					health = health - 1;
				}
				else
				{
					if(hand.contains("beer")){
						idxOfHand = hand.indexOf("beer");
						hand.remove(idxOfHand);
						//print last health but played beer
					}
					else{
						//print I am dead, no miss or health
					}			
				}
			}
		}
	}
		

	

	private static void takeCardFromHand(String cardType,String card) {
		if(cardType.equals("blue")){
			if(bHand.contains(card)){
				//do somehting
				bHand.remove(card);
			}
			else{
				//print something wrong
			}
		}
		else if(cardType.equals("gren")){
			if(gHand.contains(card)){
				//do something
				gHand.remove(card);
			}
			else{
				
				//print something wrong
			}
		}
		else {
			if(hand.contains(card)){
				//do something
				hand.remove(card);
			}
			else
			{
				//print something wrong
			}
		}
		
	}

	

	public static void addToHand(int handType, String card) {
		// resulted from b3 - used to add initial hand and general store cards
		switch (handType) {
		case 1: hand.add(card);
				inHand++;
		case 2:	GreenHand tmp = new GreenHand(card);
				gHand.add(tmp);
				inHand++;
		default: break;
		}
	}
	
	public static void b3Button() {
		// see excel sheet B3 table
		String print = new String();
		String currentCard = new String();
		int playerIndex;
		int sheriffPos = findSheriff();
		
		for (int i = 0; i < bHand.size(); i++) {
			currentCard = bHand.get(i);
			if (currentCard.equals("jail")) {
				do
					playerIndex = choosePlayerIndex(roles.size());
				while (playerIndex != sheriffPos);
			}
			if (currentCard.equals("dynamite")) {
				playerIndex = choosePlayerIndex(roles.size());
			}
			if (currentCard.equals("binocular") || currentCard.equals("scope"))
				play("Card: " + i);
			if (currentCard.equals(""))
			if (currentCard.equals("volcanic")) {
				if (sheriffPos <= 1)
					play("Card: " + i);
			}
		}
		
		
		
		//
			
		
//		switch (card) {
//		case "panic":	
//			break;
//		default: break;
//		}
	}
	
	public static void b2Button(String card) {
		// see excel sheet B2 table
		switch (1) {
		case 1:
			break;
		default: break;
		}
	}
	
	public static void play(String str) {
		
	}
	
	public static int choosePlayerIndex(int range) {
		/*
		 * Sheriff: shoot all
		 * Outlaw: shoot sheriff if in range, else random
		 * Deputy: shoot all except sheriff
		 * Renegade: shoot all except sheriff, sheriff last
		 * 
		 */
		int sheriffPos = findSheriff();
		int direction = 0; // 0 = left, 1 = right
		
		if (!(sheriffPos == 0))
			if (((double)sheriffPos/(double)roles.size()) > 0.5)
				direction = 1;
		
		
		int index = rnd.nextInt(Math.abs(range));
		if (index == 0) index++;
		int sheriff = findSheriff();
		
		switch (1) {
		case 1:	break;
		case 2:	if (roles.get(index).equals("sheriff") && roles.size() > 2)
								index = choosePlayerIndex(range);
							break;
		
		case 3: 
		case 4:	if (roles.get(index).equals("sheriff"))
							index = choosePlayerIndex(range);
							break;
		case 5:
		case 6:
		case 7:	if (sheriff <= myRange)
							index = sheriff;
						else
							break;
		default: break;
		}
		if (direction == 1)
			return Math.abs(roles.size() - index);
		else
			return index;
	}
	
	public static int findSheriff () {
		for (int i = 0; i < roles.size(); i++)
			if (roles.get(i).equals("sheriff"))
				return i;
		return 0;
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
