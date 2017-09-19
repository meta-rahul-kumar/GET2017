package com.metacube.test;
import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.facade.GuestFacade;

/**
 * Test Class For GuestFacade
 * @author Rahul Kumar
 *
 */
public class GuestFacadeTest {
	
	@Test
	public void isIdAlreadyExistsTest_True(){
		GuestFacade guestFacade = new GuestFacade();
		guestFacade.addGuest(1, "Rahul", 23);
		boolean expected = true;
		assertEquals(expected, guestFacade.isIdAlreadyExists(1));
	}
	
	@Test
	public void isIdAlreadyExistsTest_False(){
		GuestFacade guestFacade = new GuestFacade();
		guestFacade.addGuest(1, "Rahul", 23);
		boolean expected = false;
		assertNotEquals(expected, guestFacade.isIdAlreadyExists(1));
	}
	
	@Test
	public void getTotalNumberOfGuestsTest_True(){
		GuestFacade guestFacade = new GuestFacade();
		guestFacade.addGuest(1, "Rahul", 23);
		guestFacade.addGuest(2, "Vikash", 24);
		guestFacade.addGuest(3, "Nisha", 27);
		int expected = 3;
		assertEquals(expected, guestFacade.getTotalNumberOfGuests());
	}
	
	@Test
	public void getTotalNumberOfGuestsTest_False(){
		GuestFacade guestFacade = new GuestFacade();
		guestFacade.addGuest(1, "Rahul", 23);
		guestFacade.addGuest(2, "Vikash", 24);
		guestFacade.addGuest(3, "Nisha", 27);
		int expected = 5;
		assertNotEquals(expected, guestFacade.getTotalNumberOfGuests());
	}
}
