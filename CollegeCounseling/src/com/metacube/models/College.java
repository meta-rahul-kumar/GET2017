package com.metacube.models;

/**
 * College Model Class
 * @author Rahul Kumar
 *
 */
public class College extends BaseEntity{
	int collegeID;
	String collegeName;
	int noOfSeatsInCollege;
	
	/**
	 * College Constructor
	 */
	public College() {
		
	}
	
	/**
	 * College Parameterized Constructor
	 * @param id
	 * @param name
	 * @param seats
	 */
	public College(int id, String name, int seats) {
		collegeID = id;
		collegeName = name;
		noOfSeatsInCollege = seats;
	}
	
	/**
	 * sets the college ID
	 * @param id
	 */
	public void setCollegeID(int id) {
		collegeID = id;
	}
	
	/**
	 * sets the college name
	 * @param name
	 */
	public void setCollegeName(String name) {
		collegeName = name;
	}
	
	/**
	 * sets the college empty seats
	 * @param seats
	 */
	public void setNoOfSeatsInCollege(int seats) {
		noOfSeatsInCollege = seats;
	}
	
	/**
	 * returns the college id
	 * @return
	 */
	public int getCollegeID() {
		return collegeID;
	}
	
	/**
	 * returns the college name
	 * @return
	 */
	public String getCollegeName() {
		return collegeName;
	}
	
	/**
	 * retruns the college empty seats
	 * @return
	 */
	public int getNoOfSeatsInCollege() {
		return noOfSeatsInCollege;
	}
}
