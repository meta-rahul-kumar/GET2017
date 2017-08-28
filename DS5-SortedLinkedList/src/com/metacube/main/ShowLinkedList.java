package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.SortedLinkedList;

/**
 * method shows the sorted linkedlist
 * @author Rahul Kumar
 *
 */
public class ShowLinkedList implements Action {

	@Override
	public void performAction(SortedLinkedList linkedlist) {
		linkedlist.traverse();
	}

}
