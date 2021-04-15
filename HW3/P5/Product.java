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
	public Product(String name , String category , int weight , double price , String proDate , String expDate) {
		this.name = name ;
		this.category = category ;
		this.weight = weight ;
		this.price = price ;
		this.proDate = LocalDate.parse(proDate , DateTimeFormatter.ofPattern("dd-MM-yyyy")) ;
		this.expDate = LocalDate.parse(expDate , DateTimeFormatter.ofPattern("dd-MM-yyyy")) ;
	}
	// Methods
	/**
	 * Returns the name of the product
	 *
	 * @return Name of the product
	 */
	public String getName() {
		return name ;
	}
	/**
	 * Returns the category of the product
	 *
	 * @return Category of the product
	 */
	public String getCategory() {
		return category ;
	}
	/**
	 * Returns the weight of the product
	 *
	 * @return Weight of the product
	 */
	public int getWeight() {
		return weight ;
	}
	/**
	 * Returns the price of the product
	 *
	 * @return Price of the product
	 */
	public double getPrice() {
		return price ;
	}
	/**
	 * Returns the production date of the product
	 *
	 * @return Production date of the product
	 */
	public String getProDate() {
		return proDate.toString() ;
	}
	/**
	 * Returns the expiration date of the product
	 *
	 * @return Expiration date of the product
	 */
	public String getExpdate() {
		return expDate.toString() ;
	}
	/**
	 * Override Method - Converts Prodcut to String format
	 *
	 * @return Product full details
	 */
	@Override
	public String toString() {
		return name + " " + category + " " + weight + " " + price + " " + proDate.toString() + " " + expDate.toString() ;
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

