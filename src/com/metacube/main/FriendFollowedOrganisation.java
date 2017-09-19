package com.metacube.main;
import com.metacube.controllers.Connections;
import com.metacube.controllers.OrganisationFollowers;
import com.metacube.controllers.Users;
import com.metacube.utility.Util;
import com.metacube.utility.ValidatorUtil;

/**
 * Class shows the followed Organisations by User's Friend
 * @author User17
 *
 */
public class FriendFollowedOrganisation implements Action {

	/**
	 * method - performAction 
	 * method shows the followed Organisations by User's Friend
	 */
	@Override
	public void performAction() {
		int id = 0;
		OrganisationFollowers organisationFollowers = new OrganisationFollowers();
		
		do{
			
			while(true) {
				try {
						System.out.println("Enter Friend ID : ");
						id = Util.sc.nextInt();
						break;
					} catch (Exception e) {
						System.out.println("Please Enter a Valid ID");
						Util.sc.nextLine();
					}
			}
			
			ValidatorUtil validateUserId = new ValidatorUtil();
			Users users = new Users();
			Connections connections = new Connections();
			
			if (!validateUserId.validateUser(users.getUsers(), id)) {
				System.out.println("No Such User Exists with this ID.");
				continue;
			} else if (id == Home.sessionId) {
				System.out.println("We Know you are your best Friend.. but you have a lot of friend. Try another");
			} else if (!connections.isConnected(id)) {
				System.out.println("You are not connected with this user. ");
			} else {
				break;	
			}
		}while(true);
		
		organisationFollowers.showFollowedOrganisationById(id+"");
	}

}
