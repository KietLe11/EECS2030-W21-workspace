package furniture;

public class Desk {
	/*
	 * By default each class is at least accessible 
	 * by all other classes within the same package.
	 * There is no need to have an import statement:
	 * import furniture.Chair
	 */
	
	void deskMethod() {
		Chair c = new Chair();
	}
}
