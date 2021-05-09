// BWOTSHEWCHB

import java.util.Scanner ;
import java.util.ArrayList ;

public class Main {
	// Fields
	private static Scanner input ;
	private static BankingSystem bankingSystem ;
	// Main Method
	public static void main(String[] args) {
		// Create objects
		input = new Scanner(System.in) ;
		bankingSystem = new BankingSystem() ;
		// Show the menu
		while ( true ) {
			showMenu() ;
			String line = input.nextLine() ;
			System.out.println() ;
			if ( line.equals("Sign up") )
				signup() ;
			else if ( line.equals("Log in") )
				login() ;
			else if ( line.equals("System admin") )
				systemAdmin() ;
			else if ( line.equals("Exit") )
				break ;
			else
				handleMenuException() ;
		}
	}
	// Other Methods
	public static void showMenu() {
		System.out.println("> Sign up") ;
		System.out.println("> Log in") ;
		System.out.println("> System admin") ;
		System.out.println("> Exit") ;
		System.out.println() ;
	}
	public static void signup() {
		// Get info
		System.out.println("First Name :") ;
		String firstName = input.nextLine() ;
		System.out.println("Last Name :") ;
		String lastName = input.nextLine() ;
		System.out.println("ID :") ;
		String id = input.nextLine() ;
		System.out.println("Password :") ;
		String password = input.nextLine() ;
		System.out.println() ;
		// Create new user
		User newUser = new User(id , firstName , lastName , password) ;
		bankingSystem.register(newUser) ;
	}
	public static void login() {
		// Get info
		System.out.println("ID :") ;
		String id = input.nextLine() ;
		System.out.println("Password :") ;
		String password = input.nextLine() ;
		System.out.println() ;
		// Login the user
		User targetUser = bankingSystem.login(id , password) ;
		if ( targetUser != null ) {
			// Get info
			System.out.println("> Existing accounts") ;
			System.out.println("> Add new account") ;
			System.out.println("> Log out") ;
			System.out.println() ;
			String line = input.nextLine() ;
			System.out.println() ;
			if ( line.equals("Existing accounts") ) {
				// Print all user accounts
				targetUser.printAllAvailableAccounts() ;
				ArrayList <Account> userAccounts = targetUser.getAccountList() ;
				// Get info
				if ( userAccounts.size() != 0 ) {
					System.out.println("Account Serial (exp : Account number XXX-XXX-XXX) : ") ;
					line = input.nextLine() ;
					System.out.println() ;
					String[] lineSplit = line.split(" ") ;
					if ( lineSplit[0].equals("Account") && lineSplit[1].equals("number") ) {
						// Find Account
						Account targetAccount = null ;
						String accountSerial = lineSplit[2] ;
						for ( Account currentAccount : userAccounts ) {
							if ( accountSerial.equals(currentAccount.getSerial()) ) {
								targetAccount = currentAccount ;
								break ;
							}
						}
						if ( targetAccount == null ) {
							System.out.println("[INVALID ACTION] Target Account Does Not Exist") ;
							System.out.println() ;
							return ;
						}
						// Get info
						System.out.println("> Withdrawal") ;
						System.out.println("> Deposit") ;
						System.out.println("> Transfer") ;
						System.out.println("> Check balance") ;
						System.out.println("> Back") ;
						System.out.println() ;
						line = input.nextLine() ;
						System.out.println() ;
						if ( line.equals("Withdrawal") ) {
							// Get info
							System.out.println("Amount of Withdrawal : ") ;
							int amount = input.nextInt() ;
							String trash = input.nextLine() ;
							System.out.println() ;
							// Withdraw from account
							targetUser.withdraw(targetAccount , amount) ;
						}
						else if ( line.equals("Deposit") ) {
							// Get info
							System.out.println("Amount to be Deposited : ") ;
							int amount = input.nextInt() ;
							String trash = input.nextLine() ;
							System.out.println() ;
							// Deposit to account
							targetUser.deposit(targetAccount , amount) ;
						}
						else if ( line.equals("Transfer") ) {
							// Get info
							System.out.println("Destionation Account Serial : ") ;
							String destAccountSerial = input.nextLine() ;
							System.out.println("Amount : ") ;
							int amount = input.nextInt() ;
							String trash = input.nextLine() ;
							System.out.println() ;
							Account destAccount = bankingSystem.findAccount(destAccountSerial) ;
							if ( destAccount == null || targetAccount.getBalance() < amount ) {
								System.out.println("[INVALID ACTION] Destination Account Doesn’t Exist or There is Not Enough Money in Your Account.") ;
								System.out.println() ;
							}
							else {
								targetUser.transfer(targetAccount , destAccount , amount) ;
								System.out.println("[ACTION COMPLETED]") ;
								System.out.println() ;
							}
						}
						else if ( line.equals("Check balance") ) {
							targetUser.checkBalance(targetAccount) ;
						}
						else if ( line.equals("Back") ) {
							System.out.println("[LOGGED OUT OF ACCOUNT]") ;
							System.out.println() ;
						}
						else
							handleMenuException() ;
					}
					else
						handleMenuException() ;
				}
			}
			else if ( line.equals("Add new account") ) {
				// Get info
				System.out.println("User ID : ") ;
				String ID = input.nextLine() ;
				System.out.println("Account Type : ") ;
				String type = input.nextLine() ;
				System.out.println("Initial Balance : ") ;
				int initBalance = input.nextInt() ;
				String trash = input.nextLine() ;
				System.out.println() ;
				// Add new account to user's accounts
				Account newAccount = new Account(ID , targetUser.getFirstName() , targetUser.getLastName() , type , initBalance) ;
				targetUser.addAccount(newAccount) ;
				bankingSystem.addAccount(newAccount) ;
			}
			else if ( line.equals("Log out") ) {
				// Log user out
				return ;
			}
			else
				handleMenuException() ;
		}
	}
	public static void systemAdmin() {
		// Get info
		System.out.println("Username : ") ;
		String username = input.nextLine() ;
		System.out.println("Password : ") ;
		String password = input.nextLine() ;
		System.out.println() ;
		if ( !username.equals("sysadmin") || !password.equals("1234") ) {
			System.out.println("[INVALID ACTION] Username or Password is Incorrect") ;
			System.out.println() ;
			return ;
		}
		System.out.println("[LOGGED IN AS SYSADMIN]") ;
		System.out.println() ;
		System.out.println("> Display users") ;
		System.out.println("> Display accounts") ;
		System.out.println("> Remove user") ;
		String line = input.nextLine() ;
		System.out.println() ;
		if ( line.equals("Display users") )
			bankingSystem.displayUsers() ;
		else if ( line.equals("Display accounts") )
			bankingSystem.displayAccounts() ;
		else if ( line.equals("Remove user") ) {
			// Get info
			System.out.println("User ID : ") ;
			String userId = input.nextLine() ;
			System.out.println() ;
			User targetUser = bankingSystem.findUser(userId) ;
			if ( targetUser == null ) {
				System.out.println("[INVALID ACTION] User Doesn’t Exist") ;
				System.out.println() ;
			}
			else {
				ArrayList<Account> accountList = targetUser.getAccountList() ;
				for ( Account currentAccount : accountList )
					bankingSystem.removeAccount(currentAccount) ;
				bankingSystem.removeUser(targetUser) ;
				System.out.println("[USER REMOVED]") ;
				System.out.println() ;
			}
		}
		else 
			handleMenuException() ;
		
	}
	public static void handleMenuException() {
		System.out.println("[INVALID ACTION] Invalid Command") ;
		System.out.println() ;
	}
}
