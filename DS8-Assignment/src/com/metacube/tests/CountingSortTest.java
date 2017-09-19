package com.metacube.tests;

import org.junit.Test;

import com.metacube.sortAlgorithms.CountingSort;

import static org.junit.Assert.*;

/**
 * Counting Sort methods Test Class
 * 
 * @author Rahul Kumar
 *
 */
public class CountingSortTest {

	@Test
	public void sortTest_True() {
		CountingSort countingSort = new CountingSort();
		int[] input = { 7, 3, 9, 2, 1 };
		int[] expected = { 1, 2, 3, 7, 9 };
		countingSort.sort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	public void sortTest_False() {
		CountingSort countingSort = new CountingSort();
		int[] input = { 7, 3, 9, 2, 1 };
		int[] expected = { 1, 2, 7, 3, 9 };
		countingSort.sort(input);
		assertNotEquals(expected, input);
	}
}
