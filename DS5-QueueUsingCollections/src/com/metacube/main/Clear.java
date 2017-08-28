package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.QueueProgram;

/**
 * class clears the queue
 * @author Rahul Kumar
 *
 */
public class Clear implements Action {

	@Override
	public void performAction(QueueProgram queue) {
		queue.clear();
		System.out.println("Queue Cleared !!");
	}

}
