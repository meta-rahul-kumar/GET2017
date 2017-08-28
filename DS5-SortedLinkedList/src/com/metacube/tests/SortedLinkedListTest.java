package com.metacube.tests;
import static org.junit.Assert.*;
import org.junit.Test;
import com.metacube.resources.SortedLinkedList;

/**
 * Test class for SortedLinkedList Class
 * @author Rahul Kumar
 *
 */
public class SortedLinkedListTest {

	@Test
	public void addNodeTest_True() {
		SortedLinkedList sortedLinkedList = new SortedLinkedList();
		int expected = 5;
		assertEquals(expected, sortedLinkedList.addNode(5));
	}
	
	@Test
	public void addNodeTest_False() {
		SortedLinkedList sortedLinkedList = new SortedLinkedList();
		int expected = 6;
		assertNotEquals(expected, sortedLinkedList.addNode(5));
	}
}
