
public class CreateOrganisation implements Action {

	@Override
	public void performAction() {
		Organisations organisations = new Organisations();
		organisations.createOrganisation();
	}

}
