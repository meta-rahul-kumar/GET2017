package com.metacube.utility;
/**
 * Class is a Utility Class used for Validating
 * @author Rahul Kumar
 */
import java.util.HashMap;
import com.metacube.models.*;

public class ValidatorUtil {
	
	/**
	 * Method validate a User by UserID
	 * @param userIterator
	 * @param userId
	 * @return
	 */
	public boolean validateUser(HashMap<String,User> userIterator, int userId) {
		return userIterator.containsKey(userId+"");
	}
	
	/**
	 * Method validate a Connection by ConnectionID
	 * @param connectionIterator
	 * @param connectionId
	 * @return
	 */
	public boolean validateConnection(HashMap<String,Connection> connectionIterator, int connectionId) {
		return connectionIterator.containsKey(connectionId+"");
	}
	
	/**
	 * Method validate a Organisation by OrganisationID
	 * @param organisationIterator
	 * @param organisationId
	 * @return
	 */
	public boolean validateOrganisation(HashMap<String,Organisation> organisationIterator, int organisationId) {
		return organisationIterator.containsKey(organisationId+"");
	}
}
