package com.metacube.main;
/**
 * ActionableMenuItem class extedns MenuItem Class
 * 
 * @author Rahul Kumar
 *
 */
public class ActionableMenuItem extends MenuItem{
	
	Action action;

	/**
	 * method - triggerAction
	 */
	public void triggerAction(){
		this.action.performAction();
	}

	/**
	 * method ActionableMenuItem
	 * @param action
	 */
	public ActionableMenuItem(Action action) {
		
		this.action = action;
	}


}
