// BWOTSHEWCHB

public class Match {
	// Fields
	private String homeTeam ;
	private String awayTeam ;
	private String date ;
	// Constructor
	public Match(String homeTeam , String awayTeam , String date) {
		this.homeTeam = homeTeam ;
		this.awayTeam = awayTeam ;
		this.date = date ;
	}
	// Methods
	public String toString() {
		return homeTeam + "(home)" + " vs " + awayTeam + "(away)" + " [" + date + "]" ;
	}
}

