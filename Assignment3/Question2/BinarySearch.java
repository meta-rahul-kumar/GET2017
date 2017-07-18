/**
 * Class performs binary search on an input array.
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question2;

public class BinarySearch {
	
	/*
	 * Method - binarySearch
	 * input - integer input array,integer search element,integer lower index, integer upper index
	 * output - return result of search in integer
	 */
	public int binarySearch(int[] input, int search,int indexOfLower,int indexOfUpper) {
		int mid = indexOfLower + (indexOfUpper - indexOfLower) / 2;
		
		if(indexOfUpper >= indexOfLower) {
			if(input[mid] == search) {
				return mid;
			}
			if(input[mid] > search) {
				return binarySearch(input, search, indexOfLower, mid - 1);  // if input[mid] is less than searching element
			}
			if(input[mid] < search) {
				return binarySearch(input, search, mid + 1, indexOfUpper);  // if input[mid] is greater than searching element
			}
		}
		
		return -1;
	}
}

