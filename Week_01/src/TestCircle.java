import static org.junit.Assert.*;

import org.junit.Test;

public class TestCircle {

	@Test
	public void test1() {
		assertEquals(314.0, Circle.getArea(10), 1);
	}
	
	@Test
	public void test2() {
		assertEquals(20.0*20.0*Math.PI, Circle.getArea(20), 1);
	}

}
