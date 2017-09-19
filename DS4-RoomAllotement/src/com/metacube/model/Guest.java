package com.metacube.model;

/**
 * Guest Model Class
 * @author Rahul Kumar
 *
 */
public class Guest {
	int id;
	String name;
	int age;
	int allotedRoom;
	
	/**
	 * Guest Constructor
	 */
	public Guest() {
		allotedRoom = -1;
	}
	
	/**
	 * Sets the Guest ID
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Sets the Guest name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * sets the Guest Age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * returns the Guest ID
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * returns the Guest Name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns the Guest Age
	 * @return
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * returns the Alloted Room
	 * @return
	 */
	public int getAllotedRoom() {
		return allotedRoom;
	}
	
	/**
	 * set the Alloted Room
	 * @param roomNo
	 */
	public void setAllotedRoom(int roomNo) {
		allotedRoom = roomNo;
	}
}
