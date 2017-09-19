package com.metaucbe.views;
import com.metacube.menu.Action;

/**
 * views all the colleges
 * @author Rahul Kumar
 *
 */
public class ViewColleges implements Action {

	/**
	 * performAction method of Action Interface
	 */
	@Override
	public void performAction() {
		Output output = new Output();
		output.showColleges();
	}

}
