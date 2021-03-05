import java.util.Scanner ;

public class Main {
	public static String reverse(String str) {
		String result = "" ;
		for ( int i = 0 ; i < str.length() ; i ++ )
			result += str.charAt(str.length() - i - 1) ;
		return result ;
	}
	public static int binaryToInt(String binary) {
		int result = 0 ;
		binary = reverse(binary) ;
		for ( int i = 0 ; i < binary.length() ; i ++ )
			if ( binary.charAt(i) == '1' )
				result += (1 << i) ;
		return result ;	
	}
	public static String intToBinary(int val) {
		String result = "" ;
		while ( val != 0 ) {
			if ( (val & 1) == 0 )
				result += '0' ;
			else
				result += '1' ;
			val /= 2 ;
		}
		result = reverse(result) ;
		return result ;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		String key = input.nextLine() ;
		String text = input.nextLine() ;
	
		int keyInt = binaryToInt(key) ;
		
		for ( int i = 0 ; i < text.length() ; i ++ ) {
			int ascii = (int)text.charAt(i) ;
			String result = intToBinary(keyInt ^ ascii) ;
			System.out.printf("%s " , result) ;
		}
		System.out.printf("\n") ;
	}
}
