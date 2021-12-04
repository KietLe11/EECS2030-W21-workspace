package model;

public class OccursWithin extends BinarySeqOperation{
		
	private boolean occursWithin;
	private int[] seq1, seq2;
	
	public OccursWithin(int[] seq1, int[] seq2) {
		this.seq1 = seq1;
		this.seq2 = seq2;
		//Does seq1 occur within seq2?
		
		
		
		if(seq1.length>seq2.length) {
			occursWithin = false;
		}
		else if(seq1.length==0) {
			occursWithin=true;
		}
		else {
			//check each number number of seq2 to see if it equals the first number...
			//of seq1. If it does, we check the next few bits to see if the sequence is...
			//contained
			/*
			 * [3, 1, 4, 5] occurs within [2, 1, 6, 3, 1, 4, 5, 3]
			 */
			for(int i = 0; i<seq2.length;i++) {
				if(seq2[i] == seq1[0]) {
					for(int j = i; j<i+seq1.length;j++) {
						if(seq2[j]==seq1[j-i]) {
							occursWithin= true;
						}
						else {
							occursWithin=false;
							break;
						}
					}
				}
				if(occursWithin) {
					break;
				}
			}
		}
		
		
	}
	
	public String toString() {
		String s = "[";
		for(int i = 0; i<seq1.length; i++) {
			s+= seq1[i];
			if(i!=seq1.length-1) {
				s+=", ";
			}
		}
		s+="]";
		
		if(occursWithin) {
			s+= " occurs within [";
		}
		else {
			s+=" does not occur within [";
		}
		
		for(int i = 0; i<seq2.length; i++) {
			s+= seq2[i];
			if(i!=seq2.length-1) {
				s+=", ";
			}
		}
		s+="]";
		
		return s;
	}
}
