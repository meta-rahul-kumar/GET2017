
public class Organisation {
	String organisationId;
	String organisationCreator;
	String organisationName;
	String organisationCreatedDate;
	public void setOrganisation(String id, String creator,
			String name, String date) {
		this.organisationId = id;
		this.organisationCreator = creator;
		this.organisationName = name;
		this.organisationCreatedDate = date;
		
	}
	
	String getOrganisationId() {
		return organisationId;
	}
	
	String getOrganisationCreator() {
		return organisationCreator;
	}
	
	String getOrganisationName() {
		return organisationName;
	}
	
	String getOrganisationDate() {
		return organisationCreatedDate;
	}
}
