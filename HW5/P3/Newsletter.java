// BWOTSHEWCHB

import java.util.ArrayList ;

public class Newsletter {
	// Fields
	int newPosts ;
	private ArrayList<Post> posts ;
	private ArrayList<Follower> followers ;
	// Constructor
	public Newsletter() {
		newPosts = 0 ;
		posts = new ArrayList<Post>() ;
		followers = new ArrayList<Follower>() ;
	}
	// Methods
	public void addPost(String title , String context) {
		Post post = new Post(title , context) ;
		if ( posts.contains(post) )
			return ;
		posts.add(post) ;
	}
	public void addFollower(Follower follower) {
		if ( followers.contains(follower) ) {
			System.out.println("You Have Already Followed This Newsletter !") ;
			return ;
		}
		followers.add(follower) ;
	}
	public void removeFollower(Follower follower) {
		if ( !followers.contain(follower) ) {
			System.out.println("You Cannot Unfollow A Newsletter You Havent Followed !") ;
			return ;
		}
		followers.remove(follower) ;
	}
	public void notifyFollowers() {
		// TODO
	}
}

