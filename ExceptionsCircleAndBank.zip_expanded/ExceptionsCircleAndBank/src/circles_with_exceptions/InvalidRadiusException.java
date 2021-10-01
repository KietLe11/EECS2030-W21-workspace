package circles_with_exceptions;

@SuppressWarnings("serial")
public class InvalidRadiusException extends Exception {
	public InvalidRadiusException(String s) {
		super(s);
	}
}
