package without_inheritance;

public class StudentTester {

	public static void main(String[] args) {
		ResidentStudent jim = new ResidentStudent("Jim");
		Course cse114 = new Course("CSE114", 500.0);
		Course cse215 = new Course("CSE215", 500.0);
		
		jim.register(cse114);
		jim.register(cse215);
		
		jim.setPremiumRate(1.25);
		
		System.out.println("Jim's tuition: " + jim.getTuition());
		
		NonResidentStudent jeremy = new NonResidentStudent("Jeremy");
		
		jeremy.register(cse114);
		jeremy.register(cse215);
		
		jeremy.setDiscountRate(0.75);
		
		System.out.println("Jeremy's tuition: " + jeremy.getTuition());
	}

	
	
	
	
	
	
}
