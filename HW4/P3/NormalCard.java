// BWOTSHEWCHB

public class NormalCard extends Card {
	// Normal Cards : {3 , 4 , 5 , 6 , 9}

	// Constructor
	public NormalCard(String rank , String color) {
		this.rank = rank ;
		this.color = color ;
		if ( rank.equals("C") )
			this.point = 12 ;
		else if ( rank.equals("D") )
			this.point = 13 ;
		else
			this.point = Integer.parseInt(rank) ;
	}
}

