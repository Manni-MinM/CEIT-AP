// BWOTSHEWCHB

import java.util.ArrayList ;

public class User {
	// Fields
	private final String id ;
	private String firstName ;
	private String lastName ;
	private String password ;
	private ArrayList<Account> accountList ;
	// Constructor 
	public User(String id , String firstName , String lastName , String password) {
		this.id = id ;
		this.firstName = firstName ;
		this.lastName = lastName ;
		this.password = password ;
		// Create ArrayList 
		accountList = new ArrayList<Account>() ;
	}
	// Getters
	public String getId() {
		return id ;
	}
	public String getFirstName() {
		return firstName ;
	}
	public String getLastName() {
		return lastName ;
	}
	public String getPassword() {
		return password ;
	}
	public ArrayList<Account> getAccountList() {
		return accountList ;
	}
	// Private Methods
	private boolean validateAccount(Account account) {
		boolean exists = false ;
		for ( Account currentAccount : accountList )
			if ( currentAccount.getSerial().equals(account.getSerial()) )
				exists = true ;
		return exists ;
	}
	// Public Methods
	public void addAccount(Account account) {
		// Check if action is valid
		if ( validateAccount(account) ) {
			System.out.println("[INVALID ACTION] Account Already in Users Account List") ;
			System.out.println() ;
		}
		else
			accountList.add(account) ;
	}
	public void removeAccount(Account account) {
		// Check if action is valid
		if ( validateAccount(account) )
			accountList.remove(account) ;
		else {
			System.out.println("[INVALID ACTION] Account Not in Users Account List") ;
			System.out.println() ;
		}
	}
	public void deposit(Account account , int amount) {
		// Check if action is valid
		boolean found = false ;
		Account targetAccount = null ;
		for ( Account currentAccount : accountList )
			if ( currentAccount.getSerial().equals(account.getSerial()) ) {
				found = true ;
				targetAccount = currentAccount ;
			}
		// Create transaction and add it to the list
		if ( found ) {
			Transaction transaction = new Transaction(amount) ;
			targetAccount.addTransaction(transaction) ;
			// Update account balance
			targetAccount.updateBalance(amount) ;
			System.out.println("[ACTION COMPLETED]") ;
			System.out.println() ;
		}
	}
	public void withdraw(Account account , int amount) {
		// Check if action is valid
		boolean found = false ;
		Account targetAccount = null ;
		for ( Account currentAccount : accountList )
			if ( currentAccount.getSerial().equals(account.getSerial()) ) {
				found = true ;
				targetAccount = currentAccount ;
			}
		if ( found ) {
			if ( targetAccount.getBalance() >= amount ) {
				// Create transaction and add it to the list
				Transaction transaction = new Transaction(-amount) ;
				targetAccount.addTransaction(transaction) ;
				// Update account balance
				targetAccount.updateBalance(-amount) ;
				System.out.println("[ACTION COMPLETED]") ;
				System.out.println() ;
			}
			else {
				System.out.println("[INVALID ACTION] Insufficient Funds") ;
				System.out.println() ;
			}
		}
	}
	public void transfer(Account srcAccount , Account destAccount , int amount) {
		// Check if srcAccount is valid
		if ( !validateAccount(srcAccount) ) {
			System.out.println("[INVALID ACTION] Account Not in Users Account List") ;
			System.out.println() ;
		}
		if ( srcAccount.getBalance() >= amount ) {
			// Create transaction for srcAccount and add it to the list
			Transaction srcTransaction = new Transaction(-amount) ;
			srcAccount.addTransaction(srcTransaction) ;
			// Update srcAccount balance
			srcAccount.updateBalance(-amount) ;
			// Create transaction for destAccount and add it to the list
			Transaction destTransaction = new Transaction(amount) ;
			destAccount.addTransaction(destTransaction) ;
			// Update destAccount balance
			destAccount.updateBalance(amount) ;
		}
	}
	public void checkBalance(Account account) {
		// Prints account balance
		System.out.println(account.getBalance()) ;
		System.out.println() ;
	}
	public void printAllAvailableAccounts() {
		// Prints all of users accounts
		int it = 1 ;
		for ( Account currentAccount : accountList ) {
			System.out.printf("%d)\n" , it) ;
			currentAccount.printAccountData() ;
			it ++ ;
		}
	}
	public void printUserData() {
		// Prints user data
		System.out.printf("ID : %s\n" , getId()) ;
		System.out.printf("First Name : %s\n" , getFirstName()) ;
		System.out.printf("Last Name : %s\n" , getLastName()) ;
		System.out.println() ;
	}
}
