package com.metacube.utility;
import java.text.SimpleDateFormat;
/**
 * Util is an Utility Class
 * @author Rahul Kumar
 */
import java.util.Scanner;
import java.util.TimeZone;

import com.metacube.controllers.Users;
import com.metacube.main.Action;
import com.metacube.main.Home;

public class Util implements Action{
	public static final Scanner sc = new Scanner(System.in);
	public static int InputErrorcounter = 0;
	
	/**
	 * method set the logged in user session ID.
	 * @param name
	 */
	public static void setSessionId(String name) {
		Users users = new Users();
		Home.sessionId = users.getUserIdByName(name);
	}
	
	/**
	 * method checks the Scanner for Buffer
	 */
	public static void checkScanner() {
		if(!Util.sc.hasNext()) {
			Util.sc.nextLine();
		}
	}
	
	/**
	 * method of Action Interface
	 */
	@Override
	public void performAction() {
		
		
	}

	/**
	 * Static function sets the Time Zone to IST
	 * @return
	 */
	public static SimpleDateFormat formateDate() {
		SimpleDateFormat sd = new SimpleDateFormat(
	            "dd-MM-yyyy HH:mm:ss z");
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        
		return sd;
	}
	
	
}
