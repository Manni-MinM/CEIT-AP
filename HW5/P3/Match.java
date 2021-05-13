// BWOTSHEWCHB

/**
 * A Class to hold information about Matches
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Match {
	// Fields
	private String homeTeam ;
	private String awayTeam ;
	private String date ;
	// Constructor
	/**
	 * Creates Match Object
	 *
	 * @param homeTeam The home Team
	 * @param awayTeam The away Team
	 * @param date The date the game will take place on
	 */
	public Match(String homeTeam , String awayTeam , String date) {
		this.homeTeam = homeTeam ;
		this.awayTeam = awayTeam ;
		this.date = date ;
	}
	// Methods
	/**
	 * Converts Match Object to String format
	 *
	 * @return The Match in String format
	 */
	@Override
	public String toString() {
		return homeTeam + "(home)" + " vs " + awayTeam + "(away)" + " [" + date + "]" ;
	}
}

