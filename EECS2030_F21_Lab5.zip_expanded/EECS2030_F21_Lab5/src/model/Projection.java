package model;

public class Projection extends BinarySeqOperation{

	int[] projection;
	int[] seq1a;
	int[] seq2;
	
	public Projection(int[] seq1a, int[] seq2) {
		this.seq1a = seq1a;
		this.seq2 = seq2;
		
		//seq1 = [2,1,6,3,1,4,5,3] to seq2 = [1,3,5]
		//loop through each value of seq2, comparing to each value of seq1
		int matches = 0;
		int[] tempProjection = new int[seq2.length];
		for(int i = 0; i<seq2.length;i++) {
			for(int j = 0; j<seq1a.length; j++) {
				if(seq2[i] == seq1a[j]) {
					tempProjection[matches] = seq2[i];
					matches++;
					break;
				}
			}
		}
		
		projection = new int[matches];
		
		for(int i = 0; i<matches; i++) {
			projection[i] = tempProjection[i];
		}
		
	}

	public String toString() {
		String s = "";
		s +="Projecting [";
		for(int i = 0; i<seq1a.length; i++) {
			s+= seq1a[i];
			if(i!=seq1a.length-1) {
				s+=", ";
			}
		}
		s+= "] to [";
		for(int i = 0; i<seq2.length; i++) {
			s+= seq2[i];
			if(i!=seq2.length-1) {
				s+=", ";
			}
		}
		s+="] results in: [";
		for(int i = 0; i<projection.length; i++) {
			s+= projection[i];
			if(i!=projection.length-1) {
				s+=", ";
			}
		}
		s+= "]";
		return s;
	}
}
