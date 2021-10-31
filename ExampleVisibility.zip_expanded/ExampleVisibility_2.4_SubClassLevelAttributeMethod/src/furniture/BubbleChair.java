package furniture;

public class BubbleChair extends Chair {
	void bubbleChairMethod() {
		/* Within this method of a descendant class (and same resident package) 
		 * as of 'i' and 'm' from class Chair,
		 * we can access any of them, since both 'i' and 'm' are declared as 'protected'.
		 */
		Chair c = new Chair();
		System.out.println(c.i);
		c.m(); 
		
		System.out.println(this.i);
		this.m();
	}
}
