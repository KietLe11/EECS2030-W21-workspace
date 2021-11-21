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
	
	protected double[] avgWatch;
	protected double[] maxWatch;
	protected int[] views;
	
	public Monitor(String name, int maxNumOfChannelsToFollow) {
		super(name, maxNumOfChannelsToFollow);
	}
	
	/*
	 * Mutator
	 */
	
}
