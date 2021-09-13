package console_apps;
import java.util.Scanner;

public class SequenceApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//Prompt user and read inputs
		System.out.println("Enter the first term (FT) of an arithmetic seq. of size 5: ");
		int ft = input.nextInt();
		System.out.println("Enter the common difference (d): ");
		int d = input.nextInt();
		
		//compute result
		String seq = "<" +ft +", " + (ft+d) + ", " + (ft + 2*d) + ", "+ (ft+3*d) + ", " +(ft+4*d)  +">";
		int sum = 5*ft +(1+2+3+4)*d;
		
		System.out.println("Sequence " + seq +" has sum " + sum);
		
		input.close();
		
	}

}
