// BWOTSHEWCHB

import java.util.Iterator ;
import java.util.ArrayList ;

class BankingSystem {
	// Fields
	private ArrayList<User> users ;
	private ArrayList<Account> accounts ;
	// Constructor 
	public BankingSystem() {
		// Create ArrayList
		users = new ArrayList<User>() ;
		accounts = new ArrayList<Account>() ;
	}
	// Public Methods
	public void addUser(User user) {
		users.add(user) ;
	}
	public void removeUser(User user) {
		boolean exists = false ;
		User targetUser = null ;
		for ( User currentUser : users )
			if ( currentUser.getId().equals(user.getId()) ) {
				exists = true ;
				targetUser = currentUser ;
			}
		if ( exists )
			users.remove(targetUser) ;
		else {
			System.out.println("[INVALID ACTION] No Such User Found") ;
			System.out.println() ;
		}
	}
	public void displayUsers() {
		Iterator<User> it = users.iterator() ;
		while ( it.hasNext() )
			it.next().printUserData() ;
	}
	public User findUser(String id) {
		boolean exists = false ;
		User targetUser = null ;
		for ( User currentUser : users )
			if ( currentUser.getId().equals(id) ) {
				exists = true ;
				targetUser = currentUser ;
			}
		if ( exists )
			return targetUser ;
		else
			return null ;
	}
	public void addAccount(Account account) {
		accounts.add(account) ;
	}
	public void removeAccount(Account account) {
		boolean exists = false ;
		Account targetAccount = null ;
		for ( Account currentAccount : accounts )
			if ( currentAccount.getSerial().equals(account.getSerial()) ) {
				exists = true ;
				targetAccount = account ;
			}
		if ( exists )
			accounts.remove(account) ;
		else {
			System.out.println("[INVALID ACTION] No Such Account Found") ;
			System.out.println() ;
		}
	}
	public void displayAccounts() {
		for ( Account currentAccount : accounts )
			currentAccount.printAccountData() ;
	}
	public Account findAccount(String serial) {
		boolean exists = false ;
		Account targetAccount = null ;
		for ( Account currentAccount : accounts ) {
			System.out.println("SYS OUT : " + currentAccount.getSerial() + " / " + serial) ;
			if ( currentAccount.getSerial().equals(serial) ) {
				exists = true ;
				targetAccount = currentAccount ;
				break ;
			}
		}
		if ( exists )
			return targetAccount ;
		else
			return null ;
	}
	public void register(User user) {
		// Check if user is valid
		boolean exists = false ;
		for ( User currentUser : users )
			if ( currentUser.getId().equals(user.getId()) )
				exists = true ;
		if ( !exists ) {
			addUser(user) ;
			System.out.println("[USER CREATED]") ;
			System.out.println() ;
		}
		else {
			System.out.println("[INVALID ACTION] User Already Exists") ;
			System.out.println() ;
		}
	}
	public User login(String id , String password) {
		// Find target user
		boolean exists = false ;
		User targetUser = null ;
		for ( User currentUser : users )
			if ( currentUser.getId().equals(id) ) {
				exists = true ;
				targetUser = currentUser ;
			}
		if ( exists ) {
			// Check password
			if ( targetUser.getPassword().equals(password) ) {
				// Log user in
				System.out.println("[LOGGED IN]") ;
				System.out.println() ;
				return targetUser ;
			}
			else {
				System.out.println("[INVALID ACTION] User Doesn't Exists or Password is Incorrect") ;
				System.out.println() ;
				return null ;
			}
		}
		else {
			System.out.println("[INVALID ACTION] User Doesn't Exists or Password is Incorrect") ;
			System.out.println() ;
			return null ;
		}
	}
}
