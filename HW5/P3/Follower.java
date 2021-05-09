// BWOTSHEWCHB

import java.util.ArrayList ;

public class Follower {
	// Fields
	private String firstName ;
	private String lastName ;
	private String id ;
	private int age ;
	private ArrayList<Newsletter> newsletters ;
	// Constructor
	public Follower(String firstName , String lastName , String id , int age) {
		this.firstName = firstName ;
		this.lastName = lastName ;
		this.id = id ;
		this.age = age ;
		newsletters = new ArrayList<Newsletter>() ;
	}
	// Methods
	public String toString() {
		return firstName + " " + lastName ;
	}
	public boolean equals(Object object) {
		if ( !(object instanceof Follower) )
			return false ;
		if ( object == this )
			return false ;
		Follower follower = (Follower)object ;
		return follower.toString().equals(this.toString()) ;
	}
}

