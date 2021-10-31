package with_inheritance;

public class NonResidentStudent extends Student {
	/* Attributes name, registeredCourses, and noc
	 * are all inherited from the parent class Student.
	 * So there's no need to declare them here. 
	 */
	
	/* We only need to declare attributes and methods that are
	 * unique to NonResidentStudent */
	double discountRate;
	void setDiscountRate(double r) {
		discountRate = r;
	}
	
	/* We must re-declare the constructor. */
	NonResidentStudent(String name) {
		/* super keyword here refers to the
		 * constructor in the parent class (Student). */
		super(name);
	}
	
	/* We can reuse the definition of method register
	 * completely, so there's no need to redefine it. */
	
	/* For the getTuition() method that is inherited from
	 * the parent class (Student), we want to reuse it,
	 * and add something more to it. 
	 * That is, we want to redefine/override it.*/
	double getTuition() {
		/* This line calls the version of 
		 * getTuition() from the parent class (Student) */
		double base = super.getTuition();
		return base * discountRate;
	}
}
