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
 * Class Stores all Organisation and provide method to access them
 * @author Rahul Kumar
 *
 */
public class Organisations {

	final static String IMPORT_ORGANISATIONS_FILE = "src/organisation.csv";
	static HashMap<String,Organisation> totalOrganisations = new HashMap<>();
	
	/**
	 * method return All Organisation
	 * @return
	 */
	public HashMap<String, Organisation> getOrganisations(){
		return totalOrganisations;
	}
	
	/**
	 * Empty Organisation Class Constructor
	 */
	public Organisations() {
		
	}
	
	/**
	 * Method reads the Organisation from CSV File
	 */
	public void initOrganisations(){
		ReadCsv readCsv = new ReadCsv();
		for(String lineNumber : readCsv.ReadCsvFile(IMPORT_ORGANISATIONS_FILE)) {
			StringTokenizer tokenizer = new StringTokenizer(lineNumber, "\t");
			while(tokenizer.hasMoreTokens()) {
				Organisation organisation = new Organisation();
				organisation.setOrganisation(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(),tokenizer.nextToken());
				totalOrganisations.put(organisation.getOrganisationId(), organisation);
			}
		}
	}
	
	/**
	 * Method takes the organisation ID returns an Organisation Object 
	 * @param organisationId
	 * @return
	 */
	public Organisation getOrganisationById(String organisationId) {
		Organisation organisation = null;
		 if(totalOrganisations.containsKey(organisationId)) {
			 organisation = totalOrganisations.get(organisationId);
		 }
		return organisation;
	}
	
	/**
	 * Method shows all the Organisations
	 */
	public void showOrganisations() {
		boolean hasOrganisation = false;
		System.out.println("ID \t Creator \t Name \t Creation Date");
		Users user = new Users();
		
		for (String key : totalOrganisations.keySet()) {
			System.out.println(totalOrganisations.get(key).getOrganisationId() + "\t" + user.getUserById(totalOrganisations.get(key).getOrganisationCreator()).getUserName() + " \t " + totalOrganisations.get(key).getOrganisationName() + "\t" + totalOrganisations.get(key).getOrganisationDate());
			hasOrganisation = true;
		}
		
		if (hasOrganisation == false) {
			System.out.println("You don't have any Organisation");
		}
	}
	
	/**
	 * * method checks that an organisation exists or not
	 * return true if already exists
	 * return false if not already exists
	 * @param organisationId
	 * @return
	 */
	public boolean isOrganisationExists(int organisationId) {
		boolean exits = false;
		
		for(String key : totalOrganisations.keySet()) {
			if(((Home.sessionId+"").equals(totalOrganisations.get(key).getOrganisationCreator() )
					&& (organisationId+"").equals(totalOrganisations.get(key).getOrganisationId())) 
					|| ((organisationId+"").equals(totalOrganisations.get(key).getOrganisationId() )
							&& (Home.sessionId+"").equals(totalOrganisations.get(key).getOrganisationCreator()))) {
				
				exits = true;
			}
		}
		return exits;
	}
	/**
	 * Method deletes an organisation
	 */
	public void deleteOrganisation() {
		int removeOrganisationWithId = 0;
		String keyForRemove = "";
		String removedOrganisation = "";
		ValidatorUtil validateOrganisationId = new ValidatorUtil();
		
		do {
			while(true) {
				try {
					System.out.println("Enter Organisation ID");
					removeOrganisationWithId = Util.sc.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Please Enter a Valid ID");
					Util.sc.nextLine();
				}
			}
			
			
			if (!validateOrganisationId.validateOrganisation(totalOrganisations, removeOrganisationWithId)) {
				System.out.println("No Such Organisation Exists with this ID.");
				continue;
			} else if (!totalOrganisations.get(removeOrganisationWithId+"").getOrganisationCreator().equals(Home.sessionId+"")) {
				System.out.println("This is not your Organisation. You can't delete this Organisation");
			} else {
				break;	
			}
			
		}while(true);
		
		
		
		for (String key : totalOrganisations.keySet()) {
			if(((Home.sessionId+"").equals(totalOrganisations.get(key).getOrganisationCreator() )
					&& (removeOrganisationWithId+"").equals(totalOrganisations.get(key).getOrganisationId())) 
					|| ((removeOrganisationWithId+"").equals(totalOrganisations.get(key).getOrganisationId() )
							&& (Home.sessionId+"").equals(totalOrganisations.get(key).getOrganisationCreator()))) {
				
				keyForRemove = key;
				removedOrganisation = totalOrganisations.get(key).getOrganisationName();
		
			}
		}
		
		totalOrganisations.remove(keyForRemove);
		System.out.println("Organisation " + removedOrganisation + " Deleted ");
		showOrganisations();
	}
	
	/**
	 * method creates an organisation
	 */
	public void createOrganisation() {
		String organisationName;
		int max = 0;
		
		System.out.println("Enter Organisation Name");
		Util.sc.nextLine();
		organisationName = Util.sc.nextLine();
		
		Date date = new Date();
        
        for (String key : totalOrganisations.keySet()) {
			max = Integer.parseInt(key);
		}
		
		max = max + 1;

		Organisation organisation = new Organisation();
		organisation.setOrganisation(max+"", Home.sessionId+"", organisationName, Util.formateDate().format(date)+"");
		totalOrganisations.put(max+"", organisation);
		
		System.out.println("Organisation Created with name " + organisationName + "!!");
		showOrganisations();

	}
}
