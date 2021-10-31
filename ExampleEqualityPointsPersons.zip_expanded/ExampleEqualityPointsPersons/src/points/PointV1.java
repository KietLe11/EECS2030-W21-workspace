package points;

/* This version does not define equals method,
 * meaning that when comparing two PointV1 objects,
 * the default version of equals method inherited from Object, 
 * which compare references, will be used.  
 */
public class PointV1 {
	private int x; 
	private int y;
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public PointV1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
