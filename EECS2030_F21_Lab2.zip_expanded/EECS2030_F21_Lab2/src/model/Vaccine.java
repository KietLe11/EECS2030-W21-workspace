package model;

public class Vaccine {

	public String codename;
	public String type;
	public String maker;
	
	private String toStringReturn = "";
	
	public String[] recognizedVax = {"mRNA-1273","BNT162b2","Ad26.COV2.S", "AZD1222"};
	private boolean recognized = false;
	
	public Vaccine(String codename, String type, String maker) {
		this.codename = codename;
		this.type = type;
		this.maker = maker;
		
		
		for(int i = 0; i<4;i++) {
			if(this.codename.equals(recognizedVax[i])) {
				recognized = true;
				break;
			}
		}
		
	}
	
	public String toString() {
		if(recognized) {
			toStringReturn = String.format("Recognized vaccine: %s (%s; %s)", codename, type, maker);
		}
		else {
			toStringReturn = String.format("Unrecognized vaccine: %s (%s; %s)", codename, type, maker);
		}
		return toStringReturn;
	}
	
	public String getVaccineName(int i) {
		return (recognizedVax[i]);
	}
	
}
