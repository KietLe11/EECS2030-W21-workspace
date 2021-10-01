package version_3;

public class B {
	B() { }
	
	void mb(int i) throws NegValException {
		A oa = new A();
		// From the method call below,
		// we know that B.mb is the caller of A.ma.
		// To handle the exception below, we choose to
		// specify it.
		oa.ma(i);
	}
}
