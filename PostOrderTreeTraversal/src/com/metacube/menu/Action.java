package com.metacube.menu;

import com.metacube.resource.PostOrderTreeTraversal;

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
	void performAction(PostOrderTreeTraversal tree);
}