package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Sequence;

public class TestSequence {

	@Test
	public void testGetSequence() {
		String answer = Sequence.getSequence(3, 2);
		assertEquals("Sequence <3, 5, 7, 9, 11> has sum 35", answer);
	}

}
