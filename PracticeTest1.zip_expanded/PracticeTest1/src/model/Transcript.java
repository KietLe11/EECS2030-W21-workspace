package model;



public class Transcript {

	private String name;
	private Registration[] r;
	private int numOfRegistrations;
	private final int MAX_NUM_OF_TRANSCRIPTS = 500;

	public Transcript(String name) {
		this.name = name;

		r = new Registration[MAX_NUM_OF_TRANSCRIPTS];
	}

	public Registration[] getReport() {

		Registration[] report = new Registration[numOfRegistrations];
		for(int i = 0; i<numOfRegistrations; i++) {
			report[i] = r[i];
		}
		return report;
	}

	public int getMarks(String course) {
		int marks =-1;
		for(int i =0; i<numOfRegistrations;i++) {
			if(r[i].getCourseName().equals(course)) {
				marks = r[i].getMarks();
				break;
			}
		}
		return marks;
	}
	public double getWeightedGPA() {
		int totalWeightedGradePoint =0;
		
		for(int i =0; i<numOfRegistrations;i++) {
			totalWeightedGradePoint += r[i].getWeightedGradePoint();
		}
		double weightedGPA = ((double) totalWeightedGradePoint)/numOfRegistrations;
		return weightedGPA;
	}

	public void addRegistration(Registration newR) {
		r[numOfRegistrations] = newR;
		numOfRegistrations ++;
	}
	public void addRegistration(String courseName, int numOfCredits) {
		Registration newR = new Registration(courseName, numOfCredits);
		this.addRegistration(newR);
	}
	public void addRegistrations(Registration[] newRs) {
		int counter =0;
		int initialNumRs = numOfRegistrations;
		for(int i = numOfRegistrations; i<(initialNumRs+newRs.length) && (i<MAX_NUM_OF_TRANSCRIPTS); i++) {
			r[i] = newRs[counter];
			counter++;
			numOfRegistrations++;
		}
	}
	public void setMarks(String courseName, int mark) {
		for(int i =0; i<numOfRegistrations;i++) {
			if(r[i].getCourseName().equals(courseName)) {
				r[i].setMarks(mark);
				break;
			}
		}
	}
	public String getStudentName() {
		return name;
	}
}
