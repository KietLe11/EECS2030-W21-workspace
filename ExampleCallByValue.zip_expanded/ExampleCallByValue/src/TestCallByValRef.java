import static org.junit.Assert.*;

import org.junit.Test;

public class TestCallByValRef {
	@Test 
	public void testCallByVal() {
		Util u = new Util();
		int i = 10;
		assertTrue(i == 10);
		u.reassignInt(i);
		assertTrue(i == 10);
	}
	
	@Test
	public void testCallByRef_1() {
		Util u = new Util();
		Point p = new Point(3, 4);
		Point refOfPBefore = p;
		u.reassignRef(p); // internally, q = np;
		assertTrue(p == refOfPBefore);
	}
	
	@Test
	public void testCallByRef_2() {
		Util u = new Util();
		Point p = new Point(3, 4);
		Point refOfPBefore = p;
		u.changeViaRef(p); // internally, q.moveHorizontally(3); q.moveVertically(4);
		assertTrue(p == refOfPBefore);
		assertTrue(p.getX() == 6 && p.getY() == 8);
	}
}
