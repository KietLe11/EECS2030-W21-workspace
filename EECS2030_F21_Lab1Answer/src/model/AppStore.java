package model;

public class AppStore {

	
	
	private String branch;
	
	public AppStore(String branch, int maxAvailableApps){
		this.branch = branch;
	}
	
	public String getBranch() {
		return branch;
	}
	
	public App getApp(String nameOfApps){
		return null;
	}
	
	public String[] getStableApps(int numberOfUpdates) {
		
		return new String[0];
	}
	
	public void addApp(App app) {
		
	}
}
