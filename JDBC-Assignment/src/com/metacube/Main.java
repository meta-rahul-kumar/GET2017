package com.metacube;

import java.sql.SQLException;
import com.metacube.view.View;

/**
 * Main Class
 * 
 * @author Rahul Kumar
 *
 */
public class Main {
	public static void main(String[] args) throws SQLException {
		View view = new View();
		view.displayMenu();
	}
}
