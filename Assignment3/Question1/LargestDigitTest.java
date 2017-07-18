/**
 * Junit Test Class for largestDigit method of LargestDigit Class
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class LargestDigitTest {
	
	@Test
	public void largestDigitTesting() {
		LargestDigit digitFinder = new LargestDigit();
		int output = digitFinder.largestDigit(12345);
		int expected = 5;
		assertEquals(expected, output); // True Case  
		
		output = digitFinder.largestDigit(-300023);
		expected = 6;
		assertNotEquals(expected, output); // False case
		
		output = digitFinder.largestDigit(1257369);
		expected = 9;
		assertEquals(expected, output); // True case
		
		output = digitFinder.largestDigit(444);
		expected = 4;
		assertEquals(expected, output); // True case
		
		output = digitFinder.largestDigit(2);
		expected = 0;
		assertNotEquals(expected, output); // True case
		
		output = digitFinder.largestDigit(4093545);
		expected = 9;
		assertEquals(expected, output); // True case
	}
}
