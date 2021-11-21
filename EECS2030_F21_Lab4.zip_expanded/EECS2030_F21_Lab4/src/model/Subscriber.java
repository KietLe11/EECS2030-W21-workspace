package model;

public class Subscriber extends Follower{

	protected String[] recommendedVideos;
	
	public Subscriber(String name, int maxNumOfChannelsFollowed, int maxRecommendVids) {
		super(name, maxNumOfChannelsFollowed, maxRecommendVids);
		recommendedVideos = new String[maxRecommendVids];
	}
	
	/*
	 * accessors
	 */
	
	public String getClassType() {
		return "Subscriber";
	}
	
	/*
	 * Mutators
	 */
	public void recommendVid(String vidname) {
		
		norv++;
	}
}
