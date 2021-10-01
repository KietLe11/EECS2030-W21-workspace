package accounts_with_exceptions;

import java.util.Scanner;

public class BankApplication {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Account acc1 = new Account(23);
		acc1.setBalance(100);
		
		Bank b = new Bank();
		b.addAccount(acc1);
		
		boolean validAmount = false;
		
		while(!validAmount) {
			System.out.println("How much to withdraw from account 23?");
			double a = input.nextDouble();
			// There is an error if 'a' read from the user
			// is negative.
			
			// We have two options to handle the exception:
			// specify or catch. 
			// However, since the main method is the entry point
			// of project execution, we typically do not choose to specify,
			// since it will just propagate the exception to the console.
			try {
				b.withdrawFrom(23, a);
				// If we are able to reach this line,
				// that means the normal flow of execution
				// was not interrupted by the InvalidTransactionException.
				validAmount = true;
				// These two lines below should only be executed
				// when 'a' is a valid amount to withdraw.
				// That is, when a > acc1.balance or a < 0,
				// these two lines should be skipped.
				System.out.print("After withdrawing $" + a + ", the new balance is: ");
				System.out.println(acc1.balance);
			}
			catch(InvalidTransactionException ite) {
				/* do something to handle the exception */
				// since an exception occurred,
				// so validAmount remains to False.
				validAmount = false;
			}
		}
		input.close();
	}
}






