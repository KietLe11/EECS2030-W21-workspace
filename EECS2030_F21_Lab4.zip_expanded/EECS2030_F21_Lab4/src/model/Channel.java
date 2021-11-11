package model;



public class Channel {

	private int maxFollowers;
	private int maxVideos;
	private String name;

	private String stringToGo;
	private String status;

	private int numOfFollows;

	private String[] videoNames;
	private int nov;

	public Channel(String name, int maxVideos, int maxFollowers) {
		this.maxFollowers = maxFollowers;
		this.maxVideos = maxVideos;
		this.name = name;

		videoNames = new String[maxVideos];

		status = "new";

	}

	/*
	 * To String of Toooo stringgg
	 */
	public String toString() {
		if(status.equals("new")) {
			stringToGo = String.format("%s released no videos and has no followers.", name);
		}
		
		else if(status.equals("newVid")) {
			stringToGo = String.format("%s released <", name);
			for(int i =0; i<nov;i++) {
				stringToGo += videoNames[i];
				if(!(i==nov-1)) {
					stringToGo += ", ";
				}
				else {
					stringToGo += ">";
				}
			}
			if(numOfFollows==0) {
				stringToGo += String.format(" and has no followers.");
			}
			else {
				stringToGo += String.format(" and has $d followers.", numOfFollows);
			}
		}
		
		
		return stringToGo;
	}

	public void releaseANewVideo(String newVideoName) {
		videoNames[nov] = newVideoName;
		nov++;
		status = "newVid";
	}

}
