package Question3;
/**
 * Class Finds the longest increasing sequence in a Array.
 * 
 * @version 1.0 13 July 2017
 * @author Rahul Kumar
 */

public class LongestIncreasingSequence {
	
	/**
	 * Method - longestSequence
	 * Method take input as Integer Array and find longest increasing sequence
	 * in array. and create new array of longest incraesing sequence elements
	 * and return it.
	 */
	int[] longestSequence(int[] input) {
		int startingMarker = 0;  // holds current value of starting of sequence index
		int endingMarker = 0;	 // holds  current ending index of increasing sequence
		int helperStaringMarker = 0; // holds starting index value of longest sequence till now
		int helperEndingMarker = 0;  // holds ending index value of longest sequence till now
		int[] resultArray;
		
		for (int i = 1; i < input.length; i++) {
			if (input[i] > input[i - 1]) {
				/* if last element is lesser than current element*/
				endingMarker++;
			} else if ((input[i] < input[i - 1])) {
				/* if last element is greater than current element*/
				if ((helperEndingMarker - helperStaringMarker)
							<= (endingMarker - startingMarker)) {
					/* if difference of current sequence length is greater or equal than old sequence length */
					helperStaringMarker = startingMarker;
					startingMarker = i - 1;
					helperEndingMarker = endingMarker;
					endingMarker = i;
				} else {
					startingMarker = i - 1;
					endingMarker = i;
				}
			} else if (input[i] == input[i - 1]) {
				startingMarker = i - 1;
				endingMarker = i;
			}
			
			if (i == (input.length - 1)) {
				if ((helperEndingMarker - helperStaringMarker) 
							<= (endingMarker - startingMarker)) {
					helperStaringMarker = startingMarker;
					startingMarker = i;
					helperEndingMarker = endingMarker;
					endingMarker = i;
				}
			}
		}
		
		resultArray = new int[helperEndingMarker - helperStaringMarker];
		
		for (int j = 0; j < resultArray.length; j++) {
			if (helperStaringMarker != helperEndingMarker) {
				resultArray[j] = input[++helperStaringMarker];
			} else {
				break;
			}
		} 
		
		return resultArray;
	}
}
