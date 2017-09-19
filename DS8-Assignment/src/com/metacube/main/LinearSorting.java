package com.metacube.main;

import com.metacube.menu.Action;
import com.metacube.sortAlgorithms.CountingSort;
import com.metacube.sortAlgorithms.RadixSort;

/**
 * Class Performs the Liner Sortings
 * 
 * @author Rahul Kumar
 *
 */
public class LinearSorting implements Action {

	/**
	 * Overrided method of Action Interface
	 */
	@Override
	public void performAction(int[] inputArray) {
		int maxDigits = Input.digitsInMaximumNumber(inputArray); // gets the number of digits in maximum number.

		if (maxDigits > 2) {
			// if number of digits is greater than 2 in maximum number
			RadixSort radixSort = new RadixSort();
			radixSort.sort(inputArray);
			System.out.println("System has used Radix Sort sorting technique and sorted list as below :");
		} else {
			// if number of digits is less or equal than 2 in maximum number
			CountingSort countingSort = new CountingSort();
			countingSort.sort(inputArray);
			System.out.println("System has used Counting Sort sorting technique and sorted list as below :");
		}

		/**
		 * prints the array after sorting
		 */
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i] + " ");
		}

		System.out.println();
	}

}
