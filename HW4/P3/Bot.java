// BWOTSHEWCHB

import java.util.ArrayList ;
import java.util.Collections ;

public class Bot extends Player {
	// Fields

	// Constructor
	public Bot(String username) {
		super(username) ;
	}
	// Methods
	public Card playCard(Card topCard) {
		// Find avaliable cards
		ArrayList<Card> avaliable = new ArrayList<Card>() ;
		for ( Card card : getDeck().getCards() )
			if ( (topCard != null && topCard.isValid(card)) || topCard == null )
				avaliable.add(card) ;
		if ( avaliable.size() == 0 )
			return null ;
		// Get info
		Card targetCard = avaliable.get(0) ;
		deck.removeCard(targetCard) ;
		return targetCard ;
	}
	public String getWildCardColor() {
		ArrayList<String> colors = new ArrayList<String>() ;
		colors.add("RED") ;
		colors.add("GREEN") ;
		colors.add("BLUE") ;
		colors.add("BLACK") ;
		Collections.shuffle(colors) ;
		return colors.get(0) ;
	}
}
