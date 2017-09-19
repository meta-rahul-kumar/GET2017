package com.metacube.views;
import com.metacube.menu.Action;

/**
 * views all the guests
 * @author Rahul Kumar
 *
 */
public class ViewGuests implements Action {

	@Override
	public void performAction() {
		Output output = new Output();
		output.showGuests();
	}

}
