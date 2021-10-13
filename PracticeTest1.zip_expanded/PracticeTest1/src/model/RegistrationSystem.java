package model;

public class RegistrationSystem {

	Transcript[] transcripts;
	int numberOfTranscripts;
	
	public RegistrationSystem() {
		transcripts = new Transcript[500];
	}
	
	public Transcript[] getReport() {
		Transcript[] report = new Transcript[numberOfTranscripts];
		
		if(numberOfTranscripts !=0) {
			for(int i = 0; i<numberOfTranscripts; i++){
				report[i] = transcripts[i];
			}
		}
		return report;
	}
	
	public void addTranscript(Transcript trans) {
		transcripts[numberOfTranscripts] = trans;
		numberOfTranscripts++;
	}
	
	public int getMarks(String name, String course) {
		
		int marks = -1;
		
		for(int i =0; i<numberOfTranscripts; i++) {
			if(transcripts[i].getStudentName().equals(name)){
				for(int d = 0; d<transcripts[i].getReport().length; d++) {
					if(transcripts[i].getReport()[d].getCourseName().equals(course)) {
						marks = transcripts[i].getReport()[d].getMarks();
						break;
					}
				}
				break;
			}
		}
		return marks;
	}
	
}
