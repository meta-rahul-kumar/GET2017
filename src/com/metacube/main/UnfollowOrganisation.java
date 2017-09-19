package com.metacube.main;
import com.metacube.controllers.OrganisationFollowers;

/**
 * Class Unfollow an Organisation of User
 * @author Rahul Kumar
 *
 */
public class UnfollowOrganisation implements Action {

	/**
	 * method Unfollow an Organisation of User
	 */
	@Override
	public void performAction() {
		OrganisationFollowers organisationFollowers = new OrganisationFollowers();
		organisationFollowers.unfollowOrganisation();
	}

}
