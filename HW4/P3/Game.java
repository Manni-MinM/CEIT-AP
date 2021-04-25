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
		System.out.printf("Top Card is : %s\n" , topCard.toString()) ;
	}
	public void showPlayers() {
		System.out.println("Players : ") ;
		for ( Player player : players )
			System.out.println(player.getUsername()) ;
	}
	public void initDraw() {
		for ( Player player : players )
			for ( int it = 1 ; it <= 7 ; it ++ )
				player.getDeck().addCard(pile.drawTopCard()) ;
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
		showPlayers() ;
		showTopCard() ;
		// TODO
		for ( Player player : players )
			player.getDeck().show() ;
	}
}

