package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.QueueProgram;
import com.metacube.util.Util;

/**
 * class performs the enqueue method of queue.
 * @author Rahul Kumar
 *
 */
public class Enqueue implements Action {

	@Override
	public void performAction(QueueProgram queue) {
		int newElement = Util.getNewInput();
		queue.add(newElement);
	}

}
