package com.metacube.main;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Cases for BinarySearch Class Methods
 * @author Rahul Kumar
 *
 */
public class BinarySearchTest {
	BinarySearch binarySearch;
	
	@Before
	public void settingObjects() {
		binarySearch = new BinarySearch();
	}
	
	@Test
	public void binarySearchTest_True() {
		int[] input = {1,1,2,2,2,3,3,4,5,5,6};
		int searchItem = 2;
		int expected = 2;
		assertEquals(expected, binarySearch.binarySearch(input, searchItem));
		
	}
	
	@Test
	public void binarySearchTest_False() {
		int[] input = {1,1,2,2,2,3,3,4,5,5,6};
		int searchItem = 2;
		int expected = 3;
		assertNotEquals(expected, binarySearch.binarySearch(input, searchItem));
		
	}
	
	@Test
	public void binarySearchTest_NotExists_True() {
		int[] input = {1,1,2,2,2,3,3,4,5,5,6};
		int searchItem = 9;
		int expected = -1;
		assertEquals(expected, binarySearch.binarySearch(input, searchItem));
		
	}
	
	@Test
	public void binarySearchTest_NotExists_False() {
		int[] input = {1,1,2,2,2,3,3,4,5,5,6};
		int searchItem = 9;
		int expected = 2;
		assertNotEquals(expected, binarySearch.binarySearch(input, searchItem));
		
	}
}
