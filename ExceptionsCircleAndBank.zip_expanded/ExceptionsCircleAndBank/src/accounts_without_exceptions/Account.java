package accounts_without_exceptions;

public class Account {
	int id;
	double balance;
	
	Account(int id) {
		this.id = id;
	}
	
	void setBalance(double balance) {
		this.balance = balance;
	}
	
	void withdraw(double a) {
		if(a < 0 || balance < a) {
			System.out.println("Error: invalid transaction.");
		}
		else {
			balance -= a;
		}
	}
}






