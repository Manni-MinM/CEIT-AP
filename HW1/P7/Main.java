import java.util.Scanner ;

public class Main {
	public static String change(String str , char first , char second) {
		String result = "" ;
		char[] arr = str.toCharArray() ;
		for ( int i = 0 ; i < arr.length ; i ++ ) {
			if ( arr[i] == first )
				arr[i] = second ;
			result += arr[i] ;
		}
		return result ;
	}
	public static boolean checkInsert(String str , String rts) {
		boolean result = false ;
		if ( rts.length() - str.length() == 1 )
			for ( int i = 0 ; i < rts.length() ; i ++ ) {
				String cur = "" ;
				for ( int j = 0 ; j < rts.length() ; j ++ )
					if ( i != j )
						cur += rts.charAt(j) ;
				if ( str.equals(cur) )
					result = true ;
			}
		return result ;
	}
	public static boolean checkDelete(String str , String rts) {
		boolean result = false ;
		if ( str.length() - rts.length() == 1 )
			for ( int i = 0 ; i < str.length() ; i ++ ) {
				String cur = "" ;
				for ( int j = 0 ; j < str.length() ; j ++ )
					if ( i != j )
						cur += str.charAt(j) ;
				if ( rts.equals(cur) )
					result = true ;
			}
		return result ;
	}
	public static boolean checkChange(String str , String rts) {
		boolean result = false ;
		if ( str.equals(rts) )
			{ return result ; }
		for ( char fi = 'a' ; fi <= 'z' ; fi ++ )
			for ( char se = 'a' ; se <= 'z' ; se ++ ) {
				if ( fi != se ) {
					String cur = change(str , fi , se) ;
					if ( rts.equals(cur) )
						result = true ;
				}
			}
		return result ;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		String str = input.nextLine() ;
		String rts = input.nextLine() ;
		
		boolean result = checkInsert(str , rts) | checkDelete(str , rts) | checkChange(str , rts) ;
		if ( result )
			System.out.println("True") ;
		else
			System.out.println("False") ;
	}
}
