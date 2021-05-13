// BWOTSHEWCHB

public class Player {
	// Fields
	private String firstName ;
	private String lastName ;
	private String id ;
	private int age ;
	// Constructor
	public Player(String firstName , String lastName , String id , int age) {
		this.firstName = firstName ;
		this.lastName = lastName ;
		this.id = id ;
		this.age = age ;
	}
	// Methods
	public String toString() {
		return "FullName : " + firstName + " " + lastName + "\n" + 
			"ID : " + id + "\n" +
			"Age : " + age ;
	}
}

