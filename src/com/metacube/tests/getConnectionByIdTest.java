package com.metacube.tests;
import org.junit.Test;
import com.metacube.controllers.Connections;
import com.metacube.main.Home;
import com.metacube.models.Connection;
import static org.junit.Assert.*;


public class getConnectionByIdTest {

	@Test
	public void getConnectionByIdTesting() {
		Connections connections = new Connections();
		connections.initConnections();
		Home.sessionId = 1;
		Connection expected = connections.getConnections().get(Home.sessionId+"");
		assertEquals(expected , connections.getConnectionById(Home.sessionId+"")); // True case
		
		expected = connections.getConnections().get("2");
		assertNotEquals(expected , connections.getConnectionById(Home.sessionId+"")); // True case
	}
}
