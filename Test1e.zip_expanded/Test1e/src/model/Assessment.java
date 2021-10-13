package model;

public class Assessment {

	private String aName;
	private String status;
	private int marks;
	private double weight;
	
	public Assessment(String aName, double weight) {
		this.aName = aName;
		this.weight = weight;
		
		status = String.format("Assessment created: %s accounts for %.3f percents of the course.", aName, weight*100);
	}
	
	public String toString() {
		return status;
	}
	public String getAssessmentName() {
		return aName;
	}
	
	public int getMarks() {
		return marks;
	}
	public double getWeight() {
		return weight;
	}
	
	public void setMarks(int marks) {
		status = String.format("Marks of assessment %s (accounting for %.3f percents of the course) is changed from %d to %d.", aName, weight*100, this.marks, marks) ;
		this.marks = marks;
	}
	public void setWeight(double weight) {
		status = String.format("Weight of assessment %s (with marks %d) is changed from %.3f percents to %.3f percents." , aName, marks, this.weight*100, weight*100 ); 
		this.weight = weight;
	}
}
