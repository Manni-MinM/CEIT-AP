// BWOTSHEWCHB

import java.util.Iterator ;
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
		ArrayList<String> lines = new ArrayList<String>() ;
		for ( int it = 0 ; it < 8 ; it ++ )
			lines.add("") ;
		for ( int it = 0 ; it < deck.size() ; it ++ ) {	
			Card card = deck.get(it) ;
			ArrayList<String> cardLines = null ;
			if ( it == deck.size() - 1 )
				cardLines = card.stringed() ;
			else
				cardLines = card.stringedWithoutRightSide() ;
			ArrayList<String> temp = new ArrayList<String>() ;
			int index = 0 ;
			for ( String cardLine : cardLines ) {
				temp.add(lines.get(index) + cardLine) ;
				index ++ ;
			}
			lines.clear() ;
			for ( String line : temp )
				lines.add(line) ;
			temp.clear() ;
		}
		for ( String line : lines )
			System.out.println(line) ;
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

