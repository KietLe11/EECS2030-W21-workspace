package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import implementation.Counter;
import implementation.ValueTooLargeException;
import implementation.ValueTooSmallException;

public class TestCounter {

	@Test
	public void test() {
		// fail("Not yet implemented");
		/* This test passes simply because 
		 * no assertion errors or unexpected exceptions occur.
		 */
	}

	@Test
	public void testDecFromMinValue() {
		/*
		 * This test automates what's done in CounterTester1
		 */
		Counter c = new Counter();
		assertEquals(Counter.MIN_VALUE, c.getValue());
		try {
			c.decrement();
			/* reaching this line means that c.decrement() did not throw an exception */
			fail("ValueTooSmallException was NOT thrown as expected.");
		} catch (ValueTooSmallException e) {
			/*
			 *  Do nothing - ValueTooSmallException thrown as expected.
			 */
		}
	}
	
	@Test
	public void testIncFromMaxValue() {
		/*
		 * This test automates what's done in CounterTester2
		 */
		Counter c = new Counter();
		try {
			c.increment();
			c.increment();
			c.increment();
		} catch (ValueTooLargeException e) {
			fail("ValueTooLargeException was thrown unexpectedly.");
		}
		assertEquals("Counter reaches max", Counter.MAX_VALUE, c.getValue());
		try {
			c.increment(); 
			fail("ValueTooLargeException was NOT thrown as expected.");
		} catch (ValueTooLargeException e) {
			/*
			 * Do nothing - ValueTooLargeException thrown as expected.
			 */
		}
	}
	
	@Test
	public void testIncFromMaxValue_wrong() {
		/*
		 * This test automates what's done in CounterTester2
		 */
		Counter c = new Counter();
		try {
			c.increment();
			c.increment();
			c.increment(); 
			assertEquals("Counter reaches max", Counter.MAX_VALUE, c.getValue()); 
			c.increment(); 
			fail("ValueTooLargeException was NOT thrown as expected.");
		} catch (ValueTooLargeException e) {
			/*
			 * Problem, which call to c.increment() caused this exception?
			 * If it was either of the first calls to c.increment(), it's not right.
			 * If it was the last call to c.increment(), then it's right.
			 * Therefore, separate these groups of calls into two separate try-catch blocks. 
			 */
		}
	}
	
	@Test
	public void testIncAfterCreation() {
		Counter c = new Counter();
		assertTrue(Counter.MIN_VALUE == c.getValue());
		assertEquals(Counter.MIN_VALUE, c.getValue());
		assertEquals("Initial counter value is Counter.MIN_VALUE", Counter.MIN_VALUE, c.getValue());
		try {
			c.increment();
			assertEquals(1, c.getValue());
		}
		catch (ValueTooLargeException e) {
			fail("ValueTooLargeException thrown unexpectedly.");
		}
	}
	
	@Test
	public void testIncDecFromMiddleValues() {
		Counter c = new Counter();
		try { 
			for(int i = Counter.MIN_VALUE; i < Counter.MAX_VALUE; i ++) {
				int currentValue = c.getValue(); 
				c.increment();
				assertEquals(currentValue + 1, c.getValue()); 
			}
			for(int i = Counter.MAX_VALUE; i > Counter.MIN_VALUE; i --) {
				int currentValue = c.getValue();
				c.decrement();
				assertEquals(currentValue - 1, c.getValue());
			}
		}
		catch(ValueTooLargeException e) {
			fail("ValueTooLargeException is thrown unexpectedly");
		}
		catch(ValueTooSmallException e) {
			fail("ValueTooSmallException is thrown unexpectedly");
		}
	}
}
