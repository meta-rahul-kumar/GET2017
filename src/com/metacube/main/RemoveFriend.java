package com.metacube.main;
import com.metacube.controllers.Connections;

/**
 * Class removes an Connection
 * @author User17
 *
 */
public class RemoveFriend implements Action {

	/**
	 * method removes an connection of user
	 */
	@Override
	public void performAction() {
		Connections connections = new Connections();
		connections.removeConnection();

	}

}
