package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.QueueProgram;

/**
 * class performs the isEmpty method of queue.
 * @author Rahul Kumar
 *
 */
public class IsEmpty implements Action {

	@Override
	public void performAction(QueueProgram queue) {
		if (queue.isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			System.out.println("Queue is not empty");
		}
	}

}
