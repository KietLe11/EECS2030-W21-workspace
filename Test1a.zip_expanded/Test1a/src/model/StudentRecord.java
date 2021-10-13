package model;

public class StudentRecord {
	
	private String courseName;
	private int noa;
	private Assessment[] assessments;
	

	public StudentRecord(String courseName) {
		this.courseName = courseName;
		assessments = new Assessment[10];
	}
	
	public String getCourse() {
		return courseName;
	}
	
	//"Number of assessments in EECS2030: 2 [Midterm 1 (weight: 15.379 percents; marks: 75), Midterm 2 (weight: 25.378 percents; marks: 80)]"
	public String getAssessmentReport() {
		
		String assessmentReport = String.format("Number of assessments in %s: %d [",courseName, noa);
		if(noa>0) {
			for(int i =0; i<noa; i++) {
				assessmentReport += String.format("%s (weight: %.3f percents; marks: %d)", assessments[i].getAssessmentName(), assessments[i].getWeight()*100,
						assessments[i].getMarks());
				if(i!=noa-1) {
					assessmentReport += ", ";
				}
			}
		}
		
		assessmentReport += "]";
		return assessmentReport;
	}
	
	public double getCompletionRate() {
		double completionRate = 0;
		for(int i =0; i<noa; i++) {
			completionRate += assessments[i].getWeight();
		}
		return completionRate;
	}
	
	public double getRawMarks() {
		double rawMarks=0;
		for(int i =0; i<noa; i++) {
			rawMarks += assessments[i].getWeight()*assessments[i].getMarks();
		}
		return rawMarks;
	}
	
	public void addAssessment(String aName, double weight, int mark) {
		assessments[noa] = new Assessment(aName, weight);
		assessments[noa].setMarks(mark);
		
		noa++;
	}
	public void addAssessment(Assessment newAss) {
		assessments[noa] = newAss;
		noa++;
	}
	
	public void changeMarksOf(String aName, int marks) {
		
		for(int i = 0; i<noa; i++) {
			if(assessments[i].getAssessmentName().equals(aName)) {
				assessments[i].setMarks(marks);
				break;
			}
		}
	}
	
	public void removeAssessment(String aName) {
		int position = 0;
		boolean assessmentFound = false;
		
		
		for(int i = 0; i<noa; i++) {
			if(assessments[i].getAssessmentName().equals(aName)) {
				position = i;
				assessmentFound = true;
				break;
			}
		}
		
		if(assessmentFound) {
			for(int i = position; i<noa;i++) {
				assessments[i] = assessments[i+1];
			}
			assessments[noa] =null;
			noa-=1;
		}
		
	}
}
