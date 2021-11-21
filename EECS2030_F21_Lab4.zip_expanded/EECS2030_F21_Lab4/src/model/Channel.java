package model;



public class Channel {

	private int maxFollowers;
	private int maxVideos;
	private String name;

	private String stringToGo;
	private String status;

	private int numOfFollows;
	private Follower[] followers;

	private String[] videoNames;
	private int nov;

	public Channel(String name, int maxFollowers, int maxVideos) {
		this.maxFollowers = maxFollowers;
		this.maxVideos = maxVideos;
		this.name = name;

		videoNames = new String[maxVideos];

		status = "new";
		followers = new Follower[maxFollowers];
	}

	/*
	 * To String of Toooo stringgg
	 */
	public String toString() {
		stringToGo = String.format("%s released ", name);
		
		//no videos and no followers
		if(nov==0 && numOfFollows ==0) {
			stringToGo += "no videos and has no followers.";
		}
		
		//no videos and followers
		else if(nov==0 && numOfFollows!=0) {
			stringToGo += "no videos and is followed by [";
			for(int i =0; i<numOfFollows;i++) {
				if(followers[i] instanceof Subscriber) {
					stringToGo += String.format("Subscriber %s", followers[i].getName());
				}
				else if(followers[i] instanceof Monitor) {
					stringToGo += String.format("Monitor %s", followers[i].getName());
				}
				else {
					stringToGo += String.format("Follower %s", followers[i].getName());
				}
				if(!(i==numOfFollows-1)) {
					stringToGo += ", ";
				}
			}
			stringToGo +="].";
		}
		
		//video and followers
		else if(nov!=0 && numOfFollows ==0) {
			stringToGo += "<";
			for(int i =0; i<nov;i++) {
				stringToGo += videoNames[i];
				if(!(i==nov-1)) {
					stringToGo += ", ";
				}
				else {
					stringToGo += ">";
				}
			}
			stringToGo += String.format(" and has no followers.");
		}
		else if(nov!=0 && numOfFollows!=0) {
			stringToGo += "<";
			for(int i =0; i<nov;i++) {
				stringToGo += videoNames[i];
				if(!(i==nov-1)) {
					stringToGo += ", ";
				}
				else {
					stringToGo += ">";
				}
			}
			stringToGo += " and is followed by [";
			for(int i =0; i<numOfFollows;i++) {
				if(followers[i] instanceof Subscriber) {
					stringToGo += String.format("Subscriber %s", followers[i].getName());
				}
				else if(followers[i] instanceof Monitor) {
					stringToGo += String.format("Monitor %s", followers[i].getName());
				}
				else {
					stringToGo += String.format("Follower %s", followers[i].getName());
				}
				if(!(i==numOfFollows-1)) {
					stringToGo += ", ";
				}
			}
			stringToGo+="].";
		}
		return stringToGo;
	}
	
	/*
	 * Accessors
	 */
	
	public String getName() {
		return name;
	}
	
	/*
	 * Mutators
	 */
	public void releaseANewVideo(String newVideoName) {
		videoNames[nov] = newVideoName;
		nov++;
		
		for(int i =0; i<numOfFollows; i++) {
			if(followers[i] instanceof Subscriber) {
				((Subscriber) followers[i]).recommendVid(newVideoName);
			}
		}
	}
	
	//f is now following this channel
	public void follow(Follower f) {
		followers[numOfFollows] = f;
		numOfFollows++;
		status = "followers";
		followers[numOfFollows-1].addChannel(this);
	}
	public void unfollow(Follower f) {
		int position=0;
		boolean hasFollow = true;
		for(int i =0; i<numOfFollows; i++) {
			if(followers[i].equals(f)) {
				position = i;
				break;
			}
			else if(i==numOfFollows-1) {
				hasFollow = false;
			}
		}
		if(hasFollow) {
			int numberOfShifts = numOfFollows -1;
			for(int i =0; i<numberOfShifts; i++) {
				if(i!=numberOfShifts) {
					followers[position+i] = followers[position+i+1];
				}
				else {
					followers[numOfFollows-1] = null;
				}
			}
			numOfFollows --;
			if(numOfFollows == 0) {
				status = "no followers";
			}
			f.removeChannel(this);
		}
	}
}
