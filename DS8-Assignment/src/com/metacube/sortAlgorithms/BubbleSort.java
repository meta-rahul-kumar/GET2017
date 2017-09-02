package com.metacube.sortAlgorithms;

/**
 * Class Performs the bubble Sorting.
 * 
 * @author Rahul Kumar
 *
 */
public class BubbleSort {

	/**
	 * method performs the bubble sorting
	 * 
	 * @param input
	 */
	public void sort(int[] input) {
		boolean flag = true;
		do {
			flag = false;
			for (int i = 0; i < input.length - 1; i++) {
				// loop run from 0 to n-1
				for (int j = 0; j < input.length - i - 1; j++) {
					//compare jth and (j+1)th element
					if (input[j] > input[j + 1]) {
						swap(input, j, j + 1);
						flag = true;
					}
				}
			}
		} while (flag);
	}

	/**
	 * private method swap perform swapping of two numbers
	 * 
	 * @param input
	 * @param i
	 * @param j
	 */
	private void swap(int[] input, int i, int j) {
		input[i] = input[i] + input[j];
		input[j] = input[i] - input[j];
		input[i] = input[i] - input[j];
	}
}
