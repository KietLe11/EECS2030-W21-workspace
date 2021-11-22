package model;

public class Monitor extends Follower{
	
	/*
	 * video one-> [0]
	 * video two-> [1]
	 * .
	 * .
	 * .
	 * video n-> [n-1]
	 */
	
	protected double[] avgWatchTime;
	protected int[] totalWatchTime;
	protected int[] maxWatchTime;
	protected int[] views;
	
	public Monitor(String name, int maxNumOfChannelsToFollow) {
		super(name, maxNumOfChannelsToFollow);
		
		avgWatchTime = new double[maxNumOfChannelsToFollow];
		maxWatchTime = new int[maxNumOfChannelsToFollow];
		totalWatchTime = new int[maxNumOfChannelsToFollow];
		views = new int[maxNumOfChannelsToFollow];
	}
	
	/*
	 * Mutator
	 */
	public void updateMonitor(String channelName, String vidName, int watchTime) {
		
		int position=0;
		//looking through the channels to find which position to put the stats in
		for(int i =0; i<nof;i++) {
			if(channels[i].getName().equals(channelName)) {
				position = i;
			}
		}
		views[position]++;
		totalWatchTime[position]+=watchTime;
		avgWatchTime[position] = (double) totalWatchTime[position]/ (double)views[position];
		if(watchTime>maxWatchTime[position]) {
			maxWatchTime[position]=watchTime;
		}
	}
	
	/*
	 * Accessors
	 */
	public String toString() {
		String stringToGo = "";
		//"Monitor Stat Sensor A follows [Cafe Music BGM {#views: 1, max watch time: 20, avg watch time: 20.00}, 
		//I Love You Venice]."
		stringToGo = String.format("Monitor %s follows ", name);
		
		if(nof!=0) {
			stringToGo+= "[";
			for(int i =0; i<nof; i++) {
				
				stringToGo += channels[i].getName();
				
				if(views[i] !=0) {
					stringToGo += String.format(" {#views: %d, max watch time: %d, avg watch time: %.2f}", views[i], 
							maxWatchTime[i], avgWatchTime[i]);
				}
				
				if(!(i==nof-1)) {
					stringToGo += ", ";
				}
			}
			
			stringToGo += "].";
		}
		else if(nof==0) {
			stringToGo += "no channels.";
		}
		return stringToGo;
	}
	
}
