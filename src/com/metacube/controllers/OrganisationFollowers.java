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
 * Class Stores all Organisation follower and provide method to access them
 * @author Rahul Kumar
 *
 */
public class OrganisationFollowers {
	final static String IMPORT_FOLLOWERS_FILE = "src/follower.csv";
	static HashMap<String,OrganisationFollower> totalFollowers = new HashMap<>();
	
	/**
	 * method return All Organisation Followers
	 * @return
	 */
	public HashMap<String, OrganisationFollower> getFollowers(){
		// getter method
		return totalFollowers;
	}
	
	/**
	 * Empty OrganisationFollowers Class Constructor
	 */
	public OrganisationFollowers() {
		
	}
	
	/**
	 * Method reads the Follwers from CSV File
	 */
	public void initFollowers(){
		ReadCsv readCsv = new ReadCsv();
		for(String lineNumber : readCsv.ReadCsvFile(IMPORT_FOLLOWERS_FILE)) {
			StringTokenizer tokenizer = new StringTokenizer(lineNumber, "\t");
			while(tokenizer.hasMoreTokens()) {
				OrganisationFollower organisationFollower = new OrganisationFollower();
				organisationFollower.setFollower(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(),tokenizer.nextToken());
				totalFollowers.put(organisationFollower.getFollowId(), organisationFollower);
			}
		}
	}
	
	/**
	 * Method shows all the Followers
	 */
	public void showFollowers() {
		boolean hasFollowers = false;
		Users user = new Users();
		Organisations organisations = new Organisations();
		
		System.out.println("ID \t Follower \t Organisation \t Follow Date");
		
		for (String key : totalFollowers.keySet()) {
			System.out.println(totalFollowers.get(key).getFollowId() + "\t" + user.getUserById(totalFollowers.get(key).getFollowerUserId()).getUserName() + " \t " + organisations.getOrganisationById(totalFollowers.get(key).getFollowOrganisationId()).getOrganisationName() + "\t" + totalFollowers.get(key).getFollowDate());
			hasFollowers = true;
		}
		
		if (hasFollowers == false) {
			System.out.println("There are no Followers");
		}
	}
	
	/**
	 * Method shows follower for specific user
	 */
	public void showFollowedOrganisationById(String userId) {
		boolean followedOrganisations = false ;
		Organisations organisations = new Organisations();
		
		if(userId.equals(Home.sessionId+"")) {
			System.out.println("Your Followed Organisation(s) : ");
		}else {
			System.out.println("Followed Organisation(s) : ");
		}
		
		System.out.println("ID \t Organisation \t Follow Date");
		
		for (String key : totalFollowers.keySet()) {
			if (userId.equals(totalFollowers.get(key).getFollowerUserId())) {
				System.out.println(totalFollowers.get(key).getFollowId() + " \t " + organisations.getOrganisations().get(totalFollowers.get(key).getFollowOrganisationId()).getOrganisationName() + "\t" + totalFollowers.get(key).getFollowDate());
				followedOrganisations = true;
			}
		}
		
		if (followedOrganisations == false && userId.equals(Home.sessionId+"")) {
			System.out.println("You are not following anything");
		}else if (followedOrganisations == false && !userId.equals(Home.sessionId+"")) {
			System.out.println("User is Not Following anything");
		}
	}
	
	/**
	 * Method unfollows a Organisation for specific user
	 */
	public void unfollowOrganisation() {
		int unfollowOrganisationWithId = 0;
		String keyForRemove = "";
		ValidatorUtil validateOrganisationId = new ValidatorUtil();
		Organisations organisations = new Organisations();
		
		do{
			
			while(true) {
				try {
						System.out.println("Enter Organisation ID");
						unfollowOrganisationWithId = Util.sc.nextInt();
						break;
					} catch (Exception e) {
						System.out.println("Please Enter a Valid ID");
						Util.sc.nextLine();
					}
			}
			
			if (!validateOrganisationId.validateOrganisation(organisations.getOrganisations(), unfollowOrganisationWithId)) {
				System.out.println("No Such Organisation Exists with this ID. Try Again");
			} else if (!alreadyFollowed(Home.sessionId, unfollowOrganisationWithId)) {
				System.out.println("You are not following this organisation. Try Again");
			} else {
				break;
			}
			
		}while(true);
		
		for (String key : totalFollowers.keySet()) {
			if(((Home.sessionId+"").equals(totalFollowers.get(key).getFollowerUserId() )
					&& (unfollowOrganisationWithId+"").equals(totalFollowers.get(key).getFollowOrganisationId())) 
					|| ((unfollowOrganisationWithId+"").equals(totalFollowers.get(key).getFollowOrganisationId() )
							&& (Home.sessionId+"").equals(totalFollowers.get(key).getFollowerUserId()))) {
				keyForRemove = key;
			}
		}
		
		if (!keyForRemove.equals("")) {
			totalFollowers.remove(keyForRemove);
			System.out.println("Unfollowed the organisation \"" + organisations.getOrganisations().get(unfollowOrganisationWithId+"").getOrganisationName()+"\"");
		}
	}
	
	/**
	 * Method add Follower for user
	 */
	public void addFollower() {
		int followToOrganisationId = 0;
		int max = 0;
		Organisations organisations = new Organisations();
		
		do{
				
				while(true) {
					try {
							System.out.println("Enter Organisation ID to Follow : ");
							followToOrganisationId = Util.sc.nextInt();
							break;
						} catch (Exception e) {
							System.out.println("Please Enter a Valid ID");
							Util.sc.nextLine();
						}
				}
				
				ValidatorUtil validateOrganisationId = new ValidatorUtil();
				if (!validateOrganisationId.validateOrganisation(organisations.getOrganisations(), followToOrganisationId)) {
					System.out.println("No Such Organisation Exists with this ID.");
					continue;
				} else if (alreadyFollowed(Home.sessionId, followToOrganisationId)) {
					System.out.println("You are Already following this organisation \""+ organisations.getOrganisations().get(followToOrganisationId+"").getOrganisationName()+"\"");
				} else {
					break;	
				}
		}while(true);
		
		Date date = new Date();
        
        for (String key : totalFollowers.keySet()) {
			max = Integer.parseInt(key);
		}
		
		max = max + 1;

		OrganisationFollower organisationFollower = new OrganisationFollower();
		organisationFollower.setFollower(max+"", Home.sessionId+"", followToOrganisationId+"", Util.formateDate().format(date)+"");
		totalFollowers.put(max+"", organisationFollower);
		
		System.out.println("SuccessFully Followed The Organisation \""+ organisations.getOrganisations().get(followToOrganisationId+"").getOrganisationName() +"\" !!");
		
	}
	
	/**
	 * method checks that user had already followed the organisation or not
	 * return true if already followed
	 * return false if not already followed
	 * @param sessionId
	 * @param followToOrganisationId
	 * @return
	 */
	public boolean alreadyFollowed(int sessionId, int followToOrganisationId) {
		boolean alreadyFollowed = false;
		
		for(String key : totalFollowers.keySet()) {
			if(((sessionId+"").equals(totalFollowers.get(key).getFollowerUserId() )
					&& (followToOrganisationId+"").equals(totalFollowers.get(key).getFollowOrganisationId())) 
					|| ((followToOrganisationId+"").equals(totalFollowers.get(key).getFollowOrganisationId() )
							&& (sessionId+"").equals(totalFollowers.get(key).getFollowerUserId()))) {
				
				alreadyFollowed = true;
			}
		}
		return alreadyFollowed;
	}
	
	
}
