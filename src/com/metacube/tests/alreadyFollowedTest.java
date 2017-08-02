package com.metacube.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import com.metacube.controllers.OrganisationFollowers;
import com.metacube.main.Home;

public class AlreadyFollowedTest {
	
	@Test
	public void alreadyFollowedTesting() {
			OrganisationFollowers organisationFollowers = new OrganisationFollowers();
			organisationFollowers.initFollowers();
			Home.sessionId = 1;
			int organisationId = 1;
			boolean expected = true;
			assertEquals(expected, organisationFollowers.alreadyFollowed(Home.sessionId, organisationId));
			
			organisationId = 3;
			expected = true;
			assertNotEquals(expected, organisationFollowers.alreadyFollowed(Home.sessionId, organisationId));
	}
}
