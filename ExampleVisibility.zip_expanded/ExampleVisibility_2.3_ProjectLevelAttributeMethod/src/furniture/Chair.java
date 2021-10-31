package furniture;


public class Chair {
	/* An attribute declared with the modifier 'public'
	 * means that its value can be accessed 
	 * within methods of all classes (across packages) of its resident project.    
	 */
	public  int i;

	/* A method declared with the modifier 'public'
	 * means that it can be called 
	 * within methods of all classes (across packages) of its resident project.    
	 */
	public  void m() {}

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
