package com.metacube.menu;

/**
 * class trigger an Action for specific event
 * 
 * @author Rahul Kumar
 *
 */
public class ActionableMenuItem extends MenuItem {

	Action action;

	/**
	 * method - triggerAction takes two double operand and perform an action returns
	 * double
	 */
	public void triggerAction(int[] inputArray) {
		this.action.performAction(inputArray);
	}

	/**
	 * Constructor - ActionableMenuItem
	 * 
	 * @param action
	 */
	public ActionableMenuItem(Action action) {

		this.action = action;
	}

}
