package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.QueueProgram;

/**
 * class shows the queue.
 * @author Rahul Kumar
 *
 */
public class Show implements Action {

	@Override
	public void performAction(QueueProgram queue) {
		queue.show();
	}

}
