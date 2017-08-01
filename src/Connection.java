
public class Connection {
	String connectionId;
	String connectionFirstName;
	String connectionSecondName;
	String connectionDate;
	public void setConnection(String requiredConnectionId, String requiredConnectionFirstName,
			String requiredConnectionSecondName, String requiredConnectionDate) {
		this.connectionDate = requiredConnectionDate;
		this.connectionFirstName = requiredConnectionFirstName;
		this.connectionSecondName = requiredConnectionSecondName;
		this.connectionId = requiredConnectionId;
		
	}
	
	String getConnectionId() {
		return connectionId;
	}
	
	String getConnectionFirstName() {
		return connectionFirstName;
	}
	
	String getConnectionSecondName() {
		return connectionSecondName;
	}
	
	String getConnectionDate() {
		return connectionDate;
	}
}
