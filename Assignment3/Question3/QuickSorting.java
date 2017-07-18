/**
 * Class performs Quick Sort search on an input array.
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question3;


class QuickSorting
{
	/*
	 * Method - partitioning
	 * input - integer input array,integer lower index, integer upper index
	 * output - return the pivot element index
	 */
	int partitioning(int[] input, int indexOfLower, int indexOfUpper) {
		try {
			if (input.length < 1) {
				throw (new Exception());
			}
		} catch(Exception lengthError) {
			System.out.println("Length of input array must be greater than 0");
		}
		int pivotElement = input[indexOfUpper];
		int leastIndex = indexOfLower - 1;
		
		for(int loopCounter = indexOfLower ; loopCounter < indexOfUpper ; loopCounter++) {
			if (input[loopCounter] <= pivotElement) {
				leastIndex++;
				int tempElement = input[loopCounter];
				input[loopCounter] = input[leastIndex];
				input[leastIndex] = tempElement;
				
			}
		}
		
		int pivotChanging = input[leastIndex + 1];
		input[leastIndex + 1] = input[indexOfUpper]; 
		input[indexOfUpper] = pivotChanging;
		
		return leastIndex + 1;
	}
	
	/*
	 * Method - quickSort
	 * input - integer input array,integer search element,integer lower index, integer upper index
	 * output - return sorted array
	 */
	int [] quickSort(int[] input, int indexOfLower, int indexOfUpper) {
		try {
			if (input.length < 1) {
				throw (new Exception());
			}
		} catch(Exception lengthError) {
			System.out.println("Length of input array must be greater than 0");
		}
		if(indexOfLower < indexOfUpper){
			int indexOfPartitioning = partitioning(input, indexOfLower, indexOfUpper);
			
			quickSort(input, indexOfLower, indexOfPartitioning - 1);
			quickSort(input, indexOfPartitioning  +1, indexOfUpper);
		}
		
		return input;
	}
}
