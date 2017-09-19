package com.metacube.controllers;
import java.util.HashMap;
import java.util.StringTokenizer;
import com.metacube.main.Home;
import com.metacube.main.ReadCsv;
import com.metacube.models.*;
import com.metacube.utility.Util;

/**
 * Class Holds all Users and provies methods to access them
 * @author User17
 *
 */
public class Users {
	final static String IMPORT_USER_FILE = "src/users.csv";
	static HashMap<String,User> totalUsers = new HashMap<>();
	
	/**
	 * method return All Users
	 * @return
	 */
	public HashMap<String, User> getUsers(){
		// getter method
		return totalUsers;
	}
	
	/**
	 * Empty Users Class Constructor
	 */
	public Users() {
		
	}
	
	/**
	 * Method reads the Users from CSV File
	 */
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
	
	/**
	 * Method returns a user details with specific id
	 * @param userId
	 * @return
	 */
	public User getUserById(String userId) {
		User user = null;
		 if(totalUsers.containsKey(userId)) {
			 user = totalUsers.get(userId);
		 }
		return user;
	}
	
	/**
	 * method returns a user details with specific name
	 * @param name
	 * @return
	 */
	public int getUserIdByName(String name) {
		int requiredid = 0;
		
		for (String key : totalUsers.keySet()) {
			if(name.equals(totalUsers.get(key).getUserName())) {
				requiredid = Integer.parseInt(key);
			}
		}
		
		return requiredid;
	}
	
	/**
	 * Method Authenticate a user with a specific name
	 * @param name
	 * @return
	 */
	public boolean authenticateUserByName(String name) {
		boolean exists = false;
		for (String key : totalUsers.keySet()) {
			if(name.equals(totalUsers.get(key).getUserName())) {
				exists = true;
			}
		}
		return exists;
	}
	
	/**
	 * Method shows all users
	 */
	public void showUsers() {
		System.out.println("ID \t Name \t Gender \t Phone");
		for (String key : totalUsers.keySet()) {
			System.out.println(totalUsers.get(key).getUserId() + "\t" + totalUsers.get(key).getUserName() + "\t" + totalUsers.get(key).getUserGender() + "\t" + totalUsers.get(key).getUserPhone());
		}
	}
	
	/**
	 * Method search users
	 * @param searchTag
	 */
	public void searchUser(String searchTag) {
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
	
	/**
	 * Method adds a user
	 */
	public boolean addUser() {
		String userName;
		String userGender;
		String userPhone;
		int max = 0;
		boolean exists = false;
		boolean status = false;
		
		while(true) {
				System.out.println("Enter User Name : ");
				if(Util.InputErrorcounter == 0) {
					Util.sc.nextLine();
				}
				userName = Util.sc.nextLine();
				
				if(userName.length() > 20) {
					System.out.println("Name length should be less than 20 chars.");
					userName = "";
					Util.InputErrorcounter++;
					continue;
				}else if(userName.length() == 0) {
					System.out.println("Name Field Can not be Empty");
					Util.InputErrorcounter++;
					continue;
				}
				
				Util.InputErrorcounter = 0;
				break;	
		}
		
		while(true) {
			System.out.println("Enter User Gender : [Male / Female]");
			userGender = Util.sc.nextLine();
			if(!userGender.equals("Male") && !userGender.equals("Female")) {
				System.out.println("Gender can only be Male or Female");
				userGender = "";
				continue;
			}
			break;
			
		}
		
		while(true) {
			System.out.println("Enter User Mobile Number : ");
			userPhone = Util.sc.nextLine();
			if(userPhone.length() != 10 || (userPhone.charAt(0) !='9' && userPhone.charAt(0) !='8' && userPhone.charAt(0) !='7') ) {
				System.out.println("Please Enter a Valid Mobile Number");
				userPhone = "";
				continue;
			}
			break;
			
		}
		

		for (String key : totalUsers.keySet()) {
			max = Integer.parseInt(key);
		}
		
		max = max + 1;
		
		for(String key : totalUsers.keySet()) {
			if(totalUsers.get(key).getUserName().equals(userName) && totalUsers.get(key).getUserPhone().equals(userPhone)) {
				exists = true;
			}
		}
		
		if(exists) {
			System.out.println("User with Same Name and Phone Number already Exixts");
		}else {
			User user = new User();
			user.setUser(max+"", userName, userGender, userPhone);
			totalUsers.put(max+"", user);
			
			Home.sessionId = max;
			System.out.println("User Profile Created!!");
			Util.setSessionId(userName);
			status = true;
		}
		
		return status;
	}
}
