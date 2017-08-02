package com.metacube.models;

/**
 * Class provide setter and getter methods for Connections
 * @author Rahul Kumar
 *
 */
public class Connection {
	String connectionId;
	String connectionFirstName;
	String connectionSecondName;
	String connectionDate;
	
	/**
	 * Method sets a Connection
	 * @param requiredConnectionId
	 * @param requiredConnectionFirstName
	 * @param requiredConnectionSecondName
	 * @param requiredConnectionDate
	 */
	public void setConnection(String requiredConnectionId, String requiredConnectionFirstName,
			String requiredConnectionSecondName, String requiredConnectionDate) {
		this.connectionDate = requiredConnectionDate;
		this.connectionFirstName = requiredConnectionFirstName;
		this.connectionSecondName = requiredConnectionSecondName;
		this.connectionId = requiredConnectionId;
		
	}
	
	/**
	 * method returns the Connection ID
	 * @return
	 */
	public String getConnectionId() {
		return connectionId;
	}
	
	/**
	 * method returns the Connected First User
	 * @return
	 */
	public String getConnectionFirstName() {
		return connectionFirstName;
	}
	
	/**
	 * method returns the Connected Second User
	 * @return
	 */
	public String getConnectionSecondName() {
		return connectionSecondName;
	}
	
	/**
	 * method returns the Connection Establishment Date
	 * @return
	 */
	public String getConnectionDate() {
		return connectionDate;
	}
}
