package com.metacube.views;
import com.metacube.menu.Action;
import com.metacube.utils.Util;

/**
 * Adds Number of Rooms
 * @author Rahul Kumar
 *
 */
public class AddRooms implements Action {

	@Override
	public void performAction() {
		int noOfRooms = Util.getRooms();
		Input input = new Input();
		
		input.addRooms(noOfRooms);

	}

}
