import java.util.Scanner;

/*
 * Version 1 of console application
 * We will prompt the user of radious values of two circles
 * application will output thareas of two input circles
 */


public class CircleApp1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Start the actual application code here
		
		//Step 1: Prompt User for radius of first circle
		System.out.println("Enter radius 1: ");
		double rad1 = input.nextDouble();
		double area1 = Math.PI*rad1*rad1;
		
		System.out.println("Enter radius 2: ");
		double rad2 = input.nextDouble();
		double area2 = Math.PI*rad2*rad2;
		
		String area1s = String.format("%.2f ", area1);
		String area2s= String.format("%.2f ", area2);
		
		System.out.println("The area of circle 1 is " + area1s);
		System.out.println("The area of circle 2 is " +area2s);
		
		//end of application code
		
		input.close();

	}

}
