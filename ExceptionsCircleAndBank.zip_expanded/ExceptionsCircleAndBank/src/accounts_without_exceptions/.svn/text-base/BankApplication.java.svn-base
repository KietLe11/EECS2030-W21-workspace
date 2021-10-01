package accounts_without_exceptions;

import java.util.Scanner;

public class BankApplication {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Account acc1 = new Account(23);
		acc1.setBalance(100);
		
		Bank b = new Bank();
		b.addAccount(acc1);
		
		System.out.println("How much to withdraw from account 23?");
		double a = input.nextDouble();
		// There is an error if 'a' read from the user
		// is negative.
		b.withdrawFrom(23, a);
		
		// These two lines below should only be exectued
		// when 'a' is a valid amount to withdraw.
		// That is, when a > acc1.balance or a < 0,
		// these two lines should be skipped.
		System.out.print("After withdrawing $" + a + ", the new balance is: ");
		System.out.println(acc1.balance);
		
		input.close();
	}
}






