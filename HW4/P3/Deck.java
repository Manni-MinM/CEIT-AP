// BWOTSHEWCHB

import java.util.ArrayList ;

public class Deck {
	// Fields 
	ArrayList<Card> deck ;
	// Constructor
	public Deck() {
		deck = new ArrayList<Card>() ;
	}
	// Methods
	public int size() {
		return deck.size() ;
	}
	public boolean isEmpty() {
		return (size() == 0) ;
	}
	public void show() {
		for ( Card card : deck )
			System.out.println(card.toString()) ;
	}
	public void addCard(Card card) {
		deck.add(card) ;
	}
	public Card playCard(Card card) {
		Card returnValue = deck.get(0) ;
		deck.remove(0) ;
		return returnValue ;
	}
}

