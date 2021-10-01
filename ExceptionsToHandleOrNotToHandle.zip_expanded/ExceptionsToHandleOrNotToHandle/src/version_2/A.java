package version_2;

public class A {
	A() { }
	
	void ma(int i) throws NegValException {
		if(i < 0) {
			/* Error. */
			// To handle this exception below,
			// we choose to specify it (as opposed to catch it).
			throw new NegValException("Neg Val: " + i);
		}
		else {
			// Do something else.
		}
	}
}
