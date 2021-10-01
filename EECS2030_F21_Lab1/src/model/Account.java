package model;

public class Account {

	private AppStore store;
	private String name;
	private String[] namesOfDownloadedApps = new String[50];
	//private int numberOfApps = this.store.getStableApps(0).length;
	private App[] objectsOfDownloadedApps = new App[50];
	private App[] downloadedApps = new App[50];
	private AppStore[] stores;
	private int numberOfStores;
	private int numberOfDownloadedApps=0;
	
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
		return statusReturn;
	}
	
	public String[] getNamesOfDownloadedApps() {
		namesOfDownloadedApps = new String[numberOfDownloadedApps];
		for(int i =0; i<numberOfDownloadedApps;i++) {
//			namesOfDownloadedApps[i] = this.store.getApps()[i].getName();
			namesOfDownloadedApps[i] = objectsOfDownloadedApps[i].getName();
		}
		return namesOfDownloadedApps;
	}
	
	public App[] getObjectsOfDownloadedApps() {
		objectsOfDownloadedApps = new App[numberOfDownloadedApps];
//		for(int i =0; i<numberOfDownloadedApps;i++) {
//			objectsOfDownloadedApps[i] = this.store.getApps()[i];
//		}
		return objectsOfDownloadedApps;
	}
	
	public void uninstall(String appName) {
		status = "not installed for uninstall";
		contextAppName = appName;
		int counter =0;
		
		
		while(status.equals(("not installed for uninstall")) && counter<numberOfDownloadedApps){
			if(objectsOfDownloadedApps[counter].getName().equals(appName)) {
				status = "good";
				counter--;
			}
			counter++;
		}
		if(status.equals("good")) {
			for(int i = counter; i<numberOfDownloadedApps; i++ ) {
				objectsOfDownloadedApps[i] = objectsOfDownloadedApps[i+1];
			}
			objectsOfDownloadedApps[numberOfDownloadedApps-1]=null;
		}
	}
	
	public void submitRating(String appName, int rating) {
		contextAppName = appName;
		status = "not installed for rating";
		int counter =0;
		while(status.equals("not installed for rating") && counter<numberOfDownloadedApps){
			if(objectsOfDownloadedApps[counter].getName().equals(appName)) {
				status = "good";
				counter--;
			}
			counter++;
		}
		
		if(status.equals(appName)) {
			objectsOfDownloadedApps[counter].submitRating(rating);
		}
	}
	
	public void switchStore(AppStore alternateAppStore) {
		this.store = alternateAppStore;
		status = "switchedStore";
	}
	
	public void download(String appName) {
		contextAppName = appName;
		
		for(int i = 0; i<numberOfDownloadedApps; i++) {
			if(this.getNamesOfDownloadedApps()[i].equals(appName)) {
				status = "downloadError";
			}
		}
		if(numberOfDownloadedApps !=50 && !(status.equals("downloadError"))) {			
			objectsOfDownloadedApps[numberOfDownloadedApps] = store.getApp(appName);
			
			numberOfDownloadedApps++;
			
			status = "download";
		}
	}
	
}
