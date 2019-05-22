package Question5;
/**
 * Objective : Sorting type Ascending/ Descending / none
 * 
 * @version 1.0 13 July 2017
 * @author Rahul Kumar
 */

public class CheckSorted {
	
	/**
	 * Method - checkSort
	 * Input : an Integer Array of Inputs
	 * Output : type of sorting 1 => Ascending , 2 => Descending , None => 0
	 */
	int checkSort(int[] input){
		int flagAsc = 0;  // sets if Array is in Ascending order
		int flagDesc = 0; // sets if array is in descending order
		int result = 0;		  // Stores result
	
		for (int i = 1; i < input.length; i++) {
			if (input[i] > input[i - 1]){
				flagAsc++;
			} else if (input[i] < input[i - 1]) {
				flagDesc++;
			}
		}
		
		if (flagAsc == input.length - 1){
			result = 1;
		} else if (flagDesc == input.length - 1){
			result = 2;
		}
		
		return result;
	}
}
