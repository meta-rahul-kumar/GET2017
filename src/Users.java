import java.util.HashMap;
import java.util.StringTokenizer;


public class Users {
	final static String IMPORT_USER_FILE = "src/users.csv";
	static int sessionId = 0;
	static HashMap<String,User> totalUsers = new HashMap<>();
	
	HashMap<String, User> getUsers(){
		// getter method
		return totalUsers;
	}
	
	public Users() {
		
	}
	
	public void initUsers() {
		ReadCsv readCsv = new ReadCsv();
		for(String lineNumber : readCsv.ReadCsvFile(IMPORT_USER_FILE)) {
			StringTokenizer tokenizer = new StringTokenizer(lineNumber, "\t");
			while(tokenizer.hasMoreTokens()) {
				User user = new User();
				user.setUser(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(),tokenizer.nextToken());
				totalUsers.put(user.getUserId(), user);
			}
		}
	}
	
	User getUserById(String userId) {
		User user = new User();
		String requiredUserId = totalUsers.get(userId).getUserId();
		String requiredUserName = totalUsers.get(userId).getUserName();
		String requiredUserGender = totalUsers.get(userId).getUserGender();
		String requiredUserPhone = totalUsers.get(userId).getUserPhone();
		user.setUser(requiredUserId, requiredUserName, requiredUserGender, requiredUserPhone);
		return user;
	}
	
	int getUserIdByName(String name) {
		int requiredid = 0;
		
		for (String key : totalUsers.keySet()) {
			if(name.equals(totalUsers.get(key).getUserName())) {
				requiredid = Integer.parseInt(key);
			}
		}
		
		return requiredid;
	}
	boolean authenticateUserByName(String name) {
		boolean exists = false;
		for (String key : totalUsers.keySet()) {
			if(name.equals(totalUsers.get(key).getUserName())) {
				exists = true;
			}
		}
		return exists;
	}
	
	void showUsers() {
		System.out.println("ID \t Name \t Gender \t Phone");
		for (String key : totalUsers.keySet()) {
			System.out.println(totalUsers.get(key).getUserId() + "\t" + totalUsers.get(key).getUserName() + "\t" + totalUsers.get(key).getUserGender() + "\t" + totalUsers.get(key).getUserPhone());
		}
	}
	
	void searchUser(String searchTag) {
		boolean totalResult = false;
		
		System.out.println("ID \t Name \t Gender \t Phone");
		
		for (String key : totalUsers.keySet()) {
			if(totalUsers.get(key).getUserName().contains(searchTag)) {
				System.out.println(totalUsers.get(key).getUserId() + "\t" + totalUsers.get(key).getUserName() + "\t" + totalUsers.get(key).getUserGender() + "\t" + totalUsers.get(key).getUserPhone());
				totalResult = true;
			}
		}
		
		if(totalResult == false) {
			System.out.println("No Result Found !!");
		}
	}
	
	void addUser() {
		String userName;
		String userGender;
		String userPhone;
		int max = 0;
		
		while(true) {
				System.out.println("Enter User Name : ");
				Util.sc.nextLine();
				userName = Util.sc.nextLine();
				if(userName.length() > 20) {
					System.out.println("Name length should be less than 20 chars.");
					userName = "";
					continue;
				}
				break;
				
		}
		
		while(true) {
			System.out.println("Enter User Gender : ");
			userGender = Util.sc.nextLine();
			if(!userGender.equals("Male") && !userGender.equals("Female")) {
				System.out.println("Gender can only be Male or Female");
				userGender = "";
				continue;
			}
			break;
			
		}
		
		while(true) {
			System.out.println("Enter User Number : ");
			userPhone = Util.sc.nextLine();
			if(userPhone.length() != 10 || (userPhone.charAt(0) !='9' && userPhone.charAt(0) !='8' && userPhone.charAt(0) !='7') ) {
				System.out.println("Please Enter a Valid Number");
				userPhone = "";
				continue;
			}
			break;
			
		}
		

		for (String key : totalUsers.keySet()) {
			max = Integer.parseInt(key);
		}
		
		max = max + 1;
		
		User user = new User();
		user.setUser(max+"", userName, userGender, userPhone);
		totalUsers.put(max+"", user);
		
		sessionId = max;
		System.out.println("User Profile Created!!");
		
		showUsers();
	}
}
