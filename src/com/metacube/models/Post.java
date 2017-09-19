package com.metacube.models;
/**
 * Class Saves the Post Details
 * @author Rahul Kumar
 *
 */
public class Post {
	String postId;
	String postCreator;
	String postText;
	String postCreatedDate;
	
	/**
	 * method - setPost
	 * method save the post details
	 * @param id
	 * @param creator
	 * @param text
	 * @param date
	 */
	public void setPost(String id, String creator,
			String text, String date) {
		this.postId = id;
		this.postCreator = creator;
		this.postText = text;
		this.postCreatedDate = date;
		
	}
	
	/**
	 * method returns the Post ID
	 * @return
	 */
	public String getPostId() {
		return postId;
	}
	
	/**
	 * method returns the Post Creator ID
	 * @return
	 */
	public String getPostCreator() {
		return postCreator;
	}
	
	/**
	 * method returns the Post Text
	 * @return
	 */
	public String getPostText() {
		return postText;
	}
	
	/**
	 * method returns the Post Creation Date
	 * @return
	 */
	public String getPostCreationDate() {
		return postCreatedDate;
	}
}
