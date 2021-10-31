package furniture;


public class Chair {
	/* An attribute declared without any modifier
	 * means that its value can be accessed 
	 * not only within methods of its resident class, i.e., Chair,
	 * but also within methods of all other classes in the same package, i.e., furniture.  
	 */
	int i;

	/* A method declared without any modifier
	 * means that it can be called 
	 * not only within methods of its resident class, i.e., Chair,
	 * but also within methods of all other classes in the same package, i.e., furniture.  
	 */
	void m() {}

	void chairMethod() {
		/* Within this method of the same resident class 
		 * as of 'i' and 'm', 
		 * we can access both 'i' and 'm'.
		 * Notice that the visibility of this USER method chairMethod is IRRELEVANT:
		 * it only depends on the visibility of the attribute or method BEING USED.
		 */
		Chair c = new Chair();
		System.out.println(c.i);
		c.m();

		/* Alternatively, since we are now in the same resident class
		 * as of 'i' and 'm', we can ignore resident class name 
		 */
		System.out.println(this.i);
		this.m();
	}
}
