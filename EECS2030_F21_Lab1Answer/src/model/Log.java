package model;

public class Log {
	
	private String version;
	
	/*Programming pattern (part 2 of review tutorial */
	private String[] fixes;
	private int nof; /* number of fixes*/
	private final int MAX_NUM_OF_FIXES = 10;
	
	public Log(String version) {
		this.version = version;
		this.fixes = new String[MAX_NUM_OF_FIXES];
		this.nof = 0;
	}

	public void addFix(String fix) {
		this.fixes[this.nof] = fix;
		this.nof++;
	}

	public String getVersion() {
		return this.version;
	}

	public int getNumberOfFixes() {
		return this.nof;
	}
	
	public String getFixes() {
		String s = "";
		
		s+="[";
		//why not i<this.fixes.length?
		//[s1, s2, s3] comm
		for(int i =0; i<this.nof;i++) {
			s+= this.fixes[i];
			if(i<this.nof-1) {
				s+=", ";
			}
		}
		s+="]";
		
		return s;	 
	}
	
	public String toString() {
		return String.format("Version %s contains %d fixes %s", this.version, this.getNumberOfFixes(), this.getFixes());
	}
	
	
	
	
}
