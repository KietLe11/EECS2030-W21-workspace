
public class Util {
	void reassignInt(int j) {
		j = j + 1;
	}
	
	void reassignRef(Point q) {
		Point np = new Point(6, 8);
		q = np;
	}
	
	void changeViaRef(Point q) {
		q.moveHorizontally(3);
		q.moveVertically(4);
	}
}
