package model;

public class AppStore {
	
	private String branch;
	private int maxNumberOfApps;
	private int numberOfApps;
	private App[] apps;
	private String[] stableApps;
	private int numberOfStableApps;
	
	public AppStore(String branch, int maxNumberOfApps) {
		this.branch = branch;
		this.maxNumberOfApps = maxNumberOfApps;
		
		apps = new App[maxNumberOfApps];
	}
	
	public String getBranch() {
		return branch;
	}
	
	public App getApp(String appName) {
		if(numberOfApps>0) {
			for(int i = 0; i<numberOfApps; i++) {
				if(apps[i].getName().equals(appName)) {
					return apps[i];
				}
			}
		}
		return null;
	}
	
	public App[] getApps() {
		if(numberOfApps>0) {
			return apps;
		}
		return null;
	}
	
	public String[] getStableApps(int minNumberOfStableApps) {
		for(int i = 0; i<numberOfApps; i++) {
			if(apps[i].getUpdateHistory().length>=minNumberOfStableApps) {
				numberOfStableApps++;
			}
		}
		
		stableApps = new String[numberOfStableApps];
		int stableAppsAdded = 0;
		for(int i = 0; i<this.apps.length; i++) {
			if(this.apps[i] != null) {

				if(apps[i].getUpdateHistory().length>=minNumberOfStableApps) {
					int numberOfUpdates = this.apps[i].getUpdateHistory().length-1;
					//stableApps[stableAppsAdded] = apps[i].getName() + "(" + apps[i].getUpdateHistory().length +" versions;"+" Current Version: Version "+ apps[i].getUpdateHistory()[apps[i].getUpdateHistory().length].getVersion()+" contains "+apps[i].getUpdateHistory()[apps[i].getUpdateHistory().length].getNumberOfFixes()+" fixes"+ "";
					stableApps[stableAppsAdded] = this.apps[i].getName() + " (" + (numberOfUpdates+1) +" versions;"+" Current Version: "+this.apps[i].getUpdateHistory()[numberOfUpdates].toString()+")";
					stableAppsAdded++;
				}
			}
		}
		return stableApps;
	}
	
	public void addApp(App app) {
		if(numberOfApps<=maxNumberOfApps) {
			apps[numberOfApps] = app;
			numberOfApps++;
		}
	}
	
}
