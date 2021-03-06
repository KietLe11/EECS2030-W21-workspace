package model;

import model.*;

public class VaccinationSite {

	public String location;
	public int limitDosesAdded;
	public int totalDosesAvailable;

	private String toStringReturn;

	private int totalModerna;
	private int totalPfizer;
	private int totalAstra;
	private int totalJanssen;

	private int numOfTypesAdded;
	private String[] orderOfDosesAdded = new String[4];

	boolean astraAdded = false;
	boolean modernaAdded = false;
	boolean janssenAdded = false;
	boolean pfizerAdded = false;

	private HealthRecord[] appointments;
	private int numOfAppointments;
	private int vaccineReserved;
	public int numAdministered = 0;

	public VaccinationSite(String location, int limitDosesAdded) {
		this.location = location;
		this.limitDosesAdded = limitDosesAdded;

		appointments = new HealthRecord[200];
	}

	public String toString() {
		toStringReturn = String.format("%s has %d available doses: <", location, totalDosesAvailable);

		//		if(totalModerna!=0) {
		//
		//			toStringReturn+= String.format("%s doses of Moderna", totalModerna);
		//
		//			if((totalPfizer!=0)||(totalAstra!=0)||(totalJanssen!=0)) {
		//				toStringReturn+=", ";
		//			}
		//		}
		//		if(totalPfizer!=0) {
		//
		//			toStringReturn+= String.format("%s doses of Pfizer/BioNTech", totalPfizer);
		//
		//			if((totalAstra!=0)||(totalJanssen!=0)) {
		//				toStringReturn+=", ";
		//			}
		//		}
		//		if(totalAstra!=0) {
		//
		//			toStringReturn+= String.format("%s doses of Oxford/AstraZeneca", totalAstra);
		//
		//			if((totalJanssen!=0)) {
		//				toStringReturn+=", ";
		//			}
		//		}
		//		if(totalJanssen!=0) {
		//
		//			toStringReturn+= String.format("%s doses of Janssen", totalJanssen);
		//		}

		String moderna = String.format("%s doses of Moderna", totalModerna);
		String pfizer = String.format("%s doses of Pfizer/BioNTech", totalPfizer);
		String astra = String.format("%s doses of Oxford/AstraZeneca", totalAstra);
		String janssen = String.format("%s doses of Janssen", totalJanssen);


		for(int i = 0; i<numOfTypesAdded;i++) {
			if(orderOfDosesAdded[i]!=null) {
				if(orderOfDosesAdded[i].equals("Moderna")) {
					toStringReturn += moderna;
					if(i<numOfTypesAdded-1) {
						toStringReturn +=", ";
					}
				}
				else if(orderOfDosesAdded[i].equals("Pfizer")) {
					toStringReturn += pfizer;
					if(i<numOfTypesAdded-1) {
						toStringReturn +=", ";
					}
				}
				else if(orderOfDosesAdded[i].equals("Astra")) {
					toStringReturn += astra;
					if(i<numOfTypesAdded-1) {
						toStringReturn +=", ";
					}
				}
				else if(orderOfDosesAdded[i].equals("Janssen")) {
					toStringReturn += janssen;
					if(i<numOfTypesAdded-1) {
						toStringReturn +=", ";
					}
				}
			}
		}

		toStringReturn +=">";
		return toStringReturn;
	}

	public int getNumberOfAvailableDoses() {
		return totalDosesAvailable;
	}
	public int getNumberOfAvailableDoses(String codename) {
		int AD = 0;

		if(codename.equals("mRNA-1273")) {
			AD = totalModerna;
		}
		else if(codename.equals("BNT162b2")) {
			AD = totalPfizer;
		}
		else if(codename.equals("Ad26.COV2.S")) {
			AD = totalJanssen;
		}
		else if(codename.equals("AZD1222")) {
			AD = totalAstra;
		}
		return AD;
	}

	public void addDistribution(Vaccine vax, int supply) throws UnrecognizedVaccineCodeNameException,TooMuchDistributionException {

		if(vax.codename.equals("mRNA-1273")) {
			if(!modernaAdded) {
				for(int i =0; i<4;i++) {
					if(orderOfDosesAdded[i]==null ||orderOfDosesAdded[i].equals("Moderna")) {
						orderOfDosesAdded[i] = "Moderna";
						numOfTypesAdded++;
						modernaAdded = true;
						break;
					}
				}
			}

			totalModerna += supply;
		}
		else if(vax.codename.equals("BNT162b2")) {
			if(!pfizerAdded) {
				for(int i =0; i<4;i++) {
					if(orderOfDosesAdded[i]==null  ||orderOfDosesAdded[i].equals("Pfizer")) {
						orderOfDosesAdded[i] = "Pfizer";
						numOfTypesAdded++;
						pfizerAdded = true;
						break;
					}
				}
			}

			totalPfizer += supply;
		}
		else if(vax.codename.equals("Ad26.COV2.S")) {
			if(!janssenAdded) {
				for(int i =0; i<4;i++) {
					if(orderOfDosesAdded[i]==null  ||orderOfDosesAdded[i].equals("Janssen")) {
						orderOfDosesAdded[i] = "Janssen";
						numOfTypesAdded++;
						janssenAdded = true;
						break;
					}
				}
			}

			totalJanssen += supply;
		}
		else if(vax.codename.equals("AZD1222")) {
			if(!astraAdded) {
				for(int i =0; i<4;i++) {
					if(orderOfDosesAdded[i]==null||orderOfDosesAdded[i].equals("Astra")) {
						orderOfDosesAdded[i] = "Astra";
						numOfTypesAdded++;
						astraAdded = true;
						break;
					}
				}
			}

			totalAstra += supply;
		}
		else {
			throw new UnrecognizedVaccineCodeNameException(vax.codename +" is not a recognized vaccine.");
		}

		if(limitDosesAdded < (totalDosesAvailable+supply)) {
			throw new TooMuchDistributionException("too many doses");
		}

		totalDosesAvailable += supply;
	}

	public void bookAppointment(HealthRecord HR) throws InsufficientVaccineDosesException{


		if(totalDosesAvailable>=(vaccineReserved+1)) {
			appointments[numOfAppointments] = HR;
			numOfAppointments++;
			HR.numAppointments++;
			HR.appointmentLocation = this.location;
			vaccineReserved++;
			HR.appointmentSuccess =true;
		}
		else {
			HR.appointmentSuccess = false;
			HR.appointmentLocation = this.location;
			throw new InsufficientVaccineDosesException("Insufficient Vaccines available.");

		}
	}

	public void administer(String date) {
		
		int doseCounter = 0;
		
		for(int numAdministered =0; numAdministered<numOfAppointments;numAdministered++) {
			
			int dosesTaken = appointments[numAdministered].numDosesReceived;
			
			appointments[numAdministered].numAppointments --;
			appointments[numAdministered].numDosesReceived ++;
			appointments[numAdministered].date[dosesTaken] = date;
			appointments[numAdministered].numAppointments--;
			appointments[numAdministered].location[dosesTaken]= this.location;
			
			int limit = vaccineReserved*4 - doseCounter*4+1;
			
			for(int i = 0; i<limit;i++) {
				if(orderOfDosesAdded[doseCounter]!=null) {
					if(orderOfDosesAdded[doseCounter].equals("Moderna")) {
						if(totalModerna ==0) {
							doseCounter++;
						}
						if(totalModerna>0) {
							totalModerna--;
							
							appointments[numAdministered].vax[dosesTaken] = new Vaccine("mRNA-1273", "RNA", "Moderna");
							if(totalModerna ==0) {
								doseCounter++;
							}
							break;
						}
						
					}
					else if(orderOfDosesAdded[doseCounter].equals("Pfizer")) {
						if(totalPfizer ==0) {
							doseCounter++;
						}
						
						if(totalPfizer>0) {
							totalPfizer--;
							
							appointments[numAdministered].vax[dosesTaken] = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
							
							if(totalPfizer ==0) {
								doseCounter++;
							}
							break;
						}
						
					}
					else if(orderOfDosesAdded[doseCounter].equals("Astra")) {
						
						if(totalAstra ==0) {
							doseCounter++;
						}
						if(totalAstra>0) {
							totalAstra--;
							
							appointments[numAdministered].vax[dosesTaken] = new Vaccine("AZD1222", "Non Replicating Viral Vector", "Oxford/AstraZeneca");
							
							if(totalAstra ==0) {
								doseCounter++;
							}
							break;
						}
						
					}
					else if(orderOfDosesAdded[doseCounter].equals("Janssen")) {
						
						if(totalJanssen ==0) {
							doseCounter++;
						}
						if(totalJanssen>0) {
							totalJanssen--;
							
							appointments[numAdministered].vax[dosesTaken] = new Vaccine("Ad26.COV2.S", "Non Replicating Viral Vector", "Janssen");
							
							if(totalJanssen ==0) {
								doseCounter++;
							}
							break;
						}
					}
				}
			}
			
//			if(orderOfDosesAdded[doseCounter]!=null) {
//				if(orderOfDosesAdded[doseCounter].equals("Moderna")) {
//					if(totalModerna ==0) {
//						doseCounter++;
//					}
//					if(totalModerna>0) {
//						totalModerna--;
//						
//						appointments[numAdministered].vax[dosesTaken] = new Vaccine("mRNA-1273", "RNA", "Moderna");
//						if(totalModerna ==0) {
//							doseCounter++;
//						}
//					}
//				}
//				else if(orderOfDosesAdded[doseCounter].equals("Pfizer")) {
//					if(totalPfizer ==0) {
//						doseCounter++;
//					}
//					
//					if(totalPfizer>0) {
//						totalPfizer--;
//						
//						appointments[numAdministered].vax[dosesTaken] = new Vaccine("BNT162b2", "RNA", "Pfizer/BioNTech");
//						
//						if(totalPfizer ==0) {
//							doseCounter++;
//						}
//					}
//				}
//				else if(orderOfDosesAdded[doseCounter].equals("Astra")) {
//					
//					if(totalAstra ==0) {
//						doseCounter++;
//					}
//					if(totalAstra>0) {
//						totalAstra--;
//						
//						appointments[numAdministered].vax[dosesTaken] = new Vaccine("AZD1222", "Non Replicating Viral Vector", "Oxford/AstraZeneca");
//						
//						if(totalAstra ==0) {
//							doseCounter++;
//						}
//					}
//				}
//				else if(orderOfDosesAdded[doseCounter].equals("Janssen")) {
//					
//					if(totalJanssen ==0) {
//						doseCounter++;
//					}
//					if(totalJanssen>0) {
//						totalJanssen--;
//						
//						appointments[numAdministered].vax[dosesTaken] = new Vaccine("Ad26.COV2.S", "Non Replicating Viral Vector", "Janssen");
//						
//						if(totalJanssen ==0) {
//							doseCounter++;
//						}
//					}
//				}
//			}
		}
		
//		appointments[numAdministered].numDosesReceived = numOfAppointments;
//		
//		appointments[appointments[numAdministered].numDosesReceived].date[numAdministered] = date;
//		appointments[numAdministered].numDosesReceived++;
//		numAdministered++;

//		for(int i = 0; i<numOfAppointments;i++) {
//			
//		}
		
		totalDosesAvailable -= numOfAppointments;
		vaccineReserved-=numOfAppointments;
		numOfAppointments=0;

	}
}