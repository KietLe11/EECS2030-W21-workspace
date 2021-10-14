package model;

public class HealthRecord {

	public String name;
	public int limitOfVax;
	
	public int numDosesReceived =0;
	public int numAppointments;
	public String appointmentLocation;
	public boolean appointmentSuccess = true;
	
	public Vaccine[] vax;
	public String[] location;
	public String[] date;
	
	public HealthRecord(String name, int limitOfVax) {
		this.name=name;
		this.limitOfVax=limitOfVax;
		
		vax = new Vaccine[limitOfVax];
		location = new String[limitOfVax];
		date = new String[limitOfVax];
	}
	
	public String getVaccinationReceipt() {
		String s = "";
		if(numDosesReceived==0) {
			s = String.format("%s has not yet received any doses.",name);
		}
		else {
			//"Number of doses Alan has received: 2 [Recognized vaccine: mRNA-1273 (RNA; Moderna) in North York General Hospital on April-20-2021; 
			//Recognized vaccine: BNT162b2 (RNA; Pfizer/BioNTech) in Humber River Hospital on June-30-2021]"
			
			s+= String.format("Number of doses %s has received: %d [", this.name, this.numDosesReceived);
			
			for(int i = 0; i<this.numDosesReceived;i++) {
				s+= String.format("Recognized vaccine: %s (%s; %s) in %s on %s", vax[i].codename, vax[i].type, vax[i].maker, location[i], date[i]);
				if(i!=this.numDosesReceived-1) {
					s+="; ";
				}
			}
			
			s+="]";
		}
		return s;
	}
	
	public String getAppointmentStatus() {
		String s = "";
		if(numAppointments == 0 && appointmentSuccess) {
			s = String.format("No vaccination appointment for %s yet", name);
		}
		else if (numAppointments>0 && appointmentSuccess){
			s = String.format("Last vaccination appointment for %s with %s succeeded", name, appointmentLocation);
		}
		else if(!appointmentSuccess) {
			s = String.format("Last vaccination appointment for %s with %s failed", name, appointmentLocation);
		}
		return s;
	}
	
	public void addAppointment(String appointmentLocation) {
		this.appointmentLocation = appointmentLocation;
		numAppointments++;
	}
	
	public void addRecord(Vaccine vaxAdded, String location, String date) {
		vax[numDosesReceived] = vaxAdded;
		this.location[numDosesReceived] = location;
		this.date[numDosesReceived] = date;
		numDosesReceived++;
	}
}
