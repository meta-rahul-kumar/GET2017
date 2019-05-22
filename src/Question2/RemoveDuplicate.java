package Question2;
/**
 * Class Removes duplicate elements from an Array.
 * 
 * @version 1.0 13 July 2017
 * @author Rahul Kumar
 */

public class RemoveDuplicate {
	/**
	 * Method - removeDuplicate
	 * Method take input as Integer Array and remove duplicate elements from
	 * array and returns Integer array with no duplicated elements
	 */
	int[] removeDuplicate(int[] input) {
		int tempHoldingIndex = 0;
		int[] tempHolding;
		tempHolding = new int[input.length];
		int[] arrayWithoutDuplicates;
		
		for (int i = 0; i < input.length; i++) {
			boolean existance = elementExists(input[i], tempHolding);
			if (! existance) {
				/* If emlement not exists in current tempHolding Array then only store it.*/
				tempHolding[tempHoldingIndex] = input[i];
				tempHoldingIndex++;
			}
		}
		
		arrayWithoutDuplicates = new int[tempHoldingIndex];
		
		for (int i = 0; i < tempHoldingIndex; i++) {
			arrayWithoutDuplicates[i] = tempHolding[i];
		}
		
		tempHolding = null;
		return arrayWithoutDuplicates;
	}
	
	/**
	 * Method - tempHolding
	 * Method take two input parameters element as n and Integer Array
	 * tempHolding and checks that element with value n exists in tempHolding
	 * Array.
	 * if Exists returns true
	 * otherwise returns false
	 */
	boolean elementExists(int n, int[] tempHolding) {
		int flag = 0; //  if exists flag = 1 and if not exists flag = 0 
		
		for (int i = 0; i < tempHolding.length; i++) {
			if (tempHolding[i] == n) {
				/* If element is already exists in tempHolding array then set flag to 1*/
				flag = 1;
				break;
			}
		}
		
		if (flag == 0) {
			/* if element not exists*/
			return false;
		}
		
		return true;
	}
	
}
