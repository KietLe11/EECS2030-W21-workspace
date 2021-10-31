package furniture;

public class Desk {
	void deskMethod() {
		/* Within this method of a different resident class (but the same resident package) 
		 * as of 'i' and 'm' from class Chair,
		 * we can access both 'i' and 'm' since they are declared as 'public' 
		 * as accessible within methods of all classes (across packages) of its resident project.    
		 * Notice that the visibility of this USER method deskeMethod is IRRELEVANT:
		 * it only depends on the visibility of the attribute or method BEING USED.
		 */
		Chair c = new Chair();
		System.out.println(c.i);
		c.m();
	}
}
