package model;

public class PolygonCollector {
	// ST of each element in polygons is Polygon
	// which means it can be assigned any object
	// whose ST is a descendant class of Polygon
	// (i.e., Triangle and Rectangle)
	private Polygon[] polygons; 
	private int nop; // number of polygons
	
	public Polygon[] getPolygons() {
		/* for simplicity, only return the entire array */
		return this.polygons;
	}
	
	public int getNOP() {
		return this.nop;
	}

	public PolygonCollector() {
		polygons = new Polygon[10];
	} 

	// ST of parameter p is Polygon
	// This means any object whose ST is a descendant class
	// of Polygon can be passed as argument for this method.
	// i.e., Rectangle and Triangle
	public void addPolygon(Polygon p) {
		polygons[nop] = p;
		nop ++;
	}

	// ST of parameter p is Rectangle
	// This means any object whose ST is a descendant class
	// of Rectangle can be passed as argument for this method.
	// i.e., Rectangle and Triangle
	public void addRectangle(Rectangle p) {
		polygons[nop] = p;
		nop ++;
	}

	// ST of parameter p is Triangle
	// This means any object whose ST is a descendant class
	// of Triangle can be passed as argument for this method.
	// i.e., Triangle
	public void addTriangle(Triangle p) {
		polygons[nop] = p;
		nop ++;
	}
}
