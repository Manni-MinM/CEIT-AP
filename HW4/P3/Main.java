// BWOTSHEWCHB

import java.util.Scanner ;
import java.util.concurrent.TimeUnit ;

public class Main {
	public static void main(String[] args) {
		Game game = new Game() ;
		Scanner input = new Scanner(System.in) ;	
		while ( true ) {
			clearScreen(0) ;
			showMenu() ;
			System.out.print("\u001B[36m" + "Command : " + "\u001B[0m") ;
			String line = input.nextLine() ;
			if ( line.equals("Play With Bots") ) {
				game.startSingleplayer() ;
				game.run() ;
				game.end() ;
			}
			else if ( line.equals("Play With Friends") ) {
				game.startMultiplayer() ;
				game.run() ;
				game.end() ;
			}
			else if ( line.equals("Exit") )
				break ;
			else
				handleMenuException() ;
		}
	}
	public static void clearScreen(int seconds) {
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
	public static void showMenu() {
		System.out.print("\u001B[36m") ;
		System.out.println("Play With Bots") ;
		System.out.println("Play With Friends") ;
		System.out.println("Exit") ;
		System.out.println("\u001B[0m") ;
	}
	public static void handleMenuException() {
		System.out.println("[Command Not Found]") ;
	}
}

/*
TODO :
	add more visuals and get better input
	**ADD JAVADOC**
*/
