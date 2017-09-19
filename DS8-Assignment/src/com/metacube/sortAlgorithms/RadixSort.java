package com.metacube.sortAlgorithms;

/**
 * Class Performs the radix sort
 * 
 * @author Rahul Kumar
 *
 */
public class RadixSort {

	/**
	 * method performs the redix sort
	 * 
	 * @param inputArray
	 */
	public void sort(int[] inputArray) {
		int maxNumber = findMaxNumberFromArray(inputArray);
		int multiplier = 1;

		while (maxNumber != 0) {
			countingSort(inputArray, multiplier); // call to counting sort with input array and
			multiplier *= 10;
			maxNumber /= 10;
		}

	}

	/**
	 * method perform counting sort
	 * @param input
	 * @param divisor
	 */
	private void countingSort(int[] input, int divisor) {
		int[] output = new int[input.length];
		int[] counting = new int[10];

		for (int i = 0; i < input.length; i++) {
			counting[(input[i] / divisor) % 10]++;
		}
		
		for (int i = 1; i < counting.length; i++) {
			counting[i] += counting[i - 1];
		}

		for (int i = input.length - 1; i >= 0; i--) {
			output[counting[(input[i] / divisor) % 10] - 1] = input[i];
			counting[(input[i] / divisor) % 10]--;
		}

		for (int i = 0; i < input.length; i++) {
			// copies output elements in original input array
			input[i] = output[i];
		}
	}

	/**
	 * Finds the maximum number from array
	 * @param input
	 * @return
	 */
	private int findMaxNumberFromArray(int[] input) {
		int max = input[0]; // takes first element as Maximum number
		for (int iterator = 1; iterator < input.length; iterator++) {
			if (max < input[iterator]) {
				max = input[iterator];
			}
		}
		return max;
	}
}
