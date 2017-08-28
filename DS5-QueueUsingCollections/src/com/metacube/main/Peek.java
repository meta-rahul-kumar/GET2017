package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.QueueProgram;

/**
 * class performs the Peek method of Queue.
 * @author Rahul Kumar
 *
 */
public class Peek implements Action {

	@Override
	public void performAction(QueueProgram queue) {
		System.out.println("Peek Element : " + queue.peek());

	}

}
