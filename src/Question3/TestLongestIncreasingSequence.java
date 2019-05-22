package Question3;

import org.junit.*;
import static org.junit.Assert.*;

public class TestLongestIncreasingSequence {
	
	/**
	 * Checks LongestIncreasingSequence function 
	 * Input : {1, 2, 3, 2, 3, 4, 5, 3, 4, 2, 2, 3, 4, 5, 6, 7, 8, 1, 2, 4, 5, 6, 7, 8, 9}
	 * Expected Output : {1, 2, 4, 5, 6, 7, 8, 9}
	 * Test Status : Pass
	 */
	@Test
	public void testLongestSequencePass() {
		LongestIncreasingSequence obj=new LongestIncreasingSequence();
		int[] input = {1, 2, 3, 2, 3, 4, 5, 3, 4, 2, 2, 3, 4, 5, 6, 7, 8, 1, 2, 4, 5, 6, 7, 8, 9};
		int[] output = obj.longestSequence(input);
		int[] expectedOutput = {1, 2, 4, 5, 6, 7, 8, 9};
		assertArrayEquals(expectedOutput, output);
	}
	
	/**
	 * Checks LongestIncreasingSequence function 
	 * Input : {1, 2, 3, 2, 3, 4, 5, 3, 4, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2, 4, 5, 6, 7, 8, 9}
	 * Expected Output : {1, 2, 4, 5, 6, 7, 8, 9, 10 ,11}
	 * Test Status : Fail
	 */
	@Test
	public void testLongestSequenceFail() {
		LongestIncreasingSequence obj=new LongestIncreasingSequence();
		int[] input= {1, 2, 3, 2, 3, 4, 5, 3, 4, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2, 4, 5, 6, 7, 8, 9};
		int[] output=obj.longestSequence(input);
		int[] expectedOutput= {1, 2, 4, 5, 6, 7, 8, 9, 10, 11};
		assertArrayEquals(expectedOutput, output);
	}
}
