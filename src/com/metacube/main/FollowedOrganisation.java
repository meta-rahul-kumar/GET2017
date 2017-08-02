package com.metacube.main;
import com.metacube.controllers.OrganisationFollowers;

/**
 * Class Shows the followed Organisations by User
 * @author User17
 *
 */
public class FollowedOrganisation implements Action {

	/**
	 * method - performAction 
	 * method shows the Followed Organisation by User
	 */
	@Override
	public void performAction() {
		OrganisationFollowers organisationFollowers = new OrganisationFollowers();
		organisationFollowers.showFollowedOrganisationById(Home.sessionId+"");

	}

}
