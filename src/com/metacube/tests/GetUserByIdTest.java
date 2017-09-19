package com.metacube.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import com.metacube.controllers.Users;
import com.metacube.main.Home;
import com.metacube.models.User;

public class GetUserByIdTest {

	@Test
	public void getUserByIdTesting() {
		Users users = new Users();
		users.initUsers();
		Home.sessionId = 1;
		User expected = users.getUsers().get(Home.sessionId+"");
		assertEquals(expected, users.getUserById(Home.sessionId+""));
		
		expected = users.getUsers().get("2");
		assertNotEquals(expected, users.getUserById(Home.sessionId+""));
	}
}
