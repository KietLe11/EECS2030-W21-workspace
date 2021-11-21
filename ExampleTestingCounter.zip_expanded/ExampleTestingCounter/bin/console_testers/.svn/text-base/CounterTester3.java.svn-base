package console_testers;

import java.util.Scanner;
import implementation.Counter;
import implementation.ValueTooLargeException;
import implementation.ValueTooSmallException;

public class CounterTester3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String cmd = null;
		Counter c = new Counter();
		boolean userWantsToContinue = true;
		while (userWantsToContinue) {
			System.out.println("Enter \"inc\", \"dec\", or \"val\":");
			cmd = input.nextLine();
			try {
				if (cmd.equals("inc")) {
					c.increment();
				} else if (cmd.equals("dec")) {
					c.decrement();
				} else if (cmd.equals("val")) {
					System.out.println(c.getValue());
				} else {
					userWantsToContinue = false;
					System.out.println("Bye!");
				}
			} catch (ValueTooLargeException e) {
				System.out.println("Value too big!");
			} catch (ValueTooSmallException e) {
				System.out.println("Value too small!");
			}
		}
		input.close();
	}
}
