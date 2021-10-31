package persons;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPersonCollector {

	/*
	 * Your Exercise on 
	 * writing test methods to 
	 * test the equality on 
	 * Person and PersonCollector objects.
	 * Test all different cases.
	 */
	
	@Test
	public void testPersonCollector() {
		Person p1 = new Person("A", "a", 180, 1.8);
		Person p2 = new Person("A", "a", 180, 1.8);
		Person p3 = new Person("B", "b", 200, 2.1);
		Person p4 = p3;
		assertFalse(p1 == p2);
		assertTrue(p1.equals(p2));
		assertTrue(p3 == p4);
		assertTrue(p3.equals(p4));
		
		PersonCollector pc1 = new PersonCollector();
		PersonCollector pc2 = new PersonCollector();
		assertFalse(pc1 == pc2);
		// Both pc1 and pc2 contain empty arrays of persons
		assertTrue(pc1.equals(pc2));
		
		pc1.addPerson(p1);
		// pc1 and pc2 contain equal number of persons
		assertFalse(pc1.equals(pc2));
		
		pc2.addPerson(p2);
		// pc1 and pc2 contain equal number of equal persons
		assertFalse(pc1.getPersons()[0] == pc2.getPersons()[0]);
		assertTrue(pc1.getPersons()[0].equals(pc2.getPersons()[0]));
		assertTrue(pc1.equals(pc2)); 
		
		pc1.addPerson(p3);
		pc2.addPerson(p4);
		// pc1 and pc2 contain equal number of equal persons
		assertTrue(pc1.getPersons()[1] == pc2.getPersons()[1]);
		assertTrue(pc1.getPersons()[1].equals(pc2.getPersons()[1]));
		assertTrue(pc1.equals(pc2)); 
		
		pc1.addPerson(new Person("A", "a", 175, 1.75));
		pc2.addPerson(new Person("A", "a", 165, 1.55));
		// pc1 and pc2 contain equal number of unequal persons
		assertFalse(pc1.getPersons()[2] == pc2.getPersons()[2]);
		assertFalse(pc1.getPersons()[2].equals(pc2.getPersons()[2]));
		assertFalse(pc1.equals(pc2)); 
	}
}
