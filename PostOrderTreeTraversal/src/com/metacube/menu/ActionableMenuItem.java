package com.metacube.menu;

import com.metacube.resource.PostOrderTreeTraversal;

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
	public void triggerAction(PostOrderTreeTraversal tree){
		 this.action.performAction(tree);
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
