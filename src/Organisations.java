import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class Organisations {

	final static String IMPORT_ORGANISATIONS_FILE = "src/organisation.csv";
	static HashMap<String,Organisation> totalOrganisations = new HashMap<>();
	
	HashMap<String, Organisation> getOrganisations(){
		return totalOrganisations;
	}
	
	public Organisations() {
		
	}
	
	
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
	
	void showOrganisations() {
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
	
	void deleteOrganisation() {
		System.out.println("Enter Organisation ID");
		int removeOrganisationWithId = 0;
		removeOrganisationWithId = Util.sc.nextInt();
		String keyForRemove = "";
		String removedOrganisation = "";
		
		for (String key : totalOrganisations.keySet()) {
			if(((Users.sessionId+"").equals(totalOrganisations.get(key).getOrganisationCreator() )
					&& (removeOrganisationWithId+"").equals(totalOrganisations.get(key).getOrganisationId())) 
					|| ((removeOrganisationWithId+"").equals(totalOrganisations.get(key).getOrganisationId() )
							&& (Users.sessionId+"").equals(totalOrganisations.get(key).getOrganisationCreator()))) {
				keyForRemove = key;
				removedOrganisation = totalOrganisations.get(key).organisationName;
			}
		}
		totalOrganisations.remove(keyForRemove);
		System.out.println("Organisation " + removedOrganisation + " Deleted ");
		showOrganisations();
	}
	
	void createOrganisation() {
		String organisationName;
		int max = 0;
		
		System.out.println("Enter Organisation Name");
		Util.sc.nextLine();
		organisationName = Util.sc.nextLine();
		
		
		
		SimpleDateFormat sd = new SimpleDateFormat(
	            "dd-MM-yyyy HH:mm:ss z");
		Date date = new Date();
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
		
        
        for (String key : totalOrganisations.keySet()) {
			max = Integer.parseInt(key);
		}
		
		max = max + 1;

		Organisation organisation = new Organisation();
		organisation.setOrganisation(max+"", Users.sessionId+"", organisationName, sd.format(date)+"");
		totalOrganisations.put(max+"", organisation);
		
		System.out.println("Organisation Created with name " + organisationName + "!!");
		showOrganisations();

	}
}
