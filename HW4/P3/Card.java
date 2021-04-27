// BWOTSHEWCHB

import java.util.ArrayList ;

public abstract class Card {
	// Fields
	protected int point ;
	protected String rank ;
	protected String color ;
	// Constructor
	
	// Classes
	public class Color {
		// Fields
		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";
		// Methods
		public String getANSI(String color) {
			if ( color.equals("RED") )
				return ANSI_RED ;
			else if ( color.equals("GREEN") )
				return ANSI_GREEN ;
			else if ( color.equals("BLUE") )
				return ANSI_BLUE ;
			else if ( color.equals("BLACK") )
				return ANSI_BLACK ;
			return ANSI_RESET ;
		}
	}
	// Methods
	public int getPoint() {
		return point ;
	}
	public String getRank() {
		return rank ;
	}
	public String getColor() {
		return color ;
	}
	public boolean equals(Object object) {
		if ( !(object instanceof Card) )
			return false ;
		if ( object == this )
			return true ;
		Card card = (Card)object ;
		return (this.getRank().equals(card.getRank()) && this.getColor().equals(card.getColor())) ;
	}
	public String toString() {
		return (this.getRank() + "-" + this.getColor()) ;
	}
	public boolean isValid(Card nextCard) {
		return (this.getRank().equals(nextCard.getRank()) || this.getColor().equals(nextCard.getColor()) || this.getRank().equals("B")) ;
	}
	public ArrayList<String> stringed() {
		ArrayList<String> line = new ArrayList<String>() ;
		Color paint = new Color() ;
		if ( rank.equals("NULL") ) {
			line.add(paint.getANSI(color) + "┍━━━━━━━━━┑" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;	
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "┕━━━━━━━━━┙" + paint.getANSI("RESET")) ;
		}
		else {
			line.add(paint.getANSI(color) + "┍━━━━━━━━━┑" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			if ( getRank().equals("10") )
				line.add(paint.getANSI(color) + "│ "+ getRank() + "      │" + paint.getANSI("RESET")) ;
			else
				line.add(paint.getANSI(color) + "│ "+ getRank() + "       │" + paint.getANSI("RESET")) ;	
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "┕━━━━━━━━━┙" + paint.getANSI("RESET")) ;
		}
		return line ;
	}
	public ArrayList<String> stringedWithoutRightSide() {
		ArrayList<String> line = new ArrayList<String>() ;
		Color paint = new Color() ;
		if ( rank.equals("NULL") ) {
			line.add(paint.getANSI(color) + "┍━━━━━━━━" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;	
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "┕━━━━━━━━" + paint.getANSI("RESET")) ;
		}
		else {
			line.add(paint.getANSI(color) + "┍━━━━━━━━" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;
			if ( getRank().equals("10") )
				line.add(paint.getANSI(color) + "│ "+ getRank() + "     " + paint.getANSI("RESET")) ;
			else
				line.add(paint.getANSI(color) + "│ "+ getRank() + "      " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│        " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "┕━━━━━━━━" + paint.getANSI("RESET")) ;
		}
		return line ;
	}
}

