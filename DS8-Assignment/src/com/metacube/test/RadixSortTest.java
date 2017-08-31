package com.metacube.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import com.metacube.sortings.RadixSort;

/**
 * Radix Sort Methods Test Class
 * 
 * @author Rahul Kumar
 *
 */
public class RadixSortTest {
	@Test
	public void sortTest_True() {
		RadixSort radixSort = new RadixSort();
		int[] input = { 7, 3, 9, 2, 1 };
		int[] expected = { 1, 2, 3, 7, 9 };
		radixSort.sort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	public void sortTest_False() {
		RadixSort radixSort = new RadixSort();
		int[] input = { 7, 3, 9, 2, 1 };
		int[] expected = { 1, 2, 7, 3, 9 };
		radixSort.sort(input);
		assertNotEquals(expected, input);
	}
}
