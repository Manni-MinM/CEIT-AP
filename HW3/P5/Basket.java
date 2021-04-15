// BWOTSHEWCHB

import java.util.ArrayList ;

/**
 * A class to hold information about the users basket
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Basket {
	// Fields
	private ArrayList<Product> list ;
	// Constructor
	/**
	 * Constructor Method - Creates Basket Object
	 */
	public Basket() {
		list = new ArrayList<Product>() ;
	}
	// Methods
	/**
	 * Adds an item to the Basket
	 *
	 * @param item Item to be added the Basket
	 */
	public void add(Product item) {
		list.add(item) ;
	}
	/**
	 * Removes an item from the Basket
	 *
	 * @param item Item to be removed from the Basket
	 */
	public void remove(Product item) {
		if ( !list.contains(item) )
			return ;
		list.remove(item) ;
	}
	/**
	 * Calculates the total amount
	 *
	 * @return total amount to be paid at checkout
	 */
	public double getTotal() {
		double total = 0f ;
		for ( Product item : list )
			total += item.getPrice() ;
		return total ;
	}
}

