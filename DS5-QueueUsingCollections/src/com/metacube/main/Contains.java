package com.metacube.main;
import com.metacube.menu.Action;
import com.metacube.resources.QueueProgram;
import com.metacube.util.Util;

/**
 * Class performs the contains method of linkedlist
 * @author Rahul Kumar
 *
 */
public class Contains implements Action {

	@Override
	public void performAction(QueueProgram queue) {
		int checkForElement = Util.getNewInput();

		if (queue.contains(checkForElement)) {
			System.out.println("Element exists in queue !!");
		} else {
			System.out.println("Element doesn't exists in queue !!");
		}

	}

}
