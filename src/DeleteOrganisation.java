
public class DeleteOrganisation implements Action {

	@Override
	public void performAction() {
		Organisations organisations = new Organisations();
		organisations.deleteOrganisation();
	}

}
