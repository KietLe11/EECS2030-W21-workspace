package points;

public class PointTester {
	public static void main(String[] args) {
		PointV1 p1 = new PointV1(3, 4);
		PointV1 p2 = new PointV1(3, 4);
		System.out.println("Address stored in p1: " + p1);
		System.out.println("Address stored in p2: " + p2);
		System.out.print("Addresses sotred in p1 and p2 are equal: ");
		System.out.println(p1 == p2);
		
		/*
		 * Since the equals method in PointV1 is not redefined/overridden,
		 * calling p1.equals(p2) calls the default version inherited from Object,
		 * which boils down to checking p1 == p2
		 */
		System.out.print("Calling p1.equals(p2): ");
		System.out.println(p1.equals(p2));
		
		/* The best we can do is by accessing the relevant
		 * attributes of p1 and p2. 
		 */
		System.out.print("Contents of p1 and p2 are equal: ");
		
//		if(p1 ==s) {
//			
//		}
		
		/* A better solution is to factor out this comparison
		 * into a separate method in Point. 
		 */
		System.out.println(p1.getX() == p2.getX() && p1.getY() == p2.getY());
		
		PointV2 p3 = new PointV2(3, 4);
		PointV2 p4 = new PointV2(3, 4);
		System.out.println("Address stored in p3: " + p3);
		System.out.println("Address stored in p4: " + p4);
		System.out.print("Addresses sotred in p3 and p4 are equal: ");
		System.out.println(p3 == p4);
		
		/* We no longer have to access the attributes of p3 and p4
		 * in order to compare their contents. 
		 * We can simply call the equals method that is defined
		 * in Point class.
		 */
		System.out.print("Calling p3.equals(p4): ");
		System.out.println(p3.equals(p4));
		/* Calling the above equals method is as if we did
		 * the following:
		 * System.out.println(p3.x == p4.x && p3.y == p4.y);
		 */
	}
}
