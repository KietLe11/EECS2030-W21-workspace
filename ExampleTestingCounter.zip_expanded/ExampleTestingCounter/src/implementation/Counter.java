package implementation;

public class Counter {
	/*
	 * Global Constants for All Counter Objects
	 */
	public static final int MAX_VALUE = 3;  
	public static final int MIN_VALUE = 0;
	
	/*
	 * Implementation Attribute
	 */
	private int value;
	
	public int getValue() {
		return this.value;
	}
	
	/*
	 * Constructor
	 */
	public Counter() {
		this.value = MIN_VALUE;
	}

	/*
	 * Mutators
	 */
	public void increment() throws ValueTooLargeException {
		/*
		 * Try the following WRONG implementations and see how
		 * the console tester CounterTester2 can reveal the errors:
		 * 1. Change the if condition to:
		 * 		this.value < Counter.MAX_VALUE
		 * 	This would trigger the error message printed from the
		 * 	outer catch block: 
		 * 		"Error: ValueTooLargeException was thrown unexpectedly."
		 * 2. Change the if condition to:
		 * 		this.value > Counter.MAX_VALUE
		 * 	This would trigger the error message printed from 
		 * 	Line 18 (right before the inner catch block):
		 * 		"Error: ValueTooLargeException was NOT thrown as expected." 
		 */
		if(this.value == Counter.MAX_VALUE) {
			throw new ValueTooLargeException("Too large to increment");
		}
		else { 
			value += 1; 
		}
	}
	
	public void decrement() throws ValueTooSmallException {
		/*
		 * Try the following WRONG implementation and see how
		 * the console tester CounterTester1 can reveal the error:
		 * 1. Change the if condition to:
		 * 		this.value < Counter.MIN_VALUE
		 * 	This would trigger the error message printed from
		 * 	Line 12 (right before the catch block) 
		 * 		"Error: ValueTooSmallException NOT thrown as expected." 
		 */
		if(this.value == Counter.MIN_VALUE) {
			throw new ValueTooSmallException("Too small to increment");
		}
		else { 
			value -= 1; 
		}
	}
}
