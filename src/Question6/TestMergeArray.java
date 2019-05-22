package Question6;

import org.junit.*;


import static org.junit.Assert.*;

public class TestMergeArray {
	
	/**
	 * Checks join function 
	 * Input : firstArray => {7, 56, 65, 74, 82, 91}
	 * 		   secondArray => {2, 4, 7, 10}
	 * 		   firstArray.length => 6
	 *         secondArray.length => 4
	 *         output
	 * Expected Output : {1, 2, 3, 4, 6, 7, 8, 10, 10}
	 * Test Status : Pass
	 */
	@Test
	public void TestAscOrderArraysPass() {
		MergeArray obj = new MergeArray();
		int[] firstArray = {1, 3, 6, 8, 10};
		int[] secondArray = {2, 4, 7, 10};
		int[] output = new int[firstArray.length + secondArray.length];
		output = obj.join(firstArray,firstArray.length, secondArray,
						  secondArray.length, output);
		int[] expected = {1, 2, 3, 4, 6, 7, 8, 10, 10};
		assertArrayEquals(expected, output);
	}
	
	/**
	 * Checks join function 
	 * Input : firstArray => {1, 3, 6, 8, 10}
	 * 		   secondArray => {2, 4, 7, 10}
	 * 		   firstArray.length => 5
	 *         secondArray.length => 4
	 *         output
	 * Expected Output : {1, 2, 3, 4, 6, 7, 8, 10}
	 * Test Status : Fail
	 */
	@Test
	public void TestAscOrderArraysFail() {
		MergeArray obj = new MergeArray();
		int[] firstArray = {1, 3, 6, 8, 10};
		int[] secondArray = {2, 4, 7, 10};
		int[] output = new int[firstArray.length + secondArray.length];
		output = obj.join(firstArray,firstArray.length, secondArray,
						  secondArray.length, output);
		int[] expected = {1, 2, 3, 4, 6, 7, 8, 10};
		assertArrayEquals(expected, output);
	}
	
	/**
	 * Checks join function 
	 * Input : firstArray => {10, 8, 6, 3, 1}
	 * 		   secondArray => {10, 7, 4, 2}
	 * 		   firstArray.length => 5
	 *         secondArray.length => 4
	 *         output
	 * Expected Output : {1, 2, 3, 4, 6, 7, 8, 10}
	 * Test Status : Pass
	 */
	@Test
	public void TestDescOrderArraysPass() {
		MergeArray obj = new MergeArray();
		int[] firstArray = {10, 8, 6, 3, 1};
		int[] secondArray = {10, 7, 4, 2};
		int[] output = new int[firstArray.length + secondArray.length];
		output = obj.join(firstArray,firstArray.length, secondArray,
						  secondArray.length, output);
		int[] expected = {1, 2, 3, 4, 6, 7, 8, 10, 10};
		assertArrayEquals(expected, output);
	}
	
	/**
	 * Checks join function 
	 * Input : firstArray => {10, 8, 6, 3, 1}
	 * 		   secondArray => {10, 7, 4, 2}
	 * 		   firstArray.length => 5
	 *         secondArray.length => 4
	 *         output
	 * Expected Output : {1, 2, 4, 6, 7, 8, 10, 10}
	 * Test Status : Fail
	 */
	@Test
	public void TestDescOrderArraysFail() {
		MergeArray obj = new MergeArray();
		int[] firstArray = {10, 8, 6, 3, 1};
		int[] secondArray = {10, 7, 4, 2};
		int[] output = new int[firstArray.length + secondArray.length];
		output = obj.join(firstArray, firstArray.length, secondArray, 
						  secondArray.length,output);
		int[] expected = {1, 2, 4, 6, 7, 8, 10, 10};
		assertArrayEquals(expected, output);
	}
	
	/**
	 * Checks join function 
	 * Input : firstArray => {1, 3, 6, 8, 10}
	 * 		   secondArray => {10, 7, 4, 2}
	 * 		   firstArray.length => 5
	 *         secondArray.length => 4
	 *         output
	 * Expected Output : {1, 2, 3, 4, 6, 7, 8, 10, 10}
	 * Test Status : Pass
	 */
	@Test
	public void TestDiffOrderArraysPass() {
		MergeArray obj = new MergeArray();
		int[] firstArray = {1, 3, 6, 8, 10};
		int[] secondArray = {10, 7, 4, 2};
		int[] output = new int[firstArray.length + secondArray.length];
		output = obj.join(firstArray, firstArray.length, secondArray, 
						  secondArray.length,output);
		int[] expected = {1, 2, 3, 4, 6, 7, 8, 10, 10};
		assertArrayEquals(expected, output);
	}	
	
	/**
	 * Checks join function 
	 * Input : firstArray => {1, 3, 6, 8, 10}
	 * 		   secondArray => {10, 7, 4, 2}
	 * 		   firstArray.length => 5
	 *         secondArray.length => 4
	 *         output
	 * Expected Output : {1, 2, 3, 4, 6, 7, 8, 8, 10}
	 * Test Status : Fail
	 */
	@Test
	public void TestDiffOrderArraysFail() {
		MergeArray obj = new MergeArray();
		int[] firstArray = {1, 3, 6, 8, 10};
		int[] secondArray = {10, 7, 4, 2};
		int[] output = new int[firstArray.length + secondArray.length];
		output = obj.join(firstArray, firstArray.length, secondArray, 
						  secondArray.length,output);
		int[] expected = {1, 2, 3, 4, 6, 7, 8, 8, 10};
		assertArrayEquals(expected, output);
	}
	
	/**
	 * Checks checkSortedOrder function 
	 * Input : {7, 56, 65, 74, 82, 91}
	 * Expected Output : 1
	 * Test Status : Pass
	 */
	@Test
	public void TestAscPass() {
		MergeArray sort = new MergeArray();
		int[] input = {7, 56, 65, 74, 82, 91};
		int output = sort.checkSortedOrder(input);
		int expected = 1;
		assertEquals(expected, output);
	}
	
	/**
	 * Checks checkSortedOrder function 
	 * Input : {7, 56, 65, 74, 82, 91}
	 * Expected Output : 2
	 * Test Status : Fail
	 */
	@Test
	public void TestAscFail() {
		MergeArray sort = new MergeArray();
		int[] input = {7, 56, 65, 74, 82, 91};
		int output = sort.checkSortedOrder(input);
		int expected = 2;
		assertEquals(expected, output);
	}
	
	/**
	 * Checks checkSortedOrder function 
	 * Input : {100, 90, 80, 70, 56, 45, 23}
	 * Expected Output : 2
	 * Test Status : Pass
	 */
	@Test
	public void TestDescPass() {
		MergeArray sort = new MergeArray();
		int[] input = {100, 90, 80, 70, 56, 45, 23};
		int output = sort.checkSortedOrder(input);
		int expected = 2;
		assertEquals(expected, output);
	}
	
	/**
	 * Checks checkSortedOrder function 
	 * Input : {100, 90, 80, 70, 56, 45, 23}
	 * Expected Output : 2
	 * Test Status : Pass
	 */
	@Test
	public void TestDescFail() {
		MergeArray sort = new MergeArray();
		int[] input = {100, 90, 80, 70, 56, 45, 23};
		int output = sort.checkSortedOrder(input);
		int expected = 1;
		assertEquals(expected, output);
	}
	
	/**
	 * Checks checkSortedOrder function 
	 * Input : {100, 90, 80, 70, 71, 45, 23}
	 * Expected Output : 0
	 * Test Status : Pass
	 */
	@Test
	public void TestNoOrderPass() {
		MergeArray sort = new MergeArray();
		int[] input = {100, 90, 80, 70, 71, 45, 23};
		int output = sort.checkSortedOrder(input);
		int expected = 0;
		assertEquals(expected, output);
	}
	
	/**
	 * Checks checkSortedOrder function 
	 * Input : {100, 90, 80, 70, 71, 45, 23}
	 * Expected Output : 2
	 * Test Status : Fail
	 */
	@Test
	public void TestNoOrderFail() {
		MergeArray sort = new MergeArray();
		int[] input = {100, 90, 80, 70, 71, 45, 23};
		int output = sort.checkSortedOrder(input);
		int expected = 2;
		assertEquals(expected, output);
	}
}
