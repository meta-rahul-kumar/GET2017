package com.metacube.models;
/**
 * Class Saves the Organisation Followers
 * @author Rahul Kumar
 *
 */
public class OrganisationFollower {
	String followId;
	String followerUserId;
	String followOrganisationId;
	String followDate;
	
	/**
	 * method - setFollower
	 * method sets the Follower details
	 * @param id
	 * @param userId
	 * @param organisationId
	 * @param date
	 */
	public void setFollower(String id, String userId, String organisationId, String date) {
		followId = id;
		followerUserId = userId;
		followOrganisationId = organisationId;
		followDate = date;
	}
	
	/**
	 * method returns the Follower ID
	 * @return
	 */
	public String getFollowerUserId() {
		return followerUserId;
	}
	
	/**
	 * method returns the Follow ID
	 * @return
	 */
	public String getFollowId() {
		return followId;
	}
	
	/**
	 * method returns the Followed Organisation ID
	 * @return
	 */
	public String getFollowOrganisationId() {
		return followOrganisationId;
	}
	
	/**
	 * method returns the Followed Date
	 * @return
	 */
	public String getFollowDate() {
		return followDate;
	}
}
