package accounts_without_exceptions;

public class Bank {
	Account[] accounts;
	int noa; /* number of accounts */
	
	Bank() {
		accounts = new Account[100];
	}
	
	void addAccount(Account a) {
		accounts[noa] = a;
		noa ++;
	}
	
	/* Given an account id, if it exists,
	 * withdraw from the corresponding account. */
	void withdrawFrom(int id, double a) {
		for(int i = 0; i < noa; i ++) {
			if(accounts[i].id == id) {
				// From the method call below
				// we have Bank.withdrawFrom being 
				// the caller of Account.withdraw
				accounts[i].withdraw(a);
			}
		}
	}
}







