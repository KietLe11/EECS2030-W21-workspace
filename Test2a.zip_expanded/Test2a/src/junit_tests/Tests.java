package junit_tests;

import static org.junit.Assert.*;
import model.*;

import org.junit.Test;

/*
 * The problem to solve for this test is described as comments within the test methods.
 */

public class Tests {
	/*
	 * 1. Do NOT create any new packages. 
	 * 		All classes you create must be in the `model` package.
	 * 
	 * 2. All attributes you declare in the classes must be *** private ***.
	 * 
	 * 3. You are free to create additional private or public helper methods.
	 * 
	 * 4. You must NOT create any class not indicated by the given JUnit tests.
	 * 
	 * 5. You must NOT put any System.out.print statements in the classes you create.
	 * 
	 * 6. Programming Requirements:
	 * 	- You are only allowed to use primitive arrays (e.g., int[], String[], Facility[]) 
	 * 		for declaring attributes and implementing methods.
	 * 	- Any use of a Java library class or method is forbidden 
	 * 		(that is, use selections and loops to build your solution from scratch instead):
	 * 	- Here are some examples of forbidden classes/methods: 
	 * 		- Arrays class (e.g., Arrays.copyOf)
	 * 		- System class (e.g., System.arrayCopy)
	 * 		- ArrayList class
	 * 		- String class (e.g., substring).
	 * 	- The use of some library classes does not require an import statement, 
	 * 		but these classes are also forbidden to be used.
	 * 	- Here are the exceptions (library methods which you are allowed to use if needed):
	 * 		- String class (equals, format)
	 * 
	 * You will receive a penalty as specified on the test guide if this requirement is violated.
	 */
	
	/*
	 * Your expected workflow should be:
	 * 
	 * Step 1: Eliminate compilation errors. 
	 * 	Declare all the required classes and methods (returning default values if necessary), 
	 * 	so that the project contains no compilation errors (i.e., no red crosses shown on the Eclipse editor).
	 * 
	 * Step 2: Pass all unit tests. Add private attributes and complete the method implementations accordingly, 
	 * 	so that executing all tests result in a green bar.
	 * 
	 * If necessary, you are free to declare (private or public) helper methods.
	 * 
	 * Any new classes that are ***not*** indicated by the given JUnit tests will be ***disregarded*** in grading. 
	 */
	
	/*
	 * Tests related to the Account class.
	 */
	
	@Test
	public void test_account_01() {
		/*
		 * An account is characterized by its string owner name and integer account balance.
		 * 
		 * Create an account with the owner name and its initial balance.
		 * (You can assume that the initial balance passed as argument is always positive.)
		 * 
		 * An account, when first created, is a regular account. 
		 */
		Account a = new Account("Alan", 100);
		assertEquals("A regular account owned by Alan with balance $100", a.toString()); 
	}

	@Test
	public void test_account_02a() { 
		/*
		 * Create an account with the owner name and its initial balance.
		 * An account, when first created, is a regular account. 
		 */
		Account a = new Account("Alan", 100);

		try {
			/* 
			 * Switch the account status to VIP, with the specified amount of deposit 
			 * (such deposit will be refunded if the account is switched back to a regular account later).
			 * 
			 * You can assume that such deposit is always positive (> 0). 
			 */
			a.switchToVIP(25);
			assertEquals("A VIP account owned by Alan with balance $75 ($25 deposited for maintaining the VIP stauts)", a.toString());
		}
		catch(InvalidStatusToSwitchException e) {
			fail();
		}
		catch(InsufficientBalanceException e) {
			fail();
		}
	}

	@Test
	public void test_account_02b() { 
		/*
		 * Create an account with the owner name and its initial balance.
		 * An account, when first created, is a regular account. 
		 */
		Account a = new Account("Alan", 100);

		try {
			/*
			 * It is an error when attempting to switch an account to VIP while its current balance cannot afford, 
			 * i.e., deducting that VIP fee from the current balance will result in the balance being negative (< 0). 
			 */
			a.switchToVIP(101);
			fail();
		}
		catch(InvalidStatusToSwitchException e) {
			fail();
		}
		catch(InsufficientBalanceException e) { 

		}
	}

	@Test
	public void test_account_02c() { 
		/*
		 * Create an account with the owner name and its initial balance.
		 * An account, when first created, is a regular account. 
		 */
		Account a = new Account("Alan", 100);

		try {
			/* 
			 * Switch the account status to VIP, with the specified amount of deposit 
			 * (such deposit will be refunded if the account is switched back to a regular account later).
			 * 
			 * You can assume that such deposit is always positive (> 0). 
			 */
			a.switchToVIP(25);
			assertEquals("A VIP account owned by Alan with balance $75 ($25 deposited for maintaining the VIP stauts)", a.toString());
		}
		catch(InvalidStatusToSwitchException e) {
			fail();
		}
		catch(InsufficientBalanceException e) {
			fail();
		}

		try {
			/*
			 * It is an error when attempting to switch an account to VIP while it is already a VIP account,
			 * even if the account can afford the specified fee.
			 */
			a.switchToVIP(25);
			fail();
		}
		catch(InvalidStatusToSwitchException e) {

		}
		catch(InsufficientBalanceException e) {
			fail();
		}

		try {
			/*
			 * There are two errors here: 
			 * 	1. The account is already a VIP account.
			 * 	2. The account balance cannot afford the specified fee.
			 * In this case, Error 1 is reported.  
			 */
			a.switchToVIP(101);
			fail();
		}
		catch(InvalidStatusToSwitchException e) {

		}
		catch(InsufficientBalanceException e) {
			fail();
		}
	}
	
	@Test
	public void test_account_03a() {
		/*
		 * Create an account with the owner name and its initial balance.
		 * An account, when first created, is a regular account. 
		 */
		Account a = new Account("Alan", 100);
		assertEquals("A regular account owned by Alan with balance $100", a.toString()); 
		
		try {
			/*
			 * It is an error when attempting to switch an account to regular while it is already a regular account.
			 */
			a.switchToRegular();
			fail();
		}
		catch(InvalidStatusToSwitchException e) {

		}
	}
	
	@Test
	public void test_account_03b() { 
		/*
		 * Create an account with the owner name and its initial balance.
		 * An account, when first created, is a regular account. 
		 */
		Account a = new Account("Alan", 100);

		try {
			/* 
			 * Switch the account status to VIP, with the specified amount of deposit 
			 * (such deposit will be refunded if the account is switched back to a regular account later).
			 * You can assume that such deposit is always positive (> 0). 
			 */
			a.switchToVIP(25);
			assertEquals("A VIP account owned by Alan with balance $75 ($25 deposited for maintaining the VIP stauts)", a.toString());
		}
		catch(InvalidStatusToSwitchException e) {
			fail();
		}
		catch(InsufficientBalanceException e) {
			fail();
		}
		
		try {
			/*
			 * By switching an account back to regular, 
			 * the charge of deposit on its previous VIP status is refunded. 
			 */
			a.switchToRegular();
			assertEquals("A regular account owned by Alan with balance $100", a.toString());
		}
		catch(InvalidStatusToSwitchException e) {
			fail();
		}
	}


	@Test
	public void test_account_04a() {
		Account a1 = new Account("Alan", 100);
		Account a2 = new Account("Alan", 100);   
		
		Account a3 = new Account("Mark", 100);
		Account a4 = new Account("Alan", 200);
		Account a5 = new Account("Mark", 200);

		/*
		 * Two accounts are considered equal if their owner names, balance, 
		 * and types (regular or VIP) are equal. 
		 * 
		 * Note. For two VIP accounts, if their owners and balances are equal,
		 * 			the VIP fees they got charged need not be considered. 
		 */
		assertEquals(a1, a2);
		assertNotEquals(a1, a3);
		assertNotEquals(a1, a4);
		assertNotEquals(a1, a5);

		try {
			a1.switchToVIP(50);
			a4.switchToVIP(150);

			assertNotEquals(a1, a2);
			assertEquals(a1, a4);
		}
		catch(InvalidStatusToSwitchException e) {

		}
		catch(InsufficientBalanceException e) {
			fail();
		}

		/* 
		 * The above assertions do not cover all cases of the equals method as discussed in the lecture.
		 * Your implementation of the overridden equals method should cover them.    
		 */
	}

	@Test
	public void test_account_04b() {
		/*
		 * Create an account with the owner name and its initial balance.
		 * An account, when first created, is a regular account. 
		 */
		Account a1 = new Account("Alan", 100);

		try {
			/* 
			 * Switch the account status to VIP, with the specified amount of deposit 
			 * (such deposit will be refunded if the account is switched back to a regular account later).
			 * You can assume that such deposit is always positive (> 0). 
			 */
			a1.switchToVIP(25);
			assertEquals("A VIP account owned by Alan with balance $75 ($25 deposited for maintaining the VIP stauts)", a1.toString());
		}
		catch(InvalidStatusToSwitchException e) {
			fail();
		}
		catch(InsufficientBalanceException e) {
			fail();
		}
		
		/* Create account `a2` as a copy of `a1`. */
		Account a2 = new Account(a1);
		
		assertNotSame(a1, a2);
		assertEquals("A VIP account owned by Alan with balance $75 ($25 deposited for maintaining the VIP stauts)", a1.toString());
		assertEquals("A VIP account owned by Alan with balance $75 ($25 deposited for maintaining the VIP stauts)", a2.toString());
		assertEquals(a1, a2);
		
		try {
			/*
			 * By switching an account back to regular, the charge on its previous VIP status is refunded. 
			 */
			a2.switchToRegular();
			assertEquals("A regular account owned by Alan with balance $100", a2.toString());
		}
		catch(InvalidStatusToSwitchException e) {
			fail();
		}
	}
	
	/*
	 * Tests related to the Bank class.
	 */
	
	@Test
	public void test_bank_01a() {
		/*
		 * A bank stores a collection of accounts. 
		 * The maximum capacity of the collection of accounts is 5 
		 *	(and you do not need to implement any error handling on this).
		 * 
		 * Create an empty bank.
		 */
		Bank b1 = new Bank();
		
		/* Empty collection of accounts. */
		int i = b1.getNumberOfAccounts();
		Account[] a1 = b1.getReferencesOfAccounts();
		Account[] a2 = b1.getCopiesOfAccounts();
		
		assertEquals(0, i);
		assertEquals(0, a1.length);
		assertEquals(0, a2.length);
	}

	@Test
	public void test_bank_01b() {
		Bank b1 = new Bank();
		
		Account a1 = new Account("Alan", 100);
		Account a2 = new Account("Mark", 200);
		
		/*
		 * Accounts in a bank are positioned according to their chronological order of being added 
		 * (i.e., first-added account at position 0, second-added account at position 2, and so on).
		 */
		b1.addAccount(a1);
		b1.addAccount(a2);

		/* Two accounts in the collection */
		assertEquals(2, b1.getNumberOfAccounts());

		/* Returned accounts may be shared. */ 
		assertSame(b1.getReferencesOfAccounts()[0], a1);
		assertSame(b1.getReferencesOfAccounts()[1], a2);

		/* Returned accounts may not be shared. */ 
		assertNotSame(b1.getCopiesOfAccounts()[0], a1);
		assertEquals(b1.getCopiesOfAccounts()[0], a1);
		assertNotSame(b1.getCopiesOfAccounts()[1], a2);
		assertEquals(b1.getCopiesOfAccounts()[1], a2);
	}

	@Test
	public void test_bank_01c() {
		Bank b1 = new Bank();
		
		Account a1 = new Account("Alan", 100);
		Account a2 = new Account("Mark", 200);
		
		b1.addAccount(a1);
		b1.addAccount(a2);

		Account a3 = new Account("Tom", 300);
		Account a4 = new Account("Jim", 400);
		Account a5 = new Account("Jeremy", 500); 
		
		Account[] accounts = {a3, a4, a5};
		/*
		 * Add an array accounts to the bank.
		 * You can assume that adding the input array of accounts to the bank 
		 * 	will not not exceed the bank's maximum limit.  
		 */
		b1.addAccounts(accounts);

		assertEquals(5, b1.getNumberOfAccounts());

		/* Returned accounts may be shared. */ 
		assertSame(b1.getReferencesOfAccounts()[0], a1);
		assertSame(b1.getReferencesOfAccounts()[1], a2);
		assertSame(b1.getReferencesOfAccounts()[2], a3);
		assertSame(b1.getReferencesOfAccounts()[3], a4);
		assertSame(b1.getReferencesOfAccounts()[4], a5);

		/* Returned accounts may not to be shared. */ 
		assertNotSame(b1.getCopiesOfAccounts()[0], a1);
		assertEquals(b1.getCopiesOfAccounts()[0], a1);
		assertNotSame(b1.getCopiesOfAccounts()[1], a2);
		assertEquals(b1.getCopiesOfAccounts()[1], a2);
		assertNotSame(b1.getCopiesOfAccounts()[2], a3);
		assertEquals(b1.getCopiesOfAccounts()[2], a3);
		assertNotSame(b1.getCopiesOfAccounts()[3], a4);
		assertEquals(b1.getCopiesOfAccounts()[3], a4);
		assertNotSame(b1.getCopiesOfAccounts()[4], a5);
		assertEquals(b1.getCopiesOfAccounts()[4], a5);
	}

	@Test
	public void test_bank_02a() {
		Bank b1 = new Bank();
		
		Account a1 = new Account("Alan", 100);
		Account a2 = new Account("Mark", 200);
		
		b1.addAccount(a1);
		b1.addAccount(a2);

		/* Create `b2` as a copy of `b1`. */
		Bank b2 = new Bank(b1);

		/* Returned accounts may be shared. */ 
		assertSame(b1.getReferencesOfAccounts()[0], b2.getReferencesOfAccounts()[0]);
		assertSame(b1.getReferencesOfAccounts()[1], b2.getReferencesOfAccounts()[1]);

		/* Returned accounts may not be shared. */ 
		assertNotSame(b1.getCopiesOfAccounts()[0], b2.getCopiesOfAccounts()[0]);
		assertEquals(b1.getCopiesOfAccounts()[0], b2.getCopiesOfAccounts()[0]);
		assertNotSame(b1.getCopiesOfAccounts()[1], b2.getCopiesOfAccounts()[1]);
		assertEquals(b1.getCopiesOfAccounts()[1], b2.getCopiesOfAccounts()[1]);
	}

	@Test
	public void test_bank_02b() {
		Bank b1 = new Bank();
		
		Account a1 = new Account("Alan", 100);
		Account a2 = new Account("Mark", 200);
		
		b1.addAccount(a1);
		b1.addAccount(a2);
		
		/* Create `b2` as a copy of `b1`. */
		Bank b2 = new Bank(b1);
		
		/*
		 * Two banks are equal if they store the same number of accounts, 
		 * 	and accounts at the corresponding positions are equal.
		 */
		assertEquals(b1, b2);

		Account a3 = new Account("Tom", 300);
		b1.addAccount(a3);

		assertNotEquals(b1, b2);
		
		/* 
		 * The above assertions do not cover all cases of the equals method as discussed in the lecture.
		 * Your implementation of the overridden equals method should cover them.    
		 */
	}
}