package console_apps;
import java.util.Scanner;

import model.Sequence;

public class SequenceApp2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//Prompt user and read inputs
		System.out.println("Enter the first term (FT) of an arithmetic seq. of size 5: ");
		int ft = input.nextInt();
		System.out.println("Enter the common difference (d): ");
		int d = input.nextInt();
		
		//compute result
		String answer = Sequence.getSequence(ft, d);
		
		System.out.println(answer);
		
		input.close();
		
	}

}
