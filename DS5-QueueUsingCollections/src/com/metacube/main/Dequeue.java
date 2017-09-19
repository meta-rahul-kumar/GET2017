package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.QueueProgram;

/**
 * class performs the dequeue method of queue
 * @author Rahul Kumar
 *
 */
public class Dequeue implements Action {

	@Override
	public void performAction(QueueProgram queue) {
		System.out.println("Element Deleted : " + queue.remove());
	}

}
