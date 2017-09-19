package com.metacube.main;
import com.metacube.controllers.Organisations;

/**
 * Class deletes an Organisation
 * @author Rahul Kumar
 *
 */
public class DeleteOrganisation implements Action {

	/**
	 * method - performAction 
	 * method deletes an Organisation
	 */
	@Override
	public void performAction() {
		Organisations organisations = new Organisations();
		organisations.deleteOrganisation();
	}

}
