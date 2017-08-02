package com.metacube.models;
/**
 * Class Organisation saves the organisation details
 * @author User17
 *
 */
public class Organisation {
	String organisationId;
	String organisationCreator;
	String organisationName;
	String organisationCreatedDate;
	
	/**
	 * method - setOrganisation
	 * method sets the organisation details
	 * 
	 * @param id
	 * @param creator
	 * @param name
	 * @param date
	 */
	public void setOrganisation(String id, String creator,
			String name, String date) {
		this.organisationId = id;
		this.organisationCreator = creator;
		this.organisationName = name;
		this.organisationCreatedDate = date;
		
	}
	
	/**
	 * method returns the Organisation ID
	 * @return
	 */
	public String getOrganisationId() {
		return organisationId;
	}
	
	/**
	 * Method returns the Creator ID of Organisation
	 * @return
	 */
	public String getOrganisationCreator() {
		return organisationCreator;
	}
	
	/**
	 * Method returns the Organisation Name
	 * @return
	 */
	public String getOrganisationName() {
		return organisationName;
	}
	
	/**
	 * Method returns the Organisation Creation Date
	 * @return
	 */
	public String getOrganisationDate() {
		return organisationCreatedDate;
	}
}
