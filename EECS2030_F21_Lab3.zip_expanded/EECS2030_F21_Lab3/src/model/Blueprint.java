package model;

public class Blueprint {

	private int numOfFloors;
	private double progress;
	private int floorsDone;
	
	private Floor[] floors;
	
	public Blueprint(int numOfFloors) {
		this.numOfFloors = numOfFloors;
		
		floors = new Floor[numOfFloors];
	}
	
	public Blueprint(Blueprint copyBlueprint) {
		this.numOfFloors = copyBlueprint.numOfFloors;
		this.progress = copyBlueprint.progress;
		this.floorsDone = copyBlueprint.floorsDone;
		
		this.floors = copyBlueprint.floors;
	}
	
	/*
	 * MUTATORS
	 */
	public void addFloorPlan(Floor floor) {
		floors[floorsDone] = floor;
		floorsDone++;
		progress = (floorsDone/(double)numOfFloors)*100;
	}
	
	
	
	/*
	 * ACCESSORS
	 */
	public String toString() {
		String s = "";
		s = String.format("%.01f percents of building blueprint completed (%d out of %d floors)", progress, floorsDone, numOfFloors);
		return s;
	}
	
	public Floor[] getFloors() {
		Floor[] floorsSending = new Floor[floorsDone];
		
		for(int i =0; i<floorsDone; i++) {
			floorsSending[i] = new Floor(floors[i]);
		}
		return floorsSending;
	}
}
