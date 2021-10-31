package model;

public class Blueprint {

	private int numOfFloors;
	private double progress;
	private double floorsDone;
	
	public Blueprint(int numOfFloors) {
		this.numOfFloors = numOfFloors;
	}
	
	/*
	 * ACCESSORS
	 */
	public String toString() {
		String s = "";
		s = String.format("%.01f percents of building blueprint completed (%d out of %d floors)", progress, floorsDone, numOfFloors);
		return s;
	}
}
