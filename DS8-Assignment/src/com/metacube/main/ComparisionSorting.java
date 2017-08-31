package com.metacube.main;

import com.metacube.menu.Action;
import com.metacube.sortings.BubbleSort;
import com.metacube.sortings.QuickSort;

/**
 * Class Performs the Comparison Sortings
 * 
 * @author Rahul Kumar
 *
 */
public class ComparisionSorting implements Action {

	/**
	 * Overrided method of Action Interface
	 */
	@Override
	public void performAction(int[] inputArray) {
		if (inputArray.length <= 10) {
			// if inputs are less or equal than 10
			BubbleSort bubbleSort = new BubbleSort();
			bubbleSort.sort(inputArray);
			System.out.println("System has used Bubble Sort sorting technique and sorted list as below :");
		} else {
			// if inputs are greater than 10
			QuickSort quickSort = new QuickSort();
			quickSort.sort(inputArray, 0, inputArray.length - 1);
			System.out.println("System has used Quick Sort sorting technique and sorted list as below :");
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
