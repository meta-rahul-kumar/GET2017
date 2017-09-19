package com.metacube.menu;

import com.metacube.resource.PreOrderTreeTraversal;

/**
 * Action Interface
 * @author Rahul Kumar
 *
 */
public interface Action {
	
	/**
	 * method performAction
	 * @param list TODO
	 */
	void performAction(PreOrderTreeTraversal tree);
}
