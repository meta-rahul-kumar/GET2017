package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.QueueProgram;

/**
 * class performs the size method of queue.
 * @author Rahul Kumar
 *
 */
public class Size implements Action {

	@Override
	public void performAction(QueueProgram queue) {
		System.out.println("Size of Queue : " + queue.size());
	}

}
