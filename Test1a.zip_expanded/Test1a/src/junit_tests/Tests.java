package junit_tests;

import static org.junit.Assert.*;
import model.*;

import org.junit.Test;

/*
 * Problem:
 * 
 * - You are required to implement a small system for managing student records.
 * 
 * - Each student record is characterized by the tile of a course they are taking (e.g., "EECS2030") 
 * 		and a (possibly empty) array of assessments. 
 * 	 
 *   We assume that the maximum number of assessments of each student record is 10.
 * 
 * - Each assessment is characterized by: 
 * 		+ its name (e.g., Midterm 1)
 * 		+ its weight of the course final grade (e.g., 0.15234 which means 15.234 percents)
		+ marks that the student receives for that assessment (e.g., 65) 
 * 		
 *   For simplicity, we assume that the maximum marks for each assignment is 100. 
 *   Marks of an assessment may be changed.
 * 
 * - Given a student record, we may:
 * 		+ Add a new assessment.
 * 		+ Delete an assessment whose name matches the input string.
 * 			You can assume that all added assessments contain no duplicates of names. 
 * 			(meaning that if the input name is an existing name of assessment, 
 * 				there is only one â€œslotâ€� in the array of assessments to be â€œremovedâ€�).
 *  
 * 			If a non-existing name of assessment is given, then do nothing without modifying anything.
 * 		+ Change the marks of an assessment identified by some name (if that name exists). 
 * 			If a non-existing name of assessment is given, then change nothing.
 * 		+ Return a report of the assessments so far.
 * 		+ Return the rate of completion of so far.
 * 		+ Return the raw marks so far.
 * 
 * - As an example, say in the student record of HeeYeon for her EECS2030, 
 * 		there are two assessments so far:
 * 			1. Midterm 1 (weighting 15% of the course), for which she receives 75 marks
 * 			2. Lab Test 1 (weighting 20% of the course), for which she receives 60 marks
 * 	 
 *   Then HeeYeonâ€™s completion rate so far is 15% + 20% = 35% (i.e., 0.35), 
 *   	and her raw marks so far are: 75 * 0.15 + 60 * 0.2 = 23.25
 */

public class Tests {
	/*
	 * 1. Do NOT create any new packages. 
	 * 		All classes you create must be in the `model` package.
	 * 
	 * 2. All attributes you declare in the classes must be *** private ***.
	 * 
	 * 3. You are free to create additional private or public helper methods.
	 * 
	 * 4. You must NOT create any class not indicated by the given JUnit tests.
	 * 
	 * 5. You must NOT put any System.out.print statements in the classes you create.
	 * 
	 * 6. Programming Requirements:
	 * 	- You are only allowed to use primitive arrays (e.g., int[], String[], Facility[]) 
	 * 		for declaring attributes and implementing methods.
	 * 	- Any use of a Java library class or method is forbidden 
	 * 		(that is, use selections and loops to build your solution from scratch instead):
	 * 	- Here are some examples of forbidden classes/methods: 
	 * 		- Arrays class (e.g., Arrays.copyOf)
	 * 		- System class (e.g., System.arrayCopy)
	 * 		- ArrayList class
	 * 		- String class (e.g., substring).
	 * 	- The use of some library classes does not require an import statement, 
	 * 		but these classes are also forbidden to be used.
	 * 	- Here are the exceptions (library methods which you are allowed to use if needed):
	 * 		- String class (equals, format)
	 * 
	 * You will receive a penalty as specified on the test guide if this requirement is violated.
	 */
	
	/*
	 * Your expected workflow should be:
	 * 
	 * Step 1: Eliminate compilation errors. 
	 * 	Declare all the required classes and methods (returning default values if necessary), 
	 * 	so that the project contains no compilation errors (i.e., no red crosses shown on the Eclipse editor).
	 * 
	 * Step 2: Pass all unit tests. Add private attributes and complete the method implementations accordingly, 
	 * 	so that executing all tests result in a green bar.
	 * 
	 * If necessary, you are free to declare (private or public) helper methods.
	 * 
	 * Any new classes that are ***not*** indicated by the given JUnit tests will be ***disregarded*** in grading. 
	 */
	
	/*
	 * Tests related to the Assessment class.
	 */
	
	@Test
	public void test_assessment_01a() { 
		/* 
		 * Initialize a midterm assessment object 
		 * 	with initial name and weight. 
		 * The marks are uninitialized and left as default.
		 * 
		 * Note. percentage value of the weight should be displayed with
		 * 			3 digits after the decimal point.
		 */
		Assessment m1 = new Assessment("Midterm 1", 0.154736);
		assertEquals("Assessment created: Midterm 1 accounts for 15.474 percents of the course.", m1.toString());
	}
	
	@Test
	public void test_assessment_01b() { 
		/* 
		 * Initialize a midterm assessment object 
		 * with initial name and weight. 
		 * The marks are uninitialized and left as default.
		 * 
		 * Note. percentage value of the weight should be displayed with
		 * 			3 digits after the decimal point.
		 */
		Assessment m1 = new Assessment("Midterm 1", 0.154736);
		
		/* Change the marks of the midterm assessment. */
		m1.setMarks(75);
		assertEquals("Marks of assessment Midterm 1 (accounting for 15.474 percents of the course) is changed from 0 to 75.", m1.toString());
		
		m1.setMarks(83);
		assertEquals("Marks of assessment Midterm 1 (accounting for 15.474 percents of the course) is changed from 75 to 83.", m1.toString());
	} 	
	
	@Test
	public void test_assessment_01c() { 
		/* 
		 * Initialize a midterm assessment object 
		 * with initial name and weight. 
		 * The marks are uninitialized and left as default.
		 * 
		 * Note. percentage value of the weight should be displayed with
		 * 			3 digits after the decimal point.
		 */
		Assessment m1 = new Assessment("Midterm 1", 0.154736);
		
		m1.setMarks(83);
		
		/* Change the weight of the midterm assessment. */
		m1.setWeight(0.173834);
		assertEquals("Weight of assessment Midterm 1 (with marks 83) is changed from 15.474 percents to 17.383 percents.", m1.toString());
	} 	
	
	/*
	 * Tests related to the StudentRecord class.
	 */
	
	@Test
	public void test_student_record_01() {
		/* 
		 * Initialize a student record with course name. 
		 */
		StudentRecord heeyeon = new StudentRecord("EECS2030");
		assertEquals("EECS2030", heeyeon.getCourse());
		
		/* no assessments so far -> empty list of assessments listed within [] */
		String report = heeyeon.getAssessmentReport(); 
		assertEquals("Number of assessments in EECS2030: 0 []", report);
		
		/*
		 * For example calculations of the completion rate and raw marks,
		 * 	see the Problem section at the top of this test file.
		 */
		
		/* no assessments so far -> 0.0 completion rate */
		assertEquals(0.0, heeyeon.getCompletionRate(), 0.01);
		/* no assessments so far -> 0.0 raw marks */
		assertEquals(0.0, heeyeon.getRawMarks(), 0.01);
	}
	
	@Test
	public void test_student_record_02() {
		/* 
		 * Initialize a student record with course name. 
		 */
		StudentRecord heeyeon = new StudentRecord("EECS2030"); 
		
		/* Add first assessment */
		heeyeon.addAssessment("Midterm 1", 0.153789, 75);
		/* Add second assessment */
		heeyeon.addAssessment("Midterm 2", 0.253783, 80);
		/* 
		 * Two assessments added 
		 *
		 * Note. percentage value of the weight should be displayed with
		 * 			3 digits after the decimal point.
		 */
		assertEquals("Number of assessments in EECS2030: 2 [Midterm 1 (weight: 15.379 percents; marks: 75), Midterm 2 (weight: 25.378 percents; marks: 80)]", heeyeon.getAssessmentReport());
	}
	
	@Test
	public void test_student_record_03() {
		/* 
		 * Initialize a student record with course name. 
		 */
		StudentRecord heeyeon = new StudentRecord("EECS2030"); 
		
		/*
		 * For example calculations of the completion rate and raw marks,
		 * 	see the Problem section at the top of this test file.
		 */
		
		/* Add first assessment. */
		heeyeon.addAssessment("Midterm 1", 0.15, 75); 
		assertEquals("Number of assessments in EECS2030: 1 [Midterm 1 (weight: 15.000 percents; marks: 75)]", heeyeon.getAssessmentReport());
		assertEquals(0.15, heeyeon.getCompletionRate(), 0.01);
		assertEquals(75 * 0.15, heeyeon.getRawMarks(), 0.01);
		
		/* Add second assessment. */
		heeyeon.addAssessment("Midterm 2", 0.25, 80);
		assertEquals("Number of assessments in EECS2030: 2 [Midterm 1 (weight: 15.000 percents; marks: 75), Midterm 2 (weight: 25.000 percents; marks: 80)]", heeyeon.getAssessmentReport());
		assertEquals(0.15 + 0.25, heeyeon.getCompletionRate(), 0.01);
		assertEquals(75 * 0.15 + 80 * 0.25, heeyeon.getRawMarks(), 0.01);
	}
	
	@Test
	public void test_student_record_04() {
		/* 
		 * Initialize a student record with course name. 
		 */
		StudentRecord heeyeon = new StudentRecord("EECS2030");
		
		/* Add two assessments. */
		Assessment m1 = new Assessment("Midterm 1", 0.15);
		m1.setMarks(75);
		Assessment m2 = new Assessment("Midterm 2", 0.25);
		m2.setMarks(80);
		
		heeyeon.addAssessment(m1);
		heeyeon.addAssessment(m2);
		
		/* Add two more assessments */
		heeyeon.addAssessment("Lab Test 1", 0.1, 90);
		heeyeon.addAssessment("Lab Test 2", 0.1, 95); 
		
		/* four assessments added so far */
		
		/*
		 * For example calculations of the completion rate and raw marks,
		 * 	see the Problem section at the top of this test file.
		 */
		assertEquals("Number of assessments in EECS2030: 4 [Midterm 1 (weight: 15.000 percents; marks: 75), Midterm 2 (weight: 25.000 percents; marks: 80), Lab Test 1 (weight: 10.000 percents; marks: 90), Lab Test 2 (weight: 10.000 percents; marks: 95)]", heeyeon.getAssessmentReport());
		assertEquals(0.15 + 0.25 + 0.1 + 0.1, heeyeon.getCompletionRate(), 0.01);
		assertEquals(75 * 0.15 + 80 * 0.25 + 90 * 0.1 + 95 * 0.1, heeyeon.getRawMarks(), 0.01);
	}
	
	@Test
	public void test_student_record_05() {
		/* 
		 * Initialize a student record with course name. 
		 */
		StudentRecord heeyeon = new StudentRecord("EECS2030");
		
		Assessment m1 = new Assessment("Midterm 1", 0.15);
		m1.setMarks(75);
		Assessment m2 = new Assessment("Midterm 2", 0.25);
		m2.setMarks(80);
		
		/* Add four assessments. */
		heeyeon.addAssessment(m1);
		heeyeon.addAssessment("Lab Test 1", 0.1, 90);
		heeyeon.addAssessment(m2);
		heeyeon.addAssessment("Lab Test 2", 0.1, 95); 
		
		/* Change marks of "Midterm 2"
		 * Here "Midterm 2" is an existing assessment name.
		 * You can assume that there are no duplicates of assessment names. 
		 */
		heeyeon.changeMarksOf("Midterm 2", 85);
		
		/* Change marks of "Midterm 3"
		 * Here "Midterm 3" is a non-existing assessment name - do nothing. 
		 */
		heeyeon.changeMarksOf("Midterm 3", 95);
		
		/* still four assessments added so far */
		assertEquals("Number of assessments in EECS2030: 4 [Midterm 1 (weight: 15.000 percents; marks: 75), Lab Test 1 (weight: 10.000 percents; marks: 90), Midterm 2 (weight: 25.000 percents; marks: 85), Lab Test 2 (weight: 10.000 percents; marks: 95)]", heeyeon.getAssessmentReport());
		assertEquals(0.15 + 0.1 + 0.25 + 0.1, heeyeon.getCompletionRate(), 0.01);
		assertEquals(75 * 0.15 + 90 * 0.1 + 85 * 0.25 + 95 * 0.1, heeyeon.getRawMarks(), 0.01);
	}
	
	@Test
	public void test_student_record_06() {
		/* 
		 * Initialize a student record with course name. 
		 */
		StudentRecord heeyeon = new StudentRecord("EECS2030");
		
		/* Add two assessments. */
		Assessment m1 = new Assessment("Midterm 1", 0.15);
		m1.setMarks(75);
		heeyeon.addAssessment(m1);
		heeyeon.addAssessment("Lab Test 1", 0.1, 90);
		
		/* Two assessments added. */ 
		
		/*
		 * For example calculations of the completion rate and raw marks,
		 * 	see the Problem section at the top of this test file.
		 */
		
		assertEquals("Number of assessments in EECS2030: 2 [Midterm 1 (weight: 15.000 percents; marks: 75), Lab Test 1 (weight: 10.000 percents; marks: 90)]", heeyeon.getAssessmentReport());
		assertEquals(0.15 + 0.1, heeyeon.getCompletionRate(), 0.01);
		assertEquals(75 * 0.15 + 90 * 0.1, heeyeon.getRawMarks(), 0.01);
		
		/* 
		 * Remove the assessments for Midterm 1 and Lab Test 1
		 * You can assume that there are no duplicates of
		 * assessment names.
		 */
		heeyeon.removeAssessment("Midterm 1");
		heeyeon.removeAssessment("Lab Test 1");
		
		/*
		 * Remove a non-existing assessment: do nothing.
		 */
		heeyeon.removeAssessment("Midterm 2");
		
		/* Zero assessments left after removing both assessments. */
		assertEquals("Number of assessments in EECS2030: 0 []", heeyeon.getAssessmentReport());
		assertEquals(0.0, heeyeon.getCompletionRate(), 0.01);
		assertEquals(0.0, heeyeon.getRawMarks(), 0.01);
		
		/* 
		 * Change marks of "Midterm 1"
		 * Here "Midterm 1" is a non-existing assessment name - do nothing. 
		 */
		heeyeon.changeMarksOf("Midterm 1", 95);
		assertEquals("Number of assessments in EECS2030: 0 []", heeyeon.getAssessmentReport());
		assertEquals(0.0, heeyeon.getCompletionRate(), 0.01);
		assertEquals(0.0, heeyeon.getRawMarks(), 0.01);
	}
	
	@Test
	public void test_student_record_07() {
		/* 
		 * Initialize a student record with course name. 
		 */
		StudentRecord heeyeon = new StudentRecord("EECS2030");
		
		/* Add two assessments. */
		Assessment m1 = new Assessment("Midterm 1", 0.15);
		m1.setMarks(75);
		heeyeon.addAssessment("Lab Test 1", 0.1, 90);
		
		/* 
		 * Remove the assessment for Midterm 1
		 * You can assume that there are no duplicates of
		 * assessment names. 
		 */
		heeyeon.removeAssessment("Midterm 1"); 
		
		/*
		 * Remove a non-existing assessment: do nothing.
		 */
		heeyeon.removeAssessment("Midterm 2");
		
		// Up to now, there should be just one assessment remaining in the list.
		
		// Add two new assessments
		heeyeon.addAssessment("Lab Test 2", 0.20, 75);
		heeyeon.addAssessment("Lab Test 3", 0.25, 95); 
		
		/* Three assessments. */
		assertEquals("Number of assessments in EECS2030: 3 [Lab Test 1 (weight: 10.000 percents; marks: 90), Lab Test 2 (weight: 20.000 percents; marks: 75), Lab Test 3 (weight: 25.000 percents; marks: 95)]", heeyeon.getAssessmentReport());
		assertEquals(0.1 + 0.2 + 0.25, heeyeon.getCompletionRate(), 0.01);
		assertEquals(0.1 * 90 + 0.2 * 75 + 0.25 * 95, heeyeon.getRawMarks(), 0.01);
		
		/* Change marks of "Lab Test 2"
		 * Here "Lab Test 2" is an existing assessment name.
		 * You can assume that there are no duplicates of assessment names. 
		 */
		heeyeon.changeMarksOf("Lab Test 2", 100);
		assertEquals("Number of assessments in EECS2030: 3 [Lab Test 1 (weight: 10.000 percents; marks: 90), Lab Test 2 (weight: 20.000 percents; marks: 100), Lab Test 3 (weight: 25.000 percents; marks: 95)]", heeyeon.getAssessmentReport());
		assertEquals(0.1 + 0.2 + 0.25, heeyeon.getCompletionRate(), 0.01);
		assertEquals(0.1 * 90 + 0.2 * 100 + 0.25 * 95, heeyeon.getRawMarks(), 0.01);
	}
}