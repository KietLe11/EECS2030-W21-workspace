package model;

public class Sequence {

	public static String getSequence(int ft, int d){
		
		String seq = "<" +ft +", " + (ft+d) + ", " + (ft + 2*d) + ", "+ (ft+3*d) + ", " +(ft+4*d)  +">";
		int sum = 5*ft +(1+2+3+4)*d;
		
		return ("Sequence " + seq +" has sum " + sum);
	}
	
}
