package com.metacube.resource;
import com.metacube.menu.Action;

/**
 * Class performs the inOrder Traversal
 * @author Rahul Kumar
 *
 */
public class InOrder implements Action {

	@Override
	public void performAction(PostOrderTreeTraversal tree) {
		tree.inOrder();
		System.out.println();
	}

}
