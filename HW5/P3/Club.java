// BWOTHSHEWCHB

import java.util.ArrayList ;

public class Club {
	// Fields
	private Newsletter clubNews ;
	private Newsletter matchdayNews ;
	private Newsletter playerNews ;
	private ArrayList<Match> fixtures ;
	private ArrayList<Player> players ;
	// Constructor
	public Club() {
		clubNews = new Newsletter() ;
		matchdayNews = new Newsletter() ;
		playerNews = new Newsletter() ;
		fixtures = new ArrayList<Match>() ;
		players = new ArrayList<Player>() ;
	}
	// Methods
	public Newsletter clubNews() {
		return clubNews ;
	}
	public Newsletter matchdayNews() {
		return matchdayNews ;
	}
	public Newsletter playerNews() {
		return playerNews ;
	}
	public void addPlayer(Player player) {
		if ( players.contains(player) ) {
			System.out.println("Players Already Exists in Club !") ;
			return ;
		}
		players.add(player) ;
		Post newPost = new Post("Player Joined Your Club !" , "The Following Player Has Joined Your Club :\n" + player.toString()) ;
		playerNews.notifyFollowers(newPost) ;
	}
	public void addMatch(Match match) {
		if ( fixtures.contains(match) ) {
			System.out.println("Match Already Exists !") ;
			return ;	
		}
		fixtures.add(match) ;
		Post newPost = new Post("New Fixture For Your Club !" , "The Following Match Has Been Added :\n" + match.toString()) ;
		matchdayNews.notifyFollowers(newPost) ;
	}
	public void addNews(String title , String context) {
		Post newPost = new Post(title , context) ;
		clubNews.notifyFollowers(newPost) ;
	}
}

