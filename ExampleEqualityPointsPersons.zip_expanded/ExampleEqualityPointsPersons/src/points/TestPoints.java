package points;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPoints {

	@Test
	public void testEqualityOfPointV1() {
		PointV1 p1 = new PointV1(3, 4);
		PointV1 p2 = new PointV1(3, 4);
		assertFalse(p1 == p2);
		assertFalse(p2 == p1);
//		assertSame(p1, p2); // fail
//		assertSame(p2, p1); // fail
		// default version of equals 
		// from Object is called.
		assertFalse(p1.equals(p2));
		assertFalse(p2.equals(p1));
		
		// Compare contents of p1 and p2 explicitly
		// this is what a overridden equals would do
		assertTrue(p1.getX() == p2.getX() && p1.getY() == p2.getY());
	}
	
	@Test
	public void testEqualityOfPointV2() {
		PointV2 p3 = new PointV2(3, 4);
		PointV2 p4 = new PointV2(3, 4);
		assertFalse(p3 == p4);
		assertFalse(p4 == p3);
//		assertSame(p3, p4); // fail
//		assertSame(p4, p3); // fail
		// overridden version of equals 
		// from PointV2 is called.
		assertTrue(p3.equals(p4));
		assertTrue(p4.equals(p3));
		assertEquals(p3, p4);
		assertEquals(p4, p3);
	}
	
	@Test
	public void testEqualityOfPointV1andPointv2() {
		PointV1 p1 = new PointV1(3, 4);
		PointV2 p2 = new PointV2(3, 4);
		// The following two lines
		// do not compile because
		// p1 and p2's types are different
//		assertFalse(p1 == p2);
//		assertFalse(p2 == p1);
		// On the other hands, assertSame can take
		// objects of different types and fail.
//		assertSame(p1, p2); // compiles, but fails
//		assertSame(p2, p1); // compiles, but fails
		
		// p1.equals(p2)
		// calls the version of equals from Object
		// False because p1 != p2
		assertFalse(p1.equals(p2));
		// p2.equals(p1)
		// calls the version of equals from PointV2
		// False because p2.getClass() != p1.getClass()
		assertFalse(p2.equals(p1)); 
	}
}
