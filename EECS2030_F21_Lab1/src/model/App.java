package model;

import model.Log;

public class App {
	
	private int numberOfRatings;
	
	private String appName;
	
	private Log[] log;
	
	private int numberOfLogs =0;
	private int maxNumberOfRatings;
	
	int[] ratings;
	
	public App (String appName, int maxNumberOfRatings) {
		this.maxNumberOfRatings = maxNumberOfRatings;
		this.appName = appName;
		
		log = new Log[20];
		
		//creating the ratings array and setting all the slots to zero
		//each slot represents the number of ratings for each category: 1 star, 2 star, 3 star, 4 star, 5 star
		ratings = new int[5];
//		for(int i =0; 5>i; i++) {
//			ratings[i]=0;
//		}
	}
	
	public String getName() {
		return appName;
	}
	
	public String getWhatIsNew() {
		
		if(numberOfLogs!=0) {
			String fixes = log[numberOfLogs-1].getFixes();
			return fixes;
		}
		else {
			return "n/a";
		}
	}
	
	public Log[] getUpdateHistory() {
		Log[] log2 = new Log[numberOfLogs];
		for(int i = 0 ; i<numberOfLogs; i++) {
			log2[i] = log[i];
		}
		
		return log2;
	}
	
	public Log getVersionInfo(String update) {
		for(int i =0; i<numberOfLogs; i++) {
			if(this.log[i].getVersion().equals(update)) {
				return this.log[i];
			}
		}
		return null;
	}
	
//	public String getAverageRatingString() {
//		double average = this.getAverageRatingDouble();
//		if(average!=0) {
//			return String.valueOf(average);
//		}
//		return "n/a";
//	}
	
	public double getAverageRatingDouble() {
		if(ratings.length !=0) {
			double average = (ratings[0] + 2*ratings[1] + 3*ratings[2]+ 4*ratings[3]+ 5*ratings[4])/numberOfRatings;
			return average;
		}
		return 0;
	}
	
	public String getRatingReport() {
		if(numberOfLogs>0) {
			double average = this.getAverageRatingDouble();
			String report = "Average of " +numberOfRatings+ " ratings: " +average + " (Score 5: "+ratings[4]+", Score 4: "+ratings[3]+", Score 3: "+ratings[2]+", Score 2: " +ratings[1]+", Score 1: "+ratings[0]+")";
			return report;
		}
		return "No ratings submitted so far!";
	}
	
	
	public String toString() {
		String info;
		if(numberOfRatings == 0) {
			info = appName+" (Current Version: "+this.getWhatIsNew()+"; Average Rating: "+"n/a"+")";
		}
		else {
			info = appName+" (Current Version: "+this.getWhatIsNew()+"; Average Rating: "+String.format("%.1f", this.getAverageRatingDouble())+")";
		}
		return info;
	}
	
	

}
