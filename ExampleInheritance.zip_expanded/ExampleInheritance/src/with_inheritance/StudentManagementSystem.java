package with_inheritance;

public class StudentManagementSystem {
	/* Since ResidentStudnet extends Student, and
	 * NonResidentStudent extends Student,
	 * we may consider their parent class (Student)
	 * as their "representative". 
	 */
	// This array can store any objects whose types
	// are sub/child classes of Student (i.e., RS and NRS).
	Student[] students;
	int nos; /* number of students */
	
	public StudentManagementSystem() {
		students = new Student[30];
	}
	
	void addStudent(Student s) {
		students[nos] = s;
		nos ++;
	}
	
	void registerAll(Course c) {
		// we only need to update one single array.
		for(int i = 0; i < nos; i ++) {
			students[i].register(c);
		}
	}
}




