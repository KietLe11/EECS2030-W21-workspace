package junit_tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Registration;
import model.*;

/*
 * A registration system stores a list of up to 500 transcripts. 
 * Each transcript is characterized by a student’s unique name (e.g., "Sunhye") 
 * 	and a list of up to 60 current registrations.
 *   
 * Each registration is characterized by the course name (e.g., "CSE1"), 
 * 	its number of credits (e.g., 3), and the raw marks (out of 100) for that student (e.g., 78). 
 * 
 * For more details, see the in-line comments and test methods given to you below.
 */

public class Tests {

	@Test
	public void test_01() {
		/* Create a new registration for CSE114 with 4 credits and raw marks 59 (out of 100).
		 * Requirement: Marks are integers, NOT double. 
		 */
		Registration r1 = new Registration("CSE114", 4, 59);

		assertEquals("CSE114", r1.getCourseName());
		assertEquals(4, r1.getNumberOfCredits(), 0.01);
		assertEquals(59, r1.getMarks()); 
	}//new Registration(_, _, _) expects values to be set

	@Test
	public void test_02() {
		/* Create a new registration for CSE214 with 3 credits. */
        Registration r2 = new Registration("CSE214", 3);

        assertEquals("CSE214", r2.getCourseName());
		assertEquals(3, r2.getNumberOfCredits(), 0.01);
		assertEquals(0, r2.getMarks());
    }//new Registration(_, _) expects default marks values to be set

    @Test
    public void test_03() {
    	Registration r2 = new Registration("CSE214", 3);
    	/* Change marks of the registration. */
    	r2.setMarks(34);
    	
        assertEquals("CSE214", r2.getCourseName());
		assertEquals(3, r2.getNumberOfCredits(), 0.01);
		assertEquals(34, r2.getMarks()); 
    }//new Registration(_, _) then setter methods to set customized values
    
    @Test
    public void test_04() {
    	Registration r = new Registration("CSE214", 3, 49); 
    	
    	/* Here is the map from numerical raw marks to string letter grades:
		 * Marks >= 90			: "A+"
		 * 80 <= Marks <  90	: "A"
		 * 70 <= Marks <  80	: "B"
		 * 60 <= Marks <  70	: "C"
		 * 50 <= Marks <  60	: "D"
		 * Marks < 50			: "F"
		 */
		assertEquals("F", r.getLetterGrade()); 
    }//getLetterGrade() returns F on 49
    
    @Test
    public void test_05() {
    	Registration r = new Registration("CSE214", 3, 50); 
    	 
		assertEquals("D", r.getLetterGrade()); 
    }//getLetterGrade() returns D on 50
    
    @Test
    public void test_06() {
    	Registration r = new Registration("CSE214", 3, 59); 
    	 
		assertEquals("D", r.getLetterGrade()); 
    }//getLetterGrade() returns D on 59
    
    @Test
    public void test_07() {
    	Registration r = new Registration("CSE214", 3, 60); 
    	 
		assertEquals("C", r.getLetterGrade()); 
    }//getLetterGrade() returns C on 60
    
    @Test
    public void test_08() {
    	Registration r = new Registration("CSE214", 3, 69); 
    	 
		assertEquals("C", r.getLetterGrade()); 
    }//getLetterGrade() returns C on 69
    
    @Test
    public void test_09() {
    	Registration r = new Registration("CSE214", 3, 70); 
    	 
		assertEquals("B", r.getLetterGrade()); 
    }//getLetterGrade() returns B on 70
    
    @Test
    public void test_10() {
    	Registration r = new Registration("CSE214", 3, 79); 
    	 
		assertEquals("B", r.getLetterGrade()); 
    }//getLetterGrade() returns B on 79
    
    @Test
    public void test_11() {
    	Registration r = new Registration("CSE214", 3, 80); 
    	 
		assertEquals("A", r.getLetterGrade()); 
    }//getLetterGrade() returns A on 80
    
    @Test
    public void test_12() {
    	Registration r = new Registration("CSE214", 3, 89); 
    	 
		assertEquals("A", r.getLetterGrade()); 
    }//getLetterGrade() returns A on 89
    
    @Test
    public void test_13() {
    	Registration r = new Registration("CSE214", 3, 90); 
    	 
		assertEquals("A+", r.getLetterGrade()); 
    }//getLetterGrade() returns A+ on 90
    
    @Test
    public void test_14() {
    	Registration r = new Registration("CSE214", 5, 49); 
    	
    	/*
		 * Weighted Grade Point: grade point * number of credits.
		 * Here is the map from string letter grades to numerical grade points:
		 * "A+"	: 9
		 * "A"	: 8
		 * "B"	: 7
		 * "C" 	: 6
		 * "D"	: 5
		 * "F"	: 0
		 * For example, for r1 with letter grade B (and hence grade point 7) and 3 credits, 
		 * its weighted grade point is 7 * 3. 
		 */
		assertEquals(0 * 5, r.getWeightedGradePoint()); 
    }//getWeighedGradePoint() on F 
    
    @Test
    public void test_15() {
    	Registration r = new Registration("CSE214", 5, 59); 
    	 
    	assertEquals(5 * 5, r.getWeightedGradePoint()); 
    }//getWeighedGradePoint() on D 
    
    @Test
    public void test_16() {
    	Registration r = new Registration("CSE214", 5, 69); 
    	 
    	assertEquals(6 * 5, r.getWeightedGradePoint()); 
    }//getWeighedGradePoint() on C 
    
    @Test
    public void test_17() {
    	Registration r = new Registration("CSE214", 5, 79); 
    	 
    	assertEquals(7 * 5, r.getWeightedGradePoint()); 
    }//getWeighedGradePoint() on B 
    
    @Test
    public void test_18() {
    	Registration r = new Registration("CSE214", 5, 89); 
    	 
    	assertEquals(8 * 5, r.getWeightedGradePoint()); 
    }//getWeighedGradePoint() on A
    
    @Test
    public void test_19() {
    	Registration r = new Registration("CSE214", 5, 90); 
    	 
    	assertEquals(9 * 5, r.getWeightedGradePoint()); 
    }//getWeighedGradePoint() on A+

    @Test
    public void test_21() {
		Transcript alan = new Transcript("Alan"); 
		/* Return, as an array, all the stored registrations in the transcript. 
		 * Initially, no registrations have been added to the transcript yet.
		 */
		Registration[] alanRegistrations = alan.getReport();

		assertEquals(0, alanRegistrations.length); 
	}//new Transcript("A") creates a transcript with an empty array of registrations
    
	@Test
	public void test_22() {
		Registration r1 = new Registration("CSE303", 6, 79);
		Transcript alan = new Transcript("Alan"); 
		/* Add a registration object to the transcript. */
		alan.addRegistration(r1);
		Registration[] alanRegistrations = alan.getReport();
		Registration alanRegistration1 = alanRegistrations[0];

		assertEquals(1, alanRegistrations.length);
		assertEquals("CSE303", alanRegistration1.getCourseName());
		assertEquals(6, alanRegistration1.getNumberOfCredits(), 0.01);
		assertEquals(79, alanRegistration1.getMarks());
	}//addRegistration(r1) adds in r1 accordingly

	@Test
	public void test_23() {
		Registration r1 = new Registration("CSE303", 6, 79);
		Transcript alan = new Transcript("Alan"); 
		alan.addRegistration(r1);
		/* Given information of a registration (course name and number of credits), add it
		 * to the transcript. */
		alan.addRegistration("CSE215", 6);

		Registration[] alanRegistrations = alan.getReport();

		assertEquals(2, alanRegistrations.length);
		Registration alanRegistration1 = alanRegistrations[0];

		assertEquals("CSE303", alanRegistration1.getCourseName());
		assertEquals(6, alanRegistration1.getNumberOfCredits(), 0.01);
		assertEquals(79, alanRegistration1.getMarks());

		Registration alanRegistration2 = alanRegistrations[1];
		assertEquals("CSE215", alanRegistration2.getCourseName());
		assertEquals(6, alanRegistration2.getNumberOfCredits(), 0.01);
		assertEquals(0, alanRegistration2.getMarks());
	}//add two registrations to a transcript

	@Test
	public void test_24() {
		Transcript alan = new Transcript("Alan");
		Registration[] registrations = new Registration[0];
		/* Add an array of registration objects to the transcript.
		 * The test below is just an example. Your implemented method should work for any array size. 
		 */
		alan.addRegistrations(registrations);
		assertEquals(0, alan.getReport().length);
	}//alan.addRegistrations({}) where alan has an empty array of registrations

	@Test
	public void test_25() {
		Transcript alan = new Transcript("Alan");
		Registration[] registrations = {new Registration("EECS", 2)};
		alan.addRegistrations(registrations);
		assertEquals(1, alan.getReport().length);
	}//alan.addRegistrations({_}) where alan has an empty array of registrations

	@Test
	public void test_26() {
		Transcript alan = new Transcript("Alan");
		Registration[] registrations = {new Registration("EECS1", 2), new Registration("EECS2", 2)};
		alan.addRegistrations(registrations);
		assertEquals(2, alan.getReport().length);
	}//alan.addRegistrations({_, _}) where alan has an empty array of registrations

	@Test
	public void test_27() {
		Transcript alan = new Transcript("A");
		Registration[] registrations = new Registration[60];
		for(int i = 0; i < 60; i ++) {
			registrations[i] = new Registration("EECS" + i, 2);
		}
		alan.addRegistrations(registrations);
		assertEquals(60, alan.getReport().length);
	}//alan.addRegistrations(60 registrations) where m has an empty array of registrations

	@Test
	public void test_28() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 2));
		alan.addRegistration(new Registration("EECS2", 2));
		alan.addRegistration(new Registration("EECS3", 2));
		Registration[] registrations = new Registration[0];
		alan.addRegistrations(registrations);
		assertEquals(3, alan.getReport().length);
	}//alan.addRegistrations({}) where alan has a non-empty array of registrations

	@Test
	public void test_29() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 2));
		alan.addRegistration(new Registration("EECS2", 2));
		alan.addRegistration(new Registration("EECS3", 2));
		Registration[] registrations = {new Registration("EECS4", 2)};
		alan.addRegistrations(registrations);
		assertEquals(4, alan.getReport().length);
	}//alan.addRegistrations({_}) where alan has a non-empty array of registrations

	@Test
	public void test_30() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 2));
		alan.addRegistration(new Registration("EECS2", 2));
		alan.addRegistration(new Registration("EECS3", 2));
		Registration[] registrations = {new Registration("EECS4", 2), new Registration("EECS5", 2)};
		alan.addRegistrations(registrations);
		assertEquals(5, alan.getReport().length);
	}//alan.addRegistrations({_, _}) where alan has a non-empty array of registrations

	@Test
	public void test_31() {
		Transcript alan = new Transcript("A");
		alan.addRegistration(new Registration("EECS1", 2));
		alan.addRegistration(new Registration("EECS2", 2));
		alan.addRegistration(new Registration("EECS3", 2));
		Registration[] registrations = new Registration[57];
		for(int i = 0; i < 57; i ++) {
			registrations[i] = new Registration("EECS" + (i + 4), 2);
		}
		alan.addRegistrations(registrations);
		assertEquals(60, alan.getReport().length);
	}//alan.addRegistrations(57 registrations) where alan already has 3 registrations
	
	@Test
	public void test_32() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		/* Given the name of some existing course, return its current marks on the transcript.
		 */
		assertEquals(50, alan.getMarks("EECS1"));
	}//getMarks(_) test 1
	
	@Test
	public void test_33() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		assertEquals(60, alan.getMarks("EECS2"));
	}//getMarks(_) test 2
	
	@Test
	public void test_34() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		assertEquals(70, alan.getMarks("EECS3"));
	}//getMarks(_) test 3
	
	@Test
	public void test_35() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		assertEquals(80, alan.getMarks("EECS4"));
	}//getMarks(_) test 4
	
	@Test
	public void test_36() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		assertEquals(-1, alan.getMarks("EECS5"));
	}//getMarks(_) test 5
	
	@Test
	public void test_37() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		/* Given the name of some existing course, set new marks for it on the transcript.
		 */
		alan.setMarks("EECS1", 55);
		assertEquals(55, alan.getMarks("EECS1"));
	}//setMarks(_) test 1
	
	@Test
	public void test_38() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		alan.setMarks("EECS2", 65);
		assertEquals(65, alan.getMarks("EECS2"));
	}//setMarks(_) test 2
	
	@Test
	public void test_39() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		alan.setMarks("EECS3", 75);
		assertEquals(75, alan.getMarks("EECS3"));
	}//setMarks(_) test 3
	
	@Test
	public void test_40() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		alan.setMarks("EECS4", 85);
		assertEquals(85, alan.getMarks("EECS4"));
	}//setMarks(_) test 4
	
	@Test
	public void test_41() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		/* When attempting to set marks for some non-existing course, simply do nothing.
		 */
		alan.setMarks("EECS5", 100);
		assertEquals(50, alan.getMarks("EECS1"));
		assertEquals(60, alan.getMarks("EECS2"));
		assertEquals(70, alan.getMarks("EECS3"));
		assertEquals(80, alan.getMarks("EECS4"));
		/* Given the name of some non-existing course, return -1 as it marks.
		 */
		assertEquals(-1, alan.getMarks("EECS5"));
	}//setMarks(_) test 5
	
	@Test
	public void test_42() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		
		/* Weighted GPA denotes the Weighted Grade Point Average, which is calculated by
		 * first calculating the sum of the WEIGHTED grade points of all registrations on the transcript,
		 * then by dividing the sum by the number of registrations. 
		 * For example, t1 has two registrations: 
		 * 	CSE1 (with weighted grade point 7 * 3) and CSE3 (with weighed grade point 5 * 4),
		 *  then t1's weighed GPA is calculated by (21 + 20) / 2. 
		 * Requirement: When the number of registrations on the transcript is zero, then
		 * return 0 as the weighted GPA.
		 */
		assertEquals((5 * 1) / 1.0, alan.getWeightedGPA(), 0.01);
	}//getWeightedGPA(_) test 1
	
	@Test
	public void test_43() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6 
		
		assertEquals((5 * 1 + 6 * 2) / 2.0, alan.getWeightedGPA(), 0.01);
	}//getWeightedGPA(_) test 2
	
	@Test
	public void test_44() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7 
		
		assertEquals((5 * 1 + 6 * 2 + 7 * 3) / 3.0, alan.getWeightedGPA(), 0.01);
	}//getWeightedGPA(_) test 3
	
	@Test
	public void test_45() {
		Transcript alan = new Transcript("Alan");
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		assertEquals((5 * 1 + 6 * 2 + 7 * 3 + 8 * 4) / 4.0, alan.getWeightedGPA(), 0.01);
	}//getWeightedGPA(_) test 4

	@Test
	public void test_46() {
		/* Create a registration system, which can store up to and including 500 transcripts. 
		 */
		RegistrationSystem rs = new RegistrationSystem();
		Transcript[] transcripts = rs.getReport();

		assertEquals(0, transcripts.length);
	}//new RegistrationSystem has an empty array of transcripts

	@Test
	public void test_47() {
		RegistrationSystem rs = new RegistrationSystem();
		/* Add a new transcript to the system. */
		Transcript alan = new Transcript("Alan"); 
		Transcript mark = new Transcript("Mark"); 
		rs.addTranscript(mark);
		rs.addTranscript(alan);
		/* Return, as an array, all the stored transcripts in the system. */
		Transcript[] transcripts = rs.getReport();

		assertEquals(2, transcripts.length);
		assertEquals(mark, transcripts[0]);
		assertEquals(alan, transcripts[1]);
	}//two transcripts added to an empty registration system
	
	@Test
	public void test_48() {
		RegistrationSystem rs = new RegistrationSystem();
		Transcript alan = new Transcript("Alan"); 	
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		Transcript mark = new Transcript("Mark");
		mark.addRegistration(new Registration("EECS5", 1, 90));//A+: 9
		mark.addRegistration(new Registration("EECS6", 2, 80));//A: 8
		mark.addRegistration(new Registration("EECS7", 3, 70));//B: 7
		mark.addRegistration(new Registration("EECS8", 4, 60));//C: 6
		
		rs.addTranscript(mark);
		rs.addTranscript(alan); 
		
		/* Given an existing student namd and an existing course name of that student,
		 * return the marks for that course.
		 */
		assertEquals(50, rs.getMarks(alan.getStudentName(), "EECS1"));
		assertEquals(60, rs.getMarks(alan.getStudentName(), "EECS2"));
		assertEquals(70, rs.getMarks(alan.getStudentName(), "EECS3"));
		assertEquals(80, rs.getMarks(alan.getStudentName(), "EECS4"));
	}//two transcripts added to an empty registration system, getMarks test 1
	
	@Test
	public void test_49() {
		RegistrationSystem rs = new RegistrationSystem();
		Transcript alan = new Transcript("Alan"); 	
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		Transcript mark = new Transcript("Mark");
		mark.addRegistration(new Registration("EECS5", 1, 90));//A+: 9
		mark.addRegistration(new Registration("EECS6", 2, 80));//A: 8
		mark.addRegistration(new Registration("EECS7", 3, 70));//B: 7
		mark.addRegistration(new Registration("EECS8", 4, 60));//C: 6
		
		rs.addTranscript(mark);
		rs.addTranscript(alan);
		 
		assertEquals(-1, rs.getMarks(alan.getStudentName(), "EECS5")); 
	}//two transcripts added to an empty registration system, getMarks test 2

	@Test
	public void test_50() {
		RegistrationSystem rs = new RegistrationSystem();
		Transcript alan = new Transcript("Alan"); 	
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		Transcript mark = new Transcript("Mark");
		mark.addRegistration(new Registration("EECS5", 1, 90));//A+: 9
		mark.addRegistration(new Registration("EECS6", 2, 80));//A: 8
		mark.addRegistration(new Registration("EECS7", 3, 70));//B: 7
		mark.addRegistration(new Registration("EECS8", 4, 60));//C: 6
		
		rs.addTranscript(mark);
		rs.addTranscript(alan); 

		assertEquals(90, rs.getMarks(mark.getStudentName(), "EECS5"));
		assertEquals(80, rs.getMarks(mark.getStudentName(), "EECS6"));
		assertEquals(70, rs.getMarks(mark.getStudentName(), "EECS7"));
		assertEquals(60, rs.getMarks(mark.getStudentName(), "EECS8"));
	}//two transcripts added to an empty registration system, getMarks test 3
	
	@Test
	public void test_51() {
		RegistrationSystem rs = new RegistrationSystem();
		Transcript alan = new Transcript("Alan"); 	
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		Transcript mark = new Transcript("Mark");
		mark.addRegistration(new Registration("EECS5", 1, 90));//A+: 9
		mark.addRegistration(new Registration("EECS6", 2, 80));//A: 8
		mark.addRegistration(new Registration("EECS7", 3, 70));//B: 7
		mark.addRegistration(new Registration("EECS8", 4, 60));//C: 6
		
		rs.addTranscript(mark);
		rs.addTranscript(alan); 
		
		/* If the student name exists, but the course does not exist on that student's transcript,
		 * then return -1 as the marks.
		 */
		assertEquals(-1, rs.getMarks(mark.getStudentName(), "EECS9")); 
	}//two transcripts added to an empty registration system, getMarks test 4
	
	@Test
	public void test_52() {
		RegistrationSystem rs = new RegistrationSystem();
		Transcript alan = new Transcript("Alan"); 	
		alan.addRegistration(new Registration("EECS1", 1, 50));//D: 5
		alan.addRegistration(new Registration("EECS2", 2, 60));//C: 6
		alan.addRegistration(new Registration("EECS3", 3, 70));//B: 7
		alan.addRegistration(new Registration("EECS4", 4, 80));//A: 8
		
		Transcript mark = new Transcript("Mark");
		mark.addRegistration(new Registration("EECS5", 1, 90));//A+: 9
		mark.addRegistration(new Registration("EECS6", 2, 80));//A: 8
		mark.addRegistration(new Registration("EECS7", 3, 70));//B: 7
		mark.addRegistration(new Registration("EECS8", 4, 60));//C: 6
		
		rs.addTranscript(mark);
		rs.addTranscript(alan); 
		
		/* If the student name does not exist, then return -1 as the marks.
		 */
		assertEquals(-1, rs.getMarks(mark.getStudentName() + "junk", "EECS4")); 
	}//two transcripts added to an empty registration system, getMarks test 5
	
    @Test
    public void test_53() {
	    Transcript alan = new Transcript("Alan");
	    for(int i = 0; i < 60; i ++) {
	        alan.addRegistration(new Registration("EECS" + i, 2));
        }
	    assertEquals(60, alan.getReport().length);
    }//add 60 registrations (using addRegistration(_)) for a transcript

    @Test
    public void test_54() {
        Transcript alan = new Transcript("Alan");
        for(int i = 0; i < 60; i ++) {
            alan.addRegistration("ECON" + i, 3);
        }
        assertEquals(60, alan.getReport().length);
    }//add 60 registrations (using addRegistration(_, _)) for a transcript

    @Test
    public void test_55() {
        RegistrationSystem rs = new RegistrationSystem();
        for(int i = 0; i < 500; i ++) {
            rs.addTranscript(new Transcript("Student" + i));
        }
        assertEquals(500, rs.getReport().length);
    }//add 500 transcripts to a registration system
}
