package com.metacube.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import com.metacube.sortAlgorithms.QuickSort;

/**
 * Quick Sort Methods Test Class
 * 
 * @author Rahul Kumar
 *
 */
public class QuickSortTest {
	@Test
	public void sortTest_True() {
		QuickSort quickSort = new QuickSort();
		int[] input = { 7, 3, 9, 2, 1 };
		int[] expected = { 1, 2, 3, 7, 9 };
		quickSort.sort(input, 0, 4);
		assertArrayEquals(expected, input);
	}

	@Test
	public void sortTest_False() {
		QuickSort quickSort = new QuickSort();
		int[] input = { 7, 3, 9, 2, 1 };
		int[] expected = { 1, 2, 7, 3, 9 };
		quickSort.sort(input, 0, 4);
		assertNotEquals(expected, input);
	}
}
