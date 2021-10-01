package version_1;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an inter value i: ");
		int i = input.nextInt();

		B ob = new B();

		// From the method call below,
		// we know: 
		// 1. Tester.main is the caller of B.mb.
		// 2. From the header of B.mb, does not throw any exception.
		//    (Catch-or-Specify requirement)
		// This means Tester.main is not subject to the catch-or-specify requirement. 
		ob.mb(i);
		
		input.close();
	}

}
