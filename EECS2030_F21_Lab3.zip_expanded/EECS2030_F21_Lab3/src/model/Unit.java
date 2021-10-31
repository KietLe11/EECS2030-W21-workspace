package model;

public class Unit {
	
	private String function;
	private int widthFeet;
	private int lengthFeet;
	private int areaFeet;
	
	private String measurementType;
	
	public Unit(String function, int widthFeet, int lengthFeet) {
		this.function = function;
		this.widthFeet = widthFeet;
		this.lengthFeet = lengthFeet;
		this.areaFeet = widthFeet*lengthFeet;
		measurementType = "feet";
	}
	
	public String toString() {
		String s ="";
		if(measurementType.equals("feet")) {
			s = String.format("A unit of %d square %s (%d' wide and %d' long) functioning as %s", areaFeet, measurementType, widthFeet, lengthFeet, function);
		}
		else if(measurementType.equals("meters")) {
			s = String.format("A unit of %.02f square %s (%.02f m wide and %.02f m long) functioning as %s", areaFeet*0.3048*0.3048, measurementType, widthFeet*0.3048, lengthFeet*0.3048, function);
		}
		return s;
	}
	
	/*
	 * MUTATORS
	 */
	
	public void toogleMeasurement() {
		if(measurementType.equals("feet")) {
			measurementType = "meters";
		}
		else {
			measurementType = "feet";
		}
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Unit other = (Unit)obj;
		return (this.function.equals(other.function) && this.getArea() ==other.getArea());
	}
	
	/*
	 * ACCESSORS
	 */

	public int getArea() {
		return areaFeet;
	}
	
	public String getDetails() {
		String details = String.format("%s: %d sq ft (%d' by %d')", function, areaFeet, widthFeet, lengthFeet);
		return details;
	}
}
