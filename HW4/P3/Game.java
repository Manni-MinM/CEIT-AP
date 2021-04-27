// BWOTSHEWCHB

import java.util.Scanner ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.concurrent.TimeUnit ;

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
	public void clearScreen(int seconds) {
		if ( seconds == 0 ) {
			System.out.print("\033[H\033[2J") ;
			return ;
		}
		try {
			TimeUnit.SECONDS.sleep(seconds) ;
		} catch (Exception exception) {
			
		}
		System.out.print("\033[H\033[2J") ;
	}
	public void showTopCard() {
		ArrayList<String> lines = topCard.stringed() ;
		for ( String line : lines )
			System.out.println(line) ;
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
	public void startSingleplayer() {
		// Get info
		clearScreen(0) ;
		System.out.print("\u001B[36m" + "Enter The Number Of Players : " + "\u001B[0m") ;
		playerCount = input.nextInt() ;
		String trash = input.nextLine() ;
		System.out.print("\u001B[36m" + "Enter Your Username : " + "\u001B[0m") ;
		String username = input.nextLine() ;
		// Build game
		pile = new Pile() ;
		players.add(new Human(username)) ;
		for ( int it = 1 ; it <= playerCount - 1 ; it ++ )
			players.add(new Bot("Bot " + it)) ;
		initDraw() ;
		topCard = pile.drawTopCard() ;
		clearScreen(3) ;
	}
	public void startMultiplayer() {
		// Get info
		clearScreen(0) ;
		System.out.print("\u001B[36m" + "Enter The Number Of Players : " + "\u001B[36m") ;
		playerCount = input.nextInt() ;
		String trash = input.nextLine() ;
		// Build game
		pile = new Pile() ;
		for ( int it = 1 ; it <= playerCount ; it ++ ) {
			System.out.print("\u001B[36m" + "Username : " + "\u001B[0m") ;
			String username = input.nextLine() ;
			players.add(new Human(username)) ;
		}
		initDraw() ;
		topCard = pile.drawTopCard() ;
		clearScreen(3) ;
	}
	public void run() {
		// Index of player who should play a card
		int turn = 0 ;
		// 1 : clockwise | -1 : anticlockwise
		int direction = 1 ;
		while ( !playerWithNoCardsExists() ) {
			Player targetPlayer = players.get(turn) ;
			System.out.println("\u001B[36m" + targetPlayer.getUsername() + "'s Turn" + "\u001B[0m") ;
			showTopCard() ;
			System.out.println("\u001B[36m" + targetPlayer.getUsername() + "'s Deck" + "\u001B[0m") ;
			// if ( targetPlayer instanceof Human )
			targetPlayer.show() ;
			Card targetCard = targetPlayer.playCard(topCard) ;
			if ( targetCard == null ) {
				Card secondCard = pile.drawTopCard() ;
				targetPlayer.getDeck().addCard(secondCard) ;
				if ( topCard.isValid(secondCard) ) {
					// Pass
				}
				else {
					turn = (turn + direction + playerCount) % (playerCount) ;
					System.out.println("\u001B[33m" + "No Avaliable Moves : [TURN PASSED]" + "\u001B[0m") ;
				}
			}
			else {
				pile.addCard(topCard) ;
				topCard = targetCard ;
				Player nextPlayer = players.get((turn + direction + playerCount) % (playerCount)) ;
				if ( targetCard instanceof NormalCard ) {
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
				else if ( targetCard instanceof ForceCard ) {
					Card actionCard = targetPlayer.playCard(null) ;
					nextPlayer.getDeck().addCard(actionCard) ;
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
				else if ( targetCard instanceof DrawFourCard ) {
					for ( int it = 1 ; it <= 4 ; it ++ )
						nextPlayer.getDeck().addCard(pile.drawTopCard()) ;
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
				else if ( targetCard instanceof DrawTwoCard ) {
					for ( int it = 1 ; it <= 2 ; it ++ )
						nextPlayer.getDeck().addCard(pile.drawTopCard()) ;
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
				else if ( targetCard instanceof PrizeCard ) {
					// Pass
				}
				else if ( targetCard instanceof ReverseCard ) {
					direction = -1 ;
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
				else if ( targetCard instanceof SkipCard ) {
					turn = (turn + 2 * direction + playerCount) % (playerCount) ;
				}
				else if ( targetCard instanceof WildCard ) {
					String targetColor = targetPlayer.getWildCardColor() ;
					Card colorChanger = new NormalCard("NULL" , targetColor) ;
					pile.addCard(topCard) ;
					topCard = colorChanger ;
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
			}
			if ( targetPlayer instanceof Bot )
				clearScreen(5) ;
			else
				clearScreen(1) ;
		}
	}
	public void end() {
		for ( Player player : players )
			player.calculatePoint() ;
		Collections.sort(players , new Player.Compare()) ;
		System.out.println("SCOREBOARD : ") ;
		int it = 1 ;
		for ( Player player : players ) {
			System.out.println(it + ") " + player.getUsername()) ;
			it ++ ;
		}
		clearScreen(10) ;
	}
}

