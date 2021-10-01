package version_2;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer i: ");
		int i = input.nextInt();
		B ob = new B();
		// From the method call below,
		// we know B.mb is the callee of Tester.main.
		// In Tester.main, we are required to 
		// handle the NegValException, because it was only
		// specified in the callee.
		// To handle this exception, we choose to catch it.
		try {
			ob.mb(i);
		}
		catch(NegValException nve){
			System.out.println("From Tester.main: neg val "  + i);
		}
		input.close();
	}

}
