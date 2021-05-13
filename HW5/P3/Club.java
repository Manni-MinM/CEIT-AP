// BWOTHSHEWCHB

import java.util.ArrayList ;

/**
 * A Class to hold details about the Club
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Club {
	// Fields
	private Newsletter clubNews ;
	private Newsletter matchdayNews ;
	private Newsletter playerNews ;
	private ArrayList<Match> fixtures ;
	private ArrayList<Player> players ;
	// Constructor
	/**
	 * Creates Club Object
	 */
	public Club() {
		clubNews = new Newsletter() ;
		matchdayNews = new Newsletter() ;
		playerNews = new Newsletter() ;
		fixtures = new ArrayList<Match>() ;
		players = new ArrayList<Player>() ;
	}
	// Methods
	/**
	 * Returns the Club-News Newsletter
	 *
	 * @return Club-News Newsletter
	 */
	public Newsletter clubNews() {
		return clubNews ;
	}
	/**
	 * Returns the MatchDay-News Newsletter
	 *
	 * @return MatchDay-News Newsletter
	 */
	public Newsletter matchdayNews() {
		return matchdayNews ;
	}
	/**
	 * Returns the Player-News Newsletter
	 *
	 * @return Player-News Newsletter
	 */
	public Newsletter playerNews() {
		return playerNews ;
	}
	/**
	 * Adds a Player to the Club
	 *
	 * @param player The Player to be added to the Club
	 */
	public void addPlayer(Player player) {
		if ( players.contains(player) ) {
			System.out.println("Players Already Exists in Club !") ;
			return ;
		}
		players.add(player) ;
		Post newPost = new Post("Player Joined Your Club !" , "The Following Player Has Joined Your Club :\n" + player.toString()) ;
		playerNews.notifyFollowers(newPost) ;
	}
	/**
	 * Adds a Match to the Club
	 *
	 * @param match The Match to be added to the Club
	 */
	public void addMatch(Match match) {
		if ( fixtures.contains(match) ) {
			System.out.println("Match Already Exists !") ;
			return ;	
		}
		fixtures.add(match) ;
		Post newPost = new Post("New Fixture For Your Club !" , "The Following Match Has Been Added :\n" + match.toString()) ;
		matchdayNews.notifyFollowers(newPost) ;
	}
	/**
	 * Adds News to the Club
	 *
	 * @param title The title of the News
	 * @param context The context of the News
	 */
	public void addNews(String title , String context) {
		Post newPost = new Post(title , context) ;
		clubNews.notifyFollowers(newPost) ;
	}
}

