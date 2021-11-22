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
	
	public String getRecommendedVideos(int number){
		return recommendedVideos[number];
	}
	
	/*
	 * Mutators
	 */
	public void recommendVid(String vidname) {
		recommendedVideos[norv]=vidname;
		norv++;
	}
	
	public void watch(String vidname, int minutes) {
		
		boolean videoExist= false;
		for(int i =0; i<norv;i++) {
			if(recommendedVideos[i].equals(vidname)){
				videoExist =true;
				break;
			}
		}
		
		if(videoExist) {
			for(int i = 0; i<nof;i++) {
				if(channels[i].hasVideo(vidname)) {
					channels[i].watchVideo(vidname, minutes);
					break;
				}
			}
		}
	}
}
