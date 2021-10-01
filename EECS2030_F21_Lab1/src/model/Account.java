package model;

public class Account {

	private AppStore store;
	private String name;
	private String[] namesOfDownloadedApps;
	//private int numberOfApps = this.store.getStableApps(0).length;
	private App[] objectsOfDownloadedApps = new App[50];
	private App[] downloadedApps = new App[50];
	private AppStore[] stores;
	private int numberOfStores;
	private int numberOfDownloadedApps=0;
	private int rating;
	
	/*
	 * Status has different types:
	 * 1. Good = "good"
	 * 2. Tried to uninstall an app that is not installed = "not installed"
	 * 3. Tried to submit ratings when app is not installed = "not installed"
	 * 
	 */
	private String status; 
	private String contextAppName;
	
	public Account(String name, AppStore store) {
		this.name = name;
		this.store = store;
		
		this.namesOfDownloadedApps = this.getNamesOfDownloadedApps();
		status = "good";
	}
	
	public String toString() {
		
		String statusReturn ="";
		
		if(status.equals("not installed for uninstall") ){
			statusReturn = "Error: " + contextAppName + " has not been downloaded for "+name +".";
		}
		else if(status.equals("not installed for rating") ){
			statusReturn = "Error: " + contextAppName + " is not a downloaded app for "+name +".";
		}
		else if(status.equals("switchedStore") ){
			statusReturn = "Account for " +name + " is now linked to the "+store.getBranch() +" store.";
		}
		else if(status.equals("good")){
			statusReturn = "An account linked to the "+ store.getBranch()+" store is created for "+name+".";
		}
		else if(status.equals("download")){
			statusReturn = contextAppName + " is successfully downloaded for "+name+".";
		}
		else if(status.equals("downloadError")){
			statusReturn = "Error: " +contextAppName+" has already been downloaded for "+ name+".";
		}
		else if(status.equals("ratingSubmitted")){
			statusReturn = "Rating score "+this.rating+" of " +name+ " is successfully submitted for "+contextAppName+".";
		}
		else if(status.equals("uninstalled")){
			statusReturn = contextAppName + " is successfully uninstalled for "+name+".";
		}
		return statusReturn;
	}
	
	public String[] getNamesOfDownloadedApps() {
		namesOfDownloadedApps = new String[numberOfDownloadedApps];
		if(numberOfDownloadedApps!=0) {
			for(int i =0; i<numberOfDownloadedApps;i++) {
				namesOfDownloadedApps[i] = this.getObjectsOfDownloadedApps()[i].getName();
			}
		}
		
		return namesOfDownloadedApps;
	}
	
	public App[] getObjectsOfDownloadedApps() {
		objectsOfDownloadedApps = new App[numberOfDownloadedApps];
		if(numberOfDownloadedApps!=0) {
			for(int i =0; i<numberOfDownloadedApps;i++) {
				objectsOfDownloadedApps[i] = downloadedApps[i];
			}
		}
	
		return objectsOfDownloadedApps;
	}
	
	public void uninstall(String appName) {
		status = "not installed for uninstall";
		contextAppName = appName;
		int counter =0;
		
		
		while(status.equals(("not installed for uninstall")) && counter<numberOfDownloadedApps){
			if(this.getObjectsOfDownloadedApps()[counter].getName().equals(appName)) {
				status = "uninstalled";
				counter--;
			}
			counter++;
		}
		if(status.equals("uninstalled")) {
			for(int i = counter; i<numberOfDownloadedApps-1; i++ ) {
				downloadedApps[i] = this.getObjectsOfDownloadedApps()[i+1];
			}
			downloadedApps[numberOfDownloadedApps-1]=null;
			numberOfDownloadedApps--;
		}
	}
	
	public void submitRating(String appName, int rating) {
		contextAppName = appName;
		status = "not installed for rating";
		int counter =0;
		while(status.equals("not installed for rating") && counter<numberOfDownloadedApps){
			if(this.getObjectsOfDownloadedApps()[counter].getName().equals(appName)) {
				status = "ratingSubmitted";
				counter--;
			}
			counter++;
		}
		
		if(status.equals("ratingSubmitted")) {
			objectsOfDownloadedApps[counter].submitRating(rating);
			this.rating = rating;
		}
	}
	
	public void switchStore(AppStore alternateAppStore) {
		this.store = alternateAppStore;
		status = "switchedStore";
	}
	
	public void download(String appName) {
		contextAppName = appName;
		
		for(int i = 0; i<numberOfDownloadedApps; i++) {
			if(this.getObjectsOfDownloadedApps()[i].getName().equals(appName)) {
				status = "downloadError";
			}
		}
		

		if(numberOfDownloadedApps !=50 && !(status.equals("downloadError"))) {			
			downloadedApps[numberOfDownloadedApps] = store.getApp(appName);
			
			numberOfDownloadedApps++;
			
			status = "download";
		}
//		if((store.getApp(appName) !=null) && !(status.equals("downloadError"))) {
//			downloadedApps[numberOfDownloadedApps] = store.getApp(appName);
//			numberOfDownloadedApps++;
//			status = "download";
//		}		
	}
	
}
