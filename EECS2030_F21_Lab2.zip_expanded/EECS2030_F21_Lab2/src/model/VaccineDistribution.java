package model;

public class VaccineDistribution {

	private int numOfDoses;
	private Vaccine vax;
	
	public VaccineDistribution(Vaccine vax, int numOfDoses) {
		this.numOfDoses = numOfDoses;
		this.vax = vax;
	}
	
	public String toString() {
		String s = "";
		s = String.format("%d doses of %s by %s", numOfDoses, vax.codename, vax.maker);
		return s;
	}
}
