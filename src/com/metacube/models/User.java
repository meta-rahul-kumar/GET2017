package com.metacube.models;
/**
 * Class used to get and set the user details
 * @author User17
 *
 */
public class User {
	private String userId;
	private String userName;
	private String userGender;
	private String userEmail;
	
	/**
	 * User Class Empty Constructor
	 */
	public User() {
		
	}
	
	/**
	 * method sets the user details
	 * @param userId
	 * @param userName
	 * @param userGender
	 * @param userPhone
	 */
	public void setUser(String userId, String userName, String userGender, String userPhone) {
		this.userId = userId;
		this.userName = userName;
		this.userGender = userGender;
		this.userEmail = userPhone;
	}
	
	/**
	 * method returns the User ID
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * method returns the UserName
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * method return the Gender of User
	 * @return
	 */
	public String getUserGender() {
		return userGender;
	}
	
	/**
	 * method return the user Phone Number
	 * @return
	 */
	public String getUserEmail() {
		return userEmail;
	}
}
