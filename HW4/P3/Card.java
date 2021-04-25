// BWOTSHEWCHB

public abstract class Card {
	// Fields
	protected int point ;
	protected String rank ;
	protected String color ;
	// Methods
	public int getPoint() {
		return point ;
	}
	public String getRank() {
		return rank ;
	}
	public String getColor() {
		return color ;
	}
	public boolean equals(Object object) {
		if ( !(object instanceof Card) )
			return false ;
		if ( object == this )
			return true ;
		Card card = (Card)object ;
		return (this.getRank().equals(card.getRank()) && this.getColor().equals(card.getColor())) ;
	}
}

