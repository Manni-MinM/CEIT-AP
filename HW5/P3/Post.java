// BWOTSHEWCHB

public class Post {
	// Fields
	private String title ;
	private String context ;
	// Constructor
	public Post(String title , String context) {
		this.title = title ;
		this.context = context ;
	}
	// Methods
	public String toString() {
		return "#" + title + " :\n" + context ;
	}
}

