package com.metacube.views;
import com.metacube.menu.Action;

/**
 * Performs allotment process
 * @author Rahul Kumar
 *
 */
public class AllotRooms implements Action {

	@Override
	public void performAction() {
		Output output = new Output();
		if (output.getTotalNumberOfGuests() == 0 || output.getTotalNumberOfRooms() == 0) {
			System.out.println("Not Enought Data For Allotment of Rooms");
		} else {
			output.flushValues();
			output.allotRooms();
			output.showAllotedRooms();
		}
	}

}
