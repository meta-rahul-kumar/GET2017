package Question2;

import org.junit.*;
import static org.junit.Assert.*;

public class TestRemoveDuplicate {
	
	/**
	 * Checks RemoveDuplicate function 
	 * Input : {1,2,3,4,2,5,3,6,3,1,1,1,1,1,1}
	 * Expected Output : {1,2,3,4,5,6}
	 * Test Status : Pass
	 */
	@Test
	public void checkpass() {
		RemoveDuplicate obj = new RemoveDuplicate();
		int[] input = {1, 2, 3, 4, 2, 5, 3, 6, 3, 1, 1, 1, 1, 1, 1};
		int[] output = obj.removeDuplicate(input);
		int[] expectedOutput = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(expectedOutput, output);
	}
	
	/**
	 * Checks RemoveDuplicate function 
	 * Input : {1,2,3,4,2,5,3,6,3,1,1,1,1,1,1}
	 * Expected Output : {1,2,3,4,5,6,1}
	 * Test Status : Fail
	 */
	@Test
	public void checkfail() {
		RemoveDuplicate obj = new RemoveDuplicate();
		int[] input = {1, 2, 3, 4, 2, 5, 3, 6, 3, 1, 1, 1, 1, 1, 1};
		int[] output = obj.removeDuplicate(input);
		int[] expectedOutput = {1, 2, 3, 4, 5, 6, 1};
		assertArrayEquals(expectedOutput, output);
	}
	
	/**
	 * Checks elementExists function 
	 * Input : 2 , {1,2,3,4,5,6}
	 * Expected Output : true
	 * Test Status : Pass
	 */
	@Test
	public void checkElementExistsPass() {
		RemoveDuplicate obj = new RemoveDuplicate();
		int[] input = {1, 2, 3, 4, 5, 6};
		boolean output = obj.elementExists(2, input);
		boolean expectedOutput = true;
		assertEquals(expectedOutput, output);
	}
	
	/**
	 * Checks elementExists function 
	 * Input : 9 , input[]
	 * Expected Output : true
	 * Test Status : Pass
	 */
	@Test
	public void checkElementExistsFail() {
		RemoveDuplicate obj = new RemoveDuplicate();
		int[] input = {1, 2, 3, 4, 5, 6};
		boolean output = obj.elementExists(9, input);
		boolean expectedOutput = true;
		assertEquals(expectedOutput, output);
	}
}
