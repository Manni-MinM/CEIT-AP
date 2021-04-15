// BWOTSHEWCHB

import java.util.Scanner ;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		String line = input.nextLine() ;
		String[] lineSplit = line.split(" ") ;
		LinkedList list = new LinkedList() ;
		Stack stack = new Stack(lineSplit.length) ;
		for ( String element : lineSplit )
			list.add(Integer.parseInt(element)) ;
		for ( int i = 0 ; i < list.size() ; i ++ )
			stack.push(list.findIndex(i)) ;
		while ( !stack.isEmpty() ) {
			System.out.printf("%d " , stack.peek()) ;
			stack.pop() ;
		}
		System.out.println() ;
	}
}

