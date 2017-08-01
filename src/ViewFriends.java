
public class ViewFriends implements Action {

	@Override
	public void performAction() {
		Connections connections = new Connections();
		
		System.out.println("Your Friends : ");
		
		System.out.println("ID \t Connection Between \t Connection Date");
		Users user = new Users();
		
		for (String key : connections.getConnections().keySet()) {
			if(((Users.sessionId+"").equals(connections.getConnections().get(key).getConnectionFirstName())) || ((Users.sessionId+"").equals(connections.getConnections().get(key).getConnectionSecondName())))
			System.out.println(connections.getConnections().get(key).getConnectionId() + "\t" + user.getUserById(connections.getConnections().get(key).getConnectionFirstName()).getUserName() + " - " + user.getUserById(connections.getConnections().get(key).getConnectionSecondName()).getUserName() + "\t" + connections.getConnections().get(key).getConnectionDate());
		
		}

	}
}
