package com.metacube.tests;
import org.junit.Test;
import static org.junit.Assert.*;
import com.metacube.controllers.Connections;
import com.metacube.main.Home;

public class AlreadyConnectedTest {

	@Test
	public void alreadyConnectedTesting() {
		Connections connections = new Connections();
		connections.initConnections();
		Home.sessionId = 1;
		int connectToId = 2;
		boolean expected = true;
		assertEquals(expected, connections.isConnected(connectToId));
		
		connectToId = 3;
		expected = true;
		assertNotEquals(expected, connections.isConnected(connectToId));
	}
}
