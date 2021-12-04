package model;

// By declaring this as interface,
// all methods must be abstract, i.e., headers only.
public interface Point {
	// As far as users of Point are concerned,
	// they only want to access the location (x and y coordinate values).
	public double getX();
	public double getY();
}
