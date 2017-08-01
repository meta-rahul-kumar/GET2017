import java.util.HashMap;

public class ValidatorUtil {
	
	boolean validateUser(HashMap<String,User> userIterator, int userId) {
		return userIterator.containsKey(userId+"");
	}
	
	boolean validateConnection(HashMap<String,Connection> connectionIterator, int connectionId) {
		return connectionIterator.containsKey(connectionId+"");
	}
}
