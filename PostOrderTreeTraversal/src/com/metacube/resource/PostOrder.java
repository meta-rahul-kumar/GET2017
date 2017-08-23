package com.metacube.resource;
import com.metacube.menu.Action;


/**
 * Class performs the postOrder Traversal
 * @author Rahul Kumar
 *
 */
public class PostOrder implements Action {

	@Override
	public void performAction(PostOrderTreeTraversal tree) {
		tree.postOrder();
		System.out.println();
	}

}
