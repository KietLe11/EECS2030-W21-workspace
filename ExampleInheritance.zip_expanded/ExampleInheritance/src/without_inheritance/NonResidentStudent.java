package without_inheritance;

public class NonResidentStudent {
	String name;
	Course[] registeredCourses;
	int noc; /* number of courses */
	
	/* this is unique to resident students */
	double discountRate;
	
	NonResidentStudent(String name) {
		this.name = name;
		registeredCourses = new Course[30];
	}
	
	void setDiscountRate(double r) {
		discountRate = r;
	}
	
	void register(Course c) {
		/* Place #2 to have a new course policy. */
		if(noc >= 5) {
			/* Error. */
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
		
		return base * discountRate;
	}
}
