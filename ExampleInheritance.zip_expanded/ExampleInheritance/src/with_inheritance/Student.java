package with_inheritance;

/*
 * We define what is common between ResidentStudent and
 * NonResidentStudent in this single place.
 */

public class Student {
	String name;
	Course[] registeredCourses;
	int noc; /* number of courses */
	
	/* premimumRate or discountRate does not belong
	 * to this class. */
	
	Student(String name) {
		this.name = name;
		registeredCourses = new Course[30];
	}
	
	void register(Course c) {
		/* Place #1 to have a new course policy. */
		if(noc >= 5) {
			/* Error */
		}
		else {
			registeredCourses[noc] = c;
			noc ++;
		}
	}
	
	double getTuition() {
		double base = 0;
		
		for(int i = 0; i < noc; i ++) {
			base += registeredCourses[i].fee;
		}
		
		return base;
	}
}
