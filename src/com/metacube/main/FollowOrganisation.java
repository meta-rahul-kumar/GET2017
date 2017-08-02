package com.metacube.main;
import com.metacube.controllers.OrganisationFollowers;

/**
 * Class adds an follower to Organisation
 * @author Rahul Kumar
 *
 */
public class FollowOrganisation implements Action {

	/**
	 * method - performAction 
	 * method adds an follower to Organisation
	 */
	@Override
	public void performAction() {
		OrganisationFollowers organisationFollowers = new OrganisationFollowers();
		organisationFollowers.addFollower();
	}

}
