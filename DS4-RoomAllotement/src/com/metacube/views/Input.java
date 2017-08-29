package com.metacube.views;
import com.metacube.controller.GuestController;
import com.metacube.controller.RoomsController;
import com.metacube.utils.Util;

/**
 * Performs input methods
 * @author Rahul Kumar
 *
 */
public class Input {

	/**
	 * Adds a Guest
	 */
	public void addGuest() {
		int id = Util.getID();
		String name = Util.getName();
		int age = Util.getAge();
		GuestController controller = new GuestController();
		
		controller.addGuest(id,name,age);
		
	}

	/**
	 * Adds number of Rooms
	 * @param noOfRooms
	 */
	public void addRooms(int noOfRooms) {
		RoomsController roomsController = new RoomsController();
		roomsController.addRooms(noOfRooms);
		
	}

}
