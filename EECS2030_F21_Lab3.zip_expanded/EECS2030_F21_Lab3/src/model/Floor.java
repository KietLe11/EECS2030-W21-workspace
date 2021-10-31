package model;



public class Floor {

	private int maxCapacity;
	private int utilizedSpace;
	private int availableSpace;
	private Unit[] units;
	private int nou;
	
	private int[] areasOfMasters;
	private int[] areasOfOffices;
	private int[] areasOfKitchens;
	
	/*
	 * numberOfEachFunction shows the number of each type of room type
	 * numberOfEachFunction[0] -> "Master Bedroom"
	 * numberOfEachFunction[1] -> "Office"
	 * numberOfEachFunction[2] -> "Kitchen"
	 */
	private int[] numberOfEachFunction = new int[3];
	
	public Floor(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		availableSpace = maxCapacity;
		units = new Unit[20];
		
		areasOfMasters = new int[20];
		areasOfOffices = new int[20];
		areasOfKitchens = new int[20];
		
	}
	
	public String toString() {
		String s = "";
		s = String.format("Floor's utilized space is %d sq ft (%d sq ft remaining): [", utilizedSpace, availableSpace);
		for(int i = 0; i<nou;i++) {
			s+= units[i].getDetails();
			if(i != nou-1) {
				s+=", ";
			}
		}
		s+="]";
		return s;
	}
	
	/*
	 * ACCESSORS
	 */
	
	public void addUnit(String function, int widthFeet, int lengthFeet) throws InsufficientFloorSpaceException {
		int area = widthFeet*lengthFeet;
		if(area <= availableSpace) {
			units[nou] = new Unit(function, widthFeet, lengthFeet);
			if(function.equals("Master Bedroom")) {
				areasOfMasters[numberOfEachFunction[0]] = widthFeet*lengthFeet;
				numberOfEachFunction[0] ++;
			}
			else if(function.equals("Office")) {
				areasOfOffices[numberOfEachFunction[1]] = widthFeet*lengthFeet;
				numberOfEachFunction[1]++;
			}
			else {
				areasOfKitchens[numberOfEachFunction[2]] = widthFeet*lengthFeet;
				numberOfEachFunction[2]++;
			}
			nou ++;
			availableSpace -= area;
			utilizedSpace += area;
		}
		else {
			throw new InsufficientFloorSpaceException("Insufficient Floor Space Available.");
		}
	}
	
	public int getMaxCap() {
		return maxCapacity;
	}
	
	public int getNumberOfUnits() {
		return nou;
	}
	
	public int[] getNumOfEachFunction() {
		return numberOfEachFunction;
	}
	
	public int[] getAreasOfMasters() {
		return areasOfMasters;
	}
	
	public int[] getAreasOfOffices() {
		return areasOfOffices;
	}
	
	public int[] getAreasOfKitchens() {
		return areasOfKitchens;
	}
	
	public int getTotalKitchenArea() {
		int total =0;
		for(int i =0; i<numberOfEachFunction[2];i++) {
			total += areasOfKitchens[i];
		}
		return total;
	}
	
	public int getTotalOfficeArea() {
		int total =0;
		for(int i =0; i<numberOfEachFunction[1];i++) {
			total += areasOfOffices[i];
		}
		return total;
	}
	
	public int getTotalMasterArea() {
		int total =0;
		for(int i =0; i<numberOfEachFunction[0];i++) {
			total += areasOfMasters[i];
		}
		return total;
	}
	
	/*
	 * MUTATORS
	 */
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		Floor other = (Floor) obj;
		if(this.getNumberOfUnits() != other.getNumberOfUnits()) {
			return false;
		}
	
		if(this.getMaxCap()!=other.getMaxCap()) {
			return false;
		}
		boolean isFunctionsEqual=true;
		for(int i = 0; i<3;i++) {

			if(!(this.getNumOfEachFunction()[i]==other.getNumOfEachFunction()[i])) {
				return false;
			}
		}
		
		if(!(this.getTotalKitchenArea()==other.getTotalKitchenArea())) {
			return false;
		}
		if(!(this.getTotalMasterArea()==other.getTotalMasterArea())) {
			return false;
		}
		if(!(this.getTotalOfficeArea()==other.getTotalOfficeArea())) {
			return false;
		}

		return (this.getMaxCap()==other.getMaxCap());
	}
}
