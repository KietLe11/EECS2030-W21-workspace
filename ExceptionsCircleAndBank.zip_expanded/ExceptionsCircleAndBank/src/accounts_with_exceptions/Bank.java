package accounts_with_exceptions;

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
	
	// We do not want to handle the InvalidTransactionException
	// at this level. We choose to propagate it by 
	// specifying it as the signature.
	void withdrawFrom(int id, double a) throws InvalidTransactionException {
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







