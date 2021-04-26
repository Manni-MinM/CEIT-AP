// BWOTSHEWCHB

import java.util.Scanner ;
import java.util.ArrayList ;

public class Human extends Player {
	// Fields
	Scanner input ;
	// Constructor
	public Human(String username) {
		super(username) ;
		input = new Scanner(System.in) ;
	}
	// Methods
	public Card playTurn(Card topCard) {
		// Find avaliable cards
		ArrayList<Card> avaliable = new ArrayList<Card>() ;
		for ( Card card : getDeck().getCards() )
			if ( topCard.isValid(card) )
				avaliable.add(card) ;
		if ( avaliable.size() == 0 )
			return null ;
		// Get info
		Card targetCard = null ;
		while ( true ) {
			String line = input.nextLine() ;
			String[] lineSplit = line.split("-") ;
			targetCard = new NormalCard(lineSplit[0] , lineSplit[1]) ;
			if ( avaliable.contains(targetCard) )
				break ;
		}
		return targetCard ;
	}
}

