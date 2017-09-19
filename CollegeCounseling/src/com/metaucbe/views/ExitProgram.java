package com.metaucbe.views;
import java.util.concurrent.TimeUnit;
import com.metacube.menu.Action;

/**
 * Exits the Program
 * @author Rahul Kumar
 *
 */
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
	public void performAction() {
		System.out.print("Closing the Counseling Portal");
		waitTime();
		System.out.print("..");
		waitTime();
		System.out.print("..");
		waitTime();
		System.out.println("..");
		waitTime();
		System.out.println("Portal Closed");
		System.exit(0);	
	}

}
