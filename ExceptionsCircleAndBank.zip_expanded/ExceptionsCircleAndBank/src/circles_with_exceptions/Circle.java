package circles_with_exceptions;

public class Circle {
	double radius;
	
	Circle() {
		// radius will be 0 by default.
	}
	
	// Set the value of radius to r.
	// It is an error if r is negative.
	
	// Since setRadius can throw an InvalidRadiusException,
	// we have two options:
	// (1) Specify: as part of the signature of setRadius,
	//              we declare that it might happen that
	//              an InvalidRadius Exception is thrown.
	//              This option means we do not handle this
	//              error, and propogates to the caller.
	void setRadius(double r) throws InvalidRadiusException { // the "throws InvalidRadiusException" in this line tells tells the caller whether to catch the exception or specify it
		if(r < 0) {											// this method may throw an exception if the parameters are met
			// We throw an exception object back to the caller,
			// which is CircleCalculator.main, and it
			// cannot be ignored.
			throw new InvalidRadiusException("Invalid radius"); //Where Exception originates from. 
		}
		else {
			this.radius = r;
		}
	}
	
	double getArea() {
		return radius * radius * 3.14;
	}
}
