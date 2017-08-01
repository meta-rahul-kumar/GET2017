import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class Connections {
	final static String IMPORT_CONNECTION_FILE = "src/connection.csv";
	static HashMap<String,Connection> totalConnections = new HashMap<>();
	
	HashMap<String, Connection> getConnections(){
		// getter method
		return totalConnections;
	}
	
	public Connections() {
		
	}
	
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
	
	Connection getConnectionById(String connectionId) {
		Connection connection = new Connection();
		String requiredConnectionId = totalConnections.get(connectionId).getConnectionId();
		String requiredConnectionFirstName = totalConnections.get(connectionId).getConnectionFirstName();
		String requiredConnectionSecondName = totalConnections.get(connectionId).getConnectionSecondName();
		String requiredConnectionDate = totalConnections.get(connectionId).getConnectionDate();
		connection.setConnection(requiredConnectionId, requiredConnectionFirstName, requiredConnectionSecondName, requiredConnectionDate);
		return connection;
	}
	
	void showConnections() {
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
	
	void removeConnection() {
		System.out.println("Enter User ID");
		int removeConnectionWithId = 0;
		removeConnectionWithId = Util.sc.nextInt();
		String keyForRemove = "";
		for (String key : totalConnections.keySet()) {
			if(((Users.sessionId+"").equals(totalConnections.get(key).getConnectionFirstName() )
					&& (removeConnectionWithId+"").equals(totalConnections.get(key).getConnectionSecondName())) 
					|| ((removeConnectionWithId+"").equals(totalConnections.get(key).getConnectionFirstName() )
							&& (Users.sessionId+"").equals(totalConnections.get(key).getConnectionSecondName()))) {
				keyForRemove = key;
			}
		}
		totalConnections.remove(keyForRemove);
		System.out.println("Connection removed from " + Users.totalUsers.get(removeConnectionWithId+"").getUserName());
	}
	
	void addConnection() {
		int ConnectToId = 1;
		int max = 0;
		
		do{
				System.out.println("Enter User ID to Connect : ");
				ConnectToId = Util.sc.nextInt();
				
				ValidatorUtil validateUserId = new ValidatorUtil();
				Users users = new Users();
				if (!validateUserId.validateUser(users.getUsers(), ConnectToId)) {
					System.out.println("No Such User Exists with this ID.");
					continue;
				} else if (ConnectToId == Users.sessionId) {
					System.out.println("You are already your best friend :). try something new");
				} else if (alreadyConnected(Users.sessionId, ConnectToId)) {
					System.out.println("You are Already Connected");
				} else {
					break;	
				}
		}while(true);
		
		SimpleDateFormat sd = new SimpleDateFormat(
	            "dd-MM-yyyy HH:mm:ss z");
		Date date = new Date();
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
		
        
        for (String key : totalConnections.keySet()) {
			max = Integer.parseInt(key);
		}
		
		max = max + 1;

		Connection connection = new Connection();
		connection.setConnection(max+"", Users.sessionId+"", ConnectToId+"", sd.format(date)+"");
		totalConnections.put(max+"", connection);
		
		System.out.println("Connection Created!!");
		
	}

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
	
	public boolean isConnected(int connectToId) {
		boolean alreadyConnected = false;
		
		for(String key : totalConnections.keySet()) {
			if(((Users.sessionId+"").equals(totalConnections.get(key).getConnectionFirstName() )
					&& (connectToId+"").equals(totalConnections.get(key).getConnectionSecondName())) 
					|| ((connectToId+"").equals(totalConnections.get(key).getConnectionFirstName() )
							&& (Users.sessionId+"").equals(totalConnections.get(key).getConnectionSecondName()))) {
				
				alreadyConnected = true;
			}
		}
		return alreadyConnected;
	}
}
