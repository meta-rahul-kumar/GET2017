package com.metacube.dao;

/**
 * RoomDAO manipulate the room
 * @author Rahul Kumar
 *
 */
public class RoomDAO {
	public static int totalRooms;
	public static RoomDAO roomDAO;
	
	public static  RoomDAO getInstance() {
		if (roomDAO == null) {
			synchronized (RoomDAO.class) {
				if (roomDAO == null) {
					roomDAO = new RoomDAO();
				}
			}
		}
		
		return roomDAO;
	}
	
	/**
	 * sets the total number of rooms
	 * @param number
	 */
	public void setNumberOfRoom(int number) {
		totalRooms = number;
	}
	
	/**
	 * returns the total number of rooms
	 */
	public int getNumberOfRoom() {
		return totalRooms;
	}
}
