/**
 * Junit Test Class for partitioning method of QuickSorting Class
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PartitioningTest {
	@Test
	public void quickPartitioningTesting() {
		QuickSorting quickSorter = new QuickSorting();
		int[] input = {9, 6, 2, 8, 1, 7, 6};
		int indexOfLower = 0;
		int indexOfUpper = input.length - 1;
		int outputExpected = 3;
		int output = quickSorter.partitioning(input, indexOfLower, indexOfUpper);
		assertEquals(outputExpected, output); // True Case
		
		outputExpected = 4; 
		int outputSecond = quickSorter.partitioning(input, indexOfLower, indexOfUpper);
		assertNotEquals(outputExpected, outputSecond); // False Case
	}
}
