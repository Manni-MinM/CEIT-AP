// BWOTSHEWCHB

public class Main {
	public static void main(String[] args) {
		Card card1 = new NormalCard("3" , "RED") ;
		Card card2 = new ForceCard("2" , "BLACK") ;
		
		System.out.println(card1.toString()) ;
		System.out.println(card2.toString()) ;
		
		System.out.println(card2.getColor()) ;
		System.out.println(card1.equals(card2)) ;
	}
}
