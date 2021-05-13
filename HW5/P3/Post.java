// BWOTSHEWCHB

/**
 * A Class to hold details about Posts
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Post {
	// Fields
	private String title ;
	private String context ;
	// Constructor
	/**
	 * Creates Post Object
	 *
	 * @param title The title of the Post
	 * @param context The context of the Post
	 */
	public Post(String title , String context) {
		this.title = title ;
		this.context = context ;
	}
	// Methods
	/**
	 * Converts Post to String format
	 *
	 * @return The Post in String format
	 */
	@Override
	public String toString() {
		return "# " + title + " :\n" + context ;
	}
}

