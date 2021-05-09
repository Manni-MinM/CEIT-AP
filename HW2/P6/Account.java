// BWOTSHEWCHB

import java.util.UUID ;
import java.util.ArrayList ;

public class Account {
	// Fields 
	private final UUID serial ;
	private final String id ;
	private String firstName ;
	private String lastName ;
	private String type ;
	private int balance ;
	private ArrayList<Transaction> transactions ;
	// Constructor
	public Account(String id , String firstName , String lastName , String type , int balance) {
		this.serial = UUID.randomUUID() ;
		this.id = id ;
		this.firstName = firstName ;
		this.lastName = lastName ;
		this.type = type ;
		this.balance = balance ;
		// Create ArrayList
		transactions = new ArrayList<Transaction>() ;
	}
	// Getters
	public String getSerial() {
		return serial.toString() ;
	}
	public String getId() {
		return id ;
	}
	public String getFirstName() {
		return firstName ;
	}
	public String getLastName() {
		return lastName ;
	}
	public String getType() {
		return type ;
	}
	public int getBalance() {
		return balance ;
	}
	// Public Methods
	public void updateBalance(int amount) {
		// Updates account balance
		balance += amount ;
	}
	public void addTransaction(Transaction transaction) {
		// Adds transaction to the list
		transactions.add(transaction) ;
	}
	public void printTransactions() {
		// Prints account transactions
		int it = 1 ;
		for ( Transaction currentTransaction : transactions ) {
			System.out.printf("Transaction %d) " , it) ;
			System.out.println() ;
			currentTransaction.print() ;
			it ++ ;
		}
	}
	public void printAccountData() {
		// Prints account data
		System.out.printf("Serial : %s\n" , getSerial()) ;
		System.out.printf("ID : %s\n" , getId()) ;
		System.out.printf("First Name : %s\n" , getFirstName()) ;
		System.out.printf("Last Name : %s\n" , getLastName()) ;
		System.out.printf("Type : %s\n" , getType()) ;
		System.out.printf("Balance : %s\n" , getBalance()) ;
		System.out.println() ;
	}
}
