package model;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {
	 InsufficientBalanceException(String s) {
		super(s);
	}
}
