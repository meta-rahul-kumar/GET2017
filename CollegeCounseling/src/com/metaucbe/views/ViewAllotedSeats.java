package com.metaucbe.views;
import com.metacube.menu.Action;

/**
 * shows the allocated College Seats
 * @author Rahul Kumar
 *
 */
public class ViewAllotedSeats implements Action {
	
	/**
	 * performAction method of Action Interface
	 */
	@Override
	public void performAction() {
		Output output = new Output();
		output.showAllocatedSeats();
	}

}
