
public class RemoveFriend implements Action {

	@Override
	public void performAction() {
		Connections connections = new Connections();
		connections.removeConnection();

	}

}
