import java.util.Scanner ;

class Complex {
	// Private attributes
	private double real ;
	private double img ;
	// Constructor
	public Complex(double first , double second) {
		real = first ;
		img = second ;
	}
	// Getter
	public double getReal()
		{ return real ; }
	// Getter
	public double getImaginary()
		{ return img ; }
	// Prints the result
	public void printResult() {
		if ( real >= 0 ) {
			if ( img >= 0 )
				{ System.out.printf("%f+%fi\n" , real , img) ; }
			else
				{ System.out.printf("%f%fi\n" , real , img) ; }
		}
		else {
			if ( img >= 0 )
				{ System.out.printf("%f+%fi\n" , real , img) ; }
			else
				{ System.out.printf("%f%fi\n" , real , img) ; }
		}
		return ;
	}
	// Addition
	public static Complex add(Complex first , Complex second) {
		Complex result = new Complex(0 , 0) ;
		result.real = first.real + second.real ;
		result.img = first.img + second.img ;
		return result ;
	}
	// Multiplication
	public static Complex multiply(Complex first , Complex second) {
		Complex result = new Complex(0 , 0) ;
		result.real = (first.real * second.real) - (first.img * second.img) ;
		result.img = (first.real * second.img) + (first.img * second.real) ;
		return result ;
	}
	// Subtraction
	public static Complex subtract(Complex first , Complex second) {
		Complex result = new Complex(0 , 0) ;
		result.real = first.real - second.real ;
		result.img = first.img - second.img ;
		return result ;
	}
	// Division
	public static Complex divide(Complex first , Complex second) {
		Complex result = new Complex(0 , 0) ;
		result.real = ((first.real * second.real) + (first.img * second.img)) / ((second.real * second.real) + (second.img * second.img)) ;
		result.img = ((first.img * second.real) - (first.real * second.img)) / ((second.real * second.real) + (second.img * second.img)) ;
		return result ;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;

		double firstA = input.nextDouble() ;
		double firstB = input.nextDouble() ;
		
		double secondA = input.nextDouble() ;
		double secondB = input.nextDouble() ;
		
		Complex first = new Complex(firstA , firstB) ;
		Complex second = new Complex(secondA , secondB) ;
		
		char condition ;
	 	Complex result = new Complex(0 , 0) ;
		
		while ( true ) {
			condition = input.next().charAt(0) ;
			if ( condition == '#' )
				{ break ; }
			else if ( condition == '+' ) {
				result = Complex.add(first , second) ;
				result.printResult() ;
			}
			else if ( condition == '*' ) {
				result = Complex.multiply(first , second) ;
				result.printResult() ;
			}
			else if ( condition == '-' ) {
				result = Complex.subtract(first , second) ;
				result.printResult() ;
			}
			else if ( condition == '/' ) {
				result = Complex.divide(first , second) ;
				result.printResult() ;
			}
		}
	}
}
