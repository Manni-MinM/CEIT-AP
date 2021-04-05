// BWOTSHEWCHB

import java.util.Date ;

public final class Transaction {
	// Fields 
	private final int amount ;
	private final Date date ;
	// Constructor
	public Transaction(int amount) {
		this.amount = amount ;
		this.date = new Date() ;
	}
	// Getters
	private int getAmount() {
		return amount ;
	}
	private String getDate() {
		return date.toString() ;
	}
	// Methods
	public void print() {
		System.out.printf("Amount : %d / Date : %s\n" , getAmount() , getDate()) ;
		System.out.println() ;
	}
}
