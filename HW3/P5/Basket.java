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
	private ArrayList<Product> cart ;
	// Constructor
	/**
	 * Constructor Method - Creates Basket Object
	 */
	public Basket() {
		cart = new ArrayList<Product>() ;
	}
	// Methods
	/**
	 * Getter Method - Returns the product with index $index from the ArrayList
	 *
	 * @return The desired product
	 */
	public Product getIndex(int index) {
		index -- ;
		int it = 0 ;
		if ( index < 0 || index >= cart.size() )
			return null ;
		for ( Product item : cart ) {
			if ( it == index )
				return item ;
			it ++ ;
		}
		return null ;
	}
	/**
	 * Getter Method - Returns number of products in the inventory
	 *
	 * @return The size of the inventory
	 */
	public int size() {
		return cart.size() ;
	}
	/**
	 * Adds an item to the Basket
	 *
	 * @param item Item to be added the Basket
	 */
	public void add(Product item) {
		cart.add(item) ;
	}
	/**
	 * Removes an item from the Basket
	 *
	 * @param item Item to be removed from the Basket
	 */
	public void remove(Product item) {
		if ( !cart.contains(item) )
			return ;
		cart.remove(item) ;
	}
	/**
	 * Calculates the total amount
	 *
	 * @return total amount to be paid at checkout
	 */
	public double getTotal() {
		double total = 0f ;
		for ( Product item : cart )
			total += item.getPrice() ;
		return total ;
	}
	/**
	 * Override Method - Converts all items in inventory to one String object
	 *
	 * @return List of all products and their count
	 */
	@Override
	public String toString() {
		int it = 1 ;
		String ret = "Itemsincart:\n" ;
		for ( Product item : cart ) {
			ret += it + "){\n" + item.toString() + "}\n" ;
			it ++ ;
		}
		return ret ;
	}
}

