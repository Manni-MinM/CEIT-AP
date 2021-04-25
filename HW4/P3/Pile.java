// BWOTSHEWCHB

import java.util.ArrayList ;
import java.util.Collections ;

public class Pile {
	// Fields
	ArrayList<Card> pile ;
	// Constructor
	public Pile() {
		pile = new ArrayList<Card>() ;

		String[] normalCards = {"3" , "4" , "5" , "6" , "9" , "C" , "D"} ; 
		for ( String rank : normalCards ) {
			pile.add(new NormalCard(rank , "RED")) ;
			pile.add(new NormalCard(rank , "GREEN")) ;
			pile.add(new NormalCard(rank , "BLUE")) ;
			pile.add(new NormalCard(rank , "BLACK")) ;
		}

		pile.add(new ForceCard("2" , "RED")) ;
		pile.add(new ForceCard("2" , "GREEN")) ;
		pile.add(new ForceCard("2" , "BLUE")) ;
		pile.add(new ForceCard("2" , "BLACK")) ;

		pile.add(new DrawFourCard("7" , "BLACK")) ;

		pile.add(new DrawTwoCard("7" , "RED")) ;
		pile.add(new DrawTwoCard("7" , "GREEN")) ;
		pile.add(new DrawTwoCard("7" , "BLUE")) ;

		pile.add(new PrizeCard("8" , "RED")) ;
		pile.add(new PrizeCard("8" , "GREEN")) ;
		pile.add(new PrizeCard("8" , "BLUE")) ;
		pile.add(new PrizeCard("8" , "BLACK")) ;

		pile.add(new ReverseCard("10" , "RED")) ;
		pile.add(new ReverseCard("10" , "GREEN")) ;
		pile.add(new ReverseCard("10" , "BLUE")) ;
		pile.add(new ReverseCard("10" , "BLACK")) ;

		pile.add(new SkipCard("A" , "RED")) ;
		pile.add(new SkipCard("A" , "GREEN")) ;
		pile.add(new SkipCard("A" , "BLUE")) ;
		pile.add(new SkipCard("A" , "BLACK")) ;

		pile.add(new WildCard("B" , "RED")) ;
		pile.add(new WildCard("B" , "GREEN")) ;
		pile.add(new WildCard("B" , "BLUE")) ;
		pile.add(new WildCard("B" , "BLACK")) ;

		Collections.shuffle(pile) ;
	}
	public void show() {
		for ( Card card : pile )
			System.out.println(card.toString()) ;
	}
}

