package com.metacube.controllers;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import com.metacube.main.Home;
import com.metacube.main.ReadCsv;
import com.metacube.models.*;
import com.metacube.utility.Util;
import com.metacube.utility.ValidatorUtil;

/**
 * Class Holds all Connections and Provide the function to do operation on that.
 * @author Rahul Kumar
 *
 */
public class Connections {
	final static String IMPORT_CONNECTION_FILE = "src/connection.csv";
	static HashMap<String,Connection> totalConnections = new HashMap<>();
	
	/**
	 * method return All Connections
	 * @return
	 */
	public HashMap<String, Connection> getConnections(){
		// getter method
		return totalConnections;
	}
	
	/**
	 * Empty Connections Class Constructor
	 */
	public Connections() {
		
	}
	
	/**
	 * Method reads the connection from CSV File
	 */
	public void initConnections(){
		ReadCsv readCsv = new ReadCsv();
		for(String lineNumber : readCsv.ReadCsvFile(IMPORT_CONNECTION_FILE)) {
			StringTokenizer tokenizer = new StringTokenizer(lineNumber, "\t");
			while(tokenizer.hasMoreTokens()) {
				Connection connection = new Connection();
				connection.setConnection(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(),tokenizer.nextToken());
				totalConnections.put(connection.getConnectionId(), connection);
			}
		}
	}
	
	/**
	 * Method takes the connectionID and return the Connection 
	 * @param connectionId
	 * @return
	 */
	public Connection getConnectionById(String connectionId) {
		Connection connection = null;
		 if(totalConnections.containsKey(connectionId)) {
			 connection = totalConnections.get(connectionId);
		 }
		return connection;
	}
	
	/**
	 * Method shows all the connections
	 */
	public void showConnections() {
		boolean hasConnections = false;
		System.out.println("ID \t Connection Between \t Connection Date");
		Users user = new Users();
		for (String key : totalConnections.keySet()) {
			System.out.println(totalConnections.get(key).getConnectionId() + "\t" + user.getUserById(totalConnections.get(key).getConnectionFirstName()).getUserName() + " - " + user.getUserById(totalConnections.get(key).getConnectionSecondName()).getUserName() + "\t" + totalConnections.get(key).getConnectionDate());
			hasConnections = true;
		}
		
		if (hasConnections == false) {
			System.out.println("You don't have any connections");
		}
	}
	
	/**
	 * method removes connection of a specifie user
	 */
	public void removeConnection() {
		int removeConnectionWithId = 0;
		String keyForRemove = "";
		
		do{
			
			while(true) {
				try {
					System.out.println("Enter User ID");
					removeConnectionWithId = Util.sc.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Please Enter a Valid ID");
					Util.sc.nextLine();
				}
			}
			
			ValidatorUtil validateUserId = new ValidatorUtil();
			Users users = new Users();
			if (!validateUserId.validateUser(users.getUsers(), removeConnectionWithId)) {
				System.out.println("No Such User Exists with this ID. Try Again");
				continue;
			} else if (removeConnectionWithId == Home.sessionId) {
				System.out.println("We Know You are angry. But you are nothing without you. Try Again");
			} else if (!isConnected(removeConnectionWithId)) {
				System.out.println("You are Not Connected with user. Try Again");
			} else {
				break;
			}
			
		}while(true);
		
		for (String key : totalConnections.keySet()) {
			if(((Home.sessionId+"").equals(totalConnections.get(key).getConnectionFirstName() )
					&& (removeConnectionWithId+"").equals(totalConnections.get(key).getConnectionSecondName())) 
					|| ((removeConnectionWithId+"").equals(totalConnections.get(key).getConnectionFirstName() )
							&& (Home.sessionId+"").equals(totalConnections.get(key).getConnectionSecondName()))) {
				keyForRemove = key;
			}
		}
		
		if (!keyForRemove.equals("")) {
			totalConnections.remove(keyForRemove);
			System.out.println("Connection removed with " + Users.totalUsers.get(removeConnectionWithId+"").getUserName());
		}
	}
	
	/**
	 * method adds a connection for a user
	 */
	public void addConnection() {
		int ConnectToId = 1;
		int max = 0;
		
		do{
				
				while(true) {
					try {
						System.out.println("Enter User ID to Connect : ");
						ConnectToId = Util.sc.nextInt();
						break;
					} catch (Exception e) {
						System.out.println("Please Enter a Valid ID");
						Util.sc.nextLine();
					}
				}
 				
				ValidatorUtil validateUserId = new ValidatorUtil();
				Users users = new Users();
				if (!validateUserId.validateUser(users.getUsers(), ConnectToId)) {
					System.out.println("No Such User Exists with this ID.");
					continue;
				} else if (ConnectToId == Home.sessionId) {
					System.out.println("You are already your best friend :). try something new");
				} else if (alreadyConnected(Home.sessionId, ConnectToId)) {
					System.out.println("You are Already Connected");
				} else {
					break;	
				}
		}while(true);
		
		Date date = new Date();
		
        for (String key : totalConnections.keySet()) {
			max = Integer.parseInt(key);
		}
		
		max = max + 1;

		Connection connection = new Connection();
		connection.setConnection(max+"", Home.sessionId+"", ConnectToId+"", Util.formateDate().format(date)+"");
		totalConnections.put(max+"", connection);
		
		System.out.println("Connection Created!!");
		
	}

	/**
	 * method checks that a connection between two user already exits or not
	 * return true if already connected
	 * return false if not already connected
	 * 
	 * @param sessionId
	 * @param connectToId
	 * @return
	 */
	private boolean alreadyConnected(int sessionId, int connectToId) {
		boolean alreadyConnected = false;
		
		for(String key : totalConnections.keySet()) {
			if(((sessionId+"").equals(totalConnections.get(key).getConnectionFirstName() )
					&& (connectToId+"").equals(totalConnections.get(key).getConnectionSecondName())) 
					|| ((connectToId+"").equals(totalConnections.get(key).getConnectionFirstName() )
							&& (sessionId+"").equals(totalConnections.get(key).getConnectionSecondName()))) {
				
				alreadyConnected = true;
			}
		}
		return alreadyConnected;
	}
	
	/**
	 * method checks that a connection between two user already exits or not
	 * return true if already connected
	 * return false if not already connected
	 * 
	 * @param connectToId
	 * @return
	 */
	public boolean isConnected(int connectToId) {
		boolean alreadyConnected = false;
		
		for(String key : totalConnections.keySet()) {
			if(((Home.sessionId+"").equals(totalConnections.get(key).getConnectionFirstName() )
					&& (connectToId+"").equals(totalConnections.get(key).getConnectionSecondName())) 
					|| ((connectToId+"").equals(totalConnections.get(key).getConnectionFirstName() )
							&& (Home.sessionId+"").equals(totalConnections.get(key).getConnectionSecondName()))) {
				
				alreadyConnected = true;
			}
		}
		return alreadyConnected;
	}
}
