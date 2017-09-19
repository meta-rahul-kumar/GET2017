package com.metacube.main;
/**
 * Class Performs the Logout Functionality
 */
import java.util.concurrent.TimeUnit;

public class Logout implements Action {

	/**
	 * method - waitTime
	 * method delay for 1 second
	 */
	public void waitTime() {
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch(Exception e) {
			System.out.println("Error in Logging you out");
		}
	}
	
	/**
	 * method - performAction
	 * performAction Method of Action Class
	 */
	@Override
	public void performAction() {
		System.out.print("Logging you out.");
		waitTime();
		System.out.print("..");
		waitTime();
		System.out.print("..");
		waitTime();
		System.out.println("..");
		waitTime();
		System.out.println("Logout Successfully.");
		
		while (true) {
			Home.homePageWork();
		}
	}
}
