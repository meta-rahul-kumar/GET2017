package com.metacube.models;

/**
 * College Model Class
 * @author Rahul Kumar
 *
 */
public class College extends BaseEntity{
	int collegeID;
	String collegeName;
	int collegeSeats;
	
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
		collegeSeats = seats;
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
	public void setCollegeSeats(int seats) {
		collegeSeats = seats;
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
	public int getCollegeSeats() {
		return collegeSeats;
	}
}
