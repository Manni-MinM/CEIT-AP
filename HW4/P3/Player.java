// BWOTSHEWCHB

public abstract class Player {
	// Fields
	protected int point ;
	protected Deck deck ;
	protected String username ;
	// Constructor
	public Player(String username) {
		this.point = 0 ;
		this.deck = new Deck() ;
		this.username = username ;
	}
	// Methods
	public int getPoint() {
		return point ;
	}
	public Deck getDeck() {
		return deck ;
	}
	public String getUsername() {
		return username ;
	}
}
