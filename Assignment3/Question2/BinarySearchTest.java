/**
 * Junit Test Class for binarySearch method of BinarySearch Class
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class BinarySearchTest {
	@Test
	public void binarySearchTesting() {
		BinarySearch binarySearcher = new BinarySearch();
		int[] input = {1, 3, 6, 8, 9, 10};
		int indexOfLower = 0;
		int indexOfUpper = 5;
		int search = 3;
		int output = binarySearcher.binarySearch(input, search, indexOfLower, indexOfUpper);
		int expected = 1;
		assertEquals(expected, output); // True Case 
		search = 11;
		output = binarySearcher.binarySearch(input, search, indexOfLower, indexOfUpper);
		expected = -1;
		assertEquals(expected, output); // True Case
		int[] inputSecond = {1, 3, 4, 5, 7, 9};
		indexOfLower = 0;
		indexOfUpper = 5;
		search = 3;
		output = binarySearcher.binarySearch(inputSecond, search, indexOfLower, indexOfUpper);
		expected = -1;
		assertNotEquals(expected, output); // False Case 
		search = 11;
		output = binarySearcher.binarySearch(inputSecond, search, indexOfLower, indexOfUpper);
		expected = 5;
		assertNotEquals(expected, output); // False Case
		
	}
}
