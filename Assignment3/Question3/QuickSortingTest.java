/**
 * Junit Test Class for quickSort method of QuickSorting Class
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class QuickSortingTest {
	
	@Test
	public void quickSortingTesting() {
		QuickSorting quickSorter = new QuickSorting();
		int[] input = {9, 6, 2, 8, 1, 7, 6};
		int indexOfLower = 0;
		int indexOfUpper = input.length - 1;
		int[] outputExpected = {1, 2, 6, 6, 7, 8, 9};
		int[] output = quickSorter.quickSort(input, indexOfLower, indexOfUpper);
		assertArrayEquals(outputExpected, output); // True Case
		
		outputExpected = new int[]{1, 2, 6, 6, 7, 8, 1}; 
		int[] outputSecond = quickSorter.quickSort(input, indexOfLower, indexOfUpper);
		assertNotEquals(outputExpected, outputSecond); // False Case
		
		input =  new int[]{};
		outputExpected=  new int[]{1}; 
		indexOfLower = 0;
		indexOfUpper = input.length - 1;
		int[] outputThird = quickSorter.quickSort(input, indexOfLower, indexOfUpper);
		assertNotEquals(outputExpected, outputThird); // Exception Case
		
		input =  new int[]{2, 5, 8, 9, 10, 77, 55, 11};;
		outputExpected=  new int[]{2, 5, 8, 9, 10, 77, 55, 11}; 
		indexOfLower = 0;
		indexOfUpper = input.length - 1;
		int[] outputForth = quickSorter.quickSort(input, indexOfLower, indexOfUpper);
		assertNotEquals(outputExpected, outputForth); // Exception Case
	}
}
