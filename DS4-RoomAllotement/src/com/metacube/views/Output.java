package com.metacube.views;
import com.metacube.controller.GuestController;
import com.metacube.controller.RoomsController;

/**
 * Performs the output methods
 * @author Rahul Kumar
 *
 */
public class Output {

	/**
	 * Shows the Guests
	 */
	public void showGuests() {
		GuestController guestController = new GuestController();
		guestController.viewGuests();
	}

	/**
	 * Allots Rooms
	 */
	public void allotRooms() {
		RoomsController roomsController = new RoomsController();
		roomsController.allotRooms();
	}

	/**
	 * Show Alloted Rooms
	 */
	public void showAllotedRooms() {
		GuestController guestController = new GuestController();
		guestController.showAllotedRooms();
	}

	/**
	 * Checks that a user id already exists with same id
	 * @param id
	 * @return
	 */
	public boolean isIdAlreadyExists(int id) {
		GuestController guestController = new GuestController();
		return guestController.isIdAlreadyExists(id);
	}

	/**
	 * returns total number of guests
	 * @return
	 */
	public int getTotalNumberOfGuests() {
		GuestController guestController = new GuestController();
		return guestController.getTotalNumberOfGuests();
	}

	/**
	 * return total number of rooms
	 * @return
	 */
	public int getTotalNumberOfRooms() {
		RoomsController roomsController = new RoomsController();
		return roomsController.getTotalNumberOfRooms();
	}

}
