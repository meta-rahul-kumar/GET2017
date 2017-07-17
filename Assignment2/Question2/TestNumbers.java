/*
 * Class checks the numbers method of Pyramid class for different cases
 */

package Question2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestNumbers {

	Pyramid PyramidTest = new Pyramid();
	String output;
   
	@Test
	public void testNumbersTrue() {	
		int row = 5;
		int n = 5;
		output = PyramidTest.numbers(row, n);   
		String expected = "12345";
		assertEquals(expected, output);     // True case
		row = 2;
		n = 5;
		output = PyramidTest.numbers(row, n);   // False Case
		expected = "432";
		assertNotEquals(expected, output);  
	 }
}
