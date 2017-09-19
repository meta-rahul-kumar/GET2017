package com.metacube.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import com.metacube.controllers.Organisations;
import com.metacube.main.Home;

public class IsOrganisationExistsTest {
	
	@Test
	public void isOrganisationExistsTesting() {
		Organisations organisations = new Organisations();
		organisations.initOrganisations();
		int organisationId = 1;
		Home.sessionId = 1;
		boolean expected = true;
		assertEquals(expected, organisations.isOrganisationExists(organisationId));
		
		organisationId = 3;
		expected = true;
		assertNotEquals(expected, organisations.isOrganisationExists(organisationId));
	}
}
