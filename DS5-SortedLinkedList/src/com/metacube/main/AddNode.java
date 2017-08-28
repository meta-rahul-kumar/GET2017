package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.SortedLinkedList;
import com.metacube.util.Util;

/**
 * method adds a node to the sorted linkedlist
 * @author Rahul Kumar
 *
 */
public class AddNode implements Action {

	@Override
	public void performAction(SortedLinkedList linkedlist) {
		int newNodeValue = Util.getNewInput();
		linkedlist.addNode(newNodeValue);
		linkedlist.traverse();
	}

}
