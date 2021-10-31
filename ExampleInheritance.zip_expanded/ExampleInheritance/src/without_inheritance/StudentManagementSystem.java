package without_inheritance;

public class StudentManagementSystem {
	/*
	 * Since ResidentStudent and NonResidentStudent
	 * are different classes, we CANNOT have 
	 * a single array that stores objects of both kinds.
	 */
	ResidentStudent[] rs;
	int nors;
	NonResidentStudent[] nrs;
	int nonrs;
	
	public StudentManagementSystem() {
		rs = new ResidentStudent[200];
		nrs = new NonResidentStudent[200];
	}
	
	void addResidentStudent(ResidentStudent s) {
		rs[nors] = s;
		nors ++;
	}
	
	void addNonResidentStudent(NonResidentStudent s) {
		nrs[nonrs] = s;
		nonrs ++;
	}
	
	/*
	 * Register a common course for all students in the
	 * system.
	 */
	void registerAll(Course c) {
		/*
		 * The number of loops depends on the
		 * number of kinds of students. 
		 * Each kind of students is stored
		 * in a separate array.
		 */
		for(int i = 0; i < nors; i ++) {
			rs[i].register(c);
		}
		for(int i = 0; i < nonrs; i ++) {
			nrs[i].register(c);
		}
	}
}





