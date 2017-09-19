package com.metacube.test;
import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.facade.RoomsFacade;

/**
 * Test Class For Rooms facade
 * @author Rahul Kumar
 *
 */
public class RoomsFacadeTest {

	@Test
	public void getNoOfRoomsTest_True() {
		RoomsFacade roomsFacade = new RoomsFacade();
		roomsFacade.addRooms(10);
		int expected = 10;
		assertEquals(expected, roomsFacade.getNoOfRooms());
	}
	
	@Test
	public void getNoOfRoomsTest_False() {
		RoomsFacade roomsFacade = new RoomsFacade();
		roomsFacade.addRooms(10);
		int expected = 11;
		assertNotEquals(expected, roomsFacade.getNoOfRooms());
	}
}
