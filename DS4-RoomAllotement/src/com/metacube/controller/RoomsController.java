package com.metacube.controller;
import com.metacube.facade.RoomsFacade;

/**
 * Rooms Controller takes input from views and pass to RoomFacade
 * @author Rahul Kumar
 *
 */
public class RoomsController {

	/**
	 * Adds a Room
	 * @param noOfRooms
	 */
	public void addRooms(int noOfRooms) {
		RoomsFacade roomsFacade = new RoomsFacade();
		roomsFacade.addRooms(noOfRooms);
	}

	/**
	 * Allot rooms for Guests
	 */
	public void allotRooms() {
		RoomsFacade roomsFacade = new RoomsFacade();
		roomsFacade.allotRooms();
	}

	/**
	 * returns the total number of rooms
	 * @return
	 */
	public int getTotalNumberOfRooms() {
		RoomsFacade roomsFacade = new RoomsFacade();
		return roomsFacade.getNoOfRooms();
	}

	public void flushValues() {
		RoomsFacade roomsFacade = new RoomsFacade();
		roomsFacade.flushValues();
	}

}
