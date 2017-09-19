package com.metacube.main;

/**
 * BinarySearch class Find the leftmost occurrence of searching element.
 * @author Rahul Kumar
 *
 */
public class BinarySearch {
	
	/**
	 * searches the leftmost occurrence position of an searching element
	 * @param input
	 * @param searchItem
	 * @return
	 */
	public int binarySearch(int[] input ,int searchItem) {
		int min = 0;
		int max = input.length - 1;
		int mid = (min + max ) / 2;
		int position = -1;
		
		while (min < max) {
			if (input[mid] == searchItem) {
				position = mid;
				max = mid;
			} else if (input[mid] > searchItem) {
				max = mid - 1;
			} else if (input[mid] < searchItem) {
				min = mid + 1;
			}
			
			mid = (max + min ) / 2;
		}
		
		return position;
	}
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String args[]) {
		BinarySearch binarySearch = new BinarySearch();
		int[] input = {2,3,3,3,4,4,4,6,7,8,8,9};
		int searchItem = 4;
		
		System.out.println("Position : " + binarySearch.binarySearch(input, searchItem));
	}
}
