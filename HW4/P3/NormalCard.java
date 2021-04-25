// BWOTSHEWCHB

public class NormalCard extends Card {
	// Normal Cards : {3 , 4 , 5 , 6 , 9}

	// Constructor
	public NormalCard(String rank , String color) {
		this.rank = rank ;
		this.color = color ;
		this.point = Integer.parseInt(rank) ;
	}
}

