package points;

/* This version redefines/overrides the accessor method equals 
 * that is inherited from Object. */

public class PointV2 {
	double x; 
	double y;

	PointV2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals (Object obj) {
		if(this == obj) { 
			return true; 
		}
		if(obj == null) { 
			return false; 
		}
		if(this.getClass() != obj.getClass()) { 
			return false; 
		} 
		PointV2 other = (PointV2) obj;
		return this.x == other.x && this.y == other.y; 
//		return this.x == obj.x && this.y == obj.y;
	} 
}
