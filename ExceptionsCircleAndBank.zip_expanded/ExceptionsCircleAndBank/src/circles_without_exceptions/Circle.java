package circles_without_exceptions;

public class Circle {
	double radius;
	
	Circle() {
		// radius will be 0 by default.
	}
	
	// Set the value of radius to r.
	// It is an error if r is negative.
	void setRadius(double r) {
		if(r < 0) {
			System.out.println("Error: invalid radius " + r);
		}
		else {
			this.radius = r;
		}
	}
	
	double getArea() {
		return radius * radius * 3.14;
	}
}
