/**
 * Junit Test Class for gcd method of Gcd Class
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question1;

import org.junit.Test;
import static org.junit.Assert.*;

public class GcdTest {
	
	/*
	 * test gcd method of class Gcd
	 */
	@Test
	public void GcdTesting() {
		Gcd gcdFinder = new Gcd();
		int output = gcdFinder.gcd(-30, 15);
		int expected = 15;
		assertEquals(expected, output); // True Case 
		output = gcdFinder.gcd(6, 7);
		expected = 6;
		assertNotEquals(expected, output); // False case
		output = gcdFinder.gcd(-30, -60);
		expected = 30;
		assertEquals(expected, output); // True case
	}
}
