// BWOTSHEWCHB

import java.util.Scanner ;

public class Main {
	public static void main(String[] args) {
		Game game = new Game() ;
		Scanner input = new Scanner(System.in) ;
		
		showMenu() ;
		while ( true ) {
			String line = input.nextLine() ;
			if ( line.equals("Play With Bots") ) {
				// TODO
			}
			else if ( line.equals("Play With Friends") ) {
				game.start() ;
				game.run() ;
			}
			else if ( line.equals("Exit") )
				break ;
			else
				handleMenuException() ;
		}
	}
	public static void showMenu() {
		System.out.println("Play With Bots") ;
		System.out.println("Play With Friends") ;
		System.out.println("Exit") ;
	}
	public static void handleMenuException() {
		System.out.println("[Command Not Found]") ;
	}
}

