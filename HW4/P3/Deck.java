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
	public ArrayList<Card> getCards() {
		return deck ;
	}
	public void addCard(Card card) {
		deck.add(card) ;
	}
	public void removeCard(Card card) {
		deck.remove(card) ;
	}
}

