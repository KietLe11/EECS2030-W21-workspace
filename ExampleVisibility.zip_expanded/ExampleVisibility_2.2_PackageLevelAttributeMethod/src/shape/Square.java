package shape;

import furniture.*;

public class Square {
	void squareMethod() {
		/* Within this method of a different resident class and different package 
		 * as of 'i' and 'm' from Chair,
		 * we can access neither of them, 
		 * since both 'i' and 'm' are declared (without any modifier) 
		 * as accessible at the level of their resident package, i.e., furniture.
		 * Notice that the visibility of this USER method squareMethod is IRRELEVANT:
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
