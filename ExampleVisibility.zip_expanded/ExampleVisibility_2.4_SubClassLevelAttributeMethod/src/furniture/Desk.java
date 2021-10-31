package furniture;

public class Desk {
	void deskMethod() {
		/* Within this method of a different resident class (but the same resident package) 
		 * as of 'i' and 'm' from class Chair,
		 * we can access any of them, since both 'i' and 'm' are declared as 'protected'.
		 */
		Chair c = new Chair();
		System.out.println(c.i);
		c.m();
		
		/*
		 * Since Desk does not extend Chair,
		 * 	attribute i and method m are not inherited here. 
		 */
		System.out.println(this.i);
		this.m();
	}
}
