package model;

public class PolarPoint implements Point {
	private double r; // distance from point to origin
	private double theta; // angle from x-axis (radian, not degree)
	
	public PolarPoint(double r, double theta) {
		this.r = r;
		this.theta = theta;
	}
	
	@Override
	public double getX() {
		return r * Math.cos(theta);
	}

	@Override
	public double getY() {
		return r * Math.sin(theta);
	}
	
	public String toString() {
		return "r = " + r + ", " + "theta = " + theta;
	}

}
