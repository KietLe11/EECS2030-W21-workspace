package shape;

import furniture.*;

public class Square {
	void squareMethod() {
		/* 
		 * Within this method of a non-descendant class of Chair (and a different resident package)
		 * we cannot access attribute `i` and method `m`,
		 * since both 'i' and 'm' are not declared as 'protected'.
		 */
		System.out.println(this.i);
		this.m();

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
