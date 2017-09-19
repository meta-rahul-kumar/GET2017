package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.QueueProgram;

/**
 * class perfroms the poll method of Queue.
 * @author Rahul Kumar
 *
 */
public class Poll implements Action {

	@Override
	public void performAction(QueueProgram queue) {
		System.out.println("Polled Element : " + queue.poll());
	}

}
