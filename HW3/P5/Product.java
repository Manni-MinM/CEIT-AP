// BWOTSHEWCHB

import java.util.Date ;

/**
 * A class to hold information about each product
 * 
 * @author Manni Moghimi
 * @version v1.0
 */
public final class Product {
	// Fields
	private String name ;
	private String category ;
	private int weight ;
	private double price ;
	private Date proDate ;
	private Date expDate ;
	// Constructor
	/**
	 * Constructor Method - Creates Product Object
	 *
	 * @param name Name of the product
	 * @param category Category of the specified product
	 * @param weight Weight of the product
	 * @param price Price of the product
	 * @param proDate Production date of the product
	 * @param expDate Expiration date of the product 
	 */
	public Product(String name , String catergory , int weight , double price , Date proDate , Date expDate) {
		this.name = name ;
		this.category = category ;
		this.weight = weight ;
		this.price = price ;
		this.proDate = proDate ;
		this.expDate = expDate ;
	}
	// Methods
	/**
	 * Override Method - Converts Prodcut to String format
	 *
	 * @return Product full details
	 */
	@Override
	public String toString() {
		return name + " " + category + " " + weight + " " + price + " " + proDate + " " + expDate ;
	}
}
