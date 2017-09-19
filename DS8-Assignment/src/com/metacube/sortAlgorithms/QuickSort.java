package com.metacube.sortAlgorithms;

/**
 * Class Performs Quick Sort
 * 
 * @author Rahul Kumar
 *
 */
public class QuickSort {

	/**
	 * method performs the quick sorting
	 * 
	 * @param input
	 * @param low
	 * @param high
	 */
	public void sort(int[] input, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(input, low, high);

			sort(input, low, partitionIndex - 1); // sort the left sub-array
			sort(input, partitionIndex + 1, high); // sort the right sub-array
		}
	}

	/**
	 * returns the partition index
	 * 
	 * @param input
	 * @param low
	 * @param high
	 * @return
	 */
	public int partition(int[] input, int low, int high) {
		int pivot = input[high];
		int partitionIndex = low - 1;

		for (int iterator = low; iterator < high; iterator++) {
			if (input[iterator] <= pivot) {
				partitionIndex++;
				swap(input, iterator, partitionIndex);
			}
		}
		swap(input, partitionIndex + 1, high);
		return partitionIndex + 1;
	}

	/**
	 * method swap two elements
	 * 
	 * @param input
	 * @param firstindex
	 * @param secondindex
	 */
	private void swap(int[] input, int firstindex, int secondindex) {
		int temp = input[firstindex];
		input[firstindex] = input[secondindex];
		input[secondindex] = temp;
	}

	public static void main(String[] args) {
		QuickSort quickMe = new QuickSort();
		int[] input = { 7, 2, 9, 3, 0, 0 };
		quickMe.sort(input, 0, input.length - 1);

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
}
