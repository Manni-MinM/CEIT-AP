// BWOTSHEWCHB

import java.util.ArrayList ;

/**
 * A Class to hold details about the Newsletter
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Newsletter {
	// Fields
	private ArrayList<Follower> followers ;
	// Constructor
	/**
	 * Creates Newsletter Object
	 */
	public Newsletter() {
		followers = new ArrayList<Follower>() ;
	}
	// Methods
	/**
	 * Adds a Follower to the Newsletter
	 * 
	 * @param follower The Follower to be added to the Newsletter
	 */
	public void addFollower(Follower follower) {
		if ( followers.contains(follower) ) {
			System.out.println("[Newsletter] : You Have Already Followed This Newsletter !") ;
			System.out.println() ;
			return ;
		}
		followers.add(follower) ;
	}
	/**
	 * Removes a Follower from the Newsletter
	 * 
	 * @param follower The Follower to be remove from the Newsletter
	 */
	public void removeFollower(Follower follower) {
		if ( !followers.contains(follower) ) {
			System.out.println("[Newsletter] : You Cannot Unfollow A Newsletter You Havent Followed !") ;
			System.out.println() ;
			return ;
		}
		followers.remove(follower) ;
	}
	/**
	 * Notifies all Subscribers of the Newsletter of a new Post
	 *
	 * @param post The post to be showed to the Followers
	 */
	public void notifyFollowers(Post post) {
		for ( Follower follower : followers )
			follower.update(post) ;
	}
}

