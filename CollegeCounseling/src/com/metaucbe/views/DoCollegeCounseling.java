package com.metaucbe.views;
import com.metacube.menu.Action;

/**
 * Do the counseling operations
 * @author Rahul Kumar
 *
 */
public class DoCollegeCounseling implements Action {

	/**
	 * performAction method of Action Interface
	 */
	@Override
	public void performAction() {
		Input input = new Input();
		input.addRanksToQueue();
		input.sortRanksInAscendingOrder();
		input.allocateCollegeToStudents();
		System.out.println("All College Seats Are Filled !!");
	}

}
