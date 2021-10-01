package accounts_with_exceptions;

public class Account {
	int id;
	double balance;
	
	Account(int id) {
		this.id = id;
	}
	
	void setBalance(double balance) {
		this.balance = balance;
	}
	
	// When an exception can be thrown,
	// we have two options: specify or catch.
	// However, typically, in the very place where
	// the exception is thrown, we choose the specify option.
	void withdraw(double a) throws InvalidTransactionException {
		if(a < 0 || balance < a) {
			throw new InvalidTransactionException("Amount negative or too large.");
		}
		else {
			balance -= a;
		}
	}
}






