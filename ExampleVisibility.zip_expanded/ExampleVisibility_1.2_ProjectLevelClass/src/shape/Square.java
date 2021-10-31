package shape;

/*
 * Since class Chair is declared as 'public',
 * it can be accessed within all classes (across packages) in its resident project.
 */

import furniture.Chair;
 
public class Square {
	
	@SuppressWarnings("unused")
	void squareMethod() {
		Chair c = new Chair();
	}
	
}
