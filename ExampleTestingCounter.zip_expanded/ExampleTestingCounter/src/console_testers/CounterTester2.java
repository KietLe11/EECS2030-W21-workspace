package console_testers;

import implementation.Counter;
import implementation.ValueTooLargeException; 

public class CounterTester2 {
	public static void main(String[] args) {
		Counter c = new Counter();
		System.out.println("Current val: " + c.getValue());
		try {
			c.increment(); /* ValueTooLargeException not expected */
			c.increment(); /* ValueTooLargeException not expected */
			c.increment(); /* ValueTooLargeException not expected */
			
			System.out.println("Current val: " + c.getValue());
			try {
				c.increment(); /* ValueTooLargeException expected */
				System.out.println("Error: ValueTooLargeException was NOT thrown as expected.");
			} catch (ValueTooLargeException e) {
				System.out.println("Success: ValueTooLargeException thrown as expected.");
			}
		} catch (ValueTooLargeException e) {
			System.out.println("Error: ValueTooLargeException was thrown unexpectedly.");
		}
	}
}
