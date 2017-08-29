package com.metacube.controller;
import com.metacube.facade.GuestFacade;

/**
 * GuestController Takes the input from views and pass to GuestFacade
 * @author Rahul Kumar
 *
 */
public class GuestController {

	/**
	 * Adds a Guest
	 * @param id
	 * @param name
	 * @param age
	 */
	public void addGuest(int id, String name, int age) {
		GuestFacade guestFacade = new GuestFacade();
		guestFacade.addGuest(id,name,age);
	}

	/**
	 * shows the guests
	 */
	public void viewGuests() {
		GuestFacade guestFacade = new GuestFacade();
		guestFacade.viewGuests();
		
	}

	/**
	 * shows all the alloted rooms
	 */
	public void showAllotedRooms() {
		GuestFacade guestFacade = new GuestFacade();
		guestFacade.showAllotedRooms();
	}

	/**
	 * checks that guest already exists with same id
	 * @param id
	 * @return
	 */
	public boolean isIdAlreadyExists(int id) {
		GuestFacade guestFacade = new GuestFacade();
		return guestFacade.isIdAlreadyExists(id);
	}

	/**
	 * returns the total number of Guests
	 * @return
	 */
	public int getTotalNumberOfGuests() {
		GuestFacade guestFacade = new GuestFacade();
		return guestFacade.getTotalNumberOfGuests();
	}

}
