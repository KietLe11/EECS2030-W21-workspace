package furniture;


public class Chair {
	/* An attribute declared with modifier 'private'
	 * means that its value can only be accessed 
	 * within methods of its resident class, i.e., Chair.  
	 */
	private  int i;
	
	/* A method declared with modifier 'private'
	 * means that it can only be called 
	 * within methods of its resident class, i.e., Chair.  
	 */
	private  void m() {}
	
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
