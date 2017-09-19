package com.metacube.main;
import com.metacube.controllers.Connections;
import com.metacube.controllers.Users;

/**
 * Class display the friends of user 
 * @author Rahul Kumar
 *
 */
public class ViewFriends implements Action {

	/**
	 * Method display the friends of user 
	 */
	@Override
	public void performAction() {
		Connections connections = new Connections();
		
		System.out.println("Your Friends : ");
		
		System.out.println("ID \t Connection Between \t Connection Date");
		Users user = new Users();
		
		for (String key : connections.getConnections().keySet()) {
			if(((Home.sessionId+"").equals(connections.getConnections().get(key).getConnectionFirstName())) || ((Home.sessionId+"").equals(connections.getConnections().get(key).getConnectionSecondName())))
			System.out.println(connections.getConnections().get(key).getConnectionId() + "\t" + user.getUserById(connections.getConnections().get(key).getConnectionFirstName()).getUserName() + " - " + user.getUserById(connections.getConnections().get(key).getConnectionSecondName()).getUserName() + "\t" + connections.getConnections().get(key).getConnectionDate());
		
		}

	}
}
