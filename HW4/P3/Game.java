// BWOTSHEWCHB

import java.util.Scanner ;
import java.util.ArrayList ;

public class Game {
	// Fields
	private Pile pile ;
	private Card topCard ;
	private Scanner input ;
	private int playerCount ;
	private ArrayList<Player> players ;
	// Constructor
	public Game() {
		playerCount = 0 ;
		pile = new Pile() ;
		input = new Scanner(System.in) ;
		players = new ArrayList<Player>() ;
	}
	// Methods
	public void showTopCard() {
		System.out.println("Top Card is  : " + topCard.toString()) ;
		System.out.println() ;
	}
	public void showPlayers() {
		for ( Player player : players )
			player.show() ;
	}
	public void initDraw() {
		for ( Player player : players )
			for ( int it = 1 ; it <= 7 ; it ++ )
				player.getDeck().addCard(pile.drawTopCard()) ;
	}
	public boolean playerWithNoCardsExists() {
		boolean found = false ;
		for ( Player player : players )
			if ( player.getDeck().size() == 0 )
				found = true ;
		return found ;
	}
	public void start() {
		// Get info
		System.out.print("Enter The Number Of Players : ") ;
		playerCount = input.nextInt() ;
		String trash = input.nextLine() ;
		// Build game
		pile = new Pile() ;
		for ( int it = 1 ; it <= playerCount ; it ++ ) {
			String username = input.nextLine() ;
			players.add(new Human(username)) ;
		}
		initDraw() ;
		topCard = pile.drawTopCard() ;
	}
	public void run() {
		// Index of player who should play a card
		int turn = 0 ;
		// 1 : clockwise | -1 : anticlockwise
		int direction = 1 ;
		while ( !playerWithNoCardsExists() ) {
			System.out.println(players.get(turn).getUsername() + "'s Turn") ;
			showTopCard() ;
			showPlayers() ;
			Player targetPlayer = players.get(turn) ;
			Card targetCard = targetPlayer.playTurn(topCard) ;
			if ( targetCard == null )
				targetPlayer.getDeck().addCard(pile.drawTopCard()) ;
			else {
				pile.addCard(topCard) ;
				targetPlayer.getDeck().removeCard(targetCard) ;
				topCard = targetCard ;
			}
			turn = (turn + direction) % (playerCount - 1) ;
			// TODO : Add feature cards to game
		}
	}
}

