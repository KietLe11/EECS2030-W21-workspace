import java.util.Scanner;

/*
 * Version 1 of console application
 * We will prompt the user of radious values of two circles
 * application will output thareas of two input circles
 * this version improves version one by calliing a usable utility method
 */


public class CircleApp2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Start the actual application code here
		
		//Step 1: Prompt User for radius of first circle
		System.out.println("Enter radius 1: ");
		double rad1 = input.nextDouble();
		
		double area1 = Circle.getArea(rad1);
		
		String area1s = String.format("%.2f ", area1);
		System.out.println("The area of circle 1 is " + area1s);
		
		
		System.out.println("Enter radius 2: ");
		double rad2 = input.nextDouble();
		
		double area2 = Circle.getArea(rad2);
		
		String area2s= String.format("%.2f ", area2);
		System.out.println("The area of circle 2 is " +area2s);
		//end of application code
		
		input.close();

	}

}
