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
		Output output = new Output();
		input.addRanksToQueue();
		input.sortRanksInAscendingOrder();
		input.allocateCollegeToStudents();
		
		if (output.getTotalNoOfStudents() == 0) {
			System.out.println("Not Enough Data for counselling");
		} else {
			System.out.println("No College have empty seats !!");
		}
	}

}
