package com.metacube.tests;
import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.resources.QueueProgram;

/**
 * Test class for QueueProgram Class
 * @author Rahul Kumar
 *
 */
public class QueueProgramTest {

	@Test
	public void isEmpty_True() {
		QueueProgram queue = new QueueProgram();
		boolean expected = true;
		assertEquals(expected, queue.isEmpty());
	}
	
	@Test
	public void isEmpty_False() {
		QueueProgram queue = new QueueProgram();
		queue.add(5);
		boolean expected = true;
		assertNotEquals(expected, queue.isEmpty());
	}
	
	@Test
	public void sizeTest_True() {
		QueueProgram queue = new QueueProgram();
		queue.add(5);
		queue.add(6);
		int expected = 2;
		
		assertEquals(expected, queue.size());
	}
	
	@Test
	public void sizeTest_False() {
		QueueProgram queue = new QueueProgram();
		queue.add(5);
		queue.add(6);
		int expected = 1;
		
		assertNotEquals(expected, queue.size());
	}
	
	@Test
	public void containsTest_True() {
		QueueProgram queue = new QueueProgram();
		queue.add(5);
		queue.add(6);
		boolean expected = true;
		
		assertEquals(expected, queue.contains(5));
	}
	
	@Test
	public void containsTest_False() {
		QueueProgram queue = new QueueProgram();
		queue.add(5);
		queue.add(6);
		boolean expected = true;
		
		assertNotEquals(expected, queue.contains(8));
	}
	
	@Test
	public void removeTest_True() {
		QueueProgram queue = new QueueProgram();
		queue.add(5);
		queue.add(6);
		boolean expected = true;
		
		assertEquals(expected, queue.remove(5));
	}
	
	@Test
	public void removeTest_False() {
		QueueProgram queue = new QueueProgram();
		queue.add(5);
		queue.add(6);
		boolean expected = true;
		
		assertNotEquals(expected, queue.remove(50));
	}
}
