// BWOTSHECHB

import java.util.Scanner ;
import java.util.HashMap ;

/**
 * Main class
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Main {
	// Fields
	public static Scanner input ;
	public static Basket basket ;
	public static Inventory inventory ;
	// Main Method
	/**
	 * Main method
	 *
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		basket = new Basket() ;
		inventory = new Inventory() ;
		input = new Scanner(System.in) ;
		// Create the products
		Product carrot = new Product("Carrot" , "Vegetables" , 5 , 20f , "15-03-2020" , "15-03-2021") ;
		Product apple = new Product("Apple" , "Fruits" , 10 , 50f , "01-04-2020" , "01-08-2020") ;
		Product eggs12x = new Product("12xEggs" , "Egg" , 100 , 40f , "01-01-2020" , "01-06-2020") ;
		Product oats = new Product("Oats" , "Grains" , 70 , 100f , "01-06-2020" , "01-01-2021") ;
		Product salmon = new Product("Salmon" , "Seafood" , 150 , 250f , "01-01-2020" , "01-02-2020") ;
		Product stake = new Product("Stake" , "Meat" , 800 , 1000f , "01-03-2020" , "01-09-2020") ;
		Product milk = new Product("Milk" , "Dairy" , 100 , 20f , "10-01-2020" , "25-01-2020") ;
		Product cheese = new Product("Cheese" , "Dairy" , 150 , 10f , "01-02-2020" , "15-03-2020") ;
		// Add products to inventory
		inventory.stock(carrot , 10) ;
		inventory.stock(apple , 20) ;
		inventory.stock(eggs12x , 50) ;
		inventory.stock(oats , 45) ;
		inventory.stock(salmon , 5) ;
		inventory.stock(stake , 5) ;
		inventory.stock(milk , 20) ;
		inventory.stock(cheese , 50) ;
		// Roll the menu
		while ( true ) {
			System.out.print("input{products , add , remove , cart , checkout} : ") ;
			String line = input.nextLine() ;
			String[] lineSplit = line.split(" ") ;
			if ( lineSplit[0].equals("products") )
				products() ;
			else if ( lineSplit[0].equals("add") )
				add(Integer.parseInt(lineSplit[1])) ;
			else if ( lineSplit[0].equals("remove") )
				remove(Integer.parseInt(lineSplit[1])) ;
			else if ( lineSplit[0].equals("cart") )
				cart() ;
			else if ( lineSplit[0].equals("checkout") ) {
				checkout() ;
				break ;
			}
			else
				handleMenuException() ;
			System.out.println() ;
		}
	}
	// Methods
	/**
	 * Displays all products avaliable in the inventory
	 */
	public static void products() {
		if ( inventory.size() == 0 ) {
			System.out.println("We are out of stock.") ;
			return ;
		}
		System.out.println(inventory.toString()) ;	
	}
	/**
	 * Adds an item to the customers basket
	 *
	 * @param index Index of the product to be added
	 */
	public static void add(int index) {
		if ( index <= 0 || index > inventory.size() ) {
			System.out.println("[INVALID INDEX]") ;
			return ;
		}
		Product item = inventory.getIndex(index) ;
		basket.add(item) ;
		inventory.stock(item , inventory.getCount(item) - 1) ;
	}
	/**
	 * Removes an item from the customers basket
	 *
	 * @param index Index of the product to be removed
	 */
	public static void remove(int index) {
		if ( index <= 0 || index > basket.size() ) {
			System.out.println("[INVALID INDEX]") ;
			return ;
		}
		Product item = basket.getIndex(index) ;
		basket.remove(item) ;
		inventory.stock(item , inventory.getCount(item) + 1) ;
	}
	/**
	 * Displays all products avaliable in the customers cart
	 */
	public static void cart() {
		if ( basket.size() == 0 ) {
			System.out.println("Cart is empty.") ;
			return ;
		}
		System.out.println(basket.toString()) ;
	}
	/**
	 * Customer checkout
	 */
	public static void checkout() {
		System.out.printf("Your total : %f\n" , basket.getTotal()) ;
		System.out.println("It was a pleasure doing business with you.") ;
	}
	/**
	 * Displays an error message if user input command was invalid
	 */
	public static void handleMenuException() {
		System.out.println("[INVALID COMMAND]") ;
	}
}

