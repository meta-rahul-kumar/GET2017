package com.metacube.sortAlgorithms;

import java.util.Arrays;

/**
 * Class performs the counting sort.
 * 
 * @author Rahul Kumar
 *
 */
public class CountingSort {

	/**
	 * method performs the counting sort.
	 * 
	 * @param input
	 */
	public void sort(int[] input) {
		int max = findMaxNumberFromArray(input); // maximum number in an array

		int[] sortedArray = new int[max + 1];
		Arrays.fill(sortedArray, 0); // fills the array with 0

		for (int i = 0; i < input.length; i++) {
			sortedArray[input[i]]++;
		}

		int j = 0;
		for (int i = 0; i < sortedArray.length; i++) {
			while (sortedArray[i] != 0) {
				input[j++] = i;
				sortedArray[i]--;
			}
		}

	}

	/**
	 * finds the maximum number from an array
	 * 
	 * @param input
	 * @return
	 */
	private int findMaxNumberFromArray(int[] input) {
		int max = input[0]; // taking first Element as Maximum
		for (int i = 1; i < input.length; i++) {
			if (max < input[i]) {
				max = input[i];
			}
		}
		return max;
	}
}
