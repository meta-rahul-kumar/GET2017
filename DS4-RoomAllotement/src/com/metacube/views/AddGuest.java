package com.metacube.views;
import com.metacube.menu.Action;

/**
 * Adds a Guest
 * @author Rahul Kumar
 *
 */
public class AddGuest implements Action {

	@Override
	public void performAction() {
		Output output = new Output();
		if (output.getTotalNumberOfGuests() != output.getTotalNumberOfRooms()) {
			Input input = new Input();
			input.addGuest();
		} else {
			System.out.println("There are Only " + output.getTotalNumberOfRooms() + " Rooms. Unable to add Guest.");
		}
	}

}
