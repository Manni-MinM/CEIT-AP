// BWOTSHEWCHB

import java.util.HashMap ;

/**
 * A class to hold information about the inventory
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Inventory {
	// Fields
	private HashMap<Product , Integer> inventory ;
	// Constructor
	/**
	 * Constructor Method - Creates Inventory Object
	 */
	public Inventory() {
		inventory = new HashMap<Product , Integer>() ;	
	}
	/**
         * Getter Method - Returns number of products in the inventory
         *
         * @return The size of the inventory
         */
        public int size() {
        	return inventory.keySet().size() ;
	}
	/**
	 * Getter Method - Returns the product with index $index from the HashMap
	 *
	 * @return The desired product 
	 */
	public Product getIndex(int index) {
		index -- ;
		int it = 0 ;
		if ( index < 0 || index >= inventory.keySet().size() )
			return null ;
		for ( Product item : inventory.keySet() ) {
			if ( it == index )
				return item ;
			it ++ ;
		}
		return null ;
	}
	/**
	 * Getter Method - Returns the count of the desired product
	 *
	 * @return Count of the desired product
	 */
	public int getCount(Product item) {
		if ( !inventory.keySet().contains(item) )
			return 0 ;
		return inventory.get(item) ;
	}
	/**
	 * Adds an item to the inventory
	 *
	 * @param item Item to be added to the inventory
	 */
	public void add(Product item) {
		if ( inventory.keySet().contains(item) )
			return ;
		inventory.put(item , 0) ;
	}
	/**
	 * Removes an item from the inventory
	 *
	 * @param item Item to be removed from the inventory
	 */
	public void remove(Product item) {
		if ( !inventory.keySet().contains(item) )
			return ;
		inventory.remove(item) ;
	}
	/**
	 * Changes count of an item in the inventory
	 *
	 * @param item Item which count should be changed
	 * @param count New count for the item
	 */
	public void stock(Product item , int count) {
		if ( count < 0 )
			return ;
		if ( !inventory.keySet().contains(item) )
			add(item) ;
		if ( count == 0 ) {
			remove(item) ;
			return ;
		}
		inventory.put(item , count) ;
	}
	/**
	 * Override Method - Converts all items in inventory to one String object
	 * 
	 * @return List of all products and their count
	 */
	@Override
	public String toString() {
		int it = 1 ; 
		String ret = "" ;
		for ( Product item : inventory.keySet() ) {
			ret += it + "){\n" + item.toString() + "}instock: " + inventory.get(item) + "\n" ;
			it ++ ;
		}
		return ret ;
	}
}

