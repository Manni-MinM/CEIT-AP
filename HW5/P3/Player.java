// BWOTSHEWCHB

/**
 * A Class to hold details about Players
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Player {
	// Fields
	private String firstName ;
	private String lastName ;
	private String id ;
	private int age ;
	// Constructor
	/**
	 * Creates player Object
	 *
	 * @param firstName The name of the Player
	 * @param lastName The surename of the Player
	 * @param id The id of the Player
	 * @param age The age of the Player
	 */
	public Player(String firstName , String lastName , String id , int age) {
		this.firstName = firstName ;
		this.lastName = lastName ;
		this.id = id ;
		this.age = age ;
	}
	// Methods
	/**
	 * Converts Player Object to String format
	 *
	 * @return The Player in String format
	 */
	@Override
	public String toString() {
		return "FullName : " + firstName + " " + lastName + "\n" + 
			"ID : " + id + "\n" +
			"Age : " + age ;
	}
}

