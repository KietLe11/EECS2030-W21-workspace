package model;

public class Registration {

	private int numOfCredits;
	private int marks;
	private String courseName;
	private int gradePoint;
	
	public Registration(String course, int credits, int marks) {
		this.numOfCredits = credits;
		this.courseName = course;
		this.marks = marks;
	}
	
	public Registration(String courseName, int credits) {
		this.courseName = courseName;
		this.numOfCredits = credits;
	}
	public String getCourseName(){
		return this.courseName;
	}
	public int getNumberOfCredits() {
		return numOfCredits;
	}
	public int getMarks() {
		return marks;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public String getLetterGrade() {
		String letterGrade ="";
		
		if(marks>=90) {
			letterGrade = "A+";
			gradePoint = 9;
		}
		else if(marks>= 80) {
			letterGrade = "A";
			gradePoint = 8;
		}
		else if(marks>=70) {
			letterGrade ="B";
			gradePoint = 7;
		}
		else if(marks>=60) {
			letterGrade = "C";
			gradePoint = 6;
		}
		else if(marks>=50) {
			letterGrade="D";
			gradePoint = 5;
		}
		else if(marks<50) {
			letterGrade="F";
			gradePoint = 0;
		}
		return letterGrade;
	}
	
	public int getWeightedGradePoint() {
		String letterGrade = this.getLetterGrade();
		int weightedGradePoint = gradePoint*numOfCredits;
		return weightedGradePoint;
	}
}
