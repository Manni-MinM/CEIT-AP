// BWOTSHEWCHB

import java.util.ArrayList ;

public class Newsletter {
	// Fields
	private ArrayList<Follower> followers ;
	// Constructor
	public Newsletter() {
		followers = new ArrayList<Follower>() ;
	}
	// Methods
	public void addFollower(Follower follower) {
		if ( followers.contains(follower) ) {
			System.out.println("[Newsletter] : You Have Already Followed This Newsletter !") ;
			return ;
		}
		followers.add(follower) ;
	}
	public void removeFollower(Follower follower) {
		if ( !followers.contains(follower) ) {
			System.out.println("[Newsletter] : You Cannot Unfollow A Newsletter You Havent Followed !") ;
			return ;
		}
		followers.remove(follower) ;
	}
	public void notifyFollowers(Post post) {
		for ( Follower follower : followers )
			follower.update(post) ;
	}
}

