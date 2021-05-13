// BWOTSHEWCHB

import java.util.ArrayList ;

/**
 * A Class to hold details about the Follower
 * 
 * @author Manni Moghimi
 * @version v1.0
 */
public class Follower {
	// Fields
	private String firstName ;
	private String lastName ;
	private ArrayList<Newsletter> newsletters ;
	// Constructor
	/**
	 * Creates Follower Object
	 *
	 * @param firstName The name of the Follower
	 * @param lastName The Surename of the Follower
	 */
	public Follower(String firstName , String lastName) {
		this.firstName = firstName ;
		this.lastName = lastName ;
		newsletters = new ArrayList<Newsletter>() ;
	}
	// Methods
	/**
	 * Subscribes to a Newsletter
	 * 
	 * @param newsletter The Newsletter the Follower wants to subsribe to
	 */
	public void subscribe(Newsletter newsletter) {
		newsletter.addFollower(this) ;
	}
	/**
	 * Unsubscribes from a Newsletter
	 * 
	 * @param newsletter The Newsletter the Follower wants to Unsubsribe from
	 */
	public void unsubscribe(Newsletter newsletter) {
		newsletter.removeFollower(this) ;
	}
	/**
	 * Converts Follower Object to String format
	 *
	 * @return The Follower in String format
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName ;
	}
	/**
	 * Checks if two Follower Objects are equal
	 *
	 * @param object the Object to be Checked
	 * @return True if Objects are equal otherwise False
	 */
	@Override
	public boolean equals(Object object) {
		if ( !(object instanceof Follower) )
			return false ;
		if ( object == this )
			return true ;
		Follower follower = (Follower)object ;
		return follower.toString().equals(this.toString()) ;
	}
	/**
	 * Updates Feed of Follower with new Post
	 *
	 * @param post The Post to be added to the feed
	 */
	public void update(Post post) {
		System.out.println("New Post For " + firstName + " " + lastName + " :") ;
		System.out.println(post.toString()) ;
		System.out.println() ;
	}
}

