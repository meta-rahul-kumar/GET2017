package com.metacube.main;
import com.metacube.controllers.Organisations;

/**
 * Class creates an Organisation
 * @author Rahul Kumar
 *
 */
public class CreateOrganisation implements Action {

	/**
	 * method - performAction 
	 * method creates an Organisation
	 */
	@Override
	public void performAction() {
		Organisations organisations = new Organisations();
		organisations.createOrganisation();
	}

}
