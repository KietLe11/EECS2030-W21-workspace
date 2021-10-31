package furniture;

public class Desk {
	void deskMethod() {
		/* Within this method of a different resident class (but the same resident package) 
		 * as of 'i' and 'm' from class Chair,
		 * we can access neither of them, since both 'i' and 'm' are declared as 'private'.
		 * Notice that the visibility of this USER method deskeMethod is IRRELEVANT:
		 * it only depends on the visibility of the attribute or method BEING USED.
		 */
		
		/*
		 * Hover your mouse over the red-underlined 'i' and 'm',
		 * you should see two perfectly sensible error messages:
		 * - The fields Chair.i is not visible
		 * - The method m() from the type Chair is not visible
		 */
		Chair c = new Chair();
		System.out.println(c.i);
		c.m();
	}
}
