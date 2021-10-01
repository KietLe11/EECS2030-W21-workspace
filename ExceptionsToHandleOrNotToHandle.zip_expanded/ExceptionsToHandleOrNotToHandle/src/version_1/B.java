package version_1;

public class B {
	B() { }
	
	void mb(int i) {
		A oa = new A();
		
		// From the method call below,
		// we know: 
		// 1. B.mb is the caller of A.ma.
		// 2. From the header of A.ma, it may throw a NegValException which must be handled.
		//    (Catch-or-Specify requirement)
		// In this version, we choose to catch it. 
		try { 
			oa.ma(i);
		}
		catch(NegValException nve) {
			// Once the NVE is caught here, any further caller of B.mb will not be subject to the
			// catch-or-specify requirement.
			// do something to handle the exception
			System.out.println("From B.mb: neg val: " + i);
		}
	}
}
