// BWOTSHEWCHB

import java.util.ArrayList ;

public class Follower {
	// Fields
	private String firstName ;
	private String lastName ;
	private ArrayList<Newsletter> newsletters ;
	// Constructor
	public Follower(String firstName , String lastName) {
		this.firstName = firstName ;
		this.lastName = lastName ;
		newsletters = new ArrayList<Newsletter>() ;
	}
	// Methods
	public void subscribe(Newsletter newsletter) {
		newsletter.addFollower(this) ;
	}
	public void unsubscribe(Newsletter newsletter) {
		newsletter.removeFollower(this) ;
	}
	@Override
	public String toString() {
		return firstName + " " + lastName ;
	}
	@Override
	public boolean equals(Object object) {
		if ( !(object instanceof Follower) )
			return false ;
		if ( object == this )
			return false ;
		Follower follower = (Follower)object ;
		return follower.toString().equals(this.toString()) ;
	}
	public void update(Post post) {
		System.out.println("New Post For " + firstName + " " + lastName + " :") ;
		System.out.println(post.toString()) ;
		System.out.println() ;
	}
}

