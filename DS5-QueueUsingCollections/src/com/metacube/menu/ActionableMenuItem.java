package com.metacube.menu;

import com.metacube.resources.QueueProgram;

/**
 * class trigger an Action for specific event
 * @author Rahul Kumar
 *
 */
public class ActionableMenuItem extends MenuItem{
	
	Action action;

	/**
	 * method - triggerAction
	 * takes two double operand and perform an action
	 * returns double 
	 */
	public void triggerAction(QueueProgram queue){
		 this.action.performAction(queue);
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
