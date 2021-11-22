package model;

public class Follower{
	
	protected String name;
	protected int maxRecommendVids;
	
	//protected String monitorName;
	protected int maxNumOfChannelsToFollow;
	
	protected String stringToGo;
	
	protected int nof; //number of channels that Follower follows
	protected Channel[] channels;
	
	protected int norv; //number of recommended videos
	protected String[] videos;
		

	public Follower() {}
	
	public Follower(String name){
		this.name = name;
	}
	
	//Constructor for subscriber
	public Follower(String name, int maxNumOfChannelsToFollow, int maxRecommendVids) {
		this.maxNumOfChannelsToFollow = maxNumOfChannelsToFollow;
		this.name = name;
		this.maxRecommendVids = maxRecommendVids;
		this.channels = new Channel[maxNumOfChannelsToFollow];
		this.videos = new String[maxRecommendVids];
	}
	
	//constructor for monitor
	public Follower(String name, int maxNumOfChannelsToFollow) {
		this.name = name;
		this.maxNumOfChannelsToFollow = maxNumOfChannelsToFollow;
		this.channels = new Channel[maxNumOfChannelsToFollow];
	}
	
	/*
	 * Mutator
	 */
	public void addChannel(Channel c) {
		this.channels[nof] = c;
		nof++;
	}
	public void removeChannel(Channel c) {
		int position = 0;
		boolean hasChannel = true;
		for(int i =0; i<nof;i++) {
			if(channels[i].equals(c)) {
				position = i;
				break;
			}
			else if(i==nof-1) {
				hasChannel = false;
			}
		}
		
		if(hasChannel) {
			int numberOfShifts = nof -1;
			for(int i = 0; i<numberOfShifts; i++) {
				if(i!=numberOfShifts) {
					channels[position+i] = channels[position+i+1];
				}
				else {
					channels[nof-1] = null;
				}
			}
			nof--;
		}
	}

	/*
	 * Accessor
	 */
	
	public String toString() {
		//"Subscriber Alan follows [Cafe Music BGM] and has no recommended videos."
	
		String type = "";
		if(this instanceof Subscriber) {
			type = "Subscriber";
		}
		else if(this instanceof Monitor) {
			type = "Monitor";
		}
		else {
			type = "Follower";
		}
			
		stringToGo= String.format("%s %s follows ", type, name);
		
		if(nof!=0 && norv ==0 && type.equals("Subscriber")) {
			stringToGo += "[";
			
			if(nof!=0) {
				for(int i =0; i<nof; i++) {
					stringToGo += channels[i].getName();
					if(!(i==nof-1)) {
						stringToGo += ", ";
					}
				}
			}
			stringToGo += "] and has no recommended videos.";
		}
		else if(nof ==0 && norv==0 && type.equals("Subscriber")) {
			stringToGo += "no channels and has no recommended videos.";
		}
		else if(nof !=0 && norv!=0 && type.equals("Subscriber")) {
			stringToGo += "[";	
			for(int i =0; i<nof; i++) {
				stringToGo += channels[i].getName();
				if(!(i==nof-1)) {
					stringToGo += ", ";
				}
			}
			stringToGo += "] and is recommended <";
			for(int i = 0; i<norv;i++) {
				stringToGo += ((Subscriber) this).recommendedVideos[i];
				if(!(i==norv-1)) {
					stringToGo+=", ";
				}
			}
			stringToGo += ">.";
		}

		return stringToGo;
	}
	public String getName() {
		return name;
	}
}
