package shape;

import furniture.Chair;

public class RockingChair extends Chair {
	void rockingChairMethod() {
		/* 
		 * Within this method of a descendant class (but different resident package)
		 * we can access attribute `i` and method `m`, 
		 * as if they were declared in RockingChair,
		 * since both 'i' and 'm' are declared as 'protected'.
		 */
		System.out.println(this.i);
		this.m();
		
		/*
		 * However, given that `i` and `m` are not public,
		 * 	we still cannot access any of them when the context object is not `this`. 
		 */
		Chair c = new Chair();
		System.out.println(c.i);
		c.m();
		
		/*
		 * Attribute i and method m are inherited from Chair in another package.
		 */
		System.out.println(this.i);
		this.m();
	}
}
