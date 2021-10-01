package circles_with_exceptions;

import java.util.Scanner;

/*
 * This class is similar to CircleCalculator1, but 
 * with an extension on handling invalid radius values 
 * iteratively using exception handling.
 */

public class CircleCalculator2 {
	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		boolean inputRadiusIsValid = false;
		while(!inputRadiusIsValid) {
			System.out.println("Enter a radius:");
			double r = input.nextDouble();
			Circle c = new Circle();
			try {
				c.setRadius(r); /* Error if r from the user is negative */
				inputRadiusIsValid = true;
				System.out.print("Circle with radius " + r);
				System.out.println(" has area: "+ c.getArea());
			}
			catch(InvalidRadiusException e) {
				System.out.println("Radius " + r + " is invalid, try again!");
			}
		}
		input.close();
	}
}
