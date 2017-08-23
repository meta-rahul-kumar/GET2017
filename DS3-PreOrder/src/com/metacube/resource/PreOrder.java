package com.metacube.resource;
import com.metacube.menu.Action;

/**
 * Class performs the preOrder Traversal
 * @author Rahul Kumar
 *
 */
public class PreOrder implements Action {

	@Override
	public void performAction(PreOrderTreeTraversal tree) {
		tree.preOrder();
		System.out.println();
	}

}
