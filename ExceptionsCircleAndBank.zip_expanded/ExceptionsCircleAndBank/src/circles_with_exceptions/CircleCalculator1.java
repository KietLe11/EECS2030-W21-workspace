package circles_with_exceptions;

import java.util.Scanner;

public class CircleCalculator1 {
	public static void main(String[] args) {
		// If we choose not to handle the InvalidRadiusException,
		// we can specify it as part of the signature
		// of the main method
		// throws InvalidRadiusException {
		Scanner input = new Scanner(System.in);
		boolean inputRadiusIsValid = false;

		while(!inputRadiusIsValid) {

			System.out.println("Enter a radius: ");
			double r = input.nextDouble();
			Circle c = new Circle();


			//		double r =0;
			//		while(!(r>0)) {
			//			System.out.println("Enter a radius:");
			//			r = input.nextDouble();
			//			if(r<0) {
			//				System.out.println("Radius "+ r+" is invalid, try again!");
			//			}
			//		}

			// We say CircleCalculator.main
			// is the caller of Circle.setRadius

			// This line here calls a method
			// that throws InvalidRadiusException.
			// We can either specify it or catch it.
			// To catch the exception, we use a try-catch block.
			try {
				c.setRadius(r); /* Error if r from the user is negative */
				inputRadiusIsValid = true;
				System.out.print("Circle with radius " + r);
				System.out.println("has area: "+ c.getArea());
			}
			catch(InvalidRadiusException e) {//if there is an exception, then the catch is initiated. In this case there is nothing done because the catch block is empty
				// Do something to handle the error.
				//the catch was executed. There was just no effect.
				System.out.println("Radius "+ r+" is invalid, try again!");
			}
		}
		input.close();
	}
}
