package com.metacube.tests;

import org.junit.Test;

import com.metacube.sortAlgorithms.BubbleSort;

import static org.junit.Assert.*;

/**
 * Bubbles Sort methods test Class
 * 
 * @author Rahul Kumar
 *
 */
public class BubbleSortTest {

	@Test
	public void sortTest_True() {
		BubbleSort bubbleSort = new BubbleSort();
		int[] input = { 7, 3, 9, 2, 1 };
		int[] expected = { 1, 2, 3, 7, 9 };
		bubbleSort.sort(input);
		assertArrayEquals(expected, input);
	}

	@Test
	public void sortTest_False() {
		BubbleSort bubbleSort = new BubbleSort();
		int[] input = { 7, 3, 9, 2, 1 };
		int[] expected = { 1, 2, 7, 3, 9 };
		bubbleSort.sort(input);
		assertNotEquals(expected, input);
	}
}
