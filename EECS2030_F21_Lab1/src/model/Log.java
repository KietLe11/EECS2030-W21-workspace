package model;

public class Log {
	
	private String update;
	private int numberOfFixes;
	private String[] fixes;
	
	//Constructor for Update Logs
	public Log(String update) {
		this.update = update;
		this.fixes = new String[10];
	}

	//Accessor Methods for Log class 
	
	public String getVersion() {
		if(update!=null) {
			return this.update;
		}
		return "n/a";
	}
	public int getNumberOfFixes() {
		return this.numberOfFixes;
	}
	public String getFixes() {
		String fixes = "[";
		for (int i = 0; i<numberOfFixes; i++) {
			
			if(i!=0 && i!= (numberOfFixes)) {
				fixes += ", ";
			}
			fixes += this.fixes[i];
		}
		fixes += "]";
		return(fixes);
	}
	
	public String toString() {
		return("Version " + this.update + " contains " + numberOfFixes + " fixes " + this.getFixes());
	}
	
	//Mutator Class for Log class
	public void addFix(String fix) {
		
		fixes[numberOfFixes] = fix;
		numberOfFixes ++;
	}
	
	
	
}
