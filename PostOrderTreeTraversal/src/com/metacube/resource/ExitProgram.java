package com.metacube.resource;

/**
 * ExitProgream Class to exit the Calculator
 * 
 * @author Rahul Kumar
 *
 */
import java.util.concurrent.TimeUnit;

import com.metacube.menu.Action;

public class ExitProgram implements Action {

	/**
	 * method - waitTime
	 * method delay for 1 second
	 */
	public void waitTime() {
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch(Exception e) {
			System.out.println("Error in closing");
		}
	}
	
	/**
	 * method - performAction
	 * performAction Method of Action Class
	 */
	@Override
	public void performAction(PostOrderTreeTraversal tree) {
		System.out.print("Closing the Program");
		waitTime();
		System.out.print("..");
		waitTime();
		System.out.print("..");
		waitTime();
		System.out.println("..");
		waitTime();
		System.out.println("Program Closed");
		System.exit(0);	
	}

}
