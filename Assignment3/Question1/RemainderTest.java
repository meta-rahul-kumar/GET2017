/**
 * Junit Test Class for rem method of Remainder Class
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class RemainderTest {
	@Test
	public void remainderTesting() {
		Remainder remainderFinder = new Remainder();
		int output = remainderFinder.rem(-5, 2);
		int expected = -1;
		assertEquals(expected, output); // True Case 
		output = remainderFinder.rem(-5, 2);
		expected = 1;
		assertNotEquals(expected, output); // False case
		output = remainderFinder.rem(5, 2);
		expected = 1;
		assertEquals(expected, output); // True Case 
		output = remainderFinder.rem(5, 2);
		expected = -1;
		assertNotEquals(expected, output); // False case
		output = remainderFinder.rem(-5, -2);
		expected = -1; 
		assertEquals(expected, output); // True Case 
		output = remainderFinder.rem(-5, -2);
		expected = 1;
		assertNotEquals(expected, output); // False case
		output = remainderFinder.rem(5, -2);
		expected = 1;
		assertEquals(expected, output); // True Case 
		output = remainderFinder.rem(5, -2);
		expected = -1;
		assertNotEquals(expected, output); // False case
	}
}
