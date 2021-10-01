package version_1;

public class A {
	A() {}
	
	void ma(int i) throws NegValException {
		if(i < 0) {
			/* Error */
			// To handle this exception below,
			// we choose to specify it (as opposed to catch it).
			
			throw new NegValException("Neg Val: " + i);
			
			// In the method where the exception is orginated,
			// we don't catch it.
//			try {
//				throw new NegValException("Neg Val: " + i);
//			}
//			catch(NegValException nve) {
//				// computation to repair or to inform the user.
//			}
		}
		else {
			// do something else when there is not an error
		}
	}
}
