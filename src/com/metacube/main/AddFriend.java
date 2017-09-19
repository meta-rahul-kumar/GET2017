package com.metacube.main;
import com.metacube.controllers.Connections;
import com.metacube.controllers.Users;

/**
 * Class AddFriend create a Connection
 * 
 * @author Rahul Kumar
 *
 */
public class AddFriend implements Action {

	/**
	 * method - performAction 
	 * method creates a connection
	 */
	@Override
	public void performAction() {
		Connections connect = new Connections();
		Users users = new Users();
		System.out.println("Users in MetaBook");
		users.showUsers();
		connect.addConnection();

	}

}
