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
		Input input = new Input();
		input.addGuest();

	}

}
