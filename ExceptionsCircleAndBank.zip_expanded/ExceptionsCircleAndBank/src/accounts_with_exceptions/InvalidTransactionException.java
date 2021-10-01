package accounts_with_exceptions;

@SuppressWarnings("serial")
public class InvalidTransactionException extends Exception {
	InvalidTransactionException(String s) {
		super(s);
	}
}
