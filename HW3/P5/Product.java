// BWOTSHEWCHB

import java.time.LocalDate ;
import java.time.format.DateTimeFormatter ;

/**
 * A class to hold information about each product
 * 
 * @author Manni Moghimi
 * @version v1.0
 */
public final class Product {
	// Fields
	private final String name ;
	private final String category ;
	private final int weight ;
	private final double price ;
	private final LocalDate proDate ;
	private final LocalDate expDate ;
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
	public Product(String name , String category , int weight , double price , LocalDate proDate , LocalDate expDate) {
		this.name = name ;
		this.category = category ;
		this.weight = weight ;
		this.price = price ;
		this.proDate = proDate ;
		this.expDate = expDate ;
	}
	// Methods
	/**
	 * Returns the price of the product
	 *
	 * @return Price of the product
	 */
	public double getPrice() {
		return price ;
	}
	/**
	 * Override Method - Converts Prodcut to String format
	 *
	 * @return Product full details
	 */
	@Override
	public String toString() {
		return "\t\"Product\": {\n" +
			"\t\t\"NAME: \"" + name + ",\n" +
			"\t\t\"CATEGORY: \"" + category + ",\n" +
			"\t\t\"WEIGHT: \"" + weight + ",\n" +
			"\t\t\"PRICE: \"" + price + ",\n" +
			"\t\t\"MANUFACTURE_DATE: \"" + proDate.toString() + ",\n" +
			"\t\t\"EXPIRATION_DATE: \"" + expDate.toString() + "\n" +
			"\t}\n" ;
	}
	/**
	 * Override Method - Checks if two Product objects are equal
	 *
	 * @param object The object to be checked
	 */
	@Override
	public boolean equals(Object object) {
		if ( !(object instanceof Product) )
			return false ;
		if ( object == this )
			return true ;
		Product ProductObject = (Product)object ;
		return this.toString().equals(ProductObject.toString()) ;
	}
}

