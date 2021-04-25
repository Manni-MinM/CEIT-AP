// BWOTSHEWCHB

public class Main {
	public static void main(String[] args) {
		Pile pile = new Pile() ;
		pile.show() ;
		System.out.println(pile.size()) ;
		System.out.println() ;
		Card randomCard = pile.drawCard() ;
		System.out.println(randomCard.toString()) ;
		System.out.println() ;
		pile.show() ;
		System.out.println(pile.size()) ;
	}
}
