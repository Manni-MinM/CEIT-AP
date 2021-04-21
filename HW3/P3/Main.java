// BWOTSHEWCHB

import java.util.Scanner ;

/**
 * Main Class
 */
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		String line = input.nextLine() ;
		String[] lineSplit = line.split(" ") ;
		LinkedList list = new LinkedList() ;
		Stack stack = new Stack(lineSplit.length) ;
		for ( String element : lineSplit )
			list.add(Integer.parseInt(element)) ;
		int size = list.size() ;
		for ( int i = 0 ; i < size ; i ++ ) {
			stack.push(list.findIndex(0)) ;
			list.removeIndex(0) ;
		}
		while ( !stack.isEmpty() ) {
			list.add(stack.peek()) ;
			stack.pop() ;
		}
		list.print() ;
	}
}

