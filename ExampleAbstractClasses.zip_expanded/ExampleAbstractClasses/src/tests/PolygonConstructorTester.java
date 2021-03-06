package tests;
import model.Polygon;
import model.PolygonConstructor;

public class PolygonConstructorTester {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Polygon p = null; // ST: Polygon; DT: unknown
		PolygonConstructor pc = new PolygonConstructor();
		double[] sides1 = {2, 4};
		p = pc.getPolygon(sides1);
		System.out.println(p.getArea());
		// Questions:
		// ST of p? Polygon
		// DT of p? Rectangle

		double[] sides2 = {3, 4, 5};
		p = pc.getPolygon(sides2);
		System.out.println(p.getArea());
		// Questions:
		// ST of p? Polygon
		// DT of p? Triangle
	}
}
