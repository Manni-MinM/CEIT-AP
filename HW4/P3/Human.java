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
	public Card createCard(String rank , String color) {
		Card targetCard = null ;
		if ( rank.equals("3") || rank.equals("4") || rank.equals("5") ||
			rank.equals("6") || rank.equals("9") || rank.equals("C") || rank.equals("D") )
				targetCard = new NormalCard(rank , color) ;
		else if ( rank.equals("2") )
			targetCard = new ForceCard(rank , color) ;
		else if ( rank.equals("7") && color.equals("BLACK") )
			targetCard = new DrawFourCard(rank , color) ;
		else if ( rank.equals("7") && !color.equals("BLACK") )
			targetCard = new DrawTwoCard(rank , color) ;
		else if ( rank.equals("8") )
			targetCard = new PrizeCard(rank , color) ;
		else if ( rank.equals("10") )
			targetCard = new ReverseCard(rank , color) ;
		else if ( rank.equals("A") )
			targetCard = new SkipCard(rank , color) ;
		else if ( rank.equals("B") )
			targetCard = new WildCard(rank , color) ;
		return targetCard ;
	}
	public Card playCard(Card topCard) {
		// Find avaliable cards
		ArrayList<Card> avaliable = new ArrayList<Card>() ;
		for ( Card card : getDeck().getCards() )
			if ( (topCard != null && topCard.isValid(card)) || topCard == null )
				avaliable.add(card) ;
		if ( avaliable.size() == 0 )
			return null ;
		// Get info
		Card targetCard = null ;
		while ( true ) {
			String line = input.nextLine() ;
			String[] lineSplit = line.split("-") ;
			targetCard = createCard(lineSplit[0] , lineSplit[1]) ;
			if ( avaliable.contains(targetCard) )
				break ;
		}
		deck.removeCard(targetCard) ;
		return targetCard ;
	}
}

