package bang.bang;

import java.util.ArrayList;
import java.util.List;

public class GreenHand {
	String Card;
	int active;
	boolean inPlay;
	
	public GreenHand(String card) {
		Card = card;
		active = 0;
		inPlay = false;	}
	
	public String getCard() {
		return Card;
	}
	
	public Boolean isActive(){
		return active > 0;
	}
	
	public Boolean isInPlay() {
		return inPlay;
	}
	
	public void activate() {
		active++;
	}
	
	public void play() {
		inPlay = true;
	}
	
}
