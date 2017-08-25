package com.metaucbe.views;
import com.metacube.menu.Action;

/**
 * views all the students
 * @author Rahul Kumar
 *
 */
public class ViewStudents implements Action {

	/**
	 * performAction method of Action Interface
	 */
	@Override
	public void performAction() {
		Output output = new Output();
		output.showStudents();

	}

}
