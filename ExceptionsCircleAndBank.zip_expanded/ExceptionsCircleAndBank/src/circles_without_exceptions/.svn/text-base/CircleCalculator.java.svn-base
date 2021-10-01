package circles_without_exceptions;

import java.util.Scanner;

public class CircleCalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a radius:");
		double r = input.nextDouble();
		Circle c = new Circle();
		// We say CircleCalculator.main
		// is the caller of Circle.setRadius
		c.setRadius(r); /* Error if r from the user is negative */
		
		// When the user enters -10 as r, the method call
		// c.setRadius(r) prints out an error message to console.
		// However, given that an error already occurrs, 
		// the following two lines which calculate the area of circle,
		// are still executed.
		
		System.out.print("Circle with radius " + r);
		System.out.println("has area: "+ c.getArea());
	}
}
