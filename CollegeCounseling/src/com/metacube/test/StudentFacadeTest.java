package com.metacube.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import com.metacube.facade.StudentFacade;
import com.metaucbe.views.Input;
import com.metaucbe.views.Output;

/**
 * StudentFacadeTest test the StudentFacade methods
 * @author Rahul Kumar
 *
 */
public class StudentFacadeTest {
	StudentFacade studentFacde;
	Output output;
	Input input;
	
	@Before
	public void setObjects() {
		input = new Input();
		studentFacde = new StudentFacade();
		output = new Output();
	}
	
	@Test
	public void getLastStudentIDTest_False() {
		input.addStudent("Rahul", 1);
		input.addStudent("Vikash", 2);
		int expected = 1;
		assertNotEquals(expected, studentFacde.getLastStudentID());
	}
	
	@Test
	public void getLastStudentIDTest_True() {
		int expected = 2;
		assertEquals(expected, studentFacde.getLastStudentID());
	}
	
	
}
