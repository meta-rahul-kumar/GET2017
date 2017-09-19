package com.metacube.test;
import org.junit.Test;
import com.metacube.facade.CollegeFacade;
import com.metaucbe.views.Input;
import com.metaucbe.views.Output;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * CollegeFacadeTest tests the CollegeFacade methods
 * @author Rahul Kumar
 *
 */
public class CollegeFacadeTest {
	CollegeFacade collegeFacade;
	Output output;
	Input input;
	
	@Before
	public void setObjects() {
		input = new Input();
		collegeFacade = new CollegeFacade();
		output = new Output();
	}
	
	@Test
	public void checkCollegeForEmptySeatTest_False() {
		boolean expected = true;
		assertNotEquals(expected, collegeFacade.checkCollegeForEmptySeat(2));
	}
	
	@Test
	public void checkCollegeForEmptySeatTest_True() {
		boolean expected = true;
		assertEquals(expected, collegeFacade.checkCollegeForEmptySeat(1));
	}
	
	@Test
	public void getTotalSeatsTest_True() {
		int expected = 2;
		assertEquals(expected, collegeFacade.getTotalSeats());
	}

	@Test
	public void getTotalSeatsTest_False() {
		input.addCollege("CTAE", 2);
		input.addCollege("MBM", 0);
		int expected = 5;
		assertNotEquals(expected, collegeFacade.getTotalSeats());
	}
	
	@Test
	public void getCollegeNameByIdTest_False() { 
		String expected = "CTAE";
		assertNotEquals(expected, collegeFacade.getCollegeNameById(2));
	}
	
	@Test
	public void getCollegeNameByIdTest_True() { 
		String expected = "CTAE";
		assertEquals(expected, collegeFacade.getCollegeNameById(1));
	}
	
	@Test
	public void getLastCollegeIDTest_False() {
		int expected = 1;
		assertNotEquals(expected, collegeFacade.getLastCollegeID());
	}
	
	@Test
	public void getLastCollegeIDTest_True() {
		int expected = 2;
		assertEquals(expected, collegeFacade.getLastCollegeID());
	}
}
