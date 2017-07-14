package Question5;

import org.junit.*;
import static org.junit.Assert.*;

public class TestCheckSorted {
	
	/**
	 * Checks checkSort function 
	 * Input : {7, 56, 65, 74, 82, 91}
	 * Expected Output : 1
	 * Test Status : Pass
	 */
	@Test
	public void TestAscPass() {
		CheckSorted sort = new CheckSorted();
		int[] input = {7, 56, 65, 74, 82, 91};
		int output = sort.checkSort(input);
		int expected = 1;
		assertEquals(expected, output);
	}
	
	/**
	 * Checks checkSort function 
	 * Input : {7, 56, 65, 74, 82, 91}
	 * Expected Output : 2
	 * Test Status : Fail
	 */
	@Test
	public void TestAscFail() {
		CheckSorted sort = new CheckSorted();
		int[] input = {7, 56, 65, 74, 82, 91};
		int output = sort.checkSort(input);
		int expected = 2;
		assertEquals(expected, output);
	}
	
	/**
	 * Checks checkSort function 
	 * Input : {100, 90, 80, 70, 56, 45, 23}
	 * Expected Output : 2
	 * Test Status : Pass
	 */
	@Test
	public void TestDescPass() {
		CheckSorted sort = new CheckSorted();
		int[] input = {100, 90, 80, 70, 56, 45, 23};
		int output = sort.checkSort(input);
		int expected = 2;
		assertEquals(expected, output);
	}
	
	/**
	 * Checks checkSort function 
	 * Input : {100, 90, 80, 70, 56, 45, 23}
	 * Expected Output : 1
	 * Test Status : Pass
	 */
	@Test
	public void TestDescFail() {
		CheckSorted sort = new CheckSorted();
		int[] input = {100, 90, 80, 70, 56, 45, 23};
		int output = sort.checkSort(input);
		int expected = 1;
		assertEquals(expected, output);
	}
	
	/**
	 * Checks checkSort function 
	 * Input : {100, 90, 80, 70, 71, 45, 23}
	 * Expected Output : 0
	 * Test Status : Pass
	 */
	@Test
	public void TestNoOrderPass() {
		CheckSorted sort = new CheckSorted();
		int[] input = {100, 90, 80, 70, 71, 45, 23};
		int output = sort.checkSort(input);
		int expected = 0;
		assertEquals(expected, output);
	}
	
	/**
	 * Checks checkSort function 
	 * Input : {100, 90, 80, 70, 71, 45, 23}
	 * Expected Output : 2
	 * Test Status : Fail
	 */
	@Test
	public void TestNoOrderFail() {
		CheckSorted sort = new CheckSorted();
		int[] input = {100, 90, 80, 70, 71, 45, 23};
		int output = sort.checkSort(input);
		int expected = 2;
		assertEquals(expected, output);
	}
	
}
